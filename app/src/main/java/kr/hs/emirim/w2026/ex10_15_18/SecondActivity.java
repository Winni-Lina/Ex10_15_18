package kr.hs.emirim.w2026.ex10_15_18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    int cul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        String op = intent.getStringExtra("op");
        switch (op){
            case "+":
                cul = num1+num2;
                break;
            case "-":
                cul = num1-num2;
                break;
            case "*":
                cul = num1*num2;
                break;
            case "/":
                cul = num1/num2;
                break;
        }

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            mainIntent.putExtra("cul", cul);
            setResult(RESULT_OK, mainIntent);
            finish();
        }
    };
}