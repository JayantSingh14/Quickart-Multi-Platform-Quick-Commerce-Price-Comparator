package com.th3rdwave.safeareacontext;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.media3.common.util.e;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.react.b;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class SafeAreaView extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f47168f = 0;

    /* renamed from: a, reason: collision with root package name */
    public SafeAreaViewMode f47169a;

    /* renamed from: b, reason: collision with root package name */
    public EdgeInsets f47170b;

    /* renamed from: c, reason: collision with root package name */
    public SafeAreaViewEdges f47171c;

    /* renamed from: d, reason: collision with root package name */
    public View f47172d;

    /* renamed from: e, reason: collision with root package name */
    public StateWrapper f47173e;

    @Nullable
    public final StateWrapper getStateWrapper() {
        return this.f47173e;
    }

    public final void j() {
        EdgeInsets edgeInsets = this.f47170b;
        if (edgeInsets != null) {
            SafeAreaViewEdges safeAreaViewEdges = this.f47171c;
            if (safeAreaViewEdges == null) {
                SafeAreaViewEdgeModes safeAreaViewEdgeModes = SafeAreaViewEdgeModes.f47175b;
                safeAreaViewEdges = new SafeAreaViewEdges(safeAreaViewEdgeModes, safeAreaViewEdgeModes, safeAreaViewEdgeModes, safeAreaViewEdgeModes);
            }
            StateWrapper stateWrapper = getStateWrapper();
            if (stateWrapper != null) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putMap("insets", SerializationUtilsKt.a(edgeInsets));
                stateWrapper.updateState(writableMapCreateMap);
                return;
            }
            SafeAreaViewLocalData safeAreaViewLocalData = new SafeAreaViewLocalData(edgeInsets, this.f47169a, safeAreaViewEdges);
            ReactContext reactContextA = UIManagerHelperCompatKt.a(this);
            UIManagerModule uIManagerModule = (UIManagerModule) reactContextA.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), safeAreaViewLocalData);
                reactContextA.runOnNativeModulesQueueThread(new b(uIManagerModule, 2));
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                ReentrantLock reentrantLock = new ReentrantLock();
                Condition conditionNewCondition = reentrantLock.newCondition();
                long jNanoTime = System.nanoTime();
                UIManagerHelperCompatKt.a(this).runOnNativeModulesQueueThread(new e(reentrantLock, booleanRef, conditionNewCondition, 16));
                reentrantLock.lock();
                long jNanoTime2 = 0;
                while (!booleanRef.f53798a && jNanoTime2 < 500000000) {
                    try {
                        try {
                            conditionNewCondition.awaitNanos(500000000L);
                        } catch (InterruptedException unused) {
                            booleanRef.f53798a = true;
                        }
                        jNanoTime2 += System.nanoTime() - jNanoTime;
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                Unit unit = Unit.f53572a;
                reentrantLock.unlock();
                if (jNanoTime2 >= 500000000) {
                    Log.w("SafeAreaView", "Timed out waiting for layout.");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        View view;
        EdgeInsets edgeInsetsB;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent == 0) {
                view = this;
                break;
            } else {
                if (parent instanceof SafeAreaProvider) {
                    view = (View) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.f47172d = view;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(this);
        }
        View view2 = this.f47172d;
        if (view2 == null || (edgeInsetsB = SafeAreaUtilsKt.b(view2)) == null || Intrinsics.b(this.f47170b, edgeInsetsB)) {
            return;
        }
        this.f47170b = edgeInsetsB;
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        View view = this.f47172d;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this.f47172d = null;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        EdgeInsets edgeInsetsB;
        View view = this.f47172d;
        boolean z = false;
        if (view != null && (edgeInsetsB = SafeAreaUtilsKt.b(view)) != null && !Intrinsics.b(this.f47170b, edgeInsetsB)) {
            this.f47170b = edgeInsetsB;
            j();
            z = true;
        }
        if (z) {
            requestLayout();
        }
        return !z;
    }

    public final void setEdges(@NotNull SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.f47171c = edges;
        j();
    }

    public final void setMode(@NotNull SafeAreaViewMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f47169a = mode;
        j();
    }

    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
        this.f47173e = stateWrapper;
    }
}
