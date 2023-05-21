package com.example.weswing.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weswing.objects.Moguda;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterCalendari;

import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment {
    View vista;
    TextView amics, assistire, tot;
    TextView filtresTv;
    RecyclerView mogudes;

    List<TextView> tvs = new ArrayList<>();

    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_calendar, container, false);
        init();
        initRecyclerTots();

        return vista;
    }

    public void init() {
        amics = vista.findViewById(R.id.amicsBTN);
        amics.setOnClickListener(v -> {
            clickTV(amics);
            initRecyclerAmics();
        });

        assistire = vista.findViewById(R.id.asistireBTN);
        assistire.setOnClickListener(v -> {
            clickTV(assistire);
            initRecyclerAssistire();
        });

        tot = vista.findViewById(R.id.totsBTN);
        tot.setOnClickListener(v -> {
            clickTV(tot);
            initRecyclerTots();
        });
        tvs.add(amics);
        tvs.add(assistire);
        tvs.add(tot);

        filtresTv = vista.findViewById(R.id.filtresTV);
        mogudes = vista.findViewById(R.id.recyclerMogudes);
    }

    public void initRecyclerTots() {
        List<Moguda> mogudaList = new ArrayList<>();

        mogudaList.add(new Moguda("12 de abril de 2010", "Swing jam de dimarts!", R.drawable.pfp, "Organitzat per mi", "Barcelona, Spain", "12/04/2017-18/04/2017 | 2horas", "1 assistents | 1 amics"));
        mogudaList.add(new Moguda("24 de abril de 2011", "Bailadores baileando", R.drawable.pfp, "Organitzat per tu", "Murcia, Spain", "24/04/2017-18/04/2017 | 5horas", "267 assistents | 3 amics"));
        mogudaList.add(new Moguda("44 de junio de 2012", "Y si vemos One Piece?", R.drawable.pfp, "Organitzat per la que te cuento", "Mi casa, Spain", "44/06/2017-18/04/2017 | 8horas", "4 assistents | 0 amics"));
        mogudaList.add(new Moguda("28 de agosto de 2013", "Venga va a ver One Piece", R.drawable.pfp, "Organitzat per Oda", "Gibraltar, Spain", "28/08/2017-2/04/2017 | 9horas", "9 assistents | 0 amics"));
        mogudaList.add(new Moguda("29 de agosto de 2014", "Godaaaaa", R.drawable.pfp, "Organitzat per un fan", "Madrid, Spain", "29/08/2017-16/04/2017 | 1horas", "10 assistents | 0 amics"));
        mogudaList.add(new Moguda("25 de diciembre de 2015", "Nakama fest", R.drawable.pfp, "Organitzat per Royal", "Madrid, Spain", "25/12/2017-8/04/2017 | 2horas", "244 assistents | 3 amics"));

        AdapterCalendari adapter = new AdapterCalendari(mogudaList);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void initRecyclerAmics() {
        List<Moguda> mogudesList = new ArrayList<>();

        mogudesList.add(new Moguda("12 de abril de 2010", "Swing jam de dimarts!", R.drawable.pfp, "Organitzat per mi", "Barcelona, Spain", "12/04/2017-18/04/2017 | 2horas", "1 assistents | 1 amics"));
        mogudesList.add(new Moguda("24 de abril de 2011", "Bailadores baileando", R.drawable.pfp, "Organitzat per tu", "Murcia, Spain", "24/04/2017-18/04/2017 | 5horas", "267 assistents | 3 amics"));
        mogudesList.add(new Moguda("25 de diciembre de 2015", "Nakama fest", R.drawable.pfp, "Organitzat per Royal", "Madrid, Spain", "25/12/2017-8/04/2017 | 2horas", "244 assistents | 3 amics"));


        AdapterCalendari adapter = new AdapterCalendari(mogudesList);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void initRecyclerAssistire() {
        List<Moguda> mogudaList = new ArrayList<>();

        mogudaList.add(new Moguda("44 de junio de 2012", "Y si vemos One Piece?", R.drawable.pfp, "Organitzat per la que te cuento", "Mi casa, Spain", "44/06/2017-18/04/2017 | 8horas", "4 assistents | 0 amics"));

        AdapterCalendari adapter = new AdapterCalendari(mogudaList);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void clickTV(TextView clicked) {
        clicked.setTextColor(getResources().getColor(R.color.white));
        clicked.setBackgroundColor(getResources().getColor(R.color.tematicRed));

        for (TextView tv :
                tvs) {
            if (tv.equals(clicked)) {
                tv.setTextColor(getResources().getColor(R.color.white));
                tv.setBackgroundColor(getResources().getColor(R.color.tematicRed));
            } else {
                tv.setTextColor(getResources().getColor(R.color.textgrey));
                tv.setBackgroundColor(getResources().getColor(R.color.grey));
            }
        }
    }
}