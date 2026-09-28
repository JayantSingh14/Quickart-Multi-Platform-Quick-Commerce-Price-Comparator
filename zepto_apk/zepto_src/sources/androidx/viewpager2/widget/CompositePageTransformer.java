package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12376a = new ArrayList();

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void a(View view, float f2) {
        Iterator it = this.f12376a.iterator();
        while (it.hasNext()) {
            ((ViewPager2.PageTransformer) it.next()).a(view, f2);
        }
    }
}
