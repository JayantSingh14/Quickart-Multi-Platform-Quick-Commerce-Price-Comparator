package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public Fragment f4605b;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void a(int i2, Object obj) {
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object e(ViewPager viewPager, int i2) {
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean f(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void g(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable h() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void i(Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f4605b;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f4605b.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.f4605b = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void j(ViewPager viewPager) {
        if (viewPager.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void b() {
    }
}
