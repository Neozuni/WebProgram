package context.model;
/*
 * 디비접속하는 비지니스 로직을 담고 있는 DAO 클래스 ::
 * MVC 에서 M(Model)에 해당된다.
 * Model은 크게 두 가지로 나뉜다(DAO / VO)
 * ==========================================================
 * DAO ::
 * 서버 사이드에서 단 한개만 생성하고
 * 즉 다른 곳에서는 해당 클래스 타입으로 객체를 생성하지 못하게 막아놓는다.
 * 비지니스 로직이 필요한 서블릿들이 하나 생성된 DAO의 메소드를 각각 호출해서 사용하도록 한다.
 * -------------> 싱글톤
 * 1)일단 해당 클래스에서 하나만 생성 : private static으로 생성
 * 2)생성자 앞에 private 붙여서 다른 곳에서 객체가 생성되는 것을 막아둔다.
 * 3)하나 만들어놓은 객체를 다른 서블릿들이 가져다 쓸수 있도록 public static Object getInstance()
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource ds ;

	//싱글톤 패턴
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		System.out.println("singletone pattern .. dao creating..");

		try {
			Context ic = new InitialContext();
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("datasource lookup ...");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("datasource .. .lookup fail");
		}

	}

	public static MemberDAO getInstance(){
		return dao;
	}


	//공통적인 로직
	public Connection getConnection() throws SQLException {
		System.out.println("success ! connected to db");
		return ds.getConnection();
	}

	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps==null) ps.close();
		if(conn!=null) conn.close();
	}


	// 비지니스 로직

	//회원등록 
	public void registerMember(MemberVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn=getConnection();
			String query = "insert into member values(?,?,?,?)";
			ps= conn.prepareStatement(query);

			ps.setString(1, vo.getId());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getAddress());
			System.out.println(ps.executeQuery()+"row insert ok!");

		} finally {
			// TODO: handle finally clause
			closeAll(ps, conn);
		}
	}
	//회원찾기 
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public MemberVO findByIdMember(String id)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		MemberVO vo = null;

		try {
			conn=getConnection();
			String query = "Select * from member where id=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			rs=ps.executeQuery();

			if(rs.next()) {
				vo=new MemberVO(id,
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("address"));	

			}
		} finally {
			// TODO: handle finally clause
			closeAll(ps, conn);
		}
		return vo;

	}
}

