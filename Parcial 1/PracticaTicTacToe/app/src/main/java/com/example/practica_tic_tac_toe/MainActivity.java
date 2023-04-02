package com.example.practica_tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RadioButton x,o;
    private ImageButton f1_btn1, f1_btn2, f1_btn3, f2_btn1,f2_btn2,f2_btn3, f3_btn1, f3_btn2, f3_btn3;
    private TableLayout table;
    ImageButton btn;

    int statusGame = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = findViewById(R.id.tableLayout);
        x = findViewById(R.id.radioBtnX);
        o = findViewById(R.id.radioBtnO);

        //botones
        f1_btn1 = findViewById(R.id.f1_btn1);
        f1_btn2 = findViewById(R.id.f1_btn2);
        f1_btn3 = findViewById(R.id.f1_btn3);

        f2_btn1 = findViewById(R.id.f2_btn1);
        f2_btn2 = findViewById(R.id.f2_btn2);
        f2_btn3 = findViewById(R.id.f2_btn3);

        f3_btn1 = findViewById(R.id.f3_btn1);
        f3_btn2 = findViewById(R.id.f3_btn2);
        f3_btn3 = findViewById(R.id.f3_btn3);

    }

    public void cambiarBtn(View view){
        btn = (ImageButton) view;

        Drawable imgDrawable = btn.getDrawable();

        if (x.isChecked()){
            btn.setImageResource(R.mipmap.cruz);
            x.setChecked(false);
            o.setChecked(true);
            btn.setContentDescription("X");
        }else{
            btn.setImageResource(R.mipmap.cero);
            x.setChecked(true);
            o.setChecked(false);
            btn.setContentDescription("O");
        }

        view.setEnabled(false);

        statusGame = isWinner();

        if (statusGame == 1){
            Toast.makeText(this, "El ganador es X", Toast.LENGTH_SHORT).show();
            reset();
        } else if (statusGame == 2) {
            Toast.makeText(this, "El ganador es O", Toast.LENGTH_SHORT).show();
            reset();
        }else if (statusGame == 3){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
        }
    }

    public int isWinner(){
        //sentencias de columnas
        //X
        if(f1_btn1.getContentDescription() == "X" && f2_btn1.getContentDescription() == "X" && f3_btn1.getContentDescription() == "X"){
            return 1;
        } else if (f1_btn2.getContentDescription() == "X" && f2_btn2.getContentDescription() == "X" && f3_btn1.getContentDescription() == "X"){
            return 1;
        } else if (f1_btn3.getContentDescription() == "X" && f2_btn2.getContentDescription() == "X" && f3_btn3.getContentDescription() == "X"){
            return 1;
            //O
        } else if (f1_btn1.getContentDescription() == "O" && f2_btn1.getContentDescription() == "O" && f3_btn1.getContentDescription() == "O"){
            return 2;
        } else if (f1_btn2.getContentDescription() == "O" && f2_btn2.getContentDescription() == "O" && f3_btn2.getContentDescription() == "O"){
            return 2;
        } else if (f1_btn3.getContentDescription() == "O" && f2_btn2.getContentDescription() == "O" && f3_btn3.getContentDescription() == "O"){
            return 2;
        }
        //sentencias de filas
        //X
        else if (f1_btn1.getContentDescription() == "X" && f1_btn2.getContentDescription() == "X" && f1_btn3.getContentDescription() == "X"){
            return 1;
        }else if(f2_btn1.getContentDescription() == "X" && f2_btn2.getContentDescription() == "X" && f1_btn3.getContentDescription() == "X"){
            return 1;
        }else if (f3_btn1.getContentDescription() == "X" && f3_btn2.getContentDescription() == "X" && f3_btn3.getContentDescription() == "X"){
            return 1;
            //O
        } else if (f1_btn1.getContentDescription() == "O" && f1_btn2.getContentDescription() == "O" && f1_btn3.getContentDescription() == "O"){
            return 2;
        }else if(f2_btn1.getContentDescription() == "O" && f2_btn2.getContentDescription() == "O" && f2_btn3.getContentDescription() == "O"){
            return 2;
        }else if(f3_btn1.getContentDescription() == "O" && f3_btn2.getContentDescription() == "O" && f3_btn3.getContentDescription() == "O"){
            return 2;

            //sentencias de diagonales
            //X
        }else if (f1_btn1.getContentDescription() == "X" && f2_btn2.getContentDescription() == "X" && f3_btn3.getContentDescription() == "X") {
            return 1;
        } else if (f1_btn3.getContentDescription() == "X" && f2_btn2.getContentDescription() == "X" && f3_btn1.getContentDescription() == "X"){
            return 1;

            //O
        } else if (f1_btn1.getContentDescription() == "O" && f2_btn2.getContentDescription() == "O" && f3_btn3.getContentDescription() == "O"){
            return 2;
        } else if (f1_btn3.getContentDescription() == "O" && f2_btn2.getContentDescription() == "O" && f3_btn1.getContentDescription() == "O"){
            return 2;
        } else if (!f1_btn1.isEnabled() && !f1_btn2.isEnabled() && !f1_btn3.isEnabled() &&
                   !f2_btn1.isEnabled() && !f2_btn2.isEnabled() && !f2_btn3.isEnabled() &&
                   !f3_btn1.isEnabled() && !f3_btn2.isEnabled() && !f3_btn3.isEnabled()){
            return 3;
        }else{
            return 4;
        }
    }

    public void reset(){
        f1_btn1.setImageResource(R.mipmap.squere);
        f1_btn2.setImageResource(R.mipmap.squere);
        f1_btn3.setImageResource(R.mipmap.squere);

        f2_btn1.setImageResource(R.mipmap.squere);
        f2_btn2.setImageResource(R.mipmap.squere);
        f2_btn3.setImageResource(R.mipmap.squere);

        f3_btn1.setImageResource(R.mipmap.squere);
        f3_btn2.setImageResource(R.mipmap.squere);
        f3_btn3.setImageResource(R.mipmap.squere);

        f1_btn1.setEnabled(true);
        f1_btn2.setEnabled(true);
        f1_btn3.setEnabled(true);

        f2_btn1.setEnabled(true);
        f2_btn2.setEnabled(true);
        f2_btn3.setEnabled(true);

        f3_btn1.setEnabled(true);
        f3_btn2.setEnabled(true);
        f3_btn3.setEnabled(true);

        f1_btn1.setContentDescription(" ");
        f1_btn2.setContentDescription(" ");
        f1_btn3.setContentDescription(" ");

        f2_btn1.setContentDescription(" ");
        f2_btn2.setContentDescription(" ");
        f2_btn3.setContentDescription(" ");

        f3_btn1.setContentDescription(" ");
        f3_btn2.setContentDescription(" ");
        f3_btn3.setContentDescription(" ");

    }

}