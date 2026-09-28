package com.airbnb.lottie.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Utils {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f14810a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f14811b = new AnonymousClass2();

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadLocal f14812c = new AnonymousClass3();

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f14813d = new AnonymousClass4();

    /* renamed from: e, reason: collision with root package name */
    public static final float f14814e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: com.airbnb.lottie.utils.Utils$1, reason: invalid class name */
    public class AnonymousClass1 extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        public final PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$2, reason: invalid class name */
    public class AnonymousClass2 extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$3, reason: invalid class name */
    public class AnonymousClass3 extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$4, reason: invalid class name */
    public class AnonymousClass4 extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        public final float[] initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f2, float f3, float f4) {
        NetworkFetcher networkFetcher = L.f14106a;
        PathMeasure pathMeasure = (PathMeasure) f14810a.get();
        Path path2 = (Path) f14811b.get();
        Path path3 = (Path) f14812c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (!(f2 == 1.0f && f3 == 0.0f) && length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float fMin = Math.min(f5, f6) + f7;
            float fMax = Math.max(f5, f6) + f7;
            if (fMin >= length && fMax >= length) {
                fMin = MiscUtils.c(fMin, length);
                fMax = MiscUtils.c(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = MiscUtils.c(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = MiscUtils.c(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
        }
    }

    public static void b(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static Bitmap d(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void e(Canvas canvas, Paint paint, RectF rectF) {
        NetworkFetcher networkFetcher = L.f14106a;
        canvas.saveLayer(rectF, paint);
    }
}
