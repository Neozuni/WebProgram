package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverLoadingListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("1.Start to driver Loading ...");
		
		// 드라이버 로딩하기 ...
		
		
		ServletContext ctx = sce.getServletContext();
		String driverClass = ctx.getInitParameter("ODriver");
		
		System.out.println("ODriver:" + driverClass);
		
		try {
			Class.forName(driverClass);
			System.out.println(" Driver (ODriver) loading okay ...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading fail ...");
		}
		
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
