package com.noyeong.springboottest01.beanlifecycle.test02;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest02 {

    @Test
    public void lifeCycleTest() {
        // 스프링 컨테이너를 위한 객체.
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig02.class);
        NetworkClient02 networkClient02 = applicationContext.getBean(NetworkClient02.class);
        // 스프링 컨테이너 종료.
        applicationContext.close();
    }

    @Configuration
    static class LifeCycleConfig02 {
        // 스프링 빈 생성, 호출 된 결과물이 스프링 빈으로 등록
        @Bean
        public NetworkClient02 networkClient() {
            NetworkClient02 networkClient02 = new NetworkClient02();
            System.out.println("NetworkClient01 set url");
            networkClient02.setUrl("http://spring-hello.dev");
            return networkClient02;
        }
    }
}
