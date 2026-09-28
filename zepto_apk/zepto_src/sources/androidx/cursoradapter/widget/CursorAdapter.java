package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.media.b;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

/* loaded from: classes3.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3303a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3304b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f3305c;

    /* renamed from: d, reason: collision with root package name */
    public Context f3306d;

    /* renamed from: e, reason: collision with root package name */
    public int f3307e;

    /* renamed from: f, reason: collision with root package name */
    public ChangeObserver f3308f;

    /* renamed from: g, reason: collision with root package name */
    public DataSetObserver f3309g;

    /* renamed from: h, reason: collision with root package name */
    public CursorFilter f3310h;

    public class ChangeObserver extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResourceCursorAdapter f3311a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeObserver(ResourceCursorAdapter resourceCursorAdapter) {
            super(new Handler());
            this.f3311a = resourceCursorAdapter;
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            Cursor cursor;
            ResourceCursorAdapter resourceCursorAdapter = this.f3311a;
            if (!resourceCursorAdapter.f3304b || (cursor = resourceCursorAdapter.f3305c) == null || cursor.isClosed()) {
                return;
            }
            resourceCursorAdapter.f3303a = resourceCursorAdapter.f3305c.requery();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResourceCursorAdapter f3312a;

        public MyDataSetObserver(ResourceCursorAdapter resourceCursorAdapter) {
            this.f3312a = resourceCursorAdapter;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ResourceCursorAdapter resourceCursorAdapter = this.f3312a;
            resourceCursorAdapter.f3303a = true;
            resourceCursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ResourceCursorAdapter resourceCursorAdapter = this.f3312a;
            resourceCursorAdapter.f3303a = false;
            resourceCursorAdapter.notifyDataSetInvalidated();
        }
    }

    public void a(Cursor cursor) {
        Cursor cursorH = h(cursor);
        if (cursorH != null) {
            cursorH.close();
        }
    }

    public String c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor d(CharSequence charSequence) {
        return this.f3305c;
    }

    public abstract void e(View view, Cursor cursor);

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return g(context, cursor, viewGroup);
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f3303a || (cursor = this.f3305c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f3303a) {
            return null;
        }
        this.f3305c.moveToPosition(i2);
        if (view == null) {
            view = f(this.f3306d, this.f3305c, viewGroup);
        }
        e(view, this.f3305c);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f3310h == null) {
            CursorFilter cursorFilter = new CursorFilter();
            cursorFilter.f3313a = this;
            this.f3310h = cursorFilter;
        }
        return this.f3310h;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        Cursor cursor;
        if (!this.f3303a || (cursor = this.f3305c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f3305c;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        Cursor cursor;
        if (this.f3303a && (cursor = this.f3305c) != null && cursor.moveToPosition(i2)) {
            return this.f3305c.getLong(this.f3307e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f3303a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f3305c.moveToPosition(i2)) {
            throw new IllegalStateException(b.f(i2, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = g(this.f3306d, this.f3305c, viewGroup);
        }
        e(view, this.f3305c);
        return view;
    }

    public Cursor h(Cursor cursor) {
        Cursor cursor2 = this.f3305c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f3308f;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f3309g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3305c = cursor;
        if (cursor == null) {
            this.f3307e = -1;
            this.f3303a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        ChangeObserver changeObserver2 = this.f3308f;
        if (changeObserver2 != null) {
            cursor.registerContentObserver(changeObserver2);
        }
        DataSetObserver dataSetObserver2 = this.f3309g;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f3307e = cursor.getColumnIndexOrThrow("_id");
        this.f3303a = true;
        notifyDataSetChanged();
        return cursor2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
