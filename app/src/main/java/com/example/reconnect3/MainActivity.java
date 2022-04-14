package com.example.reconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningGame = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activePlayer = 0;
    boolean isWin = true;

    public void chooseSquare(View view){
        ImageView imageView = (ImageView) view;

        int tag = Integer.parseInt(imageView.getTag().toString());

        if(gameState[tag] == 2 && isWin){
            imageView.setTranslationY(-1500);
            gameState[tag] = activePlayer;
            if(activePlayer == 0){
                imageView.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            }else{
                imageView.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            imageView.animate().translationYBy(1500).rotation(3600).setDuration(350);

            String winnerInfo;
            if(activePlayer == 1){
                winnerInfo = "Yellow";
            }else{
                winnerInfo = "Red";
            }

            for(int[] winning : winningGame){
                if(gameState[winning[0]] == gameState[winning[1]] && gameState[winning[1]] == gameState[winning[2]] && gameState[winning[0]] != 2){
                    Button buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
                    TextView winnerText = (TextView) findViewById(R.id.winnerText);

                    winnerText.setVisibility(View.VISIBLE);
                    buttonPlayAgain.setVisibility(View.VISIBLE);
                    winnerText.setText(winnerInfo + " has won");


                    isWin = false;
                }else if(gameState[winning[0]] != gameState[winning[1]] && gameState[winning[1]] != gameState[winning[2]] && gameState[winning[0]] != 2 && isTrue(gameState) ==  false){
                    Button buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
                    TextView winnerText = (TextView) findViewById(R.id.winnerText);

                    winnerText.setVisibility(View.VISIBLE);
                    buttonPlayAgain.setVisibility(View.VISIBLE);
                    winnerText.setText("Draw");


                    isWin = false;
                }
            }
        }
    }

    public boolean isTrue(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                return true;
            }
        }
        return false;
    }

    public void playAgain(View view){
        Button buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        TextView winnerText = (TextView) findViewById(R.id.winnerText);

        winnerText.setVisibility(View.INVISIBLE);
        buttonPlayAgain.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ImageView imageView = (ImageView) gridLayout.getChildAt(i);
            imageView.setImageDrawable(null);
        }

        Arrays.fill(gameState, 2);

        activePlayer = 0;
        isWin = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}