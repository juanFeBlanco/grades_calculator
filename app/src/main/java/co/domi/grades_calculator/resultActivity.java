package co.domi.grades_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class resultActivity extends AppCompatActivity {

    private Button rewind;
    private TextView nameIntro;
    private TextView gradeText;
    private ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        rewind = findViewById(R.id.rewindBtn);
        nameIntro = findViewById(R.id.nameTxt);
        gradeText = findViewById(R.id.gradeTxt);
        bg = findViewById(R.id.bgCo);

        String name = getIntent().getExtras().getString("name");
        double fGrade = getIntent().getExtras().getDouble("fGrade");

        nameIntro.setText("Hola, "+ name + " . Tu nota final es:");
        gradeText.setText(fGrade+"");

        rewind.setOnClickListener(
                (view) -> {
                    Intent reStart = new Intent(this, MainActivity.class);
                    startActivity(reStart);
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