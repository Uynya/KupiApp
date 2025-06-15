package com.example.kupiapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HisAct extends AppCompatActivity {
    TextView name;
    TextView history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        name = findViewById(R.id.usernameHis);
        history = findViewById(R.id.Log);
        SharedPreferences sharedPref = getSharedPreferences("my_data", Context.MODE_PRIVATE);

        name.setText("Здравствуйте, " + SaveData.Savedname + "!");
        history.setText(SaveData.Savedlogs);
    }

    public void Back(View view) {
        Intent intent = new Intent(this, MainAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //я не уверена,
        // как оно работает, но я не знаю, как сделать по-другому
        startActivity(intent);
        finish();
    }
}
