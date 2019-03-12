package com.xdf.exams.bean;



/**
 * Examrecord generated by MyEclipse - Hibernate Tools
 */

public class Examrecord  implements java.io.Serializable {


    // Fields    

	 private Long examrecordid;
     private Result result;
     private Question question;
     private String answer;


    // Constructors

    /** default constructor */
    public Examrecord() {
    }

    
    /** full constructor */
    public Examrecord(Result result, Question question, String answer) {
        this.result = result;
        this.question = question;
        this.answer = answer;
    }

   
    // Property accessors

    public Long getExamrecordid() {
        return this.examrecordid;
    }
    
    public void setExamrecordid(Long examrecordid) {
        this.examrecordid = examrecordid;
    }

    public Result getResult() {
        return this.result;
    }
    
    public void setResult(Result result) {
        this.result = result;
    }

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}