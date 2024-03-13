package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start ");
    // req.getParameter() 메쏘드는 GET,POST 요청 둘다 꺼낼 수 있음
    // --> HTTP Body에 실려오는 형식 ===  쿼리 파라미터랑 동일
        Enumeration<String> parameterNames = req.getParameterNames();// 모든 요청 파라미터
        parameterNames.asIterator().forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end  ");
        System.out.println("[단일 파라미터 조회] - start ");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end ");

        System.out.println(" [이름이 같은 복수 파라미터 ] - start");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username : " + name);
        }
        System.out.println(" [이름이 같은 복수 파라미터 ] - end");
        resp.getWriter().write("ok");
    }

}
