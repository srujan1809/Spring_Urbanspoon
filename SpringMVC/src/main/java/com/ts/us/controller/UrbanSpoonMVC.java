package com.ts.us.controller;

import java.io.File;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ts.us.dao.RestaurantDAO;
import com.ts.us.dao.UserDAO;
import com.ts.us.dto.Restaurant;
import com.ts.us.dto.User;

public class UrbanSpoonMVC implements Controller {

	private static final String IMAGESLOCATION = "D:\\TS\\Spring_new\\SpringMVC\\src\\main\\webapp\\images";
	private UserDAO udao;
	private RestaurantDAO rdao;

	public UserDAO getUdao() {
		return udao;
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}

	public RestaurantDAO getRdao() {
		return rdao;
	}

	public void setRdao(RestaurantDAO rdao) {
		this.rdao = rdao;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("h1");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultipart);
		if (isMultipart) {

			ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItemsList;
			try {
				fileItemsList = servletFileUpload.parseRequest(request);
				String action = getFormFeildValue(fileItemsList, "action");
				if (action != null) {
					if (action.equals("restaurant_registration")) {
						if (insertRestaurant(fileItemsList, request, response)) {
							PrintWriter w = response.getWriter();
							w.println("Restaurant added");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("user_registration")) {
					insertUser(request);

				} else if (action.equals("restaurant_registration_form")) {
					insertRestaurant(request);
				}

			}
		}
		return mv;
	}

	private boolean insertRestaurant(List<FileItem> fileItemsList, HttpServletRequest request,
			HttpServletResponse response) {
		Restaurant restaurant = new Restaurant();
		for (FileItem fileItem : fileItemsList) {
			if (fileItem.isFormField()) {
				if (fileItem.getFieldName().equals("govt_reg_id")) {
					restaurant.setGovtRegistrationId(fileItem.getString());
				} else if (fileItem.getFieldName().equals("Name")) {
					restaurant.setName(fileItem.getString());
				} else if (fileItem.getFieldName().equals("rest_password")) {
					restaurant.setPassword(fileItem.getString());
				}
			}
		}
		restaurant = rdao.set(restaurant);
		if (restaurant.getId() != 0) {
			for (FileItem fileItem : fileItemsList) {

				storeImage(fileItem, "restaurants", restaurant.getId() + ".jpg");
				rdao.updateLogoAddress(restaurant.getId() + ".jpg", restaurant.getId());
			}
			return true;
		}
		return false;
	}

	private boolean storeImage(FileItem fileItem, String imageType, String fileName) {

		if (null != fileItem) {
			try {
				String filePath = IMAGESLOCATION + "\\" + imageType + "\\" + fileName;
				fileItem.write(new File(filePath));
				return true;
			} catch (Exception e) {
			}
		}
		return false;
	}

	public String getFormFeildValue(List<FileItem> fileItemsList, String fieldName) {
		if (fileItemsList != null) {
			for (FileItem fileItem : fileItemsList) {
				if (fileItem.getFieldName().equals(fieldName)) {
					return fileItem.getString();
				}
			}
		}
		return null;
	}

	private void insertRestaurant(HttpServletRequest request) {
		Restaurant r = new Restaurant();
		r.setGovtRegistrationId(request.getParameter("govt_reg_id"));
		r.setName(request.getParameter("Name"));
		r.setPassword(request.getParameter("rest_password"));

		rdao.set(r);
	}

	private void insertUser(HttpServletRequest request) {
		String uname = request.getParameter("firstName") + " " + request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String pswd = request.getParameter("password");
		String dt = request.getParameter("date");
		String mno = request.getParameter("mobileNumber");

		User u = new User();
		u.setName(uname);
		u.setGender(gender);
		u.setEmail(email);
		u.setPassword(pswd);
		u.setDate(Date.valueOf(dt));
		;
		u.setMobileNo(Long.parseLong(mno));
		udao.save(u);
		System.out.println("user registered ");
	}

}