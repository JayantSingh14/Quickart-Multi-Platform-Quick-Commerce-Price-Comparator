package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FragmentLifecycleCallbacksDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f4561a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f4562b;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class FragmentLifecycleCallbacksHolder {

        /* renamed from: a, reason: collision with root package name */
        public final FragmentManager.FragmentLifecycleCallbacks f4563a;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f4563a = callback;
        }

        public final FragmentManager.FragmentLifecycleCallbacks a() {
            return this.f4563a;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.f4561a = fragmentManager;
        this.f4562b = new CopyOnWriteArrayList();
    }

    public final void a(Fragment f2, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.a(f2, bundle, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentActivityCreated(fragmentManager, f2, bundle);
        }
    }

    public final void b(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        FragmentActivity fragmentActivity = fragmentManager.x.f4555b;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.b(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentAttached(fragmentManager, f2, fragmentActivity);
        }
    }

    public final void c(Fragment f2, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.c(f2, bundle, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentCreated(fragmentManager, f2, bundle);
        }
    }

    public final void d(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.d(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentDestroyed(fragmentManager, f2);
        }
    }

    public final void e(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.e(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentDetached(fragmentManager, f2);
        }
    }

    public final void f(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.f(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentPaused(fragmentManager, f2);
        }
    }

    public final void g(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        FragmentActivity fragmentActivity = fragmentManager.x.f4555b;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.g(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentPreAttached(fragmentManager, f2, fragmentActivity);
        }
    }

    public final void h(Fragment f2, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.h(f2, bundle, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentPreCreated(fragmentManager, f2, bundle);
        }
    }

    public final void i(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.i(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentResumed(fragmentManager, f2);
        }
    }

    public final void j(Fragment f2, Bundle outState, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.j(f2, outState, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentSaveInstanceState(fragmentManager, f2, outState);
        }
    }

    public final void k(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.k(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentStarted(fragmentManager, f2);
        }
    }

    public final void l(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.l(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentStopped(fragmentManager, f2);
        }
    }

    public final void m(Fragment f2, View v, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.m(f2, v, bundle, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentViewCreated(fragmentManager, f2, v, bundle);
        }
    }

    public final void n(Fragment f2, boolean z) {
        Intrinsics.checkNotNullParameter(f2, "f");
        FragmentManager fragmentManager = this.f4561a;
        Fragment fragment = fragmentManager.z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.p.n(f2, true);
        }
        Iterator it = this.f4562b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (z) {
                fragmentLifecycleCallbacksHolder.getClass();
            }
            fragmentLifecycleCallbacksHolder.a().onFragmentViewDestroyed(fragmentManager, f2);
        }
    }
}
