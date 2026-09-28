package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.OrientationListener;
import androidx.media3.exoplayer.video.spherical.ProjectionRenderer;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.TouchTracker;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@UnstableApi
/* loaded from: classes3.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f8417l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f8418a;

    /* renamed from: b, reason: collision with root package name */
    public final SensorManager f8419b;

    /* renamed from: c, reason: collision with root package name */
    public final Sensor f8420c;

    /* renamed from: d, reason: collision with root package name */
    public final OrientationListener f8421d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f8422e;

    /* renamed from: f, reason: collision with root package name */
    public final SceneRenderer f8423f;

    /* renamed from: g, reason: collision with root package name */
    public SurfaceTexture f8424g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f8425h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8426i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8427j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8428k;

    @VisibleForTesting
    public final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final SceneRenderer f8429a;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f8432d;

        /* renamed from: e, reason: collision with root package name */
        public final float[] f8433e;

        /* renamed from: f, reason: collision with root package name */
        public final float[] f8434f;

        /* renamed from: g, reason: collision with root package name */
        public float f8435g;

        /* renamed from: h, reason: collision with root package name */
        public float f8436h;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f8430b = new float[16];

        /* renamed from: c, reason: collision with root package name */
        public final float[] f8431c = new float[16];

        /* renamed from: i, reason: collision with root package name */
        public final float[] f8437i = new float[16];

        /* renamed from: j, reason: collision with root package name */
        public final float[] f8438j = new float[16];

        public Renderer(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.f8432d = fArr;
            float[] fArr2 = new float[16];
            this.f8433e = fArr2;
            float[] fArr3 = new float[16];
            this.f8434f = fArr3;
            this.f8429a = sceneRenderer;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f8436h = 3.1415927f;
        }

        @Override // androidx.media3.exoplayer.video.spherical.OrientationListener.Listener
        public final synchronized void a(float[] fArr, float f2) {
            float[] fArr2 = this.f8432d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float f3 = -f2;
            this.f8436h = f3;
            Matrix.setRotateM(this.f8433e, 0, -this.f8435g, (float) Math.cos(f3), (float) Math.sin(this.f8436h), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 gl10) {
            Object objD;
            float[] fArr;
            synchronized (this) {
                Matrix.multiplyMM(this.f8438j, 0, this.f8432d, 0, this.f8434f, 0);
                Matrix.multiplyMM(this.f8437i, 0, this.f8433e, 0, this.f8438j, 0);
            }
            Matrix.multiplyMM(this.f8431c, 0, this.f8430b, 0, this.f8437i, 0);
            SceneRenderer sceneRenderer = this.f8429a;
            float[] fArr2 = this.f8431c;
            GLES20.glClear(16384);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("SceneRenderer", "Failed to draw a frame", e2);
            }
            if (sceneRenderer.f8404a.compareAndSet(true, false)) {
                SurfaceTexture surfaceTexture = sceneRenderer.f8413j;
                surfaceTexture.getClass();
                surfaceTexture.updateTexImage();
                try {
                    GlUtil.b();
                } catch (GlUtil.GlException e3) {
                    Log.e("SceneRenderer", "Failed to draw a frame", e3);
                }
                if (sceneRenderer.f8405b.compareAndSet(true, false)) {
                    Matrix.setIdentityM(sceneRenderer.f8410g, 0);
                }
                long timestamp = sceneRenderer.f8413j.getTimestamp();
                TimedValueQueue timedValueQueue = sceneRenderer.f8408e;
                synchronized (timedValueQueue) {
                    objD = timedValueQueue.d(timestamp, false);
                }
                Long l2 = (Long) objD;
                if (l2 != null) {
                    FrameRotationQueue frameRotationQueue = sceneRenderer.f8407d;
                    float[] fArr3 = sceneRenderer.f8410g;
                    float[] fArr4 = (float[]) frameRotationQueue.f8371c.f(l2.longValue());
                    if (fArr4 != null) {
                        float f2 = fArr4[0];
                        float f3 = -fArr4[1];
                        float f4 = -fArr4[2];
                        float length = Matrix.length(f2, f3, f4);
                        float[] fArr5 = frameRotationQueue.f8370b;
                        if (length != 0.0f) {
                            fArr = fArr3;
                            Matrix.setRotateM(fArr5, 0, (float) Math.toDegrees(length), f2 / length, f3 / length, f4 / length);
                        } else {
                            fArr = fArr3;
                            Matrix.setIdentityM(fArr5, 0);
                        }
                        if (!frameRotationQueue.f8372d) {
                            FrameRotationQueue.a(frameRotationQueue.f8369a, frameRotationQueue.f8370b);
                            frameRotationQueue.f8372d = true;
                        }
                        Matrix.multiplyMM(fArr, 0, frameRotationQueue.f8369a, 0, frameRotationQueue.f8370b, 0);
                    }
                }
                Projection projection = (Projection) sceneRenderer.f8409f.f(timestamp);
                if (projection != null) {
                    ProjectionRenderer projectionRenderer = sceneRenderer.f8406c;
                    projectionRenderer.getClass();
                    if (ProjectionRenderer.b(projection)) {
                        projectionRenderer.f8392a = projection.f8382c;
                        projectionRenderer.f8393b = new ProjectionRenderer.MeshData(projection.f8380a.f8384a[0]);
                        if (!projection.f8383d) {
                            new ProjectionRenderer.MeshData(projection.f8381b.f8384a[0]);
                        }
                    }
                }
            }
            Matrix.multiplyMM(sceneRenderer.f8411h, 0, fArr2, 0, sceneRenderer.f8410g, 0);
            ProjectionRenderer projectionRenderer2 = sceneRenderer.f8406c;
            int i2 = sceneRenderer.f8412i;
            float[] fArr6 = sceneRenderer.f8411h;
            ProjectionRenderer.MeshData meshData = projectionRenderer2.f8393b;
            if (meshData == null) {
                return;
            }
            int i3 = projectionRenderer2.f8392a;
            GLES20.glUniformMatrix3fv(projectionRenderer2.f8396e, 1, false, i3 == 1 ? ProjectionRenderer.f8390j : i3 == 2 ? ProjectionRenderer.f8391k : ProjectionRenderer.f8389i, 0);
            GLES20.glUniformMatrix4fv(projectionRenderer2.f8395d, 1, false, fArr6, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(projectionRenderer2.f8399h, 0);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e4) {
                android.util.Log.e("ProjectionRenderer", "Failed to bind uniforms", e4);
            }
            GLES20.glVertexAttribPointer(projectionRenderer2.f8397f, 3, 5126, false, 12, (Buffer) meshData.f8401b);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e5) {
                android.util.Log.e("ProjectionRenderer", "Failed to load position data", e5);
            }
            GLES20.glVertexAttribPointer(projectionRenderer2.f8398g, 2, 5126, false, 8, (Buffer) meshData.f8402c);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e6) {
                android.util.Log.e("ProjectionRenderer", "Failed to load texture data", e6);
            }
            GLES20.glDrawArrays(meshData.f8403d, 0, meshData.f8400a);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e7) {
                android.util.Log.e("ProjectionRenderer", "Failed to render", e7);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = i2 / i3;
            Matrix.perspectiveM(this.f8430b, 0, f2 > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f2)) * 2.0d) : 90.0f, f2, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView sphericalGLSurfaceView = SphericalGLSurfaceView.this;
            sphericalGLSurfaceView.f8422e.post(new androidx.constraintlayout.motion.widget.a(6, sphericalGLSurfaceView, this.f8429a.a()));
        }
    }

    public interface VideoSurfaceListener {
        void A();

        void y(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public final void a() {
        boolean z = this.f8426i && this.f8427j;
        Sensor sensor = this.f8420c;
        if (sensor == null || z == this.f8428k) {
            return;
        }
        OrientationListener orientationListener = this.f8421d;
        SensorManager sensorManager = this.f8419b;
        if (z) {
            sensorManager.registerListener(orientationListener, sensor, 0);
        } else {
            sensorManager.unregisterListener(orientationListener);
        }
        this.f8428k = z;
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f8423f;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f8423f;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f8425h;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8422e.post(new Runnable() { // from class: androidx.media3.exoplayer.video.spherical.b
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView sphericalGLSurfaceView = this.f8447a;
                Surface surface = sphericalGLSurfaceView.f8425h;
                if (surface != null) {
                    Iterator it = sphericalGLSurfaceView.f8418a.iterator();
                    while (it.hasNext()) {
                        ((SphericalGLSurfaceView.VideoSurfaceListener) it.next()).A();
                    }
                }
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f8424g;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                sphericalGLSurfaceView.f8424g = null;
                sphericalGLSurfaceView.f8425h = null;
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.f8427j = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.f8427j = true;
        a();
    }

    public void setDefaultStereoMode(int i2) {
        this.f8423f.f8414k = i2;
    }

    public void setUseSensorRotation(boolean z) {
        this.f8426i = z;
        a();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8418a = new CopyOnWriteArrayList();
        this.f8422e = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f8419b = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f8420c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.f8423f = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        View.OnTouchListener touchTracker = new TouchTracker(context, renderer);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f8421d = new OrientationListener(windowManager.getDefaultDisplay(), touchTracker, renderer);
        this.f8426i = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }
}
