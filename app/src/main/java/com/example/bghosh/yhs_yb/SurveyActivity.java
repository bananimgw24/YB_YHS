package com.example.bghosh.yhs_yb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by bghosh on 12/15/2016.
 */

public class SurveyActivity extends AppCompatActivity {


    Button doneB;
    String userInput="";
    String fileN = "";

    TextView textView1;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioGroup rg;

    TextView textView2;
    EditText compName;
    EditText date;
    EditText addr;
    EditText eid;
    EditText pno;
    EditText area;


    TextView textView3;
    TextView tvp1;
    EditText etp1;
    TextView tvp2;
    EditText etp2;
    TextView tvp3;
    EditText etp3;
    TextView tvp4;
    EditText etp4;
    TextView tvp5;
    EditText etp5;
    EditText other3;


    TextView textView4;
    EditText editText4;

    TextView textView5;
    TextView tvp6;
    EditText etp6;
    TextView tvp7;
    EditText etp7;
    TextView tvp8;
    EditText etp8;
    TextView tvp9;
    EditText etp9;
    TextView tvp10;
    EditText etp10;
    EditText other5;

    TextView textView6;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    CheckBox cb5;
    CheckBox cb6;

//    TextView tvp11;
//    EditText etp11;
//    TextView tvp12;
//    EditText etp12;
//    TextView tvp13;
//    EditText etp13;
//    TextView tvp14;
//    EditText etp14;
//    TextView tvp15;
//    EditText etp15;
//    TextView tvp16;
//    EditText etp16;
//    EditText other6;



    TextView textView7;
    RadioButton r4;
    RadioButton r5;
    RadioButton r6;
    RadioGroup rg2;

    TextView textView8;
    EditText editText8;

    int count=0;

;

    public Boolean isValidEmail(String eid) {
        return Boolean.valueOf(Patterns.EMAIL_ADDRESS.matcher(eid).matches());
    }

    private Boolean isValidMobile(String phone) {
        Boolean flag = Boolean.valueOf(false);
        System.out.println(phone);
        if (phone.length() != 10) {
            return flag;
        }
        if (phone.startsWith("9") || phone.startsWith("8") || phone.startsWith("7")) {
            return Boolean.valueOf(true);
        }
        return flag;
    }


    private Boolean isCheckBoxValid(){
        int count=0;

        if(this.cb1.isChecked())
            count++;
        if(this.cb2.isChecked())
            count++;
        if(this.cb3.isChecked())
            count++;
        if(this.cb4.isChecked())
            count++;
        if(this.cb5.isChecked())
            count++;
        if(this.cb6.isChecked())
            count++;

        if(count > 3 | count < 1)
            return false;
        else
            return true;
    }

    public String getSurveyInfo(){

        String userText="";

        if(compName.getText() != null)
            userText += compName.getText().toString() + "^";
        if(date.getText() != null)
            userText += date.getText().toString() + "^";
        if(addr.getText() != null)
            userText += addr.getText().toString() + "^";
        if(eid.getText() != null)
            userText += eid.getText().toString() + "^";
        if(pno.getText() != null)
            userText += pno.getText().toString() + "^";
        if(area.getText() != null)
            userText += area.getText().toString() + "^";

//        userText += textView3.getText().toString() + "^";
//        userText += tvp1.getText().toString() + "^";
        if(etp1.getText() == null || etp1.getText().toString().equalsIgnoreCase("")) {
            System.out.println("I am not provided");
            userText += "0^";
        }else
            userText += etp1.getText().toString() + "^";
//        userText += tvp2.getText().toString() + "^";
        if(etp2.getText() == null || etp2.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp2.getText().toString() + "^";
//        userText += tvp3.getText().toString() + "^";
        if(etp3.getText() == null || etp3.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp3.getText().toString() + "^";
//        userText += tvp4.getText().toString() + "^";
        if(etp4.getText() == null || etp4.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp4.getText().toString() + "^";
//        userText += tvp5.getText().toString() + "^";
        if(etp5.getText() == null || etp5.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp5.getText().toString() + "^";
        if(other3 != null)
            userText += other3.getText().toString() + "^";


//        userText += textView4.getText().toString() + "^";
        if(editText4.getText() != null)
            userText += editText4.getText().toString() + "^";

        if(etp6.getText() == null || etp6.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp6.getText().toString() + "^";
        if(etp7.getText() == null || etp7.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp7.getText().toString() + "^";
        if(etp8.getText() == null || etp8.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp8.getText().toString() + "^";
        if(etp9.getText() == null || etp9.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp9.getText().toString() + "^";
        if(etp10.getText() == null || etp10.getText().toString().equalsIgnoreCase(""))
            userText += "0^";
        else
            userText += etp10.getText().toString() + "^";

        if(other5 != null)
            userText += other5.getText().toString() + "^";


        if(cb1.isChecked())
            userText += cb1.getText().toString();
        if(cb2.isChecked())
            userText += ", " + cb2.getText().toString();
        if(cb3.isChecked())
            userText += ", " + cb3.getText().toString();
        if(cb4.isChecked())
            userText += ", " + cb4.getText().toString();
        if(cb5.isChecked())
            userText += ", " + cb5.getText().toString();
        if(cb6.isChecked())
            userText += ", " + cb6.getText().toString();

        userText += "^";

//        if(etp11.getText() == null)
//            userText += "0^";
//        else
//            userText += etp11.getText().toString() + "^";
//        if(etp12.getText() == null)
//            userText += "0^";
//        else
//            userText += etp12.getText().toString() + "^";
//        if(etp13.getText() == null)
//            userText += "0^";
//        else
//            userText += etp13.getText().toString() + "^";
//        if(etp14.getText() == null)
//            userText += "0^";
//        else
//            userText += etp14.getText().toString() + "^";
//        if(etp15.getText() == null)
//            userText += "0^";
//        else
//            userText += etp15.getText().toString() + "^";
//        if(etp16.getText() == null)
//            userText += "0^";
//        else
//            userText += etp16.getText().toString() + "^";

        //textview 7
        userText += ((RadioButton)findViewById(rg2.getCheckedRadioButtonId())).getText().toString() + "^";

        if(editText8.getText() !=null)
            userText += editText8.getText().toString() + "^";

        return userText;
    }


    @Override
    public void onBackPressed()
    {
        // Your Code Here. Leave empty if you want nothing to happen on back press.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        String filename ="";

        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        System.out.println("Hello********************");


        this.textView1 = (TextView) findViewById(R.id.textView1);
        this.rg = (RadioGroup) findViewById(R.id.rg1);
        this.r1 = (RadioButton) findViewById(R.id.r0);
        this.r2 = (RadioButton) findViewById(R.id.r1);
        this.r3 = (RadioButton) findViewById(R.id.r2);

        this.textView2 = (TextView) findViewById(R.id.textView2);
        this.compName = (EditText) findViewById(R.id.compName);
        this.date = (EditText) findViewById(R.id.date);
        this.addr = (EditText) findViewById(R.id.addr);
        this.eid = (EditText) findViewById(R.id.eid);
        this.pno = (EditText) findViewById(R.id.pno);
        this.area = (EditText) findViewById(R.id.area);

        this.textView3= (TextView) findViewById(R.id.textView3);
        this.tvp1 = (TextView) findViewById(R.id.tvp1);
        this.etp1 = (EditText) findViewById(R.id.etp1);
        this.tvp2 = (TextView) findViewById(R.id.tvp2);
        this.etp2 = (EditText) findViewById(R.id.etp2);
        this.tvp3 = (TextView) findViewById(R.id.tvp3);
        this.etp3 = (EditText) findViewById(R.id.etp3);
        this.tvp4 = (TextView) findViewById(R.id.tvp4);
        this.etp4 = (EditText) findViewById(R.id.etp4);
        this.tvp5 = (TextView) findViewById(R.id.tvp5);
        this.etp5 = (EditText) findViewById(R.id.etp5);
        this.other3 = (EditText) findViewById(R.id.other3);


        this.textView4 = (TextView) findViewById(R.id.textView4);
        this.editText4 = (EditText) findViewById(R.id.editText4);



        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.tvp6 = (TextView) findViewById(R.id.tvp6);
        this.etp6 = (EditText) findViewById(R.id.etp6);
        this.tvp7 = (TextView) findViewById(R.id.tvp7);
        this.etp7 = (EditText) findViewById(R.id.etp7);
        this.tvp8 = (TextView) findViewById(R.id.tvp8);
        this.etp8 = (EditText) findViewById(R.id.etp8);
        this.tvp9 = (TextView) findViewById(R.id.tvp9);
        this.etp9 = (EditText) findViewById(R.id.etp9);
        this.tvp10 = (TextView) findViewById(R.id.tvp10);
        this.etp10 = (EditText) findViewById(R.id.etp10);
        this.other5 = (EditText) findViewById(R.id.other5);


        this.textView6= (TextView) findViewById(R.id.textView6);
        this.cb1 = (CheckBox)findViewById(R.id.checkBox1);
        this.cb2 = (CheckBox)findViewById(R.id.checkBox2);
        this.cb3 = (CheckBox)findViewById(R.id.checkBox3);
        this.cb4 = (CheckBox)findViewById(R.id.checkBox4);
        this.cb5 = (CheckBox)findViewById(R.id.checkBox5);
        this.cb6 = (CheckBox)findViewById(R.id.checkBox6);

//        this.tvp11 = (TextView) findViewById(R.id.tvp11);
//        this.etp11 = (EditText) findViewById(R.id.etp11);
//        this.tvp12 = (TextView) findViewById(R.id.tvp12);
//        this.etp12 = (EditText) findViewById(R.id.etp12);
//        this.tvp13 = (TextView) findViewById(R.id.tvp13);
//        this.etp13 = (EditText) findViewById(R.id.etp13);
//        this.tvp14 = (TextView) findViewById(R.id.tvp14);
//        this.etp14 = (EditText) findViewById(R.id.etp14);
//        this.tvp15 = (TextView) findViewById(R.id.tvp15);
//        this.etp15 = (EditText) findViewById(R.id.etp15);
//        this.tvp16 = (TextView) findViewById(R.id.tvp16);
//        this.etp16 = (EditText) findViewById(R.id.etp16);
//        this.other6 = (EditText) findViewById(R.id.other6);

        this.textView7 = (TextView) findViewById(R.id.textView7);
        this.rg2 = (RadioGroup) findViewById(R.id.rg2);
        this.r4 = (RadioButton) findViewById(R.id.r3);
        this.r5 = (RadioButton) findViewById(R.id.r4);
        this.r6 = (RadioButton) findViewById(R.id.r5);

        this.textView8 = (TextView) findViewById(R.id.textView8);
        this.editText8 = (EditText) findViewById(R.id.editText8);
        this.doneB = (Button) findViewById(R.id.nextB);



//        filename = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // change text of the TextView (tvOut)
                fileN = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                if (SurveyActivity.this.isValidEmail(eid.getText().toString().trim()).booleanValue() && SurveyActivity.this.isValidMobile(pno.getText().toString().trim()).booleanValue()) {
                        if(SurveyActivity.this.isCheckBoxValid()){
                            userInput = getSurveyInfo();
                            SurveyActivity.this.appendData(userInput, fileN);
                            SurveyActivity.this.thanksClosure();
                        }
                        else{
                            Toast.makeText(SurveyActivity.this.getApplicationContext(), "** Please select atleast 1 & maximum of 3 for Survey 6", Toast.LENGTH_LONG).show();
                        }

                }
                else{
                    Toast.makeText(SurveyActivity.this.getApplicationContext(), "** Please Enter valid Email ID or Mobile no.", Toast.LENGTH_LONG).show();
                }


            }
        };
        // assign click listener to the OK button (btnOK)
        doneB.setOnClickListener(oclBtnOk);

        System.out.println("*************   " + filename + "  ****************");
//        appendData("abc", filename);

    }


    public void appendData(String text , String filename) {
//          int flag =0;/// To delete and correct
//        String storage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/userData.txt";
        String storage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + filename +".txt";
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        System.out.println(storage);
        System.out.println(text);
        File dataFile = new File(storage);
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(dataFile, true));
            buf.append(text);
//            if (flag == quesflag) {
                buf.newLine();
                buf.newLine();
//                flag = 0;
//            }
//            flag++;
            buf.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }


    public void thanksClosure(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SurveyActivity.this);
        alertDialogBuilder.setTitle("Survey Complete !!! ");
        alertDialogBuilder
                .setMessage("Thanks for taking the Survey.Have a nice Day. \nClick OK to exit.")
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        SurveyActivity.this.startActivity(new Intent(SurveyActivity.this, MainActivity.class));
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

}

