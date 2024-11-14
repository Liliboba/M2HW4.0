package com.example.m2hw40;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.editText2);
        EditText password = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!name.getText().toString().isEmpty() || !password.getText().toString().isEmpty()) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!name.getText().toString().isEmpty() || !password.getText().toString().isEmpty()) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textName = name.getText().toString();
                String textPassword = password.getText().toString();

                if(textName.equals(textPassword) ){
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                    findViewById(R.id.textView).setVisibility(View.GONE);
                    findViewById(R.id.textView3).setVisibility(View.GONE);
                    findViewById(R.id.textView4).setVisibility(View.GONE);
                    findViewById(R.id.editText2).setVisibility(View.GONE);
                    findViewById(R.id.editText).setVisibility(View.GONE);
                    findViewById(R.id.button).setVisibility(View.GONE);
                    findViewById(R.id.textView6).setVisibility(View.GONE);
                    findViewById(R.id.textView5).setVisibility(View.GONE);
                    findViewById(R.id.textDopolnenie).setVisibility(View.GONE);
                }else{
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}