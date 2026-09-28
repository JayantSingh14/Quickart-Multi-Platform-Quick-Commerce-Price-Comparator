package com.google.android.material.tooltip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

@RestrictTo
/* loaded from: classes4.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final /* synthetic */ int Y = 0;
    public final Paint.FontMetrics A;
    public final TextDrawableHelper B;
    public final View.OnLayoutChangeListener C;
    public final Rect D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public int J;
    public int K;
    public float L;
    public float M;
    public float Q;
    public float X;
    public CharSequence y;
    public final Context z;

    public TooltipDrawable(Context context, int i2) {
        super(context, null, 0, i2);
        this.A = new Paint.FontMetrics();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.B = textDrawableHelper;
        this.C = new View.OnLayoutChangeListener() { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                int i11 = TooltipDrawable.Y;
                TooltipDrawable tooltipDrawable = TooltipDrawable.this;
                tooltipDrawable.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                tooltipDrawable.K = iArr[0];
                view.getWindowVisibleDisplayFrame(tooltipDrawable.D);
            }
        };
        this.D = new Rect();
        this.L = 1.0f;
        this.M = 1.0f;
        this.Q = 0.5f;
        this.X = 1.0f;
        this.z = context;
        TextPaint textPaint = textDrawableHelper.f40640a;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float fY = y();
        float f2 = (float) (-((Math.sqrt(2.0d) * this.J) - this.J));
        canvas.scale(this.L, this.M, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.Q) + getBounds().top);
        canvas.translate(fY, f2);
        super.draw(canvas);
        if (this.y == null) {
            canvas2 = canvas;
        } else {
            float fCenterY = getBounds().centerY();
            TextDrawableHelper textDrawableHelper = this.B;
            TextPaint textPaint = textDrawableHelper.f40640a;
            Paint.FontMetrics fontMetrics = this.A;
            textPaint.getFontMetrics(fontMetrics);
            int i2 = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            TextAppearance textAppearance = textDrawableHelper.f40646g;
            TextPaint textPaint2 = textDrawableHelper.f40640a;
            if (textAppearance != null) {
                textPaint2.drawableState = getState();
                textDrawableHelper.f40646g.e(this.z, textPaint2, textDrawableHelper.f40641b);
                textPaint2.setAlpha((int) (this.X * 255.0f));
            }
            CharSequence charSequence = this.y;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i2, textPaint2);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.B.f40640a.getTextSize(), this.G);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f2 = this.E * 2;
        CharSequence charSequence = this.y;
        return (int) Math.max(f2 + (charSequence == null ? 0.0f : this.B.a(charSequence.toString())), this.F);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.I) {
            ShapeAppearanceModel.Builder builderG = this.f40974a.f40989a.g();
            builderG.f41029k = z();
            setShapeAppearanceModel(builderG.a());
        }
    }

    public final float y() {
        int i2;
        Rect rect = this.D;
        if (((rect.right - getBounds().right) - this.K) - this.H < 0) {
            i2 = ((rect.right - getBounds().right) - this.K) - this.H;
        } else {
            if (((rect.left - getBounds().left) - this.K) + this.H <= 0) {
                return 0.0f;
            }
            i2 = ((rect.left - getBounds().left) - this.K) + this.H;
        }
        return i2;
    }

    public final OffsetEdgeTreatment z() {
        float f2 = -y();
        float fWidth = ((float) (getBounds().width() - (Math.sqrt(2.0d) * this.J))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.J), Math.min(Math.max(f2, -fWidth), fWidth));
    }
}
