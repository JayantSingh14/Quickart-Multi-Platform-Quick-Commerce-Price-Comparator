package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
class AppCompatCompoundButtonHelper {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f828a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f829b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f830c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f831d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f832e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f833f;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f828a = compoundButton;
    }

    public final void a() {
        CompoundButton compoundButton = this.f828a;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f831d || this.f832e) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.f831d) {
                    drawableMutate.setTintList(this.f829b);
                }
                if (this.f832e) {
                    drawableMutate.setTintMode(this.f830c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i2) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = this.f828a;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(compoundButton.getContext(), attributeSet, R.styleable.CompoundButton, i2);
        TypedArray typedArray = tintTypedArrayF.f1185b;
        ViewCompat.y(compoundButton, compoundButton.getContext(), R.styleable.CompoundButton, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        try {
            if (typedArray.hasValue(R.styleable.CompoundButton_buttonCompat) && (resourceId2 = typedArray.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AppCompatResources.b(resourceId2, compoundButton.getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = typedArray.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                compoundButton.setButtonDrawable(AppCompatResources.b(resourceId, compoundButton.getContext()));
            }
            if (typedArray.hasValue(R.styleable.CompoundButton_buttonTint)) {
                compoundButton.setButtonTintList(tintTypedArrayF.a(R.styleable.CompoundButton_buttonTint));
            }
            if (typedArray.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                compoundButton.setButtonTintMode(DrawableUtils.c(typedArray.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
            tintTypedArrayF.g();
        } catch (Throwable th) {
            tintTypedArrayF.g();
            throw th;
        }
    }
}
