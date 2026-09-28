package androidx.viewpager2.widget;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat windowInsetsCompatT = ViewCompat.t(viewPager2, windowInsetsCompat);
        if (windowInsetsCompatT.n()) {
            return windowInsetsCompatT;
        }
        RecyclerView recyclerView = viewPager2.f12403j;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewCompat.c(recyclerView.getChildAt(i2), new WindowInsetsCompat(windowInsetsCompatT));
        }
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.f3149b;
        return windowInsetsCompat2.q() != null ? windowInsetsCompat2 : windowInsetsCompatT.c().b();
    }
}
