package com.example.jkluevents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.UUID;
import java.util.HashMap;

public class createEvent extends AppCompatActivity {

    private TextInputLayout eventName, venue, registrationLink, eventDescription, facultyName, facultyEmail, facultyContact, studentName1, studentEmail1, studentContact1, studentName2, studentEmail2, studentContact2;
    private Button createEvent;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        eventName = (TextInputLayout)findViewById(R.id.eventName);
        venue = (TextInputLayout)findViewById(R.id.venue);
        registrationLink = (TextInputLayout)findViewById(R.id.registrationLink);
        eventDescription = (TextInputLayout)findViewById(R.id.eventDescription);
        facultyName = (TextInputLayout)findViewById(R.id.facultyName);
        facultyEmail = (TextInputLayout)findViewById(R.id.facultyEmail);
        facultyContact = (TextInputLayout)findViewById(R.id.facultyContact);
        studentName1 = (TextInputLayout)findViewById(R.id.studentName1);
        studentEmail1 = (TextInputLayout)findViewById(R.id.studentEmail1);
        studentContact1 = (TextInputLayout)findViewById(R.id.studentContact1);
        studentName2 = (TextInputLayout)findViewById(R.id.studentName2);
        studentEmail2 = (TextInputLayout)findViewById(R.id.studentEmail2);
        studentContact2 = (TextInputLayout)findViewById(R.id.studentContact2);
        createEvent = (Button)findViewById(R.id.textButton);

        db = FirebaseFirestore.getInstance();

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EventName = eventName.getEditText().getText().toString();
                String Venue = venue.getEditText().getText().toString();
                String RegistrationLink = registrationLink.getEditText().getText().toString();
                String EventDescription = eventDescription.getEditText().getText().toString();
                String FacultyName = facultyName.getEditText().getText().toString();
                String FacultyEmail = facultyEmail.getEditText().getText().toString();
                String FacultyContact = facultyContact.getEditText().getText().toString();
                String StudentName1 = studentName1.getEditText().getText().toString();
                String StudentEmail1 = studentEmail1.getEditText().getText().toString();
                String StudentContact1 = studentContact1.getEditText().getText().toString();
                String StudentName2 = studentName2.getEditText().getText().toString();
                String StudentEmail2 = studentEmail2.getEditText().getText().toString();
                String StudentContact2 = studentContact2.getEditText().getText().toString();
                String id = UUID.randomUUID().toString();

                saveToFirestore(id, EventName, Venue, RegistrationLink, EventDescription, FacultyName, FacultyEmail, FacultyContact, StudentName1, StudentEmail1, StudentContact1, StudentName2, StudentEmail2, StudentContact2);
            }
        });
    }
    private void saveToFirestore(String id, String EventName, String Venue, String RegistrationLink, String EventDescription, String FacultyName, String FacultyEmail, String FacultyContact, String StudentName1, String StudentEmail1, String StudentContact1, String StudentName2, String StudentEmail2, String StudentContact2){
        if (!EventName.isEmpty() && !Venue.isEmpty() && !RegistrationLink.isEmpty() && !EventDescription.isEmpty() && !FacultyName.isEmpty() && !FacultyEmail.isEmpty() && !FacultyContact.isEmpty() && !StudentName1.isEmpty() && !StudentEmail1.isEmpty() && !StudentContact1.isEmpty() && !StudentName2.isEmpty() && !StudentEmail2.isEmpty() && !StudentContact2.isEmpty()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("EventName", EventName);
            map.put("Venue", Venue);
            map.put("RegistrationLink", RegistrationLink);
            map.put("EventDescription", EventDescription);
            map.put("FacultyName", FacultyName);
            map.put("FacultyEmail", FacultyEmail);
            map.put("FacultyContact", FacultyContact);
            map.put("StudentName1", StudentName1);
            map.put("StudentEmail1", StudentEmail1);
            map.put("StudentContact1", StudentContact1);
            map.put("StudentName2", StudentName1);
            map.put("StudentEmail2", StudentEmail2);
            map.put("StudentContact2", StudentContact2);

            db.collection("Documents").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(createEvent.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(createEvent.this, "Failed !!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else
            Toast.makeText(this, "Empty Fields are not Allowed !!", Toast.LENGTH_SHORT).show();
    }

}