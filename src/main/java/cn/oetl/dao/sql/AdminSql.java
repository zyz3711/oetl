package cn.oetl.dao.sql;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.jdbc.SQL;

import cn.oetl.pojo.Admin;

public class AdminSql {
	// @DELETE FROM admin where admin_id=#{id}
	public String deleteByPrimaryKeySql() {
		return new SQL() {
			{
				DELETE_FROM("admin");
				WHERE("admin_id=#{id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Insert("INSERT INTO admin (NAME, PASSWORD, phone, email)
	// VALUES (#{name}, #{password}, #{phone}, #{email}")
	public String insertSql(final Admin admin) {
		return new SQL() {
			{
				INSERT_INTO("admin");
				if (admin.getName() != null && admin.getName() != "") {
					VALUES("name", "#{name, jdbcType=VARCHAR}");
				}
				if (admin.getPassword() != null && admin.getPassword() != "") {
					VALUES("password", "#{password, jdbcType=VARCHAR}");
				}
				if (admin.getPhone() != null && admin.getPhone() != "") {
					VALUES("phone", "#{phone, jdbcType=VARCHAR}");
				}
				if (admin.getEmail() != null && admin.getEmail() != "") {
					VALUES("email", "#{email, jdbcType=VARCHAR}");
				}
			}
		}.toString();
	}

	// @Update("UPDATE admin set name=#{name}, password=#{password},
	// phone=#{phone}, email=#{email} where admin_id=#{admin_id}")
	public String updateByPrimaryKeySql(final Admin admin) {
		return new SQL() {
			{
				UPDATE("admin");
				if (admin.getName() != null) {
					SET("name=#{name, jdbcType=VARCHAR}");
				}
				if (admin.getPassword() != null) {
					SET("password=#{password, jdbcType=VARCHAR}");
				}
				if (admin.getPhone() != null) {
					SET("phone=#{phone, jdbcType=VARCHAR}");
				}
				if (admin.getEmail() != null) {
					SET("email=#{email, jdbcType=VARCHAR}");
				}
				WHERE("admin_id=#{admin_id, jdbcType=INTEGER}");
			}
		}.toString();
	}

	// @Select("select admin_id, name admin_name, password admin_password,
	// phone admin_phone, email admin_email from admin where admin_id=#{id}")
	public String selectByPrimaryKeySql() {
		return new SQL() {
			{
				SELECT("admin_id, name, password, phone, email");
				FROM("admin");
				WHERE("admin_id=#{admin_id}");
			}
		}.toString();
	}

	// @Select("select admin_id, name admin_name, password admin_password,
	// phone admin_phone, email admin_email from admin where admin_name like
	// $%{value}%")
	public String selectByAdminNameSql() {
		return new SQL() {
			{
				SELECT("admin_id, name, password, phone, email");
				FROM("admin");
				WHERE("name = #{value}");
			}
		}.toString();
	}

	// 查找所有Admin的sql
	public String selectAllSql() {
		String sql = "select * from admin;";
		return sql;
	}

}
