package com.doleestudio.noque.user;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return inflater.inflate(R.layout.fragment_user_ticket, container, false);
    }


}
