package servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//사전작업 
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//사전작업의 내용이 서버상의 서블릿으로 계속적으로 연결되기 위해서는 chain이 필요하다 
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfiargg) throws ServletException {

	}

}
