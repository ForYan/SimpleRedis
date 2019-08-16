package com.For;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/8/5
 * Time: 19:21
 */
public class Database {

    private static Database instance=new Database();
    public static Database getInstance(){
        return instance;
    }

    //hash类型
    private static Map<String,Map<String,String>> hashes=new HashMap<>();
    //list
    private static Map<String,List<String>>  lists=new HashMap<>();

    public static Map<String,String> getHashes(String key){
        Map<String,String> hash=hashes.get(key);
        if (hash==null){
            hash=new HashMap<>();
            hashes.put(key,hash);
        }
        return hash;
    }

    public static List<String> getList(String key){
        List<String> list=lists.get(key);
        //保证list一定有内容
        if (list==null){
            list=new ArrayList<>();
            lists.put(key,list);
        }
        return list;
    }
}
