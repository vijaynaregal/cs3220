package jdbchm.servlet;

import java.util.Date;

public class jsubtopiclist {
	Integer id1;
	String name;
	Date date1;
	String message;
	
	public jsubtopiclist(Integer id1,String name,String message,Date date1) {
		this.id1 =id1;
		this.name=name;
		this.date1=date1;
		this.message=message;
	}

	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	}
