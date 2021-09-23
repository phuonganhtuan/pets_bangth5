package com.example.pets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets.model.Kitty;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KittyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KittyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KittyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KittyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KittyFragment newInstance(String param1, String param2) {
        KittyFragment fragment = new KittyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView rcvKitty;
    private KittyAdapter mKittyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //onCreat or onCreatView
//        rcvKitty = getActivity().findViewById(R.id.rcv_kitty);
//        mKittyAdapter = new KittyAdapter(getActivity());
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//        rcvKitty.setLayoutManager(gridLayoutManager);
//
//        mKittyAdapter.setData(getListKitty());
//        rcvKitty.setAdapter(mKittyAdapter);
    }

    private List<Kitty> getListKitty() {
        List<Kitty> list = new ArrayList<>();
        // dữ liệu thực tế từ api sẽ get tại đây qua mKittyAdapter
        list.add(new Kitty(R.drawable.anh1, "1", "meo meo 1","","","","","", ""));
        list.add(new Kitty(R.drawable.anh2, "1", "meo meo 2","","","","","", ""));
        list.add(new Kitty(R.drawable.anh3, "1", "meo meo 3","","","","","", ""));
        list.add(new Kitty(R.drawable.anh4, "1", "meo meo 4","","","","","", ""));

        list.add(new Kitty(R.drawable.anh1, "1", "meo meo 1","","","","","", ""));
        list.add(new Kitty(R.drawable.anh2, "1", "meo meo 2","","","","","", ""));
        list.add(new Kitty(R.drawable.anh3, "1", "meo meo 3","","","","","", ""));
        list.add(new Kitty(R.drawable.anh4, "1", "meo meo 4","","","","","", ""));

        list.add(new Kitty(R.drawable.anh1, "1", "meo meo 1","","","","","", ""));
        list.add(new Kitty(R.drawable.anh2, "1", "meo meo 2","","","","","", ""));
        list.add(new Kitty(R.drawable.anh3, "1", "meo meo 3","","","","","", ""));
        list.add(new Kitty(R.drawable.anh4, "1", "meo meo 4","","","","","", ""));

        return list;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kitty, container, false);

        //onCreat or onCreatView
        rcvKitty = view.findViewById(R.id.rcv_kitty);
        mKittyAdapter = new KittyAdapter(getActivity());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcvKitty.setLayoutManager(gridLayoutManager);

        mKittyAdapter.setData(getListKitty());
        rcvKitty.setAdapter(mKittyAdapter);


        // Inflate the layout for this fragment
        return view;

    }


}