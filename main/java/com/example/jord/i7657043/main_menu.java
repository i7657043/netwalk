package com.example.jord.i7657043;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class main_menu extends AppCompatActivity{

    Button btnPlay, btnExit;
    Intent i1;
    //Could have a player class for this but for now its here
    EditText playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnPlay = (Button) findViewById(R.id.btnPlayGame);
        btnPlay.setOnClickListener(new btnListener());
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new btnListener());
        playerName = (EditText) findViewById(R.id.txtBoxPlayerName);


        /*This way is not as clean at handling different events
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(main_menu.this,game_screen.class);
                startActivity(i1);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });*/
    }

    public class btnListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            i1 = new Intent(main_menu.this,game_screen.class);
            if (playerName.getText()!=null)
            {
                i1.putExtra("player",playerName.getText().toString());
            }
            CharSequence seq[] = {"Easy", "Medium", "Hard"};
            switch (v.getId())
            {
                case (R.id.btnPlayGame):
                    final AlertDialog.Builder alert = new AlertDialog.Builder(main_menu.this);
                    alert.setTitle("Pick a difficulty");

                    alert.setItems(seq, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i)
                            {
                                case 0:
                                    i1.putExtra("Diff",1);
                                    break;
                                case 1:
                                    i1.putExtra("Diff",2);
                                    break;
                                case 2:
                                    i1.putExtra("Diff",3);
                                    break;
                            }
                            startActivity(i1);
                        }
                    });
                    alert.show();
                    break;

                case (R.id.btnExit):
                    System.exit(0);
                    break;

            }
        }
    }
}


