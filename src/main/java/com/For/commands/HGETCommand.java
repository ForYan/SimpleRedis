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
 * Time: 16:30
 */
public class HGETCommand implements Command {

    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args=args;
    }

    @Override
    public void run(OutputStream os) throws Exception {

        if(args.size()!=2){
            throw  new Exception("参数字段应为3个");
        }

        //HGet  Key  Field
        String key=new String((byte[])args.get(0));
        String field=new String((byte[])args.get(1));
        Map<String,String> hash=Database.getHashes(key);
        String value=hash.get(field);
        if (value!=null){
            Protocol.writeBulking(os,value);
        }else{
            Protocol.writeNull(os);
        }
    }
}
