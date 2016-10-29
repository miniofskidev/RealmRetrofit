package jik.android.retrofitrelm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;
import jik.android.retrofitrelm.R;
import jik.android.retrofitrelm.models.RealmUserModel;
import jik.android.retrofitrelm.realm.RealmController;

/**
 * Created by tosantechnolocal on 10/29/2016.
 */
public class RealmUserAdapter extends RealmRecyclerViewAdapter<RealmUserModel> {

    final Context context;
    private Realm realm;
    private LayoutInflater inflater;

    public RealmUserAdapter(Context context) {
        this.context = context;
    }

    // create new views (invoked by the layout manager)
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate a new card view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        realm = RealmController.getInstance().getRealm();

        final RealmUserModel userModel = getItem(position);
        // cast the generic view holder to our specific one
        final Holder holder = (Holder) viewHolder;

        // set the title and the snippet
        holder.name.setText(userModel.getName());
        holder.family.setText(userModel.getFamily());
        holder.number.setText(userModel.getNumber());
    }

    public int getItemCount() {

        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView name, family, number;

        public Holder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            family = (TextView) itemView.findViewById(R.id.familyTextView);
            number = (TextView) itemView.findViewById(R.id.numberTextView);
        }
    }
}
