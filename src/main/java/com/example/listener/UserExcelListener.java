package com.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserExcelListener implements ReadListener<User> {
    private final List<User> userList = new ArrayList<>();

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        log.info("解析到一条数据：{}", user);
        userList.add(user);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

    public List<User> getUserList() {
        return userList;
    }
} 