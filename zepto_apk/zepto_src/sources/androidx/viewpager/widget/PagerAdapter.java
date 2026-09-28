package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
public abstract class PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f12323a = new DataSetObservable();

    public void a(int i2, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public abstract int c();

    public CharSequence d(int i2) {
        return null;
    }

    public Object e(ViewPager viewPager, int i2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public abstract boolean f(View view, Object obj);

    public void g(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable h() {
        return null;
    }

    public void b() {
    }

    public void i(Object obj) {
    }

    public void j(ViewPager viewPager) {
    }
}
