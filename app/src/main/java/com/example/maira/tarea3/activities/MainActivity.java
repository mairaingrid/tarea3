package com.example.maira.tarea3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.maira.tarea3.R;
import com.example.maira.tarea3.adapters.FruitAdapter;
import com.example.maira.tarea3.models.Fruit;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;
import static com.example.maira.tarea3.R.*;

public class MainActivity extends AppCompatActivity  {
    private List<Fruit> fruits;

    private FruitAdapter adapter;
    private ListView listView;
    private int counter = 0;
    private LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        this.fruits = getAllFruits();


        this.listView = findViewById(R.id.listView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new FruitAdapter(fruits, layout.item, this, new FruitAdapter.OnItemClickListener(){


            @Override
            public void onItemClick(Fruit fruit, int position) {

                fruit.addQuantity(1);
                adapter.notifyItemChanged(position);
            }


        });


        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case id.add_fruit:
                this.addFruit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addFruit(int position) {
        this.fruits.add(position, new Fruit("New fruit" + (++counter), "Fruit add by the user",drawable.fruts, drawable.coco, drawable.fresa,drawable.pina,drawable.uvas, 1));
        this.adapter.notifyItemInserted(position);
        this.layoutManager.scrollToPosition(position);
    }

    public List<Fruit> getAllFruits() {
        return new ArrayList<Fruit>(){{
            add(new Fruit("Manzana", "manzana... ", drawable.fruts, drawable.coco, drawable.fresa, drawable.fruts, drawable.fruts, 1));
            add(new Fruit("COCO", "Coco...", drawable.fruts, drawable.coco, drawable.fresa, drawable.coco, drawable.coco, 1));
            add(new Fruit("FRESA", "Fresa...", drawable.fruts, drawable.coco, drawable.fresa, drawable.fresa, drawable.fresa, 1));
            add(new Fruit("PIÑA", "Piña...", drawable.fruts, drawable.coco, drawable.fresa, drawable.pina, drawable.pina, 1));
            add(new Fruit("UVA", "Uva ...", drawable.fruts, drawable.coco, drawable.fresa, drawable.uvas, drawable.uvas, 1));
             }};
    }
}

       /* this.fruits = getAllFruits();
         loadComponents();
    }

    private void loadComponents() {

        ListView list = findViewById(R.id.listview);

        Integer[] images = new Integer[]{R.drawable.fruts,R.drawable.coco,R.drawable.fresa,R.drawable.pina,R.drawable.uvas};
        String[]  title = new String[]{"FRUTS","COCO","FRESA","PI:A","UVAS"};
        String[]  description = new String[]{"FRUTS...","COCO...","FRESA...","PI:A...","UVAS..."};
        //String[]  quanty = new String[]{"FRUTS...","COCO...","FRESA...","PI:A...","UVAS..."};


        ArrayList<fruit> listdata = new ArrayList<>();
        for (int i = 0; i<images.length; i++){
            fruit model = new fruit();
            model.setImg(images[i]);
            model.setTitle(title[i]);
            model.setDescription(description[i]);
           // model.setQuantity(quanty[i]);
            listdata.add(model);
        }


      /*  ListView list = findViewById(R.id.listview);
        ArrayList<String > datoslist = new ArrayList<>();
        for (int i = 0;i < 20;i++){
            datoslist.add(" item " + i);
        }
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datoslist);*/

   /*   Adapters adapter = new Adapters(this,listdata);

        list.setAdapter(adapter);


    }


}*/
