package com.example.mynotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mynotes.databinding.ActivityDataInsertBinding;
import com.example.mynotes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
private NoteViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        noteViewModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DataInsertActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            String Title = data.getStringExtra("Title");
            String Disc = data.getStringExtra("Disc");
            Note note = new Note(Title,Disc);
            noteViewModel.insert(note);
            Toast.makeText(this,"note added", Toast.LENGTH_SHORT).show();


        }
    }
}