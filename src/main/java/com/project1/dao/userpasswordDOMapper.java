package com.project1.dao;

import com.project1.dataobject.userpasswordDO;

public interface userpasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insert(userpasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insertSelective(userpasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    userpasswordDO selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKeySelective(userpasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKey(userpasswordDO record);
}