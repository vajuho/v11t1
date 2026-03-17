package com.example.v11t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private ContactStorage storage;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        storage = ContactStorage.getInstance();

        recyclerView = findViewById(R.id.ListContactsRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter(getApplicationContext(), storage.getContacts()));
    }
    public void sortByGroup(View view) {
        ArrayList<Contact> currentList = ContactStorage.getInstance().getContacts();
        ArrayList<Contact> workConts = new ArrayList<>();
        ArrayList<Contact> personConts = new ArrayList<>();

        Iterator<Contact> iterator = currentList.iterator();
        while (iterator.hasNext()) {
            Contact con = iterator.next();
            if (con.getContactGroup().equals("Työ")) {
                workConts.add(con);
            } else {
                personConts.add(con);
            }
        }
        currentList.clear();
        currentList.addAll(workConts);
        currentList.addAll(personConts);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void sortByName(View view) {
        ArrayList<Contact> currentList = ContactStorage.getInstance().getContacts();
        Collections.sort(currentList, (first, second) ->
                        first.getFirstName().compareTo(second.getFirstName()));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void goToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
}