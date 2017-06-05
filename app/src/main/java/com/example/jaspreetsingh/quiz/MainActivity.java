package com.example.jaspreetsingh.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    This method is to call when the submit button is clicked
     */
    public void submit(View v)  {
        EditText nameField = (EditText) findViewById(R.id.participant_name);
        String name = nameField.getText().toString();

        String resultMessage = resultSummary(name);

        displayResult(resultMessage);
    }
    /*
    This method create the summary of the result
     */
    public String resultSummary(String name)   {
        String resultMessage = "Name of the Participant is: " + name;
        return resultMessage;
    }

//    public int Question1()  {
//        CheckBox answer1 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_8);
//        Boolean isAnswer1 = answer1.isChecked();
//        return isAnswer1;
//    }
    /*
    This method display the result summary in the TextView
     */
    public void displayResult (String result)    {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(result);

    }

}

