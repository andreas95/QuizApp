package main.java.com.andreas.quizapp.model;

public class Question {
    private String text;
    private String responseA;
    private String responseB;
    private String responseC;
    private String responseD;
    private String category;
    private char answer;

    public Question() {}

    public Question(String text, String responseA, String responseB, String responseC, String responseD, String category, char answer) {
        this.text = text;
        this.responseA = responseA;
        this.responseB = responseB;
        this.responseC = responseC;
        this.responseD = responseD;
        this.category = category;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public String getResponseA() {
        return responseA;
    }

    public String getResponseB() {
        return responseB;
    }

    public String getResponseC() {
        return responseC;
    }

    public String getResponseD() {
        return responseD;
    }

    public String getCategory() {
        return category;
    }

    public char getAnswer() {
        return answer;
    }
}
