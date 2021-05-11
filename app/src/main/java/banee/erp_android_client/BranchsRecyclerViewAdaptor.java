package banee.erp_android_client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BranchsRecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final String branchName = branches.get(position);
        BranchsViewHolder branchsViewHolder = (BranchsViewHolder) holder;
        branchsViewHolder.textViewBranchName.setText(branchName);
    }

    private OnBranchNameClickListener onBranchNameClickListener;

    @Override
    public int getItemCount() {

        return branches.size();
    }

    public interface OnBranchNameClickListener {

        void onBranchNameClick(View view, String branchName);
    }

    public class BranchsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewBranchName;

        public BranchsViewHolder(@NonNull View itemView) {

            super(itemView);
            this.textViewBranchName = itemView.findViewById(R.id.textViewBranchName);

            itemView.setOnClickListener(v -> onBranchNameClickListener.onBranchNameClick(itemView, branches.get(getAdapterPosition())));
        }
    }

    public void setOnBranchNameClickListener(final OnBranchNameClickListener onBranchNameClickListener){

        this.onBranchNameClickListener=onBranchNameClickListener;
    }
}
