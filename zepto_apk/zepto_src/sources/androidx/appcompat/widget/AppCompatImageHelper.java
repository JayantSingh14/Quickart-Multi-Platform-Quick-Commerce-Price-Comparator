package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo
/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f867a;

    /* renamed from: b, reason: collision with root package name */
    public TintInfo f868b;

    /* renamed from: c, reason: collision with root package name */
    public int f869c = 0;

    public AppCompatImageHelper(ImageView imageView) {
        this.f867a = imageView;
    }

    public final void a() {
        TintInfo tintInfo;
        ImageView imageView = this.f867a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable == null || (tintInfo = this.f868b) == null) {
            return;
        }
        AppCompatDrawableManager.e(drawable, tintInfo, imageView.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i2) {
        int resourceId;
        ImageView imageView = this.f867a;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(imageView.getContext(), attributeSet, R.styleable.AppCompatImageView, i2);
        ViewCompat.y(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = tintTypedArrayF.f1185b;
            if (drawable == null && (resourceId = typedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.b(resourceId, imageView.getContext())) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            if (typedArray.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.a(imageView, tintTypedArrayF.a(R.styleable.AppCompatImageView_tint));
            }
            if (typedArray.hasValue(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.b(imageView, DrawableUtils.c(typedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
            tintTypedArrayF.g();
        } catch (Throwable th) {
            tintTypedArrayF.g();
            throw th;
        }
    }

    public final void c(int i2) {
        ImageView imageView = this.f867a;
        if (i2 != 0) {
            Drawable drawableB = AppCompatResources.b(i2, imageView.getContext());
            if (drawableB != null) {
                DrawableUtils.a(drawableB);
            }
            imageView.setImageDrawable(drawableB);
        } else {
            imageView.setImageDrawable(null);
        }
        a();
    }
}
