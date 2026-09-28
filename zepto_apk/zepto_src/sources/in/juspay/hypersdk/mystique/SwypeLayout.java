package in.juspay.hypersdk.mystique;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.ref.WeakReference;
import org.xbill.DNS.Type;

@Keep
/* loaded from: classes4.dex */
public class SwypeLayout extends FrameLayout {
    private static final String TAG = "SwypeLayout";
    public static WeakReference<SwypeLayout> activeLayoutWeakReference;
    public static WeakReference<SwypeLayout> partialSwypeWeakReference;
    private boolean didDisplace;
    private int leftEdge;
    private View mContent;
    private float mDisplaceX;
    private boolean mEnabled;
    private View mLeftOption;
    private View mRightOption;
    private float mX;
    private int rightEdge;

    public SwypeLayout(Context context) {
        super(context);
        this.mX = 0.0f;
        this.leftEdge = 0;
        this.rightEdge = Type.TSIG;
        this.mDisplaceX = 0.0f;
        this.didDisplace = false;
        this.mContent = null;
        this.mLeftOption = null;
        this.mRightOption = null;
        this.mEnabled = false;
    }

    @Keep
    public static void clear() {
        SwypeLayout swypeLayout = activeLayoutWeakReference.get();
        if (swypeLayout != null) {
            swypeLayout.reset();
            activeLayoutWeakReference = new WeakReference<>(null);
        }
        SwypeLayout swypeLayout2 = partialSwypeWeakReference.get();
        if (swypeLayout2 != null) {
            swypeLayout2.reset();
            partialSwypeWeakReference = new WeakReference<>(null);
        }
    }

    private void handleSwype(float f2, boolean z) {
        boolean z2;
        int i2 = this.leftEdge;
        if (i2 == 0 && this.rightEdge == 0) {
            return;
        }
        float f3 = i2;
        float f4 = this.mDisplaceX + (f2 - this.mX);
        if (f4 < 0.0f) {
            f3 = this.rightEdge;
            f4 *= -1.0f;
            z2 = true;
        } else {
            z2 = false;
        }
        if (f4 > f3) {
            f4 = f3;
        }
        if (!z) {
            f3 = f4;
        } else if (f4 / f3 <= 0.4d) {
            f3 = 0.0f;
        }
        SwypeLayout swypeLayout = partialSwypeWeakReference.get();
        if (swypeLayout != null && swypeLayout != this) {
            swypeLayout.reset();
        }
        partialSwypeWeakReference = new WeakReference<>(this);
        if (z2) {
            f3 *= -1.0f;
        }
        float f5 = this.mDisplaceX - f3;
        if (f5 > 20.0f || f5 < -20.0f) {
            this.didDisplace = true;
            SwypeLayout swypeLayout2 = activeLayoutWeakReference.get();
            if (swypeLayout2 != null && swypeLayout2 != this) {
                swypeLayout2.reset();
                activeLayoutWeakReference = new WeakReference<>(null);
            }
        }
        if (!z) {
            this.mContent.setTranslationX(f3);
            return;
        }
        this.mDisplaceX = f3;
        this.mContent.animate().setDuration(150L).setInterpolator(new FastOutLinearInInterpolator()).translationX(f3);
        if (f3 != 0.0f) {
            activeLayoutWeakReference = new WeakReference<>(this);
        }
        partialSwypeWeakReference = new WeakReference<>(null);
    }

    private void processClick(MotionEvent motionEvent) {
        float measuredHeight = getMeasuredHeight();
        float measuredWidth = getMeasuredWidth();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        if (measuredHeight < y || y < 0.0f || x < 0.0f || x > measuredWidth) {
            return;
        }
        float f2 = this.mDisplaceX;
        if (f2 == 0.0f) {
            this.mContent.callOnClick();
            return;
        }
        if (f2 < 0.0f && x >= measuredWidth - this.rightEdge) {
            this.mRightOption.callOnClick();
        } else if (f2 <= 0.0f || x > this.leftEdge) {
            reset();
        } else {
            this.mLeftOption.callOnClick();
        }
    }

    private boolean tagChildren() {
        if (getChildCount() != 3) {
            return false;
        }
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        View childAt3 = getChildAt(2);
        if (childAt != this.mContent || childAt2 != this.mLeftOption || childAt3 != this.mRightOption) {
            this.mContent = childAt;
            this.mLeftOption = childAt2;
            this.mRightOption = childAt3;
            reset();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mEnabled;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mContent != null || tagChildren()) {
            int i6 = i4 - i2;
            View view = this.mContent;
            view.layout(0, 0, view.getMeasuredWidth(), this.mContent.getMeasuredHeight());
            View view2 = this.mLeftOption;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.mContent.getMeasuredHeight());
            View view3 = this.mRightOption;
            view3.layout(i6 - view3.getMeasuredWidth(), 0, i6, this.mRightOption.getMeasuredWidth());
            this.mContent.bringToFront();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mX = motionEvent.getX();
        } else if (actionMasked == 1) {
            handleSwype(motionEvent.getX(), true);
            this.mX = 0.0f;
            if (this.didDisplace) {
                this.didDisplace = false;
                return false;
            }
            processClick(motionEvent);
        } else if (actionMasked == 2) {
            handleSwype(motionEvent.getX(), false);
        }
        return true;
    }

    public void reset() {
        this.mDisplaceX = 0.0f;
        this.leftEdge = this.mLeftOption.getMeasuredWidth();
        this.rightEdge = this.mRightOption.getMeasuredWidth();
        this.mContent.setTranslationZ(2.0f);
        this.mContent.animate().setDuration(150L).translationX(0.0f);
    }

    public void setSwypeEnabled(boolean z) {
        boolean z2 = this.mEnabled;
        if (z2 != z && z2) {
            reset();
        }
        this.mEnabled = z;
    }
}
