package com.example.yunoi.layouttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.gordonwong.materialsheetfab.MaterialSheetFab;
import com.gordonwong.materialsheetfab.MaterialSheetFabEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    private View view;
//    private FloatingActionButton floatingActionButton;
    private ListView listView;
    private ArrayList<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment,container,false);

//        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        listView = view.findViewById(R.id.listView);
        Fab fab = view.findViewById(R.id.fab);
        View sheetView = view.findViewById(R.id.fab_sheet);
        View overlay = view.findViewById(R.id.overlay);
        int sheetColor = getResources().getColor(R.color.colorAccent);
        int fabColor = getResources().getColor(R.color.colorAccent);

        list = makeList();
        MainAdapter adapter = new MainAdapter(getActivity().getApplicationContext(), R.layout.main_list_view_holder, list);
        listView.setAdapter(adapter);
        // Initialize material sheet FAB
        MaterialSheetFab materialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay, sheetColor, fabColor);
        materialSheetFab.setEventListener(new MaterialSheetFabEventListener() {
            @Override
            public void onShowSheet() {
                super.onShowSheet();
            }

            @Override
            public void onSheetShown() {
                super.onSheetShown();

            }

            @Override
            public void onHideSheet() {
                super.onHideSheet();
            }

            @Override
            public void onSheetHidden() {
                super.onSheetHidden();
            }
        });

        return view;
    }

    private ArrayList<String> makeList() {
        list.add("하루청소");
        list.add("주말청소");
        list.add("월말청소");
        list.add("대청소");

        return list;
    }

    class MainAdapter extends BaseAdapter {
        private Context context;
        private int layout;
        private ArrayList<String> list;
        private LayoutInflater layoutInflater;

        public MainAdapter(Context context, int layout, ArrayList<String> list) {
            this.context = context;
            this.layout = layout;
            this.list = list;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(layout, null);
            }
            ImageView ivCheckList = convertView.findViewById(R.id.ivCheckList);
            TextView tvCleaning = convertView.findViewById(R.id.tvCleaning);
            Switch swMainList = convertView.findViewById(R.id.swMainList);

            return convertView;
        }
    }
}
