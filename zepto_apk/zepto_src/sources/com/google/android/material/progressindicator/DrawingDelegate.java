package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* loaded from: classes4.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {

    /* renamed from: a, reason: collision with root package name */
    public final BaseProgressIndicatorSpec f40821a;

    public static class ActiveIndicator {

        /* renamed from: a, reason: collision with root package name */
        public float f40822a;

        /* renamed from: b, reason: collision with root package name */
        public float f40823b;

        /* renamed from: c, reason: collision with root package name */
        public int f40824c;

        /* renamed from: d, reason: collision with root package name */
        public int f40825d;
    }

    public DrawingDelegate(BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f40821a = baseProgressIndicatorSpec;
    }

    public abstract void a(Canvas canvas, Rect rect, float f2, boolean z, boolean z2);

    public abstract void b(Canvas canvas, Paint paint, int i2, int i3);

    public abstract void c(Canvas canvas, Paint paint, ActiveIndicator activeIndicator, int i2);

    public abstract void d(Canvas canvas, Paint paint, float f2, float f3, int i2, int i3, int i4);

    public abstract int e();

    public abstract int f();
}
