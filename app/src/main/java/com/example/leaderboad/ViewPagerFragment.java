package com.example.leaderboad;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerFragment extends Fragment {
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        buttonSubmit = view.findViewById(R.id.btnSubmit);
        buttonSubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                getFragmentManager().beginTransaction().replace(R.id.view_pager, ProjectSubmissionActivity.class)
//                        .addToBackStack(null).commit();
                startActivity(new Intent(getContext(), ProjectSubmissionActivity.class) );
            }
        } );

        final LeaderBoadFragment leaderBoadFragment = new LeaderBoadFragment();
        final SkillIqFragment skillIqFragment = new SkillIqFragment();

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter( new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                    return position == 0 ? leaderBoadFragment : skillIqFragment;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Learning Leaders" : "Skill IQ Leaders";
            }

            @Override
            public int getCount() {
                return 2;
            }
        } );

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        return view;

//        OnSubmitButtonSelected submitListener = (OnSubmitButtonSelected) getActivity();
    }

    @Override
    public void onStop() {
        super.onStop();
//        getActivity().setTitle("Leaderboad");
    }

}
