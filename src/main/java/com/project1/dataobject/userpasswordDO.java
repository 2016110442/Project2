package com.project1.dataobject;

public class userpasswordDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.user_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    private String userPassword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.user_id
     *
     * @return the value of user_password.user_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.user_id
     *
     * @param userId the value for user_password.user_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.user_password
     *
     * @return the value of user_password.user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.user_password
     *
     * @param userPassword the value for user_password.user_password
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}