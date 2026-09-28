package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.activity.k;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.IntFunction;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatBackgroundHelper f957a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextHelper f958b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextClassifierHelper f959c;

    /* renamed from: d, reason: collision with root package name */
    public AppCompatEmojiTextHelper f960d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f961e;

    /* renamed from: f, reason: collision with root package name */
    public SuperCallerApi26 f962f;

    /* renamed from: g, reason: collision with root package name */
    public Future f963g;

    @RequiresApi
    @RestrictTo
    /* loaded from: classes3.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f964a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f965b;

        /* renamed from: c, reason: collision with root package name */
        public int f966c;

        /* renamed from: d, reason: collision with root package name */
        public int f967d;

        /* renamed from: e, reason: collision with root package name */
        public int f968e;

        /* renamed from: f, reason: collision with root package name */
        public int f969f;

        /* renamed from: g, reason: collision with root package name */
        public int f970g;

        /* renamed from: h, reason: collision with root package name */
        public int f971h;

        /* renamed from: i, reason: collision with root package name */
        public int f972i;

        /* renamed from: androidx.appcompat.widget.AppCompatTextView$InspectionCompanion$1, reason: invalid class name */
        class AnonymousClass1 implements IntFunction<String> {
            @Override // java.util.function.IntFunction
            public final String apply(int i2) {
                return i2 != 0 ? i2 != 1 ? String.valueOf(i2) : "uniform" : "none";
            }
        }

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f965b = propertyMapper.mapInt("autoSizeMaxTextSize", R.attr.autoSizeMaxTextSize);
            this.f966c = propertyMapper.mapInt("autoSizeMinTextSize", R.attr.autoSizeMinTextSize);
            this.f967d = propertyMapper.mapInt("autoSizeStepGranularity", R.attr.autoSizeStepGranularity);
            this.f968e = propertyMapper.mapIntEnum("autoSizeTextType", R.attr.autoSizeTextType, new AnonymousClass1());
            this.f969f = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f970g = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f971h = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f972i = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f964a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) obj;
            if (!this.f964a) {
                throw k.e();
            }
            propertyReader.readInt(this.f965b, appCompatTextView.getAutoSizeMaxTextSize());
            propertyReader.readInt(this.f966c, appCompatTextView.getAutoSizeMinTextSize());
            propertyReader.readInt(this.f967d, appCompatTextView.getAutoSizeStepGranularity());
            propertyReader.readIntEnum(this.f968e, appCompatTextView.getAutoSizeTextType());
            propertyReader.readObject(this.f969f, appCompatTextView.getBackgroundTintList());
            propertyReader.readObject(this.f970g, appCompatTextView.getBackgroundTintMode());
            propertyReader.readObject(this.f971h, appCompatTextView.getCompoundDrawableTintList());
            propertyReader.readObject(this.f972i, appCompatTextView.getCompoundDrawableTintMode());
        }
    }

    /* loaded from: classes3.dex */
    public interface SuperCaller {
        void a(int[] iArr, int i2);

        void b(int i2);

        int c();

        int d();

        void e(int i2, float f2);

        int[] f();

        TextClassifier g();

        int h();

        void i(TextClassifier textClassifier);

        void j(int i2, int i3, int i4, int i5);

        void k(int i2);

        int l();

        void m(int i2);
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public class SuperCallerApi26 implements SuperCaller {
        public SuperCallerApi26() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void a(int[] iArr, int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void b(int i2) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final int c() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final int d() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void e(int i2, float f2) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final int[] f() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final TextClassifier g() {
            return AppCompatTextView.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final int h() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void i(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void j(int i2, int i3, int i4, int i5) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void k(int i2) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final int l() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void m(int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public class SuperCallerApi28 extends SuperCallerApi26 {
        public SuperCallerApi28() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void b(int i2) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i2);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void k(int i2) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i2);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public class SuperCallerApi34 extends SuperCallerApi28 {
        public SuperCallerApi34() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public final void e(int i2, float f2) {
            AppCompatTextView.super.setLineHeight(i2, f2);
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f960d == null) {
            this.f960d = new AppCompatEmojiTextHelper(this);
        }
        return this.f960d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    @RestrictTo
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f1268c) {
            return getSuperCaller().h();
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.f945i.f982e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f1268c) {
            return getSuperCaller().d();
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.f945i.f981d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f1268c) {
            return getSuperCaller().l();
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            return Math.round(appCompatTextHelper.f945i.f980c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f1268c) {
            return getSuperCaller().f();
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        return appCompatTextHelper != null ? appCompatTextHelper.f945i.f983f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo
    public int getAutoSizeTextType() {
        if (ViewUtils.f1268c) {
            return getSuperCaller().c() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f945i.f978a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.j(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    @RequiresApi
    @UiThread
    public SuperCaller getSuperCaller() {
        if (this.f962f == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                this.f962f = new SuperCallerApi34();
            } else if (i2 >= 28) {
                this.f962f = new SuperCallerApi28();
            } else if (i2 >= 26) {
                this.f962f = new SuperCallerApi26();
            }
        }
        return this.f962f;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f958b.d();
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f958b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi
    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.f959c) == null) {
            return getSuperCaller().g();
        }
        TextClassifier textClassifier = appCompatTextClassifierHelper.f936b;
        return textClassifier == null ? AppCompatTextClassifierHelper.Api26Impl.a(appCompatTextClassifierHelper.f935a) : textClassifier;
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.a(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f958b.getClass();
        if (Build.VERSION.SDK_INT < 30 && inputConnectionOnCreateInputConnection != null) {
            EditorInfoCompat.b(editorInfo, getText());
        }
        AppCompatHintHelper.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 || i2 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper == null || ViewUtils.f1268c) {
            return;
        }
        appCompatTextHelper.f945i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        q();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper == null || ViewUtils.f1268c) {
            return;
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = appCompatTextHelper.f945i;
        if (appCompatTextViewAutoSizeHelper.f()) {
            appCompatTextViewAutoSizeHelper.a();
        }
    }

    public final void q() {
        Future future = this.f963g;
        if (future != null) {
            try {
                this.f963g = null;
                TextViewCompat.h(this, (PrecomputedTextCompat) future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (ViewUtils.f1268c) {
            getSuperCaller().j(i2, i3, i4, i5);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.h(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (ViewUtils.f1268c) {
            getSuperCaller().a(iArr, i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.i(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    @RestrictTo
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (ViewUtils.f1268c) {
            getSuperCaller().m(i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.j(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.k(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f858b.a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange @Px int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().k(i2);
        } else {
            TextViewCompat.d(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange @Px int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i2);
        } else {
            TextViewCompat.e(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange @Px int i2) {
        TextViewCompat.f(this, i2);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.h(this, precomputedTextCompat);
    }

    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f957a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        appCompatTextHelper.k(colorStateList);
        appCompatTextHelper.b();
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        appCompatTextHelper.l(mode);
        appCompatTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.g(i2, context);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.f959c) == null) {
            getSuperCaller().i(textClassifier);
        } else {
            appCompatTextClassifierHelper.f936b = textClassifier;
        }
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> future) {
        this.f963g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params params) {
        TextViewCompat.i(this, params);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f2) {
        boolean z = ViewUtils.f1268c;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper == null || z) {
            return;
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = appCompatTextHelper.f945i;
        if (appCompatTextViewAutoSizeHelper.f()) {
            return;
        }
        appCompatTextViewAutoSizeHelper.g(f2, i2);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i2) {
        if (this.f961e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i2 <= 0) ? null : TypefaceCompat.a(getContext(), typeface, i2);
        this.f961e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.f961e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TintContextWrapper.a(context);
        this.f961e = false;
        this.f962f = null;
        ThemeUtils.a(getContext(), this);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f957a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f958b = appCompatTextHelper;
        appCompatTextHelper.f(attributeSet, i2);
        appCompatTextHelper.b();
        AppCompatTextClassifierHelper appCompatTextClassifierHelper = new AppCompatTextClassifierHelper();
        appCompatTextClassifierHelper.f935a = this;
        this.f959c = appCompatTextClassifierHelper;
        getEmojiTextViewHelper().a(attributeSet, i2);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().e(i2, f2);
        } else {
            TextViewCompat.g(this, i2, f2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? AppCompatResources.b(i2, context) : null, i3 != 0 ? AppCompatResources.b(i3, context) : null, i4 != 0 ? AppCompatResources.b(i4, context) : null, i5 != 0 ? AppCompatResources.b(i5, context) : null);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? AppCompatResources.b(i2, context) : null, i3 != 0 ? AppCompatResources.b(i3, context) : null, i4 != 0 ? AppCompatResources.b(i4, context) : null, i5 != 0 ? AppCompatResources.b(i5, context) : null);
        AppCompatTextHelper appCompatTextHelper = this.f958b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }
}
