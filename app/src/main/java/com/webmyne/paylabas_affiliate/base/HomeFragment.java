package com.webmyne.paylabas_affiliate.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.SquareLayout;


public class HomeFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private LinearLayout linearGiftCode;



    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View convertView = inflater.inflate(R.layout.fragment_home, container, false);

        linearGiftCode = (LinearLayout)convertView.findViewById(R.id.linearGiftCode);
        linearGiftCode.setOnClickListener(clickListner);

        return convertView;
    }

    public View.OnClickListener clickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.linearGiftCode:

                    Toast.makeText(getActivity(), "giftcode clicked", Toast.LENGTH_SHORT).show();

                    break;



            }




        }
    };


}
