package myapplication.salvatop.surveyapp;

import androidx.appcompat.app.AppCompatActivity;
import myapplication.salvatop.surveyapp.model.InternetProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private Button btnReturn;
    private EditText providers, nbOfClient, percentageOfProvider;
    private int bell, videotron, bravo, acanac = 0;
    private int totalClients = InternetProvider.getClientsCount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();

        btnReturn.setOnClickListener(this);
        providers.addTextChangedListener(this);
    }

    public int computePercentage(int provider) {
        return (provider * 100) / totalClients;
    }

    public void initialize() {
        btnReturn = findViewById(R.id.btnReturn);
        providers = findViewById(R.id.editTextProvider);
        nbOfClient = findViewById(R.id.editTextNbOfClients);
        percentageOfProvider = findViewById(R.id.editTextpercentageOfClient);

        ArrayList<InternetProvider> data = new ArrayList((ArrayList<InternetProvider>) getIntent().getExtras().getSerializable("results"));
        for(InternetProvider internetProvider : data) {
            switch (internetProvider.getInternetProvider()) {
                case "Bell":
                    bell++;
                    break;
                case "Videotron":
                    videotron++;
                    break;
                case "Bravo":
                    bravo++;
                    break;
                case "Acanac":
                    acanac++;
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if(editable.toString().equals("Bell")){
            nbOfClient.setText(String.valueOf(bell));
            String txt = String.valueOf(computePercentage(bell));
            percentageOfProvider.setText(txt);

        } else if(editable.toString().equals("Videotron")){
            nbOfClient.setText(String.valueOf(videotron));
            String txt = String.valueOf(computePercentage(videotron));
            percentageOfProvider.setText(txt);

        } else if(editable.toString().equals("Bravo")){
            nbOfClient.setText(String.valueOf(bravo));
            String txt = String.valueOf(computePercentage(bravo));
            percentageOfProvider.setText(txt);

        } else if(editable.toString().equals("Acanac")){
            nbOfClient.setText(String.valueOf(acanac));
            String txt = String.valueOf(computePercentage(acanac));
            percentageOfProvider.setText(txt);
        }
    }
}
