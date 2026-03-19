package com.example.v11t1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView ContactNameText;
    TextView ContactNumberText;
    TextView ContactGroupText;
    ImageView imageView;
    Button ContactDetailsButton;
    Button ContactDeleteButton;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        ContactNameText = itemView.findViewById(R.id.ContactNameText);
        ContactNumberText = itemView.findViewById(R.id.ContactNumberText);
        ContactGroupText = itemView.findViewById(R.id.ContactGroupText);
        imageView = itemView.findViewById(R.id.imageView);
        ContactDetailsButton = itemView.findViewById(R.id.ContactDetailsButton);
        ContactDeleteButton = itemView.findViewById(R.id.ContactDeleteButton);
    }
}
