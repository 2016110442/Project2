package com.project1.dao;

import com.project1.dataobject.userroleinfoDO;

public interface userroleinfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int deleteByPrimaryKey(Integer roleNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insert(userroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insertSelective(userroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    userroleinfoDO selectByPrimaryKey(Integer roleNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKeySelective(userroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKey(userroleinfoDO record);
}