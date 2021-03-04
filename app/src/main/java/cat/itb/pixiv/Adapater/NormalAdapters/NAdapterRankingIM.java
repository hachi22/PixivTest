package cat.itb.pixiv.Adapater.NormalAdapters;

import android.service.notification.NotificationListenerService;
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

public class NAdapterRankingIM extends RecyclerView.Adapter<NAdapterRankingIM.RankingIMViewHolder> {
    private List<ImatgesP> imagesList;

    public NAdapterRankingIM(List<ImatgesP> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterRankingIM.RankingIMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_ranking, parent,false);
        return new RankingIMViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterRankingIM.RankingIMViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class RankingIMViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewUser;
        ImageView imageViewImage;
        ImageView imageLike;
        public RankingIMViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_illustrations_ranking_name);
            textViewUser = itemView.findViewById(R.id.text_view_illustrations_ranking_user);
            imageViewImage = itemView.findViewById(R.id.image_view_illustrations_ranking);
            imageLike = itemView.findViewById(R.id.heart_illustrations_ranking);
        }

        public void binData(ImatgesP imatgesP){
            final boolean[] heart = {false};
            imageLike.setImageResource(R.drawable.likeheartwhite);
            imageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(heart[0]){
                        imageLike.setImageResource(R.drawable.likeheartwhite);
                    }else imageLike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });

            textViewTitle.setText(imatgesP.getTitle());
            textViewUser.setText(imatgesP.getUser());
            imageViewImage.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}
