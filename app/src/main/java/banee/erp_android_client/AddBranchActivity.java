package banee.erp_android_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddBranchActivity extends AppCompatActivity {

    Context activityContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        TextInputEditText textInputEditTextBranchName = findViewById(R.id.textInputEditTextBranchName);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        if (getIntent().getExtras() == null) {

            buttonSubmit.setOnClickListener(v -> {

                String branchName = textInputEditTextBranchName.getText().toString();
                if (branchName.isEmpty()) {

                    textInputEditTextBranchName.setError("Please enter branch name..");
                    textInputEditTextBranchName.requestFocus();

                } else {

                    DashboardActivity.branches.add(branchName);
                    Toast.makeText(getApplicationContext(), "Branch " + branchName + " added successfully...", Toast.LENGTH_LONG).show();
                    textInputEditTextBranchName.setText("");
                }
            });

        } else {

            buttonSubmit.setText("Update");
            textInputEditTextBranchName.setText(DashboardActivity.selectedBranchName);
            buttonSubmit.setOnClickListener(v -> {

                String branchName = textInputEditTextBranchName.getText().toString();
                if (branchName.isEmpty()) {

                    textInputEditTextBranchName.setError("Please enter branch name..");
                    textInputEditTextBranchName.requestFocus();

                } else {

                    DashboardActivity.branches.set(DashboardActivity.branches.indexOf(DashboardActivity.selectedBranchName), branchName);
                    Toast.makeText(getApplicationContext(), "Branch " + branchName + " updated successfully...", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(activityContext, BranchesActivity.class));
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {

        //TODO : Workflow for back button click from update page
        super.onBackPressed();
        startActivity(new Intent(activityContext, BranchesActivity.class));
        finish();
    }
}
