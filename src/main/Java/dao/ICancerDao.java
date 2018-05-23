package dao;

import model.Disease_Cancer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ICancerDao")
public interface ICancerDao
{
//    int deleteByPrimaryKey(Long no);
//
//    int insert(Disease_Cancer record);
//
//    int insertSelective(Disease_Cancer record);
//
//    Disease_Cancer selectByPrimaryKey(Long no);
//
//    int updateByPrimaryKeySelective(Disease_Cancer record);
//
//    int updateByPrimaryKey(Disease_Cancer record);

    List<Disease_Cancer> Cancer_SelectByKey(String strKey);
    Disease_Cancer Cancer_SelectByNo(java.lang.Long lno);
    List<Disease_Cancer> Cancer_SelectBySql(String strSql);
}