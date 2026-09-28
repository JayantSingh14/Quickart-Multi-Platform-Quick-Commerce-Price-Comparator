package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
class AppCompatTextHelper {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f937a;

    /* renamed from: b, reason: collision with root package name */
    public TintInfo f938b;

    /* renamed from: c, reason: collision with root package name */
    public TintInfo f939c;

    /* renamed from: d, reason: collision with root package name */
    public TintInfo f940d;

    /* renamed from: e, reason: collision with root package name */
    public TintInfo f941e;

    /* renamed from: f, reason: collision with root package name */
    public TintInfo f942f;

    /* renamed from: g, reason: collision with root package name */
    public TintInfo f943g;

    /* renamed from: h, reason: collision with root package name */
    public TintInfo f944h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextViewAutoSizeHelper f945i;

    /* renamed from: j, reason: collision with root package name */
    public int f946j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f947k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f948l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f949m;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        @DoNotInline
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        @DoNotInline
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        @DoNotInline
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @DoNotInline
        public static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @DoNotInline
        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api28Impl {
        @DoNotInline
        public static Typeface a(Typeface typeface, int i2, boolean z) {
            return Typeface.create(typeface, i2, z);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.f937a = textView;
        this.f945i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    public static TintInfo c(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList colorStateListG;
        synchronized (appCompatDrawableManager) {
            colorStateListG = appCompatDrawableManager.f836a.g(i2, context);
        }
        if (colorStateListG == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f1183d = true;
        tintInfo.f1180a = colorStateListG;
        return tintInfo;
    }

    public final void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.e(drawable, tintInfo, this.f937a.getDrawableState());
    }

    public final void b() {
        TintInfo tintInfo = this.f938b;
        TextView textView = this.f937a;
        if (tintInfo != null || this.f939c != null || this.f940d != null || this.f941e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f938b);
            a(compoundDrawables[1], this.f939c);
            a(compoundDrawables[2], this.f940d);
            a(compoundDrawables[3], this.f941e);
        }
        if (this.f942f == null && this.f943g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f942f);
        a(compoundDrawablesRelative[2], this.f943g);
    }

    public final ColorStateList d() {
        TintInfo tintInfo = this.f944h;
        if (tintInfo != null) {
            return tintInfo.f1180a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        TintInfo tintInfo = this.f944h;
        if (tintInfo != null) {
            return tintInfo.f1181b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.f(android.util.AttributeSet, int):void");
    }

    public final void g(int i2, Context context) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        TintTypedArray tintTypedArray = new TintTypedArray(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps);
        TextView textView = this.f937a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize) && typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        m(context, tintTypedArray);
        if (i3 >= 26 && typedArrayObtainStyledAttributes.hasValue(R.styleable.TextAppearance_fontVariationSettings) && (string = typedArrayObtainStyledAttributes.getString(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            Api26Impl.d(textView, string);
        }
        tintTypedArray.g();
        Typeface typeface = this.f948l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f946j);
        }
    }

    public final void h(int i2, int i3, int i4, int i5) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f945i;
        if (appCompatTextViewAutoSizeHelper.j()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f987j.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.k(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.h()) {
                appCompatTextViewAutoSizeHelper.a();
            }
        }
    }

    public final void i(int[] iArr, int i2) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f945i;
        if (appCompatTextViewAutoSizeHelper.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i2 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f987j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArrCopyOf[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.f983f = AppCompatTextViewAutoSizeHelper.b(iArrCopyOf);
                if (!appCompatTextViewAutoSizeHelper.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                appCompatTextViewAutoSizeHelper.f984g = false;
            }
            if (appCompatTextViewAutoSizeHelper.h()) {
                appCompatTextViewAutoSizeHelper.a();
            }
        }
    }

    public final void j(int i2) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f945i;
        if (appCompatTextViewAutoSizeHelper.j()) {
            if (i2 == 0) {
                appCompatTextViewAutoSizeHelper.f978a = 0;
                appCompatTextViewAutoSizeHelper.f981d = -1.0f;
                appCompatTextViewAutoSizeHelper.f982e = -1.0f;
                appCompatTextViewAutoSizeHelper.f980c = -1.0f;
                appCompatTextViewAutoSizeHelper.f983f = new int[0];
                appCompatTextViewAutoSizeHelper.f979b = false;
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f987j.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.h()) {
                appCompatTextViewAutoSizeHelper.a();
            }
        }
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f944h == null) {
            this.f944h = new TintInfo();
        }
        TintInfo tintInfo = this.f944h;
        tintInfo.f1180a = colorStateList;
        tintInfo.f1183d = colorStateList != null;
        this.f938b = tintInfo;
        this.f939c = tintInfo;
        this.f940d = tintInfo;
        this.f941e = tintInfo;
        this.f942f = tintInfo;
        this.f943g = tintInfo;
    }

    public final void l(PorterDuff.Mode mode) {
        if (this.f944h == null) {
            this.f944h = new TintInfo();
        }
        TintInfo tintInfo = this.f944h;
        tintInfo.f1181b = mode;
        tintInfo.f1182c = mode != null;
        this.f938b = tintInfo;
        this.f939c = tintInfo;
        this.f940d = tintInfo;
        this.f941e = tintInfo;
        this.f942f = tintInfo;
        this.f943g = tintInfo;
    }

    public final void m(Context context, TintTypedArray tintTypedArray) {
        String string;
        int i2 = R.styleable.TextAppearance_android_textStyle;
        int i3 = this.f946j;
        TypedArray typedArray = tintTypedArray.f1185b;
        this.f946j = typedArray.getInt(i2, i3);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            int i5 = typedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f947k = i5;
            if (i5 != -1) {
                this.f946j &= 2;
            }
        }
        if (!typedArray.hasValue(R.styleable.TextAppearance_android_fontFamily) && !typedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            if (typedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
                this.f949m = false;
                int i6 = typedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
                if (i6 == 1) {
                    this.f948l = Typeface.SANS_SERIF;
                    return;
                } else if (i6 == 2) {
                    this.f948l = Typeface.SERIF;
                    return;
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    this.f948l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f948l = null;
        int i7 = typedArray.hasValue(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        final int i8 = this.f947k;
        final int i9 = this.f946j;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.f937a);
            try {
                Typeface typefaceD = tintTypedArray.d(i7, this.f946j, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public final void b(int i10) {
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public final void c(final Typeface typeface) {
                        int i10;
                        if (Build.VERSION.SDK_INT >= 28 && (i10 = i8) != -1) {
                            typeface = Api28Impl.a(typeface, i10, (i9 & 2) != 0);
                        }
                        AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                        if (appCompatTextHelper.f949m) {
                            appCompatTextHelper.f948l = typeface;
                            final TextView textView = (TextView) weakReference.get();
                            if (textView != null) {
                                if (!textView.isAttachedToWindow()) {
                                    textView.setTypeface(typeface, appCompatTextHelper.f946j);
                                } else {
                                    final int i11 = appCompatTextHelper.f946j;
                                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            textView.setTypeface(typeface, i11);
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
                if (typefaceD != null) {
                    if (i4 < 28 || this.f947k == -1) {
                        this.f948l = typefaceD;
                    } else {
                        this.f948l = Api28Impl.a(Typeface.create(typefaceD, 0), this.f947k, (this.f946j & 2) != 0);
                    }
                }
                this.f949m = this.f948l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f948l != null || (string = typedArray.getString(i7)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f947k == -1) {
            this.f948l = Typeface.create(string, this.f946j);
        } else {
            this.f948l = Api28Impl.a(Typeface.create(string, 0), this.f947k, (this.f946j & 2) != 0);
        }
    }
}
