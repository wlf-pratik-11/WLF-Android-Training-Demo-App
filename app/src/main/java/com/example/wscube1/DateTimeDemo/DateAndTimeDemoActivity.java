package com.example.wscube1.DateTimeDemo;

import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.databinding.ActivityDateAndTimeDemoBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAndTimeDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDateAndTimeDemoBinding binding;

    TextView dateTimeInLongTextView,format1,format2,format3,format4,format5,format6,format7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_demo);

        String dateTime;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;


        dateTimeInLongTextView = (TextView) findViewById(R.id.dateTimeLongValue);
        format1 = (TextView) findViewById(R.id.format1);
        format2 = (TextView) findViewById(R.id.format2);
        format3 = (TextView) findViewById(R.id.format3);
        format4 = (TextView) findViewById(R.id.format4);
        format5 = (TextView) findViewById(R.id.format5);
        format6 = (TextView) findViewById(R.id.format6);
        format7 = (TextView) findViewById(R.id.format7);

        Long dateValueInLong = System.currentTimeMillis();
        dateTimeInLongTextView.setText(dateValueInLong.toString());

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format1.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format2.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format3.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.LLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format4.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.LLLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format5.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("E.LLLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format6.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEEE.LLLL.yyyy KK:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format7.setText(dateTime);


//        String date="2004-11-01 6:30:00 PM";
//        SimpleDateFormat spf=new SimpleDateFormat("yyyy-dd-mm hh:mm:ss aaa");
//        Date newDate= null;
//        try {
//            newDate = spf.parse(date);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        spf= new SimpleDateFormat("dd/MM/yyyy");
//        date = spf.format(newDate);
//        format1.setText(date);
//


        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Date And Time Foramtting",true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the "up" navigation using onBackPressedDispatcher
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}