package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageView;
import androidx.activity.k;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatBackgroundHelper f870a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageHelper f871b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f872c;

    @RequiresApi
    @RestrictTo
    /* loaded from: classes3.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f873a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f874b;

        /* renamed from: c, reason: collision with root package name */
        public int f875c;

        /* renamed from: d, reason: collision with root package name */
        public int f876d;

        /* renamed from: e, reason: collision with root package name */
        public int f877e;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f874b = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f875c = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f876d = propertyMapper.mapObject("tint", R.attr.tint);
            this.f877e = propertyMapper.mapObject("tintMode", R.attr.tintMode);
            this.f873a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) obj;
            if (!this.f873a) {
                throw k.e();
            }
            propertyReader.readObject(this.f874b, appCompatImageView.getBackgroundTintList());
            propertyReader.readObject(this.f875c, appCompatImageView.getBackgroundTintMode());
            propertyReader.readObject(this.f876d, appCompatImageView.getImageTintList());
            propertyReader.readObject(this.f877e, appCompatImageView.getImageTintMode());
        }
    }

    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.a();
        }
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo;
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper == null || (tintInfo = appCompatImageHelper.f868b) == null) {
            return null;
        }
        return tintInfo.f1180a;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo;
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper == null || (tintInfo = appCompatImageHelper.f868b) == null) {
            return null;
        }
        return tintInfo.f1181b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(this.f871b.f867a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null && drawable != null && !this.f872c) {
            appCompatImageHelper.f869c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (appCompatImageHelper != null) {
            appCompatImageHelper.a();
            if (this.f872c) {
                return;
            }
            ImageView imageView = appCompatImageHelper.f867a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(appCompatImageHelper.f869c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f872c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.a();
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f870a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    @RestrictTo
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            if (appCompatImageHelper.f868b == null) {
                appCompatImageHelper.f868b = new TintInfo();
            }
            TintInfo tintInfo = appCompatImageHelper.f868b;
            tintInfo.f1180a = colorStateList;
            tintInfo.f1183d = true;
            appCompatImageHelper.a();
        }
    }

    @RestrictTo
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.f871b;
        if (appCompatImageHelper != null) {
            if (appCompatImageHelper.f868b == null) {
                appCompatImageHelper.f868b = new TintInfo();
            }
            TintInfo tintInfo = appCompatImageHelper.f868b;
            tintInfo.f1181b = mode;
            tintInfo.f1182c = true;
            appCompatImageHelper.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TintContextWrapper.a(context);
        this.f872c = false;
        ThemeUtils.a(getContext(), this);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f870a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i2);
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f871b = appCompatImageHelper;
        appCompatImageHelper.b(attributeSet, i2);
    }
}
