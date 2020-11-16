package cat.itb.vistalista.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import cat.itb.vistalista.R;
import cat.itb.vistalista.adapters.MyAdapter;
import cat.itb.vistalista.models.ItemList;
import cat.itb.vistalista.models.ItemModel;

public class InputActivity extends AppCompatActivity {

    private EditText et_nom;
    private ImageView imageView;
    private Spinner spinner;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        et_nom = findViewById(R.id.et_nom);
        add = findViewById(R.id.button);
        imageView = findViewById(R.id.image);
        spinner = (Spinner) findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tiers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position++;
                switch (position) {
                    case 1:
                        imageView.setImageResource(R.drawable.t1img);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.t2img);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.t3img);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.t4img);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = et_nom.getText().toString();
                if (nom.matches("")) {
                    Toast.makeText(InputActivity.this, "Has d'introduir un nom.", Toast.LENGTH_SHORT).show();
                } else {
                    int tier = (spinner.getSelectedItemPosition() + 1);   //La posició del spinner comença amb 0 aixi que incrementem 1

                    afegir(nom, tier);
                    Intent intent = new Intent(InputActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    protected void afegir(String nom, int tier) {
        ItemList list = new ItemList();
        list.afegirItem(nom, tier);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}