package com.mapper;

import java.util.List;

import com.entity.Comment;

/**
 * ���� ������
 */
public interface CommentMapper {
	/**
	 * ��ѯ�����n������
	 * @param n ����
	 * @return  �б�
	 */
	List<Comment> listRecentComment(Integer n);
}
