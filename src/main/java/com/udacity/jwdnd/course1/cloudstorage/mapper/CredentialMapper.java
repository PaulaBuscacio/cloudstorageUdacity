package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {


    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    List<Credential> listCredentials(Integer userId);

        @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    Credential getCredentialById(Integer credentialId);


    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) " +
            "VALUES(#{url}, #{username}, #{key}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    Integer insert(Credential credential);


    @Update("UPDATE CREDENTIALS SET url=#{credential.url}, username=#{credential.username}, key=#{credential.key}, password=#{credential.password} " +
            "WHERE credentialId = #{credential.credentialId}")
    void update(@Param("credential") Credential credential);


    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    void delete (Integer credentialId);
}