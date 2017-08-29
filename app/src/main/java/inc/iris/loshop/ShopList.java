package inc.iris.loshop;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ShopList extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView recyclerView;
    ShopListAdapter adapter;
    Toolbar toolbar;
    List<ShopListRes> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        recyclerView = (RecyclerView) findViewById(R.id.shoplist_view);
        toolbar = (Toolbar) findViewById(R.id.shoplist_tool);
        adapter = new ShopListAdapter(getApplicationContext(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setSupportActionBar(toolbar);


    }

    public List<ShopListRes> getData() {

        //data to be replaced with server received data
        data = new ArrayList<>();
        int icon[] = {R.drawable.ic_shop, R.drawable.ic_shop, R.drawable.ic_shop, R.drawable.ic_shop, R.drawable.ic_shop};
        String name[] = {"Crazy Chilli", "Food Plaza", "Medicine", "INOX", "Wartika"};
        String category[] = {"Restaurant", "Restaurant", "Medicine", "Movie", "Stationary"};
        String time[] = {"8am - 8pm", "8am - 8pm", "8am - 8pm", "8am - 8pm", "8am - 8pm"};
        String offday[] = {"Sunday", "Sunday", "Sunday", "Sunday", "Sunday"};
        ShopListRes current;
        for (int i = 0; i < icon.length && i < name.length && i < category.length && i < time.length && i < offday.length; i++) {
            current = new ShopListRes(icon[i], name[i], category[i], time[i], offday[i]);
            data.add(current);
        }
        return data;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.shoplist_menu, menu);
        MenuItem search=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(search);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<ShopListRes> newList = new ArrayList<>();
        for(ShopListRes current:data)
        {
            String name=current.getShop_name().toLowerCase();
            if(name.contains(newText))
                newList.add(current);
        }
        adapter.setFilter(newList);
        return true;
    }
}
