package cat.itb.pixiv.Adapater;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.R;

public class AdapterGeneral1 extends FirebaseRecyclerAdapter<ImatgesP, AdapterGeneral1.GeneralViewHolder> {

    private int modelID;
    private ImatgesP model;

    private Context context;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public AdapterGeneral1(@NonNull FirebaseRecyclerOptions<ImatgesP> options, int modelID, ImatgesP model) {
        super(options);
        this.modelID = modelID;
        this.model = model;
    }

    @Override
    protected void onBindViewHolder(@NonNull GeneralViewHolder holder, int position, @NonNull ImatgesP model) {
        this.model = model;
        holder.bind();
    }


    @NonNull
    @Override
    public AdapterGeneral1.GeneralViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(modelID == 1){
            return new GeneralViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_ranking,parent,false));
        }if(modelID == 2){
            return new GeneralViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ite,parent,false));
        }
        return null;
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
            if(modelID == 1){
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(120, 120);
                imageViewImage.setLayoutParams(params);
                textViewTitle.setText(model.getTitle());
                textViewUser.setText(model.getUser());
            }

            Picasso.with(getContext()).load(model.getImage()).into(imageViewImage);
            imageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }



}
