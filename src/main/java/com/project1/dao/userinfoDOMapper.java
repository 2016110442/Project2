package com.project1.dao;

import com.project1.dataobject.userinfoDO;
import com.project1.service.model.UserModel;

public interface userinfoDOMapper {

    userinfoDO findByUserName(Integer user_id);

    userinfoDO selectByPhone(String phone);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insert(userinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insertSelective(userinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    userinfoDO selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKeySelective(userinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKey(userinfoDO record);
}