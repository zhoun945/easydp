package com.freedom.easydp.support;

import com.freedom.easydp.entity.UserEntity;

/**
 * 当前线程用户副本
 *
 * 每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本
 * 当线程结束后，对应该线程的局部变量将自动被垃圾回收（为了避免内存泄漏 也应该及时回收）
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
public class UserThreadLocal {

  private static final ThreadLocal<UserEntity> userThreadLocal = new ThreadLocal();

  public static UserEntity getUser() {
    try {
      UserEntity user = userThreadLocal.get();
      if (user == null) {
        user = new UserEntity();
        user.setId(0L);
        user.setUsername("default");
        user.setNickname("默认用户");
      }
      return user;
    } catch (Exception e) {
      userThreadLocal.remove();
    }
    return null;
  }

  public static void setUser(UserEntity user) {
    try {
      userThreadLocal.set(user);
    } catch (Exception e) {
      userThreadLocal.remove();
    }
  }

}
