package com.fifteenpuzzle.iftac.jesper.fifteenpuzzle;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);


        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);


        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);


        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);


        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);


        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);


        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);


        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(this);


        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(this);


        Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(this);


        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(this);

        Button button14 = findViewById(R.id.button14);
        button14.setOnClickListener(this);

        Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(this);

        Button button16 = findViewById(R.id.button16);
        button16.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {



    }

    private int printBoard() {
        int i = 0;
        return i;
    }
}
