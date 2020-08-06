package com.geektech.booksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listBooks;
    private final String KEY_FOR_BOOK = "key";
    private final String KEY_FOR_NAME_BOOK = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBooks();
        createRecycler();

    }

    public void createRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        BooksAdapter booksAdapter = new BooksAdapter(listBooks);
        recyclerView.setAdapter(booksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        booksAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onBookClickListener(int position) {
                Intent intent = new Intent(getApplicationContext(), BooksActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra(KEY_FOR_BOOK, R.drawable.harry_potter);
                        intent.putExtra(KEY_FOR_NAME_BOOK, listBooks.get(position));
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra(KEY_FOR_BOOK, R.drawable.think);
                        intent.putExtra(KEY_FOR_NAME_BOOK, listBooks.get(position));
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra(KEY_FOR_BOOK, R.drawable.alhimik);
                        intent.putExtra(KEY_FOR_NAME_BOOK, listBooks.get(position));
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra(KEY_FOR_BOOK, R.drawable.islam);
                        intent.putExtra(KEY_FOR_NAME_BOOK, listBooks.get(position));
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra(KEY_FOR_BOOK, R.drawable.pod);
                        intent.putExtra(KEY_FOR_NAME_BOOK, listBooks.get(position));
                        startActivity(intent);
                        break;
                }
            }
        });
        booksAdapter.notifyDataSetChanged();
    }

    private void addBooks() {
        listBooks = new ArrayList<>();
        listBooks.add("Гарри поттер");
        listBooks.add("Думай и богатей");
        listBooks.add("Алхимик");
        listBooks.add("Ислам");
        listBooks.add("Подсознание может все");
    }
}