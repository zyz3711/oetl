package cn.oetl.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.github.pagehelper.Page;

import cn.oetl.pojo.News;

public class NewsSql {
	// @Delete("DELETE FROM news where news_id=#{id}")
	public String deleteByPrimaryKeySql() {
		return new SQL() {
			{
				DELETE_FROM("news");
				WHERE("news_id=#{id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Insert("INSERT INTO news (title, published_time, content_url, visits,
	// admin_id, top)
	// VALUES (#{title}, #{published_time}, #{content_url}, #{visits},#{admin_id},
	// #{top}")
	public String insertSql(final News news) {
		return new SQL() {
			{
				INSERT_INTO("news");
				if (news.getTitle() != null) {
					VALUES("title", "#{title, jdbcType=VARCHAR}");
				}
				if (news.getPublished_time() != null) {
					VALUES("published_time", "#{published_time, jdbcType=TIMESTAMP}");
				}
				if (news.getContent_url() != null) {
					VALUES("content_url", "#{content_url, jdbcType=VARCHAR}");
				}
				if (news.getVisits() != null) {
					VALUES("visits", "#{visits, jdbcType=INTEGER}");
				}
				if (news.getTop() != null) {
					VALUES("top", "#{top, jdbcType=BIT}");
				}
				if (news.getAdmin() != null && news.getAdmin().getAdmin_id() != null) {
					VALUES("admin_id", "#{admin.admin_id, jdbcType=INTEGER}");
				}
			}
		}.toString();
	}

	// @Update("UPDATE news set title=#{title}, published_time=#{published_time},
	// content_url=#{content_url}, visits=#{visits}, admin_id =#{admin_id},
	// top=#{top} where news_id=#{news_id}")
	public String updateByPrimaryKeySql(final News news) {
		return new SQL() {
			{
				UPDATE("news");
				if (news.getContent_url() != null) {
					SET("title=#{title, jdbcType=VARCHAR}");
				}
				if (news.getPublished_time() != null) {
					SET("published_time=#{published_time, jdbcType=TIMESTAMP}");
				}
				if (news.getContent_url() != null) {
					SET("content_url=#{content_url, jdbcType=VARCHAR}");
				}
				if (news.getVisits() != null) {
					SET("visits=#{visits, jdbcType=INTEGER}");
				}
				if (news.getAdmin() != null) {
					SET("admin_id=#{admin.admin_id, jdbcType=INTEGER}");
				}
				if (news.getTop() != null) {
					SET("top=#{top, jdbcType=BIT}");
				}
				WHERE("news_id=#{news_id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Select("select news_id, title news_title, published_time
	// news_published_time,
	// content_url news_content_url, visits news_visits, admin_id news_admin_id, top
	// news_top "
	// + "from news where news_id=#{news_id}")
	public String selectByPrimaryKeySql() {
		return new SQL() {
			{
				SELECT("news_id, title, published_time, content_url, visits, admin_id, top");
				FROM("news");
				WHERE("news_id=#{news_id}");
			}
		}.toString();
	}

	public String selectByForeignKeyOfAdminSql() {
		return new SQL() {
			{
				SELECT("news_id, title, published_time, content_url, visits, admin_id, top");
				FROM("news");
				WHERE("admin_id=#{admin_id}");
			}
		}.toString();
	}

	public String selectByTitleSql() {
		return new SQL() {
			{
				SELECT("news_id, title, published_time, content_url, visits, admin_id, top");
				FROM("news");
				//name = #{name}"    name = '${name}'
				WHERE("title like %${value}%");
			}
		}.toString();
	}

	// public String selectByPublishedTimeSql() {
	// return new SQL() {
	// {
	// SELECT("news_id, title news_title, published_time news_published_time, "
	// + "content_url news_content_url, visits news_visits, "
	// + "admin_id news_admin_id, top news_top");
	// FROM("news");
	// WHERE("news_title like %${value}%");
	// }
	// }.toString();
	// }

	public String selectAllSql() {
		String s = "select * from news;";
		return s;
	}
	
}
