package com.example.baitapcanhan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Fragment extends Fragment {
    private TaskAdapter adapter;
    private List<Task> items;
    private List<Task> filteredItems; // Dữ liệu đã lọc

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvFeatured);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // Dữ liệu giả lập
        items = new ArrayList<>();
        items.add(new Task("Item 1", "Sách 1", R.drawable.img1, "50%"));
        items.add(new Task("Item 2", "Sách 2", R.drawable.img2, "50%"));
        items.add(new Task("Item 3", "Sách 3", R.drawable.img3, "50%"));

        filteredItems = new ArrayList<>(items); // Sao chép dữ liệu gốc vào filteredItems
        adapter = new TaskAdapter(filteredItems); // Sử dụng filteredItems trong adapter
        recyclerView.setAdapter(adapter);

        // Xử lý tìm kiếm
        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // Không làm gì khi nhấn Enter
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText); // Lọc danh sách khi người dùng nhập
                return false;
            }
        });

        return view;
    }

    private void filterItems(String query) {
        filteredItems.clear(); // Xóa dữ liệu cũ trong filteredItems

        if (query.isEmpty()) {
            filteredItems.addAll(items); // Hiển thị tất cả item nếu không có từ khóa
        } else {
            for (Task item : items) {
                if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        item.getSellerInfo().toLowerCase().contains(query.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
        }

        adapter.notifyDataSetChanged(); // Cập nhật adapter
    }
}
