package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes4.dex */
public final class zzcfi extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcfg {
    public static final float[] B = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    public volatile boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final zzcfh f26072a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f26073b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f26074c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f26075d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f26076e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f26077f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f26078g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f26079h;

    /* renamed from: i, reason: collision with root package name */
    public float f26080i;

    /* renamed from: j, reason: collision with root package name */
    public float f26081j;

    /* renamed from: k, reason: collision with root package name */
    public float f26082k;

    /* renamed from: l, reason: collision with root package name */
    public int f26083l;

    /* renamed from: m, reason: collision with root package name */
    public int f26084m;
    public SurfaceTexture n;
    public SurfaceTexture o;
    public int p;
    public int q;
    public int r;
    public final FloatBuffer s;
    public final CountDownLatch t;
    public final Object u;
    public EGL10 v;
    public EGLDisplay w;
    public EGLContext x;
    public EGLSurface y;
    public volatile boolean z;

    public zzcfi(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = B;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.s = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f26073b = new float[9];
        this.f26074c = new float[9];
        this.f26075d = new float[9];
        this.f26076e = new float[9];
        this.f26077f = new float[9];
        this.f26078g = new float[9];
        this.f26079h = new float[9];
        this.f26080i = Float.NaN;
        zzcfh zzcfhVar = new zzcfh(context);
        this.f26072a = zzcfhVar;
        zzcfhVar.f26071h = this;
        this.t = new CountDownLatch(1);
        this.u = new Object();
    }

    public static final void e(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            StringBuilder sb = new StringBuilder(str.length() + 10 + String.valueOf(iGlGetError).length());
            sb.append(str);
            sb.append(": glError ");
            sb.append(iGlGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    public static final void f(float[] fArr, float[] fArr2, float[] fArr3) {
        float f2 = fArr2[0] * fArr3[0];
        float f3 = fArr2[1];
        float f4 = fArr3[3];
        float f5 = fArr2[2];
        float f6 = fArr3[6];
        fArr[0] = f2 + (f3 * f4) + (f5 * f6);
        float f7 = fArr2[0];
        float f8 = fArr3[1] * f7;
        float f9 = fArr3[4];
        float f10 = fArr3[7];
        fArr[1] = f8 + (f3 * f9) + (f5 * f10);
        float f11 = f7 * fArr3[2];
        float f12 = fArr2[1];
        float f13 = fArr3[5];
        float f14 = fArr3[8];
        fArr[2] = f11 + (f12 * f13) + (f5 * f14);
        float f15 = fArr2[3];
        float f16 = fArr3[0];
        float f17 = fArr2[4];
        float f18 = fArr2[5];
        fArr[3] = (f15 * f16) + (f4 * f17) + (f18 * f6);
        float f19 = fArr2[3];
        float f20 = fArr3[1];
        fArr[4] = (f19 * f20) + (f17 * f9) + (f18 * f10);
        float f21 = fArr3[2];
        fArr[5] = (f19 * f21) + (fArr2[4] * f13) + (f18 * f14);
        float f22 = fArr2[6] * f16;
        float f23 = fArr2[7];
        float f24 = fArr3[3] * f23;
        float f25 = fArr2[8];
        fArr[6] = f22 + f24 + (f6 * f25);
        float f26 = fArr2[6];
        float f27 = f10 * f25;
        fArr[7] = f27 + (f23 * fArr3[4]) + (f20 * f26);
        fArr[8] = (f26 * f21) + (fArr2[7] * fArr3[5]) + (f25 * f14);
    }

    public static final void g(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }

    public static final void h(float[] fArr, float f2) {
        double d2 = f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    public static final int i(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        e("createShader");
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            e("shaderSource");
            GLES20.glCompileShader(iGlCreateShader);
            e("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            e("getShaderiv");
            if (iArr[0] == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 26);
                sb.append("Could not compile shader ");
                sb.append(i2);
                sb.append(":");
                Log.e("SphericalVideoRenderer", sb.toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                e("deleteShader");
                return 0;
            }
        }
        return iGlCreateShader;
    }

    public final void a(int i2, int i3) {
        Object obj = this.u;
        synchronized (obj) {
            this.f26084m = i2;
            this.f26083l = i3;
            this.z = true;
            obj.notifyAll();
        }
    }

    public final void b() {
        Object obj = this.u;
        synchronized (obj) {
            this.A = true;
            this.o = null;
            obj.notifyAll();
        }
    }

    public final void c(float f2, float f3) {
        int i2 = this.f26084m;
        int i3 = this.f26083l;
        if (i2 <= i3) {
            i2 = i3;
        }
        float f4 = i2;
        this.f26081j -= (f2 * 1.7453293f) / f4;
        float f5 = this.f26082k - ((f3 * 1.7453293f) / f4);
        this.f26082k = f5;
        if (f5 < -1.5707964f) {
            this.f26082k = -1.5707964f;
            f5 = -1.5707964f;
        }
        if (f5 > 1.5707964f) {
            this.f26082k = 1.5707964f;
        }
    }

    public final void d() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.y;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            this.v.eglMakeCurrent(this.w, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.v.eglDestroySurface(this.w, this.y);
            this.y = null;
        }
        EGLContext eGLContext = this.x;
        if (eGLContext != null) {
            this.v.eglDestroyContext(this.w, eGLContext);
            this.x = null;
        }
        EGLDisplay eGLDisplay = this.w;
        if (eGLDisplay != null) {
            this.v.eglTerminate(eGLDisplay);
            this.w = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.r++;
        Object obj = this.u;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0027  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfi.run():void");
    }
}
