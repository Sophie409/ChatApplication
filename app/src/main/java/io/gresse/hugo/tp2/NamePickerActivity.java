package io.gresse.hugo.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class NamePickerActivity extends AppCompatActivity {

    public static final String TAG = NamePickerActivity.class.getSimpleName();

    EditText    mNameEditText;
    EditText    mEmailEditText;
    Button     mSubmitButton;
    String username;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_namepicker);
        mNameEditText = findViewById(R.id.mNameEditText);
        mEmailEditText = findViewById(R.id.mEmailEditText);
        mSubmitButton = findViewById(R.id.mSubmitButton);

        username = UserStorage.getUsername(this);
        if (username != null) {
            mNameEditText.setText(username);
        }

        email = UserStorage.getEmail(this);
        if (email != null) {
            mEmailEditText.setText(email);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mNameEditText.getText().toString().isEmpty() && !mNameEditText.getText().toString().isEmpty()) {
                    UserStorage.saveUserInfo(getApplicationContext(), mNameEditText.getText().toString(), mEmailEditText.getText().toString());
                    goToMainActivity();
                    return;
                }
            }
        };
        mSubmitButton.setOnClickListener(listener);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    private boolean saveUserData() {
        UserStorage.saveUserInfo(this, mNameEditText.getText().toString(), mEmailEditText.getText().toString());
        return true;
    }

}