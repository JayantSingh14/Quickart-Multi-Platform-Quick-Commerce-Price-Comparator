package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.LongSparseArray;
import androidx.collection.LongSparseArrayKt;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayCompatKt;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* renamed from: g, reason: collision with root package name */
    public static ResourceManagerInternal f1093g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f1095a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f1096b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1097c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1098d;

    /* renamed from: e, reason: collision with root package name */
    public ResourceManagerHooks f1099e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f1092f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final ColorFilterLruCache f1094h = new ColorFilterLruCache(6);

    /* loaded from: classes3.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
    }

    /* loaded from: classes3.dex */
    public static class AvdcInflateDelegate implements InflateDelegate {
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
    }

    /* loaded from: classes3.dex */
    public static class DrawableDelegate implements InflateDelegate {
    }

    /* loaded from: classes3.dex */
    public interface InflateDelegate {
    }

    @RestrictTo
    public interface ResourceManagerHooks {
    }

    /* loaded from: classes3.dex */
    public static class VdcInflateDelegate implements InflateDelegate {
    }

    public static synchronized ResourceManagerInternal b() {
        try {
            if (f1093g == null) {
                f1093g = new ResourceManagerInternal();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1093g;
    }

    public static synchronized PorterDuffColorFilter f(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        ColorFilterLruCache colorFilterLruCache = f1094h;
        colorFilterLruCache.getClass();
        int i3 = (31 + i2) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.c(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray longSparseArray = (LongSparseArray) this.f1096b.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.f1096b.put(context, longSparseArray);
                }
                longSparseArray.g(j2, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Drawable c(Context context, long j2) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f1096b.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.c(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iB = ContainerHelpersKt.b(longSparseArray.f1477b, longSparseArray.f1479d, j2);
            if (iB >= 0) {
                Object[] objArr = longSparseArray.f1478c;
                Object obj = objArr[iB];
                Object obj2 = LongSparseArrayKt.f1480a;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    longSparseArray.f1476a = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable d(int i2, Context context) {
        return e(context, i2, false);
    }

    public final synchronized Drawable e(Context context, int i2, boolean z) {
        Drawable drawableC;
        try {
            if (!this.f1098d) {
                this.f1098d = true;
                Drawable drawableD = d(R.drawable.abc_vector_test, context);
                if (drawableD == null || (!(drawableD instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawableD.getClass().getName()))) {
                    this.f1098d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            if (this.f1097c == null) {
                this.f1097c = new TypedValue();
            }
            TypedValue typedValue = this.f1097c;
            context.getResources().getValue(i2, typedValue, true);
            long j2 = (typedValue.assetCookie << 32) | typedValue.data;
            drawableC = c(context, j2);
            if (drawableC == null) {
                ResourceManagerHooks resourceManagerHooks = this.f1099e;
                drawableC = resourceManagerHooks == null ? null : ((AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks).c(this, context, i2);
                if (drawableC != null) {
                    drawableC.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, j2, drawableC);
                }
            }
            if (drawableC == null) {
                drawableC = context.getDrawable(i2);
            }
            if (drawableC != null) {
                drawableC = h(context, i2, z, drawableC);
            }
            if (drawableC != null) {
                DrawableUtils.a(drawableC);
            }
        } finally {
        }
        return drawableC;
    }

    public final synchronized ColorStateList g(int i2, Context context) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.f1095a;
        ColorStateList colorStateListE = null;
        colorStateList = (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) ? null : (ColorStateList) SparseArrayCompatKt.a(sparseArrayCompat, i2);
        if (colorStateList == null) {
            ResourceManagerHooks resourceManagerHooks = this.f1099e;
            if (resourceManagerHooks != null) {
                colorStateListE = ((AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks).e(i2, context);
            }
            if (colorStateListE != null) {
                if (this.f1095a == null) {
                    this.f1095a = new WeakHashMap();
                }
                SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) this.f1095a.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat();
                    this.f1095a.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.a(i2, colorStateListE);
            }
            colorStateList = colorStateListE;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable h(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.h(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
