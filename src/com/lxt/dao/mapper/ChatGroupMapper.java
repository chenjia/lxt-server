package com.lxt.dao.mapper;

import com.lxt.model.ChatGroup;
import com.lxt.model.ChatGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    long countByExample(ChatGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByExample(ChatGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int deleteByPrimaryKey(String groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insert(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int insertSelective(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    List<ChatGroup> selectByExample(ChatGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    ChatGroup selectByPrimaryKey(String groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExampleSelective(@Param("record") ChatGroup record, @Param("example") ChatGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByExample(@Param("record") ChatGroup record, @Param("example") ChatGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKeySelective(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxt_chat_group
     *
     * @mbg.generated Thu Jul 13 14:57:12 CST 2017
     */
    int updateByPrimaryKey(ChatGroup record);
}