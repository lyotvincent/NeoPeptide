package controller;

import model.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IMsgService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/contact")
public class MsgController {
    @Resource
    private IMsgService MsgService;
    @ResponseBody
    @RequestMapping(value = "/msg.do",method = RequestMethod.POST)
    public void fuzzySearch(HttpServletRequest request) throws IOException {
        String strip = request.getParameter("ip");
        String strname = request.getParameter("name");
        String stremail = request.getParameter("email");
        String strphone = request.getParameter("phone");
        String strsubject = request.getParameter("subject");
        String strmessage = request.getParameter("message");
        String strtime = request.getParameter("time");
        Date date = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(strtime);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }

        String strcountry = request.getParameter("country_id");
        Msg msg = new Msg(strname,stremail,strphone,strsubject,strmessage,date,strip,strcountry);
        MsgService.insert(msg);
    }
}
