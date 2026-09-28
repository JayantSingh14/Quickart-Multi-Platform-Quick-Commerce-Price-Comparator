package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.style.Gradient;
import com.facebook.react.uimanager.style.LinearGradient;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BackgroundImageLayer {

    /* renamed from: a, reason: collision with root package name */
    public final Gradient f19834a;

    public BackgroundImageLayer(Context context, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Gradient gradient = null;
        if (readableMap != null) {
            try {
                gradient = new Gradient(context, readableMap);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.f19834a = gradient;
    }

    public final android.graphics.LinearGradient a(Rect bounds) {
        double degrees;
        double degrees2;
        double d2;
        int i2;
        Pair pair;
        Pair pair2;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Gradient gradient = this.f19834a;
        if (gradient == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (Gradient.WhenMappings.f19886a[gradient.f19881a.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        float fWidth = bounds.width();
        float fHeight = bounds.height();
        LinearGradient linearGradient = gradient.f19882b;
        LinearGradient.Direction direction = linearGradient.f19889c;
        if (direction instanceof LinearGradient.Direction.Angle) {
            degrees = ((LinearGradient.Direction.Angle) direction).f19890a;
        } else {
            if (!(direction instanceof LinearGradient.Direction.Keyword)) {
                throw new NoWhenBranchMatchedException();
            }
            double d3 = fWidth;
            double d4 = fHeight;
            int iOrdinal = ((LinearGradient.Direction.Keyword) direction).f19891a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        degrees2 = Math.toDegrees(Math.atan(d3 / d4));
                        i2 = 270;
                    } else {
                        if (iOrdinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        degrees2 = Math.toDegrees(Math.atan(d4 / d3));
                        i2 = 180;
                    }
                    d2 = i2;
                } else {
                    degrees2 = Math.toDegrees(Math.atan(d3 / d4));
                    d2 = 90;
                }
                degrees = degrees2 + d2;
            } else {
                degrees = 90 - Math.toDegrees(Math.atan(d3 / d4));
            }
        }
        double d5 = 360;
        double d6 = degrees % d5;
        if (d6 < 0.0d) {
            d6 += d5;
        }
        if (d6 == 0.0d) {
            pair = new Pair(new float[]{0.0f, fHeight}, new float[]{0.0f, 0.0f});
        } else {
            if (d6 == 90.0d) {
                pair2 = new Pair(new float[]{0.0f, 0.0f}, new float[]{fWidth, 0.0f});
            } else if (d6 == 180.0d) {
                pair = new Pair(new float[]{0.0f, 0.0f}, new float[]{0.0f, fHeight});
            } else if (d6 == 270.0d) {
                pair2 = new Pair(new float[]{fWidth, 0.0f}, new float[]{0.0f, 0.0f});
            } else {
                float fTan = (float) Math.tan(Math.toRadians(90 - d6));
                float f2 = (-1) / fTan;
                float f3 = 2;
                float f4 = fHeight / f3;
                float f5 = fWidth / f3;
                float[] fArr = d6 < 90.0d ? new float[]{f5, f4} : d6 < 180.0d ? new float[]{f5, -f4} : d6 < 270.0d ? new float[]{-f5, -f4} : new float[]{-f5, f4};
                float f6 = fArr[1] - (fArr[0] * f2);
                float f7 = f6 / (fTan - f2);
                float f8 = (f2 * f7) + f6;
                pair = new Pair(new float[]{f5 - f7, f4 + f8}, new float[]{f5 + f7, f4 - f8});
            }
            pair = pair2;
        }
        float[] fArr2 = (float[]) pair.f53533a;
        float[] fArr3 = (float[]) pair.f53534b;
        return new android.graphics.LinearGradient(fArr2[0], fArr2[1], fArr3[0], fArr3[1], linearGradient.f19887a, linearGradient.f19888b, Shader.TileMode.CLAMP);
    }
}
