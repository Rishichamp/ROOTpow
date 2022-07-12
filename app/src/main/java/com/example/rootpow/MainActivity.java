package com.example.rootpow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editnum1;
    EditText editnum2;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editnum1=(EditText) findViewById(R.id.editTextNumberDecimal);
        editnum2=(EditText) findViewById(R.id.editTextNumberDecimal2);
        result=(TextView) findViewById(R.id.textView);
        btn=(Button) findViewById(R.id.button);
        result.setVisibility(View.INVISIBLE);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Root,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                btnx(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
    void btnx(int position)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editnum1.getText().toString().isEmpty()||editnum2.getText().toString().isEmpty())
                {
                    result.setText("None of the Fields can be empty");
                }
                else
                {
                    result.setVisibility(View.VISIBLE);
                    String value=editnum1.getText().toString();
                    String value2=editnum2.getText().toString();
                    double a=Double.parseDouble(value);
                    double b=Double.parseDouble(value2);
                    if (position==0)
                    {
                        double r=Math.pow(a,b);
                        result.setText(String.format("Answer=%.2f",r));
                    }
                    else if (position==1)
                    {
                        double r=Math.pow(a,1/b);
                        result.setText(String.format("Answer=%.2f",r));
                    }
                }
            }
        });
    }
}