package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckBox;
import androidx.activity.k;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import androidx.core.widget.TintableCompoundDrawablesView;

/* loaded from: classes3.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatCompoundButtonHelper f800a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatBackgroundHelper f801b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextHelper f802c;

    /* renamed from: d, reason: collision with root package name */
    public AppCompatEmojiTextHelper f803d;

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f804a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f805b;

        /* renamed from: c, reason: collision with root package name */
        public int f806c;

        /* renamed from: d, reason: collision with root package name */
        public int f807d;

        /* renamed from: e, reason: collision with root package name */
        public int f808e;

        /* renamed from: f, reason: collision with root package name */
        public int f809f;

        /* renamed from: g, reason: collision with root package name */
        public int f810g;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f805b = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f806c = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f807d = propertyMapper.mapObject("buttonTint", R.attr.buttonTint);
            this.f808e = propertyMapper.mapObject("buttonTintMode", R.attr.buttonTintMode);
            this.f809f = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f810g = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f804a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) obj;
            if (!this.f804a) {
                throw k.e();
            }
            propertyReader.readObject(this.f805b, appCompatCheckBox.getBackgroundTintList());
            propertyReader.readObject(this.f806c, appCompatCheckBox.getBackgroundTintMode());
            propertyReader.readObject(this.f807d, appCompatCheckBox.getButtonTintList());
            propertyReader.readObject(this.f808e, appCompatCheckBox.getButtonTintMode());
            propertyReader.readObject(this.f809f, appCompatCheckBox.getCompoundDrawableTintList());
            propertyReader.readObject(this.f810g, appCompatCheckBox.getCompoundDrawableTintMode());
        }
    }

    public AppCompatCheckBox(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f803d == null) {
            this.f803d = new AppCompatEmojiTextHelper(this);
        }
        return this.f803d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.f802c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo
    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f800a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.f829b;
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f800a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.f830c;
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f802c.d();
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f802c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f800a;
        if (appCompatCompoundButtonHelper != null) {
            if (appCompatCompoundButtonHelper.f833f) {
                appCompatCompoundButtonHelper.f833f = false;
            } else {
                appCompatCompoundButtonHelper.f833f = true;
                appCompatCompoundButtonHelper.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f802c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f802c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f858b.a(inputFilterArr));
    }

    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f801b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f800a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.f829b = colorStateList;
            appCompatCompoundButtonHelper.f831d = true;
            appCompatCompoundButtonHelper.a();
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f800a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.f830c = mode;
            appCompatCompoundButtonHelper.f832e = true;
            appCompatCompoundButtonHelper.a();
        }
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.f802c;
        appCompatTextHelper.k(colorStateList);
        appCompatTextHelper.b();
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.f802c;
        appCompatTextHelper.l(mode);
        appCompatTextHelper.b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TintContextWrapper.a(context);
        ThemeUtils.a(getContext(), this);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.f800a = appCompatCompoundButtonHelper;
        appCompatCompoundButtonHelper.b(attributeSet, i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f801b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f802c = appCompatTextHelper;
        appCompatTextHelper.f(attributeSet, i2);
        getEmojiTextViewHelper().a(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i2) {
        setButtonDrawable(AppCompatResources.b(i2, getContext()));
    }
}
