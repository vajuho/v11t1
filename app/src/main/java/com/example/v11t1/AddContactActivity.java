package com.example.v11t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {
    EditText FirstNameEdit;
    EditText LastNameEdit;
    EditText PhoneNumberEdit;
    RadioGroup ContactTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        LastNameEdit = findViewById(R.id.LastNameEdit);
        PhoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        ContactTypeRadioGroup = findViewById(R.id.ContactTypeRadioGroup);
    }

    public void addContact(View view) {
        String firstName = FirstNameEdit.getText().toString().trim();
        String lastName = LastNameEdit.getText().toString().trim();
        String phoneNumber = PhoneNumberEdit.getText().toString().trim();
        String contactGroup;
        int selectedId = ContactTypeRadioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.PersonalRadioButton) {
            contactGroup = "Henkilökohtainen";
        } else {
            contactGroup = "Työ";
        }
        Contact contact = new Contact(firstName, lastName, phoneNumber, contactGroup);
        ContactStorage.getInstance().addContact(contact);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}