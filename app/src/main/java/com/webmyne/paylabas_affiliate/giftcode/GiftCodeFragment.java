package com.webmyne.paylabas_affiliate.giftcode;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.base.MyDrawerActivity;
import com.webmyne.paylabas_affiliate.custom_components.PagerSlidingTabStrip;
import com.webmyne.paylabas_affiliate.model.User;


public class GiftCodeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    PagerSlidingTabStrip tabs;
    public ViewPager pager;
    public MyPagerAdapter adapter;
   // ButtonFloat btnFloatAddMoney;
   private User user;


    public static GiftCodeFragment newInstance(String param1, String param2) {
        GiftCodeFragment fragment = new GiftCodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GiftCodeFragment() {
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

        View convertView = inflater.inflate(R.layout.fragment_gift_code, container, false);

        tabs=(PagerSlidingTabStrip)convertView.findViewById(R.id.tabs_giftcode);
        pager=(ViewPager)convertView.findViewById(R.id.pager_giftcode);

/*        btnFloatAddMoney = (ButtonFloat)convertView.findViewById(R.id.buttonFloatAddMoney);
        btnFloatAddMoney.setDrawableIcon(getResources().getDrawable(R.drawable.ic_action_new));*/

        adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        return convertView;


    }

    public void setHome(){
        pager.setCurrentItem(0,true);
    }

    @Override
    public void onResume() {
        super.onResume();

/*
         ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
         user = complexPreferences.getObject("current_user", User.class);
        ((MyDrawerActivity)getActivity()).setToolTitle("Hi, "+user.FName);
        ((MyDrawerActivity)getActivity()).setToolSubTitle("Balance "+getResources().getString(R.string.euro)+" "+user.LemonwayAmmount);

*/
//        ((MyDrawerActivity)getActivity()).setToolColor(getResources().getColor(R.color.color_giftcode));


    }


    public class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"REDEEM GC","GENERATE GC"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {


            if(position == 0){

                return RedeemGCFragment_Parent.newInstance("", "");

            }else if(position == 1){

                return GenerateGCFragment.newInstance("","");

            }else{
                return GenerateGCFragment.newInstance("","");
            }


/*

            switch (position){

                case 0:
                    return GiftCodeHomeFragment.newInstance("","");
                case 1: return GenerateGCFragment.newInstance("","");
                case 2: return CombineGCFragment.newInstance("","");
                case 3: return RedeemGCFragment_Parent.newInstance("","");

                default: return null;


            }
*/
        }
    }



}
