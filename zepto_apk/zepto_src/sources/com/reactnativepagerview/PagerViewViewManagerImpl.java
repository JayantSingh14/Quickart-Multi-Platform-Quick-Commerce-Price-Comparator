package com.reactnativepagerview;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.PixelUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class PagerViewViewManagerImpl {

    /* renamed from: a, reason: collision with root package name */
    public static b f46400a;

    public static void a(NestedScrollableHost host, View child, int i2) {
        Integer initialIndex;
        Intrinsics.checkNotNullParameter(host, "host");
        if (child == null) {
            return;
        }
        ViewPager2 viewPager2D = d(host);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager2D.getAdapter();
        if (viewPagerAdapter != null) {
            Intrinsics.checkNotNullParameter(child, "child");
            viewPagerAdapter.f46401d.add(i2, child);
            viewPagerAdapter.j(i2);
        }
        if (viewPager2D.getCurrentItem() == i2) {
            viewPager2D.post(new androidx.constraintlayout.helper.widget.a(viewPager2D, 23));
        }
        if (host.getDidSetInitialIndex() || (initialIndex = host.getInitialIndex()) == null || initialIndex.intValue() != i2) {
            return;
        }
        host.setDidSetInitialIndex(true);
        h(viewPager2D, i2, false);
    }

    public static View b(NestedScrollableHost parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) d(parent).getAdapter();
        Intrinsics.c(viewPagerAdapter);
        Object obj = viewPagerAdapter.f46401d.get(i2);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (View) obj;
    }

    public static int c(NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView.Adapter adapter = d(parent).getAdapter();
        if (adapter != null) {
            return adapter.d();
        }
        return 0;
    }

    public static ViewPager2 d(NestedScrollableHost view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view.getChildAt(0) instanceof ViewPager2)) {
            throw new ClassNotFoundException("Could not retrieve ViewPager2 instance");
        }
        View childAt = view.getChildAt(0);
        Intrinsics.d(childAt, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        return (ViewPager2) childAt;
    }

    public static void e(NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPager2 viewPager2D = d(parent);
        viewPager2D.setUserInputEnabled(false);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager2D.getAdapter();
        if (viewPagerAdapter != null) {
            ArrayList arrayList = viewPagerAdapter.f46401d;
            int size = arrayList.size();
            int i2 = 1;
            if (1 <= size) {
                while (true) {
                    Object obj = arrayList.get(i2 - 1);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    View view = (View) obj;
                    ViewParent parent2 = view.getParent();
                    if ((parent2 != null ? parent2.getParent() : null) != null) {
                        ViewParent parent3 = view.getParent().getParent();
                        Intrinsics.d(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
                        Object parent4 = view.getParent();
                        Intrinsics.d(parent4, "null cannot be cast to non-null type android.view.View");
                        ((ViewGroup) parent3).removeView((View) parent4);
                    }
                    if (i2 == size) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            int size2 = arrayList.size();
            arrayList.clear();
            viewPagerAdapter.l(0, size2);
        }
    }

    public static void f(NestedScrollableHost parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "view");
        ViewPager2 viewPager2D = d(parent);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager2D.getAdapter();
        if (viewPagerAdapter != null) {
            Intrinsics.checkNotNullParameter(child, "child");
            ArrayList arrayList = viewPagerAdapter.f46401d;
            int iIndexOf = arrayList.indexOf(child);
            if (iIndexOf > -1 && iIndexOf >= 0 && iIndexOf < arrayList.size()) {
                arrayList.remove(iIndexOf);
                viewPagerAdapter.m(iIndexOf);
            }
        }
        viewPager2D.post(new androidx.constraintlayout.helper.widget.a(viewPager2D, 23));
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.reactnativepagerview.b] */
    public static void g(NestedScrollableHost parent, int i2) {
        View view;
        Intrinsics.checkNotNullParameter(parent, "parent");
        final ViewPager2 viewPager2D = d(parent);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager2D.getAdapter();
        if (viewPagerAdapter != null) {
            Object obj = viewPagerAdapter.f46401d.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            view = (View) obj;
        } else {
            view = null;
        }
        if (view != null && view.getParent() != null) {
            ViewParent parent2 = view.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        if (viewPagerAdapter != null && i2 >= 0) {
            ArrayList arrayList = viewPagerAdapter.f46401d;
            if (i2 < arrayList.size()) {
                arrayList.remove(i2);
                viewPagerAdapter.m(i2);
            }
        }
        b bVar = f46400a;
        if (bVar != null) {
            Choreographer.getInstance().removeFrameCallback(bVar);
        }
        RecyclerView.Adapter adapter = viewPager2D.getAdapter();
        ViewPagerAdapter viewPagerAdapter2 = adapter instanceof ViewPagerAdapter ? (ViewPagerAdapter) adapter : null;
        if (viewPagerAdapter2 == null || viewPagerAdapter2.f46401d.size() == 0) {
            return;
        }
        f46400a = new Choreographer.FrameCallback() { // from class: com.reactnativepagerview.b
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                ViewPager2 viewPager2 = viewPager2D;
                viewPager2.post(new androidx.constraintlayout.helper.widget.a(viewPager2, 23));
                PagerViewViewManagerImpl.f46400a = null;
            }
        };
        Choreographer.getInstance().postFrameCallback(f46400a);
    }

    public static void h(ViewPager2 view, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.post(new androidx.constraintlayout.helper.widget.a(view, 23));
        view.d(i2, z);
    }

    public static void i(NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        ViewPager2 viewPager2D = d(host);
        if (host.getInitialIndex() == null) {
            host.setInitialIndex(Integer.valueOf(i2));
            viewPager2D.post(new androidx.constraintlayout.helper.widget.a(host, 24));
        }
    }

    public static void j(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        ViewPager2 viewPager2D = d(host);
        if (Intrinsics.b(value, "rtl")) {
            viewPager2D.setLayoutDirection(1);
        } else {
            viewPager2D.setLayoutDirection(0);
        }
    }

    public static void k(NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        d(host).setOffscreenPageLimit(i2);
    }

    public static void l(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        d(host).setOrientation(Intrinsics.b(value, "vertical") ? 1 : 0);
    }

    public static void m(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        View childAt = d(host).getChildAt(0);
        if (Intrinsics.b(value, "never")) {
            childAt.setOverScrollMode(2);
        } else if (Intrinsics.b(value, "always")) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    public static void n(NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        final ViewPager2 viewPager2D = d(host);
        final int iB = (int) PixelUtil.b(i2);
        viewPager2D.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.reactnativepagerview.a
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void a(View page, float f2) {
                Intrinsics.checkNotNullParameter(page, "page");
                float f3 = iB * f2;
                ViewPager2 viewPager2 = viewPager2D;
                if (viewPager2.getOrientation() != 0) {
                    page.setTranslationY(f3);
                    return;
                }
                if (viewPager2.getLayoutDirection() == 1) {
                    f3 = -f3;
                }
                page.setTranslationX(f3);
            }
        });
    }

    public static void o(NestedScrollableHost host, boolean z) {
        Intrinsics.checkNotNullParameter(host, "host");
        d(host).setUserInputEnabled(z);
    }
}
