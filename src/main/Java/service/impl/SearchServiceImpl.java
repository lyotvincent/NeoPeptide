package service.impl;

import dao.ICancerDao;
import model.Disease_Cancer;
import org.springframework.stereotype.Service;
import service.ISearchService;

import javax.annotation.Resource;
import java.util.List;

@Service("CancerService")
public class SearchServiceImpl implements ISearchService
{
    @Resource
    private ICancerDao  CancerDao;
    public List<Disease_Cancer> Search_Disease_CancerByKey(String strKey)
    {
        return this.CancerDao.Cancer_SelectByKey(strKey);
    }
    public Disease_Cancer Search_Disease_CancerByNo(Long lno)
    {
        return  this.CancerDao.Cancer_SelectByNo(lno);
    }

    public List<Disease_Cancer> Search_Disease_CancerBySql(String strSql)
    {
        return  this.CancerDao.Cancer_SelectBySql(strSql);
    }
}
