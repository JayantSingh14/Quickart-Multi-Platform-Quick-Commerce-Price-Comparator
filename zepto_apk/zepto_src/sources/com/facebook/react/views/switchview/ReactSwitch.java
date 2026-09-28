package com.facebook.react.views.switchview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import androidx.appcompat.widget.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ReactSwitch extends SwitchCompat {
    public boolean F0;
    public Integer G0;
    public Integer H0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSwitch(Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.F0 = true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}}, new int[]{i2}), new ColorDrawable(i2), null));
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) throws Resources.NotFoundException {
        if (!this.F0 || isChecked() == z) {
            super.setChecked(isChecked());
            return;
        }
        this.F0 = false;
        super.setChecked(z);
        setTrackColor(z);
    }

    public final void setOn(boolean z) throws Resources.NotFoundException {
        if (isChecked() != z) {
            super.setChecked(z);
            setTrackColor(z);
        }
        this.F0 = true;
    }

    public final void setThumbColor(@Nullable Integer num) {
        Drawable drawable = super.getThumbDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "getThumbDrawable(...)");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY));
        }
        if (num == null || !(getBackground() instanceof RippleDrawable)) {
            return;
        }
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}}, new int[]{num.intValue()});
        Drawable background = getBackground();
        Intrinsics.d(background, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        ((RippleDrawable) background).setColor(colorStateList);
    }

    public final void setTrackColor(@Nullable Integer num) {
        Drawable drawable = super.getTrackDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "getTrackDrawable(...)");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY));
        }
    }

    public final void setTrackColorForFalse(@Nullable Integer num) {
        if (Intrinsics.b(num, this.G0)) {
            return;
        }
        this.G0 = num;
        if (isChecked()) {
            return;
        }
        setTrackColor(this.G0);
    }

    public final void setTrackColorForTrue(@Nullable Integer num) {
        if (Intrinsics.b(num, this.H0)) {
            return;
        }
        this.H0 = num;
        if (isChecked()) {
            setTrackColor(this.H0);
        }
    }

    private final void setTrackColor(boolean z) {
        Integer num = this.H0;
        if (num == null && this.G0 == null) {
            return;
        }
        if (!z) {
            num = this.G0;
        }
        setTrackColor(num);
    }
}
