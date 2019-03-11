package cognizant.a471515.com.cfacts;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cognizant.a471515.com.cfacts.models.FactsCanadaRow;

public class FactsRecyclerAdapter extends RecyclerView.Adapter<FactsRecyclerAdapter.ViewHolder> {

    private List<FactsCanadaRow> factsList = new ArrayList<>();
    private Context mContext;
    private FactsCanadaUtils factsCanadaUtils = new FactsCanadaUtils();

    public FactsRecyclerAdapter(List<FactsCanadaRow> list, Context context){
        factsList = list;
        mContext = context;
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            final FactsCanadaRow factsCanadaRow = factsList.get(position);
            if(null != factsCanadaRow.getTitle()){
                viewHolder.title.setText(factsCanadaUtils.getAppendedFactsPosition(mContext,position + 1,factsCanadaRow.getTitle()));
            }else{
                viewHolder.title.setText("Title Not Available");
            }
            viewHolder.descriptionTitle.setText(factsCanadaUtils.getUnderLinedString("Description"));
            if(null != factsCanadaRow.getDescription()){
                viewHolder.description.setText(factsCanadaRow.getDescription());
            }else{
                viewHolder.description.setText("Description Not Available");
            }
            if(null != factsCanadaRow.getImageHref()) {
                Picasso.Builder builder = new Picasso.Builder(mContext);
                builder.listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.d("Picasso Exception",exception.getMessage());
                        Log.d("Picasso Exception",factsCanadaRow.getImageHref());
                    }
                });
               Picasso picasso = builder.build();
               picasso.load(factsCanadaRow.getImageHref()).fit().centerCrop()
                        .into(viewHolder.factsItemImage);
   //             viewHolder.factsItemImage.setImageURI(factsCanadaRow.getImageHref());
            }else{
                viewHolder.factsItemImage.setImageResource(R.mipmap.ic_launcher);
            }


    }

    @Override
    public int getItemCount() {
        return factsList.size();
    }

    public void clear() {
        factsList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<FactsCanadaRow> list) {
        factsList.addAll(list);
        notifyDataSetChanged();
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
            descriptionTitle = (TextView)itemView.findViewById(R.id.facts_description_heading);
            factsItemImage = (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}
