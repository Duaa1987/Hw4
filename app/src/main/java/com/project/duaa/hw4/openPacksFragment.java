package com.project.duaa.hw4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class openPacksFragment extends Fragment {


    public openPacksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView cardRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_open_packs, container, false);
        final View v1 = inflater.inflate(R.layout.fragment_open_packs, container, false);

        final DataBaseHelper myDb;
        myDb = new DataBaseHelper(getActivity());
        final TextView textView=(TextView)v1.findViewById(R.id.textView);


        String[] cardNames = new String[Card.cards.length];

        for (int i = 0; i < cardNames.length; i++) {
            cardNames[i] = Card.cards[i].getName();
        }

        int[] cardImages = new int[Card.cards.length];

        for (int i = 0; i < cardImages.length; i++) {
            cardImages[i] = Card.cards[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(cardNames, cardImages);
        cardRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        cardRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_LONG).show();


                           }
        });

        return cardRecycler;
    }
}