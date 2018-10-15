package com.example.android.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Quiz2 extends AppCompatActivity {

    RadioButton q1_1,q1_2,q2_1,q2_2,q3_1,q3_2,q6_2,q6_1,q7_1,q7_2;
    EditText aSuccessor;
    CheckBox cBoxAction,cBoxCourage,cBoxAbove;

    TextView scoreOne, scoreTwo;

    int quizScore = 0;


    public void checkRadioButtonAnswers() {
        q1_1 = (RadioButton) findViewById(R.id.q1_1);
        q1_2 = (RadioButton) findViewById(R.id.q1_2);
        q2_1 = (RadioButton) findViewById(R.id.q2_1);
        q2_2 = (RadioButton) findViewById(R.id.q2_2);
        q3_1 = (RadioButton) findViewById(R.id.q3_1);
        q3_2 = (RadioButton) findViewById(R.id.q3_2);
        q6_1 = (RadioButton) findViewById(R.id.q6_1);
        q6_2 = (RadioButton) findViewById(R.id.q6_2);
        q7_1 = (RadioButton) findViewById(R.id.q7_1);
        q7_2 = (RadioButton) findViewById(R.id.q7_2);
        boolean q1_1Checked = q1_1.isChecked();
        boolean q2_2Checked = q2_2.isChecked();
        boolean q3_1Checked = q3_1.isChecked();
        boolean q6_1Checked = q6_1.isChecked();
        boolean q7_2Checked = q7_2.isChecked();


        if (q1_1Checked) {
            quizScore += 1;
        }

        if (q2_2Checked) {
            quizScore += 1;
        }

        if (q3_1Checked) {
            quizScore += 1;
        }

        if (q6_1Checked) {
            quizScore += 1;
        }

        if (q7_2Checked) {
            quizScore += 1;
        }

    }


    public String checkEditTextString() {
        EditText aSuccessor = (EditText) findViewById(R.id.aSuccessor);
        String qFourText = aSuccessor.getText().toString();
        if (qFourText.trim().equalsIgnoreCase("a pioneer")){
            quizScore += 1;
            }

        return qFourText;

    }


    private void checkCheckBoxAnswers(){
        cBoxAction = (CheckBox) findViewById(R.id.cBoxAction);
        cBoxCourage = (CheckBox) findViewById(R.id.cBoxCourage);
        cBoxAbove = (CheckBox) findViewById(R.id.cBoxAbove);
        boolean cBoxActionChecked = cBoxAction.isChecked();

        if (cBoxActionChecked) {
            quizScore += 1;
        }

    }


    private void checkAllQuestions(){
        checkRadioButtonAnswers();
        checkEditTextString();
        checkCheckBoxAnswers();
    }



    private void resetCounterCorrectAnswers(){
        quizScore = 0;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);


        final RadioButton q15 = (RadioButton) findViewById(R.id.q15);
        final RadioButton q16 = (RadioButton) findViewById(R.id.q16);
        final Button submit;

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (q15.isChecked()) {
                    Intent Intents = new Intent(Quiz2.this, Result1.class);
                    startActivity(Intents);
                } else if (q16.isChecked()) {
                    Intent Intently = new Intent(Quiz2.this, Result2.class);
                    startActivity(Intently);
                }

                checkAllQuestions();
                Toast.makeText(Quiz2.this, "Correct Answers: " + quizScore + "/6",
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();


            }
        });


    }

}