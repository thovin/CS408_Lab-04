package edu.jsu.mcis.cs408.lab04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import edu.jsu.mcis.cs408.lab04.databinding.MemoItemBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private MemoItemBinding binding;
    private List<Memo> data;

    public RecyclerViewAdapter(List<Memo> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder holder = new ViewHolder(binding.getRoot());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setMemo(data.get(position));
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Memo memo;
        private TextView idLabel;
        private TextView messageLabel;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public Memo getMemo() {
            return memo;
        }

        public void setMemo(Memo memo) {
            this.memo = memo;
        }

        public void bindData() {

            if (idLabel == null) {
                idLabel = (TextView) itemView.findViewById(R.id.memoIDLabel);
            }
            if (messageLabel == null) {
                messageLabel = (TextView) itemView.findViewById(R.id.memoMessageLabel);
            }
            idLabel.setText(String.valueOf(memo.getID()) + ": ");
            messageLabel.setText(memo.getMessage());

        }

    }


}
