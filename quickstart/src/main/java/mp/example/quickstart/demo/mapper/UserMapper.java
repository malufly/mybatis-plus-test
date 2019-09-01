package mp.example.quickstart.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mp.example.quickstart.demo.domain.User;

public interface UserMapper extends BaseMapper<User> {

    Integer getMaxAge();
}
