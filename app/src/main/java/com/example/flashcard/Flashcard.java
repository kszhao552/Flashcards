package com.example.flashcard;

import android.util.Log;

public class Flashcard {
    private int n = 10;
    private int[] nums1 = new int[n];
    private int[] nums2 = new int[n];
    private char[] operands = new char[n];

    private int count = 0;
    private int correct = 0;
    private boolean start = false;

    public void reset() {
        count=0;
        correct=0;
    }

    public void generate() {
        for (int i=0;i<n;i++ ){
            nums1[i] = (int)(Math.random()*99+1);
            nums2[i] = (int)(Math.random()*20+1);
            start = true;

            switch ((int)(Math.random()*2)) {
                case 1:
                    operands[i]='-';
                    break;
                default:
                    operands[i]='+';
                    break;
            }
        }

        reset();
    }

    public int[] getNums1(){
        return nums1;
    }

    public int[] getNums2(){
        return nums2;
    }

    public char[] getOperands(){
        return operands;
    }

    public boolean getStart(){
        return start;
    }

    public int getNums1(int i){
        try {
            return nums1[i];
        } catch (Exception e) {
            return 0;
        }
    }

    public int getNums2(int i){
        try {
            return nums2[i];
        } catch (Exception e) {
            return 0;
        }
    }

    public char getOperands(int i){
        try {
            return operands[i];
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCount(){
        return count;
    }

    public int getCorrect(){
        return correct;
    }

    public void setNums1(int[] arr){
        this.nums1=arr;
    }

    public void setNums2(int[] arr){
        this.nums2=arr;
    }

    public void setOperands(char[] arr){
        this.operands=arr;
    }

    public void setCount(int i){
        this.count=i;
    }

    public void setCorrect(int i){
        this.correct=i;
    }

    public void setStart(boolean b){
        this.start =b;
    }

    public boolean validate(int submission, char operand){
        int ans;
        switch (operand){
            case '-':
                ans = getNums1(count) - getNums2(count);
                break;
            default:
                ans = getNums1(count) + getNums2(count);
        }
        if (submission==ans){
            correct++;
        }
        count++;

        return submission==ans;
    }
}
