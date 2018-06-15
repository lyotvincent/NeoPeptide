package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {
    @RequestMapping("/index.do")
    public String Index() {
        return "redirect:/index.html";
    }

    @RequestMapping("/search.do")
    public String Search() {
        return "/Search";
    }

    @RequestMapping("/about.do")
    public String about() {
        return "/about";
    }

    @RequestMapping("/download.do")
    public String download(){
        return "/Download";
    }

    @RequestMapping("/chart.do")
    public String chart(){
        return "/chart";
    }

    @RequestMapping("/search_data.do")
    public String Search_data() { return  "/Search_data"; }

    @RequestMapping("/contact.do")
    public String Contact() { return  "/contact"; }
}
