package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class EndCompoundLayout extends LinearLayout {
    public static final /* synthetic */ int x = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f41284a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f41285b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f41286c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f41287d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f41288e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f41289f;

    /* renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f41290g;

    /* renamed from: h, reason: collision with root package name */
    public final EndIconDelegates f41291h;

    /* renamed from: i, reason: collision with root package name */
    public int f41292i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f41293j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f41294k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f41295l;

    /* renamed from: m, reason: collision with root package name */
    public int f41296m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence p;
    public final AppCompatTextView q;
    public boolean r;
    public EditText s;
    public final AccessibilityManager t;
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener u;
    public final TextWatcher v;
    public final TextInputLayout.OnEditTextAttachedListener w;

    public static class EndIconDelegates {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f41300a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        public final EndCompoundLayout f41301b;

        /* renamed from: c, reason: collision with root package name */
        public final int f41302c;

        /* renamed from: d, reason: collision with root package name */
        public final int f41303d;

        public EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.f41301b = endCompoundLayout;
            int i2 = R.styleable.TextInputLayout_endIconDrawable;
            TypedArray typedArray = tintTypedArray.f1185b;
            this.f41302c = typedArray.getResourceId(i2, 0);
            this.f41303d = typedArray.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }
    }

    public EndCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) throws Resources.NotFoundException {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f41292i = 0;
        this.f41293j = new LinkedHashSet();
        this.v = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.EndCompoundLayout.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                EndCompoundLayout.this.b().a();
            }

            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                EndCompoundLayout.this.b().b();
            }
        };
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public final void a(TextInputLayout textInputLayout2) {
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                if (endCompoundLayout.s == textInputLayout2.getEditText()) {
                    return;
                }
                EditText editText = endCompoundLayout.s;
                TextWatcher textWatcher = endCompoundLayout.v;
                if (editText != null) {
                    editText.removeTextChangedListener(textWatcher);
                    if (endCompoundLayout.s.getOnFocusChangeListener() == endCompoundLayout.b().e()) {
                        endCompoundLayout.s.setOnFocusChangeListener(null);
                    }
                }
                EditText editText2 = textInputLayout2.getEditText();
                endCompoundLayout.s = editText2;
                if (editText2 != null) {
                    editText2.addTextChangedListener(textWatcher);
                }
                endCompoundLayout.b().m(endCompoundLayout.s);
                endCompoundLayout.j(endCompoundLayout.b());
            }
        };
        this.w = onEditTextAttachedListener;
        this.t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f41284a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f41285b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f41286c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f41290g = checkableImageButtonA2;
        this.f41291h = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.q = appCompatTextView;
        int i2 = R.styleable.TextInputLayout_errorIconTint;
        TypedArray typedArray = tintTypedArray.f1185b;
        if (typedArray.hasValue(i2)) {
            this.f41287d = MaterialResources.b(getContext(), tintTypedArray, R.styleable.TextInputLayout_errorIconTint);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_errorIconTintMode)) {
            this.f41288e = ViewUtils.i(typedArray.getInt(R.styleable.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_errorIconDrawable)) {
            i(tintTypedArray.b(R.styleable.TextInputLayout_errorIconDrawable));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray.hasValue(R.styleable.TextInputLayout_endIconTint)) {
                this.f41294k = MaterialResources.b(getContext(), tintTypedArray, R.styleable.TextInputLayout_endIconTint);
            }
            if (typedArray.hasValue(R.styleable.TextInputLayout_endIconTintMode)) {
                this.f41295l = ViewUtils.i(typedArray.getInt(R.styleable.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_endIconMode)) {
            g(typedArray.getInt(R.styleable.TextInputLayout_endIconMode, 0));
            if (typedArray.hasValue(R.styleable.TextInputLayout_endIconContentDescription) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(R.styleable.TextInputLayout_endIconContentDescription))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (typedArray.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
                this.f41294k = MaterialResources.b(getContext(), tintTypedArray, R.styleable.TextInputLayout_passwordToggleTint);
            }
            if (typedArray.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
                this.f41295l = ViewUtils.i(typedArray.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            g(typedArray.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f41296m) {
            this.f41296m = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(R.styleable.TextInputLayout_endIconScaleType)) {
            ImageView.ScaleType scaleTypeB = IconHelper.b(typedArray.getInt(R.styleable.TextInputLayout_endIconScaleType, -1));
            this.n = scaleTypeB;
            checkableImageButtonA2.setScaleType(scaleTypeB);
            checkableImageButtonA.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        if (typedArray.hasValue(R.styleable.TextInputLayout_suffixTextColor)) {
            appCompatTextView.setTextColor(tintTypedArray.a(R.styleable.TextInputLayout_suffixTextColor));
        }
        CharSequence text3 = typedArray.getText(R.styleable.TextInputLayout_suffixText);
        this.p = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.N0.add(onEditTextAttachedListener);
        if (textInputLayout.f41357d != null) {
            onEditTextAttachedListener.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.3
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View view) {
                AccessibilityManager accessibilityManager;
                int i3 = EndCompoundLayout.x;
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                if (endCompoundLayout.u == null || (accessibilityManager = endCompoundLayout.t) == null) {
                    return;
                }
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                if (endCompoundLayout.isAttachedToWindow()) {
                    AccessibilityManagerCompat.a(accessibilityManager, endCompoundLayout.u);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View view) {
                AccessibilityManager accessibilityManager;
                int i3 = EndCompoundLayout.x;
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = endCompoundLayout.u;
                if (touchExplorationStateChangeListener == null || (accessibilityManager = endCompoundLayout.t) == null) {
                    return;
                }
                AccessibilityManagerCompat.b(accessibilityManager, touchExplorationStateChangeListener);
            }
        });
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i2) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i2);
        if (MaterialResources.e(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final EndIconDelegate b() {
        EndIconDelegate customEndIconDelegate;
        int i2 = this.f41292i;
        EndIconDelegates endIconDelegates = this.f41291h;
        SparseArray sparseArray = endIconDelegates.f41300a;
        EndIconDelegate endIconDelegate = (EndIconDelegate) sparseArray.get(i2);
        if (endIconDelegate != null) {
            return endIconDelegate;
        }
        EndCompoundLayout endCompoundLayout = endIconDelegates.f41301b;
        if (i2 == -1) {
            customEndIconDelegate = new CustomEndIconDelegate(endCompoundLayout);
        } else if (i2 == 0) {
            customEndIconDelegate = new NoEndIconDelegate(endCompoundLayout);
        } else if (i2 == 1) {
            customEndIconDelegate = new PasswordToggleEndIconDelegate(endCompoundLayout, endIconDelegates.f41303d);
        } else if (i2 == 2) {
            customEndIconDelegate = new ClearTextEndIconDelegate(endCompoundLayout);
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Invalid end icon mode: "));
            }
            customEndIconDelegate = new DropdownMenuEndIconDelegate(endCompoundLayout);
        }
        sparseArray.append(i2, customEndIconDelegate);
        return customEndIconDelegate;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f41290g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return this.q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f41285b.getVisibility() == 0 && this.f41290g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f41286c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z3;
        EndIconDelegate endIconDelegateB = b();
        boolean zK = endIconDelegateB.k();
        CheckableImageButton checkableImageButton = this.f41290g;
        boolean z4 = true;
        if (!zK || (z3 = checkableImageButton.f40546d) == endIconDelegateB.l()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(endIconDelegateB instanceof DropdownMenuEndIconDelegate) || (zIsActivated = checkableImageButton.isActivated()) == endIconDelegateB.j()) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z4) {
            IconHelper.c(this.f41284a, checkableImageButton, this.f41294k);
        }
    }

    public final void g(int i2) throws Resources.NotFoundException {
        if (this.f41292i == i2) {
            return;
        }
        EndIconDelegate endIconDelegateB = b();
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.u;
        AccessibilityManager accessibilityManager = this.t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            AccessibilityManagerCompat.b(accessibilityManager, touchExplorationStateChangeListener);
        }
        this.u = null;
        endIconDelegateB.s();
        this.f41292i = i2;
        Iterator it = this.f41293j.iterator();
        while (it.hasNext()) {
            ((TextInputLayout.OnEndIconChangedListener) it.next()).a();
        }
        h(i2 != 0);
        EndIconDelegate endIconDelegateB2 = b();
        int iD = this.f41291h.f41302c;
        if (iD == 0) {
            iD = endIconDelegateB2.d();
        }
        Drawable drawableB = iD != 0 ? AppCompatResources.b(iD, getContext()) : null;
        CheckableImageButton checkableImageButton = this.f41290g;
        checkableImageButton.setImageDrawable(drawableB);
        TextInputLayout textInputLayout = this.f41284a;
        if (drawableB != null) {
            IconHelper.a(textInputLayout, checkableImageButton, this.f41294k, this.f41295l);
            IconHelper.c(textInputLayout, checkableImageButton, this.f41294k);
        }
        int iC = endIconDelegateB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(endIconDelegateB2.k());
        if (!endIconDelegateB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i2);
        }
        endIconDelegateB2.r();
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = endIconDelegateB2.h();
        this.u = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (isAttachedToWindow()) {
                AccessibilityManagerCompat.a(accessibilityManager, this.u);
            }
        }
        View.OnClickListener onClickListenerF = endIconDelegateB2.f();
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        IconHelper.d(checkableImageButton, onLongClickListener);
        EditText editText = this.s;
        if (editText != null) {
            endIconDelegateB2.m(editText);
            j(endIconDelegateB2);
        }
        IconHelper.a(textInputLayout, checkableImageButton, this.f41294k, this.f41295l);
        f(true);
    }

    public final void h(boolean z) throws Resources.NotFoundException {
        if (d() != z) {
            this.f41290g.setVisibility(z ? 0 : 8);
            k();
            m();
            this.f41284a.q();
        }
    }

    public final void i(Drawable drawable) throws Resources.NotFoundException {
        CheckableImageButton checkableImageButton = this.f41286c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        IconHelper.a(this.f41284a, checkableImageButton, this.f41287d, this.f41288e);
    }

    public final void j(EndIconDelegate endIconDelegate) {
        if (this.s == null) {
            return;
        }
        if (endIconDelegate.e() != null) {
            this.s.setOnFocusChangeListener(endIconDelegate.e());
        }
        if (endIconDelegate.g() != null) {
            this.f41290g.setOnFocusChangeListener(endIconDelegate.g());
        }
    }

    public final void k() {
        this.f41285b.setVisibility((this.f41290g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.p == null || this.r) ? 8 : false)) ? 0 : 8);
    }

    public final void l() throws Resources.NotFoundException {
        CheckableImageButton checkableImageButton = this.f41286c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f41284a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f41363j.q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.f41292i != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() throws Resources.NotFoundException {
        int paddingEnd;
        TextInputLayout textInputLayout = this.f41284a;
        if (textInputLayout.f41357d == null) {
            return;
        }
        if (d() || e()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.f41357d;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f41357d.getPaddingTop();
        int paddingBottom = textInputLayout.f41357d.getPaddingBottom();
        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
        this.q.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.q;
        int visibility = appCompatTextView.getVisibility();
        int i2 = (this.p == null || this.r) ? 8 : 0;
        if (visibility != i2) {
            b().p(i2 == 0);
        }
        k();
        appCompatTextView.setVisibility(i2);
        this.f41284a.q();
    }
}
