package service.impl;

import dao.ICountryDao;
import model.Country;
import org.springframework.stereotype.Service;
import service.ICountryService;

import javax.annotation.Resource;
import java.util.List;

@Service("CountryService")
public class CountryServiceImpl implements ICountryService{
    @Resource
    private ICountryDao CountryDao;
    public void UpdateVisitorCount(String country_id){
        CountryDao.UpdateVisitorCount(country_id);
    }
    public void UpdateDownloadCount(String country_id){
        CountryDao.UpdateDownloadCount(country_id);
    }

    public List<Country> GetVisitAndDownload(){
        return CountryDao.GetVisitAndDownload();
    }
}
