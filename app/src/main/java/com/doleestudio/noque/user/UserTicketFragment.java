package com.doleestudio.noque.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.doleestudio.noque.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserTicketFragment extends Fragment {


    public UserTicketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_user_ticket, container, false);
        setEventHandlerForNewTicketBtn(layout);
        setEventHandlerForTicketItem(layout);
        return layout;
    }

    private void setEventHandlerForNewTicketBtn(View layout) {
        ImageButton btnNewTicket = (ImageButton) layout.findViewById(R.id.btn_user_ticket_new);
        btnNewTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserStoreActivity();
            }
        });
    }

    private void openUserStoreActivity() {
        Intent intent = new Intent(getActivity(), UserStoreActivity.class);
        startActivity(intent);
    }


    private void setEventHandlerForTicketItem(View layout) {
        View ticketItemView = (View) layout.findViewById(R.id.user_ticket_1);
        ticketItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStoreDetailActivity();
            }
        });

    }

    private void openStoreDetailActivity() {
        Intent intent = new Intent(getActivity(), UserStoreDetailActivity.class);
        startActivity(intent);
    }
}
