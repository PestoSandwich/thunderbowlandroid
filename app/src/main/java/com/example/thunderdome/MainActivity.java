package com.example.thunderdome;

//PestoSandwich

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// This is the code which handles the activity, basically the GUI of the program. As you can see we are only looking at button clicks, updating text fields and making calls to the ThunderDome script.


public class MainActivity extends AppCompatActivity {
    ThunderDome thunderDome;
    TextView textView;
    TextView turn_text;
    Integer turncounter;


    // The onCreate is called once when the activity is created. Here we declare all the buttons and say which functions should be called when they are pressed.
    // At the end we call reset() which prepares the values for a new game.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thunderDome = new ThunderDome();

        textView = this.findViewById(R.id.text_field);
        turn_text = this.findViewById(R.id.turn_text);

        Button opponents_turn_button =  this.findViewById(R.id.opp_turn_button);
        opponents_turn_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                opponentsTurn();

            }
        });
        Button reset_button = this.findViewById(R.id.reset_button);
        reset_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        Button counter_button = this.findViewById(R.id.counter_button);
        counter_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                spellCast();
            }
        });
        Button regular_attack_button = this.findViewById(R.id.regular_attack_button);
        regular_attack_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attack();
            }
        });

        reset();
    }

    private void spellCast(){
        textView.setText(thunderDome.rollTable(ThunderDome.LOW_COUNTER));
    }

    private void Attack(){
        textView.setText(thunderDome.rollTable(ThunderDome.ATTACKER));
    }

    private void opponentsTurn(){
        textView.setText(thunderDome.rollTable(ThunderDome.OPPONENTS_TURN));
        turncounter += 1;
        String turn_string = "Turn " + String.valueOf(turncounter);
        turn_text.setText(turn_string);
    }

    private void reset(){
        textView.setText("Turn 1 \n\n You start");
        turn_text.setText("Turn 1");
        turncounter = 1;
    }
}
