package com.shuyan.demo2_post;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayTest {
    public static void main(String[] args) {
        Map<String, Object> item = new HashMap<>();
        item.put("a", 1);
        item.put("b", 2);
        Map<String, Object> item1 = new HashMap<>();
        item1.put("a", 3);
        item1.put("b", 4);
        List<Object> list = new ArrayList<>();

        list.add(item);
        list.add(item1);

        Map<String, Object> map = new HashMap<>();
        map.put("data", list);

        String str = JSON.toJSONString(map);

        JSONObject jsonObject = JSONObject.parseObject(str);
        List rList = (List) jsonObject.get("data");

        for (Object it: rList) {
            Map it2 = (Map) it;
            System.out.println(it2.get("a"));

        }
    }
}