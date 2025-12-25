package com.wzz.qq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
public class ThreadPoolTaskExecutorConfig {
    @Bean(name = "taskExecutor")
    public AsyncTaskExecutor taskExecutor() {
        ThreadFactory factory = Thread.ofVirtual().name("vt-task-", 0).factory();
        return new TaskExecutorAdapter(Executors.newThreadPerTaskExecutor(factory));
    }
}