package cn.oetl.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import cn.oetl.pojo.Attachment;
import cn.oetl.pojo.News;

public class AttachmentSql {
	// @Delete("DELETE FROM attachment where attachment_id=#{id}")
	public String deleteByPrimaryKeySql() {
		return new SQL() {
			{
				DELETE_FROM("attachment");
				WHERE("attachment_id=#{id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Insert("INSERT INTO attachment (news_id, file_path, file_name, show_name,
	// published_time, download_url) "
	// + "VALUES (#{news_id}, #{file_path}, #{file_name},
	// #{show_name},#{published_time}, #{download_url}")
	public String insertSql(final Attachment attachment) {
		return new SQL() {
			{
				INSERT_INTO("attachment");
				if (attachment.getNews() != null) {
					VALUES("news_id", "#{news.news_id, jdbcType=INTEGER}");
				}
				if (attachment.getFile_path() != null) {
					VALUES("file_path", "#{file_path, jdbcType=VARCHAR}");
				}
				if (attachment.getFile_name() != null) {
					VALUES("file_name", "#{file_name, jdbcType=VARCHAR}");
				}
				if (attachment.getShow_name() != null) {
					VALUES("show_name", "#{show_name, jdbcType=VARCHAR}");
				}
				if (attachment.getPublished_time() != null) {
					VALUES("published_time", "#{published_time, jdbcType=TIMESTAMP}");
				}
				if (attachment.getDownload_url() != null) {
					VALUES("download_url", "#{download_url, jdbcType=VARCHAR}");
				}
			}
		}.toString();
	}

	// @Update("UPDATE attachment set "
	// + "news_id=#{news_id}, file_path=#{file_path}, file_name=#{file_name},
	// show_name=#{show_name},
	// published_time =#{published_time}, download_url=#{download_url} "
	// + "where attachment_id=#{attachment_id}")
	public String updateByPrimaryKeySql(final Attachment attachment) {
		return new SQL() {
			{
				UPDATE("attachment");
				if (attachment.getNews() != null && attachment.getNews().getNews_id() != null) {
					SET("news_id=#{news.news_id, jdbcType=INTEGER}");
				}
				if (attachment.getFile_path() != null) {
					SET("file_path=#{file_path, jdbcType=VARCHAR}");
				}
				if (attachment.getFile_name() != null) {
					SET("file_name=#{file_name, jdbcType=VARCHAR}");
				}
				if (attachment.getShow_name() != null) {
					SET("show_name=#{show_name, jdbcType=VARCHAR}");
				}
				if (attachment.getPublished_time() != null) {
					SET("published_time=#{published_time, jdbcType=TIMESTAMP}");
				}
				if (attachment.getDownload_url() != null) {
					SET("download_url=#{download_url, jdbcType=VARCHAR}");
				}
				WHERE("attachment_id=#{attachment_id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Select("select attachment_id, news_id attachment_news_id, file_path
	// attachment_file_path,
	// file_name attachment_file_name, show_name attachment_show_name,
	// published_time attachment_published_time,
	// download_url attachment_download_url "
	// + "from attachment where attachment_id=#{id}")
	public String selectByPrimaryKeySql() {
		return new SQL() {
			{
				SELECT("attachment_id, news_id, file_path, file_name, show_name, published_time, download_url");
				FROM("attachment");
				WHERE("attachment_id=#{attachment_id}");
			}
		}.toString();
	}

	public String selectByForeignKeyOfNewsSql() {
		return new SQL() {
			{
				SELECT("attachment_id, news_id, file_path, file_name, show_name, published_time, download_url");
				FROM("attachment");
				WHERE("news_id=#{news_id}");
			}
		}.toString();
	}
}
