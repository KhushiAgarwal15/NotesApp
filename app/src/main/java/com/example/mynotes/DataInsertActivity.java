package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynotes.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);
        binding=ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Title", binding.Title.getText().toString());
                intent.putExtra("Disc",binding.Disc.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}