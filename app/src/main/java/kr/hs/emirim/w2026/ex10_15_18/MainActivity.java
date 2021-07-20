package kr.hs.emirim.w2026.ex10_15_18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        rg = findViewById(R.id.rg);

        Button btnCal = findViewById(R.id.btn_calc);
        btnCal.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        String op = "";
        @Override
        public void onClick(View v) {
            switch (rg.getCheckedRadioButtonId()){
                case R.id.btn_plus:
                    op = "+";
                    break;
                case R.id.btn_minu:
                    op = "-";
                    break;
                case R.id.btn_muti:
                    op = "*";
                    break;
                case R.id.btn_div:
                    op = "/";
                    break;
            }
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", Integer.parseInt((edit1.getText().toString())));
            intent.putExtra("num2", Integer.parseInt((edit2.getText().toString())));
            intent.putExtra("op", op);
            startActivityForResult(intent, 0);
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            int cul = data.getIntExtra("cul",0);
            Toast.makeText(getApplicationContext(), "계산: "+cul, Toast.LENGTH_SHORT).show();
        }
    }
}