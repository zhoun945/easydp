package com.freedom.easydp.support.tree;

import java.util.List;

/**
 * 树形节点接口
 *
 * @author nan.zhou
 * @date 2018-06-15
 */
public interface TreeNode<I> {

  /**
   * 返回当前节点 id
   *
   * @return
   */
  I getNodeId();

  /**
   * 返回上级节点 pid
   *
   * @return
   */
  I getNodePid();

  /**
   * 设置子节点
   *
   * @param children
   */
  void setChildren(List<TreeNode<I>> children);

  /**
   * id 判断相等
   *
   * @param id1
   * @param id2
   * @return
   */
  boolean idEquals(I id1, I id2);


}
