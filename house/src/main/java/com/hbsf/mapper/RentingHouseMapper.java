package com.hbsf.mapper;


import com.hbsf.pojo.RentingHouse;
import com.hbsf.pojo.RentingHouseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentingHouseMapper {
    int countByExample(RentingHouseExample example);

    int deleteByExample(RentingHouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentingHouse record);

    int insertSelective(RentingHouse record);

    List<RentingHouse> selectByExample(RentingHouseExample example);

    RentingHouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByExample(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByPrimaryKeySelective(RentingHouse record);

    int updateByPrimaryKey(RentingHouse record);

    List<RentingHouse> selectBySelect(RentingHouse rentingHouse);

    int deleteByEnos(String enos);
}