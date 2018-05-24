package service;

import model.Country;

import java.util.List;

public interface ICountryService {
    public void UpdateVisitorCount(String country_id);
    public void UpdateDownloadCount(String country_id);
    public List<Country> GetVisitAndDownload();
}
