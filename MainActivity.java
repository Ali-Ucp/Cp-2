package com.example.practice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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

        TextView textViewNumber = findViewById(R.id.textviewnumber);
        TextView textViewResult = findViewById(R.id.textviewresult);
        Button check = findViewById(R.id.check);

        int number=Integer.parseInt(textViewNumber.getText().toString());
        check.setOnClickListener(v -> {
            String result = "";
            if (number % 2 == 0) {
                result = "The number is even";
            } else {
                result = "The number is odd";
            }
            textViewResult.setText(result);
                });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}