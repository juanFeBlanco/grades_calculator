package co.domi.grades_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class configActivity extends AppCompatActivity {

    private Button ba;
    private Button bb;
    private Button br;
    private ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        ba = findViewById(R.id.btnA);
        bb = findViewById(R.id.btnB);
        br = findViewById(R.id.btnR);
        bg = findViewById(R.id.bgCo);

        SharedPreferences colorBg = getSharedPreferences("bgColor", MODE_PRIVATE);

        ba.setOnClickListener(
                (view) ->{
                    colorBg.edit().putString("color","#0000FF").apply();
                    finish();
                }
        );

        bb.setOnClickListener(
                (view) ->{
                    colorBg.edit().putString("color","#FFFFFF").apply();
                    finish();
                }
        );
        br.setOnClickListener(
                (view) ->{
                    colorBg.edit().putString("color","#FF0000").apply();
                    finish();
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorBg = getSharedPreferences("bgColor", MODE_PRIVATE);
        String bgString = colorBg.getString("color","#FFFFFF");
        bg.setBackgroundColor(Color.parseColor(bgString));
    }
}