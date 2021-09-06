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

public class MainActivity extends AppCompatActivity {

    private Button continueB;
    private Button configB;
    private EditText nameT;
    private ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueB = findViewById(R.id.continueBtn);
        configB = findViewById(R.id.configBtn);
        nameT = findViewById(R.id.nameTextField);
        bg = findViewById(R.id.bgCo);

        continueB.setOnClickListener(
                (view) -> {
                    if(nameT.getText().toString().equals("")){
                        Toast.makeText(this, "Por favor coloca tu nombre", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent calculateI = new Intent(this, calculationActivity.class);
                        calculateI.putExtra("name",nameT.getText().toString());
                        startActivity(calculateI);

                    }
                }
        );

        configB.setOnClickListener(
                (view) -> {
                    Intent configI = new Intent(this, configActivity.class);
                    startActivity(configI);
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