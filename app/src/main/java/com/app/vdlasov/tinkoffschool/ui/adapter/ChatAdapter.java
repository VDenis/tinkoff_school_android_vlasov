package com.app.vdlasov.tinkoffschool.ui.adapter;

import com.app.vdlasov.tinkoffschool.R;
import com.app.vdlasov.tinkoffschool.ui.common.OnItemClickListener;
import com.app.vdlasov.tinkoffschool.ui.model.MessageUiItem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Denis on 31.03.2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<MessageUiItem> dataSet;

    private OnItemClickListener clickListener;

    public ChatAdapter(final List<MessageUiItem> dataSet, final OnItemClickListener clickListener) {
        this.dataSet = dataSet;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public int getItemViewType(final int position) {
        return dataSet.get(position).getLayoutId();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.message.setText(dataSet.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public ViewHolder(final View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.tv_chat_message);
            setListener(clickListener);
        }

        public void setListener(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
