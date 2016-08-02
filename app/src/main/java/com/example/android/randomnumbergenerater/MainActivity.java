package com.example.android.randomnumbergenerater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsActivity);
                Toast.makeText(MainActivity.this, "打开设置！", Toast.LENGTH_SHORT).show();
            }
        });
        
    }

    public void submitGeneration(View view){
        ImageButton resetButton = (ImageButton) findViewById(R.id.resetButton);
        EditText lo = (EditText) findViewById(R.id.lowerBound);
        EditText hi = (EditText) findViewById(R.id.upperBound);
        EditText num = (EditText) findViewById(R.id.numberToGenerate);
        TextView showingBox = (TextView) findViewById(R.id.AnswerBox);
        int lowerBound = Integer.parseInt(lo.getText().toString());
        int upperBound = Integer.parseInt(hi.getText().toString());
        int numberToGenerate = Integer.parseInt(num.getText().toString());
        if((lowerBound > upperBound && numberToGenerate != 0) || (lowerBound == upperBound && lowerBound == 0 && numberToGenerate != 0) ){
            showingBox.setText("请确保最大数字大于最小数字，不然无法产生随机数");
        }
        else {
            String result = generateRandomNum(lowerBound, upperBound, numberToGenerate);
            showingBox.setText(result);
        }
        if(lowerBound != 0 || upperBound != 0 || numberToGenerate != 0 || (!showingBox.getText().toString().isEmpty() && !showingBox.getText().toString().equals("0"))){
            resetButton.setImageResource(R.drawable.is_reset);
        }
        else{
            resetButton.setImageResource(R.drawable.no_reset);
        }
    }

    public void resetAll(View view){
        ImageButton resetButton = (ImageButton) findViewById(R.id.resetButton);
        EditText lo = (EditText) findViewById(R.id.lowerBound);
        EditText hi = (EditText) findViewById(R.id.upperBound);
        EditText num = (EditText) findViewById(R.id.numberToGenerate);
        TextView showingBox = (TextView) findViewById(R.id.AnswerBox);
        lo.setText("0");
        hi.setText("0");
        num.setText("0");
        showingBox.setText("");
        resetButton.setImageResource(R.drawable.no_reset);
    }

    private String generateRandomNum(int lowerBound, int upperBound, int numberToGenerate){
        String result = "";
        int i;
        for(i = 0; i < numberToGenerate; i++){
            int newNum = 0;
            while(newNum > upperBound || newNum == 0){
                newNum = (int) (Math.random() * (Math.random() * 300 * 100));
                newNum = lowerBound + newNum;
            }
            if(numberToGenerate == 1){
                result = result + newNum;
            }
            else if(i == numberToGenerate-1){
                result = result + newNum;
            }
            else{
                result = result + newNum + ", ";
            }
        }
        return result;
    }
}
