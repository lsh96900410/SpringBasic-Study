package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //JSON 라이브러리가 SETTER 메쏘드로 객체에 데이터 주입
public class HelloData {
    private String username;
    private int age;
}
