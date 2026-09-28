package com.facebook.react.uimanager;

import android.os.SystemClock;
import androidx.tracing.Trace;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class UIViewOperationQueue {

    /* renamed from: b, reason: collision with root package name */
    public final NativeViewHierarchyManager f19514b;

    /* renamed from: e, reason: collision with root package name */
    public final DispatchUIFrameCallback f19517e;

    /* renamed from: f, reason: collision with root package name */
    public final ReactApplicationContext f19518f;

    /* renamed from: k, reason: collision with root package name */
    public NotThreadSafeViewHierarchyUpdateDebugListener f19523k;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f19513a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final Object f19515c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final Object f19516d = new Object();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f19519g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f19520h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f19521i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public ArrayDeque f19522j = new ArrayDeque();

    /* renamed from: l, reason: collision with root package name */
    public boolean f19524l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19525m = false;
    public boolean n = false;

    /* loaded from: classes3.dex */
    public static abstract class AnimationOperation implements UIOperation {
    }

    /* loaded from: classes3.dex */
    public final class ChangeJSResponderOperation extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final int f19536b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19537c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19538d;

        public ChangeJSResponderOperation(int i2, int i3, boolean z, boolean z2) {
            super(i2);
            this.f19536b = i3;
            this.f19538d = z;
            this.f19537c = z2;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            boolean z = this.f19538d;
            UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
            if (z) {
                uIViewOperationQueue.f19514b.clearJSResponder();
                return;
            }
            uIViewOperationQueue.f19514b.setJSResponder(this.f19590a, this.f19536b, this.f19537c);
        }
    }

    /* loaded from: classes3.dex */
    public class ConfigureLayoutAnimationOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final ReadableMap f19540a;

        /* renamed from: b, reason: collision with root package name */
        public final Callback f19541b;

        public ConfigureLayoutAnimationOperation(ReadableMap readableMap, Callback callback) {
            this.f19540a = readableMap;
            this.f19541b = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            UIViewOperationQueue.this.f19514b.configureLayoutAnimation(this.f19540a, this.f19541b);
        }
    }

    public final class CreateViewOperation extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final ThemedReactContext f19543b;

        /* renamed from: c, reason: collision with root package name */
        public final String f19544c;

        /* renamed from: d, reason: collision with root package name */
        public final ReactStylesDiffMap f19545d;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i2, String str, ReactStylesDiffMap reactStylesDiffMap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super(i2);
            this.f19543b = themedReactContext;
            this.f19544c = str;
            this.f19545d = reactStylesDiffMap;
            Intrinsics.checkNotNullParameter("createView", "sectionName");
            Intrinsics.checkNotNullParameter("createView", "sectionName");
            Trace.a(i2, "createView");
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter("createView", "sectionName");
            int i2 = this.f19590a;
            Intrinsics.checkNotNullParameter("createView", "sectionName");
            Trace.c(i2, "createView");
            UIViewOperationQueue.this.f19514b.createView(this.f19543b, i2, this.f19544c, this.f19545d);
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public final class DispatchCommandOperation extends ViewOperation implements DispatchCommandViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final int f19547b;

        /* renamed from: c, reason: collision with root package name */
        public final ReadableArray f19548c;

        /* renamed from: d, reason: collision with root package name */
        public int f19549d;

        public DispatchCommandOperation(int i2, int i3, ReadableArray readableArray) {
            super(i2);
            this.f19549d = 0;
            this.f19547b = i3;
            this.f19548c = readableArray;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final int a() {
            return this.f19549d;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final void b() {
            this.f19549d++;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final void c() {
            UIViewOperationQueue.this.f19514b.dispatchCommand(this.f19590a, this.f19547b, this.f19548c);
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            try {
                UIViewOperationQueue.this.f19514b.dispatchCommand(this.f19590a, this.f19547b, this.f19548c);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface DispatchCommandViewOperation {
        int a();

        void b();

        void c();
    }

    /* loaded from: classes3.dex */
    public final class DispatchStringCommandOperation extends ViewOperation implements DispatchCommandViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final String f19551b;

        /* renamed from: c, reason: collision with root package name */
        public final ReadableArray f19552c;

        /* renamed from: d, reason: collision with root package name */
        public int f19553d;

        public DispatchStringCommandOperation(int i2, String str, ReadableArray readableArray) {
            super(i2);
            this.f19553d = 0;
            this.f19551b = str;
            this.f19552c = readableArray;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final int a() {
            return this.f19553d;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final void b() {
            this.f19553d++;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public final void c() {
            UIViewOperationQueue.this.f19514b.dispatchCommand(this.f19590a, this.f19551b, this.f19552c);
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            try {
                UIViewOperationQueue.this.f19514b.dispatchCommand(this.f19590a, this.f19551b, this.f19552c);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    public class DispatchUIFrameCallback extends GuardedFrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public final int f19555a;

        public DispatchUIFrameCallback(ReactApplicationContext reactApplicationContext, int i2) {
            super(reactApplicationContext);
            this.f19555a = i2;
        }

        public final void a(long j2) throws Exception {
            UIOperation uIOperation;
            while (16 - ((System.nanoTime() - j2) / 1000000) >= this.f19555a) {
                synchronized (UIViewOperationQueue.this.f19516d) {
                    try {
                        if (UIViewOperationQueue.this.f19522j.isEmpty()) {
                            return;
                        } else {
                            uIOperation = (UIOperation) UIViewOperationQueue.this.f19522j.pollFirst();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    uIOperation.d();
                    UIViewOperationQueue.this.o += SystemClock.uptimeMillis() - jUptimeMillis;
                } catch (Exception e2) {
                    UIViewOperationQueue.this.f19525m = true;
                    throw e2;
                }
            }
        }

        @Override // com.facebook.react.uimanager.GuardedFrameCallback
        public final void doFrameGuarded(long j2) {
            UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
            if (uIViewOperationQueue.f19525m) {
                FLog.q("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Intrinsics.checkNotNullParameter("dispatchNonBatchedUIOperations", "sectionName");
            android.os.Trace.beginSection(Trace.g("dispatchNonBatchedUIOperations"));
            try {
                a(j2);
                android.os.Trace.endSection();
                uIViewOperationQueue.d();
                ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19069b, this);
            } catch (Throwable th) {
                android.os.Trace.endSection();
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class FindTargetForTouchOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final int f19557a;

        /* renamed from: b, reason: collision with root package name */
        public final float f19558b;

        /* renamed from: c, reason: collision with root package name */
        public final float f19559c;

        /* renamed from: d, reason: collision with root package name */
        public final Callback f19560d;

        public FindTargetForTouchOperation(int i2, float f2, float f3, Callback callback) {
            this.f19557a = i2;
            this.f19558b = f2;
            this.f19559c = f3;
            this.f19560d = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            int i2 = this.f19557a;
            Callback callback = this.f19560d;
            UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
            try {
                NativeViewHierarchyManager nativeViewHierarchyManager = uIViewOperationQueue.f19514b;
                int[] iArr = uIViewOperationQueue.f19513a;
                nativeViewHierarchyManager.measure(i2, iArr);
                float f2 = iArr[0];
                float f3 = iArr[1];
                NativeViewHierarchyManager nativeViewHierarchyManager2 = uIViewOperationQueue.f19514b;
                int iFindTargetTagForTouch = nativeViewHierarchyManager2.findTargetTagForTouch(i2, this.f19558b, this.f19559c);
                try {
                    nativeViewHierarchyManager2.measure(iFindTargetTagForTouch, iArr);
                    callback.invoke(Integer.valueOf(iFindTargetTagForTouch), Float.valueOf(PixelUtil.a(iArr[0] - f2)), Float.valueOf(PixelUtil.a(iArr[1] - f3)), Float.valueOf(PixelUtil.a(iArr[2])), Float.valueOf(PixelUtil.a(iArr[3])));
                } catch (IllegalViewOperationException unused) {
                    callback.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                callback.invoke(new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class LayoutUpdateFinishedOperation implements UIOperation {
        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            throw null;
        }
    }

    public final class ManageChildrenOperation extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final int[] f19562b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewAtIndex[] f19563c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f19564d;

        public ManageChildrenOperation(int i2, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
            super(i2);
            this.f19562b = iArr;
            this.f19563c = viewAtIndexArr;
            this.f19564d = iArr2;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() throws Throwable {
            UIViewOperationQueue.this.f19514b.manageChildren(this.f19590a, this.f19562b, this.f19563c, this.f19564d);
        }
    }

    /* loaded from: classes3.dex */
    public final class MeasureInWindowOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final int f19566a;

        /* renamed from: b, reason: collision with root package name */
        public final Callback f19567b;

        public MeasureInWindowOperation(int i2, Callback callback) {
            this.f19566a = i2;
            this.f19567b = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            Callback callback = this.f19567b;
            UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
            try {
                uIViewOperationQueue.f19514b.measureInWindow(this.f19566a, uIViewOperationQueue.f19513a);
                callback.invoke(Float.valueOf(PixelUtil.a(r1[0])), Float.valueOf(PixelUtil.a(r1[1])), Float.valueOf(PixelUtil.a(r1[2])), Float.valueOf(PixelUtil.a(r1[3])));
            } catch (NoSuchNativeViewException unused) {
                callback.invoke(new Object[0]);
            }
        }
    }

    public final class MeasureOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final int f19569a;

        /* renamed from: b, reason: collision with root package name */
        public final Callback f19570b;

        public MeasureOperation(int i2, Callback callback) {
            this.f19569a = i2;
            this.f19570b = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            Callback callback = this.f19570b;
            UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
            try {
                uIViewOperationQueue.f19514b.measure(this.f19569a, uIViewOperationQueue.f19513a);
                callback.invoke(0, 0, Float.valueOf(PixelUtil.a(r1[2])), Float.valueOf(PixelUtil.a(r1[3])), Float.valueOf(PixelUtil.a(r1[0])), Float.valueOf(PixelUtil.a(r1[1])));
            } catch (NoSuchNativeViewException unused) {
                callback.invoke(new Object[0]);
            }
        }
    }

    public final class RemoveRootViewOperation extends ViewOperation {
        public RemoveRootViewOperation(int i2) {
            super(i2);
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            UIViewOperationQueue.this.f19514b.removeRootView(this.f19590a);
        }
    }

    /* loaded from: classes3.dex */
    public final class SendAccessibilityEvent extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final int f19573b;

        public SendAccessibilityEvent(int i2, int i3) {
            super(i2);
            this.f19573b = i3;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            try {
                UIViewOperationQueue.this.f19514b.sendAccessibilityEvent(this.f19590a, this.f19573b);
            } catch (RetryableMountingLayerException e2) {
                ReactSoftExceptionLogger.logSoftException("UIViewOperationQueue", e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class SetChildrenOperation extends ViewOperation {
        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            throw null;
        }
    }

    public class SetLayoutAnimationEnabledOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f19575a;

        public SetLayoutAnimationEnabledOperation(boolean z) {
            this.f19575a = z;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            UIViewOperationQueue.this.f19514b.setLayoutAnimationEnabled(this.f19575a);
        }
    }

    public class UIBlockOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final UIBlock f19577a;

        public UIBlockOperation(UIBlock uIBlock) {
            this.f19577a = uIBlock;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            this.f19577a.i(UIViewOperationQueue.this.f19514b);
        }
    }

    public interface UIOperation {
        void d();
    }

    /* loaded from: classes3.dex */
    public final class UpdateInstanceHandleOperation extends ViewOperation {
        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            throw null;
        }
    }

    public final class UpdateLayoutOperation extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final int f19579b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19580c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19581d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19582e;

        /* renamed from: f, reason: collision with root package name */
        public final int f19583f;

        /* renamed from: g, reason: collision with root package name */
        public final YogaDirection f19584g;

        public UpdateLayoutOperation(int i2, int i3, int i4, int i5, int i6, int i7, YogaDirection yogaDirection) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super(i3);
            this.f19579b = i2;
            this.f19580c = i4;
            this.f19581d = i5;
            this.f19582e = i6;
            this.f19583f = i7;
            this.f19584g = yogaDirection;
            Intrinsics.checkNotNullParameter("updateLayout", "sectionName");
            Intrinsics.checkNotNullParameter("updateLayout", "sectionName");
            Trace.a(i3, "updateLayout");
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter("updateLayout", "sectionName");
            int i2 = this.f19590a;
            Intrinsics.checkNotNullParameter("updateLayout", "sectionName");
            Trace.c(i2, "updateLayout");
            UIViewOperationQueue.this.f19514b.updateLayout(this.f19579b, this.f19590a, this.f19580c, this.f19581d, this.f19582e, this.f19583f, this.f19584g);
        }
    }

    public final class UpdatePropertiesOperation extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final ReactStylesDiffMap f19586b;

        public UpdatePropertiesOperation(int i2, ReactStylesDiffMap reactStylesDiffMap) {
            super(i2);
            this.f19586b = reactStylesDiffMap;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            UIViewOperationQueue.this.f19514b.updateProperties(this.f19590a, this.f19586b);
        }
    }

    public final class UpdateViewExtraData extends ViewOperation {

        /* renamed from: b, reason: collision with root package name */
        public final Object f19588b;

        public UpdateViewExtraData(int i2, Object obj) {
            super(i2);
            this.f19588b = obj;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public final void d() {
            UIViewOperationQueue.this.f19514b.updateViewExtraData(this.f19590a, this.f19588b);
        }
    }

    public abstract class ViewOperation implements UIOperation {

        /* renamed from: a, reason: collision with root package name */
        public final int f19590a;

        public ViewOperation(int i2) {
            this.f19590a = i2;
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i2) {
        this.f19514b = nativeViewHierarchyManager;
        this.f19517e = new DispatchUIFrameCallback(reactApplicationContext, i2 == -1 ? 8 : i2);
        this.f19518f = reactApplicationContext;
    }

    public final void a(final long j2, final long j3, final int i2) {
        final ArrayList arrayList;
        final ArrayList arrayList2;
        SystraceMessage.Builder builderA = SystraceMessage.a("UIViewOperationQueue.dispatchViewUpdates");
        builderA.a(i2, "batchId");
        builderA.c();
        try {
            final long jUptimeMillis = SystemClock.uptimeMillis();
            final long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            ArrayDeque arrayDeque = null;
            if (this.f19519g.isEmpty()) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = this.f19519g;
                this.f19519g = new ArrayList();
                arrayList = arrayList3;
            }
            if (this.f19520h.isEmpty()) {
                arrayList2 = null;
            } else {
                ArrayList arrayList4 = this.f19520h;
                this.f19520h = new ArrayList();
                arrayList2 = arrayList4;
            }
            synchronized (this.f19516d) {
                try {
                    if (!this.f19522j.isEmpty()) {
                        arrayDeque = this.f19522j;
                        this.f19522j = new ArrayDeque();
                    }
                } finally {
                }
            }
            NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener = this.f19523k;
            if (notThreadSafeViewHierarchyUpdateDebugListener != null) {
                notThreadSafeViewHierarchyUpdateDebugListener.b();
            }
            final ArrayDeque arrayDeque2 = arrayDeque;
            Runnable runnable = new Runnable() { // from class: com.facebook.react.uimanager.UIViewOperationQueue.1
                @Override // java.lang.Runnable
                public final void run() {
                    UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
                    SystraceMessage.Builder builderA2 = SystraceMessage.a("DispatchUI");
                    builderA2.a(i2, "BatchId");
                    builderA2.c();
                    try {
                        try {
                            long jUptimeMillis2 = SystemClock.uptimeMillis();
                            ArrayList arrayList5 = arrayList;
                            if (arrayList5 != null) {
                                Iterator it = arrayList5.iterator();
                                while (it.hasNext()) {
                                    DispatchCommandViewOperation dispatchCommandViewOperation = (DispatchCommandViewOperation) it.next();
                                    try {
                                        dispatchCommandViewOperation.c();
                                    } catch (RetryableMountingLayerException e2) {
                                        if (dispatchCommandViewOperation.a() == 0) {
                                            dispatchCommandViewOperation.b();
                                            uIViewOperationQueue.f19519g.add(dispatchCommandViewOperation);
                                        } else {
                                            ReactSoftExceptionLogger.logSoftException("UIViewOperationQueue", new ReactNoCrashSoftException(e2));
                                        }
                                    } catch (Throwable th) {
                                        ReactSoftExceptionLogger.logSoftException("UIViewOperationQueue", th);
                                    }
                                }
                            }
                            ArrayDeque arrayDeque3 = arrayDeque2;
                            if (arrayDeque3 != null) {
                                Iterator it2 = arrayDeque3.iterator();
                                while (it2.hasNext()) {
                                    ((UIOperation) it2.next()).d();
                                }
                            }
                            ArrayList arrayList6 = arrayList2;
                            if (arrayList6 != null) {
                                Iterator it3 = arrayList6.iterator();
                                while (it3.hasNext()) {
                                    ((UIOperation) it3.next()).d();
                                }
                            }
                            if (uIViewOperationQueue.n && uIViewOperationQueue.p == 0) {
                                uIViewOperationQueue.p = j2;
                                long jUptimeMillis3 = SystemClock.uptimeMillis();
                                uIViewOperationQueue.q = jUptimeMillis3;
                                uIViewOperationQueue.r = j3;
                                uIViewOperationQueue.s = jUptimeMillis;
                                uIViewOperationQueue.t = jUptimeMillis2;
                                uIViewOperationQueue.u = jUptimeMillis3;
                                uIViewOperationQueue.x = jCurrentThreadTimeMillis;
                                Intrinsics.checkNotNullParameter("delayBeforeDispatchViewUpdates", "sectionName");
                                Intrinsics.checkNotNullParameter("delayBeforeDispatchViewUpdates", "sectionName");
                                Trace.a(0, "delayBeforeDispatchViewUpdates");
                                Intrinsics.checkNotNullParameter("delayBeforeDispatchViewUpdates", "sectionName");
                                Intrinsics.checkNotNullParameter("delayBeforeDispatchViewUpdates", "sectionName");
                                Trace.c(0, "delayBeforeDispatchViewUpdates");
                                Intrinsics.checkNotNullParameter("delayBeforeBatchRunStart", "sectionName");
                                Intrinsics.checkNotNullParameter("delayBeforeBatchRunStart", "sectionName");
                                Trace.a(0, "delayBeforeBatchRunStart");
                                Intrinsics.checkNotNullParameter("delayBeforeBatchRunStart", "sectionName");
                                Intrinsics.checkNotNullParameter("delayBeforeBatchRunStart", "sectionName");
                                Trace.c(0, "delayBeforeBatchRunStart");
                            }
                            uIViewOperationQueue.f19514b.clearLayoutAnimation();
                            NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener2 = uIViewOperationQueue.f19523k;
                            if (notThreadSafeViewHierarchyUpdateDebugListener2 != null) {
                                notThreadSafeViewHierarchyUpdateDebugListener2.a();
                            }
                            android.os.Trace.endSection();
                        } catch (Exception e3) {
                            uIViewOperationQueue.f19525m = true;
                            throw e3;
                        }
                    } catch (Throwable th2) {
                        android.os.Trace.endSection();
                        throw th2;
                    }
                }
            };
            SystraceMessage.Builder builderA2 = SystraceMessage.a("acquiring mDispatchRunnablesLock");
            builderA2.a(i2, "batchId");
            builderA2.c();
            synchronized (this.f19515c) {
                android.os.Trace.endSection();
                this.f19521i.add(runnable);
            }
            if (!this.f19524l) {
                UiThreadUtil.runOnUiThread(new GuardedRunnable(this.f19518f) { // from class: com.facebook.react.uimanager.UIViewOperationQueue.2
                    @Override // com.facebook.react.bridge.GuardedRunnable
                    public final void runGuarded() {
                        UIViewOperationQueue.this.d();
                    }
                });
            }
            android.os.Trace.endSection();
        } catch (Throwable th) {
            android.os.Trace.endSection();
            throw th;
        }
    }

    public final void b(ThemedReactContext themedReactContext, int i2, String str, ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.f19516d) {
            this.y++;
            this.f19522j.addLast(new CreateViewOperation(themedReactContext, i2, str, reactStylesDiffMap));
        }
    }

    public final void c(int i2, Object obj) {
        this.f19520h.add(new UpdateViewExtraData(i2, obj));
    }

    public final void d() {
        if (this.f19525m) {
            FLog.q("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
            return;
        }
        synchronized (this.f19515c) {
            if (this.f19521i.isEmpty()) {
                return;
            }
            ArrayList arrayList = this.f19521i;
            this.f19521i = new ArrayList();
            long jUptimeMillis = SystemClock.uptimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            if (this.n) {
                this.v = SystemClock.uptimeMillis() - jUptimeMillis;
                this.w = this.o;
                this.n = false;
                Intrinsics.checkNotNullParameter("batchedExecutionTime", "sectionName");
                Intrinsics.checkNotNullParameter("batchedExecutionTime", "sectionName");
                Trace.a(0, "batchedExecutionTime");
                Intrinsics.checkNotNullParameter("batchedExecutionTime", "sectionName");
                Trace.c(0, "batchedExecutionTime");
            }
            this.o = 0L;
        }
    }
}
