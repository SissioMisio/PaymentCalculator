package it.edu.iiscopernico.paymentcalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private final Item[] localDataSet;

    public CustomAdapter(Item[] dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getName().setText(localDataSet[position].getName());
        int amount = localDataSet[position].getAmount();
        if (amount != 0)
            viewHolder.getAmount().setText(MessageFormat.format("{0} {1}", amount, localDataSet[position].getUnit()));
        viewHolder.getMinus().setOnClickListener(v -> {
            localDataSet[position].decrementCount();
            viewHolder.count.setText(String.valueOf(localDataSet[position].getCount()));
        });
        viewHolder.getPlus().setOnClickListener(v -> {
            localDataSet[position].incrementCount();
            viewHolder.count.setText(String.valueOf(localDataSet[position].getCount()));
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView amount;
        private final TextView count;
        private final Button minus;
        private final Button plus;

        public ViewHolder(View view) { // commento test
            super(view);

            name = view.findViewById(R.id.name);
            amount = view.findViewById(R.id.amount);
            count = view.findViewById(R.id.count);
            minus = view.findViewById(R.id.minus);
            plus = view.findViewById(R.id.plus);
        }

        public TextView getName() {
            return name;
        }

        public TextView getAmount() {
            return amount;
        }

        public Button getMinus() {
            return minus;
        }

        public Button getPlus() {
            return plus;
        }
    }
}