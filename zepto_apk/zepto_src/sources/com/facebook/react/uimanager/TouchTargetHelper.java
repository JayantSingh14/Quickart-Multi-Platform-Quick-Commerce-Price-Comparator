package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import java.util.ArrayList;
import java.util.EnumSet;

/* loaded from: classes3.dex */
public class TouchTargetHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f19482a = new float[2];

    /* renamed from: b, reason: collision with root package name */
    public static final PointF f19483b = new PointF();

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f19484c = new float[2];

    /* renamed from: d, reason: collision with root package name */
    public static final Matrix f19485d = new Matrix();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TouchTargetReturnType {

        /* renamed from: a, reason: collision with root package name */
        public static final TouchTargetReturnType f19486a;

        /* renamed from: b, reason: collision with root package name */
        public static final TouchTargetReturnType f19487b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ TouchTargetReturnType[] f19488c;

        static {
            TouchTargetReturnType touchTargetReturnType = new TouchTargetReturnType("SELF", 0);
            f19486a = touchTargetReturnType;
            TouchTargetReturnType touchTargetReturnType2 = new TouchTargetReturnType("CHILD", 1);
            f19487b = touchTargetReturnType2;
            f19488c = new TouchTargetReturnType[]{touchTargetReturnType, touchTargetReturnType2};
        }

        public static TouchTargetReturnType valueOf(String str) {
            return (TouchTargetReturnType) Enum.valueOf(TouchTargetReturnType.class, str);
        }

        public static TouchTargetReturnType[] values() {
            return (TouchTargetReturnType[]) f19488c.clone();
        }
    }

    public static class ViewTarget {

        /* renamed from: a, reason: collision with root package name */
        public final int f19489a;

        /* renamed from: b, reason: collision with root package name */
        public final View f19490b;

        public ViewTarget(int i2, View view) {
            this.f19489a = i2;
            this.f19490b = view;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof ViewTarget) && ((ViewTarget) obj).f19489a == this.f19489a;
        }

        public final int hashCode() {
            return Integer.valueOf(this.f19489a).hashCode();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(float f2, float f3, ViewGroup viewGroup, float[] fArr) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f2;
        fArr[1] = f3;
        View viewD = d(fArr, viewGroup, null);
        View view = viewD;
        if (viewD != null) {
            while (view != 0 && view.getId() <= 0) {
                view = (View) view.getParent();
            }
            if (view != 0) {
                return view instanceof ReactCompoundView ? ((ReactCompoundView) view).reactTagForTouch(fArr[0], fArr[1]) : view.getId();
            }
        }
        return id;
    }

    public static int b(float f2, float f3, ViewGroup viewGroup) {
        return a(f2, f3, viewGroup, f19482a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
    
        if (r0.getClipChildren() != false) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.View c(float[] r12, android.view.View r13, java.util.EnumSet r14, java.util.ArrayList r15) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.TouchTargetHelper.c(float[], android.view.View, java.util.EnumSet, java.util.ArrayList):android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View d(float[] fArr, View view, ArrayList arrayList) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.f19428e;
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.f19428e) {
                pointerEvents = PointerEvents.f19426c;
            } else if (pointerEvents == PointerEvents.f19427d) {
                pointerEvents = PointerEvents.f19425b;
            }
        }
        if (pointerEvents == PointerEvents.f19425b) {
            return null;
        }
        PointerEvents pointerEvents2 = PointerEvents.f19427d;
        TouchTargetReturnType touchTargetReturnType = TouchTargetReturnType.f19486a;
        if (pointerEvents == pointerEvents2) {
            View viewC = c(fArr, view, EnumSet.of(touchTargetReturnType), arrayList);
            if (viewC != null && arrayList != null) {
                arrayList.add(new ViewTarget(view.getId(), view));
            }
            return viewC;
        }
        PointerEvents pointerEvents3 = PointerEvents.f19426c;
        TouchTargetReturnType touchTargetReturnType2 = TouchTargetReturnType.f19487b;
        if (pointerEvents == pointerEvents3) {
            View viewC2 = c(fArr, view, EnumSet.of(touchTargetReturnType2), arrayList);
            if (viewC2 != null) {
                if (arrayList != null) {
                    arrayList.add(new ViewTarget(view.getId(), view));
                }
                return viewC2;
            }
            if (!(view instanceof ReactCompoundView) || !e(view, fArr[0], fArr[1]) || ((ReactCompoundView) view).reactTagForTouch(fArr[0], fArr[1]) == view.getId()) {
                return null;
            }
            if (arrayList != null) {
                arrayList.add(new ViewTarget(view.getId(), view));
                return view;
            }
        } else {
            if (pointerEvents != PointerEvents.f19428e) {
                FLog.q("ReactNative", "Unknown pointer event type: " + pointerEvents.toString());
            }
            if (!(view instanceof ReactCompoundViewGroup) || !e(view, fArr[0], fArr[1]) || !((ReactCompoundViewGroup) view).interceptsTouchEvent(fArr[0], fArr[1])) {
                View viewC3 = c(fArr, view, EnumSet.of(touchTargetReturnType, touchTargetReturnType2), arrayList);
                if (viewC3 != null && arrayList != null) {
                    arrayList.add(new ViewTarget(view.getId(), view));
                }
                return viewC3;
            }
            if (arrayList != null) {
                arrayList.add(new ViewTarget(view.getId(), view));
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(View view, float f2, float f3) {
        if (view instanceof ReactHitSlopView) {
            ReactHitSlopView reactHitSlopView = (ReactHitSlopView) view;
            if (reactHitSlopView.getHitSlopRect() != null) {
                Rect hitSlopRect = reactHitSlopView.getHitSlopRect();
                return f2 >= ((float) (-hitSlopRect.left)) && f2 < ((float) (view.getWidth() + hitSlopRect.right)) && f3 >= ((float) (-hitSlopRect.top)) && f3 < ((float) (view.getHeight() + hitSlopRect.bottom));
            }
        }
        return f2 >= 0.0f && f2 < ((float) view.getWidth()) && f3 >= 0.0f && f3 < ((float) view.getHeight());
    }
}
