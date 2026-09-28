package in.juspay.hypersdk.mystique;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public class AccordionLayout extends FrameLayout {
    private static final int COLLAPSE = 0;
    private static final int EXPAND = 1;
    private float alphaDelta;
    private int animationDuration;
    private ValueAnimator animator;
    private Context context;
    private float delta;
    private float parallaxDelta;
    private int parentScrollViewId;
    private boolean postLayout;
    private float target;

    public AccordionLayout(Context context) {
        super(context);
        this.delta = 1.0f;
        this.target = 1.0f;
        this.parallaxDelta = 0.6f;
        this.alphaDelta = 1.0f;
        this.animationDuration = 300;
        this.parentScrollViewId = -1;
        this.postLayout = false;
        this.context = context;
    }

    private int getRelativeTop(View view, ScrollView scrollView) {
        Object parent = view.getParent();
        return (parent == scrollView || !(parent instanceof View)) ? view.getTop() : view.getTop() + getRelativeTop((View) parent, scrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollParent() {
        ScrollView scrollView;
        if (this.target != 1.0f || this.parentScrollViewId == -1 || !(getContext() instanceof Activity) || (scrollView = (ScrollView) ((Activity) getContext()).findViewById(this.parentScrollViewId)) == null) {
            return;
        }
        int scrollY = scrollView.getScrollY();
        int height = scrollView.getHeight() + scrollY;
        int relativeTop = getRelativeTop(this, scrollView);
        int height2 = getHeight() + relativeTop;
        if (relativeTop < scrollY || height2 > height) {
            scrollView.scrollTo(0, scrollView.getScrollY() + (relativeTop < scrollY ? relativeTop - scrollY : height2 - height));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredHeight = (int) (this.delta * getMeasuredHeight());
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        setVisibility((measuredHeight == 0 && this.target == 0.0f) ? 8 : 0);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.setTranslationY((int) ((measuredHeight - r6) * this.parallaxDelta));
            float f2 = this.alphaDelta;
            if (f2 != 0.0f) {
                childAt.setAlpha(this.delta * f2);
                if (this.target == 1.0f && this.delta == 1.0f) {
                    childAt.setAlpha(1.0f);
                }
            }
        }
        setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        this.postLayout = true;
    }

    public void setDefaultExpand(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        this.target = f2;
        this.delta = f2;
        if (f2 == 0.0f) {
            setVisibility(8);
        }
    }

    public void setExpand(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        if (this.target == f2) {
            return;
        }
        this.target = f2;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            if (!z) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.delta = f2;
            scrollParent();
            return;
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.target == 1.0f) {
            setVisibility(0);
        }
        float f3 = this.target;
        float f4 = this.delta;
        float f5 = f3 - f4;
        if (f5 < 0.0f) {
            f5 = f4 - f3;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f4, f3);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration((int) (f5 * this.animationDuration));
        this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.postLayout = false;
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.juspay.hypersdk.mystique.AccordionLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                AccordionLayout.this.delta = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (AccordionLayout.this.postLayout) {
                    AccordionLayout.this.scrollParent();
                }
                AccordionLayout.this.requestLayout();
            }
        });
        this.animator.start();
    }

    public void setExpandAlpha(float f2) {
        this.alphaDelta = f2;
    }

    public void setExpandDuration(int i2) {
        this.animationDuration = i2;
    }

    public void setExpandParallax(float f2) {
        this.parallaxDelta = f2;
    }

    public void setScrollParent(int i2) {
        this.parentScrollViewId = i2;
    }

    public AccordionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.delta = 1.0f;
        this.target = 1.0f;
        this.parallaxDelta = 0.6f;
        this.alphaDelta = 1.0f;
        this.animationDuration = 300;
        this.parentScrollViewId = -1;
        this.postLayout = false;
        this.context = context;
    }

    public AccordionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.delta = 1.0f;
        this.target = 1.0f;
        this.parallaxDelta = 0.6f;
        this.alphaDelta = 1.0f;
        this.animationDuration = 300;
        this.parentScrollViewId = -1;
        this.postLayout = false;
        this.context = context;
    }

    public AccordionLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.delta = 1.0f;
        this.target = 1.0f;
        this.parallaxDelta = 0.6f;
        this.alphaDelta = 1.0f;
        this.animationDuration = 300;
        this.parentScrollViewId = -1;
        this.postLayout = false;
        this.context = context;
    }
}
