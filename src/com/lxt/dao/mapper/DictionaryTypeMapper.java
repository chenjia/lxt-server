package com.lxt.dao.mapper;

import com.lxt.model.DictionaryType;
import com.lxt.model.DictionaryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    long countByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByPrimaryKey(Integer type);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insert(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insertSelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    List<DictionaryType> selectByExample(DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    DictionaryType selectByPrimaryKey(Integer type);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExampleSelective(@Param("record") DictionaryType record, @Param("example") DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExample(@Param("record") DictionaryType record, @Param("example") DictionaryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKeySelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary_type
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKey(DictionaryType record);
}