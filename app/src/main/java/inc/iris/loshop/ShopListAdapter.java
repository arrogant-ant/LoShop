package inc.iris.loshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sabita_Sant on 8/29/2017.
 */
public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<ShopListRes> data = Collections.emptyList();

    public ShopListAdapter(Context context, List<ShopListRes> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShopListRes current = data.get(position);
        holder.offday_tv.setText(current.getShop_offday());
        holder.time_tv.setText(current.getShop_time());
        holder.cat_tv.setText(current.getShop_cat());
        holder.title_tv.setText(current.getShop_name());
        holder.icon.setImageResource(current.getShop_icon());


    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title_tv, cat_tv, time_tv, offday_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.shop_icon);
            title_tv = (TextView) itemView.findViewById(R.id.shop_name);
            cat_tv = (TextView) itemView.findViewById(R.id.shop_category);
            time_tv = (TextView) itemView.findViewById(R.id.shop_timing);
            offday_tv = (TextView) itemView.findViewById(R.id.shop_offday);
        }
    }
    public void setFilter(ArrayList<ShopListRes> newList)
    {
        data=new ArrayList<>();
        data.addAll(newList);
        notifyDataSetChanged();
    }
}
