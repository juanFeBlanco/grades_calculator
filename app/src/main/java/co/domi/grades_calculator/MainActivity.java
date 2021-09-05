package co.domi.grades_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button continueB;
    private Button configB;
    private EditText nameT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueB = findViewById(R.id.continueBtn);
        configB = findViewById(R.id.configBtn);
        nameT = findViewById(R.id.nameTextField);

        continueB.setOnClickListener(
                (view) -> {
                    if(nameT.getText().toString().equals("")){
                        Toast.makeText(this, "Por favor coloca tu nombre", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent calculateI = new Intent(this, calculationActivity.class);
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
}