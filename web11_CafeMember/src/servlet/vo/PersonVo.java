package servlet.vo;
/*
 * 클라이언트 폼(front) :
 * 
 * 디비 테이블(back) :컬럼
 */
public class PersonVo {
	private String name;
	private int age;
	
	public PersonVo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public PersonVo() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + "]";
	}	
}






