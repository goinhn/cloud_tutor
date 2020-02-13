package com.goinhn.mini.dao;

import com.goinhn.mini.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

//@CacheNamespace(blocking = true)  开启二级缓存
public interface UserDao {

    @Select("select * from tab_user")
    @Results(id = "userMap",
            value = {
                    @Result(id = true, column = "userId", property = "userId"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "sex", property = "sex"),
                    @Result(column = "telephone", property = "telephone"),
                    @Result(column = "email", property = "email"),
                    @Result(column = "type", property = "type"),
                    @Result(column = "status", property = "status"),
                    @Result(column = "code", property = "code")
            })
    List<User> findAll();


    @Select("select * from tab_user where userId = #{userId}")
    @ResultMap("userMap")
    User findByUserId(Integer userId);


    @Select("select * from tab_user where username = #{username}")
    @ResultMap("userMap")
    User findByUsername(String username);


    @Select("select * from tab_user where username = #{username} and password = #{password}")
    @ResultMap("userMap")
    User findByUsernameAndPassword(HashMap hashMap);


    @Select("select * from tab_user where code = #{code}")
    @ResultMap("userMap")
    User findByCode(String code);


    @Select("select * from tab_user where name like #{name}")
    @ResultMap("userMap")
    List<User> findByName(String name);


    @Select("select count(*) from tab_user")
    int findTotal();


    @Insert("insert into tab_user(username, password, name, birthday, sex, telephone, email, type, status, code) " +
            "values(#{username}, #{password}, #{name}, #{birthday}, #{sex}, #{telephone}, #{emial}, #{type}, #{status}, #{code})")
    @SelectKey(keyColumn="userId", keyProperty = "userId", resultType = Integer.class, before = false, statement = {"select last_insert_id()"})
    int saveUser(User user);


    @Update("update tab_user set " +
            "username = #{username}, password = #{password}, name = #[name}, birthday = #{birthday}, sex = #{sex}, telephone = #{telephone}, email = #{email}, type = #{type}, status = #{status}, code = #{code}" +
            "where userId = #{userId}")
    int updateUser(User user);


    @Update("update tab_user set status = #{status} where userId = #{userId}")
    int updateStatus(User user);


    @Delete("delete from tab_user where userId = #{userId}")
    int deleteUser(User user);

}
