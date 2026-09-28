package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.media3.exoplayer.analytics.p;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.CutoutDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int l1 = R.style.Widget_Design_TextInputLayout;
    public static final int[][] m1 = {new int[]{android.R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public int A0;
    public ColorStateList B;
    public int B0;
    public boolean C;
    public int C0;
    public CharSequence D;
    public int D0;
    public boolean E;
    public int E0;
    public MaterialShapeDrawable F;
    public int F0;
    public MaterialShapeDrawable G;
    public int G0;
    public StateListDrawable H;
    public final Rect H0;
    public boolean I;
    public final Rect I0;
    public MaterialShapeDrawable J;
    public final RectF J0;
    public MaterialShapeDrawable K;
    public Typeface K0;
    public ShapeAppearanceModel L;
    public ColorDrawable L0;
    public boolean M;
    public int M0;
    public final LinkedHashSet N0;
    public ColorDrawable O0;
    public int P0;
    public final int Q;
    public Drawable Q0;
    public ColorStateList R0;
    public ColorStateList S0;
    public int T0;
    public int U0;
    public int V0;
    public ColorStateList W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f41354a;
    public int a1;

    /* renamed from: b, reason: collision with root package name */
    public final StartCompoundLayout f41355b;
    public int b1;

    /* renamed from: c, reason: collision with root package name */
    public final EndCompoundLayout f41356c;
    public int c1;

    /* renamed from: d, reason: collision with root package name */
    public EditText f41357d;
    public boolean d1;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f41358e;
    public final CollapsingTextHelper e1;

    /* renamed from: f, reason: collision with root package name */
    public int f41359f;
    public boolean f1;

    /* renamed from: g, reason: collision with root package name */
    public int f41360g;
    public boolean g1;

    /* renamed from: h, reason: collision with root package name */
    public int f41361h;
    public ValueAnimator h1;

    /* renamed from: i, reason: collision with root package name */
    public int f41362i;
    public boolean i1;

    /* renamed from: j, reason: collision with root package name */
    public final IndicatorViewController f41363j;
    public boolean j1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41364k;
    public boolean k1;

    /* renamed from: l, reason: collision with root package name */
    public int f41365l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41366m;
    public LengthCounter n;
    public AppCompatTextView o;
    public int p;
    public int q;
    public CharSequence r;
    public boolean s;
    public AppCompatTextView t;
    public ColorStateList u;
    public int v;
    public Fade w;
    public Fade x;
    public ColorStateList y;
    public ColorStateList z;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        public final TextInputLayout f41372a;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f41372a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            TextInputLayout textInputLayout = this.f41372a;
            EditText editText = textInputLayout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean z = textInputLayout.d1;
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            StartCompoundLayout startCompoundLayout = textInputLayout.f41355b;
            AppCompatTextView appCompatTextView = startCompoundLayout.f41343b;
            int visibility = appCompatTextView.getVisibility();
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
            if (visibility == 0) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView);
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            } else {
                accessibilityNodeInfo.setTraversalAfter(startCompoundLayout.f41345d);
            }
            if (!zIsEmpty) {
                accessibilityNodeInfoCompat.w(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.w(string);
                if (!z && placeholderText != null) {
                    accessibilityNodeInfoCompat.w(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.w(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    accessibilityNodeInfoCompat.s(string);
                } else {
                    if (!zIsEmpty) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.w(string);
                }
                if (i2 >= 26) {
                    accessibilityNodeInfo.setShowingHintText(zIsEmpty);
                } else {
                    accessibilityNodeInfoCompat.k(4, zIsEmpty);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
            if (z2) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfo.setError(error);
            }
            AppCompatTextView appCompatTextView2 = textInputLayout.f41363j.y;
            if (appCompatTextView2 != null) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView2);
            }
            textInputLayout.f41356c.b().n(accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f41372a.f41356c.b().o(accessibilityEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int c(Editable editable);
    }

    public interface OnEditTextAttachedListener {
        void a(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void a();
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f41373c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f41374d;

        /* renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f41373c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f41374d = parcel.readInt() == 1;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f41373c) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f41373c, parcel, i2);
            parcel.writeInt(this.f41374d ? 1 : 0);
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f41357d;
        if (!(editText instanceof AutoCompleteTextView) || EditTextUtils.a(editText)) {
            return this.F;
        }
        int iB = MaterialColors.b(R.attr.colorControlHighlight, this.f41357d);
        int i2 = this.A0;
        int[][] iArr = m1;
        if (i2 != 2) {
            if (i2 != 1) {
                return null;
            }
            MaterialShapeDrawable materialShapeDrawable = this.F;
            int i3 = this.G0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.g(0.1f, iB, i3), i3}), materialShapeDrawable, materialShapeDrawable);
        }
        Context context = getContext();
        MaterialShapeDrawable materialShapeDrawable2 = this.F;
        int iD = MaterialColors.d(context, R.attr.colorSurface, "TextInputLayout");
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable2.f40974a.f40989a);
        int iG = MaterialColors.g(0.1f, iB, iD);
        materialShapeDrawable3.m(new ColorStateList(iArr, new int[]{iG, 0}));
        materialShapeDrawable3.setTint(iD);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iG, iD});
        MaterialShapeDrawable materialShapeDrawable4 = new MaterialShapeDrawable(materialShapeDrawable2.f40974a.f40989a);
        materialShapeDrawable4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable3, materialShapeDrawable4), materialShapeDrawable2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.H == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.H = stateListDrawable;
            stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.H.addState(new int[0], f(false));
        }
        return this.H;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.G == null) {
            this.G = f(true);
        }
        return this.G;
    }

    public static void k(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) throws Resources.NotFoundException {
        if (this.f41357d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f41357d = editText;
        int i2 = this.f41359f;
        if (i2 != -1) {
            setMinEms(i2);
        } else {
            setMinWidth(this.f41361h);
        }
        int i3 = this.f41360g;
        if (i3 != -1) {
            setMaxEms(i3);
        } else {
            setMaxWidth(this.f41362i);
        }
        this.I = false;
        i();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        Typeface typeface = this.f41357d.getTypeface();
        CollapsingTextHelper collapsingTextHelper = this.e1;
        boolean zM = collapsingTextHelper.m(typeface);
        boolean zO = collapsingTextHelper.o(typeface);
        if (zM || zO) {
            collapsingTextHelper.i(false);
        }
        float textSize = this.f41357d.getTextSize();
        if (collapsingTextHelper.f40564l != textSize) {
            collapsingTextHelper.f40564l = textSize;
            collapsingTextHelper.i(false);
        }
        int i4 = Build.VERSION.SDK_INT;
        float letterSpacing = this.f41357d.getLetterSpacing();
        if (collapsingTextHelper.g0 != letterSpacing) {
            collapsingTextHelper.g0 = letterSpacing;
            collapsingTextHelper.i(false);
        }
        int gravity = this.f41357d.getGravity();
        collapsingTextHelper.l((gravity & (-113)) | 48);
        if (collapsingTextHelper.f40562j != gravity) {
            collapsingTextHelper.f40562j = gravity;
            collapsingTextHelper.i(false);
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        this.c1 = editText.getMinimumHeight();
        this.f41357d.addTextChangedListener(new TextWatcher(editText) { // from class: com.google.android.material.textfield.TextInputLayout.1

            /* renamed from: a, reason: collision with root package name */
            public int f41367a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ EditText f41368b;

            {
                this.f41368b = editText;
                this.f41367a = editText.getLineCount();
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) throws Resources.NotFoundException {
                TextInputLayout textInputLayout = TextInputLayout.this;
                textInputLayout.u(!textInputLayout.j1, false);
                if (textInputLayout.f41364k) {
                    textInputLayout.n(editable);
                }
                if (textInputLayout.s) {
                    textInputLayout.v(editable);
                }
                EditText editText2 = this.f41368b;
                int lineCount = editText2.getLineCount();
                int i5 = this.f41367a;
                if (lineCount != i5) {
                    if (lineCount < i5) {
                        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                        int minimumHeight = editText2.getMinimumHeight();
                        int i6 = textInputLayout.c1;
                        if (minimumHeight != i6) {
                            editText2.setMinimumHeight(i6);
                        }
                    }
                    this.f41367a = lineCount;
                }
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }
        });
        if (this.R0 == null) {
            this.R0 = this.f41357d.getHintTextColors();
        }
        if (this.C) {
            if (TextUtils.isEmpty(this.D)) {
                CharSequence hint = this.f41357d.getHint();
                this.f41358e = hint;
                setHint(hint);
                this.f41357d.setHint((CharSequence) null);
            }
            this.E = true;
        }
        if (i4 >= 29) {
            p();
        }
        if (this.o != null) {
            n(this.f41357d.getText());
        }
        r();
        this.f41363j.b();
        this.f41355b.bringToFront();
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.bringToFront();
        Iterator it = this.N0.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).a(this);
        }
        endCompoundLayout.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.D)) {
            return;
        }
        this.D = charSequence;
        CollapsingTextHelper collapsingTextHelper = this.e1;
        if (charSequence == null || !TextUtils.equals(collapsingTextHelper.G, charSequence)) {
            collapsingTextHelper.G = charSequence;
            collapsingTextHelper.H = null;
            Bitmap bitmap = collapsingTextHelper.K;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.K = null;
            }
            collapsingTextHelper.i(false);
        }
        if (this.d1) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.s == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.t;
            if (appCompatTextView != null) {
                this.f41354a.addView(appCompatTextView);
                this.t.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.t;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.t = null;
        }
        this.s = z;
    }

    public final void a(float f2) {
        CollapsingTextHelper collapsingTextHelper = this.e1;
        if (collapsingTextHelper.f40554b == f2) {
            return;
        }
        if (this.h1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.h1 = valueAnimator;
            valueAnimator.setInterpolator(MotionUtils.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.f39817b));
            this.h1.setDuration(MotionUtils.c(getContext(), R.attr.motionDurationMedium4, 167));
            this.h1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TextInputLayout.this.e1.p(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.h1.setFloatValues(collapsingTextHelper.f40554b, f2);
        this.h1.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f41354a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    public final void b() {
        int i2;
        int i3;
        MaterialShapeDrawable materialShapeDrawable = this.F;
        if (materialShapeDrawable == null) {
            return;
        }
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.f40974a.f40989a;
        ShapeAppearanceModel shapeAppearanceModel2 = this.L;
        if (shapeAppearanceModel != shapeAppearanceModel2) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (this.A0 == 2 && (i2 = this.C0) > -1 && (i3 = this.F0) != 0) {
            MaterialShapeDrawable materialShapeDrawable2 = this.F;
            materialShapeDrawable2.u(i2);
            materialShapeDrawable2.t(ColorStateList.valueOf(i3));
        }
        int iH = this.G0;
        if (this.A0 == 1) {
            iH = ColorUtils.h(this.G0, MaterialColors.c(getContext(), R.attr.colorSurface, 0));
        }
        this.G0 = iH;
        this.F.m(ColorStateList.valueOf(iH));
        MaterialShapeDrawable materialShapeDrawable3 = this.J;
        if (materialShapeDrawable3 != null && this.K != null) {
            if (this.C0 > -1 && this.F0 != 0) {
                materialShapeDrawable3.m(this.f41357d.isFocused() ? ColorStateList.valueOf(this.T0) : ColorStateList.valueOf(this.F0));
                this.K.m(ColorStateList.valueOf(this.F0));
            }
            invalidate();
        }
        s();
    }

    public final int c() {
        float fE;
        if (!this.C) {
            return 0;
        }
        int i2 = this.A0;
        CollapsingTextHelper collapsingTextHelper = this.e1;
        if (i2 == 0) {
            fE = collapsingTextHelper.e();
        } else {
            if (i2 != 2) {
                return 0;
            }
            fE = collapsingTextHelper.e() / 2.0f;
        }
        return (int) fE;
    }

    public final Fade d() {
        Fade fade = new Fade();
        fade.f12117c = MotionUtils.c(getContext(), R.attr.motionDurationShort2, 87);
        fade.f12118d = MotionUtils.d(getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.f39816a);
        return fade;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f41357d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f41358e != null) {
            boolean z = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f41357d.setHint(this.f41358e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f41357d.setHint(hint);
                this.E = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        FrameLayout frameLayout = this.f41354a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i3 = 0; i3 < frameLayout.getChildCount(); i3++) {
            View childAt = frameLayout.getChildAt(i3);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i2);
            if (childAt == this.f41357d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.j1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.j1 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        super.draw(canvas);
        boolean z = this.C;
        CollapsingTextHelper collapsingTextHelper = this.e1;
        if (z) {
            collapsingTextHelper.d(canvas);
        }
        if (this.K == null || (materialShapeDrawable = this.J) == null) {
            return;
        }
        materialShapeDrawable.draw(canvas);
        if (this.f41357d.isFocused()) {
            Rect bounds = this.K.getBounds();
            Rect bounds2 = this.J.getBounds();
            float f2 = collapsingTextHelper.f40554b;
            int iCenterX = bounds2.centerX();
            bounds.left = AnimationUtils.c(f2, iCenterX, bounds2.left);
            bounds.right = AnimationUtils.c(f2, iCenterX, bounds2.right);
            this.K.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            boolean r0 = r4.i1
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.i1 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.CollapsingTextHelper r3 = r4.e1
            if (r3 == 0) goto L2f
            r3.R = r1
            android.content.res.ColorStateList r1 = r3.o
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.n
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.i(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f41357d
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = androidx.core.view.ViewCompat.f3080a
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.u(r0, r2)
        L47:
            r4.r()
            r4.x()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.i1 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof CutoutDrawable);
    }

    public final MaterialShapeDrawable f(boolean z) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float f2 = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f41357d;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.h(f2);
        builder.k(f2);
        builder.d(dimensionPixelOffset);
        builder.e(dimensionPixelOffset);
        ShapeAppearanceModel shapeAppearanceModelA = builder.a();
        EditText editText2 = this.f41357d;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = MaterialShapeDrawable.x;
            dropDownBackgroundTintList = ColorStateList.valueOf(MaterialColors.d(context, R.attr.colorSurface, "MaterialShapeDrawable"));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.k(context);
        materialShapeDrawable.m(dropDownBackgroundTintList);
        materialShapeDrawable.l(popupElevation);
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelA);
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.f40974a;
        if (materialShapeDrawableState.f40995g == null) {
            materialShapeDrawableState.f40995g = new Rect();
        }
        materialShapeDrawable.f40974a.f40995g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        materialShapeDrawable.invalidateSelf();
        return materialShapeDrawable;
    }

    public final int g(int i2, boolean z) {
        int iC;
        if (!z && getPrefixText() != null) {
            iC = this.f41355b.a();
        } else {
            if (!z || getSuffixText() == null) {
                return this.f41357d.getCompoundPaddingLeft() + i2;
            }
            iC = this.f41356c.c();
        }
        return i2 + iC;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f41357d;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i2 = this.A0;
        if (i2 == 1 || i2 == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.G0;
    }

    public int getBoxBackgroundMode() {
        return this.A0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.B0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zH = ViewUtils.h(this);
        RectF rectF = this.J0;
        return zH ? this.L.f41014h.a(rectF) : this.L.f41013g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zH = ViewUtils.h(this);
        RectF rectF = this.J0;
        return zH ? this.L.f41013g.a(rectF) : this.L.f41014h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zH = ViewUtils.h(this);
        RectF rectF = this.J0;
        return zH ? this.L.f41011e.a(rectF) : this.L.f41012f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zH = ViewUtils.h(this);
        RectF rectF = this.J0;
        return zH ? this.L.f41012f.a(rectF) : this.L.f41011e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.V0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.W0;
    }

    public int getBoxStrokeWidth() {
        return this.D0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.E0;
    }

    public int getCounterMaxLength() {
        return this.f41365l;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f41364k && this.f41366m && (appCompatTextView = this.o) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.z;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.y;
    }

    @Nullable
    @RequiresApi
    public ColorStateList getCursorColor() {
        return this.A;
    }

    @Nullable
    @RequiresApi
    public ColorStateList getCursorErrorColor() {
        return this.B;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.R0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f41357d;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f41356c.f41290g.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f41356c.f41290g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f41356c.f41296m;
    }

    public int getEndIconMode() {
        return this.f41356c.f41292i;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f41356c.n;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f41356c.f41290g;
    }

    @Nullable
    public CharSequence getError() {
        IndicatorViewController indicatorViewController = this.f41363j;
        if (indicatorViewController.q) {
            return indicatorViewController.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f41363j.t;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f41363j.s;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f41363j.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f41356c.f41286c.getDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController = this.f41363j;
        if (indicatorViewController.x) {
            return indicatorViewController.w;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f41363j.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.e1.e();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        CollapsingTextHelper collapsingTextHelper = this.e1;
        return collapsingTextHelper.f(collapsingTextHelper.o);
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.S0;
    }

    @NonNull
    public LengthCounter getLengthCounter() {
        return this.n;
    }

    public int getMaxEms() {
        return this.f41360g;
    }

    @Px
    public int getMaxWidth() {
        return this.f41362i;
    }

    public int getMinEms() {
        return this.f41359f;
    }

    @Px
    public int getMinWidth() {
        return this.f41361h;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f41356c.f41290g.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f41356c.f41290g.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.s) {
            return this.r;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.v;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f41355b.f41344c;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f41355b.f41343b.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f41355b.f41343b;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.L;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f41355b.f41345d.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f41355b.f41345d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f41355b.f41348g;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f41355b.f41349h;
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f41356c.p;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f41356c.q.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f41356c.q;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.K0;
    }

    public final int h(int i2, boolean z) {
        return i2 - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.f41357d.getCompoundPaddingRight() : this.f41355b.a() : this.f41356c.c());
    }

    public final void i() throws Resources.NotFoundException {
        int i2 = this.A0;
        if (i2 == 0) {
            this.F = null;
            this.J = null;
            this.K = null;
        } else if (i2 == 1) {
            this.F = new MaterialShapeDrawable(this.L);
            this.J = new MaterialShapeDrawable();
            this.K = new MaterialShapeDrawable();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(android.support.v4.media.b.o(new StringBuilder(), this.A0, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.C || (this.F instanceof CutoutDrawable)) {
                this.F = new MaterialShapeDrawable(this.L);
            } else {
                ShapeAppearanceModel shapeAppearanceModel = this.L;
                int i3 = CutoutDrawable.z;
                if (shapeAppearanceModel == null) {
                    shapeAppearanceModel = new ShapeAppearanceModel();
                }
                CutoutDrawable.CutoutDrawableState cutoutDrawableState = new CutoutDrawable.CutoutDrawableState(shapeAppearanceModel, new RectF());
                CutoutDrawable.ImplApi18 implApi18 = new CutoutDrawable.ImplApi18(cutoutDrawableState);
                implApi18.y = cutoutDrawableState;
                this.F = implApi18;
            }
            this.J = null;
            this.K = null;
        }
        s();
        x();
        if (this.A0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.B0 = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.e(getContext())) {
                this.B0 = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f41357d != null && this.A0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.f41357d;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                editText.setPaddingRelative(editText.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.f41357d.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.e(getContext())) {
                EditText editText2 = this.f41357d;
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.f41357d.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.A0 != 0) {
            t();
        }
        EditText editText3 = this.f41357d;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i4 = this.A0;
                if (i4 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i4 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.j():void");
    }

    public final void l(AppCompatTextView appCompatTextView, int i2) {
        try {
            appCompatTextView.setTextAppearance(i2);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(getContext().getColor(R.color.design_error));
    }

    public final boolean m() {
        IndicatorViewController indicatorViewController = this.f41363j;
        return (indicatorViewController.o != 1 || indicatorViewController.r == null || TextUtils.isEmpty(indicatorViewController.p)) ? false : true;
    }

    public final void n(Editable editable) throws Resources.NotFoundException {
        int iC = this.n.c(editable);
        boolean z = this.f41366m;
        int i2 = this.f41365l;
        String string = null;
        if (i2 == -1) {
            this.o.setText(String.valueOf(iC));
            this.o.setContentDescription(null);
            this.f41366m = false;
        } else {
            this.f41366m = iC > i2;
            Context context = getContext();
            this.o.setContentDescription(context.getString(this.f41366m ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(iC), Integer.valueOf(this.f41365l)));
            if (z != this.f41366m) {
                o();
            }
            BidiFormatter bidiFormatterC = BidiFormatter.c();
            AppCompatTextView appCompatTextView = this.o;
            String string2 = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(iC), Integer.valueOf(this.f41365l));
            if (string2 == null) {
                bidiFormatterC.getClass();
            } else {
                string = bidiFormatterC.d(string2, bidiFormatterC.f2944c).toString();
            }
            appCompatTextView.setText(string);
        }
        if (this.f41357d == null || z == this.f41366m) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.o;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.f41366m ? this.p : this.q);
            if (!this.f41366m && (colorStateList2 = this.y) != null) {
                this.o.setTextColor(colorStateList2);
            }
            if (!this.f41366m || (colorStateList = this.z) == null) {
                return;
            }
            this.o.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.e1.h(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.k1 = false;
        if (this.f41357d != null && this.f41357d.getMeasuredHeight() < (iMax = Math.max(endCompoundLayout.getMeasuredHeight(), this.f41355b.getMeasuredHeight()))) {
            this.f41357d.setMinimumHeight(iMax);
            z = true;
        }
        boolean zQ = q();
        if (z || zQ) {
            this.f41357d.post(new d(this, 2));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f41357d;
        if (editText != null) {
            Rect rect = this.H0;
            DescendantOffsetUtils.a(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.J;
            if (materialShapeDrawable != null) {
                int i6 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i6 - this.D0, rect.right, i6);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.K;
            if (materialShapeDrawable2 != null) {
                int i7 = rect.bottom;
                materialShapeDrawable2.setBounds(rect.left, i7 - this.E0, rect.right, i7);
            }
            if (this.C) {
                float textSize = this.f41357d.getTextSize();
                CollapsingTextHelper collapsingTextHelper = this.e1;
                if (collapsingTextHelper.f40564l != textSize) {
                    collapsingTextHelper.f40564l = textSize;
                    collapsingTextHelper.i(false);
                }
                int gravity = this.f41357d.getGravity();
                collapsingTextHelper.l((gravity & (-113)) | 48);
                if (collapsingTextHelper.f40562j != gravity) {
                    collapsingTextHelper.f40562j = gravity;
                    collapsingTextHelper.i(false);
                }
                if (this.f41357d == null) {
                    throw new IllegalStateException();
                }
                boolean zH = ViewUtils.h(this);
                int i8 = rect.bottom;
                Rect rect2 = this.I0;
                rect2.bottom = i8;
                int i9 = this.A0;
                if (i9 == 1) {
                    rect2.left = g(rect.left, zH);
                    rect2.top = rect.top + this.B0;
                    rect2.right = h(rect.right, zH);
                } else if (i9 != 2) {
                    rect2.left = g(rect.left, zH);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, zH);
                } else {
                    rect2.left = this.f41357d.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.f41357d.getPaddingRight();
                }
                int i10 = rect2.left;
                int i11 = rect2.top;
                int i12 = rect2.right;
                int i13 = rect2.bottom;
                Rect rect3 = collapsingTextHelper.f40560h;
                if (rect3.left != i10 || rect3.top != i11 || rect3.right != i12 || rect3.bottom != i13) {
                    rect3.set(i10, i11, i12, i13);
                    collapsingTextHelper.S = true;
                }
                if (this.f41357d == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = collapsingTextHelper.U;
                textPaint.setTextSize(collapsingTextHelper.f40564l);
                textPaint.setTypeface(collapsingTextHelper.z);
                textPaint.setLetterSpacing(collapsingTextHelper.g0);
                float f2 = -textPaint.ascent();
                rect2.left = this.f41357d.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.A0 != 1 || this.f41357d.getMinLines() > 1) ? rect.top + this.f41357d.getCompoundPaddingTop() : (int) (rect.centerY() - (f2 / 2.0f));
                rect2.right = rect.right - this.f41357d.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.A0 != 1 || this.f41357d.getMinLines() > 1) ? rect.bottom - this.f41357d.getCompoundPaddingBottom() : (int) (rect2.top + f2);
                rect2.bottom = compoundPaddingBottom;
                int i14 = rect2.left;
                int i15 = rect2.top;
                int i16 = rect2.right;
                Rect rect4 = collapsingTextHelper.f40559g;
                if (rect4.left != i14 || rect4.top != i15 || rect4.right != i16 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i14, i15, i16, compoundPaddingBottom);
                    collapsingTextHelper.S = true;
                }
                collapsingTextHelper.i(false);
                if (!e() || this.d1) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        EditText editText;
        super.onMeasure(i2, i3);
        boolean z = this.k1;
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (!z) {
            endCompoundLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.k1 = true;
        }
        if (this.t != null && (editText = this.f41357d) != null) {
            this.t.setGravity(editText.getGravity());
            this.t.setPadding(this.f41357d.getCompoundPaddingLeft(), this.f41357d.getCompoundPaddingTop(), this.f41357d.getCompoundPaddingRight(), this.f41357d.getCompoundPaddingBottom());
        }
        endCompoundLayout.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        setError(savedState.f41373c);
        if (savedState.f41374d) {
            post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public final void run() {
                    CheckableImageButton checkableImageButton = TextInputLayout.this.f41356c.f41290g;
                    checkableImageButton.performClick();
                    checkableImageButton.jumpDrawablesToCurrentState();
                }
            });
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        boolean z = i2 == 1;
        if (z != this.M) {
            CornerSize cornerSize = this.L.f41011e;
            RectF rectF = this.J0;
            float fA = cornerSize.a(rectF);
            float fA2 = this.L.f41012f.a(rectF);
            float fA3 = this.L.f41014h.a(rectF);
            float fA4 = this.L.f41013g.a(rectF);
            ShapeAppearanceModel shapeAppearanceModel = this.L;
            CornerTreatment cornerTreatment = shapeAppearanceModel.f41007a;
            CornerTreatment cornerTreatment2 = shapeAppearanceModel.f41008b;
            CornerTreatment cornerTreatment3 = shapeAppearanceModel.f41010d;
            CornerTreatment cornerTreatment4 = shapeAppearanceModel.f41009c;
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
            builder.g(cornerTreatment2);
            builder.j(cornerTreatment);
            builder.f41022d = cornerTreatment4;
            float fB = ShapeAppearanceModel.Builder.b(cornerTreatment4);
            if (fB != -1.0f) {
                builder.d(fB);
            }
            builder.f41021c = cornerTreatment3;
            float fB2 = ShapeAppearanceModel.Builder.b(cornerTreatment3);
            if (fB2 != -1.0f) {
                builder.e(fB2);
            }
            builder.h(fA2);
            builder.k(fA);
            builder.d(fA4);
            builder.e(fA3);
            ShapeAppearanceModel shapeAppearanceModelA = builder.a();
            this.M = z;
            setShapeAppearanceModel(shapeAppearanceModelA);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (m()) {
            savedState.f41373c = getError();
        }
        EndCompoundLayout endCompoundLayout = this.f41356c;
        savedState.f41374d = endCompoundLayout.f41292i != 0 && endCompoundLayout.f41290g.f40546d;
        return savedState;
    }

    public final void p() {
        ColorStateList colorStateList;
        ColorStateList colorStateListE = this.A;
        if (colorStateListE == null) {
            colorStateListE = MaterialColors.e(R.attr.colorControlActivated, getContext());
        }
        EditText editText = this.f41357d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = this.f41357d.getTextCursorDrawable().mutate();
        if ((m() || (this.o != null && this.f41366m)) && (colorStateList = this.B) != null) {
            colorStateListE = colorStateList;
        }
        drawableMutate.setTintList(colorStateListE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.f41357d;
        if (editText == null || this.A0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = DrawableUtils.f1008a;
        Drawable drawableMutate = background.mutate();
        if (m()) {
            drawableMutate.setColorFilter(AppCompatDrawableManager.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f41366m && (appCompatTextView = this.o) != null) {
            drawableMutate.setColorFilter(AppCompatDrawableManager.c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.f41357d.refreshDrawableState();
        }
    }

    public final void s() {
        EditText editText = this.f41357d;
        if (editText == null || this.F == null) {
            return;
        }
        if ((this.I || editText.getBackground() == null) && this.A0 != 0) {
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            EditText editText2 = this.f41357d;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            editText2.setBackground(editTextBoxBackground);
            this.I = true;
        }
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.G0 != i2) {
            this.G0 = i2;
            this.X0 = i2;
            this.Z0 = i2;
            this.a1 = i2;
            b();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(getContext().getColor(i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.X0 = defaultColor;
        this.G0 = defaultColor;
        this.Y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.Z0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.a1 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i2) throws Resources.NotFoundException {
        if (i2 == this.A0) {
            return;
        }
        this.A0 = i2;
        if (this.f41357d != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i2) {
        this.B0 = i2;
    }

    public void setBoxCornerFamily(int i2) {
        ShapeAppearanceModel.Builder builderG = this.L.g();
        CornerSize cornerSize = this.L.f41011e;
        builderG.g(MaterialShapeUtils.a(i2));
        builderG.f41023e = cornerSize;
        CornerSize cornerSize2 = this.L.f41012f;
        builderG.j(MaterialShapeUtils.a(i2));
        builderG.f41024f = cornerSize2;
        CornerSize cornerSize3 = this.L.f41014h;
        CornerTreatment cornerTreatmentA = MaterialShapeUtils.a(i2);
        builderG.f41022d = cornerTreatmentA;
        float fB = ShapeAppearanceModel.Builder.b(cornerTreatmentA);
        if (fB != -1.0f) {
            builderG.d(fB);
        }
        builderG.f41026h = cornerSize3;
        CornerSize cornerSize4 = this.L.f41013g;
        CornerTreatment cornerTreatmentA2 = MaterialShapeUtils.a(i2);
        builderG.f41021c = cornerTreatmentA2;
        float fB2 = ShapeAppearanceModel.Builder.b(cornerTreatmentA2);
        if (fB2 != -1.0f) {
            builderG.e(fB2);
        }
        builderG.f41025g = cornerSize4;
        this.L = builderG.a();
        b();
    }

    public void setBoxStrokeColor(@ColorInt int i2) throws Resources.NotFoundException {
        if (this.V0 != i2) {
            this.V0 = i2;
            x();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) throws Resources.NotFoundException {
        if (colorStateList.isStateful()) {
            this.T0 = colorStateList.getDefaultColor();
            this.b1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.U0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.V0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.V0 != colorStateList.getDefaultColor()) {
            this.V0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.W0 != colorStateList) {
            this.W0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i2) throws Resources.NotFoundException {
        this.D0 = i2;
        x();
    }

    public void setBoxStrokeWidthFocused(int i2) throws Resources.NotFoundException {
        this.E0 = i2;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) throws Resources.NotFoundException {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) throws Resources.NotFoundException {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) throws Resources.NotFoundException {
        if (this.f41364k != z) {
            IndicatorViewController indicatorViewController = this.f41363j;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.o = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.K0;
                if (typeface != null) {
                    this.o.setTypeface(typeface);
                }
                this.o.setMaxLines(1);
                indicatorViewController.a(this.o, 2);
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.o != null) {
                    EditText editText = this.f41357d;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                indicatorViewController.g(this.o, 2);
                this.o = null;
            }
            this.f41364k = z;
        }
    }

    public void setCounterMaxLength(int i2) throws Resources.NotFoundException {
        if (this.f41365l != i2) {
            if (i2 > 0) {
                this.f41365l = i2;
            } else {
                this.f41365l = -1;
            }
            if (!this.f41364k || this.o == null) {
                return;
            }
            EditText editText = this.f41357d;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.p != i2) {
            this.p = i2;
            o();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.q != i2) {
            this.q = i2;
            o();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            o();
        }
    }

    @RequiresApi
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            p();
        }
    }

    @RequiresApi
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (m() || (this.o != null && this.f41366m)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.R0 = colorStateList;
        this.S0 = colorStateList;
        if (this.f41357d != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        k(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f41356c.f41290g.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f41356c.f41290g.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        CharSequence text = i2 != 0 ? endCompoundLayout.getResources().getText(i2) : null;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        Drawable drawableB = i2 != 0 ? AppCompatResources.b(i2, endCompoundLayout.getContext()) : null;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        checkableImageButton.setImageDrawable(drawableB);
        if (drawableB != null) {
            ColorStateList colorStateList = endCompoundLayout.f41294k;
            PorterDuff.Mode mode = endCompoundLayout.f41295l;
            TextInputLayout textInputLayout = endCompoundLayout.f41284a;
            IconHelper.a(textInputLayout, checkableImageButton, colorStateList, mode);
            IconHelper.c(textInputLayout, checkableImageButton, endCompoundLayout.f41294k);
        }
    }

    public void setEndIconMinSize(@IntRange int i2) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (i2 < 0) {
            endCompoundLayout.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i2 != endCompoundLayout.f41296m) {
            endCompoundLayout.f41296m = i2;
            CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
            checkableImageButton.setMinimumWidth(i2);
            checkableImageButton.setMinimumHeight(i2);
            CheckableImageButton checkableImageButton2 = endCompoundLayout.f41286c;
            checkableImageButton2.setMinimumWidth(i2);
            checkableImageButton2.setMinimumHeight(i2);
        }
    }

    public void setEndIconMode(int i2) throws Resources.NotFoundException {
        this.f41356c.g(i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        View.OnLongClickListener onLongClickListener = endCompoundLayout.o;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        checkableImageButton.setOnClickListener(onClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.o = onLongClickListener;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.n = scaleType;
        endCompoundLayout.f41290g.setScaleType(scaleType);
        endCompoundLayout.f41286c.setScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (endCompoundLayout.f41294k != colorStateList) {
            endCompoundLayout.f41294k = colorStateList;
            IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41290g, colorStateList, endCompoundLayout.f41295l);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (endCompoundLayout.f41295l != mode) {
            endCompoundLayout.f41295l = mode;
            IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41290g, endCompoundLayout.f41294k, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.f41356c.h(z);
    }

    public void setError(@Nullable CharSequence charSequence) throws Resources.NotFoundException {
        IndicatorViewController indicatorViewController = this.f41363j;
        if (!indicatorViewController.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            indicatorViewController.f();
            return;
        }
        indicatorViewController.c();
        indicatorViewController.p = charSequence;
        indicatorViewController.r.setText(charSequence);
        int i2 = indicatorViewController.n;
        if (i2 != 1) {
            indicatorViewController.o = 1;
        }
        indicatorViewController.i(i2, indicatorViewController.o, indicatorViewController.h(indicatorViewController.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i2) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.t = i2;
        AppCompatTextView appCompatTextView = indicatorViewController.r;
        if (appCompatTextView != null) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            appCompatTextView.setAccessibilityLiveRegion(i2);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.s = charSequence;
        AppCompatTextView appCompatTextView = indicatorViewController.r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) throws Resources.NotFoundException {
        IndicatorViewController indicatorViewController = this.f41363j;
        if (indicatorViewController.q == z) {
            return;
        }
        indicatorViewController.c();
        TextInputLayout textInputLayout = indicatorViewController.f41315h;
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.f41314g, null);
            indicatorViewController.r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            indicatorViewController.r.setTextAlignment(5);
            Typeface typeface = indicatorViewController.B;
            if (typeface != null) {
                indicatorViewController.r.setTypeface(typeface);
            }
            int i2 = indicatorViewController.u;
            indicatorViewController.u = i2;
            AppCompatTextView appCompatTextView2 = indicatorViewController.r;
            if (appCompatTextView2 != null) {
                textInputLayout.l(appCompatTextView2, i2);
            }
            ColorStateList colorStateList = indicatorViewController.v;
            indicatorViewController.v = colorStateList;
            AppCompatTextView appCompatTextView3 = indicatorViewController.r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = indicatorViewController.s;
            indicatorViewController.s = charSequence;
            AppCompatTextView appCompatTextView4 = indicatorViewController.r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i3 = indicatorViewController.t;
            indicatorViewController.t = i3;
            AppCompatTextView appCompatTextView5 = indicatorViewController.r;
            if (appCompatTextView5 != null) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                appCompatTextView5.setAccessibilityLiveRegion(i3);
            }
            indicatorViewController.r.setVisibility(4);
            indicatorViewController.a(indicatorViewController.r, 0);
        } else {
            indicatorViewController.f();
            indicatorViewController.g(indicatorViewController.r, 0);
            indicatorViewController.r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        indicatorViewController.q = z;
    }

    public void setErrorIconDrawable(@DrawableRes int i2) throws Resources.NotFoundException {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.i(i2 != 0 ? AppCompatResources.b(i2, endCompoundLayout.getContext()) : null);
        IconHelper.c(endCompoundLayout.f41284a, endCompoundLayout.f41286c, endCompoundLayout.f41287d);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41286c;
        View.OnLongClickListener onLongClickListener = endCompoundLayout.f41289f;
        checkableImageButton.setOnClickListener(onClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.f41289f = onLongClickListener;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41286c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (endCompoundLayout.f41287d != colorStateList) {
            endCompoundLayout.f41287d = colorStateList;
            IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41286c, colorStateList, endCompoundLayout.f41288e);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (endCompoundLayout.f41288e != mode) {
            endCompoundLayout.f41288e = mode;
            IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41286c, endCompoundLayout.f41287d, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.u = i2;
        AppCompatTextView appCompatTextView = indicatorViewController.r;
        if (appCompatTextView != null) {
            indicatorViewController.f41315h.l(appCompatTextView, i2);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.v = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.f1 != z) {
            this.f1 = z;
            u(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) throws Resources.NotFoundException {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        IndicatorViewController indicatorViewController = this.f41363j;
        if (zIsEmpty) {
            if (indicatorViewController.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!indicatorViewController.x) {
            setHelperTextEnabled(true);
        }
        indicatorViewController.c();
        indicatorViewController.w = charSequence;
        indicatorViewController.y.setText(charSequence);
        int i2 = indicatorViewController.n;
        if (i2 != 2) {
            indicatorViewController.o = 2;
        }
        indicatorViewController.i(i2, indicatorViewController.o, indicatorViewController.h(indicatorViewController.y, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.A = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) throws Resources.NotFoundException {
        final IndicatorViewController indicatorViewController = this.f41363j;
        if (indicatorViewController.x == z) {
            return;
        }
        indicatorViewController.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.f41314g, null);
            indicatorViewController.y = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            indicatorViewController.y.setTextAlignment(5);
            Typeface typeface = indicatorViewController.B;
            if (typeface != null) {
                indicatorViewController.y.setTypeface(typeface);
            }
            indicatorViewController.y.setVisibility(4);
            AppCompatTextView appCompatTextView2 = indicatorViewController.y;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i2 = indicatorViewController.z;
            indicatorViewController.z = i2;
            AppCompatTextView appCompatTextView3 = indicatorViewController.y;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i2);
            }
            ColorStateList colorStateList = indicatorViewController.A;
            indicatorViewController.A = colorStateList;
            AppCompatTextView appCompatTextView4 = indicatorViewController.y;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            indicatorViewController.a(indicatorViewController.y, 1);
            indicatorViewController.y.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                @Override // android.view.View.AccessibilityDelegate
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    EditText editText = IndicatorViewController.this.f41315h.getEditText();
                    if (editText != null) {
                        accessibilityNodeInfo.setLabeledBy(editText);
                    }
                }
            });
        } else {
            indicatorViewController.c();
            int i3 = indicatorViewController.n;
            if (i3 == 2) {
                indicatorViewController.o = 0;
            }
            indicatorViewController.i(i3, indicatorViewController.o, indicatorViewController.h(indicatorViewController.y, ""));
            indicatorViewController.g(indicatorViewController.y, 1);
            indicatorViewController.y = null;
            TextInputLayout textInputLayout = indicatorViewController.f41315h;
            textInputLayout.r();
            textInputLayout.x();
        }
        indicatorViewController.x = z;
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        IndicatorViewController indicatorViewController = this.f41363j;
        indicatorViewController.z = i2;
        AppCompatTextView appCompatTextView = indicatorViewController.y;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i2);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.g1 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.C) {
            this.C = z;
            if (z) {
                CharSequence hint = this.f41357d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f41357d.setHint((CharSequence) null);
                }
                this.E = true;
            } else {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f41357d.getHint())) {
                    this.f41357d.setHint(this.D);
                }
                setHintInternal(null);
            }
            if (this.f41357d != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        CollapsingTextHelper collapsingTextHelper = this.e1;
        collapsingTextHelper.k(i2);
        this.S0 = collapsingTextHelper.o;
        if (this.f41357d != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.S0 != colorStateList) {
            if (this.R0 == null) {
                CollapsingTextHelper collapsingTextHelper = this.e1;
                if (collapsingTextHelper.o != colorStateList) {
                    collapsingTextHelper.o = colorStateList;
                    collapsingTextHelper.i(false);
                }
            }
            this.S0 = colorStateList;
            if (this.f41357d != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(@NonNull LengthCounter lengthCounter) {
        this.n = lengthCounter;
    }

    public void setMaxEms(int i2) {
        this.f41360g = i2;
        EditText editText = this.f41357d;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxEms(i2);
    }

    public void setMaxWidth(@Px int i2) {
        this.f41362i = i2;
        EditText editText = this.f41357d;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxWidth(i2);
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinEms(int i2) {
        this.f41359f = i2;
        EditText editText = this.f41357d;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinEms(i2);
    }

    public void setMinWidth(@Px int i2) {
        this.f41361h = i2;
        EditText editText = this.f41357d;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinWidth(i2);
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.f41290g.setContentDescription(i2 != 0 ? endCompoundLayout.getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.f41290g.setImageDrawable(i2 != 0 ? AppCompatResources.b(i2, endCompoundLayout.getContext()) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) throws Resources.NotFoundException {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        if (z && endCompoundLayout.f41292i != 1) {
            endCompoundLayout.g(1);
        } else if (z) {
            endCompoundLayout.getClass();
        } else {
            endCompoundLayout.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.f41294k = colorStateList;
        IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41290g, colorStateList, endCompoundLayout.f41295l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.f41295l = mode;
        IconHelper.a(endCompoundLayout.f41284a, endCompoundLayout.f41290g, endCompoundLayout.f41294k, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.t = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.t;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            appCompatTextView2.setImportantForAccessibility(2);
            Fade fadeD = d();
            this.w = fadeD;
            fadeD.f12116b = 67L;
            this.x = d();
            setPlaceholderTextAppearance(this.v);
            setPlaceholderTextColor(this.u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.s) {
                setPlaceholderTextEnabled(true);
            }
            this.r = charSequence;
        }
        EditText editText = this.f41357d;
        v(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.v = i2;
        AppCompatTextView appCompatTextView = this.t;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            AppCompatTextView appCompatTextView = this.t;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        startCompoundLayout.getClass();
        startCompoundLayout.f41344c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        startCompoundLayout.f41343b.setText(charSequence);
        startCompoundLayout.e();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        this.f41355b.f41343b.setTextAppearance(i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f41355b.f41343b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.F;
        if (materialShapeDrawable == null || materialShapeDrawable.f40974a.f40989a == shapeAppearanceModel) {
            return;
        }
        this.L = shapeAppearanceModel;
        b();
    }

    public void setStartIconCheckable(boolean z) {
        this.f41355b.f41345d.setCheckable(z);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f41355b.f41345d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.b(i2, getContext()) : null);
    }

    public void setStartIconMinSize(@IntRange int i2) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        if (i2 < 0) {
            startCompoundLayout.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i2 != startCompoundLayout.f41348g) {
            startCompoundLayout.f41348g = i2;
            CheckableImageButton checkableImageButton = startCompoundLayout.f41345d;
            checkableImageButton.setMinimumWidth(i2);
            checkableImageButton.setMinimumHeight(i2);
        }
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        View.OnLongClickListener onLongClickListener = startCompoundLayout.f41350i;
        CheckableImageButton checkableImageButton = startCompoundLayout.f41345d;
        checkableImageButton.setOnClickListener(onClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        startCompoundLayout.f41350i = onLongClickListener;
        CheckableImageButton checkableImageButton = startCompoundLayout.f41345d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        IconHelper.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        startCompoundLayout.f41349h = scaleType;
        startCompoundLayout.f41345d.setScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        if (startCompoundLayout.f41346e != colorStateList) {
            startCompoundLayout.f41346e = colorStateList;
            IconHelper.a(startCompoundLayout.f41342a, startCompoundLayout.f41345d, colorStateList, startCompoundLayout.f41347f);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        StartCompoundLayout startCompoundLayout = this.f41355b;
        if (startCompoundLayout.f41347f != mode) {
            startCompoundLayout.f41347f = mode;
            IconHelper.a(startCompoundLayout.f41342a, startCompoundLayout.f41345d, startCompoundLayout.f41346e, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.f41355b.c(z);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.getClass();
        endCompoundLayout.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        endCompoundLayout.q.setText(charSequence);
        endCompoundLayout.n();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        this.f41356c.q.setTextAppearance(i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f41356c.q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f41357d;
        if (editText != null) {
            ViewCompat.z(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.K0) {
            this.K0 = typeface;
            CollapsingTextHelper collapsingTextHelper = this.e1;
            boolean zM = collapsingTextHelper.m(typeface);
            boolean zO = collapsingTextHelper.o(typeface);
            if (zM || zO) {
                collapsingTextHelper.i(false);
            }
            IndicatorViewController indicatorViewController = this.f41363j;
            if (typeface != indicatorViewController.B) {
                indicatorViewController.B = typeface;
                AppCompatTextView appCompatTextView = indicatorViewController.r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = indicatorViewController.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.A0 != 1) {
            FrameLayout frameLayout = this.f41354a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f41357d;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f41357d;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.R0;
        CollapsingTextHelper collapsingTextHelper = this.e1;
        if (colorStateList2 != null) {
            collapsingTextHelper.j(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.R0;
            collapsingTextHelper.j(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.b1) : this.b1));
        } else if (m()) {
            AppCompatTextView appCompatTextView2 = this.f41363j.r;
            collapsingTextHelper.j(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f41366m && (appCompatTextView = this.o) != null) {
            collapsingTextHelper.j(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.S0) != null && collapsingTextHelper.o != colorStateList) {
            collapsingTextHelper.o = colorStateList;
            collapsingTextHelper.i(false);
        }
        EndCompoundLayout endCompoundLayout = this.f41356c;
        StartCompoundLayout startCompoundLayout = this.f41355b;
        if (z3 || !this.f1 || (isEnabled() && z4)) {
            if (z2 || this.d1) {
                ValueAnimator valueAnimator = this.h1;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.h1.cancel();
                }
                if (z && this.g1) {
                    a(1.0f);
                } else {
                    collapsingTextHelper.p(1.0f);
                }
                this.d1 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.f41357d;
                v(editText3 != null ? editText3.getText() : null);
                startCompoundLayout.f41351j = false;
                startCompoundLayout.e();
                endCompoundLayout.r = false;
                endCompoundLayout.n();
                return;
            }
            return;
        }
        if (z2 || !this.d1) {
            ValueAnimator valueAnimator2 = this.h1;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.h1.cancel();
            }
            if (z && this.g1) {
                a(0.0f);
            } else {
                collapsingTextHelper.p(0.0f);
            }
            if (e() && !((CutoutDrawable) this.F).y.s.isEmpty() && e()) {
                ((CutoutDrawable) this.F).y(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.d1 = true;
            AppCompatTextView appCompatTextView3 = this.t;
            if (appCompatTextView3 != null && this.s) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.a(this.f41354a, this.x);
                this.t.setVisibility(4);
            }
            startCompoundLayout.f41351j = true;
            startCompoundLayout.e();
            endCompoundLayout.r = true;
            endCompoundLayout.n();
        }
    }

    public final void v(Editable editable) {
        int iC = this.n.c(editable);
        FrameLayout frameLayout = this.f41354a;
        if (iC != 0 || this.d1) {
            AppCompatTextView appCompatTextView = this.t;
            if (appCompatTextView == null || !this.s) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.a(frameLayout, this.x);
            this.t.setVisibility(4);
            return;
        }
        if (this.t == null || !this.s || TextUtils.isEmpty(this.r)) {
            return;
        }
        this.t.setText(this.r);
        TransitionManager.a(frameLayout, this.w);
        this.t.setVisibility(0);
        this.t.bringToFront();
        announceForAccessibility(this.r);
    }

    public final void w(boolean z, boolean z2) {
        int defaultColor = this.W0.getDefaultColor();
        int colorForState = this.W0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.W0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z) {
            this.F0 = colorForState2;
        } else if (z2) {
            this.F0 = colorForState;
        } else {
            this.F0 = defaultColor;
        }
    }

    public final void x() throws Resources.NotFoundException {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.F == null || this.A0 == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f41357d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f41357d) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.F0 = this.b1;
        } else if (m()) {
            if (this.W0 != null) {
                w(z2, z);
            } else {
                this.F0 = getErrorCurrentTextColors();
            }
        } else if (!this.f41366m || (appCompatTextView = this.o) == null) {
            if (z2) {
                this.F0 = this.V0;
            } else if (z) {
                this.F0 = this.U0;
            } else {
                this.F0 = this.T0;
            }
        } else if (this.W0 != null) {
            w(z2, z);
        } else {
            this.F0 = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        EndCompoundLayout endCompoundLayout = this.f41356c;
        endCompoundLayout.l();
        CheckableImageButton checkableImageButton = endCompoundLayout.f41286c;
        ColorStateList colorStateList = endCompoundLayout.f41287d;
        TextInputLayout textInputLayout = endCompoundLayout.f41284a;
        IconHelper.c(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = endCompoundLayout.f41294k;
        CheckableImageButton checkableImageButton2 = endCompoundLayout.f41290g;
        IconHelper.c(textInputLayout, checkableImageButton2, colorStateList2);
        if (endCompoundLayout.b() instanceof DropdownMenuEndIconDelegate) {
            if (!textInputLayout.m() || checkableImageButton2.getDrawable() == null) {
                IconHelper.a(textInputLayout, checkableImageButton2, endCompoundLayout.f41294k, endCompoundLayout.f41295l);
            } else {
                Drawable drawableMutate = checkableImageButton2.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(drawableMutate);
            }
        }
        StartCompoundLayout startCompoundLayout = this.f41355b;
        IconHelper.c(startCompoundLayout.f41342a, startCompoundLayout.f41345d, startCompoundLayout.f41346e);
        if (this.A0 == 2) {
            int i2 = this.C0;
            if (z2 && isEnabled()) {
                this.C0 = this.E0;
            } else {
                this.C0 = this.D0;
            }
            if (this.C0 != i2 && e() && !this.d1) {
                if (e()) {
                    ((CutoutDrawable) this.F).y(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.A0 == 1) {
            if (!isEnabled()) {
                this.G0 = this.Y0;
            } else if (z && !z2) {
                this.G0 = this.a1;
            } else if (z2) {
                this.G0 = this.Z0;
            } else {
                this.G0 = this.X0;
            }
        }
        b();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = l1;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f41359f = -1;
        this.f41360g = -1;
        this.f41361h = -1;
        this.f41362i = -1;
        this.f41363j = new IndicatorViewController(this);
        this.n = new p(28);
        this.H0 = new Rect();
        this.I0 = new Rect();
        this.J0 = new RectF();
        this.N0 = new LinkedHashSet();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.e1 = collapsingTextHelper;
        this.k1 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f41354a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = AnimationUtils.f39816a;
        collapsingTextHelper.W = linearInterpolator;
        collapsingTextHelper.i(false);
        collapsingTextHelper.V = linearInterpolator;
        collapsingTextHelper.i(false);
        collapsingTextHelper.l(8388659);
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(context2, attributeSet, R.styleable.TextInputLayout, i2, i3, R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, tintTypedArrayE);
        this.f41355b = startCompoundLayout;
        int i4 = R.styleable.TextInputLayout_hintEnabled;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        this.C = typedArray.getBoolean(i4, true);
        setHint(typedArray.getText(R.styleable.TextInputLayout_android_hint));
        this.g1 = typedArray.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f1 = typedArray.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        if (typedArray.hasValue(R.styleable.TextInputLayout_android_minEms)) {
            setMinEms(typedArray.getInt(R.styleable.TextInputLayout_android_minEms, -1));
        } else if (typedArray.hasValue(R.styleable.TextInputLayout_android_minWidth)) {
            setMinWidth(typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_android_minWidth, -1));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_android_maxEms)) {
            setMaxEms(typedArray.getInt(R.styleable.TextInputLayout_android_maxEms, -1));
        } else if (typedArray.hasValue(R.styleable.TextInputLayout_android_maxWidth)) {
            setMaxWidth(typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_android_maxWidth, -1));
        }
        this.L = ShapeAppearanceModel.c(context2, attributeSet, i2, i3).a();
        this.Q = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.B0 = typedArray.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.D0 = typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.E0 = typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.C0 = this.D0;
        float dimension = typedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = typedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = typedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = typedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder builderG = this.L.g();
        if (dimension >= 0.0f) {
            builderG.h(dimension);
        }
        if (dimension2 >= 0.0f) {
            builderG.k(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builderG.e(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builderG.d(dimension4);
        }
        this.L = builderG.a();
        ColorStateList colorStateListB = MaterialResources.b(context2, tintTypedArrayE, R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.X0 = defaultColor;
            this.G0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.Y0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.Z0 = colorStateListB.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.a1 = colorStateListB.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.Z0 = this.X0;
                ColorStateList colorStateListB2 = ResourcesCompat.b(context2.getResources(), R.color.mtrl_filled_background_color, context2.getTheme());
                this.Y0 = colorStateListB2.getColorForState(new int[]{-16842910}, -1);
                this.a1 = colorStateListB2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.G0 = 0;
            this.X0 = 0;
            this.Y0 = 0;
            this.Z0 = 0;
            this.a1 = 0;
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListA = tintTypedArrayE.a(R.styleable.TextInputLayout_android_textColorHint);
            this.S0 = colorStateListA;
            this.R0 = colorStateListA;
        }
        ColorStateList colorStateListB3 = MaterialResources.b(context2, tintTypedArrayE, R.styleable.TextInputLayout_boxStrokeColor);
        this.V0 = typedArray.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.T0 = context2.getColor(R.color.mtrl_textinput_default_box_stroke_color);
        this.b1 = context2.getColor(R.color.mtrl_textinput_disabled_color);
        this.U0 = context2.getColor(R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB3 != null) {
            setBoxStrokeColorStateList(colorStateListB3);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(MaterialResources.b(context2, tintTypedArrayE, R.styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (typedArray.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.A = tintTypedArrayE.a(R.styleable.TextInputLayout_cursorColor);
        this.B = tintTypedArrayE.a(R.styleable.TextInputLayout_cursorErrorColor);
        int resourceId = typedArray.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence text = typedArray.getText(R.styleable.TextInputLayout_errorContentDescription);
        int i5 = typedArray.getInt(R.styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean z = typedArray.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        int resourceId2 = typedArray.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean z2 = typedArray.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = typedArray.getText(R.styleable.TextInputLayout_helperText);
        int resourceId3 = typedArray.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = typedArray.getText(R.styleable.TextInputLayout_placeholderText);
        boolean z3 = typedArray.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(typedArray.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.q = typedArray.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.p = typedArray.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(typedArray.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i5);
        setCounterOverflowTextAppearance(this.p);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.q);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(R.styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_errorTextColor));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_helperTextTextColor));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_hintTextColor));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_counterTextColor));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(tintTypedArrayE.a(R.styleable.TextInputLayout_placeholderTextColor));
        }
        EndCompoundLayout endCompoundLayout = new EndCompoundLayout(this, tintTypedArrayE);
        this.f41356c = endCompoundLayout;
        boolean z4 = typedArray.getBoolean(R.styleable.TextInputLayout_android_enabled, true);
        tintTypedArrayE.g();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.F(this, 1);
        }
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(endCompoundLayout);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f41355b.b(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f41356c.f41290g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f41356c.f41290g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f41356c.i(drawable);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f41356c.f41290g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        EndCompoundLayout endCompoundLayout = this.f41356c;
        CheckableImageButton checkableImageButton = endCompoundLayout.f41290g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = endCompoundLayout.f41294k;
            PorterDuff.Mode mode = endCompoundLayout.f41295l;
            TextInputLayout textInputLayout = endCompoundLayout.f41284a;
            IconHelper.a(textInputLayout, checkableImageButton, colorStateList, mode);
            IconHelper.c(textInputLayout, checkableImageButton, endCompoundLayout.f41294k);
        }
    }
}
