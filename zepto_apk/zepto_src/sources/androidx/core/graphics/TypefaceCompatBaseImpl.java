package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.google.android.gms.common.api.Api;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo
/* loaded from: classes3.dex */
class TypefaceCompatBaseImpl {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2841a = new ConcurrentHashMap();

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$1, reason: invalid class name */
    class AnonymousClass1 implements StyleExtractor<FontsContractCompat.FontInfo> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final boolean a(Object obj) {
            return ((FontsContractCompat.FontInfo) obj).f2926d;
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final int b(Object obj) {
            return ((FontsContractCompat.FontInfo) obj).f2925c;
        }
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$2, reason: invalid class name */
    class AnonymousClass2 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final boolean a(Object obj) {
            return ((FontResourcesParserCompat.FontFileResourceEntry) obj).f2753c;
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final int b(Object obj) {
            return ((FontResourcesParserCompat.FontFileResourceEntry) obj).f2752b;
        }
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$3, reason: invalid class name */
    class AnonymousClass3 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final boolean a(Object obj) {
            return ((FontResourcesParserCompat.FontFileResourceEntry) obj).f2753c;
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final int b(Object obj) {
            return ((FontResourcesParserCompat.FontFileResourceEntry) obj).f2752b;
        }
    }

    public interface StyleExtractor<T> {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object f(Object[] objArr, int i2, StyleExtractor styleExtractor) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        Object obj = null;
        int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(styleExtractor.b(obj2) - i3) * 2) + (styleExtractor.a(obj2) == z ? 0 : 1);
            if (obj == null || i4 > iAbs) {
                obj = obj2;
                i4 = iAbs;
            }
        }
        return obj;
    }

    public Typeface a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) throws NoSuchFieldException, SecurityException {
        long jLongValue;
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = (FontResourcesParserCompat.FontFileResourceEntry) f(fontFamilyFilesResourceEntry.f2750a, i2, new AnonymousClass2());
        if (fontFileResourceEntry == null) {
            return null;
        }
        Typeface typefaceE = TypefaceCompat.e(context, resources, fontFileResourceEntry.f2756f, fontFileResourceEntry.f2751a, 0, i2);
        if (typefaceE == null) {
            jLongValue = 0;
        } else {
            try {
                Field declaredField = Typeface.class.getDeclaredField("native_instance");
                declaredField.setAccessible(true);
                jLongValue = ((Number) declaredField.get(typefaceE)).longValue();
            } catch (IllegalAccessException e2) {
                Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            }
        }
        if (jLongValue != 0) {
            this.f2841a.put(Long.valueOf(jLongValue), fontFamilyFilesResourceEntry);
        }
        return typefaceE;
    }

    public Typeface b(Context context, FontsContractCompat.FontInfo[] fontInfoArr, int i2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(g(fontInfoArr, i2).f2923a);
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                TypefaceCompatUtil.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                TypefaceCompatUtil.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Typeface c(Context context, List list, int i2) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface d(Context context, InputStream inputStream) {
        File fileD = TypefaceCompatUtil.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.c(fileD, inputStream)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File fileD = TypefaceCompatUtil.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.b(fileD, resources, i2)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public FontsContractCompat.FontInfo g(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return (FontsContractCompat.FontInfo) f(fontInfoArr, i2, new AnonymousClass1());
    }
}
