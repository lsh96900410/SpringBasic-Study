package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 뷰패스 설정 후 HttpServletRequest 이용하여 forward [ 3. JSP forward]
        String viewPath = "/WEB-INF/views/newForm.jsp";
        RequestDispatcher disPatcher = request.getRequestDispatcher(viewPath);
        disPatcher.forward(request,response);

    }
}
