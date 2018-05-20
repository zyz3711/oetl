package cn.oetl.dao.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import com.github.pagehelper.Page;

import cn.oetl.dao.sql.NewsSql;
import cn.oetl.pojo.Admin;
import cn.oetl.pojo.Attachment;
import cn.oetl.pojo.News;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;

//@CacheNamespace(size = 512)
public interface NewsMapperSecond {
	@InsertProvider(type = NewsSql.class, method = "insertSql")
	@Options(useGeneratedKeys = true, keyProperty = "news_id", keyColumn = "news_id")
	public int insert(News news);

	@DeleteProvider(type = NewsSql.class, method = "deleteByPrimaryKeySql")
	public int deleteByPrimaryKey(int i);

	@UpdateProvider(type = NewsSql.class, method = "updateByPrimaryKeySql")
	public int updateByPrimaryKey(News news);

	@SelectProvider(type = NewsSql.class, method = "selectByPrimaryKeySql")
	@Results({
			@Result(id = true, property = "news_id", column = "news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "title", column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "published_time", column = "published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "content_url", column = "content_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "visits", column = "visits", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "top", column = "top", javaType = boolean.class, jdbcType = JdbcType.BIT),
			@Result(property = "admin", column = "admin_id", javaType = Admin.class, one = @One(select = "cn.oetl.dao.mapper.AdminMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)),
			@Result(property = "attachments", column = "news_id", javaType = Attachment.class, many = @Many(select = "cn.oetl.dao.mapper.AttachmentMapper.selectByForeignKeyOfNews", fetchType = FetchType.LAZY)) })
	public News selectByPrimaryKey(@Param("news_id") Integer news_id);

	@SelectProvider(type = NewsSql.class, method = "selectByForeignKeyOfAdminSql")
	@Results({
			@Result(id = true, property = "news_id", column = "news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "title", column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "published_time", column = "published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "content_url", column = "content_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "visits", column = "visits", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "top", column = "top", javaType = boolean.class, jdbcType = JdbcType.BIT),
			@Result(property = "admin", column = "admin_id", javaType = Admin.class, one = @One(select = "cn.oetl.dao.mapper.AdminMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)),
			@Result(property = "attachments", column = "news_id", javaType = Attachment.class, many = @Many(select = "cn.oetl.dao.mapper.AttachmentMapper.selectByForeignKeyOfNews", fetchType = FetchType.LAZY)) })
	public List<News> selectByForeignKeyOfAdmin(@Param("admin_id") Integer admin_id);

	@SelectProvider(type = NewsSql.class, method = "selectByTitleSql")
	@Results({
			@Result(id = true, property = "news_id", column = "news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "title", column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "published_time", column = "published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "content_url", column = "content_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "visits", column = "visits", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "top", column = "top", javaType = boolean.class, jdbcType = JdbcType.BIT),
			@Result(property = "admin", column = "admin_id", javaType = Admin.class, one = @One(select = "cn.oetl.dao.mapper.AdminMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)),
			@Result(property = "attachments", column = "news_id", javaType = List.class, many = @Many(select = "cn.oetl.dao.mapper.AttachmentMapper.selectByForeignKeyOfNews", fetchType = FetchType.LAZY)) })
	public List<News> selectByTitle(@Param("partTitle") String partTitle);
	
	@SelectProvider(type = NewsSql.class, method = "selectAllSql")
	@Results({
		@Result(id = true, property = "news_id", column = "news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
		@Result(property = "title", column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
		@Result(property = "published_time", column = "published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "content_url", column = "content_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
		@Result(property = "visits", column = "visits", javaType = int.class, jdbcType = JdbcType.INTEGER),
		@Result(property = "top", column = "top", javaType = boolean.class, jdbcType = JdbcType.BIT),
		@Result(property = "admin", column = "admin_id", javaType = Admin.class, one = @One(select = "cn.oetl.dao.mapper.AdminMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)),
		@Result(property = "attachments", column = "news_id", javaType = List.class, many = @Many(select = "cn.oetl.dao.mapper.AttachmentMapper.selectByForeignKeyOfNews", fetchType = FetchType.LAZY)) })
	public List<News> selectAll();
}
