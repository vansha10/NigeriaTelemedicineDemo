package vansha10.nigeriatelemedicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class EnterDetailsActivity extends AppCompatActivity {

    EditText givenName;
    EditText middleName;
    EditText lastName;
    EditText phoneNumber;
    EditText mComplaint;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        findViewByIds();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyDetails()) {
                    submitDetails();
                }
            }
        });
    }

    private void findViewByIds() {
        givenName = findViewById(R.id.given_name);
        middleName = findViewById(R.id.middle_name);
        lastName = findViewById(R.id.last_name);
        phoneNumber = findViewById(R.id.phone_number);
        mComplaint = findViewById(R.id.complaint);
        submitButton = findViewById(R.id.submit_button);
    }

    private boolean verifyDetails() {
        if (givenName.getText().toString().equals("")) {
            givenName.setError("Required field");
            return false;
        }
        if (lastName.getText().toString().equals("")) {
            lastName.setError("Required field");
            return false;
        }
        if (phoneNumber.getText().toString().equals("")) {
            phoneNumber.setError("Required field");
            return false;
        }
        if (mComplaint.getText().toString().equals("")) {
            mComplaint.setError("Required field");
            return false;
        }
        return true;
    }

    private void submitDetails() {
        String gName = givenName.getText().toString();
        String mName = middleName.getText().toString();
        String lName = lastName.getText().toString();
        String pNumber = phoneNumber.getText().toString();
        String complaint = mComplaint.getText().toString();
        Details details = new Details(gName, mName, lName, pNumber, complaint);

        Intent intent = new Intent(EnterDetailsActivity.this, VerifyDetailsActivity.class);
        intent.putExtra("Details", details);
        startActivity(intent);
    }
}
