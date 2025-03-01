package cat.itb.vistalista.adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cat.itb.vistalista.R;
import cat.itb.vistalista.models.ItemList;
import cat.itb.vistalista.models.ItemModel;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemModel> items;

    public MyAdapter(Context context, int layout, ItemList items) {
        this.context = context;
        this.layout = layout;
        this.items = items.getItems();
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);

            holder = new ViewHolder();
            

            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            holder.tierImageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemModel item = (ItemModel) getItem(position);
        String nom = item.getNom();
        holder.nameTextView.setText(nom);
        int imatge = item.getImatge();
        holder.tierImageView.setImageResource(imatge);
        int tier = item.getTier();
        switch (tier) {
            case 1:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.t1));
                break;
            case 2:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.t2));
                break;
            case 3:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.t3));
                break;
            case 4:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.t4));
                break;
        }
        return convertView;
    }

    static class ViewHolder {
        private TextView nameTextView;
        private ImageView tierImageView;
    }

}

