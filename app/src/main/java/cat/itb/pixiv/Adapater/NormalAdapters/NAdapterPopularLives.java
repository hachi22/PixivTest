package cat.itb.pixiv.Adapater.NormalAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.R;

public class NAdapterPopularLives extends RecyclerView.Adapter<NAdapterPopularLives.NAViewHolder>{

    private List<ImatgesP> imagesList;

    public NAdapterPopularLives(List<ImatgesP> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterPopularLives.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_popular_lives, parent,false);
        return new NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterPopularLives.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle, textViewViews;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_illustrations_popular_lives);
            textViewTitle = itemView.findViewById(R.id.text_view_illustrations_name_popular_lives);
            textViewViews = itemView.findViewById(R.id.text_view_illustrations_views_popular_lives);
        }

        public  void binData(ImatgesP imatgesP){
            imageView.setImageResource(R.drawable.ic_launcher_background);
            textViewTitle.setText(imatgesP.getUser());
            textViewViews.setText(String.valueOf(imatgesP.getNumViews()));
        }
    }

}
