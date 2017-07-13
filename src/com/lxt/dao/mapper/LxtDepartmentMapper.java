package com.lxt.dao.mapper;

import com.lxt.model.LxtDepartment;
import com.lxt.model.LxtDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LxtDepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    long countByExample(LxtDepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByExample(LxtDepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insert(LxtDepartment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insertSelective(LxtDepartment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    List<LxtDepartment> selectByExample(LxtDepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    LxtDepartment selectByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") LxtDepartment record, @Param("example") LxtDepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExample(@Param("record") LxtDepartment record, @Param("example") LxtDepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKeySelective(LxtDepartment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_department
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKey(LxtDepartment record);
}