package com.example.pets.listener;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class PagingnationScrollListener extends RecyclerView.OnScrollListener {
    private GridLayoutManager gridLayoutManager;

    public PagingnationScrollListener(GridLayoutManager gridLayoutManager) {
        this.gridLayoutManager = gridLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isLastPage() || isLoading()) return;
        int totalItemCount = gridLayoutManager.getItemCount();
        if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == totalItemCount - 1) ;
        {
            loadMoreItem();
        }
    }

    public abstract void loadMoreItem();

    public abstract boolean isLoading();

    public abstract boolean isLastPage();
}
