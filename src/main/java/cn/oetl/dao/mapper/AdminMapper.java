package cn.oetl.dao.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import cn.oetl.dao.sql.AdminSql;
import cn.oetl.pojo.Admin;
import cn.oetl.pojo.News;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;

//@CacheNamespace(size = 512)
public interface AdminMapper {
	@InsertProvider(type = AdminSql.class, method = "insertSql")
	@Options(useGeneratedKeys = true, keyProperty = "admin_id", keyColumn = "admin_id")
	public int insert(Admin admin);

	@DeleteProvider(type = AdminSql.class, method = "deleteByPrimaryKeySql")
	@Options(flushCache = FlushCachePolicy.TRUE, timeout = 20000)
	public int deleteByPrimaryKey(Integer i);

	@UpdateProvider(type = AdminSql.class, method = "updateByPrimaryKeySql")
	@Options(flushCache = FlushCachePolicy.TRUE, timeout = 20000)
	public int updateByPrimaryKey(Admin admin);

	@SelectProvider(type = AdminSql.class, method = "selectByPrimaryKeySql")
	@Options(useCache = true, flushCache = FlushCachePolicy.FALSE, timeout = 10000)
	@Results(value = {
			@Result(id = true, property = "admin_id", column = "admin_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "email", column = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "newses", column = "admin_id", javaType = List.class, many = @Many(fetchType = FetchType.LAZY, select = "cn.oetl.dao.mapper.NewsMapper.selectByForeignKeyOfAdmin")) })
	public Admin selectByPrimaryKey(Integer admin_id);

	@SelectProvider(type = AdminSql.class, method = "selectByAdminNameSql")
	@Options(useCache = true, flushCache = FlushCachePolicy.FALSE, timeout = 10000)
	@Results(value = {
			@Result(id = true, property = "admin_id", column = "admin_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "email", column = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "newses", column = "admin_id", javaType = List.class, many = @Many(fetchType = FetchType.LAZY, select = "cn.oetl.dao.mapper.NewsMapper.selectByForeignKeyOfAdmin")) })
	public Admin selectByAdminName(String admin_name);

	@SelectProvider(type = AdminSql.class, method = "selectAllSql")
	@Options(useCache = true, flushCache = FlushCachePolicy.FALSE, timeout = 10000)
	@Results(value = {
			@Result(id = true, property = "admin_id", column = "admin_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "phone", column = "phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "email", column = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "newses", column = "admin_id", javaType = List.class, many = @Many(fetchType = FetchType.LAZY, select = "cn.oetl.dao.mapper.NewsMapper.selectByForeignKeyOfAdmin")) })
	public List<Admin> selectAll();

}
