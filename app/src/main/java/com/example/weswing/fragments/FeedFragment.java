package com.example.weswing.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterNovetats;
import com.example.weswing.listener.SelectListenerNovetats;
import com.example.weswing.objects.Novetats;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment implements SelectListenerNovetats {
    List<Novetats> novetats;
    RecyclerView novetatsRecycler;
    AdapterNovetats novetatsAdapter;
    Novetats selectedNovetat;

    public FeedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedFragment newInstance(String param1, String param2) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed,container,false);
        ((MainActivity) getActivity()).changeTitle("Novetats");
        novetatsRecycler = view.findViewById(R.id.recyclerNovetats);
        initRecyclerReview();
        return view;
    }

    public void initRecyclerReview(){
        novetats = new ArrayList<>();
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));
        novetats.add(new Novetats(R.drawable.we_swing_icon,"descripcion lolol","Fa 33h"));

        novetatsAdapter = new AdapterNovetats(novetats,this);
        novetatsRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        novetatsRecycler.setHasFixedSize(true);
        novetatsRecycler.setAdapter(novetatsAdapter);
    }

    @Override
    public void onItemClicked(Novetats novetats) {
        selectedNovetat = novetats;
        ((MainActivity)getActivity()).replaceFragment(new MogudesFragment());
    }
}