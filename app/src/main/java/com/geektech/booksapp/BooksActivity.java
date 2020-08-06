package com.geektech.booksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BooksActivity extends AppCompatActivity {

    private TextView textView;
    private final String KEY_FOR_BOOK = "key";
    private final String KEY_FOR_NAME_BOOK = "key2";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        textView = findViewById(R.id.tv_for_books);
        imageView = findViewById(R.id.image_view);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra(KEY_FOR_BOOK, R.drawable.ic_launcher_background));
        textView.setText(intent.getStringExtra(KEY_FOR_NAME_BOOK));

    }
}