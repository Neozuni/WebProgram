package sql;

public interface StringQuery {
	String INSERT_POSTING = 
			"insert into board(no, title, writer, password, content,time_posted)"+
			" values(board_seq.nextval,?,?,?,?,sysdate)";
}
