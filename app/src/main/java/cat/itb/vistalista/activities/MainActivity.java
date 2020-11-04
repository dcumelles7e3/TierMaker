package cat.itb.vistalista.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.vistalista.R;
import cat.itb.vistalista.adapters.*;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

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
                names.add("New name");

                adapter.notifyDataSetChanged();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}