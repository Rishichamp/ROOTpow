package com.example.rootpow;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText first = findViewById(R.id.editTextNumberDecimal);
        EditText second = findViewById(R.id.editTextNumberDecimal2);
        TextView result = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Root, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        result.setVisibility(View.INVISIBLE);
        button.setOnClickListener(view -> {
            // Errors and answers share this view, so it has to be visible for both.
            result.setVisibility(View.VISIBLE);
            result.setText(Calculator.calculate(first.getText().toString(),
                    second.getText().toString(), spinner.getSelectedItemPosition()));
        });
    }
}
