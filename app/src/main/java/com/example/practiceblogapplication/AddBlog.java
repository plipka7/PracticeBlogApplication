package com.example.practiceblogapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AddBlog extends AppCompatActivity {
    private BlogRepository repository;
    private EditText nameInput;
    private EditText blogInput;
    private Button submitButton;

    public static final String USER_BLOG = "al;skdjfalskdjf";
    public static final String USER_NAME = "o9wwleknfsldlfjsda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blog);

        repository = new BlogRepository(this.getApplication());

        /*Get the view objects*/
        nameInput = this.findViewById(R.id.fullName);
        blogInput = this.findViewById(R.id.userBlog);
        submitButton = this.findViewById(R.id.submitButton);

        /*Action for the submit button*/
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blog = blogInput.getText().toString();
                String fullName = nameInput.getText().toString();
                Intent replyIntent = new Intent();
                if(blog.length() == 0 || fullName.length() == 0) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra(USER_NAME, fullName);
                    replyIntent.putExtra(USER_BLOG, blog);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
