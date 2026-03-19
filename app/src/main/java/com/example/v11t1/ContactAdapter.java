package com.example.v11t1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.ContactNameText.setText(contacts.get(position).getFullName());
        holder.ContactNumberText.setText(contacts.get(position).getNumber());
        holder.ContactGroupText.setText(contacts.get(position).getContactGroup());
        holder.imageView.setImageResource(R.drawable.photo_contact);

        holder.ContactNumberText.setVisibility(View.GONE);
        holder.ContactGroupText.setVisibility(View.GONE);

        holder.ContactDetailsButton.setOnClickListener(view -> {
            if (holder.ContactNumberText.getVisibility() == View.GONE) {
                holder.ContactNumberText.setVisibility(View.VISIBLE);
                holder.ContactGroupText.setVisibility(View.VISIBLE);
            } else {
                holder.ContactNumberText.setVisibility(View.GONE);
                holder.ContactGroupText.setVisibility(View.GONE);
            }
        });

        holder.ContactDeleteButton.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(pos);
            notifyItemRemoved(pos);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}

