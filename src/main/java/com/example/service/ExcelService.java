package com.example.service;

import com.alibaba.excel.EasyExcel;
import com.example.entity.User;
import com.example.listener.UserExcelListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ExcelService {
    
    public void exportUsers(HttpServletResponse response, List<User> userList) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户数据", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        
        EasyExcel.write(response.getOutputStream(), User.class)
                .sheet("用户列表")
                .doWrite(userList);
    }
    
    public List<User> importUsers(MultipartFile file) throws IOException {
        UserExcelListener listener = new UserExcelListener();
        EasyExcel.read(file.getInputStream(), User.class, listener)
                .sheet()
                .doRead();
        return listener.getUserList();
    }
} 