package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes3.dex */
public class TypefaceCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final TypefaceCompatBaseImpl f2822a;

    /* renamed from: b, reason: collision with root package name */
    public static final LruCache f2823b;

    @RestrictTo
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a, reason: collision with root package name */
        public ResourcesCompat.FontCallback f2824a;
    }

    static {
        Trace.beginSection(androidx.tracing.Trace.g("TypefaceCompat static init"));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f2822a = new TypefaceCompatApi29Impl();
        } else if (i2 >= 28) {
            f2822a = new TypefaceCompatApi28Impl();
        } else if (i2 >= 26) {
            f2822a = new TypefaceCompatApi26Impl();
        } else {
            Method method = TypefaceCompatApi24Impl.f2832d;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                f2822a = new TypefaceCompatApi24Impl();
            } else {
                f2822a = new TypefaceCompatApi21Impl();
            }
        }
        f2823b = new LruCache(16);
        Trace.endSection();
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Trace.beginSection(androidx.tracing.Trace.g("TypefaceCompat.createFromFontInfo"));
        try {
            return f2822a.b(context, fontInfoArr, i2);
        } finally {
            Trace.endSection();
        }
    }

    public static Typeface c(Context context, List list, int i2) {
        Trace.beginSection(androidx.tracing.Trace.g("TypefaceCompat.createFromFontInfoWithFallback"));
        try {
            return f2822a.c(context, list, i2);
        } finally {
            Trace.endSection();
        }
    }

    public static Typeface d(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i2, String str, int i3, int i4, ResourcesCompat.FontCallback fontCallback, boolean z) {
        Typeface typefaceA;
        List listUnmodifiableList;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            String str2 = providerResourceEntry.f2761e;
            Typeface typeface = null;
            if (str2 != null && !str2.isEmpty()) {
                Typeface typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                    typeface = typefaceCreate;
                }
            }
            if (typeface != null) {
                if (fontCallback != null) {
                    new Handler(Looper.getMainLooper()).post(new a(1, fontCallback, typeface));
                }
                return typeface;
            }
            boolean z2 = !z ? fontCallback != null : providerResourceEntry.f2760d != 0;
            int i5 = z ? providerResourceEntry.f2759c : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            ResourcesCallbackAdapter resourcesCallbackAdapter = new ResourcesCallbackAdapter();
            resourcesCallbackAdapter.f2824a = fontCallback;
            FontRequest fontRequest = providerResourceEntry.f2757a;
            FontRequest fontRequest2 = providerResourceEntry.f2758b;
            if (fontRequest2 != null) {
                Object[] objArr = {fontRequest, fontRequest2};
                ArrayList arrayList = new ArrayList(2);
                for (int i6 = 0; i6 < 2; i6++) {
                    Object obj = objArr[i6];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
            } else {
                Object[] objArr2 = {fontRequest};
                ArrayList arrayList2 = new ArrayList(1);
                Object obj2 = objArr2[0];
                Objects.requireNonNull(obj2);
                arrayList2.add(obj2);
                listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            }
            typefaceA = FontsContractCompat.b(context, listUnmodifiableList, i4, z2, i5, handler, resourcesCallbackAdapter);
        } else {
            typefaceA = f2822a.a(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i4);
            if (fontCallback != null) {
                if (typefaceA != null) {
                    new Handler(Looper.getMainLooper()).post(new a(1, fontCallback, typefaceA));
                } else {
                    fontCallback.a(-3);
                }
            }
        }
        if (typefaceA != null) {
            f2823b.d(f(resources, i2, str, i3, i4), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface e(Context context, Resources resources, int i2, String str, int i3, int i4) {
        Typeface typefaceE = f2822a.e(context, resources, i2, str, i4);
        if (typefaceE != null) {
            f2823b.d(f(resources, i2, str, i3, i4), typefaceE);
        }
        return typefaceE;
    }

    public static String f(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + Soundex.SILENT_MARKER + str + Soundex.SILENT_MARKER + i3 + Soundex.SILENT_MARKER + i2 + Soundex.SILENT_MARKER + i4;
    }

    public static Typeface g(Resources resources, int i2, String str, int i3, int i4) {
        return (Typeface) f2823b.c(f(resources, i2, str, i3, i4));
    }
}
