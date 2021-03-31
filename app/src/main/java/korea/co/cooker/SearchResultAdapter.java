package korea.co.cooker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    ArrayList<SearchResult> items = new ArrayList<SearchResult>();
    Context context;

    public SearchResultAdapter(Context context) {
        this.context = context;
    }
    public void addItem(SearchResult item){
        items.add(item);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.form_searchresult, viewGroup, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SearchResult item = items.get(i);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView author;
        TextView date;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            author = itemView.findViewById(R.id.textViewAuthor);
            date = itemView.findViewById(R.id.textViewDate);
            image = itemView.findViewById(R.id.imageViewRecipe);

        }
        public void setItem(SearchResult item){
            name.setText(item.getName());
            author.setText(item.getAuthor());
            date.setText(item.getDate());
            // add image source later...
        }
    }
}
