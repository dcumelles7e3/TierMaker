package cat.itb.vistalista.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.vistalista.R;
import cat.itb.vistalista.adapters.*;
import cat.itb.vistalista.models.ItemModel;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;
    private List<String> names;
    private MyAdapter adapter;
    private MyAdapter adapterGrid;
    private ItemModel im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        names = new ArrayList<String>(){{
            add("Hola");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
            add("Ekisde");
        }};



        adapter = new MyAdapter(this,R.layout.list_item, names);
        adapterGrid = new MyAdapter(this,R.layout.list_item, names);

        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Intent input = new Intent(MainActivity.this, InputActivity.class);
                startActivity(input);

                adapter.notifyDataSetChanged();

                return true;
            case R.id.grid_view:
                gridView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                //listView.setAdapter(adapterGrid);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}