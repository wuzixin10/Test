package com.service;

import java.util.List;

import com.entity.Comment;

/**
 * ����
 */
public interface CommentService {
	/**
	 * ��ѯ�����n������
	 * @param n ����
	 * @return  �б�
	 */
	List<Comment> listRecentComment(Integer n);
}		
