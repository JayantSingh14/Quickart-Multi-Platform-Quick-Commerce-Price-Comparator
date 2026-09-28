package androidx.viewpager2.widget;

import android.support.v4.media.b;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes3.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f12377a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager2.PageTransformer f12378b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f12377a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void a(int i2) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void b(float f2, int i2, int i3) {
        if (this.f12378b == null) {
            return;
        }
        float f3 = -f2;
        int i4 = 0;
        while (true) {
            LinearLayoutManager linearLayoutManager = this.f12377a;
            if (i4 >= linearLayoutManager.v()) {
                return;
            }
            View viewU = linearLayoutManager.u(i4);
            if (viewU == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException(b.e(i4, linearLayoutManager.v(), "LayoutManager returned a null child at pos ", "/", " while transforming pages"));
            }
            this.f12378b.a(viewU, (RecyclerView.LayoutManager.L(viewU) - i2) + f3);
            i4++;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void c(int i2) {
    }

    public final ViewPager2.PageTransformer d() {
        return this.f12378b;
    }

    public final void e(ViewPager2.PageTransformer pageTransformer) {
        this.f12378b = pageTransformer;
    }
}
