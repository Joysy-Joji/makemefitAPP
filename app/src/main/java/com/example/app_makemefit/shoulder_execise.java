package com.example.app_makemefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class shoulder_execise extends AppCompatActivity {
    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;

    private  FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_execise);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.firestore_list);

        Query query = firebaseFirestore.collection("shoulders");
        FirestoreRecyclerOptions<shoulderModel> options = new FirestoreRecyclerOptions.Builder<shoulderModel>()
                .setQuery(query,shoulderModel.class)
                .build();

 adapter = new FirestoreRecyclerAdapter<shoulderModel, shoulderViewHolder>(options) {
            @NonNull
            @Override
            public shoulderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new shoulderViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull shoulderViewHolder holder, int position, @NonNull shoulderModel model) {
                holder.list_name.setText(model.getName());
                holder.list_description.setText(model.getDescription());
            }
        };
        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);

    }

    private class shoulderViewHolder extends RecyclerView.ViewHolder{
        private TextView list_name;
        private TextView list_description;
        public shoulderViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_description = itemView.findViewById(R.id.list_description);
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}