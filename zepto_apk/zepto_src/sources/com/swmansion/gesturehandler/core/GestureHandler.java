package com.swmansion.gesturehandler.core;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.react.RNGestureHandlerInteractionManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class GestureHandler<ConcreteGestureHandlerT extends GestureHandler<ConcreteGestureHandlerT>> {
    public static MotionEvent.PointerProperties[] J;
    public static MotionEvent.PointerCoords[] K;
    public static short L;
    public GestureHandlerOrchestrator A;
    public OnTouchEventListener B;
    public RNGestureHandlerInteractionManager C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f46714a = new int[12];

    /* renamed from: b, reason: collision with root package name */
    public int f46715b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f46716c;

    /* renamed from: d, reason: collision with root package name */
    public int f46717d;

    /* renamed from: e, reason: collision with root package name */
    public View f46718e;

    /* renamed from: f, reason: collision with root package name */
    public int f46719f;

    /* renamed from: g, reason: collision with root package name */
    public float f46720g;

    /* renamed from: h, reason: collision with root package name */
    public float f46721h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46722i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f46723j;

    /* renamed from: k, reason: collision with root package name */
    public int f46724k;

    /* renamed from: l, reason: collision with root package name */
    public WritableArray f46725l;

    /* renamed from: m, reason: collision with root package name */
    public WritableArray f46726m;
    public int n;
    public int o;
    public final PointerData[] p;
    public boolean q;
    public float[] r;
    public short s;
    public float t;
    public float u;
    public boolean v;
    public float w;
    public float x;
    public boolean y;
    public int z;

    @Metadata
    public static final class AdaptEventException extends Exception {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class PointerData {

        /* renamed from: a, reason: collision with root package name */
        public final int f46727a;

        /* renamed from: b, reason: collision with root package name */
        public float f46728b;

        /* renamed from: c, reason: collision with root package name */
        public float f46729c;

        /* renamed from: d, reason: collision with root package name */
        public float f46730d;

        /* renamed from: e, reason: collision with root package name */
        public float f46731e;

        public PointerData(float f2, float f3, float f4, float f5, int i2) {
            this.f46727a = i2;
            this.f46728b = f2;
            this.f46729c = f3;
            this.f46730d = f4;
            this.f46731e = f5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PointerData)) {
                return false;
            }
            PointerData pointerData = (PointerData) obj;
            return this.f46727a == pointerData.f46727a && Float.compare(this.f46728b, pointerData.f46728b) == 0 && Float.compare(this.f46729c, pointerData.f46729c) == 0 && Float.compare(this.f46730d, pointerData.f46730d) == 0 && Float.compare(this.f46731e, pointerData.f46731e) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.f46731e) + ((Float.hashCode(this.f46730d) + ((Float.hashCode(this.f46729c) + ((Float.hashCode(this.f46728b) + (Integer.hashCode(this.f46727a) * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "PointerData(pointerId=" + this.f46727a + ", x=" + this.f46728b + ", y=" + this.f46729c + ", absoluteX=" + this.f46730d + ", absoluteY=" + this.f46731e + ")";
        }
    }

    public GestureHandler() {
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr[i2] = 0;
        }
        this.f46716c = iArr;
        this.f46723j = true;
        PointerData[] pointerDataArr = new PointerData[12];
        for (int i3 = 0; i3 < 12; i3++) {
            pointerDataArr[i3] = null;
        }
        this.p = pointerDataArr;
        this.D = 3;
    }

    public static WritableMap f(PointerData pointerData) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, pointerData.f46727a);
        writableMapCreateMap.putDouble("x", PixelUtil.a(pointerData.f46728b));
        writableMapCreateMap.putDouble("y", PixelUtil.a(pointerData.f46729c));
        writableMapCreateMap.putDouble("absoluteX", PixelUtil.a(pointerData.f46730d));
        writableMapCreateMap.putDouble("absoluteY", PixelUtil.a(pointerData.f46731e));
        return writableMapCreateMap;
    }

    public static Activity m(Context context) {
        if (context instanceof ReactContext) {
            return ((ReactContext) context).getCurrentActivity();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final void A(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (this.r == null) {
            this.r = new float[6];
        }
        float[] fArr = this.r;
        Intrinsics.c(fArr);
        fArr[0] = f2;
        float[] fArr2 = this.r;
        Intrinsics.c(fArr2);
        fArr2[1] = f3;
        float[] fArr3 = this.r;
        Intrinsics.c(fArr3);
        fArr3[2] = f4;
        float[] fArr4 = this.r;
        Intrinsics.c(fArr4);
        fArr4[3] = f5;
        float[] fArr5 = this.r;
        Intrinsics.c(fArr5);
        fArr5[4] = f6;
        float[] fArr6 = this.r;
        Intrinsics.c(fArr6);
        fArr6[5] = f7;
        if (!Float.isNaN(f6) && !Float.isNaN(f2) && !Float.isNaN(f4)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined");
        }
        if (!Float.isNaN(f6) && Float.isNaN(f2) && Float.isNaN(f4)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
        }
        if (!Float.isNaN(f7) && !Float.isNaN(f5) && !Float.isNaN(f3)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
        }
        if (!Float.isNaN(f7) && Float.isNaN(f5) && Float.isNaN(f3)) {
            throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
        }
    }

    public final boolean B(MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (sourceEvent.getToolType(0) == 3) {
            if (sourceEvent.getAction() != 0 && sourceEvent.getAction() != 1 && sourceEvent.getAction() != 6 && sourceEvent.getAction() != 5) {
                if (sourceEvent.getAction() != 2) {
                    int actionButton = sourceEvent.getActionButton();
                    int i2 = this.E;
                    if (i2 != 0 ? (actionButton & i2) != 0 : actionButton == 1) {
                    }
                }
                if (sourceEvent.getAction() == 2) {
                    int buttonState = sourceEvent.getButtonState();
                    int i3 = this.E;
                    if (i3 != 0 ? (buttonState & i3) == 0 : buttonState != 1) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean C(GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(otherHandler, "handler");
        if (otherHandler != this && this.C != null) {
            Intrinsics.checkNotNullParameter(this, "handler");
            Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
            if (otherHandler instanceof NativeViewGestureHandler) {
                return ((NativeViewGestureHandler) otherHandler).N;
            }
            if (otherHandler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler) {
                return true;
            }
        }
        return false;
    }

    public boolean D(GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(otherHandler, "handler");
        if (otherHandler == this) {
            return true;
        }
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.C;
        if (rNGestureHandlerInteractionManager != null) {
            Intrinsics.checkNotNullParameter(this, "handler");
            Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
            int[] iArr = (int[]) rNGestureHandlerInteractionManager.f46821b.get(this.f46717d);
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (i2 == otherHandler.f46717d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean E(GestureHandler otherHandler) {
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager;
        Intrinsics.checkNotNullParameter(otherHandler, "handler");
        if (otherHandler != this && (rNGestureHandlerInteractionManager = this.C) != null) {
            Intrinsics.checkNotNullParameter(this, "handler");
            Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
            int[] iArr = (int[]) rNGestureHandlerInteractionManager.f46822c.get(this.f46717d);
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (i2 == otherHandler.f46717d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void F(int i2) {
        int[] iArr = this.f46714a;
        if (iArr[i2] == -1) {
            int i3 = 0;
            while (i3 < this.f46715b) {
                int i4 = 0;
                while (i4 < iArr.length && iArr[i4] != i3) {
                    i4++;
                }
                if (i4 == iArr.length) {
                    break;
                } else {
                    i3++;
                }
            }
            iArr[i2] = i3;
            this.f46715b++;
        }
    }

    public final void G(MotionEvent event, MotionEvent sourceEvent) {
        OnTouchEventListener onTouchEventListener;
        OnTouchEventListener onTouchEventListener2;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        int actionMasked = event.getActionMasked();
        PointerData[] pointerDataArr = this.p;
        int[] iArr = this.f46716c;
        if (actionMasked == 0 || event.getActionMasked() == 5) {
            this.f46725l = null;
            this.n = 1;
            int pointerId = event.getPointerId(event.getActionIndex());
            PointerData pointerData = new PointerData(event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), (sourceEvent.getX(event.getActionIndex()) + (sourceEvent.getRawX() - sourceEvent.getX())) - iArr[0], (sourceEvent.getY(event.getActionIndex()) + (sourceEvent.getRawY() - sourceEvent.getY())) - iArr[1], pointerId);
            pointerDataArr[pointerId] = pointerData;
            this.o++;
            c(pointerData);
            k();
            if (this.f46725l != null && (onTouchEventListener = this.B) != null) {
                onTouchEventListener.b(this);
            }
            i(event, sourceEvent);
            return;
        }
        if (event.getActionMasked() != 1 && event.getActionMasked() != 6) {
            if (event.getActionMasked() == 2) {
                i(event, sourceEvent);
                return;
            }
            return;
        }
        i(event, sourceEvent);
        k();
        this.f46725l = null;
        this.n = 3;
        int pointerId2 = event.getPointerId(event.getActionIndex());
        PointerData pointerData2 = new PointerData(event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), (sourceEvent.getX(event.getActionIndex()) + (sourceEvent.getRawX() - sourceEvent.getX())) - iArr[0], (sourceEvent.getY(event.getActionIndex()) + (sourceEvent.getRawY() - sourceEvent.getY())) - iArr[1], pointerId2);
        pointerDataArr[pointerId2] = pointerData2;
        c(pointerData2);
        pointerDataArr[pointerId2] = null;
        this.o--;
        if (this.f46725l == null || (onTouchEventListener2 = this.B) == null) {
            return;
        }
        onTouchEventListener2.b(this);
    }

    public void a(boolean z) {
        if (!this.v || z) {
            int i2 = this.f46719f;
            if (i2 == 0 || i2 == 2) {
                r(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.MotionEvent b(android.view.MotionEvent r30) throws com.swmansion.gesturehandler.core.GestureHandler.AdaptEventException {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.b(android.view.MotionEvent):android.view.MotionEvent");
    }

    public final void c(PointerData pointerData) {
        if (this.f46725l == null) {
            this.f46725l = Arguments.createArray();
        }
        WritableArray writableArray = this.f46725l;
        Intrinsics.c(writableArray);
        writableArray.pushMap(f(pointerData));
    }

    public final void d() {
        if (this.f46719f == 0) {
            r(2);
        }
    }

    public final void e() {
        int i2 = this.f46719f;
        if (i2 == 4 || i2 == 0 || i2 == 2 || this.H) {
            s();
            r(3);
        }
    }

    public void g(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnTouchEventListener onTouchEventListener = this.B;
        if (onTouchEventListener != null) {
            onTouchEventListener.c(this, event);
        }
    }

    public void h(int i2, int i3) {
        OnTouchEventListener onTouchEventListener = this.B;
        if (onTouchEventListener != null) {
            onTouchEventListener.a(this, i2, i3);
        }
    }

    public final void i(MotionEvent motionEvent, MotionEvent motionEvent2) {
        OnTouchEventListener onTouchEventListener;
        this.f46725l = null;
        this.n = 2;
        float rawX = motionEvent2.getRawX() - motionEvent2.getX();
        float rawY = motionEvent2.getRawY() - motionEvent2.getY();
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            PointerData pointerData = this.p[motionEvent.getPointerId(i3)];
            if (pointerData != null && (pointerData.f46728b != motionEvent.getX(i3) || pointerData.f46729c != motionEvent.getY(i3))) {
                pointerData.f46728b = motionEvent.getX(i3);
                pointerData.f46729c = motionEvent.getY(i3);
                float x = motionEvent2.getX(i3) + rawX;
                int[] iArr = this.f46716c;
                pointerData.f46730d = x - iArr[0];
                pointerData.f46731e = (motionEvent2.getY(i3) + rawY) - iArr[1];
                c(pointerData);
                i2++;
            }
        }
        if (i2 > 0) {
            k();
            if (this.f46725l == null || (onTouchEventListener = this.B) == null) {
                return;
            }
            onTouchEventListener.b(this);
        }
    }

    public final void j() {
        int i2 = this.f46719f;
        if (i2 == 2 || i2 == 4) {
            r(5);
        }
    }

    public final void k() {
        this.f46726m = null;
        for (PointerData pointerData : this.p) {
            if (pointerData != null) {
                if (this.f46726m == null) {
                    this.f46726m = Arguments.createArray();
                }
                WritableArray writableArray = this.f46726m;
                Intrinsics.c(writableArray);
                writableArray.pushMap(f(pointerData));
            }
        }
    }

    public final void l() {
        int i2 = this.f46719f;
        if (i2 == 4 || i2 == 0 || i2 == 2) {
            r(1);
        }
    }

    public final float n() {
        return (this.t + this.w) - this.f46716c[0];
    }

    public final float o() {
        return (this.u + this.x) - this.f46716c[1];
    }

    public final boolean p(GestureHandler other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int[] iArr = this.f46714a;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArr[i2] != -1 && other.f46714a[i2] != -1) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(View view, float f2, float f3) {
        float f4;
        Intrinsics.c(view);
        float width = view.getWidth();
        float height = view.getHeight();
        float[] fArr = this.r;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            float f9 = !Float.isNaN(f5) ? 0.0f - f5 : 0.0f;
            f = Float.isNaN(f6) ? 0.0f : 0.0f - f6;
            if (!Float.isNaN(f7)) {
                width += f7;
            }
            if (!Float.isNaN(f8)) {
                height += f8;
            }
            float f10 = fArr[4];
            float f11 = fArr[5];
            if (!Float.isNaN(f10)) {
                if (Float.isNaN(f5)) {
                    f9 = width - f10;
                } else if (Float.isNaN(f7)) {
                    width = f10 + f9;
                }
            }
            if (!Float.isNaN(f11)) {
                if (Float.isNaN(f6)) {
                    f = height - f11;
                } else if (Float.isNaN(f8)) {
                    height = f11 + f;
                }
            }
            f4 = f;
            f = f9;
        } else {
            f4 = 0.0f;
        }
        return f <= f2 && f2 <= width && f4 <= f3 && f3 <= height;
    }

    public final void r(int i2) {
        OnTouchEventListener onTouchEventListener;
        UiThreadUtil.assertOnUiThread();
        if (this.f46719f == i2) {
            return;
        }
        if (this.o > 0 && (i2 == 5 || i2 == 3 || i2 == 1)) {
            this.n = 4;
            this.f46725l = null;
            k();
            PointerData[] pointerDataArr = this.p;
            for (PointerData pointerData : pointerDataArr) {
                if (pointerData != null) {
                    c(pointerData);
                }
            }
            this.o = 0;
            ArraysKt.q(pointerDataArr, null, 0, pointerDataArr.length);
            if (this.f46725l != null && (onTouchEventListener = this.B) != null) {
                onTouchEventListener.b(this);
            }
        }
        int i3 = this.f46719f;
        this.f46719f = i2;
        if (i2 == 4) {
            short s = L;
            L = (short) (s + 1);
            this.s = s;
        }
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.A;
        Intrinsics.c(gestureHandlerOrchestrator);
        Intrinsics.checkNotNullParameter(this, "handler");
        gestureHandlerOrchestrator.f46742j++;
        PointF pointF = GestureHandlerOrchestrator.f46732m;
        if (GestureHandlerOrchestrator.Companion.a(i2)) {
            for (GestureHandler gestureHandler : CollectionsKt.e0(gestureHandlerOrchestrator.f46738f)) {
                if (GestureHandlerOrchestrator.Companion.c(gestureHandler, this) && gestureHandlerOrchestrator.f46740h.contains(Integer.valueOf(gestureHandler.f46717d))) {
                    if (i2 == 5) {
                        gestureHandler.e();
                        if (gestureHandler.f46719f == 5) {
                            gestureHandler.h(3, 2);
                        }
                        gestureHandler.H = false;
                    } else {
                        gestureHandlerOrchestrator.i(gestureHandler);
                    }
                }
            }
            gestureHandlerOrchestrator.a();
        }
        if (i2 == 4) {
            gestureHandlerOrchestrator.i(this);
        } else if (i3 == 4 || i3 == 5) {
            if (this.G) {
                h(i2, i3);
            } else if (i3 == 4 && (i2 == 3 || i2 == 1)) {
                h(i2, 2);
            }
        } else if (i3 != 0 || i2 != 3) {
            h(i2, i3);
        }
        int i4 = gestureHandlerOrchestrator.f46742j - 1;
        gestureHandlerOrchestrator.f46742j = i4;
        if (gestureHandlerOrchestrator.f46741i || i4 != 0) {
            gestureHandlerOrchestrator.f46743k = true;
        } else {
            gestureHandlerOrchestrator.b();
        }
        x();
    }

    public void s() {
    }

    public void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        r(1);
    }

    public final String toString() {
        String simpleName;
        View view = this.f46718e;
        if (view == null) {
            simpleName = null;
        } else {
            Intrinsics.c(view);
            simpleName = view.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "@[" + this.f46717d + "]:" + simpleName;
    }

    public void u(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
    }

    public void v() {
    }

    public void w() {
    }

    public void y() {
        this.q = false;
        this.v = false;
        this.y = false;
        this.f46723j = true;
        this.r = null;
    }

    public void z() {
    }

    public void x() {
    }
}
