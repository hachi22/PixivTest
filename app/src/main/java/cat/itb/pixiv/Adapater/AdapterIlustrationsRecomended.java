package cat.itb.pixiv.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.R;

public class AdapterIlustrationsRecomended extends FirebaseRecyclerAdapter<ImatgesP, AdapterIlustrationsRecomended.ViewHolderIllustrationsRecommended> {

    private ImatgesP model;
    private Context context;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public AdapterIlustrationsRecomended(@NonNull FirebaseRecyclerOptions<ImatgesP> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterIlustrationsRecomended.ViewHolderIllustrationsRecommended holder, int position, @NonNull ImatgesP model) {
        this.model = model;
        holder.bind();
    }

    @NonNull
    @Override
    public AdapterIlustrationsRecomended.ViewHolderIllustrationsRecommended onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterIlustrationsRecomended.ViewHolderIllustrationsRecommended(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_recommended,parent,false));
    }

    class ViewHolderIllustrationsRecommended extends RecyclerView.ViewHolder {

        ImageView imageViewimage, imageViewLike;

        public ViewHolderIllustrationsRecommended(@NonNull View itemView) {
            super(itemView);

            imageViewimage = itemView.findViewById(R.id.image_view_illustrations_recommended);
            imageViewLike = itemView.findViewById(R.id.image_view_illustrations_recommended_like);

        }

        public void bind(){
            Picasso.with(getContext()).load(model.getImage()).into(imageViewimage);

            final boolean[] heart = {false};
            imageViewLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(heart[0]){
                        imageViewLike.setImageResource(R.drawable.likeheartwhite);
                    }else imageViewLike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });

        }
    }

}
