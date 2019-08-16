import redis.clients.jedis.Jedis;
import junit.framework.TestCase;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/8/15
 * Time: 23:20
 */

public class testTest extends TestCase{
    //模仿了一个客户端
    Jedis client =new Jedis();
//    public void testLpush(){
//        Long len=client.lpush("key","value");
//        System.out.println(len);
//    }

    public void testRead(){
        long start=System.nanoTime();
        for (int i = 0; i <1000 ; i++) {
            client.lpush("for","2");
            client.lrange("for",0,-1);
        }
        long end=System.nanoTime();
        System.out.println(end-start);
    }

    public void lrange(){
//        List<String> list1=client.lrange("for",0,-1);
//        System.out.println(list1);
        List<String> list2=client.lrange("for",0,-2);
        System.out.println(list2);
//        List<String> list3=client.lrange("for",0,1);
//        System.out.println(list3);
//        List<String> list4=client.lrange("for",0,2);
//        System.out.println(list4);
//        List<String> list5=client.lrange("for",0,3);
//        System.out.println(list5);
//        List<String> list6=client.lrange("for",0,-3);
//        System.out.println(list6);
    }


}
