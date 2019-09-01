package mp.example.quickstart.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//@KeySequence("SEQ_USER") //CREATE SEQUENCE IF NOT EXISTS SEQ_USER START WITH 10086 INCREMENT BY 1; ORACLE 有效
@Data
public class User {
    @TableId(value = "id",type = IdType.INPUT) //AUTO 必须在设计表的时候有默认值，没有不可用，只能用KEY 序列增长 类 @KeySequence
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
