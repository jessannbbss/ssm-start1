import com.seecen.dao.UserMapper;
import com.seecen.entity.Page;
import com.seecen.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jessann on 2018/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void page(){
        Page page = new Page();
        page.setPageSize(2);
        User user = new User();
        user.setUserName("%a%");
        List<User> list = userMapper.findUserByPage(user,page);
        int total = userMapper.countUserByPage(user);
        Assert.assertTrue("找不到带有a字母的用户",list.size()>0);
    }
}
