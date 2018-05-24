package dao;

import model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ICountryDao")
public interface ICountryDao {
//    int insert(Country record);
//
//    int insertSelective(Country record);
    void UpdateVisitorCount(String country_id);
    void UpdateDownloadCount(String country_id);
    List<Country> GetVisitAndDownload();
}