package com.mapper;

import java.util.List;

import com.entity.Category;

/**
 * ����
 */
public interface CategoryMapper {
	/**
	 * ��������id,��ѯ���¶�Ӧ����Щ����
	 * 
	 * @param articleId ����id
	 * @return �����б�(ʵ����ֻ����������,��������,�Ӽ�����)
	 */
	List<Category> listCategoryByArticleId(Integer articleId);
	/**
	 * ��ѯ�����б�
	 * 
	 * @return �����б�
	 */
	List<Category> listCategory();

	
	/**
	 * ���ݸ��༶�����id��ѯ�Ӽ������б�,��ʱû����,�Ժ���ܻ���
	 * @param parentId ��������
	 * @return �Ӽ������б�
	 */
	List<Category> listCategoryByParentId(Integer parentId);


}
