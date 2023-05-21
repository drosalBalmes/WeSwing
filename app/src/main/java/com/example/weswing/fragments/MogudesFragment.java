package com.example.weswing.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterNovetats;
import com.example.weswing.listener.SelectListenerNovetats;
import com.example.weswing.objects.Novetats;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.internal.MainDispatcherFactory;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MogudesFragment extends Fragment implements View.OnClickListener, SelectListenerNovetats {
    View view;
    TextView titol,tipus,data,descripcio;
    Button asistencia;
    List<Novetats> novetats;
    RecyclerView novetatsRecycler;
    AdapterNovetats novetatsAdapter;
    Novetats selectedNovetat;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void initComponents(){
        novetatsRecycler = view.findViewById(R.id.recyclerView);
        titol = view.findViewById(R.id.nomMoguda);
        tipus = view.findViewById(R.id.tipusMoguda);
        descripcio = view.findViewById(R.id.descriptionText);
        data = view.findViewById(R.id.dataMoguda);
        asistencia = view.findViewById(R.id.asistentsButton);
        initRecyclerEscola();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mogudes, container, false);
        ((MainActivity) getActivity()).changeTitle("Moguda");
        // Inflate the layout for this fragment
        initComponents();
        asistencia.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        ((MainActivity) getActivity()).replaceFragment(new AssistentsFragment());
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    public void initRecyclerEscola(){
        novetats = new ArrayList<>();
        novetats.add(new Novetats(R.drawable.we_swing_icon,"La que te cuento","Barcelona,Espanya"));

        novetatsAdapter = new AdapterNovetats(novetats,this);
        novetatsRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        novetatsRecycler.setHasFixedSize(true);
        novetatsRecycler.setAdapter(novetatsAdapter);
    }
    @Override
    public void onItemClicked(Novetats novetat) {
        novetat.getPfp();
        ((MainActivity)getActivity()).replaceFragment(new EscolaFragment());

    }
}