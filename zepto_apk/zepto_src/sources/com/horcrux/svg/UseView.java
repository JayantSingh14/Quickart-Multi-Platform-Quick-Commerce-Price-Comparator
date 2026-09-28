package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.common.logging.FLog;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class UseView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public String f45923a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45924b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45925c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45926d;

    /* renamed from: e, reason: collision with root package name */
    public SVGLength f45927e;

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
        Canvas canvas2;
        Paint paint2;
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f45923a);
        if (definedTemplate == null) {
            FLog.q("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f45923a + " is not defined.");
            return;
        }
        definedTemplate.clearCache();
        canvas.translate((float) relativeOnWidth(this.f45924b), (float) relativeOnHeight(this.f45925c));
        boolean z = definedTemplate instanceof RenderableView;
        if (z) {
            ((RenderableView) definedTemplate).mergeProperties(this);
        }
        int iSaveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas, this.mCTM);
        clip(canvas, paint);
        if (definedTemplate instanceof SymbolView) {
            canvas2 = canvas;
            paint2 = paint;
            ((SymbolView) definedTemplate).q(canvas2, paint2, f2, (float) relativeOnWidth(this.f45926d), (float) relativeOnHeight(this.f45927e));
        } else {
            canvas2 = canvas;
            paint2 = paint;
            definedTemplate.draw(canvas2, paint2, f2 * this.mOpacity);
        }
        RectF rectF = new RectF();
        getPath(canvas2, paint2).computeBounds(rectF, true);
        canvas2.getMatrix().mapRect(rectF);
        setClientRect(rectF);
        definedTemplate.restoreCanvas(canvas2, iSaveAndSetupCanvas);
        if (z) {
            ((RenderableView) definedTemplate).resetProperties();
        }
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f45923a);
        if (definedTemplate == null) {
            FLog.q("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f45923a + " is not defined.");
            return null;
        }
        Path path = definedTemplate.getPath(canvas, paint);
        Path path2 = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) relativeOnWidth(this.f45924b), (float) relativeOnHeight(this.f45925c));
        path.transform(matrix, path2);
        return path2;
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final int hitTest(float[] fArr) {
        if (this.mInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f45923a);
            if (definedTemplate == null) {
                FLog.q("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f45923a + " is not defined.");
                return -1;
            }
            int iHitTest = definedTemplate.hitTest(fArr2);
            if (iHitTest != -1) {
                return (definedTemplate.isResponsible() || iHitTest != definedTemplate.getId()) ? iHitTest : getId();
            }
        }
        return -1;
    }
}
