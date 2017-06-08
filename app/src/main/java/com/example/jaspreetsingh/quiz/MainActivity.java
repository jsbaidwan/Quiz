package com.example.jaspreetsingh.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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
        question2();
        question3();
        question4();

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
    /*
    * Fetch the input of question 1 and counter the correct answer
    * Which of the following is the prime number?
     */
    private void question1()  {
        //figure out if user choose answer 1 i.e. 8
        CheckBox answer1 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_8);
        Boolean isAnswer1 = answer1.isChecked();
        //figure out if user choose answer 2 i.e. 11
        CheckBox answer2 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_11);
        Boolean isAnswer2 = answer2.isChecked();
        //figure our if user choose answer 3 i.e. 33
        CheckBox answer3 = (CheckBox) findViewById(R.id.mcq_prime_number_answer_33);
        Boolean isAnswer3 = answer3.isChecked();

        if(!isAnswer1 && isAnswer2 && !isAnswer3 )   {
                score++;
        }
    }
    /*
    * Fetch the input of question 2 and counter the correct answer
    * For which of the following disciplines Noble Prize is awarded?
     */
    private void question2()  {
        //figure out if user choose answer 1 i.e. Physics
        CheckBox answer1 = (CheckBox) findViewById(R.id.mcq_noble_prize_answer_physics);
        Boolean isAnswer1 = answer1.isChecked();
        //figure out if user choose answer 2 i.e. Chemistry
        CheckBox answer2 = (CheckBox) findViewById(R.id.mcq_noble_prize_answer_chemistry);
        Boolean isAnswer2 = answer2.isChecked();
        //figure our if user choose answer 3 i.e. Computers
        CheckBox answer3 = (CheckBox) findViewById(R.id.mcq_noble_prize_answer_computer);
        Boolean isAnswer3 = answer3.isChecked();

        //Check id selected answer is correct
        if(isAnswer1 && isAnswer2 && !isAnswer3 )   {
            score++;
        }
    }
    /*
    * Fetch the input of question 3 and counter the correct answer
    * Who is founder of Android?
     */
    private void question3() {
        //figure out if user choose answer 1 i.e. Andy Rubin
        RadioButton answer1 = (RadioButton) findViewById(R.id.rb_android_founder_answer_rubin);
        Boolean isAnswer1 = answer1.isChecked();

        //Check if selected answer is correct
        if (isAnswer1 ) {
            score++;
        }
    }
    /*
    * Fetch the input of question 4 and counter the correct answer
    * In which year Neil Armstrong became the first perosn to land on Moon?
     */
    private void question4() {
        //figure out if user choose answer 1 i.e. 1969
        RadioButton answer1 = (RadioButton) findViewById(R.id.rb_first_on_moon_year_answer_l969);
        Boolean isAnswer1 = answer1.isChecked();

        //Check if selected answer is correct
        if (isAnswer1 ) {
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

