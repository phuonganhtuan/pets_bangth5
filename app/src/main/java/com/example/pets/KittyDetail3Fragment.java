package com.example.pets;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets.listener.ItemDAO;
import com.example.pets.model.ItemKittyLiked;
import com.example.pets.model.Kitty;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KittyDetail3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KittyDetail3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KittyDetail3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment KittyDetail3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KittyDetail3Fragment newInstance(Kitty kitty) {
        KittyDetail3Fragment fragment = new KittyDetail3Fragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, String.valueOf(kitty));
        args.putSerializable("Kitty" , kitty);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_kitty_detail3, container, false);

        AppDatabase database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries() // chạy luôn trên luồng chính do đang còn đơn giản, chưa cần AsynTask
                .build();
        //
        ItemDAO itemDAO = database.getItemDAO();
        ItemKittyLiked item = new ItemKittyLiked("");
        item.setId("Item001");

        itemDAO.insert(item);
        List<ItemKittyLiked> items = itemDAO.getItems();
        System.out.println(items);

        // Inflate the layout for this fragment
        return view;
    }
}