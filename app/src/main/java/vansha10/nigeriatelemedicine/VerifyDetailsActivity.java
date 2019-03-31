package vansha10.nigeriatelemedicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VerifyDetailsActivity extends AppCompatActivity {

    Details details;

    TextView givenName;
    TextView middleName;
    TextView lastName;
    TextView phoneNumber;
    TextView mComplaint;
    Button confirmButton;
    Button modifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_details);

        details = (Details) getIntent().getSerializableExtra("Details");

        findViewByIds();
        initializeUI();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDetails();
            }
        });
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifyDetails();
            }
        });
    }

    private void findViewByIds() {
        givenName = findViewById(R.id.g_name);
        middleName = findViewById(R.id.m_name);
        lastName = findViewById(R.id.l_name);
        phoneNumber = findViewById(R.id.pno);
        mComplaint = findViewById(R.id.compl);
        confirmButton = findViewById(R.id.confirm_button);
        modifyButton = findViewById(R.id.modify_button);
    }

    public void initializeUI() {
        givenName.setText(details.getGivenName());
        middleName.setText(details.getMiddleName());
        lastName.setText(details.getLastName());
        phoneNumber.setText(details.getPhoneNumber());
        mComplaint.setText(details.getComplaint());
    }

    private void confirmDetails() {
        Intent intent = new Intent(VerifyDetailsActivity.this, SuccessActivity.class);
        startActivity(intent);
    }

    private void modifyDetails() {
        finish();
    }
}
