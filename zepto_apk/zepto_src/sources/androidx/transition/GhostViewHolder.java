package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
class GhostViewHolder extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f12080c = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f12081a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12082b;

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static float a(View view) {
            return view.getZ();
        }
    }

    public static void a(View view, ArrayList arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        if (!this.f12082b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            int i2 = R.id.ghost_view_holder;
            ViewGroup viewGroup = this.f12081a;
            viewGroup.setTag(i2, null);
            viewGroup.getOverlay().remove(this);
            this.f12082b = false;
        }
    }
}
