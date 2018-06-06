package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/Download")
public class DownloadController {
    @Value("#{projectProperties['filePath_dbf']}")
    private String strfilepath_dbf;

    @Value("#{projectProperties['filePath_xlsx']}")
    private String strfilepath_xlsx;

    @RequestMapping("/Cancer_dbf.do")
    public void downloaddbf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DownloadFile(response,strfilepath_dbf);
    }

    @RequestMapping("/Cancer_xlsx.do")
    public void downloadxlsx(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DownloadFile(response,strfilepath_xlsx);
    }

    public void DownloadFile(HttpServletResponse response, String strfilepath) throws Exception {
        try {
            String path = strfilepath;
            File file = new File(path);
            if (file.exists()) {
                String filename = file.getName();
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                response.reset();
                response.setContentType("application/x-download");
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes(), "UTF-8"));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream out = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                byte[] buffer = new byte[1024 * 1024 * 10];
                int i = -1;
                while ((i = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, i);
                }
                fis.close();
                out.flush();
                out.close();
                try {
                    response.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                PrintWriter out = response.getWriter();
                out.print("<script>");
                out.print("alert(\"not find the file\")");
                out.print("</script>");
            }
        } catch (IOException ex) {
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("alert(\"not find the file\")");
            out.print("</script>");
        }
    }
}
