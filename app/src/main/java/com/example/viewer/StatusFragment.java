package com.example.viewer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StatusFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<ItemModel> arrayList;

    String name[] = {"chand", "Nazeer", "Nikhil", "Sukanya", "Sagar", "Riyaz", "Sudarshan", "Taj", "Shafi", "Shukur"};
    int image[] = {R.drawable.chand,R.drawable.nazeer,R.drawable.nikhil,R.drawable.sukanya,R.drawable.sagar,R.drawable.riyaz,R.drawable.sudarshan,R.drawable.taj,R.drawable.shafi,R.drawable.shukur};
    CustomAdapter adapter;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_status, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setName(name[i]);
            itemModel.setImage(image[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        adapter = new CustomAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public class ItemModel {

        int image;
        String name;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder>{

        ArrayList<ItemModel> arrayList;

        public CustomAdapter(ArrayList<ItemModel> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public  viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.list, viewGroup, false);
            return new viewHolder(view);
        }
        @Override
        public  void onBindViewHolder(viewHolder viewHolder, int position) {
            viewHolder.name.setText(arrayList.get(position).getName());
            viewHolder.image.setImageResource(arrayList.get(position).getImage());

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class viewHolder extends RecyclerView.ViewHolder {
            TextView name;
            ImageView image;

            public viewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.name);
                image = (ImageView) itemView.findViewById(R.id.image);

            }
        }
    }
}
