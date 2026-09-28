package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ShapePath {

    /* renamed from: a, reason: collision with root package name */
    public float f41049a;

    /* renamed from: b, reason: collision with root package name */
    public float f41050b;

    /* renamed from: c, reason: collision with root package name */
    public float f41051c;

    /* renamed from: d, reason: collision with root package name */
    public float f41052d;

    /* renamed from: e, reason: collision with root package name */
    public float f41053e;

    /* renamed from: f, reason: collision with root package name */
    public float f41054f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f41055g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f41056h = new ArrayList();

    public static class ArcShadowOperation extends ShadowCompatOperation {

        /* renamed from: c, reason: collision with root package name */
        public final PathArcOperation f41059c;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.f41059c = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            PathArcOperation pathArcOperation = this.f41059c;
            shadowRenderer.a(canvas, matrix, new RectF(pathArcOperation.f41068b, pathArcOperation.f41069c, pathArcOperation.f41070d, pathArcOperation.f41071e), i2, pathArcOperation.f41072f, pathArcOperation.f41073g);
        }
    }

    public static class InnerCornerShadowOperation extends ShadowCompatOperation {

        /* renamed from: c, reason: collision with root package name */
        public final PathLineOperation f41060c;

        /* renamed from: d, reason: collision with root package name */
        public final PathLineOperation f41061d;

        /* renamed from: e, reason: collision with root package name */
        public final float f41062e;

        /* renamed from: f, reason: collision with root package name */
        public final float f41063f;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f2, float f3) {
            this.f41060c = pathLineOperation;
            this.f41061d = pathLineOperation2;
            this.f41062e = f2;
            this.f41063f = f3;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            double d2;
            float f2;
            float f3;
            Canvas canvas2;
            float f4;
            int i3;
            ShadowRenderer shadowRenderer2;
            float fB = ((b() - c()) + 360.0f) % 360.0f;
            if (fB > 180.0f) {
                fB -= 360.0f;
            }
            if (fB > 0.0f) {
                return;
            }
            PathLineOperation pathLineOperation = this.f41060c;
            float f5 = pathLineOperation.f41074b;
            float f6 = this.f41062e;
            double d3 = f5 - f6;
            float f7 = pathLineOperation.f41075c;
            float f8 = this.f41063f;
            double dHypot = Math.hypot(d3, f7 - f8);
            PathLineOperation pathLineOperation2 = this.f41061d;
            double dHypot2 = Math.hypot(pathLineOperation2.f41074b - pathLineOperation.f41074b, pathLineOperation2.f41075c - pathLineOperation.f41075c);
            float fMin = (float) Math.min(i2, Math.min(dHypot, dHypot2));
            double d4 = fMin;
            float f9 = -fB;
            float f10 = fB;
            double dTan = Math.tan(Math.toRadians(f9 / 2.0f)) * d4;
            Matrix matrix2 = this.f41078a;
            if (dHypot > dTan) {
                d2 = d4;
                f2 = 0.0f;
                RectF rectF = new RectF(0.0f, 0.0f, (float) (dHypot - dTan), 0.0f);
                matrix2.set(matrix);
                matrix2.preTranslate(f6, f8);
                matrix2.preRotate(c());
                shadowRenderer.b(canvas, matrix2, rectF, i2);
            } else {
                d2 = d4;
                f2 = 0.0f;
            }
            float f11 = fMin * 2.0f;
            RectF rectF2 = new RectF(f2, f2, f11, f11);
            matrix2.set(matrix);
            matrix2.preTranslate(pathLineOperation.f41074b, pathLineOperation.f41075c);
            matrix2.preRotate(c());
            matrix2.preTranslate((float) ((-dTan) - d2), (-2.0f) * fMin);
            int i4 = (int) fMin;
            float[] fArr = {(float) (d2 + dTan), f11};
            shadowRenderer.getClass();
            if (fB > 0.0f) {
                f3 = f9;
                canvas2 = canvas;
                f4 = 450.0f + f10;
                shadowRenderer2 = shadowRenderer;
                i3 = i4;
            } else {
                f3 = f10;
                canvas2 = canvas;
                f4 = 450.0f;
                i3 = i4;
                shadowRenderer2 = shadowRenderer;
            }
            shadowRenderer2.a(canvas2, matrix2, rectF2, i3, f4, f3);
            Path path = shadowRenderer2.f40966g;
            path.rewind();
            path.moveTo(fArr[0], fArr[1]);
            path.arcTo(rectF2, f4, f3);
            path.close();
            canvas2.save();
            canvas2.concat(matrix2);
            canvas2.scale(1.0f, rectF2.height() / rectF2.width());
            canvas2.drawPath(path, shadowRenderer2.f40967h);
            canvas2.drawPath(path, shadowRenderer2.f40960a);
            canvas2.restore();
            if (dHypot2 > dTan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (dHypot2 - dTan), 0.0f);
                matrix2.set(matrix);
                matrix2.preTranslate(pathLineOperation.f41074b, pathLineOperation.f41075c);
                matrix2.preRotate(b());
                matrix2.preTranslate((float) dTan, 0.0f);
                shadowRenderer2.b(canvas2, matrix2, rectF3, i2);
            }
        }

        public final float b() {
            float f2 = this.f41061d.f41075c;
            PathLineOperation pathLineOperation = this.f41060c;
            return (float) Math.toDegrees(Math.atan((f2 - pathLineOperation.f41075c) / (r0.f41074b - pathLineOperation.f41074b)));
        }

        public final float c() {
            PathLineOperation pathLineOperation = this.f41060c;
            return (float) Math.toDegrees(Math.atan((pathLineOperation.f41075c - this.f41063f) / (pathLineOperation.f41074b - this.f41062e)));
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {

        /* renamed from: c, reason: collision with root package name */
        public final PathLineOperation f41064c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41065d;

        /* renamed from: e, reason: collision with root package name */
        public final float f41066e;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f2, float f3) {
            this.f41064c = pathLineOperation;
            this.f41065d = f2;
            this.f41066e = f3;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            PathLineOperation pathLineOperation = this.f41064c;
            float f2 = pathLineOperation.f41075c;
            float f3 = this.f41066e;
            float f4 = pathLineOperation.f41074b;
            float f5 = this.f41065d;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f2 - f3, f4 - f5), 0.0f);
            Matrix matrix2 = this.f41078a;
            matrix2.set(matrix);
            matrix2.preTranslate(f5, f3);
            matrix2.preRotate(b());
            shadowRenderer.b(canvas, matrix2, rectF, i2);
        }

        public final float b() {
            PathLineOperation pathLineOperation = this.f41064c;
            return (float) Math.toDegrees(Math.atan((pathLineOperation.f41075c - this.f41066e) / (pathLineOperation.f41074b - this.f41065d)));
        }
    }

    public static class PathArcOperation extends PathOperation {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f41067h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final float f41068b;

        /* renamed from: c, reason: collision with root package name */
        public final float f41069c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41070d;

        /* renamed from: e, reason: collision with root package name */
        public final float f41071e;

        /* renamed from: f, reason: collision with root package name */
        public float f41072f;

        /* renamed from: g, reason: collision with root package name */
        public float f41073g;

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            this.f41068b = f2;
            this.f41069c = f3;
            this.f41070d = f4;
            this.f41071e = f5;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f41076a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f41067h;
            rectF.set(this.f41068b, this.f41069c, this.f41070d, this.f41071e);
            path.arcTo(rectF, this.f41072f, this.f41073g, false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f41076a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* renamed from: b, reason: collision with root package name */
        public float f41074b;

        /* renamed from: c, reason: collision with root package name */
        public float f41075c;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f41076a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f41074b, this.f41075c);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f41076a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f41076a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(0.0f, 0.0f, 0.0f, 0.0f);
            path.transform(matrix);
        }
    }

    public static abstract class ShadowCompatOperation {

        /* renamed from: b, reason: collision with root package name */
        public static final Matrix f41077b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f41078a = new Matrix();

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas);
    }

    public ShapePath() {
        f(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
        pathArcOperation.f41072f = f6;
        pathArcOperation.f41073g = f7;
        this.f41055g.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.f41056h.add(arcShadowOperation);
        this.f41053e = f9;
        double d2 = f8;
        this.f41051c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f41052d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.f41053e;
        if (f3 == f2) {
            return;
        }
        float f4 = ((f2 - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f41051c;
        float f6 = this.f41052d;
        PathArcOperation pathArcOperation = new PathArcOperation(f5, f6, f5, f6);
        pathArcOperation.f41072f = this.f41053e;
        pathArcOperation.f41073g = f4;
        this.f41056h.add(new ArcShadowOperation(pathArcOperation));
        this.f41053e = f2;
    }

    public final void c(Matrix matrix, Path path) {
        ArrayList arrayList = this.f41055g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((PathOperation) arrayList.get(i2)).a(matrix, path);
        }
    }

    public final void d(float f2, float f3) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f41074b = f2;
        pathLineOperation.f41075c = f3;
        this.f41055g.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, this.f41051c, this.f41052d);
        float fB = lineShadowOperation.b() + 270.0f;
        float fB2 = lineShadowOperation.b() + 270.0f;
        b(fB);
        this.f41056h.add(lineShadowOperation);
        this.f41053e = fB2;
        this.f41051c = f2;
        this.f41052d = f3;
    }

    public final void e(float f2, float f3, float f4) {
        if ((Math.abs(f2 - this.f41051c) < 0.001f && Math.abs(0.0f - this.f41052d) < 0.001f) || (Math.abs(f2 - f3) < 0.001f && Math.abs(0.0f - f4) < 0.001f)) {
            d(f3, f4);
            return;
        }
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f41074b = f2;
        pathLineOperation.f41075c = 0.0f;
        ArrayList arrayList = this.f41055g;
        arrayList.add(pathLineOperation);
        PathLineOperation pathLineOperation2 = new PathLineOperation();
        pathLineOperation2.f41074b = f3;
        pathLineOperation2.f41075c = f4;
        arrayList.add(pathLineOperation2);
        InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, this.f41051c, this.f41052d);
        float fB = ((innerCornerShadowOperation.b() - innerCornerShadowOperation.c()) + 360.0f) % 360.0f;
        if (fB > 180.0f) {
            fB -= 360.0f;
        }
        if (fB > 0.0f) {
            d(f2, 0.0f);
            d(f3, f4);
            return;
        }
        float fC = innerCornerShadowOperation.c() + 270.0f;
        float fB2 = innerCornerShadowOperation.b() + 270.0f;
        b(fC);
        this.f41056h.add(innerCornerShadowOperation);
        this.f41053e = fB2;
        this.f41051c = f3;
        this.f41052d = f4;
    }

    public final void f(float f2, float f3, float f4, float f5) {
        this.f41049a = f2;
        this.f41050b = f3;
        this.f41051c = f2;
        this.f41052d = f3;
        this.f41053e = f4;
        this.f41054f = (f4 + f5) % 360.0f;
        this.f41055g.clear();
        this.f41056h.clear();
    }
}
