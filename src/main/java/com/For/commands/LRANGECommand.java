package com.For.commands;

import com.For.Command;
import com.For.Database;
import com.For.Protocol;

import java.io.OutputStream;
import java.util.List;
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Time: 16:06
 */
public class LRANGECommand implements Command {
    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args=args;
    }

    @Override
    public void run(OutputStream os) throws Exception {
        String key=new String((byte[])args.get(0));
        int start=Integer.parseInt(new String((byte[]) args.get(1)));
        int stop=Integer.parseInt(new String((byte[]) args.get(2)));
        List<String> list=Database.getList(key);
        if (stop<0){
            stop=list.size()+stop;
        }
        List<String> result=list.subList(start,stop+1);
        Protocol.writeArray(os,result);
    }
}
