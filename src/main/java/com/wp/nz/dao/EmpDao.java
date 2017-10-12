package com.wp.nz.dao;

import com.wp.nz.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao {

    int deleteByPrimaryKey(String id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}