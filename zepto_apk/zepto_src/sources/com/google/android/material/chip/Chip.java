package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {

    /* renamed from: e, reason: collision with root package name */
    public ChipDrawable f40210e;

    /* renamed from: f, reason: collision with root package name */
    public InsetDrawable f40211f;

    /* renamed from: g, reason: collision with root package name */
    public RippleDrawable f40212g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f40213h;

    /* renamed from: i, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f40214i;

    /* renamed from: j, reason: collision with root package name */
    public MaterialCheckable.OnCheckedChangeListener f40215j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40216k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f40217l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f40218m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public CharSequence r;
    public final ChipTouchHelper s;
    public boolean t;
    public final Rect u;
    public final RectF v;
    public final TextAppearanceFontCallback w;
    public static final int x = R.style.Widget_MaterialComponents_Chip_Action;
    public static final Rect y = new Rect();
    public static final int[] z = {android.R.attr.state_selected};
    public static final int[] A = {android.R.attr.state_checkable};

    public class ChipTouchHelper extends ExploreByTouchHelper {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final int e(float f2, float f3) {
            int i2 = Chip.x;
            Chip chip = Chip.this;
            return (chip.e() && chip.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void f(ArrayList arrayList) {
            ChipDrawable chipDrawable;
            arrayList.add(0);
            int i2 = Chip.x;
            Chip chip = Chip.this;
            if (!chip.e() || (chipDrawable = chip.f40210e) == null || !chipDrawable.L || chip.f40213h == null) {
                return;
            }
            arrayList.add(1);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final boolean j(int i2, int i3, Bundle bundle) {
            boolean z = false;
            if (i3 == 16) {
                Chip chip = Chip.this;
                if (i2 == 0) {
                    return chip.performClick();
                }
                if (i2 == 1) {
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.f40213h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    if (chip.t) {
                        chip.s.o(1, 1);
                    }
                }
            }
            return z;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void k(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Chip chip = Chip.this;
            ChipDrawable chipDrawable = chip.f40210e;
            accessibilityNodeInfoCompat.f3185a.setCheckable(chipDrawable != null && chipDrawable.A0);
            accessibilityNodeInfoCompat.n(chip.isClickable());
            accessibilityNodeInfoCompat.m(chip.getAccessibilityClassName());
            accessibilityNodeInfoCompat.w(chip.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void l(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i2 != 1) {
                accessibilityNodeInfoCompat.q("");
                accessibilityNodeInfoCompat.l(Chip.y);
                return;
            }
            Chip chip = Chip.this;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.q(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                accessibilityNodeInfoCompat.q(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfoCompat.l(chip.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3189g);
            accessibilityNodeInfoCompat.f3185a.setEnabled(chip.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void m(int i2, boolean z) {
            if (i2 == 1) {
                Chip chip = Chip.this;
                chip.n = z;
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.v;
        rectF.setEmpty();
        if (e() && this.f40213h != null) {
            ChipDrawable chipDrawable = this.f40210e;
            Rect bounds = chipDrawable.getBounds();
            rectF.setEmpty();
            if (chipDrawable.d0()) {
                float f2 = chipDrawable.N0 + chipDrawable.M0 + chipDrawable.Y + chipDrawable.L0 + chipDrawable.K0;
                if (chipDrawable.getLayoutDirection() == 0) {
                    float f3 = bounds.right;
                    rectF.right = f3;
                    rectF.left = f3 - f2;
                } else {
                    float f4 = bounds.left;
                    rectF.left = f4;
                    rectF.right = f4 + f2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i2 = (int) closeIconTouchBounds.left;
        int i3 = (int) closeIconTouchBounds.top;
        int i4 = (int) closeIconTouchBounds.right;
        int i5 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.u;
        rect.set(i2, i3, i4, i5);
        return rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.U0.f40646g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f40218m != z2) {
            this.f40218m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f40217l != z2) {
            this.f40217l = z2;
            refreshDrawableState();
        }
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public final void a() {
        d(this.q);
        requestLayout();
        invalidateOutline();
    }

    public final void d(int i2) {
        this.q = i2;
        if (!this.o) {
            InsetDrawable insetDrawable = this.f40211f;
            if (insetDrawable == null) {
                g();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f40211f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    g();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i2 - ((int) this.f40210e.A));
        int iMax2 = Math.max(0, i2 - this.f40210e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f40211f;
            if (insetDrawable2 == null) {
                g();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f40211f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    g();
                    return;
                }
                return;
            }
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.f40211f != null) {
            Rect rect = new Rect();
            this.f40211f.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                g();
                return;
            }
        }
        if (getMinHeight() != i2) {
            setMinHeight(i2);
        }
        if (getMinWidth() != i2) {
            setMinWidth(i2);
        }
        this.f40211f = new InsetDrawable((Drawable) this.f40210e, i3, i4, i3, i4);
        g();
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.t ? super.dispatchHoverEvent(motionEvent) : this.s.d(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.t
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r9.s
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            if (r1 == r2) goto L84
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L6e
            r5 = 66
            if (r1 == r5) goto L57
            switch(r1) {
                case 19: goto L29;
                case 20: goto L29;
                case 21: goto L29;
                case 22: goto L29;
                case 23: goto L57;
                default: goto L28;
            }
        L28:
            goto L84
        L29:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L84
            r7 = 19
            if (r1 == r7) goto L41
            r7 = 21
            if (r1 == r7) goto L3e
            r7 = 22
            if (r1 == r7) goto L43
            r5 = 130(0x82, float:1.82E-43)
            goto L43
        L3e:
            r5 = 17
            goto L43
        L41:
            r5 = 33
        L43:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r2
            r7 = r4
        L49:
            if (r4 >= r1) goto L55
            boolean r8 = r0.h(r5, r6)
            if (r8 == 0) goto L55
            int r4 = r4 + 1
            r7 = r2
            goto L49
        L55:
            r4 = r7
            goto L84
        L57:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L84
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L84
            int r1 = r0.f3333i
            if (r1 == r3) goto L6c
            r4 = 16
            r0.j(r1, r4, r6)
        L6c:
            r4 = r2
            goto L84
        L6e:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L7a
            r1 = 2
            boolean r4 = r0.h(r1, r6)
            goto L84
        L7a:
            boolean r1 = r10.hasModifiers(r2)
            if (r1 == 0) goto L84
            boolean r4 = r0.h(r2, r6)
        L84:
            if (r4 == 0) goto L8b
            int r0 = r0.f3333i
            if (r0 == r3) goto L8b
            return r2
        L8b:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i2;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f40210e;
        boolean zG = false;
        if (chipDrawable != null && ChipDrawable.E(chipDrawable.M)) {
            ChipDrawable chipDrawable2 = this.f40210e;
            ?? IsEnabled = isEnabled();
            int i3 = IsEnabled;
            if (this.n) {
                i3 = IsEnabled + 1;
            }
            int i4 = i3;
            if (this.f40218m) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.f40217l) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (isChecked()) {
                i6 = i5 + 1;
            }
            int[] iArr = new int[i6];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.n) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.f40218m) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.f40217l) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            if (!Arrays.equals(chipDrawable2.i1, iArr)) {
                chipDrawable2.i1 = iArr;
                if (chipDrawable2.d0()) {
                    zG = chipDrawable2.G(chipDrawable2.getState(), iArr);
                }
            }
        }
        if (zG) {
            invalidate();
        }
    }

    public final boolean e() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null) {
            return false;
        }
        Drawable drawable = chipDrawable.M;
        return (drawable != null ? DrawableCompat.o(drawable) : null) != null;
    }

    public final void f() {
        ChipDrawable chipDrawable;
        if (!e() || (chipDrawable = this.f40210e) == null || !chipDrawable.L || this.f40213h == null) {
            ViewCompat.z(this, null);
            this.t = false;
        } else {
            ViewCompat.z(this, this.s);
            this.t = true;
        }
    }

    public final void g() {
        this.f40212g = new RippleDrawable(RippleUtils.c(this.f40210e.E), getBackgroundDrawable(), null);
        this.f40210e.getClass();
        RippleDrawable rippleDrawable = this.f40212g;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setBackground(rippleDrawable);
        h();
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.r)) {
            return this.r;
        }
        ChipDrawable chipDrawable = this.f40210e;
        if (!(chipDrawable != null && chipDrawable.A0)) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).f40225h.f40542d) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f40211f;
        return insetDrawable == null ? this.f40210e : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.C0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.D0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.z;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return Math.max(0.0f, chipDrawable.C());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f40210e;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.N0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || (drawable = chipDrawable.H) == null) {
            return null;
        }
        return DrawableCompat.o(drawable);
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.J;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.I;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.A;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.G0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.C;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.D;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || (drawable = chipDrawable.M) == null) {
            return null;
        }
        return DrawableCompat.o(drawable);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.Z;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.M0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.Y;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.L0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.X;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.l1;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.t) {
            ChipTouchHelper chipTouchHelper = this.s;
            if (chipTouchHelper.f3333i == 1 || chipTouchHelper.f3332h == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.F0;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.I0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.H0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.E;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40210e.f40974a.f40989a;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.E0;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.K0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            return chipDrawable.J0;
        }
        return 0.0f;
    }

    public final void h() {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.f40210e) == null) {
            return;
        }
        int iB = (int) (chipDrawable.B() + chipDrawable.N0 + chipDrawable.K0);
        ChipDrawable chipDrawable2 = this.f40210e;
        int iA = (int) (chipDrawable2.A() + chipDrawable2.G0 + chipDrawable2.J0);
        if (this.f40211f != null) {
            Rect rect = new Rect();
            this.f40211f.getPadding(rect);
            iA += rect.left;
            iB += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setPaddingRelative(iA, paddingTop, iB, paddingBottom);
    }

    public final void i() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.w);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.c(this, this.f40210e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null && chipDrawable.A0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.t) {
            ChipTouchHelper chipTouchHelper = this.s;
            int i3 = chipTouchHelper.f3333i;
            if (i3 != Integer.MIN_VALUE) {
                chipTouchHelper.a(i3);
            }
            if (z2) {
                chipTouchHelper.h(i2, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        ChipDrawable chipDrawable = this.f40210e;
        int i3 = 0;
        accessibilityNodeInfo.setCheckable(chipDrawable != null && chipDrawable.A0);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            if (chipGroup.f40579c) {
                int i4 = 0;
                while (true) {
                    if (i3 >= chipGroup.getChildCount()) {
                        i4 = -1;
                        break;
                    }
                    View childAt = chipGroup.getChildAt(i3);
                    if ((childAt instanceof Chip) && chipGroup.getChildAt(i3).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    i3++;
                }
                i2 = i4;
            } else {
                i2 = -1;
            }
            Object tag = getTag(R.id.row_index_key);
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i2, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.p != i2) {
            this.p = i2;
            h();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f40217l
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = r3
            goto L51
        L2c:
            boolean r0 = r5.f40217l
            if (r0 == 0) goto L45
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f40213h
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.t
            if (r0 == 0) goto L43
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r5.s
            r0.o(r3, r3)
        L43:
            r0 = r3
            goto L46
        L45:
            r0 = r2
        L46:
            r5.setCloseIconPressed(r2)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r3)
            goto L2a
        L50:
            r0 = r2
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r2
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f40212g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f40212g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.H(z2);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.H(chipDrawable.O0.getResources().getBoolean(i2));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null) {
            this.f40216k = z2;
        } else if (chipDrawable.A0) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.I(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.I(AppCompatResources.b(i2, chipDrawable.O0));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.J(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.J(ContextCompat.b(i2, chipDrawable.O0));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.K(chipDrawable.O0.getResources().getBoolean(i2));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.z == colorStateList) {
            return;
        }
        chipDrawable.z = colorStateList;
        chipDrawable.onStateChange(chipDrawable.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        ColorStateList colorStateListB;
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.z == (colorStateListB = ContextCompat.b(i2, chipDrawable.O0))) {
            return;
        }
        chipDrawable.z = colorStateListB;
        chipDrawable.onStateChange(chipDrawable.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.L(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.L(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f40210e;
        if (chipDrawable2 != chipDrawable) {
            if (chipDrawable2 != null) {
                chipDrawable2.k1 = new WeakReference(null);
            }
            this.f40210e = chipDrawable;
            chipDrawable.m1 = false;
            chipDrawable.k1 = new WeakReference(this);
            d(this.q);
        }
    }

    public void setChipEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.N0 == f2) {
            return;
        }
        chipDrawable.N0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.F();
    }

    public void setChipEndPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float dimension = chipDrawable.O0.getResources().getDimension(i2);
            if (chipDrawable.N0 != dimension) {
                chipDrawable.N0 = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.F();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.M(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.M(AppCompatResources.b(i2, chipDrawable.O0));
        }
    }

    public void setChipIconSize(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.N(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.N(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.O(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.O(ContextCompat.b(i2, chipDrawable.O0));
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.P(chipDrawable.O0.getResources().getBoolean(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.A == f2) {
            return;
        }
        chipDrawable.A = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.F();
    }

    public void setChipMinHeightResource(@DimenRes int i2) throws Resources.NotFoundException {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float dimension = chipDrawable.O0.getResources().getDimension(i2);
            if (chipDrawable.A != dimension) {
                chipDrawable.A = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.F();
            }
        }
    }

    public void setChipStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.G0 == f2) {
            return;
        }
        chipDrawable.G0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.F();
    }

    public void setChipStartPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float dimension = chipDrawable.O0.getResources().getDimension(i2);
            if (chipDrawable.G0 != dimension) {
                chipDrawable.G0 = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.F();
            }
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Q(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Q(ContextCompat.b(i2, chipDrawable.O0));
        }
    }

    public void setChipStrokeWidth(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.R(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.R(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.S(drawable);
        }
        f();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.Z == charSequence) {
            return;
        }
        BidiFormatter bidiFormatterC = BidiFormatter.c();
        chipDrawable.Z = bidiFormatterC.d(charSequence, bidiFormatterC.f2944c);
        chipDrawable.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.T(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.T(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.S(AppCompatResources.b(i2, chipDrawable.O0));
        }
        f();
    }

    public void setCloseIconSize(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.U(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.U(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.V(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.V(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.W(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.W(ContextCompat.b(i2, chipDrawable.O0));
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.l(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f40210e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.l1 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.o = z2;
        d(this.q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.F0 = motionSpec;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.F0 = MotionSpec.b(i2, chipDrawable.O0);
        }
    }

    public void setIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Y(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Y(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Z(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.Z(chipDrawable.O0.getResources().getDimension(i2));
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    @RestrictTo
    public void setInternalOnCheckedChangeListener(@Nullable MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f40215j = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f40210e == null) {
            return;
        }
        super.setLayoutDirection(i2);
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.n1 = i2;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f40214i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f40213h = onClickListener;
        f();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.a0(colorStateList);
        }
        this.f40210e.getClass();
        g();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.a0(ContextCompat.b(i2, chipDrawable.O0));
            this.f40210e.getClass();
            g();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f40210e.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.E0 = motionSpec;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.E0 = MotionSpec.b(i2, chipDrawable.O0);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(chipDrawable.m1 ? null : charSequence, bufferType);
        ChipDrawable chipDrawable2 = this.f40210e;
        if (chipDrawable2 == null || TextUtils.equals(chipDrawable2.F, charSequence)) {
            return;
        }
        chipDrawable2.F = charSequence;
        chipDrawable2.U0.f40644e = true;
        chipDrawable2.invalidateSelf();
        chipDrawable2.F();
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.U0.c(textAppearance, chipDrawable.O0);
        }
        i();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.K0 == f2) {
            return;
        }
        chipDrawable.K0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.F();
    }

    public void setTextEndPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float dimension = chipDrawable.O0.getResources().getDimension(i2);
            if (chipDrawable.K0 != dimension) {
                chipDrawable.K0 = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.F();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float fApplyDimension = TypedValue.applyDimension(i2, f2, getResources().getDisplayMetrics());
            TextDrawableHelper textDrawableHelper = chipDrawable.U0;
            TextAppearance textAppearance = textDrawableHelper.f40646g;
            if (textAppearance != null) {
                textAppearance.f40878k = fApplyDimension;
                textDrawableHelper.f40640a.setTextSize(fApplyDimension);
                chipDrawable.a();
            }
        }
        i();
    }

    public void setTextStartPadding(float f2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable == null || chipDrawable.J0 == f2) {
            return;
        }
        chipDrawable.J0 = f2;
        chipDrawable.invalidateSelf();
        chipDrawable.F();
    }

    public void setTextStartPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            float dimension = chipDrawable.O0.getResources().getDimension(i2);
            if (chipDrawable.J0 != dimension) {
                chipDrawable.J0 = dimension;
                chipDrawable.invalidateSelf();
                chipDrawable.F();
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i2) {
        int resourceId;
        int i3 = x;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.u = new Rect();
        this.v = new RectF();
        this.w = new TextAppearanceFontCallback() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void a(int i4) {
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void b(Typeface typeface, boolean z2) {
                Chip chip = Chip.this;
                ChipDrawable chipDrawable = chip.f40210e;
                chip.setText(chipDrawable.m1 ? chipDrawable.F : chip.getText());
                chip.requestLayout();
                chip.invalidate();
            }
        };
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", AppStateModule.APP_STATE_BACKGROUND) != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i2);
        TypedArray typedArrayD = ThemeEnforcement.d(chipDrawable.O0, attributeSet, R.styleable.Chip, i2, i3, new int[0]);
        chipDrawable.o1 = typedArrayD.hasValue(R.styleable.Chip_shapeAppearance);
        int i4 = R.styleable.Chip_chipSurfaceColor;
        Context context3 = chipDrawable.O0;
        ColorStateList colorStateListA = MaterialResources.a(context3, typedArrayD, i4);
        if (chipDrawable.y != colorStateListA) {
            chipDrawable.y = colorStateListA;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        ColorStateList colorStateListA2 = MaterialResources.a(context3, typedArrayD, R.styleable.Chip_chipBackgroundColor);
        if (chipDrawable.z != colorStateListA2) {
            chipDrawable.z = colorStateListA2;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        float dimension = typedArrayD.getDimension(R.styleable.Chip_chipMinHeight, 0.0f);
        if (chipDrawable.A != dimension) {
            chipDrawable.A = dimension;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        if (typedArrayD.hasValue(R.styleable.Chip_chipCornerRadius)) {
            chipDrawable.L(typedArrayD.getDimension(R.styleable.Chip_chipCornerRadius, 0.0f));
        }
        chipDrawable.Q(MaterialResources.a(context3, typedArrayD, R.styleable.Chip_chipStrokeColor));
        chipDrawable.R(typedArrayD.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        chipDrawable.a0(MaterialResources.a(context3, typedArrayD, R.styleable.Chip_rippleColor));
        String text = typedArrayD.getText(R.styleable.Chip_android_text);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(chipDrawable.F, text);
        TextDrawableHelper textDrawableHelper = chipDrawable.U0;
        if (!zEquals) {
            chipDrawable.F = text;
            textDrawableHelper.f40644e = true;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        int i5 = R.styleable.Chip_android_textAppearance;
        TextAppearance textAppearance = (!typedArrayD.hasValue(i5) || (resourceId = typedArrayD.getResourceId(i5, 0)) == 0) ? null : new TextAppearance(context3, resourceId);
        textAppearance.f40878k = typedArrayD.getDimension(R.styleable.Chip_android_textSize, textAppearance.f40878k);
        textDrawableHelper.c(textAppearance, context3);
        int i6 = typedArrayD.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i6 == 1) {
            chipDrawable.l1 = TextUtils.TruncateAt.START;
        } else if (i6 == 2) {
            chipDrawable.l1 = TextUtils.TruncateAt.MIDDLE;
        } else if (i6 == 3) {
            chipDrawable.l1 = TextUtils.TruncateAt.END;
        }
        chipDrawable.P(typedArrayD.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            chipDrawable.P(typedArrayD.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        chipDrawable.M(MaterialResources.d(context3, typedArrayD, R.styleable.Chip_chipIcon));
        if (typedArrayD.hasValue(R.styleable.Chip_chipIconTint)) {
            chipDrawable.O(MaterialResources.a(context3, typedArrayD, R.styleable.Chip_chipIconTint));
        }
        chipDrawable.N(typedArrayD.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        chipDrawable.X(typedArrayD.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            chipDrawable.X(typedArrayD.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        chipDrawable.S(MaterialResources.d(context3, typedArrayD, R.styleable.Chip_closeIcon));
        chipDrawable.W(MaterialResources.a(context3, typedArrayD, R.styleable.Chip_closeIconTint));
        chipDrawable.U(typedArrayD.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        chipDrawable.H(typedArrayD.getBoolean(R.styleable.Chip_android_checkable, false));
        chipDrawable.K(typedArrayD.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            chipDrawable.K(typedArrayD.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        chipDrawable.I(MaterialResources.d(context3, typedArrayD, R.styleable.Chip_checkedIcon));
        if (typedArrayD.hasValue(R.styleable.Chip_checkedIconTint)) {
            chipDrawable.J(MaterialResources.a(context3, typedArrayD, R.styleable.Chip_checkedIconTint));
        }
        chipDrawable.E0 = MotionSpec.a(context3, typedArrayD, R.styleable.Chip_showMotionSpec);
        chipDrawable.F0 = MotionSpec.a(context3, typedArrayD, R.styleable.Chip_hideMotionSpec);
        float dimension2 = typedArrayD.getDimension(R.styleable.Chip_chipStartPadding, 0.0f);
        if (chipDrawable.G0 != dimension2) {
            chipDrawable.G0 = dimension2;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        chipDrawable.Z(typedArrayD.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        chipDrawable.Y(typedArrayD.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        float dimension3 = typedArrayD.getDimension(R.styleable.Chip_textStartPadding, 0.0f);
        if (chipDrawable.J0 != dimension3) {
            chipDrawable.J0 = dimension3;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        float dimension4 = typedArrayD.getDimension(R.styleable.Chip_textEndPadding, 0.0f);
        if (chipDrawable.K0 != dimension4) {
            chipDrawable.K0 = dimension4;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        chipDrawable.V(typedArrayD.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        chipDrawable.T(typedArrayD.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        float dimension5 = typedArrayD.getDimension(R.styleable.Chip_chipEndPadding, 0.0f);
        if (chipDrawable.N0 != dimension5) {
            chipDrawable.N0 = dimension5;
            chipDrawable.invalidateSelf();
            chipDrawable.F();
        }
        chipDrawable.n1 = typedArrayD.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        typedArrayD.recycle();
        int[] iArr = R.styleable.Chip;
        ThemeEnforcement.a(context2, attributeSet, i2, i3);
        ThemeEnforcement.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.q = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.d(48, getContext()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(chipDrawable);
        chipDrawable.l(ViewCompat.j(this));
        int[] iArr2 = R.styleable.Chip;
        ThemeEnforcement.a(context2, attributeSet, i2, i3);
        ThemeEnforcement.b(context2, attributeSet, iArr2, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr2, i2, i3);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(R.styleable.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes2.recycle();
        this.s = new ChipTouchHelper(this);
        f();
        if (!zHasValue) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view, Outline outline) {
                    ChipDrawable chipDrawable2 = Chip.this.f40210e;
                    if (chipDrawable2 != null) {
                        chipDrawable2.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.f40216k);
        setText(chipDrawable.F);
        setEllipsize(chipDrawable.l1);
        i();
        if (!this.f40210e.m1) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        h();
        if (this.o) {
            setMinHeight(this.q);
        }
        this.p = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.google.android.material.chip.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                Chip chip = this.f40233a;
                MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener = chip.f40215j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.a(chip, z2);
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = chip.f40214i;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(compoundButton, z2);
                }
            }
        });
    }

    public void setCloseIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.X(z2);
        }
        f();
    }

    public void setCheckedIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.K(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            chipDrawable.P(z2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            Context context2 = chipDrawable.O0;
            chipDrawable.U0.c(new TextAppearance(context2, i2), context2);
        }
        i();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        ChipDrawable chipDrawable = this.f40210e;
        if (chipDrawable != null) {
            Context context = chipDrawable.O0;
            chipDrawable.U0.c(new TextAppearance(context, i2), context);
        }
        i();
    }
}
