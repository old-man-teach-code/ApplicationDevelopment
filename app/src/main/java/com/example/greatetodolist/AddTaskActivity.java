package com.example.greatetodolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText taskNameEditText;

    private EditText taskContentEditText;
    private RadioButton rd1, rd2, rd3, rd4, rd5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        submitButton = findViewById(R.id.submitButton);
        taskNameEditText = findViewById(R.id.TaskNameEditText);
        taskContentEditText = findViewById(R.id.TaskContentEditText);
        rd1 = findViewById(R.id.radioButtonImport1);
        rd2 = findViewById(R.id.radioButtonImport2);
        rd3 = findViewById(R.id.radioButtonImport3);
        rd4 = findViewById(R.id.radioButtonImport4);
        rd5 = findViewById(R.id.radioButtonImport5);

        submitButton.setOnClickListener(v -> {
            String taskName = taskNameEditText.getText().toString();
            String taskContent = taskContentEditText.getText().toString();
            if(taskName == null || taskName.isEmpty()){
                taskNameEditText.setError("Task name is required");
                return;
            }
            if(taskContent == null || taskContent.isEmpty()){
                taskContentEditText.setError("Task content is required");
            }
            int priority = 1;
            if(rd1.isChecked()){
                priority = 1;
            }else if(rd2.isChecked()){
                priority = 2;
            } else if(rd3.isChecked()){
                priority = 3;
            } else if(rd4.isChecked()){
                priority = 4;
            } else if(rd5.isChecked()){
                priority = 5;
            }
            TempMemory.tasks.add(new Task(taskName, taskContent, true, priority));
            Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
            startActivity(intent);

        });


    }
}