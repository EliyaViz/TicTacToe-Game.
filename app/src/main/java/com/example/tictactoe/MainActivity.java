package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[][] board = new int[3][3];
    int turn = 0;//circel turn
    private int XScore ,CircleScore;
    private int boardCount=0;
    ArrayList<Button> clickedButtons = new ArrayList<>();

    public void insert(View v) {

        if(R.id.EndGame == v.getId()){
            finish();
        }
        if (R.id.topLeft == v.getId()) {
            Button topLeft = findViewById(R.id.topLeft);
            topLeft.setEnabled(false);
            clickedButtons.add(topLeft);
            boardCount++;
            if (turn == 0) {
                board[0][0] = 0;
                topLeft.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[0][0] = 1;
                topLeft.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.topMid == v.getId()) {
            Button topMid = findViewById(R.id.topMid);
            topMid.setEnabled(false);
            clickedButtons.add(topMid);
            boardCount++;
            if (turn == 0) {
                board[0][1] = 0;
                topMid.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[0][1] = 1;
                topMid.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.topRight == v.getId()) {
            Button topRight = findViewById(R.id.topRight);
            topRight.setEnabled(false);
            clickedButtons.add(topRight);
            boardCount++;
            if (turn == 0) {
                board[0][2] = 0;
                topRight.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[0][2] = 1;
                topRight.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.midLeft == v.getId()) {
            Button midLeft = findViewById(R.id.midLeft);
            midLeft.setEnabled(false);
            clickedButtons.add(midLeft);
            boardCount++;
            if (turn == 0) {
                board[1][0] = 0;
                midLeft.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[1][0] = 1;
                midLeft.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.midMid == v.getId()) {
            Button midMid = findViewById(R.id.midMid);
            midMid.setEnabled(false);
            clickedButtons.add(midMid);
            boardCount++;
            if (turn == 0) {
                board[1][1] = 0;
                midMid.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[1][1] = 1;
                midMid.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.midRight == v.getId()) {
            Button midRight = findViewById(R.id.midRight);
            midRight.setEnabled(false);
            clickedButtons.add(midRight);
            boardCount++;
            if (turn == 0) {
                board[1][2] = 0;
                midRight.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[1][2] = 1;
                midRight.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.bottomLeft == v.getId()) {
            Button bottomLeft = findViewById(R.id.bottomLeft);
            bottomLeft.setEnabled(false);
            clickedButtons.add(bottomLeft);
            boardCount++;
            if (turn == 0) {
                board[2][0] = 0;
                bottomLeft.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[2][0] = 1;
                bottomLeft.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.bottomMid == v.getId()) {
            Button bottomMid = findViewById(R.id.bottomMid);
            bottomMid.setEnabled(false);
            clickedButtons.add(bottomMid);
            boardCount++;
            if (turn == 0) {
                board[2][1] = 0;
                bottomMid.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[2][1] = 1;
                bottomMid.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }
        if (R.id.bottomRight == v.getId()) {
            Button bottomRight = findViewById(R.id.bottomRight);
            bottomRight.setEnabled(false);
            clickedButtons.add(bottomRight);
            boardCount++;
            if (turn == 0) {
                board[2][2] = 0;
                bottomRight.setBackgroundResource(R.drawable.circle);
                turn = 1;
            } else {
                board[2][2] = 1;
                bottomRight.setBackgroundResource(R.drawable.x);
                turn = 0;
            }
        }

        if(checkWin()==1){
            final TextView announcer = findViewById(R.id.scoreAnouncer);
            announcer.setVisibility(View.VISIBLE);
            announcer.setText("X won this round");
            Handler handler = new Handler();

            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    XScore++;
                    TextView scoreUpdate = findViewById(R.id.scoreX);
                    scoreUpdate.setText("Score: "+XScore);
                    for(int i = 0 ; i < clickedButtons.size() ; i++){
                        Log.d("buttons", ""+boardCount++);
                        clickedButtons.get(i).setBackgroundResource(0);
                        clickedButtons.get(i).setEnabled(true);
                    }
                    clickedButtons.clear();
                    turn = 0;
                    boardCount=0;
                    for(int i = 0 ; i<3;i++){
                        for(int j = 0 ;j<3;j++){
                            board[i][j]=-1;
                        }
                    }
                    announcer.setVisibility(View.INVISIBLE);
                }
            }, 2000);

        }
        if(checkWin()==0){
            final TextView announcer = findViewById(R.id.scoreAnouncer);
            announcer.setVisibility(View.VISIBLE);
            announcer.setText("Circle won this round");
            Handler handler = new Handler();

            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    CircleScore++;
                    TextView scoreUpdate = findViewById(R.id.scoreCircle);
                    scoreUpdate.setText("Score: "+CircleScore);
                    for(int i = 0 ; i < clickedButtons.size() ; i++){
                        Log.d("buttons", "");
                        clickedButtons.get(i).setBackgroundResource(0);
                        clickedButtons.get(i).setEnabled(true);
                    }
                    clickedButtons.clear();
                    turn = 0;
                    boardCount=0;
                    for(int i = 0 ; i<3;i++){
                        for(int j = 0 ;j<3;j++){
                            board[i][j]=-1;
                        }
                    }
                    announcer.setVisibility(View.INVISIBLE);
                }
            }, 2000);

        }
        if(boardCount==9){
            final TextView announcer = findViewById(R.id.scoreAnouncer);
            announcer.setVisibility(View.VISIBLE);
            announcer.setText("Draw!");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    for(int i = 0 ; i < clickedButtons.size() ; i++){
                        Log.d("buttons", "");
                        clickedButtons.get(i).setBackgroundResource(0);
                        clickedButtons.get(i).setEnabled(true);
                    }
                    clickedButtons.clear();
                    turn = 0;
                    boardCount=0;
                    for(int i = 0 ; i<3;i++){
                        for(int j = 0 ;j<3;j++){
                            board[i][j]=-1;
                        }
                    }
                    announcer.setVisibility(View.INVISIBLE);
                }
            }, 2000);

        }

    }
    //going through the possible win conditions.
    public int checkWin(){
        int result=-1;
        for (int i = 0; i < 3; ++ i) {
            if ((board[i][0] != -1) && (board[i][0] == board[i][1])
                    && (board[i][1] == board[i][2])) {
                return board[i][0];

            }
            if ((board[0][i] != -1) && (board[0][i] == board[1][i])
                    && (board[1][i] == board[2][i])) {
                return board[0][i];

            }
        }
        if ((board[1][1] != -1) && (board[0][0] == board[1][1])
                && (board[1][1] == board[2][2])) {
            return board[1][1];

        }
        if ((board[1][1] != -1) && (board[0][2] == board[1][1])
                && (board[1][1] == board[2][0])) {
            return board[1][1];
        }
        return result;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the array with -1.
        for(int i = 0 ; i<3;i++){
            for(int j = 0 ;j<3;j++){
                board[i][j]=-1;
            }
        }
    }
}
