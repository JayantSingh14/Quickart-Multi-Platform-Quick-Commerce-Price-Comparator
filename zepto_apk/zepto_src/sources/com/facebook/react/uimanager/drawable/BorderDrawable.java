package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ColorEdges;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.LogicalEdge;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BorderDrawable extends Drawable {
    public static final /* synthetic */ KProperty[] z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f19639a;

    /* renamed from: b, reason: collision with root package name */
    public final Spacing f19640b;

    /* renamed from: c, reason: collision with root package name */
    public BorderRadiusStyle f19641c;

    /* renamed from: d, reason: collision with root package name */
    public BorderInsets f19642d;

    /* renamed from: e, reason: collision with root package name */
    public final BorderDrawable$invalidatingAndPathChange$1 f19643e;

    /* renamed from: f, reason: collision with root package name */
    public Integer[] f19644f;

    /* renamed from: g, reason: collision with root package name */
    public ColorEdges f19645g;

    /* renamed from: h, reason: collision with root package name */
    public ComputedBorderRadius f19646h;

    /* renamed from: i, reason: collision with root package name */
    public int f19647i;

    /* renamed from: j, reason: collision with root package name */
    public final float f19648j;

    /* renamed from: k, reason: collision with root package name */
    public Path f19649k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f19650l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19651m;
    public Path n;
    public Path o;
    public Path p;
    public Path q;
    public Path r;
    public PointF s;
    public PointF t;
    public PointF u;
    public PointF v;
    public RectF w;
    public RectF x;
    public RectF y;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[BorderStyle.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BorderStyle.Companion companion = BorderStyle.f19856a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BorderStyle.Companion companion2 = BorderStyle.f19856a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl("borderStyle", "getBorderStyle()Lcom/facebook/react/uimanager/style/BorderStyle;", BorderDrawable.class);
        Reflection.f53802a.getClass();
        z = new KProperty[]{mutablePropertyReference1Impl};
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.facebook.react.uimanager.drawable.BorderDrawable$invalidatingAndPathChange$1] */
    public BorderDrawable(Context context, Spacing spacing, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets) {
        BorderStyle.Companion companion = BorderStyle.f19856a;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19639a = context;
        this.f19640b = spacing;
        this.f19641c = borderRadiusStyle;
        this.f19642d = borderInsets;
        this.f19643e = new ObservableProperty<Object>(this) { // from class: com.facebook.react.uimanager.drawable.BorderDrawable$invalidatingAndPathChange$1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BorderDrawable f19652b;

            {
                BorderStyle borderStyle = BorderStyle.f19857b;
                this.f19652b = this;
                this.f53814a = borderStyle;
            }

            @Override // kotlin.properties.ObservableProperty
            public final void b(KProperty property, BorderStyle borderStyle, BorderStyle borderStyle2) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.b(borderStyle, borderStyle2)) {
                    return;
                }
                BorderDrawable borderDrawable = this.f19652b;
                borderDrawable.f19651m = true;
                borderDrawable.invalidateSelf();
            }
        };
        this.f19645g = new ColorEdges(0);
        this.f19647i = 255;
        this.f19648j = 0.8f;
        this.f19650l = new Paint(1);
        this.f19651m = true;
    }

    public static void d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        double d10 = 2;
        double d11 = (d2 + d4) / d10;
        double d12 = (d3 + d5) / d10;
        double d13 = d6 - d11;
        double d14 = d7 - d12;
        double dAbs = Math.abs(d4 - d2) / d10;
        double dAbs2 = Math.abs(d5 - d3) / d10;
        double d15 = ((d9 - d12) - d14) / ((d8 - d11) - d13);
        double d16 = d14 - (d13 * d15);
        double d17 = dAbs2 * dAbs2;
        double d18 = dAbs * dAbs;
        double dA = b.a(d18, d15, d15, d17);
        double d19 = d10 * dAbs * dAbs * d16 * d15;
        double d20 = d10 * dA;
        double dSqrt = ((-d19) / d20) - Math.sqrt(Math.pow(d19 / d20, 2.0d) + ((-(d18 * ((d16 * d16) - d17))) / dA));
        double d21 = (d15 * dSqrt) + d16;
        double d22 = dSqrt + d11;
        double d23 = d21 + d12;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    public static float e(float f2, float f3) {
        float f4 = f2 - f3;
        if (f4 < 0.0f) {
            return 0.0f;
        }
        return f4;
    }

    public static DashPathEffect f(BorderStyle borderStyle, float f2) {
        int iOrdinal = borderStyle.ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 1) {
            float f3 = f2 * 3;
            return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
        }
        if (iOrdinal == 2) {
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static int g(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * ((i3 + (i3 >> 7)) >> 7)) >> 8) << 24);
    }

    public final RectF a() {
        BorderInsets borderInsets = this.f19642d;
        if (borderInsets == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        RectF rectFA = borderInsets.a(getLayoutDirection(), this.f19639a);
        return new RectF(Float.isNaN(rectFA.left) ? 0.0f : PixelUtil.b(rectFA.left), Float.isNaN(rectFA.top) ? 0.0f : PixelUtil.b(rectFA.top), Float.isNaN(rectFA.right) ? 0.0f : PixelUtil.b(rectFA.right), Float.isNaN(rectFA.bottom) ? 0.0f : PixelUtil.b(rectFA.bottom));
    }

    public final void b(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i2 == 0) {
            return;
        }
        if (this.f19649k == null) {
            this.f19649k = new Path();
        }
        Paint paint = this.f19650l;
        paint.setColor(g(i2, this.f19647i));
        Path path = this.f19649k;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.f19649k;
        if (path2 != null) {
            path2.moveTo(f2, f3);
        }
        Path path3 = this.f19649k;
        if (path3 != null) {
            path3.lineTo(f4, f5);
        }
        Path path4 = this.f19649k;
        if (path4 != null) {
            path4.lineTo(f6, f7);
        }
        Path path5 = this.f19649k;
        if (path5 != null) {
            path5.lineTo(f8, f9);
        }
        Path path6 = this.f19649k;
        if (path6 != null) {
            path6.lineTo(f2, f3);
        }
        Path path7 = this.f19649k;
        if (path7 != null) {
            canvas.drawPath(path7, paint);
        }
    }

    public final BorderStyle c() {
        return (BorderStyle) a(this, z[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:419:0x06db  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r59) {
        /*
            Method dump skipped, instructions count: 2584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.drawable.BorderDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int iAlpha = Color.alpha(g(this.f19645g.f19869a, this.f19647i));
        int[] other = {Color.alpha(g(this.f19645g.f19870b, this.f19647i)), Color.alpha(g(this.f19645g.f19871c, this.f19647i)), Color.alpha(g(this.f19645g.f19872d, this.f19647i))};
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 = 0; i2 < 3; i2++) {
            iAlpha = Math.max(iAlpha, other[i2]);
        }
        if (iAlpha == 0) {
            return -2;
        }
        int iAlpha2 = Color.alpha(g(this.f19645g.f19869a, this.f19647i));
        int[] other2 = {Color.alpha(g(this.f19645g.f19870b, this.f19647i)), Color.alpha(g(this.f19645g.f19871c, this.f19647i)), Color.alpha(g(this.f19645g.f19872d, this.f19647i))};
        Intrinsics.checkNotNullParameter(other2, "other");
        for (int i3 = 0; i3 < 3; i3++) {
            iAlpha2 = Math.min(iAlpha2, other2[i3]);
        }
        return iAlpha2 == 255 ? -1 : -3;
    }

    public final void h(LogicalEdge position, Integer num) {
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] edgeColors = this.f19644f;
        if (edgeColors == null) {
            edgeColors = new Integer[LogicalEdge.values().length];
            Intrinsics.checkNotNullParameter(edgeColors, "edgeColors");
        }
        this.f19644f = edgeColors;
        edgeColors[position.ordinal()] = num;
        this.f19651m = true;
        invalidateSelf();
    }

    public final void i(BorderInsets borderInsets) {
        this.f19642d = borderInsets;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f19651m = true;
        super.invalidateSelf();
    }

    public final void j(BorderRadiusStyle borderRadiusStyle) {
        this.f19641c = borderRadiusStyle;
    }

    public final void k(BorderStyle borderStyle) {
        KProperty property = z[0];
        BorderDrawable$invalidatingAndPathChange$1 borderDrawable$invalidatingAndPathChange$1 = this.f19643e;
        borderDrawable$invalidatingAndPathChange$1.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        BorderStyle borderStyle2 = borderDrawable$invalidatingAndPathChange$1.f53814a;
        borderDrawable$invalidatingAndPathChange$1.c(property);
        borderDrawable$invalidatingAndPathChange$1.f53814a = borderStyle;
        borderDrawable$invalidatingAndPathChange$1.b(property, borderStyle2, borderStyle);
    }

    public final void l(int i2, float f2) {
        Spacing spacing = this.f19640b;
        Float fValueOf = spacing != null ? Float.valueOf(spacing.f19476b[i2]) : null;
        if (fValueOf == null ? false : FloatUtil.a(fValueOf.floatValue(), f2)) {
            return;
        }
        if (spacing != null) {
            spacing.b(f2, i2);
        }
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
            this.f19651m = true;
        }
        invalidateSelf();
    }

    public final void m(int i2) {
        BorderStyle borderStyleC = c();
        if (borderStyleC != null) {
            this.f19650l.setPathEffect(c() != null ? f(borderStyleC, i2) : null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.f19651m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f19647i = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
