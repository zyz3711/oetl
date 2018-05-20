package cn.oetl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.oetl.dao.mapper.AdminMapper;
import cn.oetl.pojo.Admin;
import cn.oetl.service.AdminService;
import cn.oetl.web.exception.CustomException;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	
//	@Autowired
	PageHelper pageHelper;
	
	@Override
	public Admin selectAdminByName(String admin_name) throws Exception {
		Admin admin = adminMapper.selectByAdminName(admin_name);
		// if(admin == null) {
		// throw new CustomException("用户登录失败，不存在该用户");
		// }
		return admin;
	}

	@Override
	public int deleteAdmin(int id) throws Exception {
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertAdmin(Admin admin) throws Exception {
		return adminMapper.insert(admin);
	}

	@Override
	public int updateAdmin(Admin admin) throws Exception {
		return adminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public List<Admin> selectAllByLimit(Integer offset, Integer length) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("length", length);
		return adminMapper.selectAll();
	}

}
