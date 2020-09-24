package com.otus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Adding extends AppCompatActivity {

    private TextInputEditText editTitle;
    private TextInputEditText editDesc;
    private MaterialButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        editDesc = findViewById(R.id.edit_desc_two);
        editTitle = findViewById(R.id.edit_title_two);
        mButton = findViewById(R.id.adding);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.title, editTitle.getText().toString());
                intent.putExtra(MainActivity.desc, editDesc.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


}
