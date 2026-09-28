package com.chuckerteam.chucker.internal.support;

import android.graphics.Paint;
import androidx.palette.graphics.Palette;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Palette.Filter {
    @Override // androidx.palette.graphics.Palette.Filter
    public final boolean a(int i2, float[] fArr) {
        Paint paint = BitmapUtilsKt.f16746a;
        Intrinsics.checkNotNullParameter(fArr, "<unused var>");
        return i2 != -65281;
    }
}
