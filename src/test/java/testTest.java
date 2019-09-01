import redis.clients.jedis.Jedis;
import junit.framework.TestCase;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Time: 23:20
 */

public class testTest extends TestCase{
    Jedis client =new Jedis();
//    public void testLpush(){
//        for (int i = 0; i <10000 ; i++) {
//            client.lpush("for","2");
//        }
//        client.lrange("for",0,-1);
//    }
    //对lpush和lrange的命令的读写速度进行测试
    public void testRead(){
        long start=System.nanoTime();
        for (int i = 0; i <50000 ; i++) {
            client.lpush("for","2");
        }
        long middle=System.nanoTime();
        System.out.println(middle-start);
        List<String> list1=client.lrange("for",0,-1);
        long end=System.nanoTime();
        System.out.println(end-middle);
    }
}
