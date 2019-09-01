package com.For.commands;

import com.For.Command;
import com.For.Database;
import com.For.Protocol;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Time: 14:41
 */
public class HSETCommand implements Command {

    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args=args;
    }

    @Override
    public void run(OutputStream os) throws Exception {
        if (args.size()!=3){
            throw new Exception("字段参数应为4个");
        }
        //由四个字段组成：Hset  Key  Field Value
        String key=new String((byte[]) args.get(0));
        String field=new String((byte[])args.get(1));
        String value=new String((byte[])args.get(2));

        Map<String,String> hash=Database.getHashes(key);
        //0表示更新，1表示插入
        boolean isUpdate=hash.containsKey(field);
        hash.put(field,value);
        if (isUpdate){
            Protocol.writeInteger(os,0);
        }else{
            Protocol.writeInteger(os,1);
        }
    }
}
