package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12375a = new ArrayList(3);

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void a(int i2) {
        try {
            Iterator it = this.f12375a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void b(float f2, int i2, int i3) {
        try {
            Iterator it = this.f12375a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).b(f2, i2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void c(int i2) {
        try {
            Iterator it = this.f12375a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).c(i2);
            }
        } catch (ConcurrentModificationException e2) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e2);
        }
    }

    public final void d(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12375a.add(onPageChangeCallback);
    }

    public final void e(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12375a.remove(onPageChangeCallback);
    }
}
