package com.project1.dao;

import com.project1.dataobject.UserroleinfoDO;

public interface UserroleinfoDOMapper {
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
    int insert(UserroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insertSelective(UserroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    UserroleinfoDO selectByPrimaryKey(Integer roleNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKeySelective(UserroleinfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_info
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKey(UserroleinfoDO record);
}