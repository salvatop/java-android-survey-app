package myapplication.salvatop.surveyapp;

import androidx.appcompat.app.AppCompatActivity;
import myapplication.salvatop.surveyapp.model.InternetProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave, btnStats;
    private RadioGroup radioGroup;
    private EditText clientNumber;
    private ArrayList<InternetProvider> surveyResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        btnSave.setOnClickListener(this);
        btnStats.setOnClickListener(this);
    }

    public void initialize(){
        btnSave = findViewById(R.id.btnSave);
        btnStats = findViewById(R.id.btnStat);
        radioGroup = findViewById(R.id.radioGroup);
        clientNumber = findViewById(R.id.editTextShowClients);
        clientNumber.setText(String.valueOf(InternetProvider.getClientsCount()));
        surveyResults = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSave) {
            saveData(view);
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("results", surveyResults);
            startActivity(intent);
        }
    }

    private void saveData(View view) {
        int btnProviders = radioGroup.getCheckedRadioButtonId();
        String oneProvider = null;

        switch (btnProviders) {
            case R.id.rdbBell : oneProvider = "Bell"; break;
            case R.id.rdbVideotron : oneProvider = "Videotron"; break;
            case R.id.rdbAcanac : oneProvider = "Acnac"; break;
            case R.id.rdbBravo : oneProvider = "Bravo"; break;
        }
        InternetProvider internetProvider = new InternetProvider(oneProvider);
        surveyResults.add(internetProvider);

        radioGroup.clearCheck();
        InternetProvider.setClientsCount(InternetProvider.getClientsCount() + 1);
        clientNumber.setText(String.valueOf(InternetProvider.getClientsCount()));
        Snackbar.make(view, "Survey added!", Snackbar.LENGTH_SHORT).show();

    }
}
