package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class StartCompoundLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f41342a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f41343b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f41344c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f41345d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f41346e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f41347f;

    /* renamed from: g, reason: collision with root package name */
    public int f41348g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f41349h;

    /* renamed from: i, reason: collision with root package name */
    public View.OnLongClickListener f41350i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41351j;

    public StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f41342a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f41345d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f41343b = appCompatTextView;
        if (MaterialResources.e(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f41350i;
        checkableImageButton.setOnClickListener(null);
        IconHelper.d(checkableImageButton, onLongClickListener);
        this.f41350i = null;
        checkableImageButton.setOnLongClickListener(null);
        IconHelper.d(checkableImageButton, null);
        int i2 = R.styleable.TextInputLayout_startIconTint;
        TypedArray typedArray = tintTypedArray.f1185b;
        if (typedArray.hasValue(i2)) {
            this.f41346e = MaterialResources.b(getContext(), tintTypedArray, R.styleable.TextInputLayout_startIconTint);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_startIconTintMode)) {
            this.f41347f = ViewUtils.i(typedArray.getInt(R.styleable.TextInputLayout_startIconTintMode, -1), null);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_startIconDrawable)) {
            b(tintTypedArray.b(R.styleable.TextInputLayout_startIconDrawable));
            if (typedArray.hasValue(R.styleable.TextInputLayout_startIconContentDescription) && checkableImageButton.getContentDescription() != (text = typedArray.getText(R.styleable.TextInputLayout_startIconContentDescription))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f41348g) {
            this.f41348g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_startIconScaleType)) {
            ImageView.ScaleType scaleTypeB = IconHelper.b(typedArray.getInt(R.styleable.TextInputLayout_startIconScaleType, -1));
            this.f41349h = scaleTypeB;
            checkableImageButton.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        if (typedArray.hasValue(R.styleable.TextInputLayout_prefixTextColor)) {
            appCompatTextView.setTextColor(tintTypedArray.a(R.styleable.TextInputLayout_prefixTextColor));
        }
        CharSequence text2 = typedArray.getText(R.styleable.TextInputLayout_prefixText);
        this.f41344c = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        e();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f41345d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return this.f41343b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f41345d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f41346e;
            PorterDuff.Mode mode = this.f41347f;
            TextInputLayout textInputLayout = this.f41342a;
            IconHelper.a(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            IconHelper.c(textInputLayout, checkableImageButton, this.f41346e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f41350i;
        checkableImageButton.setOnClickListener(null);
        IconHelper.d(checkableImageButton, onLongClickListener);
        this.f41350i = null;
        checkableImageButton.setOnLongClickListener(null);
        IconHelper.d(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.f41345d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() throws Resources.NotFoundException {
        int paddingStart;
        EditText editText = this.f41342a.f41357d;
        if (editText == null) {
            return;
        }
        if (this.f41345d.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
        this.f41343b.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i2 = (this.f41344c == null || this.f41351j) ? 8 : 0;
        setVisibility((this.f41345d.getVisibility() == 0 || i2 == 0) ? 0 : 8);
        this.f41343b.setVisibility(i2);
        this.f41342a.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        super.onMeasure(i2, i3);
        d();
    }
}
