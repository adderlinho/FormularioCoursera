package asoftwaresolution.formulariocoursera;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText form_username, form_borndate, form_phone, form_email, form_description;
    private Button btnSiguiente;

    private int year, month, day;

    public void setDate()
    {
        form_borndate.setText(day + "/" + month + "/" + year);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        form_username       = (TextInputEditText) findViewById(R.id.form_username);
        form_borndate       = (TextInputEditText) findViewById(R.id.form_borndate);
        form_phone          = (TextInputEditText) findViewById(R.id.form_phone);
        form_email          = (TextInputEditText) findViewById(R.id.form_email);
        form_description    = (TextInputEditText) findViewById(R.id.form_description);
        btnSiguiente        = (Button) findViewById(R.id.btnSiguiente);

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        year                        = calendar.get(java.util.Calendar.YEAR);
        month                       = calendar.get(java.util.Calendar.MONTH);
        day                         = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        form_borndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int yearPicker, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        month = monthOfYear + 1;
                        year = yearPicker;
                        setDate();
                    }
                }, year, month, day);
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Confirmacion.class);
                intent.putExtra(getResources().getString(R.string.param_username), form_username.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_borndate), form_borndate.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_phone), form_phone.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_email), form_email.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_description), form_description.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            form_username.setText(bundle.getString(getResources().getString(R.string.param_username)));
            form_borndate.setText(bundle.getString(getResources().getString(R.string.param_borndate)));
            form_phone.setText(bundle.getString(getResources().getString(R.string.param_phone)));
            form_email.setText(bundle.getString(getResources().getString(R.string.param_email)));
            form_description.setText(bundle.getString(getResources().getString(R.string.param_description)));
        }
    }
}
