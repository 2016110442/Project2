package com.project1.dao;

import com.project1.dataobject.userunitDO;

public interface userunitDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int deleteByPrimaryKey(Integer unitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insert(userunitDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int insertSelective(userunitDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    userunitDO selectByPrimaryKey(Integer unitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKeySelective(userunitDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_unit
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    int updateByPrimaryKey(userunitDO record);
}