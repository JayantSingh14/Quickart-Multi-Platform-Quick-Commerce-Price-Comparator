package com.swmansion.gesturehandler.core;

import android.R;
import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.brentvatne.common.react.r;
import com.google.android.gms.common.api.Api;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerInteractionManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRegistry;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootView;
import com.swmansion.gesturehandler.react.RNViewConfigurationHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class GestureHandlerOrchestrator {

    /* renamed from: m, reason: collision with root package name */
    public static final PointF f46732m = new PointF();
    public static final float[] n = new float[2];
    public static final Matrix o = new Matrix();
    public static final float[] p = new float[2];
    public static final com.google.firebase.crashlytics.internal.persistence.a q = new com.google.firebase.crashlytics.internal.persistence.a(1);

    /* renamed from: a, reason: collision with root package name */
    public final RNGestureHandlerRootView f46733a;

    /* renamed from: b, reason: collision with root package name */
    public final RNGestureHandlerRegistry f46734b;

    /* renamed from: c, reason: collision with root package name */
    public final RNViewConfigurationHelper f46735c;

    /* renamed from: d, reason: collision with root package name */
    public float f46736d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f46737e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f46738f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f46739g;

    /* renamed from: h, reason: collision with root package name */
    public final HashSet f46740h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46741i;

    /* renamed from: j, reason: collision with root package name */
    public int f46742j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46743k;

    /* renamed from: l, reason: collision with root package name */
    public int f46744l;

    @Metadata
    public static final class Companion {
        public static final boolean a(int i2) {
            PointF pointF = GestureHandlerOrchestrator.f46732m;
            return i2 == 3 || i2 == 1 || i2 == 5;
        }

        public static final boolean b(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            PointF pointF = GestureHandlerOrchestrator.f46732m;
            if (!gestureHandler.p(gestureHandler2) || gestureHandler == gestureHandler2 || gestureHandler.D(gestureHandler2) || gestureHandler2.D(gestureHandler)) {
                return false;
            }
            if (gestureHandler == gestureHandler2) {
                return true;
            }
            if (gestureHandler.H || gestureHandler.f46719f == 4) {
                return gestureHandler.C(gestureHandler2);
            }
            return true;
        }

        public static final boolean c(GestureHandler handler, GestureHandler otherHandler) {
            RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager;
            PointF pointF = GestureHandlerOrchestrator.f46732m;
            if (handler != otherHandler) {
                handler.getClass();
                Intrinsics.checkNotNullParameter(otherHandler, "handler");
                if (otherHandler != handler && (rNGestureHandlerInteractionManager = handler.C) != null) {
                    Intrinsics.checkNotNullParameter(handler, "handler");
                    Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
                    int[] iArr = (int[]) rNGestureHandlerInteractionManager.f46820a.get(handler.f46717d);
                    if (iArr != null) {
                        for (int i2 : iArr) {
                            if (i2 == otherHandler.f46717d) {
                                break;
                            }
                        }
                    }
                }
                if (otherHandler.E(handler)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean d(View view, float f2, float f3) {
            return 0.0f <= f2 && f2 <= ((float) view.getWidth()) && 0.0f <= f3 && f3 <= ((float) view.getHeight());
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[PointerEventsConfig.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PointerEventsConfig pointerEventsConfig = PointerEventsConfig.f46753a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PointerEventsConfig pointerEventsConfig2 = PointerEventsConfig.f46753a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PointerEventsConfig pointerEventsConfig3 = PointerEventsConfig.f46753a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public GestureHandlerOrchestrator(RNGestureHandlerRootView wrapperView, RNGestureHandlerRegistry handlerRegistry, RNViewConfigurationHelper viewConfigHelper) {
        Intrinsics.checkNotNullParameter(wrapperView, "wrapperView");
        Intrinsics.checkNotNullParameter(handlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigHelper, "viewConfigHelper");
        this.f46733a = wrapperView;
        this.f46734b = handlerRegistry;
        this.f46735c = viewConfigHelper;
        this.f46737e = new ArrayList();
        this.f46738f = new ArrayList();
        this.f46739g = new ArrayList();
        this.f46740h = new HashSet();
    }

    public final void a() {
        ArrayList arrayList = this.f46738f;
        for (GestureHandler gestureHandler : CollectionsKt.e0(arrayList)) {
            if (!gestureHandler.H) {
                arrayList.remove(gestureHandler);
                this.f46740h.remove(Integer.valueOf(gestureHandler.f46717d));
            }
        }
    }

    public final void b() {
        ArrayList arrayList = this.f46737e;
        for (GestureHandler gestureHandler : CollectionsKt.m(arrayList)) {
            if (Companion.a(gestureHandler.f46719f) && !gestureHandler.H) {
                gestureHandler.f46718e = null;
                gestureHandler.A = null;
                Arrays.fill(gestureHandler.f46714a, -1);
                gestureHandler.f46715b = 0;
                gestureHandler.o = 0;
                GestureHandler.PointerData[] pointerDataArr = gestureHandler.p;
                ArraysKt.q(pointerDataArr, null, 0, pointerDataArr.length);
                gestureHandler.n = 0;
                gestureHandler.w();
                gestureHandler.G = false;
                gestureHandler.H = false;
                gestureHandler.F = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
        }
        CollectionsKt.N(arrayList, new r(11));
        this.f46743k = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.ViewGroup r10, float[] r11, int r12, android.view.MotionEvent r13) {
        /*
            r9 = this;
            int r0 = r10.getChildCount()
            r1 = 1
            int r0 = r0 - r1
        L6:
            r2 = 0
            r3 = -1
            if (r3 >= r0) goto Ld0
            com.swmansion.gesturehandler.react.RNViewConfigurationHelper r3 = r9.f46735c
            android.view.View r3 = r3.a(r10, r0)
            int r4 = r3.getVisibility()
            if (r4 != 0) goto Lcc
            float r4 = r3.getAlpha()
            float r5 = r9.f46736d
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto Lcc
            android.graphics.PointF r4 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.f46732m
            r5 = r11[r2]
            r6 = r11[r1]
            int r7 = r10.getScrollX()
            float r7 = (float) r7
            float r5 = r5 + r7
            int r7 = r3.getLeft()
            float r7 = (float) r7
            float r5 = r5 - r7
            int r7 = r10.getScrollY()
            float r7 = (float) r7
            float r6 = r6 + r7
            int r7 = r3.getTop()
            float r7 = (float) r7
            float r6 = r6 - r7
            android.graphics.Matrix r7 = r3.getMatrix()
            boolean r8 = r7.isIdentity()
            if (r8 != 0) goto L5a
            float[] r8 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.n
            r8[r2] = r5
            r8[r1] = r6
            android.graphics.Matrix r5 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.o
            r7.invert(r5)
            r5.mapPoints(r8)
            r5 = r8[r2]
            r6 = r8[r1]
        L5a:
            r4.set(r5, r6)
            r5 = r11[r2]
            r6 = r11[r1]
            float r7 = r4.x
            r11[r2] = r7
            float r4 = r4.y
            r11[r1] = r4
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto Lb5
            r4 = r3
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            java.lang.String r7 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            boolean r7 = r4.getClipChildren()
            if (r7 == 0) goto L7c
            goto L9f
        L7c:
            boolean r7 = r4 instanceof com.facebook.react.views.scroll.ReactScrollView
            java.lang.String r8 = "visible"
            if (r7 == 0) goto L8f
            com.facebook.react.views.scroll.ReactScrollView r4 = (com.facebook.react.views.scroll.ReactScrollView) r4
            java.lang.String r4 = r4.getOverflow()
            boolean r4 = kotlin.jvm.internal.Intrinsics.b(r4, r8)
            if (r4 != 0) goto Lb2
            goto L9f
        L8f:
            boolean r7 = r4 instanceof com.facebook.react.views.scroll.ReactHorizontalScrollView
            if (r7 == 0) goto La1
            com.facebook.react.views.scroll.ReactHorizontalScrollView r4 = (com.facebook.react.views.scroll.ReactHorizontalScrollView) r4
            java.lang.String r4 = r4.getOverflow()
            boolean r4 = kotlin.jvm.internal.Intrinsics.b(r4, r8)
            if (r4 != 0) goto Lb2
        L9f:
            r4 = r1
            goto Lb3
        La1:
            boolean r7 = r4 instanceof com.facebook.react.views.view.ReactViewGroup
            if (r7 == 0) goto Lb2
            com.facebook.react.views.view.ReactViewGroup r4 = (com.facebook.react.views.view.ReactViewGroup) r4
            java.lang.String r4 = r4.getOverflow()
            java.lang.String r7 = "hidden"
            boolean r4 = kotlin.jvm.internal.Intrinsics.b(r4, r7)
            goto Lb3
        Lb2:
            r4 = r2
        Lb3:
            if (r4 == 0) goto Lbf
        Lb5:
            r4 = r11[r2]
            r7 = r11[r1]
            boolean r4 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.Companion.d(r3, r4, r7)
            if (r4 == 0) goto Lc4
        Lbf:
            boolean r3 = r9.h(r3, r11, r12, r13)
            goto Lc5
        Lc4:
            r3 = r2
        Lc5:
            r11[r2] = r5
            r11[r1] = r6
            if (r3 == 0) goto Lcc
            return r1
        Lcc:
            int r0 = r0 + (-1)
            goto L6
        Ld0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.c(android.view.ViewGroup, float[], int, android.view.MotionEvent):boolean");
    }

    public final void d(GestureHandler gestureHandler, View view) {
        ArrayList arrayList = this.f46737e;
        if (arrayList.contains(gestureHandler)) {
            return;
        }
        arrayList.add(gestureHandler);
        gestureHandler.G = false;
        gestureHandler.H = false;
        gestureHandler.F = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (gestureHandler.f46718e != null || gestureHandler.A != null) {
            throw new IllegalStateException("Already prepared or hasn't been reset");
        }
        Arrays.fill(gestureHandler.f46714a, -1);
        gestureHandler.f46715b = 0;
        gestureHandler.f46719f = 0;
        gestureHandler.f46718e = view;
        gestureHandler.A = this;
        Activity activityM = GestureHandler.m(view.getContext());
        View viewFindViewById = activityM != null ? activityM.findViewById(R.id.content) : null;
        int[] iArr = gestureHandler.f46716c;
        if (viewFindViewById != null) {
            viewFindViewById.getLocationOnScreen(iArr);
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        gestureHandler.v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v11, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    public final boolean e(View view, float[] fArr, int i2, MotionEvent motionEvent) {
        boolean z;
        ArrayList arrayListE = this.f46734b.e(view);
        if (arrayListE != null) {
            synchronized (arrayListE) {
                try {
                    Iterator it = arrayListE.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    z = false;
                    while (it.hasNext()) {
                        GestureHandler gestureHandler = (GestureHandler) it.next();
                        if (gestureHandler.f46723j && gestureHandler.q(view, fArr[0], fArr[1]) && (!CollectionsKt.I(10, 9, 7).contains(Integer.valueOf(motionEvent.getAction())) || (gestureHandler instanceof HoverGestureHandler))) {
                            d(gestureHandler, view);
                            gestureHandler.F(i2);
                            z = true;
                        }
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            z = false;
        }
        float width = view.getWidth();
        float f2 = fArr[0];
        if (0.0f <= f2 && f2 <= width) {
            float height = view.getHeight();
            float f3 = fArr[1];
            if (0.0f <= f3 && f3 <= height) {
                ViewParent parent = view.getParent();
                if ((parent instanceof ViewGroup ? (ViewGroup) parent : null) != null) {
                    Matrix matrix = view.getMatrix();
                    float[] fArr2 = n;
                    fArr2[0] = 0.0f;
                    fArr2[1] = 0.0f;
                    matrix.mapPoints(fArr2);
                    float left = fArr2[0] + view.getLeft();
                    float top = fArr2[1] + view.getTop();
                    if (left < 0.0f || left + view.getWidth() > r14.getWidth() || top < 0.0f || top + view.getHeight() > r14.getHeight()) {
                        boolean z2 = false;
                        for (ViewGroup parent2 = view.getParent(); parent2 != 0; parent2 = parent2.getParent()) {
                            if (parent2 instanceof ViewGroup) {
                                ViewGroup viewGroup = parent2;
                                ArrayList arrayListE2 = this.f46734b.e(parent2);
                                if (arrayListE2 != null) {
                                    synchronized (arrayListE2) {
                                        try {
                                            Iterator it2 = arrayListE2.iterator();
                                            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                            while (it2.hasNext()) {
                                                GestureHandler gestureHandler2 = (GestureHandler) it2.next();
                                                if (gestureHandler2.f46723j && gestureHandler2.q(view, fArr[0], fArr[1])) {
                                                    d(gestureHandler2, viewGroup);
                                                    gestureHandler2.F(i2);
                                                    z2 = true;
                                                }
                                            }
                                            Unit unit2 = Unit.f53572a;
                                        } finally {
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (z2) {
                            return true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public final void f(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.b(viewGroup, this.f46733a)) {
            f(viewGroup, event);
        }
        if (viewGroup != null) {
            event.setLocation((event.getX() + viewGroup.getScrollX()) - view.getLeft(), (event.getY() + viewGroup.getScrollY()) - view.getTop());
        }
        if (view.getMatrix().isIdentity()) {
            return;
        }
        Matrix matrix = view.getMatrix();
        Matrix matrix2 = o;
        matrix.invert(matrix2);
        event.transform(matrix2);
    }

    public final void g(View view, PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.b(viewGroup, this.f46733a)) {
            g(viewGroup, point);
        }
        if (viewGroup != null) {
            point.x += viewGroup.getScrollX() - view.getLeft();
            point.y += viewGroup.getScrollY() - view.getTop();
        }
        if (view.getMatrix().isIdentity()) {
            return;
        }
        Matrix matrix = view.getMatrix();
        Matrix matrix2 = o;
        matrix.invert(matrix2);
        float f2 = point.x;
        float[] fArr = p;
        fArr[0] = f2;
        fArr[1] = point.y;
        matrix2.mapPoints(fArr);
        point.x = fArr[0];
        point.y = fArr[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.view.View r6, float[] r7, int r8, android.view.MotionEvent r9) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof com.facebook.react.uimanager.ReactPointerEventsView
            if (r0 == 0) goto L11
            r0 = r6
            com.facebook.react.uimanager.ReactPointerEventsView r0 = (com.facebook.react.uimanager.ReactPointerEventsView) r0
            com.facebook.react.uimanager.PointerEvents r0 = r0.getPointerEvents()
            goto L13
        L11:
            com.facebook.react.uimanager.PointerEvents r0 = com.facebook.react.uimanager.PointerEvents.f19428e
        L13:
            boolean r1 = r6.isEnabled()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 != 0) goto L2a
            com.facebook.react.uimanager.PointerEvents r1 = com.facebook.react.uimanager.PointerEvents.f19428e
            if (r0 != r1) goto L23
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46754b
            goto L47
        L23:
            com.facebook.react.uimanager.PointerEvents r1 = com.facebook.react.uimanager.PointerEvents.f19427d
            if (r0 != r1) goto L2a
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46753a
            goto L47
        L2a:
            int r0 = r0.ordinal()
            if (r0 == 0) goto L45
            if (r0 == r4) goto L42
            if (r0 == r3) goto L3f
            if (r0 != r2) goto L39
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46756d
            goto L47
        L39:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L3f:
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46755c
            goto L47
        L42:
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46754b
            goto L47
        L45:
            com.swmansion.gesturehandler.core.PointerEventsConfig r0 = com.swmansion.gesturehandler.core.PointerEventsConfig.f46753a
        L47:
            int r0 = r0.ordinal()
            r1 = 0
            if (r0 == 0) goto Lb7
            if (r0 == r4) goto L9d
            if (r0 == r3) goto L82
            if (r0 != r2) goto L7c
            boolean r0 = r6 instanceof android.view.ViewGroup
            if (r0 == 0) goto L60
            r2 = r6
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            boolean r2 = r5.c(r2, r7, r8, r9)
            goto L61
        L60:
            r2 = r1
        L61:
            boolean r8 = r5.e(r6, r7, r8, r9)
            if (r8 != 0) goto L9c
            if (r2 != 0) goto L9c
            if (r0 == 0) goto L71
            android.graphics.drawable.Drawable r8 = r6.getBackground()
            if (r8 == 0) goto Lb7
        L71:
            r8 = r7[r1]
            r7 = r7[r4]
            boolean r6 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.Companion.d(r6, r8, r7)
            if (r6 == 0) goto Lb7
            goto L9c
        L7c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L82:
            boolean r8 = r5.e(r6, r7, r8, r9)
            if (r8 != 0) goto L9c
            boolean r8 = r6 instanceof android.view.ViewGroup
            if (r8 == 0) goto L92
            android.graphics.drawable.Drawable r8 = r6.getBackground()
            if (r8 == 0) goto Lb7
        L92:
            r8 = r7[r1]
            r7 = r7[r4]
            boolean r6 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.Companion.d(r6, r8, r7)
            if (r6 == 0) goto Lb7
        L9c:
            return r4
        L9d:
            boolean r0 = r6 instanceof android.view.ViewGroup
            if (r0 == 0) goto Lae
            r0 = r6
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            boolean r0 = r5.c(r0, r7, r8, r9)
            if (r0 == 0) goto Lad
            r5.e(r6, r7, r8, r9)
        Lad:
            return r0
        Lae:
            boolean r0 = r6 instanceof android.widget.EditText
            if (r0 == 0) goto Lb7
            boolean r6 = r5.e(r6, r7, r8, r9)
            return r6
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.h(android.view.View, float[], int, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0072, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(com.swmansion.gesturehandler.core.GestureHandler r10) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.i(com.swmansion.gesturehandler.core.GestureHandler):void");
    }
}
