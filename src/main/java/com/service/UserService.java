package com.service;

import com.entity.User;

public interface UserService {
	/**
	 * �����û����������¼
	 * @param userName �˺�
	 * @param userPass ����
	 * @return �û���Ϣ
	 */
	User login( String userName, String userPass);
}
