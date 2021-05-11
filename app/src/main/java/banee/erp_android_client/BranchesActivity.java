package banee.erp_android_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BranchesActivity extends AppCompatActivity {

    Context activityContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);

        Button buttonAddBranch = findViewById(R.id.buttonAddBranch);
        buttonAddBranch.setOnClickListener(v -> {

            startActivity(new Intent(activityContext, AddBranchActivity.class));
            finish();
        });

        RecyclerView recyclerViewBranches = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewBranches.setLayoutManager(linearLayoutManager);
        recyclerViewBranches.setHasFixedSize(true);

        DashboardActivity.branches.add("Branch 1");
        DashboardActivity.branches.add("Branch 2");
        DashboardActivity.branches.add("Branch 3");

        BranchsRecyclerViewAdaptor branchsRecyclerViewAdaptor = new BranchsRecyclerViewAdaptor(DashboardActivity.branches);
        recyclerViewBranches.setAdapter(branchsRecyclerViewAdaptor);
    }
}
