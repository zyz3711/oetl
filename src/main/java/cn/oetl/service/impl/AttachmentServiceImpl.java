package cn.oetl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.oetl.dao.mapper.AdminMapper;
import cn.oetl.dao.mapper.AttachmentMapper;
import cn.oetl.pojo.Admin;
import cn.oetl.pojo.Attachment;
import cn.oetl.service.AdminService;
import cn.oetl.service.AttachmentService;

@Service(value = "attachmentService")
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	AttachmentMapper attachmentMapper;

	@Override
	public Attachment selectAttachment(int attachment_id) {
		return attachmentMapper.selectByPrimaryKey(attachment_id);
	}

	@Override
	public int deleteAttachment(int attachment_id) {
		return attachmentMapper.deleteByPrimaryKey(attachment_id);
	}

	@Override
	public int insertAttachment(Attachment attachment) {
		return attachmentMapper.insert(attachment);
	}

	@Override
	public int updateAttachment(Attachment attachment) {
		return attachmentMapper.updateByPrimaryKey(attachment);
	}

}
