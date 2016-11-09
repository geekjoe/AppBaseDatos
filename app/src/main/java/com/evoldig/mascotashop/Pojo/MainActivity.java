package com.evoldig.mascotashop.Pojo;

//import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.evoldig.mascotashop.Adapter.PageAdapter;
import com.evoldig.mascotashop.Fragment.PerfilFragment;
import com.evoldig.mascotashop.Fragment.RecyclerviewFragment;
import com.evoldig.mascotashop.Menu.AcercaDe;
import com.evoldig.mascotashop.Menu.Contacto;
import com.evoldig.mascotashop.Pojo.DetalleMascota;
import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.R;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotasMain;
    private RecyclerView listaMascotasMain;




    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamando el objeto de Action bar
         Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
         miActionBar.setTitle("");
         setSupportActionBar(miActionBar);

        // TAblayout y ViewPager llamando objetos

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Llamar el Viewpager
        setUPViewPager();


        //Floating Button
            agregarFAB();



        //Pasar Datos Like

        ImageView Rateo = (ImageView) findViewById(R.id.rateo);

        Rateo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                envioDatos();

            }
        });







        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }




    }





    //Pasa datos al fragment

    private ArrayList<Fragment> agregarFragments() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void  setUPViewPager () {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher_love);


    }



    //Menu de Opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mContato :
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                return true;

            case R.id.mAcercaDe :
                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    

    //Menu Contexto


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }


    public void agregarFAB () {
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.mifloatingbutton);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Se presiono el boton FAB", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

    }


    public void envioDatos() {

        Intent intent = new Intent(this, DetalleMascota.class);
        //int t = getResources().getTextArray(R.array.reiting).length;

        /* for (int i=0; i<t;i++ ) {
            intent.putExtra(getResources().getTextArray(R.array.reiting)[i].toString(),mascotasMain.get(i));
            // intent.putExtra(getResources().getTextArray(R.array.reiting)[i].toString(),mascotas.get(i));
        } */

        startActivity(intent);
    }

    /*public void sortMascota () {

        Collections.sort(mascotasMain, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota o1, Mascota o2) {
                if (o1.getRaiting() > o2.getRaiting()) return -1;
                else if (o1.getRaiting() == o2.getRaiting()) return 0;
                else return 1;
            }
        });
    } */


}
