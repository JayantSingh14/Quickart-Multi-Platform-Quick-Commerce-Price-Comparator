package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata
/* loaded from: classes3.dex */
public final class BackgroundDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19627a;

    /* renamed from: b, reason: collision with root package name */
    public BorderRadiusStyle f19628b;

    /* renamed from: c, reason: collision with root package name */
    public BorderInsets f19629c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19630d;

    /* renamed from: e, reason: collision with root package name */
    public RectF f19631e;

    /* renamed from: f, reason: collision with root package name */
    public ComputedBorderRadius f19632f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19633g;

    /* renamed from: h, reason: collision with root package name */
    public int f19634h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f19635i;

    /* renamed from: j, reason: collision with root package name */
    public Path f19636j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f19637k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f19638l;

    public BackgroundDrawable(Context context, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19627a = context;
        this.f19628b = borderRadiusStyle;
        this.f19629c = borderInsets;
        this.f19630d = 0.8f;
        this.f19633g = true;
        this.f19635i = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f19634h);
        this.f19638l = paint;
    }

    public final int a() {
        return this.f19634h;
    }

    public final void b(int i2) {
        if (this.f19634h != i2) {
            this.f19634h = i2;
            this.f19638l.setColor(i2);
            invalidateSelf();
        }
    }

    public final void c(ArrayList arrayList) {
        if (Intrinsics.b(this.f19637k, arrayList)) {
            return;
        }
        this.f19637k = arrayList;
        invalidateSelf();
    }

    public final void d(BorderInsets borderInsets) {
        this.f19629c = borderInsets;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.drawable.BackgroundDrawable.draw(android.graphics.Canvas):void");
    }

    public final void e(BorderRadiusStyle borderRadiusStyle) {
        this.f19628b = borderRadiusStyle;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int alpha = this.f19638l.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f19633g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.f19633g = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f19638l.setAlpha(MathKt.b((Color.alpha(this.f19634h) / 255.0f) * (i2 / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
