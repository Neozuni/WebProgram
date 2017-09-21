package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * ServletContextEvent를 감지하는 리스너
 * ServletContextEvent는 ServletContext에 어떤 값으로 초기화가
 * 진행됬을때 이를 하나의 사건으로 감지하고 이벤트를 발생
 * ::
 * '어떤 값으로 초기화'
 *  getInitParameter("param-name")값을 끌어당길때...dd 파일에 등록
 *  ::
 *  이벤트를 감지하는 리스너
 *  ServletContextListener임.
 *  이벤트가 발생하면
 *  contextInitialized(sce)--> 여기다 getInitparameter() 를 사용
 *  contextDestroyed(sce)
 */
public class MyServletListener implements ServletContextListener{
	private ServletContext cont;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed...call");		
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized...call");		
		cont = sce.getServletContext();
		String fileName = cont.getInitParameter("userFile");
		
		/*
		 * ServletContext를 하나 리턴받음
		 * String fileName = getInitParameter()를 이용해서 값을 받아옴..
		 * 
		 */
		
		//ServletContext를 하나 리턴받음 // 호출하기 어려워서 주석처리후 위로 선언 올림 
		//String fileName =sce.getServletContext().getInitParameter("userFile");
		System.out.println("filename ::"+fileName);
		
		InputStream is = null; // 인풋스트림 선언
		BufferedReader br = null; // 감쌀꺼
		try {
			System.out.println("getResourceAsStream()...call..");
			is = cont.getResourceAsStream(fileName);
			/*
			 * 이 안에 있는 파일을 읽어 들여서 정보를 콘솔로 출력 
			 */
			br = new BufferedReader(new InputStreamReader(is)); // 1.버퍼리더 만들어
			String line = null; // 2.널이 아닐때 까지 
			System.out.println("파일의 내용을 읽어 들입니다. .. ");
			while((line=br.readLine())!=null) { // 3.읽어들임 ..
				System.out.println(line);
			}
		}catch (Exception e) {
			System.out.println("파일을 읽어오지 못했습니다. ");
		}
	}
}














