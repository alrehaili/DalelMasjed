package com.example.dalelmasjed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dalelmasjed.Adaptor.MasjedRowAdaptor;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;
    RadioButton radioButton2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton = findViewById(R.id.radioButtonriyadh);
        radioButton.setChecked(true);

        radioGroup = findViewById(R.id.radiog);

        button = findViewById(R.id.buttonsrh);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId ==-1)
                {
                    Toast.makeText(getApplicationContext(),"please select a region", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    radioButton2 =  findViewById(selectedId);
                    Toast.makeText(getApplicationContext(),radioButton2.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext() , MasjedList.class);

                    intent.putExtra("region" , radioButton2.getText());
                    startActivity(intent);
                }

            }
        });





    }
}
