package besupreme.com.quickchem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Yinka on 2016-08-28.
 */
public class ListAdaptor extends RecyclerView.Adapter<ListAdaptor.ListViewHolder> {
    private PeriodicTable mPeriodicTable;
    private Context mContext;


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.element_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.elementSymbol.setText( mPeriodicTable.mElements.get(position).getSymbol() );
        holder.elementName.setText( mPeriodicTable.mElements.get(position).getName() );
        holder.atomicNumber.setText( mPeriodicTable.mElements.get(position).getAtomic_number() );
        holder.atomicMass.setText( mPeriodicTable.mElements.get(position).getStandard_atomic_weight() );
    }

    public ListAdaptor(Context context, PeriodicTable periodicTable){
        mContext = context;
        mPeriodicTable = periodicTable;
    }



    @Override
    public int getItemCount() {
        return mPeriodicTable.mElements.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        public TextView elementSymbol;
        TextView elementName;
        TextView atomicNumber;
        TextView atomicMass;

        public ListViewHolder(View itemView) {
            super(itemView);

            elementSymbol = (TextView) itemView.findViewById(R.id.elementSymbol);
            elementName = (TextView) itemView.findViewById(R.id.elementTitle);
            atomicNumber = (TextView) itemView.findViewById(R.id.atomicNumberTitle);
            atomicMass = (TextView) itemView.findViewById(R.id.atomicMassTitle);
        }

    }
}
