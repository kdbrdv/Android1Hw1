package com.example.android1hw1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.android1hw1.databinding.ColiseumActivityMainBinding;

public class SecondActivity extends AppCompatActivity {


    ColiseumActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ColiseumActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.firstRectangle.setOnClickListener(v -> startActivity(new Intent("android.media.action.IMAGE_CAPTURE")));

        binding.secondRectangle.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, 2);
        });

        binding.thirdRectangle.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        binding.btnPass.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivityForResult(intent, 1);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            binding.tvText.setText(data.getStringExtra("name"));
        }
    }
}