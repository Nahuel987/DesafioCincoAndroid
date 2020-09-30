package com.example.desafiocincoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.desafiocincoandroid.modelo.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickOnListener {

    private RecyclerView recyclerView;
    private AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        mAdapter=new AnimalAdapter(inciaAnimales(),this,this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }//on create

    private List<Animal> inciaAnimales(){

        Animal animal1= new Animal("https://images.unsplash.com/photo-1504208434309-cb69f4fe52b0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80","ZORRITO BLANCO");
        Animal animal2= new Animal("https://images.unsplash.com/photo-1543946207-39bd91e70ca7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80","CIERVO");
        Animal animal3= new Animal("https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=749&q=80","KOALA DORMILON");
        Animal animal4 =new Animal("https://images.unsplash.com/photo-1516728778615-2d590ea1855e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80","JAGUAR");
        Animal animal5 =new Animal("https://images.unsplash.com/photo-1452857297128-d9c29adba80b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=667&q=80","CONEJITO");

        List<Animal>animalList=new ArrayList<Animal>();

        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);

        return animalList;

    }

    @Override
    public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url) {
        Toast.makeText(this,nameAnimal,Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal,url);
    }

    private void instanceDetailFragment(String name,String url){

        DetailFragment detailFragment=DetailFragment.newInstance(name, url);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout,detailFragment,"FRAGMENTO DE DETALLES")
                .addToBackStack(null)
                .commit();
    }
    
}//class