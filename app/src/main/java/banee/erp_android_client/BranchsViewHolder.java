package banee.erp_android_client;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BranchsViewHolder extends RecyclerView.ViewHolder {

    TextView textViewBranchName;

    public BranchsViewHolder(@NonNull View itemView) {

        super(itemView);
        textViewBranchName=itemView.findViewById(R.id.textViewBranchName);
    }
}
