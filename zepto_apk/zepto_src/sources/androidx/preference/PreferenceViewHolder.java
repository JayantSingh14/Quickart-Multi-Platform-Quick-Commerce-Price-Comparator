package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    public final SparseArray u;
    public boolean v;
    public boolean w;

    public PreferenceViewHolder(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.u = sparseArray;
        sparseArray.put(android.R.id.title, view.findViewById(android.R.id.title));
        sparseArray.put(android.R.id.summary, view.findViewById(android.R.id.summary));
        sparseArray.put(android.R.id.icon, view.findViewById(android.R.id.icon));
        int i2 = R.id.icon_frame;
        sparseArray.put(i2, view.findViewById(i2));
        sparseArray.put(android.R.id.icon_frame, view.findViewById(android.R.id.icon_frame));
    }

    public final View q(int i2) {
        SparseArray sparseArray = this.u;
        View view = (View) sparseArray.get(i2);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f11653a.findViewById(i2);
        if (viewFindViewById != null) {
            sparseArray.put(i2, viewFindViewById);
        }
        return viewFindViewById;
    }
}
