package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends ViewGroup {
    private static final String A = "a";

    /* renamed from: a, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b f49035a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f49036b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f49037c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f49038d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceView f49039e;

    /* renamed from: f, reason: collision with root package name */
    private TextureView f49040f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f49041g;

    /* renamed from: h, reason: collision with root package name */
    private h f49042h;

    /* renamed from: i, reason: collision with root package name */
    private int f49043i;

    /* renamed from: j, reason: collision with root package name */
    private List<f> f49044j;

    /* renamed from: k, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.h f49045k;

    /* renamed from: l, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d f49046l;

    /* renamed from: m, reason: collision with root package name */
    private i f49047m;
    private i n;
    private Rect o;
    private i p;
    private Rect q;
    private Rect r;
    private i s;
    private double t;
    private l u;
    private boolean v;
    private final SurfaceHolder.Callback w;
    private final Handler.Callback x;
    private g y;
    private final f z;

    /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    public class TextureViewSurfaceTextureListenerC0056a implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC0056a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            a.this.p = new i(i2, i3);
            a.this.i();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            if (surfaceHolder == null) {
                Log.e(a.A, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            a.this.p = new i(i3, i4);
            a.this.i();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.this.p = null;
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == R.id.zxing_prewiew_size_ready) {
                a.this.b((i) message.obj);
                return true;
            }
            if (i2 != R.id.zxing_camera_error) {
                if (i2 != R.id.zxing_camera_closed) {
                    return false;
                }
                a.this.z.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!a.this.e()) {
                return false;
            }
            a.this.pause();
            a.this.z.a(exc);
            return false;
        }
    }

    public class d implements g {

        /* renamed from: in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a$d$a, reason: collision with other inner class name */
        public class RunnableC0057a implements Runnable {
            public RunnableC0057a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.g();
            }
        }

        public d() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.g
        public void a(int i2) {
            a.this.f49037c.postDelayed(new RunnableC0057a(), 250L);
        }
    }

    public class e implements f {
        public e() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a() {
            Iterator it = a.this.f49044j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void b() {
            Iterator it = a.this.f49044j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void c() {
            Iterator it = a.this.f49044j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void d() {
            Iterator it = a.this.f49044j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a(Exception exc) {
            Iterator it = a.this.f49044j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(exc);
            }
        }
    }

    public interface f {
        void a();

        void a(Exception exc);

        void b();

        void c();

        void d();
    }

    public a(Context context) {
        super(context);
        this.f49038d = false;
        this.f49041g = false;
        this.f49043i = -1;
        this.f49044j = new ArrayList();
        this.f49046l = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0.1d;
        this.u = null;
        this.v = false;
        this.w = new b();
        this.x = new c();
        this.y = new d();
        this.z = new e();
        a(context, null, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!e() || getDisplayRotation() == this.f49043i) {
            return;
        }
        pause();
        resume();
    }

    private int getDisplayRotation() {
        return this.f49036b.getDefaultDisplay().getRotation();
    }

    private void h() {
        View view;
        if (this.f49038d) {
            TextureView textureView = new TextureView(getContext());
            this.f49040f = textureView;
            textureView.setSurfaceTextureListener(j());
            view = this.f49040f;
        } else {
            SurfaceView surfaceView = new SurfaceView(getContext());
            this.f49039e = surfaceView;
            surfaceView.getHolder().addCallback(this.w);
            view = this.f49039e;
        }
        addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Rect rect;
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e eVar;
        i iVar = this.p;
        if (iVar == null || this.n == null || (rect = this.o) == null) {
            return;
        }
        if (this.f49039e == null || !iVar.equals(new i(rect.width(), this.o.height()))) {
            TextureView textureView = this.f49040f;
            if (textureView == null || textureView.getSurfaceTexture() == null) {
                return;
            }
            if (this.n != null) {
                this.f49040f.setTransform(a(new i(this.f49040f.getWidth(), this.f49040f.getHeight()), this.n));
            }
            eVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e(this.f49040f.getSurfaceTexture());
        } else {
            eVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e(this.f49039e.getHolder());
        }
        a(eVar);
    }

    @TargetApi(14)
    private TextureView.SurfaceTextureListener j() {
        return new TextureViewSurfaceTextureListenerC0056a();
    }

    public Matrix a(i iVar, i iVar2) {
        float f2;
        float f3 = iVar.f49078a / iVar.f49079b;
        float f4 = iVar2.f49078a / iVar2.f49079b;
        float f5 = 1.0f;
        if (f3 < f4) {
            float f6 = f4 / f3;
            f2 = 1.0f;
            f5 = f6;
        } else {
            f2 = f3 / f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f2);
        float f7 = iVar.f49078a;
        float f8 = iVar.f49079b;
        matrix.postTranslate((f7 - (f5 * f7)) / 2.0f, (f8 - (f2 * f8)) / 2.0f);
        return matrix;
    }

    public void addStateListener(f fVar) {
        this.f49044j.add(fVar);
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b c() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b(getContext());
        bVar.a(this.f49046l);
        return bVar;
    }

    public void f() {
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b getCameraInstance() {
        return this.f49035a;
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d getCameraSettings() {
        return this.f49046l;
    }

    public Rect getFramingRect() {
        return this.q;
    }

    public i getFramingRectSize() {
        return this.s;
    }

    public double getMarginFraction() {
        return this.t;
    }

    public Rect getPreviewFramingRect() {
        return this.r;
    }

    public l getPreviewScalingStrategy() {
        l lVar = this.u;
        return lVar != null ? lVar : this.f49040f != null ? new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.g() : new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.i();
    }

    public boolean isCameraClosed() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar = this.f49035a;
        return bVar == null || bVar.f();
    }

    public boolean isPreviewActive() {
        return this.f49041g;
    }

    public boolean isUseTextureView() {
        return this.f49038d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a(new i(i4 - i2, i5 - i3));
        SurfaceView surfaceView = this.f49039e;
        if (surfaceView == null) {
            TextureView textureView = this.f49040f;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.o;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.v);
        return bundle;
    }

    public void pause() {
        TextureView textureView;
        SurfaceView surfaceView;
        k.a();
        Log.d(A, "pause()");
        this.f49043i = -1;
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar = this.f49035a;
        if (bVar != null) {
            bVar.b();
            this.f49035a = null;
            this.f49041g = false;
        } else {
            this.f49037c.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.p == null && (surfaceView = this.f49039e) != null) {
            surfaceView.getHolder().removeCallback(this.w);
        }
        if (this.p == null && (textureView = this.f49040f) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f49047m = null;
        this.n = null;
        this.r = null;
        this.f49042h.a();
        this.z.b();
    }

    public void pauseAndWait() throws InterruptedException {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b cameraInstance = getCameraInstance();
        pause();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.f() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public void resume() {
        k.a();
        Log.d(A, "resume()");
        d();
        if (this.p != null) {
            i();
        } else {
            SurfaceView surfaceView = this.f49039e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.w);
            } else {
                TextureView textureView = this.f49040f;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        j().onSurfaceTextureAvailable(this.f49040f.getSurfaceTexture(), this.f49040f.getWidth(), this.f49040f.getHeight());
                    } else {
                        this.f49040f.setSurfaceTextureListener(j());
                    }
                }
            }
        }
        requestLayout();
        this.f49042h.a(getContext(), this.y);
    }

    public void setCameraSettings(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d dVar) {
        this.f49046l = dVar;
    }

    public void setFramingRectSize(i iVar) {
        this.s = iVar;
    }

    public void setMarginFraction(double d2) {
        if (d2 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.t = d2;
    }

    public void setPreviewScalingStrategy(l lVar) {
        this.u = lVar;
    }

    public void setTorch(boolean z) {
        this.v = z;
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar = this.f49035a;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void setUseTextureView(boolean z) {
        this.f49038d = z;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49038d = false;
        this.f49041g = false;
        this.f49043i = -1;
        this.f49044j = new ArrayList();
        this.f49046l = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0.1d;
        this.u = null;
        this.v = false;
        this.w = new b();
        this.x = new c();
        this.y = new d();
        this.z = new e();
        a(context, attributeSet, 0, 0);
    }

    private void b() {
        i iVar;
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.h hVar;
        i iVar2 = this.f49047m;
        if (iVar2 == null || (iVar = this.n) == null || (hVar = this.f49045k) == null) {
            this.r = null;
            this.q = null;
            this.o = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i2 = iVar.f49078a;
        int i3 = iVar.f49079b;
        int i4 = iVar2.f49078a;
        int i5 = iVar2.f49079b;
        this.o = hVar.a(iVar);
        this.q = a(new Rect(0, 0, i4, i5), this.o);
        Rect rect = new Rect(this.q);
        Rect rect2 = this.o;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i2) / this.o.width(), (rect.top * i3) / this.o.height(), (rect.right * i2) / this.o.width(), (rect.bottom * i3) / this.o.height());
        this.r = rect3;
        if (rect3.width() > 0 && this.r.height() > 0) {
            this.z.a();
            return;
        }
        this.r = null;
        this.q = null;
        Log.w(A, "Preview frame is too small");
    }

    private void d() {
        if (this.f49035a != null) {
            Log.w(A, "initCamera called twice");
            return;
        }
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVarC = c();
        this.f49035a = bVarC;
        bVarC.a(this.f49037c);
        this.f49035a.g();
        this.f49043i = getDisplayRotation();
    }

    public Rect a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.s != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.s.f49078a) / 2), Math.max(0, (rect3.height() - this.s.f49079b) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(rect3.width() * this.t, rect3.height() * this.t);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public boolean e() {
        return this.f49035a != null;
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f49038d = false;
        this.f49041g = false;
        this.f49043i = -1;
        this.f49044j = new ArrayList();
        this.f49046l = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0.1d;
        this.u = null;
        this.v = false;
        this.w = new b();
        this.x = new c();
        this.y = new d();
        this.z = new e();
        a(context, attributeSet, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i iVar) {
        this.n = iVar;
        if (this.f49047m != null) {
            b();
            requestLayout();
            i();
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        a(attributeSet);
        this.f49036b = (WindowManager) context.getSystemService("window");
        this.f49037c = new Handler(this.x);
        this.f49042h = new h();
    }

    public void a(AttributeSet attributeSet) {
        l jVar;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.s = new i(dimension, dimension2);
        }
        this.f49038d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            jVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.g();
        } else {
            if (integer != 2) {
                if (integer == 3) {
                    jVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.j();
                }
                typedArrayObtainStyledAttributes.recycle();
            }
            jVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.i();
        }
        this.u = jVar;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(i iVar) {
        this.f49047m = iVar;
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.b bVar = this.f49035a;
        if (bVar == null || bVar.d() != null) {
            return;
        }
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.h hVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.h(getDisplayRotation(), iVar);
        this.f49045k = hVar;
        hVar.a(getPreviewScalingStrategy());
        this.f49035a.a(this.f49045k);
        this.f49035a.c();
        boolean z = this.v;
        if (z) {
            this.f49035a.a(z);
        }
    }

    private void a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.e eVar) {
        if (this.f49041g || this.f49035a == null) {
            return;
        }
        Log.i(A, "Starting preview");
        this.f49035a.a(eVar);
        this.f49035a.h();
        this.f49041g = true;
        f();
        this.z.c();
    }
}
