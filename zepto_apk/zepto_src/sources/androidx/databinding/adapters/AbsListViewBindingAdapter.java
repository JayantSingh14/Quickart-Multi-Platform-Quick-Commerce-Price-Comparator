package androidx.databinding.adapters;

import android.widget.AbsListView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class AbsListViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AbsListViewBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    public interface OnScroll {
    }

    public interface OnScrollStateChanged {
    }
}
