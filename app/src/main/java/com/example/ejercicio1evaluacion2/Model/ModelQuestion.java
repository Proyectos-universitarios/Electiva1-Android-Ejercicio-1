package com.example.ejercicio1evaluacion2.Model;

// Modelo creado para guardar informacion de las preguntas
public class ModelQuestion {
    private int Idquestion;
    private int Numberquestion;
    private String Namequestion;
    private String AnswerText1;
    private String AnswerText2;
    private String AnswerText3;
    private int AnswerIdValue;


    public int getAnswerIdValue() {
        return AnswerIdValue;
    }

    public void setAnswerIdValue(int answerIdValue) {
        AnswerIdValue = answerIdValue;
    }

    public int getIdquestion() {
        return Idquestion;
    }

    public void setIdquestion(int idquestion) {
        Idquestion = idquestion;
    }

    public int getNumberquestion() {
        return Numberquestion;
    }

    public void setNumberquestion(int numberquestion) {
        Numberquestion = numberquestion;
    }

    public String getNamequestion() {
        return Namequestion;
    }

    public void setNamequestion(String namequestion) {
        Namequestion = namequestion;
    }

    public String getAnswerText1() {
        return AnswerText1;
    }

    public void setAnswerText1(String answerText1) {
        AnswerText1 = answerText1;
    }

    public String getAnswerText2() {
        return AnswerText2;
    }

    public void setAnswerText2(String answerText2) {
        AnswerText2 = answerText2;
    }

    public String getAnswerText3() {
        return AnswerText3;
    }

    public void setAnswerText3(String answerText3) {
        AnswerText3 = answerText3;
    }

}

