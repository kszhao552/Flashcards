package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private EditText ans;
    private TextView num1;
    private TextView num2;
    private TextView operand;
    private Button submit;
    private Button generate;

    private Flashcard flashcard;

    private final String NUMS1 = "nums1";
    private final String NUMS2 = "nums2";
    private final String OPERANDS = "operands";
    private final String CORRECT = "correct";
    private final String COUNT = "count";
    private final String GEN_STATUS = "genStatus";
    private final String SUB_STATUS = "subStatus";
    private final String START = "start";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      flashcard = new Flashcard();

      generate = (Button) findViewById(R.id.generate_name);
      submit = (Button) findViewById(R.id.submit_name);
      num1 = (TextView) findViewById(R.id.num1_name);
      num2 = (TextView) findViewById(R.id.num2_name);
      operand = (TextView) findViewById(R.id.operand_name);
      ans = (EditText) findViewById(R.id.answer_name);

        if (savedInstanceState != null
                && savedInstanceState.getBoolean(START)){
            flashcard.setCount(savedInstanceState.getInt(COUNT));
            flashcard.setCorrect(savedInstanceState.getInt(CORRECT));
            flashcard.setNums1(savedInstanceState.getIntArray(NUMS1));
            flashcard.setNums2(savedInstanceState.getIntArray(NUMS2));
            flashcard.setOperands(savedInstanceState.getCharArray(OPERANDS));
            flashcard.setStart(savedInstanceState.getBoolean(START));

            num1.setText(String.valueOf(flashcard.getNums1(flashcard.getCount())));
            num2.setText(String.valueOf(flashcard.getNums2(flashcard.getCount())));
            operand.setText(String.valueOf(flashcard.getOperands(flashcard.getCount())));
            generate.setEnabled(savedInstanceState.getBoolean(GEN_STATUS));
            submit.setEnabled(savedInstanceState.getBoolean(SUB_STATUS));
        }

      generate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              flashcard.generate();

              num1.setText(String.valueOf(flashcard.getNums1(0)));
              num2.setText(String.valueOf(flashcard.getNums2(0)));
              operand.setText(String.valueOf(flashcard.getOperands(0)));
              ans.getText().clear();
              submit.setEnabled(true);
              generate.setEnabled(false);

          }
      });
      
      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int temp = !ans.getText().toString().matches("") ? Integer.parseInt(ans.getText().toString()) : 0;

              flashcard.validate(temp, flashcard.getOperands(flashcard.getCount()));

              if (flashcard.getCount()==10){
                  Toast.makeText(MainActivity.this, flashcard.getCorrect() + " out of " + flashcard.getCount(), Toast.LENGTH_LONG).show();
                  flashcard.reset();
                  generate.setEnabled(true);
              }

              num1.setText(String.valueOf(flashcard.getNums1(flashcard.getCount())));
              num2.setText(String.valueOf(flashcard.getNums2(flashcard.getCount())));
              operand.setText(String.valueOf(flashcard.getOperands(flashcard.getCount())));
              ans.getText().clear();

          }
      });
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(COUNT, flashcard.getCount());
        outState.putInt(CORRECT, flashcard.getCorrect());
        outState.putIntArray(NUMS1, flashcard.getNums1());
        outState.putIntArray(NUMS2, flashcard.getNums2());
        outState.putCharArray(OPERANDS, flashcard.getOperands());
        outState.putBoolean(GEN_STATUS, generate.isEnabled());
        outState.putBoolean(SUB_STATUS, submit.isEnabled());
        outState.putBoolean(START, flashcard.getStart());

    }
}