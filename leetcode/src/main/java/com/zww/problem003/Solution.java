package com.zww.problem003;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title Solution
 * @description: 无重复字符的最长子串
 * @author: zhaoww
 * @create: 2019/05/20
 */
public class Solution {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */

    private static String S = "pwwkew";

    /**
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        for (AtomicInteger i = new AtomicInteger(0); i.get() < s.length(); i.getAndIncrement()) {
            sb.chars().boxed().filter(c -> c.equals(s.charAt(i.get()))).findAny().ifPresent(c -> sb.append(c));


        }
        return 0;
    }

    public static void main(String[] args){
        lengthOfLongestSubstring(S);
    }
}
