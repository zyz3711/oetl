package cn.oetl.dao.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import cn.oetl.dao.sql.AttachmentSql;
import cn.oetl.pojo.Attachment;
import cn.oetl.pojo.News;

@CacheNamespace(size = 512)
public interface AttachmentMapper {
	@InsertProvider(type = AttachmentSql.class, method = "insertSql")
	@Options(useGeneratedKeys = true, keyProperty = "attachment_id", keyColumn = "attachment_id")
	public int insert(Attachment attachment);

	@DeleteProvider(type = AttachmentSql.class, method = "deleteByPrimaryKeySql")
	public int deleteByPrimaryKey(Integer i);

	@UpdateProvider(type = AttachmentSql.class, method = "updateByPrimaryKeySql")
	public int updateByPrimaryKey(Attachment attachment);

	@SelectProvider(type = AttachmentSql.class, method = "selectByPrimaryKeySql")
	@Results({
			@Result(id = true, property = "attachment_id", column = "attachment_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "news_id", column = "attachment_news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "file_path", column = "attachment_file_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "file_name", column = "attachment_file_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "show_name", column = "attachment_show_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "published_time", column = "attachment_published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "download_url", column = "attachment_download_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "news", column = "attachment_news_id", javaType = News.class, one = @One(select = "cn.oetl.dao.mapper.NewsMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)), })
	public Attachment selectByPrimaryKey(Integer attachment_id);

	@SelectProvider(type = AttachmentSql.class, method = "selectByForeignKeyOfNewsSql")
	@Results({
			@Result(id = true, property = "attachment_id", column = "attachment_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "news_id", column = "attachment_news_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "file_path", column = "attachment_file_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "file_name", column = "attachment_file_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "show_name", column = "attachment_show_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "published_time", column = "attachment_published_time", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "download_url", column = "attachment_download_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "news", column = "attachment_news_id", javaType = News.class, one = @One(select = "cn.oetl.dao.mapper.NewsMapper.selectByPrimaryKey", fetchType = FetchType.LAZY)), })
	public List<Attachment> selectByForeignKeyOfNews(Integer attachment_id);
}
