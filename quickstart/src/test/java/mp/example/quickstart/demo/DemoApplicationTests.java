package mp.example.quickstart.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mp.example.quickstart.demo.domain.User;
import mp.example.quickstart.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println("begain to test");
        List<User> users = userMapper.selectList(new QueryWrapper<User>());
        Assert.assertEquals(5,users.size());//断言 ，错误抛异常
        users.forEach(System.out ::println );

    }

    //测试分页组件
    @Test
    public void testPagination(){

        Page<User> page = new Page<User>(1,3);
        userMapper.selectPage(page, null);
        Assert.assertTrue("total should not be 0",page.getTotal() != 0);
        page.getRecords().forEach(System.out ::println);

    }

    //测试自定义sql语句
    @Test
    public void testCustomedSql(){

        System.out.printf("查询年龄的最大值" + userMapper.getMaxAge());
    }

    //测试sequence ,添加数据，添加后回显id值
    //在oracle中sequence就是序号，每次取的时候它会自动增加。sequence与表没有关系。
    @Test
    public void testSequence(){
        User u = new User();
        u.setId(13L);
        u.setName("Tomcat");
        u.setAge(18);
        u.setEmail("kellylake@qq.com");
        userMapper.insert(u);
        Long id = u.getId(); //回显id 和page一样
        System.out.println("id为：" + id);
        u.setName("TOMcat");
       // userMapper.insert(u);
        System.out.println("第二次id为" + u.getId());



    }



}
