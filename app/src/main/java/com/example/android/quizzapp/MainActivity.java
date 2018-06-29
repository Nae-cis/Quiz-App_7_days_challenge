package com.example.android.quizzapp;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    boolean answerQuest = false;
    boolean answerQuestOne = false;
    boolean answerQuesttwo = false;
    boolean answerQuestthree = false;
    boolean answerQuestFour = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void submitOrderOne(View view) {
        CheckBox gyroCheckBox = (CheckBox) findViewById(R.id.gyro_checkbox);
        boolean isgyrometerCheckBox = gyroCheckBox.isChecked();

        CheckBox hydroCheckbox = (CheckBox) findViewById(R.id.hydro_checkbox);
        boolean isHydroCheckBox = hydroCheckbox.isChecked();
        CheckBox thermoCheckBox = (CheckBox) findViewById(R.id.thermo_checkbox);
        boolean isthermoCheckBox = thermoCheckBox.isChecked();

        calculateWin(isgyrometerCheckBox, isHydroCheckBox, isthermoCheckBox);
    }

    public void submitOrderTwo(View view) {
        CheckBox camelCheckBox = (CheckBox) findViewById(R.id.camel_checkbox);
        boolean isCamCheckBox = camelCheckBox.isChecked();
        CheckBox tigerCheckBox = (CheckBox) findViewById(R.id.tiger_checkbox);
        boolean isTigerCheckBox = tigerCheckBox.isChecked();
        CheckBox dogCheckBox = (CheckBox) findViewById(R.id.dog_checkbox);
        boolean isdogCheckBox = dogCheckBox.isChecked();
        calculateTwo(isCamCheckBox, isTigerCheckBox, isdogCheckBox);
    }

    public void submitOrderThree(View view) {
        CheckBox hydrosphereCheckBox = (CheckBox) findViewById(R.id.hydrosphere_checkbox);
        boolean isHydroSphere = hydrosphereCheckBox.isChecked();
        CheckBox atomCheckBox = (CheckBox) findViewById(R.id.atom_checkbox);
        boolean isAtomCheckBox = atomCheckBox.isChecked();
        CheckBox upperCheckBox = (CheckBox) findViewById(R.id.upper_checkbox);
        boolean isUpperCheckBox = upperCheckBox.isChecked();
        calculateThree(isHydroSphere, isAtomCheckBox, isUpperCheckBox);
    }

    //To make the buttons work and collect checked input for question five
    public void submitOrderFour(View view) {
        CheckBox indiaCheckBox = (CheckBox) findViewById(R.id.india_checkbox);
        boolean isIndiaCheckBox = indiaCheckBox.isChecked();
        CheckBox botCheckBox = (CheckBox) findViewById(R.id.botswana_checkbox);
        boolean isBotCheckBox = botCheckBox.isChecked();
        CheckBox chileCheckBox = (CheckBox) findViewById(R.id.chile_checkbox);
        boolean isChileCheckBox = chileCheckBox.isChecked();
        calculateFour(isIndiaCheckBox, isBotCheckBox, isChileCheckBox);
    }

    //To make the buttons work and collect input for question six
    public void submitOrderFive(View view) {


        CheckBox digCheckBox = (CheckBox) findViewById(R.id.dig_checkBox);
        boolean isDigCheckBox = digCheckBox.isChecked();
        CheckBox photoCheckBox = (CheckBox) findViewById(R.id.photo_checkbox);
        boolean isPhotoCheckBox = photoCheckBox.isChecked();
        CheckBox excreteCheckBox = (CheckBox) findViewById(R.id.excrete_checkBox);
        boolean isexcreteCheckBox = excreteCheckBox.isChecked();
        calculateFive(isDigCheckBox, isPhotoCheckBox, isexcreteCheckBox);
    }


    public void submitOrder(View view) {
        //To get the name of the person taking the quiz
        TextView nameTextView = (TextView) findViewById(R.id.name_input);
        String mane = nameTextView.getText().toString();
        //To get the answer to question 4
        TextView editText = (TextView) findViewById(R.id.answer_quest);
        String message = editText.getText().toString();



         //put the collected value in an array
        String[] answers = getResult(message);
        int result = evalQuiz(answers);
        //show result in a toast message
        toastResult(result, mane);

    }


    //To get Result and convert to String
    public String[] getResult(String message) {
        String[] ret = new String[7];
        ret[0] = Boolean.toString(answerQuest);
        ret[1] = Boolean.toString(answerQuestOne);
        ret[2] = Boolean.toString(answerQuesttwo);
        ret[3] = message.toLowerCase();
        ret[4] = Boolean.toString(answerQuestthree);
        ret[5] = Boolean.toString(answerQuestFour);
        ret[6] = evaluateRadioGroup(R.id.radioCorrect).toLowerCase();

        return ret;
    }

    //To calculate Result
    public int evalQuiz(String[] answers) {
        int result = 0;

        String[] correctAnswers = {"true", "true", "true", "the earth goes around the sun", "true", "true","yes" };
        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }
        return result;
    }

    //Code to show Results
    public void toastResult(int result, String mane) {


        String message =  "You got" + result + " out of 7";

        if (result == 0) {
            message += "\nTry Again\n   " + mane;
        } else if (result == 1) {
            message += "\nyou could do better\n   " + mane;
        } else if (result == 2) {
            message += "\nAverage score\n  " + mane;
        } else if (result == 3) {
            message += "\nGood\n  " + mane;

        } else if (result == 4) {
            message += "\nGreat\n  " + mane;
        } else if (result == 5) {
            message += "\nAwesome\n  " + mane;
        } else if (result == 6) {
            message += "\nYayy\n   " + mane;
        } else if (result == 7) {
            message += "\nAmazing\n" + mane;
        }
        Toast showResult = Toast.makeText(this, message, Toast.LENGTH_LONG);
        showResult.show();

    }


    //For question one
    public void calculateWin(boolean hasgyrometerCheckBox, boolean hasHydroCheckBox, boolean hasThermoCheckBox) {

        if (hasThermoCheckBox && !hasgyrometerCheckBox && !hasHydroCheckBox) {
            answerQuest = true;
        } else if (hasgyrometerCheckBox && hasHydroCheckBox) {
            answerQuest = false;
            Toast.makeText(this, "You picked two options, pick again ", Toast.LENGTH_SHORT).show();
        } else if (hasgyrometerCheckBox && hasThermoCheckBox) {
            answerQuest = false;
            Toast.makeText(this, "You picked two options, pick again ", Toast.LENGTH_SHORT).show();
        } else if (!hasgyrometerCheckBox && !hasHydroCheckBox && !hasThermoCheckBox) {
            Toast.makeText(this, "You did not pick any option ", Toast.LENGTH_SHORT).show();
            answerQuest = false;
        }


    }

    //For question two
    public void calculateTwo(boolean hasCamelCheckBox, boolean hasTigerCheckBox, boolean hasDogCheckBox) {

        if (hasCamelCheckBox & !hasTigerCheckBox && !hasDogCheckBox) {
            answerQuestOne = true;
        } else if (hasCamelCheckBox && hasTigerCheckBox) {
            answerQuestOne = false;
            Toast.makeText(this, "You picked two options, pick again", Toast.LENGTH_SHORT).show();
        } else if (hasDogCheckBox && hasTigerCheckBox) {
            Toast.makeText(this, "You picked two options, pick again ", Toast.LENGTH_SHORT).show();
            answerQuestOne = false;
        } else if (!hasCamelCheckBox && !hasDogCheckBox && !hasTigerCheckBox) {
            answerQuestOne = false;
            Toast.makeText(this, "You did not pick any option ", Toast.LENGTH_SHORT).show();
        }

    }

    //For question three
    public void calculateThree(boolean hasHydrosphereCheckBox, boolean hasAtomCheckBox, boolean hasUpperCheckBox) {

        if (hasAtomCheckBox && !hasHydrosphereCheckBox && !hasUpperCheckBox) {
            answerQuesttwo = true;
        } else if (hasAtomCheckBox && hasHydrosphereCheckBox) {
            answerQuesttwo = false;
            Toast.makeText(this, "You picked two options, pick again", Toast.LENGTH_SHORT).show();
        } else if (hasUpperCheckBox && hasHydrosphereCheckBox) {
            answerQuesttwo = false;
            Toast.makeText(this, "You picked two options, pick again", Toast.LENGTH_SHORT).show();
        } else if (!hasAtomCheckBox && !hasHydrosphereCheckBox && !hasUpperCheckBox) {
            Toast.makeText(this, "You did not pick any option  ", Toast.LENGTH_SHORT).show();
            answerQuesttwo = false;
        }
    }


    //For question five
    public void calculateFour(boolean hasIndia, boolean hasBotswana, boolean hasChile) {
        if (hasBotswana && !hasChile && !hasIndia) {
            answerQuestthree = true;
        } else if (hasChile && hasIndia) {
            answerQuestthree = false;
            Toast.makeText(this, "You picked two options, pick again", Toast.LENGTH_SHORT).show();
        } else if (hasBotswana && hasIndia) {
            answerQuestthree = false;
            Toast.makeText(this, "You picked two options, pick again", Toast.LENGTH_SHORT).show();
        } else if (!hasBotswana && !hasChile && !hasIndia) {
            answerQuestthree = false;
            Toast.makeText(this, "You did not pick any option ", Toast.LENGTH_SHORT).show();
        }

    }

    //For question six
    public void calculateFive(boolean hasDigestion, boolean hasPhotosynthesis, boolean hasExcretion) {

        if (hasPhotosynthesis && !hasDigestion && !hasExcretion) {
            answerQuestFour = true;
        } else if (hasDigestion && hasExcretion) {
            answerQuestFour = false;
            Toast.makeText(this, "You can't pick two options ", Toast.LENGTH_SHORT).show();
        } else if (hasPhotosynthesis && hasExcretion) {
            answerQuestFour = false;
            Toast.makeText(this, "You can't pick two options ", Toast.LENGTH_SHORT).show();
        } else if (hasDigestion || hasExcretion) {
            answerQuestFour = false;

        } else if (!hasDigestion && !hasExcretion && !hasPhotosynthesis) {
            Toast.makeText(this, "You did not pick any option", Toast.LENGTH_SHORT).show();
        }

    }
    //To know the radio button that is checked and get the string
    private String evaluateRadioGroup(int id) {
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonQuestion;

        radioGroupQuestion = findViewById(id);

        int radioButtonId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonQuestion = findViewById(radioButtonId);

        if (radioButtonQuestion == null) {
            return "";
        }

        return (String)radioButtonQuestion.getText();
    }






}












