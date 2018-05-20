package cn.oetl.service;

import cn.oetl.pojo.Attachment;

public interface AttachmentService {
	public Attachment selectAttachment(int attachment_id) throws Exception;

	public int deleteAttachment(int attachment_id) throws Exception;

	public int insertAttachment(Attachment attachment) throws Exception;

	public int updateAttachment(Attachment attachment) throws Exception;
}
