package asoftwaresolution.formulariocoursera;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    private TextView con_username, con_borndate, con_phone, con_email, con_description;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        con_username   = (TextView) findViewById(R.id.con_username);
        con_borndate   = (TextView) findViewById(R.id.con_borndate);
        con_phone      = (TextView) findViewById(R.id.con_phone);
        con_email      = (TextView) findViewById(R.id.con_email);
        con_description = (TextView) findViewById(R.id.con_description);
        btnEditar       = (Button) findViewById(R.id.btnEditar);

        Bundle bundle = getIntent().getExtras();

        con_username.setText(bundle.getString(getResources().getString(R.string.param_username)));
        con_borndate.setText(bundle.getString(getResources().getString(R.string.param_borndate)));
        con_phone.setText(bundle.getString(getResources().getString(R.string.param_phone)));
        con_email.setText(bundle.getString(getResources().getString(R.string.param_email)));
        con_description.setText(bundle.getString(getResources().getString(R.string.param_description)));

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Confirmacion.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.param_username), con_username.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_borndate), con_borndate.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_phone), con_phone.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_email), con_email.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_description), con_description.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
