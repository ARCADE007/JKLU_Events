package com.example.jkluevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class moderatorSignUP extends AppCompatActivity {

    TextInputLayout menu;
    AutoCompleteTextView menu2;

    ArrayList<String> arrayList_role;
    ArrayAdapter<String> arrayAdapter_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderator_sign_up);
        menu=(TextInputLayout)findViewById(R.id.menu);
        menu2=(AutoCompleteTextView)findViewById(R.id.menu2);

        arrayList_role=new ArrayList<>();
        arrayList_role.add("Coding Club");
        arrayList_role.add("Dance Club");
        arrayList_role.add("Drama Club");
        arrayList_role.add("Music Club");
        arrayList_role.add("Sports Club");
        arrayList_role.add("Student Life");
        arrayList_role.add("Student");
        arrayList_role.add("Admin");

        arrayAdapter_role=new ArrayAdapter<>(getApplicationContext(),R.layout.list_item,arrayList_role);
        menu2.setAdapter(arrayAdapter_role);
        menu2.setThreshold(1);



    }
}