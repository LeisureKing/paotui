package cn.dowalker.notice;

import java.util.List;

import cn.dowalker.bean.Notice;

public class NoticeService {
	
	NoticeDao noticeDao = new NoticeDao();
	
	public void insertNotice(Notice notice) {
		noticeDao.insertNotice(notice);
	}
	
	public List<Notice> getNotices() {
		return noticeDao.getNotices();
	}
	
	public Notice getNotice(String id) {
		return noticeDao.getNotice(id);
	}
	
	public void deleteNotice(String id) {
		noticeDao.deleteNotice(id);
	}
	
	public List<Notice> getMyNotices(String uid) {
		return noticeDao.getMyNotices(uid);
	}

}
