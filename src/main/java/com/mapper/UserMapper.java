package com.mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.User;
/**
 * �û��ӿ�
 */
public interface UserMapper {
	/**
	 * �����û����������¼
	 * @param userName �˺�
	 * @param userPass ����
	 * @return �û���Ϣ
	 */
	User login(@Param("userName") String userName,@Param("userPass") String userPass);


}
