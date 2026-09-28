package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {

    /* renamed from: a, reason: collision with root package name */
    public final GifState f16351a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16352b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16353c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16354d;

    /* renamed from: f, reason: collision with root package name */
    public int f16356f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16358h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f16359i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f16360j;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16355e = true;

    /* renamed from: g, reason: collision with root package name */
    public final int f16357g = -1;

    public static final class GifState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final GifFrameLoader f16361a;

        public GifState(GifFrameLoader gifFrameLoader) {
            this.f16361a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(GifState gifState) {
        this.f16351a = gifState;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public final void a() {
        Object callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        GifFrameLoader.DelayTarget delayTarget = this.f16351a.f16361a.f16371i;
        if ((delayTarget != null ? delayTarget.f16377e : -1) == r0.f16363a.f15786l.f15762c - 1) {
            this.f16356f++;
        }
        int i2 = this.f16357g;
        if (i2 == -1 || this.f16356f < i2) {
            return;
        }
        stop();
    }

    public final ByteBuffer b() {
        return this.f16351a.f16361a.f16363a.f15778d.asReadOnlyBuffer();
    }

    public final Bitmap c() {
        return this.f16351a.f16361a.f16374l;
    }

    public final void d() {
        Preconditions.a(!this.f16354d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        GifFrameLoader gifFrameLoader = this.f16351a.f16361a;
        if (gifFrameLoader.f16363a.f15786l.f15762c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f16352b) {
            return;
        }
        this.f16352b = true;
        if (gifFrameLoader.f16372j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        ArrayList arrayList = gifFrameLoader.f16365c;
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !gifFrameLoader.f16368f) {
            gifFrameLoader.f16368f = true;
            gifFrameLoader.f16372j = false;
            gifFrameLoader.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f16354d) {
            return;
        }
        if (this.f16358h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f16360j == null) {
                this.f16360j = new Rect();
            }
            Gravity.apply(WKSRecord.Service.NNTP, intrinsicWidth, intrinsicHeight, bounds, this.f16360j);
            this.f16358h = false;
        }
        GifFrameLoader gifFrameLoader = this.f16351a.f16361a;
        GifFrameLoader.DelayTarget delayTarget = gifFrameLoader.f16371i;
        Bitmap bitmap = delayTarget != null ? delayTarget.f16379g : gifFrameLoader.f16374l;
        if (this.f16360j == null) {
            this.f16360j = new Rect();
        }
        Rect rect = this.f16360j;
        if (this.f16359i == null) {
            this.f16359i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f16359i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f16351a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f16351a.f16361a.q;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f16351a.f16361a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f16352b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f16358h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.f16359i == null) {
            this.f16359i = new Paint(2);
        }
        this.f16359i.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f16359i == null) {
            this.f16359i = new Paint(2);
        }
        this.f16359i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Preconditions.a(!this.f16354d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f16355e = z;
        if (!z) {
            this.f16352b = false;
            GifFrameLoader gifFrameLoader = this.f16351a.f16361a;
            ArrayList arrayList = gifFrameLoader.f16365c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                gifFrameLoader.f16368f = false;
            }
        } else if (this.f16353c) {
            d();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f16353c = true;
        this.f16356f = 0;
        if (this.f16355e) {
            d();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f16353c = false;
        this.f16352b = false;
        GifFrameLoader gifFrameLoader = this.f16351a.f16361a;
        ArrayList arrayList = gifFrameLoader.f16365c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            gifFrameLoader.f16368f = false;
        }
    }
}
