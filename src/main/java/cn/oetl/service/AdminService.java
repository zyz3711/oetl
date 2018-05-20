package cn.oetl.service;

import java.util.List;

import cn.oetl.pojo.Admin;

public interface AdminService {
	public Admin selectAdminByName(String admin_name) throws Exception;

	public int deleteAdmin(int id) throws Exception;

	public int insertAdmin(Admin admin) throws Exception;

	public int updateAdmin(Admin admin) throws Exception;

	public List<Admin> selectAllByLimit(Integer offset, Integer length) throws Exception;
}
