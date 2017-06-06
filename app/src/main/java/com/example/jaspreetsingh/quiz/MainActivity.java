package com.example.jaspreetsingh.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
int score = 0;
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

        question1();

        String resultMessage = resultSummary(name);

        displayResult(resultMessage);

        //Disable the button on clicking the button so that user can take test once
        Button endTest = (Button) findViewById(R.id.result_button);
        endTest.setClickable(false);

        // Display the Toast to ask user to take test only once
        Toast toast = Toast.makeText(this, "Test can be taken once", Toast.LENGTH_LONG );
        toast.show();
    }
    /*
    This method create the summary of the result
     */
    public String resultSummary(String name)   {
        String resultMessage = name;
        resultMessage += " score " + score + " out of 5 questions";
        return resultMessage;
    }

    private void question1()  {
        CheckBox answer1 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_8);
        Boolean isAnswer1 = answer1.isChecked();
        CheckBox answer2 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_11);
        Boolean isAnswer2 = answer2.isChecked();
        CheckBox answer3 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_33);
        Boolean isAnswer3 = answer3.isChecked();


        if(isAnswer1 && !isAnswer2 && !isAnswer3 )   {
                score++;
        }
    }


    /*
    This method display the result summary in the TextView
     */
    public void displayResult (String result)    {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(result);

    }

}

