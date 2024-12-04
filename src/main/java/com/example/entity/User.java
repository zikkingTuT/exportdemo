package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ExcelProperty("用户ID")
    private Long id;
    
    @NotBlank(message = "用户名不能为空")
    @ExcelProperty("用户名")
    private String username;
    
    @NotNull(message = "年龄不能为空")
    @ExcelProperty("年龄")
    private Integer age;
    
    @Email(message = "邮箱格式不正确")
    @ExcelProperty("邮箱")
    private String email;
} 