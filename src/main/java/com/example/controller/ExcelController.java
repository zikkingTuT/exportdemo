package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {
    
    @Autowired
    private ExcelService excelService;
    
    @PostMapping("/import")
    public Result<List<User>> importUsers(@RequestParam("file") MultipartFile file) {
        try {
            List<User> users = excelService.importUsers(file);
            return Result.success(users);
        } catch (IOException e) {
            log.error("导入失败", e);
            return Result.error("导入失败：" + e.getMessage());
        }
    }
    
    @GetMapping("/export")
    public void exportUsers(HttpServletResponse response) {
        try {
            // 模拟数据
            List<User> users = Arrays.asList(
                new User(1L, "张三", 25, "zhangsan@example.com"),
                new User(2L, "李四", 30, "lisi@example.com")
            );
            excelService.exportUsers(response, users);
        } catch (IOException e) {
            log.error("导出失败", e);
        }
    }
} 