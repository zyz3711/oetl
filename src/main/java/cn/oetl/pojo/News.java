package cn.oetl.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class News implements Serializable {
	Integer news_id;
	String title;
	// timestamp映射成java.sql.Timestamp
	Timestamp published_time;
	String content_url;
	Integer visits;
	// bit映射成boolean
	Boolean top;

	// 注入admin
	Admin admin;
	// 注入attachment
	List<Attachment> attachments;

	@Override
	public String toString() {
		return news_id + title;
	}

	// getters and setters..
	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getPublished_time() {
		return published_time;
	}

	public void setPublished_time(Timestamp published_time) {
		this.published_time = published_time;
	}

	public String getContent_url() {
		return content_url;
	}

	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public Boolean getTop() {
		return top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
