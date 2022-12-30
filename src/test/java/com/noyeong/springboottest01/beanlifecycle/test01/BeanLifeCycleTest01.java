package com.noyeong.springboottest01.beanlifecycle.test01;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest01 {

    /**
     * print 내용은 객체 생성 순서 추적용으로 기록
     */

    @Test
    public void lifeCycleTest() {
        System.out.println("ConfigurableApplicationContext 객체 생성");
        // 스프링 컨테이너를 위한 객체.
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig01.class);
        System.out.println("ConfigurableApplicationContext 객체 생성 후 NetworkClient01 호출");
        NetworkClient01 networkClient01 = applicationContext.getBean(NetworkClient01.class);
        // 스프링 컨테이너 종료.
        applicationContext.close();
    }

    @Configuration
    static class LifeCycleConfig01 {
        // 스프링 빈 생성, 호출 된 결과물이 스프링 빈으로 등록
        @Bean
        public NetworkClient01 networkClient() {
            NetworkClient01 networkClient01 = new NetworkClient01();
            System.out.println("NetworkClient01 set url");
            networkClient01.setUrl("http://spring-hello.dev");
            return networkClient01;
        }
    }
}
