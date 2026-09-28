package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class StylusData {

    /* renamed from: a, reason: collision with root package name */
    public final double f46784a;

    /* renamed from: b, reason: collision with root package name */
    public final double f46785b;

    /* renamed from: c, reason: collision with root package name */
    public final double f46786c;

    /* renamed from: d, reason: collision with root package name */
    public final double f46787d;

    /* renamed from: e, reason: collision with root package name */
    public final double f46788e;

    @Metadata
    public static final class Companion {
        public static StylusData a(MotionEvent event) {
            double dAtan;
            Intrinsics.checkNotNullParameter(event, "event");
            double dAtan2 = 1.5707963267948966d;
            double axisValue = 1.5707963267948966d - event.getAxisValue(25);
            double pressure = event.getPressure(0);
            double orientation = (event.getOrientation(0) + 1.5707963267948966d) % 6.283185307179586d;
            if (orientation != 0.0d && Math.signum(orientation) != Math.signum(6.283185307179586d)) {
                orientation += 6.283185307179586d;
            }
            double d2 = orientation;
            if (axisValue < 1.0E-9d) {
                double d3 = (d2 < 1.0E-9d || Math.abs(d2 - 6.283185307179586d) < 1.0E-9d) ? 1.5707963267948966d : 0.0d;
                double d4 = d2 - 1.5707963267948966d;
                double d5 = Math.abs(d4) < 1.0E-9d ? 1.5707963267948966d : 0.0d;
                double d6 = d2 - 3.141592653589793d;
                dAtan = -1.5707963267948966d;
                if (Math.abs(d6) < 1.0E-9d) {
                    d3 = -1.5707963267948966d;
                }
                double d7 = d2 - 4.71238898038469d;
                if (Math.abs(d7) < 1.0E-9d) {
                    d5 = -1.5707963267948966d;
                }
                if (d2 > 1.0E-9d && Math.abs(d4) < 1.0E-9d) {
                    d5 = 1.5707963267948966d;
                    d3 = 1.5707963267948966d;
                }
                if (Math.abs(d4) > 1.0E-9d && Math.abs(d6) < 1.0E-9d) {
                    d5 = 1.5707963267948966d;
                    d3 = -1.5707963267948966d;
                }
                if (Math.abs(d6) > 1.0E-9d && Math.abs(d7) < 1.0E-9d) {
                    d5 = -1.5707963267948966d;
                    d3 = -1.5707963267948966d;
                }
                if (Math.abs(d7) <= 1.0E-9d || Math.abs(d2 - 6.283185307179586d) >= 1.0E-9d) {
                    dAtan = d5;
                    dAtan2 = d3;
                }
            } else {
                double dTan = Math.tan(axisValue);
                dAtan2 = Math.atan(Math.cos(d2) / dTan);
                dAtan = Math.atan(Math.sin(d2) / dTan);
            }
            return new StylusData(Double.valueOf(Math.rint(dAtan2 * 57.29577951308232d)).doubleValue(), Double.valueOf(Math.rint(dAtan * 57.29577951308232d)).doubleValue(), axisValue, d2, pressure);
        }
    }

    public StylusData() {
        this(0);
    }

    public final WritableMap a() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("tiltX", this.f46784a);
        writableMapCreateMap.putDouble("tiltY", this.f46785b);
        writableMapCreateMap.putDouble("altitudeAngle", this.f46786c);
        writableMapCreateMap.putDouble("azimuthAngle", this.f46787d);
        writableMapCreateMap.putDouble("pressure", this.f46788e);
        return writableMapCreateMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusData)) {
            return false;
        }
        StylusData stylusData = (StylusData) obj;
        return Double.compare(this.f46784a, stylusData.f46784a) == 0 && Double.compare(this.f46785b, stylusData.f46785b) == 0 && Double.compare(this.f46786c, stylusData.f46786c) == 0 && Double.compare(this.f46787d, stylusData.f46787d) == 0 && Double.compare(this.f46788e, stylusData.f46788e) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f46788e) + ((Double.hashCode(this.f46787d) + ((Double.hashCode(this.f46786c) + ((Double.hashCode(this.f46785b) + (Double.hashCode(this.f46784a) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "StylusData(tiltX=" + this.f46784a + ", tiltY=" + this.f46785b + ", altitudeAngle=" + this.f46786c + ", azimuthAngle=" + this.f46787d + ", pressure=" + this.f46788e + ")";
    }

    public StylusData(double d2, double d3, double d4, double d5, double d6) {
        this.f46784a = d2;
        this.f46785b = d3;
        this.f46786c = d4;
        this.f46787d = d5;
        this.f46788e = d6;
    }

    public /* synthetic */ StylusData(int i2) {
        this(0.0d, 0.0d, 0.0d, 0.0d, -1.0d);
    }
}
