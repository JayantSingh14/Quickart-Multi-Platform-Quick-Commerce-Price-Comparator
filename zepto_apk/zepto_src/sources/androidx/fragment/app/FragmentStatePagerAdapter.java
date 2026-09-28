package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final FragmentManager f4626b;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4632h;

    /* renamed from: d, reason: collision with root package name */
    public FragmentTransaction f4628d = null;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4629e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f4630f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public Fragment f4631g = null;

    /* renamed from: c, reason: collision with root package name */
    public final int f4627c = 1;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f4626b = fragmentManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    @Override // androidx.viewpager.widget.PagerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            androidx.fragment.app.FragmentTransaction r0 = r6.f4628d
            androidx.fragment.app.FragmentManager r1 = r6.f4626b
            if (r0 != 0) goto L12
            r1.getClass()
            androidx.fragment.app.BackStackRecord r0 = new androidx.fragment.app.BackStackRecord
            r0.<init>(r1)
            r6.f4628d = r0
        L12:
            java.util.ArrayList r0 = r6.f4629e
            int r2 = r0.size()
            r3 = 0
            if (r2 > r7) goto L1f
            r0.add(r3)
            goto L12
        L1f:
            boolean r2 = r8.isAdded()
            if (r2 == 0) goto L5e
            r1.getClass()
            java.lang.String r2 = r8.mWho
            androidx.fragment.app.FragmentStore r4 = r1.f4566c
            java.util.HashMap r4 = r4.f4634b
            java.lang.Object r2 = r4.get(r2)
            androidx.fragment.app.FragmentStateManager r2 = (androidx.fragment.app.FragmentStateManager) r2
            if (r2 == 0) goto L4d
            androidx.fragment.app.Fragment r4 = r2.f4621c
            boolean r5 = r4.equals(r8)
            if (r5 == 0) goto L4d
            int r1 = r4.mState
            r4 = -1
            if (r1 <= r4) goto L5e
            androidx.fragment.app.Fragment$SavedState r1 = new androidx.fragment.app.Fragment$SavedState
            android.os.Bundle r2 = r2.n()
            r1.<init>(r2)
            goto L5f
        L4d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Fragment "
            java.lang.String r2 = " is not currently in the FragmentManager"
            java.lang.String r8 = androidx.fragment.app.e.o(r0, r8, r2)
            r7.<init>(r8)
            r1.k0(r7)
            throw r3
        L5e:
            r1 = r3
        L5f:
            r0.set(r7, r1)
            java.util.ArrayList r0 = r6.f4630f
            r0.set(r7, r3)
            androidx.fragment.app.FragmentTransaction r7 = r6.f4628d
            r7.i(r8)
            androidx.fragment.app.Fragment r7 = r6.f4631g
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L76
            r6.f4631g = r3
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStatePagerAdapter.a(int, java.lang.Object):void");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void b() {
        FragmentTransaction fragmentTransaction = this.f4628d;
        if (fragmentTransaction != null) {
            if (!this.f4632h) {
                try {
                    this.f4632h = true;
                    fragmentTransaction.f();
                } finally {
                    this.f4632h = false;
                }
            }
            this.f4628d = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object e(ViewPager viewPager, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        ArrayList arrayList = this.f4630f;
        if (arrayList.size() > i2 && (fragment = (Fragment) arrayList.get(i2)) != null) {
            return fragment;
        }
        if (this.f4628d == null) {
            FragmentManager fragmentManager = this.f4626b;
            fragmentManager.getClass();
            this.f4628d = new BackStackRecord(fragmentManager);
        }
        Fragment fragmentK = k(i2);
        ArrayList arrayList2 = this.f4629e;
        if (arrayList2.size() > i2 && (savedState = (Fragment.SavedState) arrayList2.get(i2)) != null) {
            fragmentK.setInitialSavedState(savedState);
        }
        while (arrayList.size() <= i2) {
            arrayList.add(null);
        }
        fragmentK.setMenuVisibility(false);
        int i3 = this.f4627c;
        if (i3 == 0) {
            fragmentK.setUserVisibleHint(false);
        }
        arrayList.set(i2, fragmentK);
        this.f4628d.h(viewPager.getId(), fragmentK, null, 1);
        if (i3 == 1) {
            this.f4628d.l(fragmentK, Lifecycle.State.f4808d);
        }
        return fragmentK;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean f(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void g(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            ArrayList arrayList = this.f4629e;
            arrayList.clear();
            ArrayList arrayList2 = this.f4630f;
            arrayList2.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    arrayList.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i2 = Integer.parseInt(str.substring(1));
                    Fragment fragmentI = this.f4626b.I(bundle, str);
                    if (fragmentI != null) {
                        while (arrayList2.size() <= i2) {
                            arrayList2.add(null);
                        }
                        fragmentI.setMenuVisibility(false);
                        arrayList2.set(i2, fragmentI);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key ".concat(str));
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable h() {
        Bundle bundle;
        ArrayList arrayList = this.f4629e;
        if (arrayList.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[arrayList.size()];
            arrayList.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        int i2 = 0;
        while (true) {
            ArrayList arrayList2 = this.f4630f;
            if (i2 >= arrayList2.size()) {
                return bundle;
            }
            Fragment fragment = (Fragment) arrayList2.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f4626b.Y(bundle, android.support.v4.media.b.f(i2, "f"), fragment);
            }
            i2++;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void i(Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f4631g;
        if (fragment != fragment2) {
            FragmentManager fragmentManager = this.f4626b;
            int i2 = this.f4627c;
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (i2 == 1) {
                    if (this.f4628d == null) {
                        fragmentManager.getClass();
                        this.f4628d = new BackStackRecord(fragmentManager);
                    }
                    this.f4628d.l(this.f4631g, Lifecycle.State.f4808d);
                } else {
                    this.f4631g.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (i2 == 1) {
                if (this.f4628d == null) {
                    fragmentManager.getClass();
                    this.f4628d = new BackStackRecord(fragmentManager);
                }
                this.f4628d.l(fragment, Lifecycle.State.f4809e);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f4631g = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void j(ViewPager viewPager) {
        if (viewPager.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment k(int i2);
}
