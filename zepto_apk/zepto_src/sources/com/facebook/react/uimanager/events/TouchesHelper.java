package com.facebook.react.uimanager.events;

import android.os.Trace;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.TouchEventType;
import com.facebook.systrace.Systrace;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TouchesHelper {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                TouchEventType.Companion companion = TouchEventType.f19778b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                TouchEventType.Companion companion2 = TouchEventType.f19778b;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                TouchEventType.Companion companion3 = TouchEventType.f19778b;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static WritableMap[] a(TouchEvent touchEvent) {
        MotionEvent motionEvent = touchEvent.f19771a;
        Assertions.c(motionEvent);
        Intrinsics.checkNotNullExpressionValue(motionEvent, "assertNotNull(...)");
        WritableMap[] writableMapArr = new WritableMap[motionEvent.getPointerCount()];
        float x = motionEvent.getX() - touchEvent.f19774d;
        float y = motionEvent.getY() - touchEvent.f19775e;
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("pageX", PixelUtil.a(motionEvent.getX(i2)));
            writableMapCreateMap.putDouble("pageY", PixelUtil.a(motionEvent.getY(i2)));
            float x2 = motionEvent.getX(i2) - x;
            float y2 = motionEvent.getY(i2) - y;
            writableMapCreateMap.putDouble("locationX", PixelUtil.a(x2));
            writableMapCreateMap.putDouble("locationY", PixelUtil.a(y2));
            writableMapCreateMap.putInt("targetSurface", touchEvent.getSurfaceId());
            writableMapCreateMap.putInt("target", touchEvent.getViewTag());
            writableMapCreateMap.putDouble("timestamp", touchEvent.getTimestampMs());
            writableMapCreateMap.putDouble("identifier", motionEvent.getPointerId(i2));
            writableMapArr[i2] = writableMapCreateMap;
        }
        return writableMapArr;
    }

    public static WritableArray b(boolean z, WritableMap[] writableMapArr) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (WritableMap writableMapCopy : writableMapArr) {
            if (writableMapCopy != null) {
                if (z) {
                    writableMapCopy = writableMapCopy.copy();
                }
                writableArrayCreateArray.pushMap(writableMapCopy);
            }
        }
        Intrinsics.c(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    public static final void c(RCTModernEventEmitter eventEmitter, TouchEvent event) {
        WritableMap[] writableMapArr;
        WritableMap writableMap;
        WritableMap[] writableMapArr2;
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        Intrinsics.checkNotNullParameter(event, "event");
        Systrace.a("TouchesHelper.sentTouchEventModern(" + event.getEventName() + ")");
        try {
            TouchEventType touchEventType = event.f19772b;
            Assertions.c(touchEventType);
            Intrinsics.checkNotNullExpressionValue(touchEventType, "assertNotNull(...)");
            MotionEvent motionEvent = event.f19771a;
            Assertions.c(motionEvent);
            Intrinsics.checkNotNullExpressionValue(motionEvent, "assertNotNull(...)");
            WritableMap[] writableMapArrA = a(event);
            int iOrdinal = touchEventType.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    int actionIndex = motionEvent.getActionIndex();
                    WritableMap writableMap2 = writableMapArrA[actionIndex];
                    writableMapArrA[actionIndex] = null;
                    writableMapArr2 = new WritableMap[]{writableMap2};
                } else if (iOrdinal == 2) {
                    writableMapArr2 = new WritableMap[writableMapArrA.length];
                    for (int i2 = 0; i2 < writableMapArrA.length; i2++) {
                        WritableMap writableMap3 = writableMapArrA[i2];
                        writableMapArr2[i2] = writableMap3 != null ? writableMap3.copy() : null;
                    }
                } else {
                    if (iOrdinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    writableMapArr = new WritableMap[0];
                }
                writableMapArr = writableMapArrA;
                writableMapArrA = writableMapArr2;
            } else {
                WritableMap writableMap4 = writableMapArrA[motionEvent.getActionIndex()];
                writableMapArr = writableMapArrA;
                writableMapArrA = new WritableMap[]{writableMap4 != null ? writableMap4.copy() : null};
            }
            Iterator itA = ArrayIteratorKt.a(writableMapArrA);
            while (itA.hasNext()) {
                WritableMap writableMap5 = (WritableMap) itA.next();
                if (writableMap5 != null) {
                    WritableMap writableMapCopy = writableMap5.copy();
                    WritableArray writableArrayB = b(true, writableMapArrA);
                    WritableArray writableArrayB2 = b(true, writableMapArr);
                    writableMapCopy.putArray("changedTouches", writableArrayB);
                    writableMapCopy.putArray("touches", writableArrayB2);
                    writableMap = writableMapCopy;
                } else {
                    writableMap = null;
                }
                RCTModernEventEmitter rCTModernEventEmitter = eventEmitter;
                rCTModernEventEmitter.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap, event.getEventCategory());
                eventEmitter = rCTModernEventEmitter;
            }
        } finally {
            Trace.endSection();
        }
    }

    public static final void d(RCTEventEmitter rctEventEmitter, TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        TouchEventType type = touchEvent.f19772b;
        Assertions.c(type);
        Intrinsics.checkNotNullExpressionValue(type, "assertNotNull(...)");
        WritableArray writableArrayB = b(false, a(touchEvent));
        MotionEvent motionEvent = touchEvent.f19771a;
        Assertions.c(motionEvent);
        Intrinsics.checkNotNullExpressionValue(motionEvent, "assertNotNull(...)");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (type == TouchEventType.f19781e || type == TouchEventType.f19782f) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                writableArrayCreateArray.pushInt(i2);
            }
        } else {
            if (type != TouchEventType.f19779c && type != TouchEventType.f19780d) {
                throw new RuntimeException("Unknown touch type: " + type);
            }
            writableArrayCreateArray.pushInt(motionEvent.getActionIndex());
        }
        TouchEventType.f19778b.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.c(writableArrayCreateArray);
        rctEventEmitter.receiveTouches(type.f19785a, writableArrayB, writableArrayCreateArray);
    }
}
