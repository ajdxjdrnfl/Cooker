package korea.co.cooker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchTextAdapter extends RecyclerView.Adapter<SearchTextAdapter.ViewHolder>{
    Context context;
    ArrayList<SearchText> items = new ArrayList<SearchText>();
    SearchTextListener listener = null;

    public SearchTextAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.search_text, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       SearchText item = items.get(i);
       viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void addItem(SearchText item){
        items.add(item);
    }

    public void addItems(ArrayList<SearchText> items){
        this.items = items;
    }

    public SearchText getItem(int position){
        return items.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION){
                        if(listener!=null){
                            listener.onItemClick(v, position);
                        }

                    }
                }
            });

        }

        public void setItem(SearchText item){
            text.setText(item.getText());
        }
    }
    public void setOnItemClickListener(SearchTextListener listener){
        this.listener = listener;
    }

}
