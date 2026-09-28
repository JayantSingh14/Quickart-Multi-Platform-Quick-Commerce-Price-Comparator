package androidx.media3.exoplayer.video.spherical;

import android.opengl.Matrix;
import androidx.media3.common.util.TimedValueQueue;

/* loaded from: classes3.dex */
final class FrameRotationQueue {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f8369a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f8370b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final TimedValueQueue f8371c = new TimedValueQueue();

    /* renamed from: d, reason: collision with root package name */
    public boolean f8372d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f2 = fArr2[10];
        float f3 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2));
        float f4 = fArr2[10] / fSqrt;
        fArr[0] = f4;
        float f5 = fArr2[8];
        fArr[2] = f5 / fSqrt;
        fArr[8] = (-f5) / fSqrt;
        fArr[10] = f4;
    }
}
