package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* loaded from: classes3.dex */
final class SubtitlePainter {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a, reason: collision with root package name */
    public final float f10946a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10947b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10948c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10949d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10950e;

    /* renamed from: f, reason: collision with root package name */
    public final TextPaint f10951f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f10952g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f10953h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f10954i;

    /* renamed from: j, reason: collision with root package name */
    public Layout.Alignment f10955j;

    /* renamed from: k, reason: collision with root package name */
    public Bitmap f10956k;

    /* renamed from: l, reason: collision with root package name */
    public float f10957l;

    /* renamed from: m, reason: collision with root package name */
    public int f10958m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public SubtitlePainter(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{android.R.attr.lineSpacingExtra, android.R.attr.lineSpacingMultiplier}, 0, 0);
        this.f10950e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f10949d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f10946a = fRound;
        this.f10947b = fRound;
        this.f10948c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f10951f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f10952g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f10953h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z) {
        Canvas canvas2;
        if (!z) {
            this.J.getClass();
            this.f10956k.getClass();
            canvas.drawBitmap(this.f10956k, (Rect) null, this.J, this.f10953h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.u) > 0) {
            Paint paint = this.f10952g;
            paint.setColor(this.u);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i2 = this.w;
        TextPaint textPaint = this.f10951f;
        if (i2 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f10946a);
            textPaint.setColor(this.v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f2 = this.f10947b;
            if (i2 == 2) {
                float f3 = this.f10948c;
                textPaint.setShadowLayer(f2, f3, f3, this.v);
            } else if (i2 == 3 || i2 == 4) {
                boolean z2 = i2 == 3;
                int i3 = z2 ? -1 : this.v;
                int i4 = z2 ? this.v : -1;
                float f4 = f2 / 2.0f;
                textPaint.setColor(this.s);
                textPaint.setStyle(Paint.Style.FILL);
                float f5 = -f4;
                textPaint.setShadowLayer(f2, f5, f5, i3);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f2, f4, f4, i4);
            }
        }
        textPaint.setColor(this.s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }
}
