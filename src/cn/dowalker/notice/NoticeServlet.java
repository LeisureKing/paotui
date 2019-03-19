package cn.dowalker.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.dowalker.bean.Notice;
import cn.dowalker.bean.User;
import cn.dowalker.utils.BaseServlet;
import cn.dowalker.utils.UUIDUtils;
import cn.dowalker.utils.UploadUtils;

public class NoticeServlet extends BaseServlet {
	
	/**
	 * 添加通知
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String insertNotice(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeService noticeService = new NoticeService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Notice notice = new Notice();
		
		notice.setId(UUIDUtils.getId());
		notice.setTime(new Date());
        notice.setUid(user.getId());
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建解析类的实例
        ServletFileUpload sfu = new ServletFileUpload(factory);
        try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			
			Map<String,String> map = new HashMap<String,String>();
			
			//区分表单域
            for (int i = 0; i < fileItemList.size(); i++) {
                FileItem item = fileItemList.get(i);
                
                //isFormField为true，表示这不是文件上传表单域
                if(!item.isFormField()){
                	//生成图片的url保存到数据库
                	String imgUrl = "images/notice/"+UploadUtils.getUUIDName(UploadUtils.getRealName(item.getName()));
                	notice.setImage(imgUrl);
                	//获取项目地址
                	String realUrl=request.getSession().getServletContext().getRealPath("/");
                	//保存图片 保存地址=项目地址+相对路径
                	File destFile = new File(realUrl+imgUrl);
					item.write(destFile);
                }else {
                	map.put(item.getFieldName(), item.getString("UTF-8"));
				}
            }
            BeanUtils.populate(notice, map);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        noticeService.insertNotice(notice);
        response.sendRedirect(request.getContextPath()+"/NoticeServlet?method=getMyNotice");
		return null;
	}
	
	
	public String allNotices(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeService noticeService = new NoticeService();
		List<Notice> notices = new ArrayList<Notice>();
		notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return "/news.jsp";
	}
	
	public String showNoticesInIndex(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeService noticeService = new NoticeService();
		List<Notice> notices = noticeService.getNotices();
		List<Notice> showNotices = new ArrayList<Notice>();
		
		if(notices.size()>=4){
			for(int i=0;i<4;i++)
				showNotices.add(notices.get(i));
			request.setAttribute("showNotices", showNotices);
		}else {
			request.setAttribute("showNotices", notices);
		}
		
		return "/index.jsp";
	}
	
	public String noticeDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeService noticeService = new NoticeService();
		String id = request.getParameter("id");
		Notice notice = noticeService.getNotice(id);
		request.setAttribute("notice", notice);
		return "/news_details.jsp";
	}

	
	public String getMyNotice(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeService noticeService = new NoticeService();
		User user = (User) request.getSession().getAttribute("user");
		List<Notice> notices = new ArrayList<Notice>();
		if(user!=null){
			String uid = user.getId();
			notices = noticeService.getMyNotices(uid);
			request.setAttribute("notices", notices);
		}else {
			response.sendRedirect(request.getContextPath()+"/toMemberLogin.html");
			return null;
		}
		return "/user/mynotice.jsp";
	}
}
