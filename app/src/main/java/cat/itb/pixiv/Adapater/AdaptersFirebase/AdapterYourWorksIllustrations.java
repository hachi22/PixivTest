package cat.itb.pixiv.Adapater.AdaptersFirebase;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.IllustrationClass;

public class AdapterYourWorksIllustrations extends FirebaseRecyclerAdapter<IllustrationClass, AdapterYourWorksIllustrations.ViewHolderYourWorks> {

    private IllustrationClass model;
    private Context context;

    public AdapterYourWorksIllustrations(@NonNull FirebaseRecyclerOptions<IllustrationClass> options) {
        super(options);
    }

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderYourWorks holder, int position, @NonNull IllustrationClass model) {
        this.model = model;
        holder.bind();
    }

    @NonNull
    @Override
    public ViewHolderYourWorks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    class ViewHolderYourWorks extends RecyclerView.ViewHolder {

        ImageView imageViewimage;
        TextView textViewTitle, textViewlike, textViewComm, textViewviews;

        public ViewHolderYourWorks(@NonNull View itemView) {
            super(itemView);


        }

        public void bind(){
            Picasso.with(getContext()).load(model.getIllustrationImgUrl()).into(imageViewimage);
            textViewTitle.setText(model.getTitle());


        }
    }
}
