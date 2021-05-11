package banee.erp_android_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BranchViewActivity extends AppCompatActivity {

    Context activityContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_view);

        TextView textViewBranchName = findViewById(R.id.textViewBranchName);
        textViewBranchName.setText(DashboardActivity.selectedBranchName);

        Button buttonDeleteBranch = findViewById(R.id.buttonDeleteBranch);
        buttonDeleteBranch.setOnClickListener(v -> {

            DashboardActivity.branches.remove(textViewBranchName.getText().toString());
            Toast.makeText(getApplicationContext(), "Branch " + textViewBranchName.getText() + " deleted successfully...", Toast.LENGTH_LONG).show();
            startActivity(new Intent(activityContext, BranchesActivity.class));
            finish();
        });

        Button buttonUpdateBranch = findViewById(R.id.buttonUpdateBranch);
        buttonUpdateBranch.setOnClickListener(v -> {

            Intent updateBranchIntent = new Intent(activityContext, AddBranchActivity.class);
            updateBranchIntent.putExtra("mode", "update");
            startActivity(updateBranchIntent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        startActivity(new Intent(activityContext, BranchesActivity.class));
        finish();
    }
}
