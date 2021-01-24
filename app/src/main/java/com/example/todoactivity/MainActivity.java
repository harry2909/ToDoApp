package com.example.todoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static TextView textBox;

    public static String[] toDoItems;

    public static int index;

    Button buttonNext;
    Button buttonPrev;

    private static final String TODO_INDEX = "todoIndex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = findViewById(R.id.textViewTodo);
        toDoItems = getResources().getStringArray(R.array.todos);
        textBox.setText(toDoItems[0]);
        buttonNext = findViewById(R.id.buttonNext);
        buttonPrev = findViewById(R.id.buttonPrev);
        if (savedInstanceState != null){
            index = savedInstanceState.getInt(TODO_INDEX, 0);
        }
    }

    public void buttonPrevious(View view) {
        index = (index -= 1) % toDoItems.length;
        textBox.setText(toDoItems[index]);
    }

    public void buttonNext(View view) {
        index = (index + 1) % toDoItems.length;
        textBox.setText(toDoItems[index]);
    }


}