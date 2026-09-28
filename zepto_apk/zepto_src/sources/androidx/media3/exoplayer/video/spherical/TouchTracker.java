package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.exoplayer.video.spherical.OrientationListener;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;

/* loaded from: classes3.dex */
final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {

    /* renamed from: c, reason: collision with root package name */
    public final Listener f8442c;

    /* renamed from: e, reason: collision with root package name */
    public final GestureDetector f8444e;

    /* renamed from: a, reason: collision with root package name */
    public final PointF f8440a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    public final PointF f8441b = new PointF();

    /* renamed from: d, reason: collision with root package name */
    public final float f8443d = 25.0f;

    /* renamed from: f, reason: collision with root package name */
    public volatile float f8445f = 3.1415927f;

    public interface Listener {
    }

    public TouchTracker(Context context, Listener listener) {
        this.f8442c = listener;
        this.f8444e = new GestureDetector(context, this);
    }

    @Override // androidx.media3.exoplayer.video.spherical.OrientationListener.Listener
    public final void a(float[] fArr, float f2) {
        this.f8445f = -f2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f8440a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = (motionEvent2.getX() - this.f8440a.x) / this.f8443d;
        float y = motionEvent2.getY();
        PointF pointF = this.f8440a;
        float f4 = (y - pointF.y) / this.f8443d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = this.f8445f;
        float fCos = (float) Math.cos(d2);
        float fSin = (float) Math.sin(d2);
        PointF pointF2 = this.f8441b;
        pointF2.x -= (fCos * x) - (fSin * f4);
        float f5 = (fCos * f4) + (fSin * x) + pointF2.y;
        pointF2.y = f5;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f5));
        Listener listener = this.f8442c;
        PointF pointF3 = this.f8441b;
        SphericalGLSurfaceView.Renderer renderer = (SphericalGLSurfaceView.Renderer) listener;
        synchronized (renderer) {
            float f6 = pointF3.y;
            renderer.f8435g = f6;
            Matrix.setRotateM(renderer.f8433e, 0, -f6, (float) Math.cos(renderer.f8436h), (float) Math.sin(renderer.f8436h), 0.0f);
            Matrix.setRotateM(renderer.f8434f, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return SphericalGLSurfaceView.this.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f8444e.onTouchEvent(motionEvent);
    }
}
