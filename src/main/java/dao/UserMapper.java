package dao;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from product_user where id = #{Id}")
    @Results(
            value = {
                    @Result(column = "Id", property = "userId"),
                    @Result(column = "username", property = "userName"),
                    @Result(column = "password", property = "passWord"),
                    @Result(column = "email", property = "email")
            }
    )
    User selectById(@Param("Id") int id);

}
