package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlaceholderSurface extends Surface {

    /* renamed from: d, reason: collision with root package name */
    public static int f8279d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8280e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8281a;

    /* renamed from: b, reason: collision with root package name */
    public final PlaceholderSurfaceThread f8282b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8283c;

    public static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public EGLSurfaceTexture f8284a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f8285b;

        /* renamed from: c, reason: collision with root package name */
        public Error f8286c;

        /* renamed from: d, reason: collision with root package name */
        public RuntimeException f8287d;

        /* renamed from: e, reason: collision with root package name */
        public PlaceholderSurface f8288e;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public final void a(int i2) throws GlUtil.GlException {
            EGLSurface eGLSurfaceEglCreatePbufferSurface;
            this.f8284a.getClass();
            EGLSurfaceTexture eGLSurfaceTexture = this.f8284a;
            eGLSurfaceTexture.getClass();
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.c("eglGetDisplay failed", eGLDisplayEglGetDisplay != null);
            int[] iArr = new int[2];
            GlUtil.c("eglInitialize failed", EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1));
            eGLSurfaceTexture.f5678c = eGLDisplayEglGetDisplay;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, EGLSurfaceTexture.f5675g, 0, eGLConfigArr, 0, 1, iArr2, 0);
            boolean z = zEglChooseConfig && iArr2[0] > 0 && eGLConfigArr[0] != null;
            Object[] objArr = {Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]};
            int i3 = Util.f5744a;
            GlUtil.c(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr), z);
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLSurfaceTexture.f5678c, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            GlUtil.c("eglCreateContext failed", eGLContextEglCreateContext != null);
            eGLSurfaceTexture.f5679d = eGLContextEglCreateContext;
            EGLDisplay eGLDisplay = eGLSurfaceTexture.f5678c;
            if (i2 == 1) {
                eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
            } else {
                eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                GlUtil.c("eglCreatePbufferSurface failed", eGLSurfaceEglCreatePbufferSurface != null);
            }
            GlUtil.c("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext));
            eGLSurfaceTexture.f5680e = eGLSurfaceEglCreatePbufferSurface;
            int[] iArr3 = eGLSurfaceTexture.f5677b;
            GLES20.glGenTextures(1, iArr3, 0);
            GlUtil.b();
            SurfaceTexture surfaceTexture = new SurfaceTexture(iArr3[0]);
            eGLSurfaceTexture.f5681f = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(eGLSurfaceTexture);
            SurfaceTexture surfaceTexture2 = this.f8284a.f5681f;
            surfaceTexture2.getClass();
            this.f8288e = new PlaceholderSurface(this, surfaceTexture2, i2 != 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            this.f8284a.getClass();
            EGLSurfaceTexture eGLSurfaceTexture = this.f8284a;
            eGLSurfaceTexture.f5676a.removeCallbacks(eGLSurfaceTexture);
            try {
                SurfaceTexture surfaceTexture = eGLSurfaceTexture.f5681f;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, eGLSurfaceTexture.f5677b, 0);
                }
            } finally {
                EGLDisplay eGLDisplay = eGLSurfaceTexture.f5678c;
                if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGLDisplay eGLDisplay2 = eGLSurfaceTexture.f5678c;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                }
                EGLSurface eGLSurface2 = eGLSurfaceTexture.f5680e;
                if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface(eGLSurfaceTexture.f5678c, eGLSurfaceTexture.f5680e);
                }
                EGLContext eGLContext = eGLSurfaceTexture.f5679d;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLSurfaceTexture.f5678c, eGLContext);
                }
                EGL14.eglReleaseThread();
                EGLDisplay eGLDisplay3 = eGLSurfaceTexture.f5678c;
                if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglTerminate(eGLSurfaceTexture.f5678c);
                }
                eGLSurfaceTexture.f5678c = null;
                eGLSurfaceTexture.f5679d = null;
                eGLSurfaceTexture.f5680e = null;
                eGLSurfaceTexture.f5681f = null;
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            try {
                if (i2 == 1) {
                    try {
                        a(message.arg1);
                        synchronized (this) {
                            notify();
                        }
                        return true;
                    } catch (GlUtil.GlException e2) {
                        Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                        this.f8287d = new IllegalStateException(e2);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e3) {
                        Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                        this.f8286c = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e4) {
                        Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                        this.f8287d = e4;
                        synchronized (this) {
                            notify();
                        }
                    }
                } else if (i2 == 2) {
                    try {
                        b();
                        return true;
                    } catch (Throwable th) {
                        try {
                            Log.e("PlaceholderSurface", "Failed to release placeholder surface", th);
                        } finally {
                            quit();
                        }
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }
    }

    public PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f8282b = placeholderSurfaceThread;
        this.f8281a = z;
    }

    public static synchronized boolean a(Context context) {
        String strEglQueryString;
        int i2;
        try {
            if (!f8280e) {
                int i3 = Util.f5744a;
                if (i3 >= 24 && ((i3 >= 26 || !("samsung".equals(Util.f5746c) || "XT1650".equals(Util.f5747d))) && ((i3 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content")))) {
                    String strEglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    i2 = strEglQueryString2 != null && strEglQueryString2.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
                } else {
                    i2 = 0;
                }
                f8279d = i2;
                f8280e = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8279d != 0;
    }

    public static PlaceholderSurface b(Context context, boolean z) {
        boolean z2 = false;
        Assertions.g(!z || a(context));
        PlaceholderSurfaceThread placeholderSurfaceThread = new PlaceholderSurfaceThread();
        int i2 = z ? f8279d : 0;
        placeholderSurfaceThread.start();
        Handler handler = new Handler(placeholderSurfaceThread.getLooper(), placeholderSurfaceThread);
        placeholderSurfaceThread.f8285b = handler;
        placeholderSurfaceThread.f8284a = new EGLSurfaceTexture(handler);
        synchronized (placeholderSurfaceThread) {
            placeholderSurfaceThread.f8285b.obtainMessage(1, i2, 0).sendToTarget();
            while (placeholderSurfaceThread.f8288e == null && placeholderSurfaceThread.f8287d == null && placeholderSurfaceThread.f8286c == null) {
                try {
                    placeholderSurfaceThread.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = placeholderSurfaceThread.f8287d;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = placeholderSurfaceThread.f8286c;
        if (error != null) {
            throw error;
        }
        PlaceholderSurface placeholderSurface = placeholderSurfaceThread.f8288e;
        placeholderSurface.getClass();
        return placeholderSurface;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f8282b) {
            try {
                if (!this.f8283c) {
                    PlaceholderSurfaceThread placeholderSurfaceThread = this.f8282b;
                    placeholderSurfaceThread.f8285b.getClass();
                    placeholderSurfaceThread.f8285b.sendEmptyMessage(2);
                    this.f8283c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
