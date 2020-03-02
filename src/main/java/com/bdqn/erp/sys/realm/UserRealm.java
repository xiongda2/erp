package com.bdqn.erp.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdqn.erp.sys.entity.Permission;
import com.bdqn.erp.sys.entity.User;
import com.bdqn.erp.sys.service.PermissionService;
import com.bdqn.erp.sys.service.RoleService;
import com.bdqn.erp.sys.service.UserService;
import com.bdqn.erp.sys.utils.SystemConstant;
import com.bdqn.erp.sys.vo.LoginUserVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;


    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取当前登录主体
        LoginUserVo userVo = (LoginUserVo) principals.getPrimaryPrincipal();
        simpleAuthorizationInfo.setRoles(userVo.getRoles());
        //获取当前用户登录权限
        Set<String> permissions = userVo.getPermissions();
        //判断当前登录用户是否是管理员
        if (userVo.getUser().getType() == SystemConstant.SUPERUSER) {
            //是超级管理员,拥有所有权限
            QueryWrapper<Permission> wq = new QueryWrapper<Permission>();
            wq.eq("type", SystemConstant.TYPE_PERMISSION);
            List<Permission> list = permissionService.list(wq);
            //创建集合，保存权限编码
            Set<String> percodes = new HashSet<String>();
            //循环获取每一个权限编码
            for (Permission permission : list){
                percodes.add(permission.getPercode());
            }
            simpleAuthorizationInfo.addStringPermissions(percodes);
        } else {
            if (permissions != null && permissions.size() > 0) {
                //获取数据库中的权限编码
                simpleAuthorizationInfo.addStringPermissions(permissions);
            }
        }

        return simpleAuthorizationInfo;
    }


    /**
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取当前登录主体
        String userName = (String) token.getPrincipal();
        try {
            //根据用户名查询用户信息的方法
            User user = userService.findUserByName(userName);
            //对象不为空
            if (user != null) {
                //创建当前登录用户对象
                LoginUserVo loginUserVo = new LoginUserVo();
                loginUserVo.setUser(user);
                QueryWrapper<Permission> qw = new QueryWrapper<Permission>();
                qw.eq("type", SystemConstant.TYPE_PERMISSION);
                //根据当前用户id获取该用户的角色id
                Set<Integer> currentUserRoleIds = userService.findUserRoleByUserId(user.getId());
                //设置角色id
                Set< String >  roles =
                        currentUserRoleIds.stream().map(e -> String.valueOf(e)).collect(Collectors.toSet());
                loginUserVo.setRoles(roles);
                //创建set集合保存菜单
                Set<Integer> pids = new HashSet<Integer>();
                //循环遍历角色id集合取出每一个角色编号关联菜单和权限
                for (Integer c : currentUserRoleIds) {
                    Set<Integer> permissions = roleService.findRolePermissionIdByRoleId(c);
                    pids.addAll(permissions);
                }
                //创建集合保存权限对象
                List<Permission> list = new ArrayList<Permission>();
                //判断权限集合是否有数据
                if (pids.size() > 0) {
                    qw.in("id", pids);
                    list = permissionService.list(qw);
                }
                //创建集合，保存权限编码
                Set<String> percodes = new HashSet<String>();
                //循环获取每一个权限编码
                for (Permission permission : list){
                    percodes.add(permission.getPercode());
                }
                //设置权限编码集合
                loginUserVo.setPermissions(percodes);

                //创建盐值(以用户名作为盐值)
                ByteSource salt = ByteSource.Util.bytes(user.getSalt());
                //创建身份验证对象
                //参数1：当前登录对象  参数2：密码  参数3：盐值 参数4：域名
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginUserVo, user.getLoginpwd(), salt, getName());
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //验证失败
        return null;
    }
}


