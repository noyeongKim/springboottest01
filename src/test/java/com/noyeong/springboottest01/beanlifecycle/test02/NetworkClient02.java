package com.noyeong.springboottest01.beanlifecycle.test02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient02 implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient02() { System.out.println("생성자 호출, url = " + url);
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

    /**
     * InitializingBean 객체에서 메소드 오버라이딩
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결된 메시지");
    }

    /**
     * DisposableBean 객체에서 메소드 오버라이딩
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
