package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class button1 extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount =0;
    private int player1Points =0;
    private int player2Points =0;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        textViewPlayer1 = findViewById(R.id.player1__number_score);
        textViewPlayer2 = findViewById(R.id.player2__number_score);

        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }
    @Override
    public void onClick(View view){
        if(!((Button) view).getText().toString().equals("")){
            return;
        }
        if(player1Turn) {
            ((Button) view).setText("X");
        }else{
            ((Button) view).setText("O");

        }
        roundCount++;
        if(checkForWin()){
            if(player1Turn){
                player1Wins();
            }
            else{
                player2Wins();
            }
        } else if(roundCount == 9){
            draw();
        }else{
            player1Turn =!player1Turn;
        }
    }
    private boolean checkForWin(){
        String[][] check = new String[3][3];
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                check[i][j] = buttons[i][j].getText().toString();

            }
        }
        for (int i=0; i<3; i++){
            if (check[i][0].equals(check[i][1]) && check[i][0].equals(check[i][2]) && !check[i][0].equals("")){
                return true;
            }

        }
        for (int i=0; i<3; i++){
            if (check[0][i].equals(check[1][i]) && check[0][i].equals(check[2][i]) && !check[0][i].equals("")){
                return true;
            }

        }
        if (check[0][0].equals(check[1][1]) && check[0][0].equals(check[2][2]) && !check[0][0].equals("")){
            return true;
        }
        if (check[0][2].equals(check[1][1]) && check[0][2].equals(check[2][0]) && !check[0][2].equals("")){
            return true;
        }
        return false;
    }
    private void player1Wins() {
        player1Points++;
        textViewPlayer1.setText(Integer.toString(player1Points));
        Toast.makeText(this,"Player 1 has won",Toast.LENGTH_SHORT).show();
        resetBoard();

    }


    private void player2Wins(){
        player2Points++;
        textViewPlayer2.setText(Integer.toString(player2Points));
        Toast.makeText(this,"Player 2 has won",Toast.LENGTH_SHORT).show();
        resetBoard();

    }
    private void resetBoard(){
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                buttons[i][j].setText("");
            }
        }
        roundCount =0;
    }
    private void draw(){
        Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
        resetBoard();


    }


}
