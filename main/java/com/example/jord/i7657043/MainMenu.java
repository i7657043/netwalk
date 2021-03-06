package com.example.jord.i7657043;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity{

    private Intent i1;
    private EditText playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button btnPlay = (Button) findViewById(R.id.btnPlayGame);
        btnPlay.setOnClickListener(new btnListener());
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new btnListener());
        playerName = (EditText) findViewById(R.id.txtBoxPlayerName);


        /*This is an alternative way of handling different events
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainMenu.this,GameScreen.class);
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

    private class btnListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            i1 = new Intent(MainMenu.this,GameScreen.class);
            if (playerName.getText()!=null)
            {
                i1.putExtra("player",playerName.getText().toString());
            }
            CharSequence seq[] = {"Easy", "Medium", "Hard"};

            switch (v.getId())
            {
                case (R.id.btnPlayGame):
                    final AlertDialog.Builder alert = new AlertDialog.Builder(MainMenu.this);
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


