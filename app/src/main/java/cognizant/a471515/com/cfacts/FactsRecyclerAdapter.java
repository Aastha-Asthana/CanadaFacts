package cognizant.a471515.com.cfacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cognizant.a471515.com.cfacts.models.FactsCanadaRow;

public class FactsRecyclerAdapter extends RecyclerView.Adapter<FactsRecyclerAdapter.ViewHolder> {

    private List<FactsCanadaRow> factsList = new ArrayList<>();
    private Context context;

    public FactsRecyclerAdapter(List<FactsCanadaRow> list){
        factsList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.facts_list_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            FactsCanadaRow factsCanadaRow = factsList.get(position);
            if(null != factsCanadaRow.getTitle()){
                viewHolder.title.setText(factsCanadaRow.getTitle());
            }else{
                viewHolder.title.setText("Title Not Available");
            }
            if(null != factsCanadaRow.getDescription()){
                viewHolder.description.setText(factsCanadaRow.getDescription());
            }else{
                viewHolder.description.setText("Description Not Available");
            }
            viewHolder.factsItemImage.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return factsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView description;
        public ImageView factsItemImage;


        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.facts_title);
            description = (TextView) itemView.findViewById(R.id.facts_description);
            factsItemImage = (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}
