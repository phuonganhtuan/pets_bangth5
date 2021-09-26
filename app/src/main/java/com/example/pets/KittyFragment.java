package com.example.pets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets.adapter.KittyAdapter;
import com.example.pets.api.APIServiceIml;
import com.example.pets.api.ApiService;
import com.example.pets.listener.FectDataCallBack;
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
    private List<Kitty> kitties;
    private KittyAdapter mKittyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void getListKitty(int page) {// truyền 1 tham số page vào để hàm có thể gọi list ở bất kỳ đoạn nào của list đó
        isLoading = true;//lm
        // dữ liệu thực tế từ api sẽ get tại đây qua mKittyAdapter
        APIServiceIml.getAllKitties(page, new FectDataCallBack() {
            @Override
            public void onFetchSuccess(ArrayList<Kitty> list) {
                isLoading = false;//lm
                kitties.clear();
                kitties.addAll(list);
                if (list.size() < 10) { //lm
                    isLastPage = true;//lm
                }
                mKittyAdapter.setData(kitties);
            }

            @Override
            public void onFetchFault(Exception e) {
                isLoading = false;
            }
        });

    }

    private int page = 1;//lm
    private boolean isLoading = false;//lm
    private boolean isLastPage = false;//lm

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kitty, container, false);

        //onCreat or onCreatView
        rcvKitty = view.findViewById(R.id.rcv_kitty);
        mKittyAdapter = new KittyAdapter(getActivity());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcvKitty.setLayoutManager(gridLayoutManager);
        kitties = new ArrayList<>();
        mKittyAdapter.setData(kitties);
        rcvKitty.setAdapter(mKittyAdapter);

        page = 1;//lm
        isLastPage = false;//lm
        getListKitty(page);//lm

        //
        rcvKitty.setOnScrollListener(new PagingnationScrollListener(gridLayoutManager) {
            @Override
            public void loadMoreItem() {
                page = page + 1;//lm
                getListKitty(page);//lm
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
        });

        // Inflate the layout for this fragment
        return view;

    }


}