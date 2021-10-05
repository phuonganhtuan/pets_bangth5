package com.example.pets;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pets.adapter.KittyAdapter;
import com.example.pets.api.APIServiceIml;
import com.example.pets.listener.FectDataCallBack;
import com.example.pets.listener.ItemClickListener;
import com.example.pets.listener.ItemDAO;
import com.example.pets.listener.PagingnationScrollListener;
import com.example.pets.model.Kitty;
import com.example.pets.utils.DarkModeInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KittyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KittyFragment extends Fragment implements DarkModeInterface {

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

        AppDatabase database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries() // chạy luôn trên luồng chính do đang còn đơn giản, chuưa cần AsynTask
                .build();
        ItemDAO itemDAO = database.getItemDAO();
        Item item = new Item("","","","");
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setLike("Like");

        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
        System.out.println(items);

        //onCreat or onCreatView
        rcvKitty = view.findViewById(R.id.rcv_kitty);
        mKittyAdapter = new KittyAdapter(getActivity(), new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                loadFragment(new KittyDetail3Fragment());

//                KittyDetail3Fragment nextFrag= new KittyDetail3Fragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container_detail, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
//                Intent intent = new Intent(getActivity(), KittyDetailFragment.class);
//
////                intent.putExtra("id", id);                 // Truyền một id
//
//                getContext().startActivity(intent);

            }
        });

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

    private void loadFragment(KittyDetail3Fragment kittyDetail3Fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container_detail, kittyDetail3Fragment);
        fragmentTransaction.commit(); // lưu lại các thay đổi fragment
    }


    @Override
    public void enableDarkMode() {

    }

    @Override
    public void disableDarkMode() {

    }
//
//    @Override
//    public void onClick(View view, int position, boolean isLongClick) {
//        KittyDetailFragment nextFrag= new KittyDetailFragment();
//        ((FragmentActivity)view.getContext()).getSupportFragmentManager().beginTransaction()
//                .replace(R.id.layout_container, nextFrag, "findThisFragment")
//                .addToBackStack(null)
//                .commit();
//    }
}