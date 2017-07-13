package com.lxt.dao.mapper;

import com.lxt.model.LxtUser;
import com.lxt.model.LxtUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LxtUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    long countByExample(LxtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByExample(LxtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insert(LxtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insertSelective(LxtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    List<LxtUser> selectByExample(LxtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    LxtUser selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") LxtUser record, @Param("example") LxtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExample(@Param("record") LxtUser record, @Param("example") LxtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKeySelective(LxtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_user
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKey(LxtUser record);
}