package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckedTextView;
import androidx.activity.k;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* loaded from: classes3.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatCheckedTextViewHelper f811a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatBackgroundHelper f812b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextHelper f813c;

    /* renamed from: d, reason: collision with root package name */
    public AppCompatEmojiTextHelper f814d;

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f815a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f816b;

        /* renamed from: c, reason: collision with root package name */
        public int f817c;

        /* renamed from: d, reason: collision with root package name */
        public int f818d;

        /* renamed from: e, reason: collision with root package name */
        public int f819e;

        /* renamed from: f, reason: collision with root package name */
        public int f820f;

        /* renamed from: g, reason: collision with root package name */
        public int f821g;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f816b = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f817c = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f818d = propertyMapper.mapObject("checkMarkTint", R.attr.checkMarkTint);
            this.f819e = propertyMapper.mapObject("checkMarkTintMode", R.attr.checkMarkTintMode);
            this.f820f = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f821g = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f815a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) obj;
            if (!this.f815a) {
                throw k.e();
            }
            propertyReader.readObject(this.f816b, appCompatCheckedTextView.getBackgroundTintList());
            propertyReader.readObject(this.f817c, appCompatCheckedTextView.getBackgroundTintMode());
            propertyReader.readObject(this.f818d, appCompatCheckedTextView.getCheckMarkTintList());
            propertyReader.readObject(this.f819e, appCompatCheckedTextView.getCheckMarkTintMode());
            propertyReader.readObject(this.f820f, appCompatCheckedTextView.getCompoundDrawableTintList());
            propertyReader.readObject(this.f821g, appCompatCheckedTextView.getCompoundDrawableTintMode());
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f814d == null) {
            this.f814d = new AppCompatEmojiTextHelper(this);
        }
        return this.f814d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.f813c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.a();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.j(super.getCustomSelectionActionModeCallback());
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.f823b;
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.f824c;
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f813c.d();
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f813c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AppCompatHintHelper.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            if (appCompatCheckedTextViewHelper.f827f) {
                appCompatCheckedTextViewHelper.f827f = false;
            } else {
                appCompatCheckedTextViewHelper.f827f = true;
                appCompatCheckedTextViewHelper.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f813c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f813c;
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

    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f812b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    @RestrictTo
    public void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.f823b = colorStateList;
            appCompatCheckedTextViewHelper.f825d = true;
            appCompatCheckedTextViewHelper.a();
        }
    }

    @RestrictTo
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f811a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.f824c = mode;
            appCompatCheckedTextViewHelper.f826e = true;
            appCompatCheckedTextViewHelper.a();
        }
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.f813c;
        appCompatTextHelper.k(colorStateList);
        appCompatTextHelper.b();
    }

    @RestrictTo
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.f813c;
        appCompatTextHelper.l(mode);
        appCompatTextHelper.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.f813c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.g(i2, context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, i2);
        TintContextWrapper.a(context);
        ThemeUtils.a(getContext(), this);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f813c = appCompatTextHelper;
        appCompatTextHelper.f(attributeSet, i2);
        appCompatTextHelper.b();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f812b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i2);
        this.f811a = new AppCompatCheckedTextViewHelper(this);
        TintTypedArray tintTypedArrayF = TintTypedArray.f(getContext(), attributeSet, R.styleable.CheckedTextView, i2);
        TypedArray typedArray = tintTypedArrayF.f1185b;
        ViewCompat.y(this, getContext(), R.styleable.CheckedTextView, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        try {
            if (typedArray.hasValue(R.styleable.CheckedTextView_checkMarkCompat) && (resourceId2 = typedArray.getResourceId(R.styleable.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AppCompatResources.b(resourceId2, getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(R.styleable.CheckedTextView_android_checkMark) && (resourceId = typedArray.getResourceId(R.styleable.CheckedTextView_android_checkMark, 0)) != 0) {
                setCheckMarkDrawable(AppCompatResources.b(resourceId, getContext()));
            }
            if (typedArray.hasValue(R.styleable.CheckedTextView_checkMarkTint)) {
                setCheckMarkTintList(tintTypedArrayF.a(R.styleable.CheckedTextView_checkMarkTint));
            }
            if (typedArray.hasValue(R.styleable.CheckedTextView_checkMarkTintMode)) {
                setCheckMarkTintMode(DrawableUtils.c(typedArray.getInt(R.styleable.CheckedTextView_checkMarkTintMode, -1), null));
            }
            tintTypedArrayF.g();
            getEmojiTextViewHelper().a(attributeSet, i2);
        } catch (Throwable th) {
            tintTypedArrayF.g();
            throw th;
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int i2) {
        setCheckMarkDrawable(AppCompatResources.b(i2, getContext()));
    }
}
