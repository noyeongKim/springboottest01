package com.noyeong.springboottest01.beanlifecycle.test04;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient04 {

    private String url;

    public NetworkClient04() { System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    // 외부에서 URL을 넣을 수 있게
    public void setUrl(String url) {
        this.url = url;
    }
    // 서비스 시작할 때 호출
    public void connect() {
        System.out.println("connect: " + url);
    }
    // 실제 호출하는 것
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }
    // 서비스 종료할 때 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
