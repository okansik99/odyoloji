package com.okanisik.odyoloji;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class vestibuleriki extends AppCompatActivity {



    private TextView optionA,optionB,optionC,optionD;
    private TextView questionnumber,question,score;
    private TextView chechkout1,checkout2;
    int currentIndex;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;


    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;




    private answerclass[] questionBank= new answerclass[]
            {
                    new answerclass(R.string.question_1V1,R.string.question1_AV1,R.string.question1_BV1,R.string.question1_CV1,R.string.question1_DV1,R.string.answer_1V1),
                    new answerclass(R.string.question_2V1,R.string.question1_2AV1,R.string.question1_2BV1,R.string.question1_2CV1,R.string.question1_2DV1,R.string.answer_2V1),
                    new answerclass(R.string.question_3V1,R.string.question1_3AV1,R.string.question1_3BV1,R.string.question1_3CV1,R.string.question1_3DV1,R.string.answer_3V1),
                    new answerclass(R.string.question_4V1,R.string.question1_4AV1,R.string.question1_4BV1,R.string.question1_4CV1,R.string.question1_4DV1,R.string.answer_4V1),
                    new answerclass(R.string.question_5V1,R.string.question1_5AV1,R.string.question1_5BV1,R.string.question1_5CV1,R.string.question1_5DV1,R.string.answer_5V1),
                    new answerclass(R.string.question_6V1,R.string.question1_6AV1,R.string.question1_6BV1,R.string.question1_6CV1,R.string.question1_6DV1,R.string.answer_6V1),
                    new answerclass(R.string.question_7V1,R.string.question1_7AV1,R.string.question1_7BV1,R.string.question1_7CV1,R.string.question1_7DV1,R.string.answer_7V1),
                    new answerclass(R.string.question_8V1,R.string.question1_8AV1,R.string.question1_8BV1,R.string.question1_8CV1,R.string.question1_8DV1,R.string.answer_8V1),





            };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vestibuleriki);



        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);


        question =findViewById(R.id.qestion);
        score = findViewById(R.id.score);
        questionnumber = findViewById(R.id.QestionNumber);


        chechkout1 =findViewById(R.id.selectoption);
        checkout2 =findViewById(R.id.CorrectAnswer);
        progressBar=findViewById(R.id.progress_bar);


        CurrentQuestion = questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionA);
                updateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionB);
                updateQuestion();

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionC);
                updateQuestion();

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionD);
                updateQuestion();

            }
        });





    }

    private void checkAnswer(int userSelection) {

        int correctanswer =questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= chechkout1.getText().toString().trim();
        String n= checkout2.getText().toString().trim();

        if (m.equals(n))
        {
            Toast.makeText(getApplicationContext(),"Doğru",Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Yanlış",Toast.LENGTH_SHORT).show();
        }

    }

    private void updateQuestion() {


        currentIndex = (currentIndex+1)%questionBank.length;


        if (currentIndex==0)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Oyun Bitti");
            alert.setCancelable(false);
            alert.setMessage("Sonuç " + mscore + " puan");
            alert.setPositiveButton("Ekranı Kapat", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            alert.setNegativeButton("Başla", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Puan: " + mscore + "/" +questionBank.length);
                    questionnumber.setText(qn + "/" + questionBank.length + " Soru");


                }
            });

            alert.show();

        }




        CurrentQuestion = questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn=qn+1;

        if (qn<=questionBank.length)

        {

            questionnumber.setText(qn + "/" + questionBank.length + " Soru");
        }
        score.setText("Puan: " + mscore + "/" +questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);




    }
}