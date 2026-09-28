package com.facebook.drawee.drawable;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {

    /* renamed from: d, reason: collision with root package name */
    public final Type f17351d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f17352e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f17353f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f17354g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f17355h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17356i;

    /* renamed from: j, reason: collision with root package name */
    public float f17357j;

    /* renamed from: k, reason: collision with root package name */
    public int f17358k;

    /* renamed from: l, reason: collision with root package name */
    public int f17359l;

    /* renamed from: m, reason: collision with root package name */
    public float f17360m;
    public boolean n;
    public final Path o;
    public final Path p;
    public final RectF q;

    /* renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17361a;

        static {
            int[] iArr = new int[Type.values().length];
            f17361a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17361a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f17362a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f17363b;

        static {
            Type type = new Type("OVERLAY_COLOR", 0);
            f17362a = type;
            f17363b = new Type[]{type, new Type("CLIPPING", 1)};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f17363b.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornersDrawable(Drawable drawable) {
        super(drawable);
        drawable.getClass();
        this.f17351d = Type.f17362a;
        this.f17352e = new RectF();
        this.f17353f = new float[8];
        this.f17354g = new float[8];
        this.f17355h = new Paint(1);
        this.f17356i = false;
        this.f17357j = 0.0f;
        this.f17358k = 0;
        this.f17359l = 0;
        this.f17360m = 0.0f;
        this.n = false;
        this.o = new Path();
        this.p = new Path();
        this.q = new RectF();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b(boolean z) {
        this.f17356i = z;
        v();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void c(float f2, int i2) {
        this.f17358k = i2;
        this.f17357j = f2;
        v();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r12) {
        /*
            r11 = this;
            android.graphics.RectF r0 = r11.f17352e
            android.graphics.Rect r1 = r11.getBounds()
            r0.set(r1)
            com.facebook.drawee.drawable.RoundedCornersDrawable$Type r1 = r11.f17351d
            int r1 = r1.ordinal()
            android.graphics.Path r2 = r11.o
            android.graphics.Paint r8 = r11.f17355h
            if (r1 == 0) goto L29
            r0 = 1
            if (r1 == r0) goto L1b
        L18:
            r3 = r12
            goto La0
        L1b:
            int r0 = r12.save()
            r12.clipPath(r2)
            super.draw(r12)
            r12.restoreToCount(r0)
            goto L18
        L29:
            super.draw(r12)
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r8.setStyle(r1)
            int r1 = r11.f17359l
            r8.setColor(r1)
            r1 = 0
            r8.setStrokeWidth(r1)
            boolean r3 = r11.n
            r8.setFilterBitmap(r3)
            android.graphics.Path$FillType r3 = android.graphics.Path.FillType.EVEN_ODD
            r2.setFillType(r3)
            r12.drawPath(r2, r8)
            boolean r3 = r11.f17356i
            if (r3 == 0) goto L18
            float r3 = r0.width()
            float r4 = r0.height()
            float r3 = r3 - r4
            float r4 = r11.f17357j
            float r3 = r3 + r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r9 = r3 / r4
            float r3 = r0.height()
            float r5 = r0.width()
            float r3 = r3 - r5
            float r5 = r11.f17357j
            float r3 = r3 + r5
            float r10 = r3 / r4
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L85
            float r4 = r0.left
            float r5 = r0.top
            float r6 = r4 + r9
            float r7 = r0.bottom
            r3 = r12
            r3.drawRect(r4, r5, r6, r7, r8)
            float r6 = r0.right
            float r4 = r6 - r9
            float r5 = r0.top
            float r7 = r0.bottom
            r3.drawRect(r4, r5, r6, r7, r8)
            goto L86
        L85:
            r3 = r12
        L86:
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 <= 0) goto La0
            float r4 = r0.left
            float r5 = r0.top
            float r6 = r0.right
            float r7 = r5 + r10
            r3.drawRect(r4, r5, r6, r7, r8)
            float r4 = r0.left
            float r7 = r0.bottom
            float r5 = r7 - r10
            float r6 = r0.right
            r3.drawRect(r4, r5, r6, r7, r8)
        La0:
            int r12 = r11.f17358k
            if (r12 == 0) goto Lbd
            android.graphics.Paint$Style r12 = android.graphics.Paint.Style.STROKE
            r8.setStyle(r12)
            int r12 = r11.f17358k
            r8.setColor(r12)
            float r12 = r11.f17357j
            r8.setStrokeWidth(r12)
            android.graphics.Path$FillType r12 = android.graphics.Path.FillType.EVEN_ODD
            r2.setFillType(r12)
            android.graphics.Path r12 = r11.p
            r3.drawPath(r12, r8)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.RoundedCornersDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void h(float f2) {
        this.f17360m = f2;
        v();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void k() {
        Arrays.fill(this.f17353f, 0.0f);
        v();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void m(boolean z) {
        if (this.n != z) {
            this.n = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        v();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void r() {
        v();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void s(float[] fArr) {
        float[] fArr2 = this.f17353f;
        if (fArr == null) {
            Arrays.fill(fArr2, 0.0f);
        } else {
            Preconditions.b(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, fArr2, 0, 8);
        }
        v();
        invalidateSelf();
    }

    public final void v() {
        float[] fArr;
        Path path = this.o;
        path.reset();
        Path path2 = this.p;
        path2.reset();
        RectF rectF = this.q;
        rectF.set(getBounds());
        float f2 = this.f17360m;
        rectF.inset(f2, f2);
        if (this.f17351d == Type.f17362a) {
            path.addRect(rectF, Path.Direction.CW);
        }
        boolean z = this.f17356i;
        float[] fArr2 = this.f17353f;
        if (z) {
            path.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
        } else {
            path.addRoundRect(rectF, fArr2, Path.Direction.CW);
        }
        float f3 = this.f17360m;
        rectF.inset(-f3, -f3);
        float f4 = this.f17357j;
        rectF.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.f17356i) {
            path2.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f17354g;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (fArr2[i2] + this.f17360m) - (this.f17357j / 2.0f);
                i2++;
            }
            path2.addRoundRect(rectF, fArr, Path.Direction.CW);
        }
        float f5 = this.f17357j;
        rectF.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void o() {
    }
}
