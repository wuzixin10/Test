package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Comment;
import com.mapper.CommentMapper;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;
	
	public List<Comment> listRecentComment(Integer n) {
		return commentMapper.listRecentComment(n);
	}
}

