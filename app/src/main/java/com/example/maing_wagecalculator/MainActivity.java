package com.example.maing_wagecalculator;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Name, Type, Hours;
    Button Calc;
    TextView total_wage,reg_wage,ot_wage,total_hours,ot_hours;
    int hours, OT_hours, total_Hours, reg_Wage, OT_wage, total_Wage;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.Edit_Name);
        Type = findViewById(R.id.Edit_Type);
        Hours = findViewById(R.id.Edit_Hours);
        Calc = findViewById(R.id.btn_calc);
        Calc.setOnClickListener(this);
        total_wage = findViewById(R.id.total_wage);
        reg_wage = findViewById(R.id.reg_wage);
        ot_wage = findViewById(R.id.ot_wage);
        total_hours = findViewById(R.id.total_hours);
        ot_hours = findViewById(R.id.ot_hours);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: mic test woo baka naman gusto mo work fr fr");
        hours = Integer.parseInt(Hours.getText().toString());
        type = (Type.getText().toString());
        if (type.equals("regular")||type.equals("Regular")||type.equals("REGULAR")){
            if (hours>8){
                total_Hours = hours;
                OT_hours = hours-8;
                reg_Wage = 800;
                OT_wage = OT_hours*115;
                total_Wage = reg_Wage+ OT_wage;
            } else{
                reg_Wage = hours * 100;
                total_Wage= reg_Wage;
            }
        } else if (type.equals("probationary")||type.equals("Probationary")||type.equals("PROBATIONARY")){
            if (hours>8){
                total_Hours = hours;
                OT_hours = hours-8;
                reg_Wage = 720;
                OT_wage = OT_hours*100;
                total_Wage = reg_Wage+ OT_wage;
            } else{
                reg_Wage = hours * 90;
                total_Wage= reg_Wage;
            }
        } else{
            if (hours>8){
                total_Hours = hours;
                OT_hours = hours-8;
                reg_Wage = 600;
                OT_wage = OT_hours*90;
                total_Wage = reg_Wage+ OT_wage;
            } else{
                reg_Wage = hours * 75;
                total_Wage= reg_Wage;
            }
        }
        total_wage.setText(String.valueOf(total_Wage));
        reg_wage.setText(String.valueOf(reg_Wage));
        ot_wage.setText(String.valueOf(OT_wage));
        total_hours.setText(String.valueOf(hours));
        ot_hours.setText(String.valueOf(OT_hours));
    }
    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
}
