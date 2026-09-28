package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;

/* loaded from: classes3.dex */
final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f2861a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f2862b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f2863c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f2864d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i2 = this.f2861a;
        Drawable.ConstantState constantState = this.f2862b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        WrappedDrawableApi21 wrappedDrawableApi21 = new WrappedDrawableApi21();
        wrappedDrawableApi21.f2857d = this;
        Drawable.ConstantState constantState = this.f2862b;
        if (constantState != null) {
            wrappedDrawableApi21.b(constantState.newDrawable(resources));
        }
        if (WrappedDrawableApi21.f2860h == null) {
            try {
                WrappedDrawableApi21.f2860h = Drawable.class.getDeclaredMethod("isProjected", null);
                return wrappedDrawableApi21;
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
        return wrappedDrawableApi21;
    }
}
