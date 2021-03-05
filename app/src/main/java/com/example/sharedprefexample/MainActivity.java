package com.example.sharedprefexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedprefexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView tvText;
    EditText etText;
    RadioButton save, load;
    SharedPreferences preferences;
    boolean flag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);


        preferences = getPreferences(MODE_PRIVATE);



        binding.btLoad.setOnClickListener((view) -> {
            flag = true;
        });

        binding.btSave.setOnClickListener((view -> {
            flag = false;
        }));


        binding.btSet.setOnClickListener((view -> {

            if (!flag) {
                SharedPreferences.Editor editor = preferences.edit();
                String text = binding.etText.getText().toString();
                editor.putString("TEXT", text);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Pref create", Toast.LENGTH_SHORT).show();
            }
            else {
                String text = preferences.getString("TEXT", "");
                binding.tvText.setText(text);
            }

        }));





    }
}