package cat.itb.pixiv.Adapater.AdaptersFirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.R;

public class AdapterRankingIM extends FirebaseRecyclerAdapter<ImatgesP, AdapterRankingIM.GeneralViewHolder> {

    private ImatgesP model;
    private Context context;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public AdapterRankingIM(@NonNull FirebaseRecyclerOptions<ImatgesP> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull GeneralViewHolder holder, int position, @NonNull ImatgesP model) {
        this.model = model;
        holder.bind();
    }


    @NonNull
    @Override
    public AdapterRankingIM.GeneralViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GeneralViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_ranking,parent,false));

    }

    class GeneralViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        TextView textViewUser;
        ImageView imageViewImage;
        ImageView imageLike;

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_illustrations_ranking_name);
            textViewUser = itemView.findViewById(R.id.text_view_illustrations_ranking_user);
            imageViewImage = itemView.findViewById(R.id.image_view_illustrations_ranking);
            imageLike = itemView.findViewById(R.id.heart_illustrations_ranking);
        }

        public void bind(){
            textViewTitle.setText(model.getTitle());
            textViewUser.setText(model.getUser());

            final boolean[] heart = {false};
            Picasso.with(getContext()).load(model.getImage()).into(imageViewImage);
            imageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(heart[0]){
                        imageLike.setImageResource(R.drawable.likeheartwhite);
                    }else imageLike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });
        }

    }



}
