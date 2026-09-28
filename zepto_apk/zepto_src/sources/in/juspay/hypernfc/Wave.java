package in.juspay.hypernfc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class Wave extends View {
    private int offSet;

    @NotNull
    private final List<Paint> paints;

    @NotNull
    private final float[] radii;

    public Wave(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paints = new ArrayList();
        this.radii = new float[]{0.0f, 0.0f, 0.0f};
        int[] iArr = {200, 200, 200};
        for (int i2 = 0; i2 < 3; i2++) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#D9D9D9"));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(25.0f);
            paint.setAlpha(iArr[i2]);
            this.paints.add(paint);
        }
    }

    private final ValueAnimator createRingAnimator(Paint paint) {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(-1);
        animator.setDuration(4000L);
        animator.setInterpolator(new d());
        animator.addUpdateListener(new h(2, this, paint));
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createRingAnimator$lambda$1(float f2) {
        if (f2 < 0.5f) {
            return 2 * f2 * f2;
        }
        float f3 = 1;
        float f4 = f3 - f2;
        return f3 - ((2 * f4) * f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createRingAnimator$lambda$2(Wave this$0, Paint paint, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paint, "$paint");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        float width = ((1.5f * fFloatValue) * this$0.getWidth()) / 2;
        paint.setAlpha((int) ((1 - fFloatValue) * 150));
        for (int i2 = 0; i2 < 3; i2++) {
            if (paint == this$0.paints.get(i2)) {
                this$0.radii[i2] = width;
            }
        }
        this$0.invalidate();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i2 = this.offSet;
        for (int i3 = 0; i3 < 3; i3++) {
            canvas.drawCircle(width, i2, this.radii[i3], this.paints.get(i3));
        }
    }

    public final void startRippleAnimation(int i2) {
        this.offSet = i2;
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(createRingAnimator(this.paints.get(i3)));
        }
        for (final int i4 = 0; i4 < 2; i4++) {
            ((ValueAnimator) arrayList.get(i4)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.juspay.hypernfc.Wave.startRippleAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NotNull ValueAnimator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    if (animation.getCurrentPlayTime() >= 500) {
                        arrayList.get(i4 + 1).start();
                        arrayList.get(i4).removeUpdateListener(this);
                    }
                }
            });
        }
        ((ValueAnimator) arrayList.get(0)).start();
    }
}
