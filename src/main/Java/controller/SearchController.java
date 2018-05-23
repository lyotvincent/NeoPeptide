package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Disease_Cancer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ISearchService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Search")
public class SearchController{
    @Resource
    private ISearchService SearchService;
    @ResponseBody
    @RequestMapping(value = "/fuzzy_search_cancer.do",method = RequestMethod.POST)
    public Object fuzzySearch(HttpServletRequest request) throws IOException {
        String str = request.getParameter("key");
        List<Disease_Cancer> cancerList = this.SearchService.Search_Disease_CancerByKey(str);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cancerList);
    }

    @ResponseBody
    @RequestMapping(value = "/exact_search_cancer.do", method = RequestMethod.POST)
    public Object exactSearch(HttpServletRequest request) throws IOException {
        String str = request.getParameter("key");
        List<Disease_Cancer> cancerList = this.SearchService.Search_Disease_CancerBySql(str);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cancerList);
    }
}
