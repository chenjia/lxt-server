package com.lxt.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.USERNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.PASSWORD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.REALNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.ORG_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String orgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.DEPT_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.INSERT_USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String insertUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.INSERT_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.UPDATE_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.LOGIN_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date loginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.SET_QUESTION
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Integer setQuestion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.UPDATE_QUESTION_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date updateQuestionTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.UPDATE_PWD_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date updatePwdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.PWD_STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Integer pwdStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.MOBILE
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.EMAIL
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.QQ
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String qq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.BIRTHDAY
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.GENDER
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lxt_user.IDENTITY_CARD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    private String identityCard;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.USER_ID
     *
     * @return the value of lxt_user.USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.USER_ID
     *
     * @param userId the value for lxt_user.USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.USERNAME
     *
     * @return the value of lxt_user.USERNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.USERNAME
     *
     * @param username the value for lxt_user.USERNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.PASSWORD
     *
     * @return the value of lxt_user.PASSWORD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.PASSWORD
     *
     * @param password the value for lxt_user.PASSWORD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.REALNAME
     *
     * @return the value of lxt_user.REALNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.REALNAME
     *
     * @param realname the value for lxt_user.REALNAME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.ORG_ID
     *
     * @return the value of lxt_user.ORG_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.ORG_ID
     *
     * @param orgId the value for lxt_user.ORG_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.DEPT_ID
     *
     * @return the value of lxt_user.DEPT_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.DEPT_ID
     *
     * @param deptId the value for lxt_user.DEPT_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.STATUS
     *
     * @return the value of lxt_user.STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.STATUS
     *
     * @param status the value for lxt_user.STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.INSERT_USER_ID
     *
     * @return the value of lxt_user.INSERT_USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getInsertUserId() {
        return insertUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.INSERT_USER_ID
     *
     * @param insertUserId the value for lxt_user.INSERT_USER_ID
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId == null ? null : insertUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.INSERT_TIME
     *
     * @return the value of lxt_user.INSERT_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.INSERT_TIME
     *
     * @param insertTime the value for lxt_user.INSERT_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.UPDATE_TIME
     *
     * @return the value of lxt_user.UPDATE_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.UPDATE_TIME
     *
     * @param updateTime the value for lxt_user.UPDATE_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.LOGIN_TIME
     *
     * @return the value of lxt_user.LOGIN_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.LOGIN_TIME
     *
     * @param loginTime the value for lxt_user.LOGIN_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.SET_QUESTION
     *
     * @return the value of lxt_user.SET_QUESTION
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Integer getSetQuestion() {
        return setQuestion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.SET_QUESTION
     *
     * @param setQuestion the value for lxt_user.SET_QUESTION
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setSetQuestion(Integer setQuestion) {
        this.setQuestion = setQuestion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.UPDATE_QUESTION_TIME
     *
     * @return the value of lxt_user.UPDATE_QUESTION_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getUpdateQuestionTime() {
        return updateQuestionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.UPDATE_QUESTION_TIME
     *
     * @param updateQuestionTime the value for lxt_user.UPDATE_QUESTION_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setUpdateQuestionTime(Date updateQuestionTime) {
        this.updateQuestionTime = updateQuestionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.UPDATE_PWD_TIME
     *
     * @return the value of lxt_user.UPDATE_PWD_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getUpdatePwdTime() {
        return updatePwdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.UPDATE_PWD_TIME
     *
     * @param updatePwdTime the value for lxt_user.UPDATE_PWD_TIME
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setUpdatePwdTime(Date updatePwdTime) {
        this.updatePwdTime = updatePwdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.PWD_STATUS
     *
     * @return the value of lxt_user.PWD_STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Integer getPwdStatus() {
        return pwdStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.PWD_STATUS
     *
     * @param pwdStatus the value for lxt_user.PWD_STATUS
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setPwdStatus(Integer pwdStatus) {
        this.pwdStatus = pwdStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.MOBILE
     *
     * @return the value of lxt_user.MOBILE
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.MOBILE
     *
     * @param mobile the value for lxt_user.MOBILE
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.EMAIL
     *
     * @return the value of lxt_user.EMAIL
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.EMAIL
     *
     * @param email the value for lxt_user.EMAIL
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.QQ
     *
     * @return the value of lxt_user.QQ
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.QQ
     *
     * @param qq the value for lxt_user.QQ
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.BIRTHDAY
     *
     * @return the value of lxt_user.BIRTHDAY
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.BIRTHDAY
     *
     * @param birthday the value for lxt_user.BIRTHDAY
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.GENDER
     *
     * @return the value of lxt_user.GENDER
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.GENDER
     *
     * @param gender the value for lxt_user.GENDER
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lxt_user.IDENTITY_CARD
     *
     * @return the value of lxt_user.IDENTITY_CARD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lxt_user.IDENTITY_CARD
     *
     * @param identityCard the value for lxt_user.IDENTITY_CARD
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }
}