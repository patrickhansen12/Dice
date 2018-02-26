package com.example.nicolai.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dice1, dice2;
    Button Roll, Clear;
    TextView History1, History2, History3, History4, History5;
    int[] images = {
            R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    };
    int PickedImage, holdPicked;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll = findViewById(R.id.Roll);
        Clear = findViewById(R.id.Clear);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        History1 = findViewById(R.id.History1);
        History2 = findViewById(R.id.History2);
        History3 = findViewById(R.id.History3);
        History4 = findViewById(R.id.History4);
        History5 = findViewById(R.id.History5);
        r = new Random();

        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearHistory();
            }
        });
    }

    private void randomDice()
    {
            PickedImage = r.nextInt(images.length);
    }

    private void rollDice()
    {
        randomDice();
        dice1.setImageResource(images[PickedImage]);
        holdPicked = PickedImage;
        randomDice();
        dice2.setImageResource(images[PickedImage]);
        updateHistory();
    }

    private void updateHistory()
    {
        History5.setText(History4.getText());
        History4.setText(History3.getText());
        History3.setText(History2.getText());
        History2.setText(History1.getText());
        History1.setText((holdPicked + 1) + " + " + (1 + PickedImage) + " = " + (holdPicked + 1 + 1 + PickedImage));
    }

    private void clearHistory()
    {
        History1.setText("");
        History2.setText("");
        History3.setText("");
        History4.setText("");
        History5.setText("");
    }
}