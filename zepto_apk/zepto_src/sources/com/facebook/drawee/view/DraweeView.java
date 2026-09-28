package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.react.uimanager.ThemedReactContext;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes.dex */
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f17453g = false;

    /* renamed from: a, reason: collision with root package name */
    public final AspectRatioMeasure.Spec f17454a;

    /* renamed from: b, reason: collision with root package name */
    public float f17455b;

    /* renamed from: c, reason: collision with root package name */
    public DraweeHolder f17456c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17457d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17458e;

    /* renamed from: f, reason: collision with root package name */
    public Object f17459f;

    public DraweeView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f17454a = new AspectRatioMeasure.Spec();
        this.f17455b = 0.0f;
        this.f17457d = false;
        this.f17458e = false;
        this.f17459f = null;
        a(themedReactContext);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        f17453g = z;
    }

    public final void a(Context context) {
        try {
            FrescoSystrace.a();
            if (this.f17457d) {
                FrescoSystrace.a();
                return;
            }
            boolean z = true;
            this.f17457d = true;
            this.f17456c = DraweeHolder.c(null);
            ColorStateList imageTintList = getImageTintList();
            if (imageTintList == null) {
                FrescoSystrace.a();
                return;
            }
            setColorFilter(imageTintList.getDefaultColor());
            if (!f17453g || context.getApplicationInfo().targetSdkVersion < 24) {
                z = false;
            }
            this.f17458e = z;
            FrescoSystrace.a();
        } catch (Throwable th) {
            FrescoSystrace.a();
            throw th;
        }
    }

    public final void b() {
        Drawable drawable;
        if (!this.f17458e || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    public float getAspectRatio() {
        return this.f17455b;
    }

    @Nullable
    public DraweeController getController() {
        return this.f17456c.d();
    }

    @Nullable
    public Object getExtraData() {
        return this.f17459f;
    }

    public DH getHierarchy() {
        return (DH) this.f17456c.e();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.f17456c.f();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        this.f17456c.h();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        this.f17456c.i();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
        this.f17456c.h();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i2, int i3) {
        AspectRatioMeasure.Spec spec = this.f17454a;
        spec.f17445a = i2;
        spec.f17446b = i3;
        AspectRatioMeasure.a(spec, this.f17455b, getLayoutParams(), getPaddingRight() + getPaddingLeft(), getPaddingBottom() + getPaddingTop());
        super.onMeasure(spec.f17445a, spec.f17446b);
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        b();
        this.f17456c.i();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17456c.j(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        b();
    }

    public void setAspectRatio(float f2) {
        if (f2 == this.f17455b) {
            return;
        }
        this.f17455b = f2;
        requestLayout();
    }

    public void setController(@Nullable DraweeController draweeController) {
        this.f17456c.m(draweeController);
        super.setImageDrawable(this.f17456c.f());
    }

    public void setExtraData(@Nullable Object obj) {
        this.f17459f = obj;
    }

    public void setHierarchy(DH dh) {
        this.f17456c.n(dh);
        super.setImageDrawable(this.f17456c.f());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        a(getContext());
        this.f17456c.l();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(@Nullable Drawable drawable) {
        a(getContext());
        this.f17456c.l();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i2) {
        a(getContext());
        this.f17456c.l();
        super.setImageResource(i2);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        a(getContext());
        this.f17456c.l();
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.f17458e = z;
    }

    @Override // android.view.View
    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        DraweeHolder draweeHolder = this.f17456c;
        toStringHelperB.a(draweeHolder != null ? draweeHolder.toString() : "<no holder set>");
        return toStringHelperB.toString();
    }

    public DraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17454a = new AspectRatioMeasure.Spec();
        this.f17455b = 0.0f;
        this.f17457d = false;
        this.f17458e = false;
        this.f17459f = null;
        a(context);
    }

    public DraweeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17454a = new AspectRatioMeasure.Spec();
        this.f17455b = 0.0f;
        this.f17457d = false;
        this.f17458e = false;
        this.f17459f = null;
        a(context);
    }
}
