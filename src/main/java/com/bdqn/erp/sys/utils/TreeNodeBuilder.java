package com.bdqn.erp.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建节点层级关系
 */
public class TreeNodeBuilder {


    /**
     * 创建节点层级关系
     * @param treeNodes     节点对象集合
     * @param topPid        父节点
     * @return
     */
    public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topPid){
        List<TreeNode> nodes=new ArrayList<TreeNode>();
        //循环遍历节点集合
        for (TreeNode n1 : treeNodes) {
            //如果当前节点为根节点，则将当前节点添加到节点数组中
            if(n1.getPid()==topPid) {
                nodes.add(n1);
            }
            //如果当前子节点对应的节点相等，则添加到子节点集合中
            for (TreeNode n2 : treeNodes) {
                if(n1.getId()==n2.getPid()) {
                    n1.getChildren().add(n2);
                }
            }
        }

        return nodes;
    }

}
