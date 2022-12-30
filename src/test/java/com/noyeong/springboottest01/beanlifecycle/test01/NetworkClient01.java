package com.noyeong.springboottest01.beanlifecycle.test01;

public class NetworkClient01 {

    /**
     * 네트워크 통신에 대한 스프링 빈 생성 주기 테스트 객체
     *
     * connect() : 어플리케이션 시작시점에 동작하는 메소드
     * disConnect() : 어플리케이션 종료시 동작하는 메소드
     */
    private String url;

    public NetworkClient01() { System.out.println("생성자 호출, url = " + url);
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
}
