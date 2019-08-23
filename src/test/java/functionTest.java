import junit.framework.TestCase;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class functionTest extends TestCase {

    Jedis client=new Jedis(  );

    //测试lpush方法，插入成功返回该键对应的list大小
    public void testLPUSH(){
//          Long  size=client.lpush( "key","value");
//          System.out.println(size);
           long size=0;
          for(int i=0;i<5;i++ ){
           size=client.lpush( "key",String.valueOf( i ) );
          }


    //输入参数个数不正确抛出JedisDataException异常信息
    //        Long  size=client.lpush( "key")；
    //        System.out.println(size);

    //输入参数类型不正确抛出找不到方法异常信息
    //        Long  size=client.lpush( "key",1)；
    //        System.out.println(size);
    }

    //测试LRANGE方法，成功返回该键对应的List<String>内容（在上一步已经插入了五个数据）
    public void testLRANGE(){
        List<String> list1=client.lrange( "key",0,0); //取一个数据
        System.out.println(list1);
        List<String> list6=client.lrange( "key",0,2); //取一个数据
        System.out.println(list6);
        List<String> list2=client.lrange( "key",0,4); //取全部数据
        System.out.println(list2);
        List<String> list3=client.lrange( "key",0,10); //取数据范围超过list集合大小
        System.out.println(list3);
        List<String> list4=client.lrange( "key",-1,-4); //-代表从后往前
        System.out.println(list4);
        List<String> list5=client.lrange( "key",5,10); //取范围不在list长度范围内
        System.out.println(list5);
    }
    //测试hset方法，插入成功返回该键对应的hashMap<String>大小，失败返回未插入之前的hashMap<String>大小
    public void testHSET(){
//        long size=0;
//        for (int i=0;i<5;i++){
//            size=client.hset("key","field"+String.valueOf(i),String.valueOf(i));
//        }
//        System.out.println(size);
        long size=0;
        size=client.hset("key","field","value");
        System.out.println(size);
    }
    //测试hget方法，成功返回String，查询不到返回空
    public void testHGET(){
        String str1= client.hget( "key","field0" );
        System.out.println(str1);
        String str2= client.hget( "key","field1" );
        System.out.println(str2);
        String str3= client.hget( "key","field2" );
        System.out.println(str3);
        String str4= client.hget( "key","field3" );
        System.out.println(str4);
        String str5= client.hget( "key","field4" );
        System.out.println(str5);

        String str= client.hget( "key","field4" );
        System.out.println(str);
    }
}
