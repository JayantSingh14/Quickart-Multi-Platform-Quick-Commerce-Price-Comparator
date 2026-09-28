package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.RestrictTo;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class ShapeAppearancePathProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ShapePath[] f41031a = new ShapePath[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f41032b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f41033c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f41034d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f41035e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f41036f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final ShapePath f41037g = new ShapePath();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f41038h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f41039i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f41040j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f41041k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f41042l = true;

    public static class Lazy {

        /* renamed from: a, reason: collision with root package name */
        public static final ShapeAppearancePathProvider f41043a = new ShapeAppearancePathProvider();
    }

    @RestrictTo
    public interface PathListener {
    }

    public static final class ShapeAppearancePathSpec {

        /* renamed from: a, reason: collision with root package name */
        public final ShapeAppearanceModel f41044a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f41045b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f41046c;

        /* renamed from: d, reason: collision with root package name */
        public final PathListener f41047d;

        /* renamed from: e, reason: collision with root package name */
        public final float f41048e;

        public ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, Path path) {
            this.f41047d = pathListener;
            this.f41044a = shapeAppearanceModel;
            this.f41048e = f2;
            this.f41046c = rectF;
            this.f41045b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f41031a[i2] = new ShapePath();
            this.f41032b[i2] = new Matrix();
            this.f41033c[i2] = new Matrix();
        }
    }

    public static ShapeAppearancePathProvider b() {
        return Lazy.f41043a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    public final void a(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        ShapePath[] shapePathArr;
        int i2;
        int i3;
        float[] fArr;
        float f3;
        RectF rectF2;
        boolean z;
        ShapeAppearanceModel shapeAppearanceModel2;
        ShapeAppearancePathSpec shapeAppearancePathSpec;
        Matrix[] matrixArr3;
        Matrix[] matrixArr4;
        int i4;
        int i5;
        boolean z2;
        path.rewind();
        Path path2 = this.f41035e;
        path2.rewind();
        Path path3 = this.f41036f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec2 = new ShapeAppearancePathSpec(shapeAppearanceModel, f2, rectF, pathListener, path);
        int i6 = 0;
        while (true) {
            matrixArr = this.f41033c;
            matrixArr2 = this.f41032b;
            shapePathArr = this.f41031a;
            i2 = 1;
            fArr = this.f41038h;
            f3 = shapeAppearancePathSpec2.f41048e;
            rectF2 = shapeAppearancePathSpec2.f41046c;
            z = 0;
            shapeAppearanceModel2 = shapeAppearancePathSpec2.f41044a;
            if (i6 >= 4) {
                break;
            }
            CornerSize cornerSize = i6 != 1 ? i6 != 2 ? i6 != 3 ? shapeAppearanceModel2.f41012f : shapeAppearanceModel2.f41011e : shapeAppearanceModel2.f41014h : shapeAppearanceModel2.f41013g;
            CornerTreatment cornerTreatment = i6 != 1 ? i6 != 2 ? i6 != 3 ? shapeAppearanceModel2.f41008b : shapeAppearanceModel2.f41007a : shapeAppearanceModel2.f41010d : shapeAppearanceModel2.f41009c;
            ShapePath shapePath = shapePathArr[i6];
            cornerTreatment.getClass();
            cornerTreatment.a(shapePath, f3, cornerSize.a(rectF2));
            int i7 = i6 + 1;
            float f4 = (i7 % 4) * 90;
            matrixArr2[i6].reset();
            PointF pointF = this.f41034d;
            if (i6 == 1) {
                pointF.set(rectF2.right, rectF2.bottom);
            } else if (i6 == 2) {
                pointF.set(rectF2.left, rectF2.bottom);
            } else if (i6 != 3) {
                pointF.set(rectF2.right, rectF2.top);
            } else {
                pointF.set(rectF2.left, rectF2.top);
            }
            matrixArr2[i6].setTranslate(pointF.x, pointF.y);
            matrixArr2[i6].preRotate(f4);
            ShapePath shapePath2 = shapePathArr[i6];
            fArr[0] = shapePath2.f41051c;
            fArr[1] = shapePath2.f41052d;
            matrixArr2[i6].mapPoints(fArr);
            matrixArr[i6].reset();
            matrixArr[i6].setTranslate(fArr[0], fArr[1]);
            matrixArr[i6].preRotate(f4);
            i6 = i7;
        }
        int i8 = 0;
        for (i3 = 4; i8 < i3; i3 = 4) {
            ShapePath shapePath3 = shapePathArr[i8];
            fArr[z] = shapePath3.f41049a;
            fArr[i2] = shapePath3.f41050b;
            matrixArr2[i8].mapPoints(fArr);
            Path path4 = shapeAppearancePathSpec2.f41045b;
            if (i8 == 0) {
                path4.moveTo(fArr[z], fArr[i2]);
            } else {
                path4.lineTo(fArr[z], fArr[i2]);
            }
            shapePathArr[i8].c(matrixArr2[i8], path4);
            PathListener pathListener2 = shapeAppearancePathSpec2.f41047d;
            if (pathListener2 != null) {
                ShapePath shapePath4 = shapePathArr[i8];
                i4 = i2;
                Matrix matrix = matrixArr2[i8];
                shapeAppearancePathSpec = shapeAppearancePathSpec2;
                MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.this;
                matrixArr3 = matrixArr;
                BitSet bitSet = materialShapeDrawable.f40977d;
                shapePath4.getClass();
                matrixArr4 = matrixArr2;
                bitSet.set(i8, z);
                shapePath4.b(shapePath4.f41054f);
                materialShapeDrawable.f40975b[i8] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1

                    /* renamed from: c */
                    public final /* synthetic */ ArrayList f41057c;

                    /* renamed from: d */
                    public final /* synthetic */ Matrix f41058d;

                    public AnonymousClass1(ArrayList arrayList, Matrix matrix2) {
                        arrayList = arrayList;
                        matrix = matrix2;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void a(Matrix matrix2, ShadowRenderer shadowRenderer, int i9, Canvas canvas) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ShadowCompatOperation) it.next()).a(matrix, shadowRenderer, i9, canvas);
                        }
                    }
                };
            } else {
                shapeAppearancePathSpec = shapeAppearancePathSpec2;
                matrixArr3 = matrixArr;
                matrixArr4 = matrixArr2;
                i4 = i2;
            }
            int i9 = i8 + 1;
            int i10 = i9 % 4;
            ShapePath shapePath5 = shapePathArr[i8];
            fArr[0] = shapePath5.f41051c;
            fArr[i4] = shapePath5.f41052d;
            matrixArr4[i8].mapPoints(fArr);
            ShapePath shapePath6 = shapePathArr[i10];
            float f5 = shapePath6.f41049a;
            float[] fArr2 = this.f41039i;
            fArr2[0] = f5;
            fArr2[i4] = shapePath6.f41050b;
            matrixArr4[i10].mapPoints(fArr2);
            ShapePath[] shapePathArr2 = shapePathArr;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[i4] - fArr2[i4])) - 0.001f, 0.0f);
            ShapePath shapePath7 = shapePathArr2[i8];
            fArr[0] = shapePath7.f41051c;
            fArr[i4] = shapePath7.f41052d;
            matrixArr4[i8].mapPoints(fArr);
            int i11 = i4;
            float fAbs = (i8 == i11 || i8 == 3) ? Math.abs(rectF2.centerX() - fArr[0]) : Math.abs(rectF2.centerY() - fArr[i11]);
            ShapePath shapePath8 = this.f41037g;
            shapePath8.f(0.0f, 0.0f, 270.0f, 0.0f);
            EdgeTreatment edgeTreatment = i8 != 1 ? i8 != 2 ? i8 != 3 ? shapeAppearanceModel2.f41016j : shapeAppearanceModel2.f41015i : shapeAppearanceModel2.f41018l : shapeAppearanceModel2.f41017k;
            edgeTreatment.b(fMax, fAbs, f3, shapePath8);
            Path path5 = this.f41040j;
            path5.reset();
            shapePath8.c(matrixArr3[i8], path5);
            if (this.f41042l && (edgeTreatment.a() || c(path5, i8) || c(path5, i10))) {
                path5.op(path5, path3, Path.Op.DIFFERENCE);
                fArr[0] = shapePath8.f41049a;
                i5 = 1;
                fArr[1] = shapePath8.f41050b;
                matrixArr3[i8].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                shapePath8.c(matrixArr3[i8], path2);
            } else {
                i5 = 1;
                shapePath8.c(matrixArr3[i8], path4);
            }
            if (pathListener2 != null) {
                Matrix matrix2 = matrixArr3[i8];
                MaterialShapeDrawable materialShapeDrawable2 = MaterialShapeDrawable.this;
                z2 = false;
                materialShapeDrawable2.f40977d.set(i8 + 4, false);
                shapePath8.b(shapePath8.f41054f);
                materialShapeDrawable2.f40976c[i8] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1

                    /* renamed from: c */
                    public final /* synthetic */ ArrayList f41057c;

                    /* renamed from: d */
                    public final /* synthetic */ Matrix f41058d;

                    public AnonymousClass1(ArrayList arrayList, Matrix matrix22) {
                        arrayList = arrayList;
                        matrix = matrix22;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void a(Matrix matrix22, ShadowRenderer shadowRenderer, int i92, Canvas canvas) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ShadowCompatOperation) it.next()).a(matrix, shadowRenderer, i92, canvas);
                        }
                    }
                };
            } else {
                z2 = false;
            }
            z = z2;
            i2 = i5;
            shapeAppearancePathSpec2 = shapeAppearancePathSpec;
            matrixArr = matrixArr3;
            matrixArr2 = matrixArr4;
            shapePathArr = shapePathArr2;
            i8 = i9;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean c(Path path, int i2) {
        Path path2 = this.f41041k;
        path2.reset();
        this.f41031a[i2].c(this.f41032b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
