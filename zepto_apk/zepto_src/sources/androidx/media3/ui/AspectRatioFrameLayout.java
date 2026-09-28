package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final AspectRatioUpdateDispatcher f10817a;

    /* renamed from: b, reason: collision with root package name */
    public AspectRatioListener f10818b;

    /* renamed from: c, reason: collision with root package name */
    public float f10819c;

    /* renamed from: d, reason: collision with root package name */
    public int f10820d;

    public interface AspectRatioListener {
        void a();
    }

    public final class AspectRatioUpdateDispatcher implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10821a;

        public AspectRatioUpdateDispatcher() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10821a = false;
            AspectRatioListener aspectRatioListener = AspectRatioFrameLayout.this.f10818b;
            if (aspectRatioListener == null) {
                return;
            }
            aspectRatioListener.a();
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10820d = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f10820d = typedArrayObtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f10817a = new AspectRatioUpdateDispatcher();
    }

    public int getResizeMode() {
        return this.f10820d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        float f2;
        float f3;
        super.onMeasure(i2, i3);
        if (this.f10819c <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f4 = measuredWidth;
        float f5 = measuredHeight;
        float f6 = (this.f10819c / (f4 / f5)) - 1.0f;
        float fAbs = Math.abs(f6);
        AspectRatioUpdateDispatcher aspectRatioUpdateDispatcher = this.f10817a;
        if (fAbs <= 0.01f) {
            aspectRatioUpdateDispatcher.getClass();
            if (aspectRatioUpdateDispatcher.f10821a) {
                return;
            }
            aspectRatioUpdateDispatcher.f10821a = true;
            AspectRatioFrameLayout.this.post(aspectRatioUpdateDispatcher);
            return;
        }
        int i4 = this.f10820d;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    f2 = this.f10819c;
                } else if (i4 == 4) {
                    if (f6 > 0.0f) {
                        f2 = this.f10819c;
                    } else {
                        f3 = this.f10819c;
                    }
                }
                measuredWidth = (int) (f5 * f2);
            } else {
                f3 = this.f10819c;
            }
            measuredHeight = (int) (f4 / f3);
        } else if (f6 > 0.0f) {
            f3 = this.f10819c;
            measuredHeight = (int) (f4 / f3);
        } else {
            f2 = this.f10819c;
            measuredWidth = (int) (f5 * f2);
        }
        aspectRatioUpdateDispatcher.getClass();
        if (!aspectRatioUpdateDispatcher.f10821a) {
            aspectRatioUpdateDispatcher.f10821a = true;
            AspectRatioFrameLayout.this.post(aspectRatioUpdateDispatcher);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f2) {
        if (this.f10819c != f2) {
            this.f10819c = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioListener aspectRatioListener) {
        this.f10818b = aspectRatioListener;
    }

    public void setResizeMode(int i2) {
        if (this.f10820d != i2) {
            this.f10820d = i2;
            requestLayout();
        }
    }
}
