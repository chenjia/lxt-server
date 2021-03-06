package com.lxt.dao.mapper;

import com.lxt.model.Organization;
import com.lxt.model.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    long countByExample(OrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByExample(OrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByPrimaryKey(String orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insert(Organization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insertSelective(Organization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    List<Organization> selectByExample(OrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    Organization selectByPrimaryKey(String orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKeySelective(Organization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_organization
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKey(Organization record);
}