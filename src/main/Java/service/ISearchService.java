package service;

import model.Disease_Cancer;

import java.util.List;

public interface ISearchService {
    public List<Disease_Cancer> Search_Disease_CancerByKey(String strKey);
    public Disease_Cancer Search_Disease_CancerByNo(Long lno);
    public List<Disease_Cancer> Search_Disease_CancerBySql(String strSql);
}
