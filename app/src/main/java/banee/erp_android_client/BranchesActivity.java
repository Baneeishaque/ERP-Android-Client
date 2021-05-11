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
    public static ArrayList<String> branches = new ArrayList<>();

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

        branches.add("Branch 1");
        branches.add("Branch 2");
        branches.add("Branch 3");

        BranchsRecyclerViewAdaptor branchsRecyclerViewAdaptor = new BranchsRecyclerViewAdaptor(branches);
        recyclerViewBranches.setAdapter(branchsRecyclerViewAdaptor);
    }
}
