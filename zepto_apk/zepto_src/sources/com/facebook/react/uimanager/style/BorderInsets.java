package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.RectF;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.style.LogicalEdge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BorderInsets {

    /* renamed from: a, reason: collision with root package name */
    public final Float[] f19835a = new Float[LogicalEdge.values().length];

    public final RectF a(int i2, Context context) {
        float fFloatValue;
        float fFloatValue2;
        Intrinsics.checkNotNullParameter(context, "context");
        float fFloatValue3 = 0.0f;
        Float[] fArr = this.f19835a;
        if (i2 == 0) {
            LogicalEdge.Companion companion = LogicalEdge.f19898a;
            Float f2 = fArr[5];
            float fFloatValue4 = (f2 == null && (f2 = fArr[1]) == null && (f2 = fArr[7]) == null && (f2 = fArr[0]) == null) ? 0.0f : f2.floatValue();
            Float f3 = fArr[9];
            float fFloatValue5 = (f3 == null && (f3 = fArr[3]) == null && (f3 = fArr[11]) == null && (f3 = fArr[8]) == null && (f3 = fArr[0]) == null) ? 0.0f : f3.floatValue();
            Float f4 = fArr[6];
            float fFloatValue6 = (f4 == null && (f4 = fArr[2]) == null && (f4 = fArr[7]) == null && (f4 = fArr[0]) == null) ? 0.0f : f4.floatValue();
            Float f5 = fArr[10];
            if (f5 == null && (f5 = fArr[4]) == null && (f5 = fArr[11]) == null && (f5 = fArr[8]) == null) {
                Float f6 = fArr[0];
                if (f6 != null) {
                    fFloatValue3 = f6.floatValue();
                }
            } else {
                fFloatValue3 = f5.floatValue();
            }
            return new RectF(fFloatValue4, fFloatValue5, fFloatValue6, fFloatValue3);
        }
        if (i2 != 1) {
            throw new IllegalArgumentException("Expected resolved layout direction");
        }
        if (I18nUtil.a(context)) {
            LogicalEdge.Companion companion2 = LogicalEdge.f19898a;
            Float f7 = fArr[6];
            float fFloatValue7 = (f7 == null && (f7 = fArr[2]) == null && (f7 = fArr[7]) == null && (f7 = fArr[0]) == null) ? 0.0f : f7.floatValue();
            Float f8 = fArr[9];
            if (f8 != null) {
                fFloatValue2 = f8.floatValue();
            } else {
                Float f9 = fArr[3];
                fFloatValue2 = (f9 == null && (f9 = fArr[11]) == null && (f9 = fArr[8]) == null && (f9 = fArr[0]) == null) ? 0.0f : f9.floatValue();
            }
            Float f10 = fArr[5];
            float fFloatValue8 = (f10 == null && (f10 = fArr[1]) == null && (f10 = fArr[7]) == null && (f10 = fArr[0]) == null) ? 0.0f : f10.floatValue();
            Float f11 = fArr[10];
            if (f11 == null && (f11 = fArr[4]) == null && (f11 = fArr[11]) == null && (f11 = fArr[8]) == null) {
                Float f12 = fArr[0];
                if (f12 != null) {
                    fFloatValue3 = f12.floatValue();
                }
            } else {
                fFloatValue3 = f11.floatValue();
            }
            return new RectF(fFloatValue7, fFloatValue2, fFloatValue8, fFloatValue3);
        }
        LogicalEdge.Companion companion3 = LogicalEdge.f19898a;
        Float f13 = fArr[6];
        float fFloatValue9 = (f13 == null && (f13 = fArr[1]) == null && (f13 = fArr[7]) == null && (f13 = fArr[0]) == null) ? 0.0f : f13.floatValue();
        Float f14 = fArr[9];
        if (f14 != null) {
            fFloatValue = f14.floatValue();
        } else {
            Float f15 = fArr[3];
            fFloatValue = (f15 == null && (f15 = fArr[11]) == null && (f15 = fArr[8]) == null && (f15 = fArr[0]) == null) ? 0.0f : f15.floatValue();
        }
        Float f16 = fArr[5];
        float fFloatValue10 = (f16 == null && (f16 = fArr[2]) == null && (f16 = fArr[7]) == null && (f16 = fArr[0]) == null) ? 0.0f : f16.floatValue();
        Float f17 = fArr[10];
        if (f17 == null && (f17 = fArr[4]) == null && (f17 = fArr[11]) == null && (f17 = fArr[8]) == null) {
            Float f18 = fArr[0];
            if (f18 != null) {
                fFloatValue3 = f18.floatValue();
            }
        } else {
            fFloatValue3 = f17.floatValue();
        }
        return new RectF(fFloatValue9, fFloatValue, fFloatValue10, fFloatValue3);
    }

    public final void b(LogicalEdge edge, Float f2) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        this.f19835a[edge.ordinal()] = f2;
    }
}
