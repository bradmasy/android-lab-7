package brad.masciotra.lab7;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    Context c;
    String[] items;
    int[] images;
    private ItemClickListener clickListener;

    public MyRecyclerViewAdapter(Context c, String[] items, int[] images){
        this.c = c;
        this.items = items;
        this.images = images;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.text.setText(items[position]);
       // holder.text2.setText(introductions[position]);
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView text;
        ImageView image;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.item_name);
            Log.d("text", "MyViewHolder: " + text);
            image = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
       //     if(clickListener != null) clickListener.onClick(itemView,getBindingAdapterPosition());
        }
    }
}
