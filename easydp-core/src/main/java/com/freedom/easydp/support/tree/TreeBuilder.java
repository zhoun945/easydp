package com.freedom.easydp.support.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeBuilder
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
public class TreeBuilder<T extends TreeNode<I>, I> {

  private List<TreeNode<I>> nodeList;
  private I rootId;

  public TreeBuilder(List<TreeNode<I>> nodeList, I rootId) {
    this.nodeList = nodeList;
    this.rootId = rootId;
  }

  public List<TreeNode<I>> build() {
    List<TreeNode<I>> rootNodeList = findRootNodeList();
    for (TreeNode<I> rootNode : rootNodeList) {
      buildChildNode(rootNode);
    }
    return rootNodeList;
  }

  public void buildChildNode(TreeNode<I> treeNode) {
    List<TreeNode<I>> childNodeList = findChildNodeList(treeNode.getId());
    if (!childNodeList.isEmpty()) {
      for (TreeNode<I> childNode : childNodeList) {
        buildChildNode(childNode);
      }
    }
    treeNode.setChildren(childNodeList);
  }

  private List<TreeNode<I>> findRootNodeList() {
    List<TreeNode<I>> rootNodeList = new ArrayList<>();
    for (TreeNode<I> treeNode : nodeList) {
      if (treeNode.idEquals(treeNode.getPid(), rootId)) {
        rootNodeList.add(treeNode);
      }
    }
    return rootNodeList;
  }

  private List<TreeNode<I>> findChildNodeList(I pid) {
    List<TreeNode<I>> childNodeList = new ArrayList<>();
    for (TreeNode<I> treeNode : nodeList) {
      if (treeNode.idEquals(treeNode.getPid(), pid)) {
        childNodeList.add(treeNode);
      }
    }
    return childNodeList;
  }

}
