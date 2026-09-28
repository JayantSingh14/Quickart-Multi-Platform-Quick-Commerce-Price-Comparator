package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f46401d = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return this.f46401d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        ViewPagerViewHolder holder = (ViewPagerViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.f11653a;
        Intrinsics.d(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        Object obj = this.f46401d.get(i2);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        View view2 = (View) obj;
        holder.n(false);
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view2.getParent() != null) {
            ViewParent parent = view2.getParent();
            Intrinsics.d(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
            ((FrameLayout) parent).removeView(view2);
        }
        frameLayout.addView(view2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i3 = ViewPagerViewHolder.u;
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setSaveEnabled(false);
        return new ViewPagerViewHolder(frameLayout);
    }
}
