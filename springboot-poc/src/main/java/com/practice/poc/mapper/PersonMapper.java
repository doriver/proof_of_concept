package com.practice.poc.mapper;

import com.practice.poc.dto.mybatis.UserM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<UserM> findAll();
}
