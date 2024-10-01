package org.example.tobi.springbootessentials.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화(필요 시) 필요없으면 이거 오버라이드 안해도 됌. 생성자 같은 것임
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain chain
    ) throws IOException, ServletException {
        // 실질적인 필터. 너 업스면 망해....
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 요청 정보 로깅
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Request Method: " + request.getMethod());

        // 필터 체인 계속해서 다음 필터 또는 서블릿으로 전달
        chain.doFilter(request, response);

        // 응답 상태 코드 로깅 <--
        System.out.println("Response status: " + response.getStatus());
    }

    @Override
    public void destroy() {
        // 필터 종료 시 처리(필요 시) 필요없으면 이거 오버라이드 안해도 됌.
    }
}
