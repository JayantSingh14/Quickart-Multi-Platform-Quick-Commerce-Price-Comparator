package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes3.dex */
class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name */
    public Rect f12103a;

    @Override // android.animation.TypeEvaluator
    public final Rect evaluate(float f2, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        int i2 = rect3.left + ((int) ((rect4.left - r0) * f2));
        int i3 = rect3.top + ((int) ((rect4.top - r1) * f2));
        int i4 = rect3.right + ((int) ((rect4.right - r2) * f2));
        int i5 = rect3.bottom + ((int) ((rect4.bottom - r6) * f2));
        Rect rect5 = this.f12103a;
        if (rect5 == null) {
            return new Rect(i2, i3, i4, i5);
        }
        rect5.set(i2, i3, i4, i5);
        return rect5;
    }
}
