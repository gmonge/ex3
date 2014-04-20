/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uia.is12.domain;

/**
 *
 * @author Vera
 */
public class Verse {
    
    private String paragraph;
    private int readingTime;

    public Verse() {
    }

    public Verse(String paragraph, int readingTime) {
        this.paragraph = paragraph;
        this.readingTime = readingTime;
    }

    /**
     * @return the paragraph
     */
    public String getParagraph() {
        return paragraph;
    }

    /**
     * @param paragraph the paragraph to set
     */
    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    /**
     * @return the readingTime
     */
    public int getReadingTime() {
        return readingTime;
    }

    /**
     * @param readingTime the readingTime to set
     */
    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }
    
    

}
