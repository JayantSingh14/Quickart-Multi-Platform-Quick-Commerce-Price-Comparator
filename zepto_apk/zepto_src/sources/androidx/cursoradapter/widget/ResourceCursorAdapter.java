package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;

/* loaded from: classes3.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: i, reason: collision with root package name */
    public final int f3314i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3315j;

    /* renamed from: k, reason: collision with root package name */
    public final LayoutInflater f3316k;

    public ResourceCursorAdapter(Context context, int i2) {
        this.f3304b = true;
        this.f3305c = null;
        this.f3303a = false;
        this.f3306d = context;
        this.f3307e = -1;
        this.f3308f = new CursorAdapter.ChangeObserver(this);
        this.f3309g = new CursorAdapter.MyDataSetObserver(this);
        this.f3315j = i2;
        this.f3314i = i2;
        this.f3316k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3316k.inflate(this.f3315j, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3316k.inflate(this.f3314i, viewGroup, false);
    }
}
