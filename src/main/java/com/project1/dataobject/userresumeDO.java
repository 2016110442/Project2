package com.project1.dataobject;

public class userresumeDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resume.resume_no
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    private Integer resumeNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resume.user_id
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_resume.event
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    private String event;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resume.resume_no
     *
     * @return the value of user_resume.resume_no
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public Integer getResumeNo() {
        return resumeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resume.resume_no
     *
     * @param resumeNo the value for user_resume.resume_no
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public void setResumeNo(Integer resumeNo) {
        this.resumeNo = resumeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resume.user_id
     *
     * @return the value of user_resume.user_id
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resume.user_id
     *
     * @param userId the value for user_resume.user_id
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_resume.event
     *
     * @return the value of user_resume.event
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public String getEvent() {
        return event;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_resume.event
     *
     * @param event the value for user_resume.event
     *
     * @mbg.generated Thu May 02 10:13:39 CST 2019
     */
    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }
}