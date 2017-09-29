package model;
/*
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;

import config.OracleInfo;

public class DataSourceManager {
	private Connection conn;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Class.forName(OracleInfo.DRIVER);
			System.out.println("Driver Loading....");
			
			conn = DriverManager.getConnection(OracleInfo.URL,"hr","hr");
			System.out.println("db connection....");					
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public static DataSourceManager getInstance() {
		return instance;		
	}	
	//추가
	public Connection getConnection() {
		return conn;
	}
}









