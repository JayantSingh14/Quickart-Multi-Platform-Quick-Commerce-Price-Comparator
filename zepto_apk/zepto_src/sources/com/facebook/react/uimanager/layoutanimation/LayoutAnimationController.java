package com.facebook.react.uimanager.layoutanimation;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes.dex */
public class LayoutAnimationController {

    @Nullable
    private Runnable mCompletionRunnable;
    private boolean mShouldAnimateLayout;
    private final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
    private final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
    private final AbstractLayoutAnimation mLayoutDeleteAnimation = new LayoutDeleteAnimation();
    private final SparseArray<LayoutHandlingAnimation> mLayoutHandlers = new SparseArray<>(0);
    private long mMaxAnimationDuration = -1;

    public static void b(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                b(viewGroup.getChildAt(i2));
            }
        }
    }

    public void applyLayoutUpdate(View view, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        final int id = view.getId();
        LayoutHandlingAnimation layoutHandlingAnimation = this.mLayoutHandlers.get(id);
        if (layoutHandlingAnimation != null) {
            layoutHandlingAnimation.a(i2, i3, i4, i5);
            return;
        }
        Animation animationA = ((view.getWidth() == 0 || view.getHeight() == 0) ? this.mLayoutCreateAnimation : this.mLayoutUpdateAnimation).a(view, i2, i3, i4, i5);
        if (animationA instanceof LayoutHandlingAnimation) {
            animationA.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.2
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    LayoutAnimationController.this.mLayoutHandlers.remove(id);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    LayoutAnimationController.this.mLayoutHandlers.put(id, (LayoutHandlingAnimation) animation);
                }
            });
        } else {
            view.layout(i2, i3, i2 + i4, i3 + i5);
        }
        if (animationA != null) {
            long duration = animationA.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                this.mMaxAnimationDuration = duration;
                if (this.mCompletionRunnable != null) {
                    Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
                    uiThreadHandler.removeCallbacks(this.mCompletionRunnable);
                    uiThreadHandler.postDelayed(this.mCompletionRunnable, duration);
                }
            }
            view.startAnimation(animationA);
        }
    }

    public void deleteView(View view, final LayoutAnimationListener layoutAnimationListener) {
        UiThreadUtil.assertOnUiThread();
        Animation animationA = this.mLayoutDeleteAnimation.a(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (animationA == null) {
            layoutAnimationListener.a();
            return;
        }
        b(view);
        animationA.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                layoutAnimationListener.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }
        });
        long duration = animationA.getDuration();
        if (duration > this.mMaxAnimationDuration) {
            if (this.mCompletionRunnable != null) {
                Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
                uiThreadHandler.removeCallbacks(this.mCompletionRunnable);
                uiThreadHandler.postDelayed(this.mCompletionRunnable, duration);
            }
            this.mMaxAnimationDuration = duration;
        }
        view.startAnimation(animationA);
    }

    public void initializeFromConfig(@Nullable ReadableMap readableMap, final Callback callback) {
        if (readableMap == null) {
            reset();
            return;
        }
        this.mShouldAnimateLayout = false;
        int i2 = readableMap.hasKey("duration") ? readableMap.getInt("duration") : 0;
        LayoutAnimationType layoutAnimationType = LayoutAnimationType.f19814b;
        if (readableMap.hasKey(LayoutAnimationType.a(layoutAnimationType))) {
            this.mLayoutCreateAnimation.c(i2, readableMap.getMap(LayoutAnimationType.a(layoutAnimationType)));
            this.mShouldAnimateLayout = true;
        }
        LayoutAnimationType layoutAnimationType2 = LayoutAnimationType.f19815c;
        if (readableMap.hasKey(LayoutAnimationType.a(layoutAnimationType2))) {
            this.mLayoutUpdateAnimation.c(i2, readableMap.getMap(LayoutAnimationType.a(layoutAnimationType2)));
            this.mShouldAnimateLayout = true;
        }
        LayoutAnimationType layoutAnimationType3 = LayoutAnimationType.f19816d;
        if (readableMap.hasKey(LayoutAnimationType.a(layoutAnimationType3))) {
            this.mLayoutDeleteAnimation.c(i2, readableMap.getMap(LayoutAnimationType.a(layoutAnimationType3)));
            this.mShouldAnimateLayout = true;
        }
        if (!this.mShouldAnimateLayout || callback == null) {
            return;
        }
        this.mCompletionRunnable = new Runnable() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.1
            @Override // java.lang.Runnable
            public final void run() {
                callback.invoke(Boolean.TRUE);
            }
        };
    }

    public void reset() {
        AbstractLayoutAnimation abstractLayoutAnimation = this.mLayoutCreateAnimation;
        abstractLayoutAnimation.f19791c = null;
        abstractLayoutAnimation.f19792d = 0;
        abstractLayoutAnimation.f19790b = 0;
        abstractLayoutAnimation.f19789a = null;
        AbstractLayoutAnimation abstractLayoutAnimation2 = this.mLayoutUpdateAnimation;
        abstractLayoutAnimation2.f19791c = null;
        abstractLayoutAnimation2.f19792d = 0;
        abstractLayoutAnimation2.f19790b = 0;
        abstractLayoutAnimation2.f19789a = null;
        AbstractLayoutAnimation abstractLayoutAnimation3 = this.mLayoutDeleteAnimation;
        abstractLayoutAnimation3.f19791c = null;
        abstractLayoutAnimation3.f19792d = 0;
        abstractLayoutAnimation3.f19790b = 0;
        abstractLayoutAnimation3.f19789a = null;
        this.mCompletionRunnable = null;
        this.mShouldAnimateLayout = false;
        this.mMaxAnimationDuration = -1L;
    }

    public boolean shouldAnimateLayout(View view) {
        if (view == null) {
            return false;
        }
        return (this.mShouldAnimateLayout && view.getParent() != null) || this.mLayoutHandlers.get(view.getId()) != null;
    }
}
