package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public class BlurView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public BlurController f48323a;

    /* renamed from: b, reason: collision with root package name */
    public int f48324b;

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48323a = new NoOpController();
        a(attributeSet, 0);
    }

    @NonNull
    @RequiresApi
    private BlurAlgorithm getBlurAlgorithm() {
        return Build.VERSION.SDK_INT >= 31 ? new RenderEffectBlur() : new RenderScriptBlur(getContext());
    }

    public final void a(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BlurView, i2, 0);
        this.f48324b = typedArrayObtainStyledAttributes.getColor(R.styleable.BlurView_blurOverlayColor, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final PreDrawBlurController b(ViewGroup viewGroup) {
        BlurAlgorithm blurAlgorithm = getBlurAlgorithm();
        this.f48323a.destroy();
        PreDrawBlurController preDrawBlurController = new PreDrawBlurController(this, viewGroup, this.f48324b, blurAlgorithm);
        this.f48323a = preDrawBlurController;
        return preDrawBlurController;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.f48323a.draw(canvas)) {
            super.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            this.f48323a.c(true);
        } else {
            Log.e("BlurView", "BlurView can't be used in not hardware-accelerated window!");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f48323a.c(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f48323a.d();
    }

    public BlurView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f48323a = new NoOpController();
        a(attributeSet, i2);
    }
}
