package com.noyeong.springboottest01.beanlifecycle.test03;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest03 {

    @Test
    public void lifeCycleTest() {
        // 스프링 컨테이너를 위한 객체.
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig03.class);
        NetworkClient03 networkClient03 = applicationContext.getBean(NetworkClient03.class);
        // 스프링 컨테이너 종료.
        applicationContext.close();
    }

    @Configuration
    static class LifeCycleConfig03 {
        // 스프링 빈 생성, 호출 된 결과물이 스프링 빈으로 등록
        @Bean(initMethod = "init",destroyMethod = "close")
        public NetworkClient03 networkClient() {
            NetworkClient03 networkClient03 = new NetworkClient03();
            System.out.println("NetworkClient01 set url");
            networkClient03.setUrl("http://spring-hello.dev");
            return networkClient03;
        }
    }
}
