package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.StringQuery;

/*
 * 나중에 실질적으로 Component기반으로 최종적으로 돌릴때에는
 * DataSource 방식을 사용할 것이다...
 * 
 * 지금은 단위테스트를 우선적으로 해야하기 떄문에
 * DriverManager 방식을 임시로 사용하겠다.
 * ::
 * 1)
 * DataSource방식을 사용할때 가장 핵심이 되는 Service는 JNDI(Naming Service)를 사용할
 * 것이다.
 * 바인딩된 객체를 찾아오는 로직이 dao에 혼재되지 않도록 별도로 분리시키겠다.
 * ::
 * DataSourceManager
 * ::
 * ::
 * 2)
 * String Query부분을 별도로 분리시키겠다.
 * Interface  >>> properties >>>   xml(Framework - MyBatis)  >>> Annotation
 */
public class BoardDao {
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return dao;
		
	}
	
	/////////////// 공통적인 로직 /////////////////////////////
	public  Connection getConnection() throws SQLException{
		System.out.println("디비연결 성공....");
		return DataSourceManager.getInstance().getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs!=null){
			rs.close();
			closeAll(ps, conn);
		}
	}//
	
	//////////////////////// 비지니스 로직 //////////////////////////
	public void posting(BoardVO vo) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getWriter());
			ps.setString(3,vo.getPassword());
			ps.setString(4,vo.getContent());
			
			int row = ps.executeUpdate();
			System.out.println(row+" row INSERT OK!!");
		}finally {
			closeAll(ps, conn);
		}
	}//	posting
	
	
	
	
	
	
	
	
	public BoardVO getPostingByNo(int no) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			
		}finally {
			closeAll(ps, conn);
		}
		return vo;
	}//getPostingByNo
	
	public static void main(String[] args) {
		/*
		 * 비지니스 로직 call
		 */
	}

}









