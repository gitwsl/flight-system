package com.wsl;

import com.alibaba.fastjson.JSON;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class FlightProviderUserApplicationTests {


    /***
     *
     * 第一行由字符 "qwertyuiop" 组成。
     * 第二行由字符 "asdfghjkl" 组成。
     * 第三行由字符 "zxcvbnm" 组成。
     */
    @Test
    void contextLoads() {
//        LinkedHashSet<String> set = new LinkedHashSet<>();
//        set.add("a");
//        set.add("ba");
//        set.add("a");
//        set.add("f");
//        set.add("c");
//        set.add("d");
//        System.out.println(set);
//        String wordsRule[] = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
//        String words[] = {"Hello","Alaska","Dad","Peace"};
//        System.out.println(JSON.toJSONString(findWords(words)));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList();
        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                for(int k = j + 1; k < nums.length; k ++){
                    if(i != j && j != k && i != k
                            && nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        resultList.addAll(Collections.singleton(list));
                    }
                }
            }
        }
        return resultList;
    }
    public static String[] findWords(String[] words) {
        if (words == null || words.length < 0) {
            return new String[]{};
        }
        String wordsRule[] = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> returnWords = new ArrayList<>();
        for (String word : words) {
            for (String wordrule : wordsRule) {
                if(returnWords.contains(word)){
                    break;
                }
                int i = 0;
                while (word.length() != i +1 && wordrule.contains(String.valueOf(word.charAt(i)).toLowerCase()) &&
                        wordrule.contains(String.valueOf(word.charAt(i + 1)).toLowerCase())) {
                    i++;
                }
                if(word.length() == i + 1){
                    returnWords.add(word);
                }
            }
        }
        return returnWords.toArray(new String[returnWords.size()]);
    }

}
