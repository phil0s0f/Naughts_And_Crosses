package com.example.naughtsandcrosses;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Boolean turn = true; // true - p1, false - p2
    Button [][] btnMap = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMap[0][0] = (Button) findViewById(R.id.button1);
        btnMap[0][1] = (Button) findViewById(R.id.button2);
        btnMap[0][2] = (Button) findViewById(R.id.button3);
        btnMap[1][0] = (Button) findViewById(R.id.button4);
        btnMap[1][1] = (Button) findViewById(R.id.button5);
        btnMap[1][2] = (Button) findViewById(R.id.button6);
        btnMap[2][0] = (Button) findViewById(R.id.button7);
        btnMap[2][1] = (Button) findViewById(R.id.button8);
        btnMap[2][2] = (Button) findViewById(R.id.button9);
    }

    //array:
    //2131231202   2131231204    2131231203
    //2131231205   2131231207    2131231206
    //2131231210   2131231208    2131231209
    public void onButtonClick(View view){
        Button btn = (Button)findViewById(view.getId());
        //TextView text = (TextView)findViewById(R.id.textView);
        //text.setText(view.getId() + "");
        //view.getId();// получаем id нажатой кнопки
        if (turn){
            btn.setText("X");
            btn.setEnabled(false);
            checkWin(turn);
            turn = false;
        }else{
            btn.setText("O");
            btn.setEnabled(false);
            checkWin(turn);
            turn = true;
        }
    }
    public void checkWin(Boolean turn){
        if (turn){
            //p1 - win
            if((btnMap[0][0].getText().toString() == "X" && btnMap[0][1].getText().toString() == "X" && btnMap[0][2].getText().toString() == "X")
                    || (btnMap[1][0].getText().toString() == "X" && btnMap[1][1].getText().toString() == "X" && btnMap[1][2].getText().toString() == "X")
                    || (btnMap[2][0].getText().toString() == "X" && btnMap[2][1].getText().toString() == "X" && btnMap[2][2].getText().toString() == "X")
                    || (btnMap[0][0].getText().toString() == "X" && btnMap[1][0].getText().toString() == "X" && btnMap[2][0].getText().toString() == "X")
                    || (btnMap[0][1].getText().toString() == "X" && btnMap[1][1].getText().toString() == "X" && btnMap[2][1].getText().toString() == "X")
                    || (btnMap[0][2].getText().toString() == "X" && btnMap[1][2].getText().toString() == "X" && btnMap[2][2].getText().toString() == "X")
                    || (btnMap[0][0].getText().toString() == "X" && btnMap[1][1].getText().toString() == "X" && btnMap[2][2].getText().toString() == "X")
                    || (btnMap[0][2].getText().toString() == "X" && btnMap[1][1].getText().toString() == "X" && btnMap[2][0].getText().toString() == "X")
            ){
                TextView p1 = (TextView) findViewById(R.id.textViewP1);
                TextView res = (TextView) findViewById(R.id.textViewRes);
                int count = Integer.parseInt(p1.getText().toString());
                count++;
                p1.setText(count + "");
                res.setText("Player 1 win!");
                resetGame();
            }
        }else{
            //p2 - win
            if((btnMap[0][0].getText().toString() == "O" && btnMap[0][1].getText().toString() == "O" && btnMap[0][2].getText().toString() == "O")
                    || (btnMap[1][0].getText().toString() == "O" && btnMap[1][1].getText().toString() == "O" && btnMap[1][2].getText().toString() == "O")
                    || (btnMap[2][0].getText().toString() == "O" && btnMap[2][1].getText().toString() == "O" && btnMap[2][2].getText().toString() == "O")
                    || (btnMap[0][0].getText().toString() == "O" && btnMap[1][0].getText().toString() == "O" && btnMap[2][0].getText().toString() == "O")
                    || (btnMap[0][1].getText().toString() == "O" && btnMap[1][1].getText().toString() == "O" && btnMap[2][1].getText().toString() == "O")
                    || (btnMap[0][2].getText().toString() == "O" && btnMap[1][2].getText().toString() == "O" && btnMap[2][2].getText().toString() == "O")
                    || (btnMap[0][0].getText().toString() == "O" && btnMap[1][1].getText().toString() == "O" && btnMap[2][2].getText().toString() == "O")
                    || (btnMap[0][2].getText().toString() == "O" && btnMap[1][1].getText().toString() == "O" && btnMap[2][0].getText().toString() == "O")
            ){
                TextView p2 = (TextView) findViewById(R.id.textViewP2);
                TextView res = (TextView) findViewById(R.id.textViewRes);
                int count = Integer.parseInt(p2.getText().toString());
                count++;
                p2.setText(count + "");
                res.setText("Player 2 win!");
                resetGame();
            }
        }
    }
    public void resetGame(){
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3;j++)
            {
                btnMap[i][j].setEnabled(false);
            }
        }
    }
    public void onButtonClickNewGame(View view){
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3;j++)
            {
                btnMap[i][j].setEnabled(true);
                btnMap[i][j].setText("");
                TextView res = (TextView) findViewById(R.id.textViewRes);
                res.setText("");
                turn = true;
            }
        }
    }

}