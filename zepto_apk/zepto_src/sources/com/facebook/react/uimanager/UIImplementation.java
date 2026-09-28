package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.os.Trace;
import android.util.SparseBooleanArray;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherImpl;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class UIImplementation {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19493a;

    /* renamed from: b, reason: collision with root package name */
    public final EventDispatcher f19494b;

    /* renamed from: c, reason: collision with root package name */
    public final ReactApplicationContext f19495c;

    /* renamed from: d, reason: collision with root package name */
    public final ShadowNodeRegistry f19496d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewManagerRegistry f19497e;

    /* renamed from: f, reason: collision with root package name */
    public final UIViewOperationQueue f19498f;

    /* renamed from: g, reason: collision with root package name */
    public final NativeViewHierarchyOptimizer f19499g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f19500h;

    /* renamed from: i, reason: collision with root package name */
    public long f19501i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f19502j;

    /* loaded from: classes3.dex */
    public interface LayoutUpdateListener {
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcherImpl eventDispatcherImpl, int i2) {
        this(reactApplicationContext, viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i2), eventDispatcherImpl);
    }

    public final void a(ReactShadowNode reactShadowNode, float f2, float f3, ArrayList arrayList) {
        if (reactShadowNode.e()) {
            if (reactShadowNode.P(f2, f3) && reactShadowNode.Q()) {
                int iG = reactShadowNode.G();
                ShadowNodeRegistry shadowNodeRegistry = this.f19496d;
                shadowNodeRegistry.f19473c.a();
                if (!shadowNodeRegistry.f19472b.get(iG)) {
                    arrayList.add(reactShadowNode);
                }
            }
            ArrayList arrayListF = reactShadowNode.F();
            if (arrayListF != null) {
                Iterator it = arrayListF.iterator();
                while (it.hasNext()) {
                    a((ReactShadowNode) it.next(), reactShadowNode.x() + f2, reactShadowNode.u() + f3, arrayList);
                }
            }
            UIViewOperationQueue uIViewOperationQueue = this.f19498f;
            NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = this.f19499g;
            reactShadowNode.g(f2, f3, uIViewOperationQueue, nativeViewHierarchyOptimizer);
            reactShadowNode.b();
            nativeViewHierarchyOptimizer.f19416c.clear();
        }
    }

    public final void b(ReactShadowNode reactShadowNode) {
        NativeModule nativeModuleA = this.f19497e.a(reactShadowNode.s());
        if (!(nativeModuleA instanceof IViewManagerWithChildren)) {
            throw new IllegalViewOperationException("Trying to use view " + reactShadowNode.s() + " as a parent, but its Manager doesn't extends ViewGroupManager");
        }
        if (((IViewManagerWithChildren) nativeModuleA).needsCustomLayoutForChildren()) {
            throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + reactShadowNode.s() + "). Use measure instead.");
        }
    }

    public final void c(ReactShadowNode reactShadowNode) {
        SystraceMessage.Builder builderA = SystraceMessage.a("cssRoot.calculateLayout");
        builderA.a(reactShadowNode.G(), "rootTag");
        builderA.c();
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            int iIntValue = reactShadowNode.getWidthMeasureSpec().intValue();
            int iIntValue2 = reactShadowNode.getHeightMeasureSpec().intValue();
            float size = Float.NaN;
            float size2 = View.MeasureSpec.getMode(iIntValue) == 0 ? Float.NaN : View.MeasureSpec.getSize(iIntValue);
            if (View.MeasureSpec.getMode(iIntValue2) != 0) {
                size = View.MeasureSpec.getSize(iIntValue2);
            }
            reactShadowNode.R(size2, size);
        } finally {
            Trace.endSection();
            this.f19501i = SystemClock.uptimeMillis() - jUptimeMillis;
        }
    }

    public final boolean d(int i2, String str) {
        if (this.f19496d.a(i2) != null) {
            return true;
        }
        FLog.q("ReactNative", "Unable to execute operation " + str + " on view with tag: " + i2 + ", since the view does not exist");
        return false;
    }

    public final void e(int i2) {
        SystraceMessage.Builder builderA = SystraceMessage.a("UIImplementation.dispatchViewUpdates");
        builderA.a(i2, "batchId");
        builderA.c();
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            k();
            this.f19499g.f19416c.clear();
            this.f19498f.a(jUptimeMillis, this.f19501i, i2);
        } finally {
            Trace.endSection();
        }
    }

    public final void f(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode.J()) {
            return;
        }
        ThemedReactContext themedReactContextM = reactShadowNode.M();
        NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = this.f19499g;
        nativeViewHierarchyOptimizer.getClass();
        reactShadowNode.z(reactShadowNode.s().equals(ReactViewManager.REACT_CLASS) && NativeViewHierarchyOptimizer.f(reactStylesDiffMap));
        if (reactShadowNode.N() != NativeKind.f19405c) {
            nativeViewHierarchyOptimizer.f19414a.b(themedReactContextM, reactShadowNode.G(), reactShadowNode.s(), reactStylesDiffMap);
        }
    }

    public final void g(int i2, int i3, int[] iArr) {
        int iRound;
        int iRound2;
        ShadowNodeRegistry shadowNodeRegistry = this.f19496d;
        ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(i2);
        ReactShadowNode reactShadowNodeA2 = shadowNodeRegistry.a(i3);
        if (reactShadowNodeA == null || reactShadowNodeA2 == null) {
            StringBuilder sb = new StringBuilder("Tag ");
            if (reactShadowNodeA != null) {
                i2 = i3;
            }
            throw new IllegalViewOperationException(android.support.v4.media.b.o(sb, i2, " does not exist"));
        }
        if (reactShadowNodeA != reactShadowNodeA2) {
            for (ReactShadowNodeImpl parent = reactShadowNodeA.getParent(); parent != reactShadowNodeA2; parent = parent.f19463h) {
                if (parent == null) {
                    throw new IllegalViewOperationException(android.support.v4.media.b.d(i3, i2, "Tag ", " is not an ancestor of tag "));
                }
            }
        }
        if (reactShadowNodeA == reactShadowNodeA2 || reactShadowNodeA.J()) {
            iRound = 0;
            iRound2 = 0;
        } else {
            iRound = Math.round(reactShadowNodeA.x());
            iRound2 = Math.round(reactShadowNodeA.u());
            for (ReactShadowNodeImpl parent2 = reactShadowNodeA.getParent(); parent2 != reactShadowNodeA2; parent2 = parent2.f19463h) {
                Assertions.c(parent2);
                b(parent2);
                iRound += Math.round(parent2.u.i());
                iRound2 += Math.round(parent2.u.j());
            }
            b(reactShadowNodeA2);
        }
        iArr[0] = iRound;
        iArr[1] = iRound2;
        iArr[2] = reactShadowNodeA.L();
        iArr[3] = reactShadowNodeA.B();
    }

    public final void h(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.e()) {
            for (int i2 = 0; i2 < reactShadowNode.f(); i2++) {
                h(reactShadowNode.a(i2));
            }
            reactShadowNode.S(this.f19499g);
        }
    }

    public final void i(ReactShadowNode reactShadowNode) {
        reactShadowNode.H();
        int iG = reactShadowNode.G();
        ShadowNodeRegistry shadowNodeRegistry = this.f19496d;
        shadowNodeRegistry.f19473c.a();
        if (shadowNodeRegistry.f19472b.get(iG)) {
            throw new IllegalViewOperationException(android.support.v4.media.b.g(iG, "Trying to remove root node ", " without using removeRootNode!"));
        }
        shadowNodeRegistry.f19471a.remove(iG);
        for (int iF = reactShadowNode.f() - 1; iF >= 0; iF--) {
            i(reactShadowNode.a(iF));
        }
        reactShadowNode.i();
    }

    public final ReactShadowNode j(int i2) {
        return this.f19496d.a(i2);
    }

    public final void k() {
        ShadowNodeRegistry shadowNodeRegistry = this.f19496d;
        Intrinsics.checkNotNullParameter("UIImplementation.updateViewHierarchy", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("UIImplementation.updateViewHierarchy"));
        int i2 = 0;
        while (true) {
            try {
                shadowNodeRegistry.f19473c.a();
                SparseBooleanArray sparseBooleanArray = shadowNodeRegistry.f19472b;
                if (i2 >= sparseBooleanArray.size()) {
                    return;
                }
                shadowNodeRegistry.f19473c.a();
                ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(sparseBooleanArray.keyAt(i2));
                if (reactShadowNodeA.getWidthMeasureSpec() != null && reactShadowNodeA.getHeightMeasureSpec() != null) {
                    SystraceMessage.Builder builderA = SystraceMessage.a("UIImplementation.notifyOnBeforeLayoutRecursive");
                    builderA.a(reactShadowNodeA.G(), "rootTag");
                    builderA.c();
                    try {
                        h(reactShadowNodeA);
                        Trace.endSection();
                        c(reactShadowNodeA);
                        SystraceMessage.Builder builderA2 = SystraceMessage.a("UIImplementation.applyUpdatesRecursive");
                        builderA2.a(reactShadowNodeA.G(), "rootTag");
                        builderA2.c();
                        try {
                            ArrayList arrayList = new ArrayList();
                            a(reactShadowNodeA, 0.0f, 0.0f, arrayList);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ReactShadowNode reactShadowNode = (ReactShadowNode) it.next();
                                this.f19494b.g(OnLayoutEvent.a(reactShadowNode.G(), reactShadowNode.v(), reactShadowNode.p(), reactShadowNode.L(), reactShadowNode.B()));
                            }
                            Trace.endSection();
                        } finally {
                        }
                    } finally {
                    }
                }
                i2++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue, EventDispatcher eventDispatcher) {
        this.f19493a = new Object();
        ShadowNodeRegistry shadowNodeRegistry = new ShadowNodeRegistry();
        this.f19496d = shadowNodeRegistry;
        this.f19500h = new int[4];
        this.f19501i = 0L;
        this.f19502j = true;
        this.f19495c = reactApplicationContext;
        this.f19497e = viewManagerRegistry;
        this.f19498f = uIViewOperationQueue;
        this.f19499g = new NativeViewHierarchyOptimizer(uIViewOperationQueue, shadowNodeRegistry);
        this.f19494b = eventDispatcher;
    }
}
