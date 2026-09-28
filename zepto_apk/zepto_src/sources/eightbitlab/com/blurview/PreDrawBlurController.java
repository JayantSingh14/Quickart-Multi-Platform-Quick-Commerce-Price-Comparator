package eightbitlab.com.blurview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: classes4.dex */
public final class PreDrawBlurController implements BlurController {

    /* renamed from: b, reason: collision with root package name */
    public final BlurAlgorithm f48326b;

    /* renamed from: c, reason: collision with root package name */
    public BlurViewCanvas f48327c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f48328d;

    /* renamed from: e, reason: collision with root package name */
    public final BlurView f48329e;

    /* renamed from: f, reason: collision with root package name */
    public int f48330f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f48331g;

    /* renamed from: l, reason: collision with root package name */
    public boolean f48336l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f48337m;

    /* renamed from: a, reason: collision with root package name */
    public float f48325a = 16.0f;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f48332h = new int[2];

    /* renamed from: i, reason: collision with root package name */
    public final int[] f48333i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f48334j = new ViewTreeObserver.OnPreDrawListener() { // from class: eightbitlab.com.blurview.PreDrawBlurController.1
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            PreDrawBlurController.this.g();
            return true;
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public boolean f48335k = true;

    public PreDrawBlurController(BlurView blurView, ViewGroup viewGroup, int i2, BlurAlgorithm blurAlgorithm) {
        this.f48331g = viewGroup;
        this.f48329e = blurView;
        this.f48330f = i2;
        this.f48326b = blurAlgorithm;
        if (blurAlgorithm instanceof RenderEffectBlur) {
            ((RenderEffectBlur) blurAlgorithm).f48344f = blurView.getContext();
        }
        f(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade a(int i2) {
        if (this.f48330f != i2) {
            this.f48330f = i2;
            this.f48329e.invalidate();
        }
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade b(boolean z) {
        this.f48335k = z;
        c(z);
        this.f48329e.invalidate();
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade c(boolean z) {
        ViewGroup viewGroup = this.f48331g;
        ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f48334j;
        viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        if (z) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
        }
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final void d() {
        BlurView blurView = this.f48329e;
        f(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final void destroy() {
        c(false);
        this.f48326b.destroy();
        this.f48336l = false;
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final boolean draw(Canvas canvas) {
        if (this.f48335k && this.f48336l) {
            if (canvas instanceof BlurViewCanvas) {
                return false;
            }
            BlurView blurView = this.f48329e;
            float height = blurView.getHeight() / this.f48328d.getHeight();
            canvas.save();
            canvas.scale(blurView.getWidth() / this.f48328d.getWidth(), height);
            this.f48326b.b(canvas, this.f48328d);
            canvas.restore();
            int i2 = this.f48330f;
            if (i2 != 0) {
                canvas.drawColor(i2);
            }
        }
        return true;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade e(float f2) {
        this.f48325a = f2;
        return this;
    }

    public final void f(int i2, int i3) {
        c(true);
        BlurAlgorithm blurAlgorithm = this.f48326b;
        blurAlgorithm.getClass();
        float f2 = i3;
        int iCeil = (int) Math.ceil(f2 / 6.0f);
        BlurView blurView = this.f48329e;
        if (iCeil != 0) {
            float f3 = i2;
            if (((int) Math.ceil(f3 / 6.0f)) != 0) {
                blurView.setWillNotDraw(false);
                int iCeil2 = (int) Math.ceil(f3 / 6.0f);
                int i4 = iCeil2 % 64;
                if (i4 != 0) {
                    iCeil2 = (iCeil2 - i4) + 64;
                }
                int iCeil3 = (int) Math.ceil(f2 / (f3 / iCeil2));
                blurAlgorithm.a();
                this.f48328d = Bitmap.createBitmap(iCeil2, iCeil3, Bitmap.Config.ARGB_8888);
                this.f48327c = new BlurViewCanvas(this.f48328d);
                this.f48336l = true;
                g();
                return;
            }
        }
        blurView.setWillNotDraw(true);
    }

    public final void g() {
        if (this.f48335k && this.f48336l) {
            Drawable drawable = this.f48337m;
            if (drawable == null) {
                this.f48328d.eraseColor(0);
            } else {
                drawable.draw(this.f48327c);
            }
            this.f48327c.save();
            int[] iArr = this.f48332h;
            ViewGroup viewGroup = this.f48331g;
            viewGroup.getLocationOnScreen(iArr);
            BlurView blurView = this.f48329e;
            int[] iArr2 = this.f48333i;
            blurView.getLocationOnScreen(iArr2);
            int i2 = iArr2[0] - iArr[0];
            int i3 = iArr2[1] - iArr[1];
            float height = blurView.getHeight() / this.f48328d.getHeight();
            float width = blurView.getWidth() / this.f48328d.getWidth();
            this.f48327c.translate((-i2) / width, (-i3) / height);
            this.f48327c.scale(1.0f / width, 1.0f / height);
            viewGroup.draw(this.f48327c);
            this.f48327c.restore();
            this.f48328d = this.f48326b.c(this.f48328d, this.f48325a);
        }
    }
}
