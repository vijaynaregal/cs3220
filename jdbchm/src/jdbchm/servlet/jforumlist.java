package jdbchm.servlet;

public class jforumlist {
	Integer id;
	String forum;
	Integer topics;
	Integer subid;
public jforumlist(Integer id,String forum,Integer topics,Integer subid) {
	this.id=id;
	this.forum=forum;
	this.topics=topics;
	this.subid=subid;
}
public jforumlist(Integer topics) {
	this.topics=topics;
}


public Integer getSubid() {
	return subid;
}


public void setSubid(Integer subid) {
	this.subid = subid;
}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getForum() {
	return forum;
}
public void setForum(String forum) {
	this.forum = forum;
}
public Integer getTopics() {
	return topics;
}
public void setTopics(Integer topics) {
	this.topics = topics;
}

}
