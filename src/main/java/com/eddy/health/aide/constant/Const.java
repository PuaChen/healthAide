package com.eddy.health.aide.constant;

/**
 * @Author PuaChen
 * @Create 2018-11-28 16:32
 */
public interface Const {
    String SESSION_USER_KEY = "UserKey";

    /**
     * 参数带的Token
     */
    String PARAMS_TOKEN_KEY = "assess";

    interface Illness {
        /**
         * 脑血管
         */
        String NXG = "脑血管";

        /**
         * 心脏病
         */
        String XZB = "心脏病";

        /**
         * 痛风
         */
        String TF = "痛风";

        /**
         * 肺病
         */
        String FB = "肺病";

        /**
         * 正常
         */
        String NORMAL = "正常";
    }
}
