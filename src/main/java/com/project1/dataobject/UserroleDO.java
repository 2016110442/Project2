package com.project1.dataobject;

public class UserroleDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_role.role_id
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_role.role_name
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_role.role_info
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    private String roleInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_role.role_id
     *
     * @return the value of user_role.role_id
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_role.role_id
     *
     * @param roleId the value for user_role.role_id
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_role.role_name
     *
     * @return the value of user_role.role_name
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_role.role_name
     *
     * @param roleName the value for user_role.role_name
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_role.role_info
     *
     * @return the value of user_role.role_info
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public String getRoleInfo() {
        return roleInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_role.role_info
     *
     * @param roleInfo the value for user_role.role_info
     *
     * @mbg.generated Sat May 11 09:58:06 CST 2019
     */
    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }
}