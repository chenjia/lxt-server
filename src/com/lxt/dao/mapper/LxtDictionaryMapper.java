package com.lxt.dao.mapper;

import com.lxt.model.LxtDictionary;
import com.lxt.model.LxtDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LxtDictionaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    long countByExample(LxtDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByExample(LxtDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insert(LxtDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int insertSelective(LxtDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    List<LxtDictionary> selectByExample(LxtDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    LxtDictionary selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") LxtDictionary record, @Param("example") LxtDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByExample(@Param("record") LxtDictionary record, @Param("example") LxtDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKeySelective(LxtDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_dictionary
     *
     * @mbg.generated Thu Jul 13 11:50:24 CST 2017
     */
    int updateByPrimaryKey(LxtDictionary record);
}