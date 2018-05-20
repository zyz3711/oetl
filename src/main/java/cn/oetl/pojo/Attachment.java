package cn.oetl.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Attachment implements Serializable {
	Integer attachment_id;
	String file_path;
	String file_name;
	String show_name;
	// timestamp映射成java.sql.Timestamp
	Timestamp published_time;
	String download_url;

	// 注入News属性
	News news;

	@Override
	public String toString() {
		return attachment_id + "";
	}

	public int getAttachment_id() {
		return attachment_id;
	}

	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_time) {
		this.show_name = show_time;
	}

	public Timestamp getPublished_time() {
		return published_time;
	}

	public void setPublished_time(Timestamp published_time) {
		this.published_time = published_time;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
