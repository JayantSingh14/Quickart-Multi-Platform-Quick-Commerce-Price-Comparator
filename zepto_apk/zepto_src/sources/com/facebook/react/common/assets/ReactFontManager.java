package com.facebook.react.common.assets;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import androidx.fragment.app.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactFontManager {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f18709c = {"", "_bold", "_italic", "_bold_italic"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f18710d = {".ttf", ".otf"};

    /* renamed from: e, reason: collision with root package name */
    public static final ReactFontManager f18711e = new ReactFontManager();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f18712a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f18713b = new LinkedHashMap();

    @Metadata
    public static final class AssetFontFamily {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f18714a = new SparseArray(4);
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class TypefaceStyle {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f18715a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18716b;

        @Metadata
        public static final class Companion {
        }

        public TypefaceStyle(int i2, int i3) {
            i2 = i2 == -1 ? 0 : i2;
            this.f18715a = (i2 & 2) != 0;
            this.f18716b = i3 == -1 ? (i2 & 1) != 0 ? 700 : 400 : i3;
        }
    }

    public final Typeface a(String fontFamilyName, TypefaceStyle typefaceStyle, AssetManager assetManager) {
        Typeface typefaceCreate;
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(typefaceStyle, "typefaceStyle");
        LinkedHashMap linkedHashMap = this.f18713b;
        boolean zContainsKey = linkedHashMap.containsKey(fontFamilyName);
        int i2 = 3;
        int i3 = typefaceStyle.f18716b;
        boolean z = typefaceStyle.f18715a;
        if (zContainsKey) {
            Typeface typeface = (Typeface) linkedHashMap.get(fontFamilyName);
            if (Build.VERSION.SDK_INT >= 28) {
                Typeface typefaceCreate2 = Typeface.create(typeface, i3, z);
                Intrinsics.c(typefaceCreate2);
                return typefaceCreate2;
            }
            if (i3 < 700) {
                i2 = z ? 2 : 0;
            } else if (!z) {
                i2 = 1;
            }
            Typeface typefaceCreate3 = Typeface.create(typeface, i2);
            Intrinsics.c(typefaceCreate3);
            return typefaceCreate3;
        }
        LinkedHashMap linkedHashMap2 = this.f18712a;
        Object assetFontFamily = linkedHashMap2.get(fontFamilyName);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            linkedHashMap2.put(fontFamilyName, assetFontFamily);
        }
        AssetFontFamily assetFontFamily2 = (AssetFontFamily) assetFontFamily;
        if (i3 < 700) {
            i2 = z ? 2 : 0;
        } else if (!z) {
            i2 = 1;
        }
        SparseArray sparseArray = assetFontFamily2.f18714a;
        Typeface typeface2 = (Typeface) sparseArray.get(i2);
        if (typeface2 != null) {
            return typeface2;
        }
        if (assetManager != null) {
            String str = f18709c[i2];
            String[] strArr = f18710d;
            for (int i4 = 0; i4 < 2; i4++) {
                try {
                    typefaceCreate = Typeface.createFromAsset(assetManager, e.p("fonts/", fontFamilyName, str, strArr[i4]));
                    Intrinsics.checkNotNullExpressionValue(typefaceCreate, "createFromAsset(...)");
                    break;
                } catch (RuntimeException unused) {
                }
            }
            typefaceCreate = Typeface.create(fontFamilyName, i2);
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
        } else {
            typefaceCreate = Typeface.create(fontFamilyName, i2);
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
        }
        sparseArray.put(i2, typefaceCreate);
        return typefaceCreate;
    }
}
