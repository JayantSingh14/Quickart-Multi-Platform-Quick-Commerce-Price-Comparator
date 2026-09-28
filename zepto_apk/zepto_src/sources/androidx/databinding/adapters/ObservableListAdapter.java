package androidx.databinding.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;

@RestrictTo
/* loaded from: classes3.dex */
class ObservableListAdapter<T> extends BaseAdapter {

    /* renamed from: androidx.databinding.adapters.ObservableListAdapter$1, reason: invalid class name */
    class AnonymousClass1 extends ObservableList.OnListChangedCallback {
        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void a() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void b() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void c() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void d() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void e() {
            throw null;
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TextView(null);
        }
        throw null;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        throw null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TextView(null);
        }
        throw null;
    }
}
