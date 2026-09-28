package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11006a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11007b;

    public /* synthetic */ g(Object obj, int i2) {
        this.f11006a = i2;
        this.f11007b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f11007b;
        switch (this.f11006a) {
            case 0:
                PlayerControlViewLayoutManager playerControlViewLayoutManager = (PlayerControlViewLayoutManager) obj;
                playerControlViewLayoutManager.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view = playerControlViewLayoutManager.f10894b;
                if (view != null) {
                    view.setAlpha(fFloatValue);
                }
                ViewGroup viewGroup = playerControlViewLayoutManager.f10895c;
                if (viewGroup != null) {
                    viewGroup.setAlpha(fFloatValue);
                }
                ViewGroup viewGroup2 = playerControlViewLayoutManager.f10897e;
                if (viewGroup2 != null) {
                    viewGroup2.setAlpha(fFloatValue);
                    break;
                }
                break;
            case 1:
                PlayerControlViewLayoutManager playerControlViewLayoutManager2 = (PlayerControlViewLayoutManager) obj;
                playerControlViewLayoutManager2.getClass();
                playerControlViewLayoutManager2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                PlayerControlViewLayoutManager playerControlViewLayoutManager3 = (PlayerControlViewLayoutManager) obj;
                playerControlViewLayoutManager3.getClass();
                playerControlViewLayoutManager3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 3:
                PlayerControlViewLayoutManager playerControlViewLayoutManager4 = (PlayerControlViewLayoutManager) obj;
                playerControlViewLayoutManager4.getClass();
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view2 = playerControlViewLayoutManager4.f10894b;
                if (view2 != null) {
                    view2.setAlpha(fFloatValue2);
                }
                ViewGroup viewGroup3 = playerControlViewLayoutManager4.f10895c;
                if (viewGroup3 != null) {
                    viewGroup3.setAlpha(fFloatValue2);
                }
                ViewGroup viewGroup4 = playerControlViewLayoutManager4.f10897e;
                if (viewGroup4 != null) {
                    viewGroup4.setAlpha(fFloatValue2);
                    break;
                }
                break;
            default:
                int i2 = DefaultTimeBar.B0;
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) obj;
                defaultTimeBar.getClass();
                defaultTimeBar.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f10836a);
                break;
        }
    }
}
