package cognizant.a471515.com.cfacts.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cognizant.a471515.com.cfacts.FactsUtils;
import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.models.FactsResponseRow;

public class FactsRecyclerAdapter extends RecyclerView.Adapter<FactsRecyclerAdapter.ViewHolder> {

    private List<FactsResponseRow> factsList = new ArrayList<>();
    private Context mContext;
    private FactsUtils factsUtils = new FactsUtils();

    public FactsRecyclerAdapter( Context context) {
        mContext = context;
    }

    public void setDataList(List<FactsResponseRow> list){
        factsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View contactView = inflater.inflate(R.layout.facts_list_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
            final FactsResponseRow factsCanadaRow = factsList.get(position);
            if(null != factsCanadaRow.getTitle()){
                viewHolder.title.setText(factsUtils.getAppendedFactsPosition(position + 1,factsCanadaRow.getTitle()));
            }else{
                viewHolder.title.setText(mContext.getString(R.string.title_not_available));
            }
            if(null != factsCanadaRow.getDescription()){
                viewHolder.description.setText(factsCanadaRow.getDescription());
            }else{
                viewHolder.description.setText(mContext.getString(R.string.description_not_available));
            }
            if(null != factsCanadaRow.getImageHref()) {
                Picasso.Builder builder = new Picasso.Builder(mContext);
                Picasso picasso = builder.build();
                builder.listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                       exception.printStackTrace();
                    }
                });

               picasso.load(factsCanadaRow.getImageHref()).placeholder(R.mipmap.placeholder)
                        .into(viewHolder.factsItemImage);
            }else{
                viewHolder.factsItemImage.setImageResource(R.mipmap.placeholder);
            }


    }

    @Override
    public int getItemCount() {
        return factsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView description;
        public TextView descriptionTitle;
        public ImageView factsItemImage;


        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.facts_title);
            description = (TextView) itemView.findViewById(R.id.facts_description);
            descriptionTitle = (TextView) itemView.findViewById(R.id.facts_description_heading);
            factsItemImage = (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}
