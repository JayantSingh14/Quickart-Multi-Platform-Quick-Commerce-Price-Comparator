package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo
/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1184a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f1185b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1186c;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        @DoNotInline
        public static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        public static int b(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.f1184a = context;
        this.f1185b = typedArray;
    }

    public static TintTypedArray e(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray f(Context context, AttributeSet attributeSet, int[] iArr, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, 0));
    }

    public final ColorStateList a(int i2) {
        int resourceId;
        ColorStateList colorStateListA;
        TypedArray typedArray = this.f1185b;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListA = AppCompatResources.a(resourceId, this.f1184a)) == null) ? typedArray.getColorStateList(i2) : colorStateListA;
    }

    public final Drawable b(int i2) {
        int resourceId;
        TypedArray typedArray = this.f1185b;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) ? typedArray.getDrawable(i2) : AppCompatResources.b(resourceId, this.f1184a);
    }

    public final Drawable c(int i2) {
        int resourceId;
        Drawable drawableE;
        if (!this.f1185b.hasValue(i2) || (resourceId = this.f1185b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManagerA = AppCompatDrawableManager.a();
        Context context = this.f1184a;
        synchronized (appCompatDrawableManagerA) {
            drawableE = appCompatDrawableManagerA.f836a.e(context, resourceId, true);
        }
        return drawableE;
    }

    public final Typeface d(int i2, int i3, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f1185b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1186c == null) {
            this.f1186c = new TypedValue();
        }
        TypedValue typedValue = this.f1186c;
        ThreadLocal threadLocal = ResourcesCompat.f2764a;
        Context context = this.f1184a;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.f(context, resourceId, typedValue, i3, fontCallback, true, false);
    }

    public final void g() {
        this.f1185b.recycle();
    }
}
