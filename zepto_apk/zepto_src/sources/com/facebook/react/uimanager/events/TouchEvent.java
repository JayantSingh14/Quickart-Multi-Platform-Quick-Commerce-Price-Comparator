package com.facebook.react.uimanager.events;

import android.support.v4.media.b;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.events.TouchEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Message;

@Metadata
/* loaded from: classes3.dex */
public final class TouchEvent extends Event<TouchEvent> {

    /* renamed from: f, reason: collision with root package name */
    public static final Pools.SynchronizedPool f19770f = new Pools.SynchronizedPool(3);

    /* renamed from: a, reason: collision with root package name */
    public MotionEvent f19771a;

    /* renamed from: b, reason: collision with root package name */
    public TouchEventType f19772b;

    /* renamed from: c, reason: collision with root package name */
    public short f19773c;

    /* renamed from: d, reason: collision with root package name */
    public float f19774d;

    /* renamed from: e, reason: collision with root package name */
    public float f19775e;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19776a;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                TouchEventType.Companion companion = TouchEventType.f19778b;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                TouchEventType.Companion companion2 = TouchEventType.f19778b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                TouchEventType.Companion companion3 = TouchEventType.f19778b;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                TouchEventType.Companion companion4 = TouchEventType.f19778b;
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f19776a = iArr;
        }
    }

    public static final TouchEvent a(int i2, int i3, TouchEventType touchEventType, MotionEvent motionEvent, long j2, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        Intrinsics.checkNotNullParameter(touchEventCoalescingKeyHelper, "touchEventCoalescingKeyHelper");
        TouchEvent touchEvent = (TouchEvent) f19770f.b();
        if (touchEvent == null) {
            touchEvent = new TouchEvent();
        }
        Assertions.c(motionEvent);
        Intrinsics.checkNotNullExpressionValue(motionEvent, "assertNotNull(...)");
        super.init(i2, i3, motionEvent.getEventTime());
        short s = 0;
        SoftAssertions.assertCondition(j2 != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            touchEventCoalescingKeyHelper.f19777a.put((int) j2, 0);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.f19777a.delete((int) j2);
        } else if (action == 2) {
            int i4 = touchEventCoalescingKeyHelper.f19777a.get((int) j2, -1);
            if (i4 == -1) {
                throw new RuntimeException("Tried to get non-existent cookie");
            }
            s = (short) (i4 & Message.MAXLENGTH);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.f19777a.delete((int) j2);
        } else {
            if (action != 5 && action != 6) {
                throw new RuntimeException(b.f(action, "Unhandled MotionEvent action: "));
            }
            SparseIntArray sparseIntArray = touchEventCoalescingKeyHelper.f19777a;
            int i5 = (int) j2;
            int i6 = sparseIntArray.get(i5, -1);
            if (i6 == -1) {
                throw new RuntimeException("Tried to increment non-existent cookie");
            }
            sparseIntArray.put(i5, i6 + 1);
        }
        touchEvent.f19771a = MotionEvent.obtain(motionEvent);
        touchEvent.f19772b = touchEventType;
        touchEvent.f19773c = s;
        touchEvent.f19774d = f2;
        touchEvent.f19775e = f3;
        return touchEvent;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        TouchEventType touchEventType = this.f19772b;
        Assertions.c(touchEventType);
        int i2 = WhenMappings.f19776a[touchEventType.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return false;
        }
        if (i2 == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.f19772b);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (this.f19771a != null) {
            TouchesHelper.d(rctEventEmitter, this);
        } else {
            Intrinsics.checkNotNullExpressionValue("TouchEvent", "TAG");
            ReactSoftExceptionLogger.logSoftException("TouchEvent", new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (this.f19771a != null) {
            rctEventEmitter.receiveTouches(this);
        } else {
            Intrinsics.checkNotNullExpressionValue("TouchEvent", "TAG");
            ReactSoftExceptionLogger.logSoftException("TouchEvent", new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return this.f19773c;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final int getEventCategory() {
        TouchEventType touchEventType = this.f19772b;
        if (touchEventType == null) {
            return 2;
        }
        int iOrdinal = touchEventType.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return 4;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return 1;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        TouchEventType.Companion companion = TouchEventType.f19778b;
        TouchEventType type = this.f19772b;
        Assertions.c(type);
        Intrinsics.checkNotNullExpressionValue(type, "assertNotNull(...)");
        companion.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        return type.f19785a;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        MotionEvent motionEvent = this.f19771a;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.f19771a = null;
        try {
            f19770f.a(this);
        } catch (IllegalStateException e2) {
            Intrinsics.checkNotNullExpressionValue("TouchEvent", "TAG");
            ReactSoftExceptionLogger.logSoftException("TouchEvent", e2);
        }
    }
}
