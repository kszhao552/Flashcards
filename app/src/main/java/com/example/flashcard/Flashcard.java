package com.example.flashcard;

public class Flashcard {
    private int n = 10;
    private int[] nums1 = new int[n];
    private int[] nums2 = new int[n];
    private char[] operands = new char[n];

    private int count = 0;
    private int correct = 0;

    public void reset() {
        count=0;
        correct=0;
    }

    public void generate() {
        for (int i=0;i<n;i++ ){
            nums1[i] = (int)(Math.random()*99+1);
            nums2[i] = (int)(Math.random()*20+1);

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

    public boolean validate(int submission, char operand){
        int ans;
        switch (operand){
            case '-':
                ans = getNums1(count) - getNums2(count);
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
