package listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import servlet.vo.PersonVO;

public class CollectionListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("1.contextInitialized...CollectionListener");
		ArrayList<PersonVo> list = new ArrayList<PersonVo>();
		sce.getServletContext().setAttribute("list", list);
		System.out.println("2.ArrayList Binding ");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
