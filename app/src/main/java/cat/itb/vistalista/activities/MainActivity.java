package cat.itb.vistalista.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.vistalista.R;
import cat.itb.vistalista.adapters.*;
import cat.itb.vistalista.models.ItemList;
import cat.itb.vistalista.models.ItemModel;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;
    private MyAdapter adapter;
    private MyAdapter adapterGrid;
    private ItemList itemList;
    MenuItem listB;
    MenuItem gridB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.t1img);

        listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        itemList = new ItemList();
        adapter = new MyAdapter(this, R.layout.list_item, itemList);
        adapterGrid = new MyAdapter(this, R.layout.list_item_grid, itemList);

        listView.setAdapter(adapter);
        gridView.setAdapter(adapterGrid);

        registerForContextMenu(listView);
        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.itemList.getNomActual(info.position));

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_item:
                this.itemList.borrar(info.position);
                adapter.notifyDataSetChanged();
                adapterGrid.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        listB = menu.findItem(R.id.b_list_view);
        gridB = menu.findItem(R.id.b_grid_view);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Intent input = new Intent(MainActivity.this, InputActivity.class);
                startActivity(input);
                finish();
                return true;
            case R.id.b_grid_view:
                gridView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                listB.setVisible(true);
                gridB.setVisible(false);
                return true;
            case R.id.b_list_view:
                gridView.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
                listB.setVisible(false);
                gridB.setVisible(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}