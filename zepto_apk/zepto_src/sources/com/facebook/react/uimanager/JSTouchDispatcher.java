package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;

@Nullsafe
/* loaded from: classes.dex */
public class JSTouchDispatcher {

    /* renamed from: e, reason: collision with root package name */
    public final ViewGroup f19386e;

    /* renamed from: a, reason: collision with root package name */
    public int f19382a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f19383b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    public boolean f19384c = false;

    /* renamed from: d, reason: collision with root package name */
    public long f19385d = Long.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public final TouchEventCoalescingKeyHelper f19387f = new TouchEventCoalescingKeyHelper();

    public JSTouchDispatcher(ViewGroup viewGroup) {
        this.f19386e = viewGroup;
    }

    public final void a(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.f19382a == -1) {
            FLog.q("ReactNative", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        Assertions.b(!this.f19384c, "Expected to not have already sent a cancel for this gesture");
        Assertions.c(eventDispatcher);
        int iE = UIManagerHelper.e(this.f19386e);
        int i2 = this.f19382a;
        TouchEventType touchEventType = TouchEventType.f19782f;
        long j2 = this.f19385d;
        float[] fArr = this.f19383b;
        eventDispatcher.g(TouchEvent.a(iE, i2, touchEventType, motionEvent, j2, fArr[0], fArr[1], this.f19387f));
    }

    public final void b(MotionEvent motionEvent, EventDispatcher eventDispatcher, ReactContext reactContext) {
        UIManager uIManagerF;
        UIManager uIManagerF2;
        UIManager uIManagerF3;
        int action = motionEvent.getAction() & 255;
        float[] fArr = this.f19383b;
        ViewGroup viewGroup = this.f19386e;
        if (action == 0) {
            if (this.f19382a != -1) {
                FLog.g("ReactNative", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.f19384c = false;
            this.f19385d = motionEvent.getEventTime();
            this.f19382a = TouchTargetHelper.a(motionEvent.getX(), motionEvent.getY(), viewGroup, fArr);
            int iE = UIManagerHelper.e(viewGroup);
            int i2 = this.f19382a;
            if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid() && reactContext != null && (uIManagerF3 = UIManagerHelper.f(reactContext, 2, true)) != null) {
                uIManagerF3.markActiveTouchForTag(iE, i2);
            }
            eventDispatcher.g(TouchEvent.a(UIManagerHelper.e(viewGroup), this.f19382a, TouchEventType.f19779c, motionEvent, this.f19385d, fArr[0], fArr[1], this.f19387f));
            return;
        }
        if (this.f19384c) {
            return;
        }
        if (this.f19382a == -1) {
            FLog.g("ReactNative", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            return;
        }
        if (action == 1) {
            TouchTargetHelper.a(motionEvent.getX(), motionEvent.getY(), viewGroup, fArr);
            int iE2 = UIManagerHelper.e(viewGroup);
            eventDispatcher.g(TouchEvent.a(iE2, this.f19382a, TouchEventType.f19780d, motionEvent, this.f19385d, fArr[0], fArr[1], this.f19387f));
            int i3 = this.f19382a;
            if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid() && reactContext != null && (uIManagerF2 = UIManagerHelper.f(reactContext, 2, true)) != null) {
                uIManagerF2.sweepActiveTouchForTag(iE2, i3);
            }
            this.f19382a = -1;
            this.f19385d = Long.MIN_VALUE;
            return;
        }
        if (action == 2) {
            TouchTargetHelper.a(motionEvent.getX(), motionEvent.getY(), viewGroup, fArr);
            eventDispatcher.g(TouchEvent.a(UIManagerHelper.e(viewGroup), this.f19382a, TouchEventType.f19781e, motionEvent, this.f19385d, fArr[0], fArr[1], this.f19387f));
            return;
        }
        if (action == 5) {
            eventDispatcher.g(TouchEvent.a(UIManagerHelper.e(viewGroup), this.f19382a, TouchEventType.f19779c, motionEvent, this.f19385d, fArr[0], fArr[1], this.f19387f));
            return;
        }
        if (action == 6) {
            eventDispatcher.g(TouchEvent.a(UIManagerHelper.e(viewGroup), this.f19382a, TouchEventType.f19780d, motionEvent, this.f19385d, fArr[0], fArr[1], this.f19387f));
            return;
        }
        if (action != 3) {
            StringBuilder sbU = android.support.v4.media.b.u(action, "Warning : touch event was ignored. Action=", " Target=");
            sbU.append(this.f19382a);
            FLog.q("ReactNative", sbU.toString());
            return;
        }
        if (this.f19387f.f19777a.get((int) motionEvent.getDownTime(), -1) != -1) {
            a(motionEvent, eventDispatcher);
        } else {
            FLog.g("ReactNative", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
        }
        int iE3 = UIManagerHelper.e(viewGroup);
        int i4 = this.f19382a;
        if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid() && reactContext != null && (uIManagerF = UIManagerHelper.f(reactContext, 2, true)) != null) {
            uIManagerF.sweepActiveTouchForTag(iE3, i4);
        }
        this.f19382a = -1;
        this.f19385d = Long.MIN_VALUE;
    }

    public final void c(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.f19384c) {
            return;
        }
        a(motionEvent, eventDispatcher);
        this.f19384c = true;
        this.f19382a = -1;
    }
}
