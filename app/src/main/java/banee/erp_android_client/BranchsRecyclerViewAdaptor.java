package banee.erp_android_client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BranchsRecyclerViewAdaptor extends RecyclerView.Adapter<BranchsViewHolder> {

    private ArrayList<String> branches;

    public BranchsRecyclerViewAdaptor(ArrayList<String> branches) {

        this.branches = branches;
    }

    @NonNull
    @Override
    public BranchsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_branch, parent, false);
        return new BranchsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchsViewHolder holder, int position) {

        final String branchName = branches.get(position);
        holder.textViewBranchName.setText(branchName);
        holder.textViewBranchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {

        return branches.size();
    }
}
