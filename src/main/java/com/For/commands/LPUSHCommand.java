package com.For.commands;

import com.For.Command;
import com.For.Database;
import com.For.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Time: 19:01
 */
public class LPUSHCommand implements Command {

    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args=args;
    }

    @Override
    public void run(OutputStream os) throws IOException {

        if (args.size()!=2){
            Protocol.writeError(os,"元素个数应为2个");
            return;
        }

        String key = new String((byte[])args.get(0));
        String value=new String((byte[])args.get(1));
        List<String> list = Database.getList(key);
        list.add(0,value);
        Protocol.writeInteger(os,list.size());
    }
}
