package co.domi.grades_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculationActivity extends AppCompatActivity {

    private EditText pp1;
    private EditText pp2;
    private EditText qz;
    private EditText p1;
    private EditText p2;
    private Button calculateB;
    private ConstraintLayout bg;

    String nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        pp1 = findViewById(R.id.proPar1);
        pp2 = findViewById(R.id.proPar2);
        qz = findViewById(R.id.quices);
        p1 = findViewById(R.id.par1);
        p2 = findViewById(R.id.par2);
        calculateB = findViewById(R.id.calculateBtn);
        bg = findViewById(R.id.bgCo);

         nameUser = getIntent().getExtras().getString("name");

        calculateB.setOnClickListener(
                (view) -> {
                    if(!pp1.getText().toString().equals("") && !pp2.getText().toString().equals("") &&
                        !p1.getText().toString().equals("") && !p2.getText().toString().equals("") &&
                        !qz.getText().toString().equals("")){

                        double g = calculateGrade();
                        Intent results = new Intent(this, resultActivity.class);
                        results.putExtra("name",nameUser);
                        results.putExtra("fGrade", g);
                        startActivity(results);
                    }else{
                        Toast.makeText(this, "Pls llena todo", Toast.LENGTH_SHORT).show();
                    }
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

    private double calculateGrade() {
        pp1.setText(pp1.getText().toString().replace(',', '.'));
        pp2.setText(pp2.getText().toString().replace(',', '.'));
        qz.setText(qz.getText().toString().replace(',', '.'));
        p1.setText(p1.getText().toString().replace(',', '.'));
        p2.setText(p2.getText().toString().replace(',', '.'));

        double grade = ((Double.parseDouble(pp1.getText().toString()))*0.25)+
                ((Double.parseDouble(pp2.getText().toString()))*0.25)+
                ((Double.parseDouble(qz.getText().toString()))*0.20)+
                ((Double.parseDouble(p1.getText().toString()))*0.15)+
                ((Double.parseDouble(p2.getText().toString()))*0.15);

        return grade;
    }
}