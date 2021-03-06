package id.ac.umn.jophoto.GettingStarted;

import static id.ac.umn.jophoto.SplashFragment.GETTING_STARTED_SHARED;
import static id.ac.umn.jophoto.SplashFragment.GETTING_STARTED_STATUS;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.umn.jophoto.HomeActivity;
import id.ac.umn.jophoto.databinding.FragmentStarted2Binding;

public class Started2Fragment extends Fragment {

    FragmentStarted2Binding bind;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentStarted2Binding.inflate(inflater, container, false);

        bind.btnStartedFinish.setOnClickListener(view -> {
            onGettingStartedCompleted();
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            requireActivity().startActivity(intent);
//            Navigation.findNavController(bind.getRoot()).navigate(R.id.action_startedViewPagerFragment_to_homeActivity);
        });

        // Inflate the layout for this fragment
        return bind.getRoot();
    }

    private void onGettingStartedCompleted(){
        SharedPreferences sharedPref = requireActivity().getSharedPreferences(GETTING_STARTED_SHARED, Context.MODE_PRIVATE);
//        sharedPref.edit();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(GETTING_STARTED_STATUS, true);
        editor.apply();
    }
}