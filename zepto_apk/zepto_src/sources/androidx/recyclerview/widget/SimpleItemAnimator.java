package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11670g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        if (itemHolderInfo != null && ((i2 = itemHolderInfo.f11574a) != (i3 = itemHolderInfo2.f11574a) || itemHolderInfo.f11575b != itemHolderInfo2.f11575b)) {
            return o(viewHolder, i2, itemHolderInfo.f11575b, i3, itemHolderInfo2.f11575b);
        }
        m(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        int i4 = itemHolderInfo.f11574a;
        int i5 = itemHolderInfo.f11575b;
        if (viewHolder2.o()) {
            int i6 = itemHolderInfo.f11574a;
            i3 = itemHolderInfo.f11575b;
            i2 = i6;
        } else {
            i2 = itemHolderInfo2.f11574a;
            i3 = itemHolderInfo2.f11575b;
        }
        return n(viewHolder, viewHolder2, i4, i5, i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2 = itemHolderInfo.f11574a;
        int i3 = itemHolderInfo.f11575b;
        View view = viewHolder.f11653a;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.f11574a;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.f11575b;
        if (viewHolder.h() || (i2 == left && i3 == top)) {
            p(viewHolder);
            return true;
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return o(viewHolder, i2, i3, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2 = itemHolderInfo.f11574a;
        int i3 = itemHolderInfo2.f11574a;
        if (i2 != i3 || itemHolderInfo.f11575b != itemHolderInfo2.f11575b) {
            return o(viewHolder, i2, itemHolderInfo.f11575b, i3, itemHolderInfo2.f11575b);
        }
        h(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean f(RecyclerView.ViewHolder viewHolder) {
        return !this.f11670g || viewHolder.f();
    }

    public abstract void m(RecyclerView.ViewHolder viewHolder);

    public abstract boolean n(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5);

    public abstract boolean o(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5);

    public abstract void p(RecyclerView.ViewHolder viewHolder);
}
