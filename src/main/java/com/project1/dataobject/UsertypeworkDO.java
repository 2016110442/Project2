package com.project1.dataobject;

public class UsertypeworkDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_typework.word_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    private Integer wordId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_typework.word
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    private String word;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_typework.word_id
     *
     * @return the value of user_typework.word_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public Integer getWordId() {
        return wordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_typework.word_id
     *
     * @param wordId the value for user_typework.word_id
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_typework.word
     *
     * @return the value of user_typework.word
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public String getWord() {
        return word;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_typework.word
     *
     * @param word the value for user_typework.word
     *
     * @mbg.generated Tue Apr 23 09:17:39 CST 2019
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }
}