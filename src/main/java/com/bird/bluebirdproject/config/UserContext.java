package com.bird.bluebirdproject.config;

/**
 * 用户上下文类
 * @author lenovo
 */
public class UserContext {

    private static final ThreadLocal<Integer> userHolder = new ThreadLocal<>();

    /**
     * 设置当前线程的用户ID
     * @param userId 用户ID
     */
    public static void setUserId(Integer userId) {
        userHolder.set(userId);
    }

    /**
     * 获取当前线程的用户ID
     * @return 当前用户ID，如果未设置则返回null
     */
    public static Integer getUserId() {
        return userHolder.get();
    }

    /**
     * 清除当前线程的用户ID
     */
    public static void clear() {
        userHolder.remove();
    }
}
