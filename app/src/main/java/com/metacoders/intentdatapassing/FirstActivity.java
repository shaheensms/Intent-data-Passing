package com.metacoders.intentdatapassing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private TextView firstTextView;
    private Button nxtButton;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firstTextView = findViewById(R.id.textView_first);
        nxtButton = findViewById(R.id.button_first);

        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, Second_Activity.class);
                intent.putExtra("Message", "Hello from first activity");
                intent.putExtra("SecondMessage", "Hello Again");
                intent.putExtra("Value", 123);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String result = data.getStringExtra("returnData");

                Toast.makeText(FirstActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }

    }
}
