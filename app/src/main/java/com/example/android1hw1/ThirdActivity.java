package com.example.android1hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android1hw1.databinding.ColiseumActivityMainBinding;
import com.example.android1hw1.databinding.ThirdActivityMainBinding;

public class ThirdActivity extends AppCompatActivity {
    ThirdActivityMainBinding binding;
    public String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ThirdActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChange.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("name", binding.etDigit.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}