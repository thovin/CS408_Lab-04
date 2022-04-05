package edu.jsu.mcis.cs408.lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import edu.jsu.mcis.cs408.lab04.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();

        binding.addMemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMemo();
            }
        });

        binding.deleteMemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                deleteMemo();
            }
        });

    }

    public void addMemo() {
        String message = binding.newMemoInput.getText().toString();
        db.addMemo(message);
        updateRecyclerView();
    }

    public void deleteMemo() {
//        int ID = Integer.parseInt(binding.deleteMemoInput.getText().toString());
        String ID = binding.deleteMemoInput.getText().toString();
        db.deleteMemo(ID);
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        RecyclerViewAdapter adaptor = new RecyclerViewAdapter(db.getMemosAsList());
        binding.outputRecyclerView.setHasFixedSize(true);
        binding.outputRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.outputRecyclerView.setAdapter(adaptor);
    }
}