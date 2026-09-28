package com.swmansion.rnscreens;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ScreenContainer extends ViewGroup {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f46989h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f46990a;

    /* renamed from: b, reason: collision with root package name */
    public FragmentManager f46991b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f46992c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f46993d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46994e;

    /* renamed from: f, reason: collision with root package name */
    public final ScreenContainer$layoutCallback$1 f46995f;

    /* renamed from: g, reason: collision with root package name */
    public ScreenFragmentWrapper f46996g;

    /* JADX WARN: Type inference failed for: r1v2, types: [com.swmansion.rnscreens.ScreenContainer$layoutCallback$1] */
    public ScreenContainer(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f46990a = new ArrayList();
        this.f46995f = new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.ScreenContainer$layoutCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                ScreenContainer screenContainer = this.f46997a;
                screenContainer.f46994e = false;
                screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(screenContainer.getHeight(), 1073741824));
                screenContainer.layout(screenContainer.getLeft(), screenContainer.getTop(), screenContainer.getRight(), screenContainer.getBottom());
            }
        };
    }

    private final void setFragmentManager(FragmentManager fragmentManager) {
        this.f46991b = fragmentManager;
        this.f46993d = true;
        g();
    }

    public ScreenFragmentWrapper a(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final FragmentTransaction b() {
        FragmentManager fragmentManager = this.f46991b;
        if (fragmentManager == null) {
            throw new IllegalArgumentException("fragment manager is null when creating transaction");
        }
        FragmentTransaction fragmentTransactionD = fragmentManager.d();
        fragmentTransactionD.r = true;
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionD, "setReorderingAllowed(...)");
        return fragmentTransactionD;
    }

    public boolean c(ScreenFragmentWrapper screenFragmentWrapper) {
        return CollectionsKt.s(this.f46990a, screenFragmentWrapper);
    }

    public void d() {
        ScreenFragmentWrapper fragmentWrapper;
        Screen topScreen = getTopScreen();
        if (topScreen == null || (fragmentWrapper = topScreen.getFragmentWrapper()) == null) {
            return;
        }
        fragmentWrapper.p();
    }

    public final void e() {
        this.f46993d = true;
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).f19479a.runOnUiQueueThread(new androidx.lifecycle.a(this, 9));
    }

    public void f() {
        FragmentTransaction fragmentTransactionB = b();
        FragmentManager fragmentManager = this.f46991b;
        if (fragmentManager == null) {
            throw new IllegalArgumentException("fragment manager is null when performing update in ScreenContainer");
        }
        HashSet hashSet = new HashSet(fragmentManager.L());
        ArrayList arrayList = this.f46990a;
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
            if (screenFragmentWrapper.k().getActivityState() == Screen.ActivityState.f46949a && screenFragmentWrapper.j().isAdded()) {
                fragmentTransactionB.i(screenFragmentWrapper.j());
            }
            hashSet.remove(screenFragmentWrapper.j());
        }
        boolean z = false;
        if (!hashSet.isEmpty()) {
            for (Fragment fragment : (Fragment[]) hashSet.toArray(new Fragment[0])) {
                if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).k().getContainer() == null) {
                    fragmentTransactionB.i(fragment);
                }
            }
        }
        boolean z2 = getTopScreen() == null;
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) next2;
            Screen.ActivityState activityState = screenFragmentWrapper2.k().getActivityState();
            Screen.ActivityState activityState2 = Screen.ActivityState.f46949a;
            if (activityState != activityState2 && !screenFragmentWrapper2.j().isAdded()) {
                fragmentTransactionB.h(getId(), screenFragmentWrapper2.j(), null, 1);
                z = true;
            } else if (activityState != activityState2 && z) {
                fragmentTransactionB.i(screenFragmentWrapper2.j());
                arrayList2.add(screenFragmentWrapper2);
            }
            screenFragmentWrapper2.k().setTransitioning(z2);
        }
        Iterator it3 = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next3 = it3.next();
            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
            fragmentTransactionB.h(getId(), ((ScreenFragmentWrapper) next3).j(), null, 1);
        }
        fragmentTransactionB.f();
    }

    public final void g() {
        FragmentManager fragmentManager;
        if (!this.f46993d || !this.f46992c || (fragmentManager = this.f46991b) == null || fragmentManager.K) {
            return;
        }
        this.f46993d = false;
        f();
        d();
    }

    public final int getScreenCount() {
        return this.f46990a.size();
    }

    @Nullable
    public Screen getTopScreen() {
        Object next;
        Iterator it = this.f46990a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ScreenFragmentWrapper) next).k().getActivityState() == Screen.ActivityState.f46951c) {
                break;
            }
        }
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.k();
        }
        return null;
    }

    public void h() {
        ArrayList arrayList = this.f46990a;
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ((ScreenFragmentWrapper) next).k().setContainer(null);
        }
        arrayList.clear();
        e();
    }

    public void i(int i2) {
        ArrayList arrayList = this.f46990a;
        ((ScreenFragmentWrapper) arrayList.get(i2)).k().setContainer(null);
        arrayList.remove(i2);
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        boolean z;
        boolean z2;
        FragmentManager supportFragmentManager;
        Unit unit;
        super.onAttachedToWindow();
        this.f46992c = true;
        ViewParent parent = this;
        while (true) {
            z = parent instanceof ReactRootView;
            if (z || (parent instanceof Screen) || parent.getParent() == null) {
                break;
            } else {
                parent = parent.getParent();
            }
        }
        if (parent instanceof Screen) {
            ScreenFragmentWrapper fragmentWrapper = ((Screen) parent).getFragmentWrapper();
            if (fragmentWrapper != null) {
                this.f46996g = fragmentWrapper;
                fragmentWrapper.o(this);
                FragmentManager childFragmentManager = fragmentWrapper.j().getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                setFragmentManager(childFragmentManager);
                unit = Unit.f53572a;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("Parent Screen does not have its Fragment attached");
            }
            return;
        }
        if (!z) {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
        }
        ReactRootView reactRootView = (ReactRootView) parent;
        Context context = reactRootView.getContext();
        while (true) {
            z2 = context instanceof FragmentActivity;
            if (z2 || !(context instanceof ContextWrapper)) {
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (!z2) {
            throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactActivity");
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity.getSupportFragmentManager().L().isEmpty()) {
            supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.c(supportFragmentManager);
        } else {
            try {
                Fragment fragmentF = FragmentManager.F(reactRootView);
                if (fragmentF == null) {
                    throw new IllegalStateException("View " + reactRootView + " does not have a Fragment set");
                }
                supportFragmentManager = fragmentF.getChildFragmentManager();
            } catch (IllegalStateException unused) {
                supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            }
        }
        setFragmentManager(supportFragmentManager);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.f46991b;
        if (fragmentManager != null && !fragmentManager.K) {
            FragmentTransaction fragmentTransactionD = fragmentManager.d();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionD, "beginTransaction(...)");
            boolean z = false;
            for (Fragment fragment : fragmentManager.L()) {
                if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).k().getContainer() == this) {
                    fragmentTransactionD.i(fragment);
                    z = true;
                }
            }
            if (z) {
                fragmentTransactionD.f();
            }
            fragmentManager.A(true);
            fragmentManager.G();
        }
        ScreenFragmentWrapper screenFragmentWrapper = this.f46996g;
        if (screenFragmentWrapper != null) {
            screenFragmentWrapper.q(this);
        }
        this.f46996g = null;
        super.onDetachedFromWindow();
        this.f46992c = false;
        for (int childCount = getChildCount() - 1; -1 < childCount; childCount--) {
            removeViewAt(childCount);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(i2, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        ScreenContainer$layoutCallback$1 screenContainer$layoutCallback$1;
        super.requestLayout();
        if (this.f46994e || (screenContainer$layoutCallback$1 = this.f46995f) == null) {
            return;
        }
        this.f46994e = true;
        ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19070c, screenContainer$layoutCallback$1);
    }
}
