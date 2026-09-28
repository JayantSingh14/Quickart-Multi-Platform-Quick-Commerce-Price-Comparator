package org.reactnative.maskedview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes5.dex */
public class RNCMaskedView extends ReactViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f57685a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f57686b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f57687c;

    /* renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f57688d;

    /* renamed from: e, reason: collision with root package name */
    public int f57689e;

    public RNCMaskedView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f57685a = null;
        this.f57686b = false;
        this.f57689e = 2;
        this.f57687c = new Paint(1);
        this.f57688d = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Bitmap bitmapCreateBitmap;
        super.dispatchDraw(canvas);
        if (this.f57686b) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                childAt.setVisibility(0);
                Bitmap bitmap = this.f57685a;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                if (childAt.getMeasuredWidth() <= 0 || childAt.getMeasuredHeight() <= 0) {
                    bitmapCreateBitmap = null;
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    childAt.draw(new Canvas(bitmapCreateBitmap));
                }
                this.f57685a = bitmapCreateBitmap;
                childAt.setVisibility(4);
            }
            this.f57686b = false;
        }
        if (this.f57685a != null) {
            int i2 = this.f57689e;
            Paint paint = this.f57687c;
            setLayerType(i2, paint);
            paint.setXfermode(this.f57688d);
            canvas.drawBitmap(this.f57685a, 0.0f, 0.0f, paint);
            paint.setXfermode(null);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f57686b = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        View childAt;
        super.onDescendantInvalidated(view, view2);
        if (!this.f57686b && (childAt = getChildAt(0)) != null && childAt.equals(view)) {
            this.f57686b = true;
        }
        invalidate();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f57686b = true;
        }
    }

    public void setRenderingMode(String str) {
        this.f57689e = str.equals("software") ? 1 : 2;
    }
}
