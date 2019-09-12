package com.metacoders.intentdatapassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {

    private TextView secondTextView;
    private Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondTextView = findViewById(R.id.textView_second);
        prevButton = findViewById(R.id.button_second);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String message = extras.getString("Message");
            String secMessage = extras.getString("SecondMessage");
            int extraInt = extras.getInt("Value");

            secondTextView.setText(message+" "+secMessage+" "+ String.valueOf(extraInt));
        }

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From second activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
