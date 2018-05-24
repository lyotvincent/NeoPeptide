package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ICountryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Country")
public class CountryController {
    @Resource
    private ICountryService CountryService;
    @ResponseBody
    @RequestMapping(value = "/GetVisitAndDownload.do",method = RequestMethod.POST)
    public Object GetVisitAndDownload(HttpServletRequest request) throws IOException {
        List<Country> CountryData = this.CountryService.GetVisitAndDownload();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(CountryData);
    }


    @RequestMapping(value = "/UpdateVisit.do",method = RequestMethod.POST)
    public void UpdateVisit(HttpServletRequest request) throws IOException {
        String country_id = request.getParameter("country_id");
        this.CountryService.UpdateVisitorCount(country_id);
    }

    @RequestMapping(value = "/UpdateDownload.do",method = RequestMethod.POST)
    public void UpdateDownload(HttpServletRequest request) throws IOException {
        String country_id = request.getParameter("country_id");
        this.CountryService.UpdateDownloadCount(country_id);
    }
}
