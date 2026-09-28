package androidx.core.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import in.juspay.hypernfc.Wave;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3215b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3216c;

    public /* synthetic */ h(int i2, Object obj, Object obj2) {
        this.f3214a = i2;
        this.f3215b = obj;
        this.f3216c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f3216c;
        Object obj2 = this.f3215b;
        switch (this.f3214a) {
            case 0:
                ((ViewPropertyAnimatorUpdateListener) obj2).a();
                break;
            case 1:
                int i2 = AppBarLayout.z;
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((MaterialShapeDrawable) obj).l(fFloatValue);
                Drawable drawable = appBarLayout.v;
                if (drawable instanceof MaterialShapeDrawable) {
                    ((MaterialShapeDrawable) drawable).l(fFloatValue);
                }
                Iterator it = appBarLayout.r.iterator();
                while (it.hasNext()) {
                    ((AppBarLayout.LiftOnScrollListener) it.next()).a();
                }
                break;
            default:
                Wave.createRingAnimator$lambda$2((Wave) obj2, (Paint) obj, valueAnimator);
                break;
        }
    }
}
