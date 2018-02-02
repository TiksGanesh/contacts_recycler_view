package com.example.ganeshtikone.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ganeshtikone on 01/02/18.
 * Recycler View Adapter Class
 */

public class MyContactAdapter extends RecyclerView.Adapter<MyContactAdapter.ContactViewHolder>{



    /**
     * Interface to pass event to activity
     * of recycler view item
     */
    public interface OnContactClickListener {
       void onContactClick(int position);
    }


    private List<MyContacts> myContactsList;
    private Context context;
    private OnContactClickListener listener;



    public MyContactAdapter(List<MyContacts> myContactsList, Context context) {
        this.myContactsList = myContactsList;
        this.context = context;
    }

    public void setListener(OnContactClickListener listener) {
        this.listener = listener;
    }


    /**
     * ContactViewHolder class represent row_contacts.xml
     *  in JAVA format as Class
     */
    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewContactName;
        TextView textViewContactNumber;
        View parentLayout;

        public ContactViewHolder(View itemView) {
            super(itemView);

            textViewContactName = itemView.findViewById(R.id.textViewContactName);
            textViewContactNumber = itemView.findViewById(R.id.textViewContactNumber);
            parentLayout = itemView.findViewById(R.id.parentLayout);

            parentLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            // Let's catch the position
            int tappedPosition = getAdapterPosition();
            if (null != listener){
                listener.onContactClick(tappedPosition);
            }

        }
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(
                R.layout.row_contact,
                parent,
                false
        );


        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        MyContacts contacts = myContactsList.get(position);

        holder.textViewContactName.setText(contacts.getContactName());
        holder.textViewContactNumber.setText(contacts.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return myContactsList != null ?  myContactsList.size() : 0;
    }


}
