package com.example.hotupdatees;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @author DongCL
 * @description
 * @date 2024/5/9 10:47
 */
@RestController
@RequestMapping("/api/es")
public class HomeController {
    @RequestMapping(value = "hotWord")
    public void msbHotword(HttpServletResponse response, Integer wordlib) throws Exception {
        File file;
        if (wordlib == 1){
            file = new File("D:\\tools\\elasticsearch-7.10.0-windows-x86_64\\elasticsearch-7.10.0\\plugins\\ik\\config\\hotUpdate\\dcl_extend.dic");
        }else {
            file = new File("D:\\tools\\elasticsearch-7.10.0-windows-x86_64\\elasticsearch-7.10.0\\plugins\\ik\\config\\hotUpdate\\dcl_stopword.dic");
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("Last-Modified", String.valueOf(buffer.length));
        response.setHeader("ETag", String.valueOf(buffer.length));
        int offset = 0;
        while (fis.read(buffer, offset, buffer.length - offset)!=-1){

        }
        OutputStream out = response.getOutputStream();
        out.write(buffer);
        out.flush();
        fis.close();
    }
}