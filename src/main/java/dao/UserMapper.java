package dao;

import model.User;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into product_user(username,password,email)" +
            " value(#{userName},#{passWord},#{email})")
    void saveUser(@Param("userName") String userName,
                  @Param("passWord") String passWord,
                  @Param("email") String email);

    @Delete("delete from product_user where email = #{email}")
    int deleteByEmail(@Param("email") String email);
}
