package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.RequestExecutor;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class FontRequestWorker {

    /* renamed from: a, reason: collision with root package name */
    public static final LruCache f2905a = new LruCache(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f2906b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2907c;

    /* renamed from: d, reason: collision with root package name */
    public static final SimpleArrayMap f2908d;

    /* renamed from: androidx.core.provider.FontRequestWorker$3, reason: invalid class name */
    class AnonymousClass3 implements Callable<TypefaceResult> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2914a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f2915b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f2916c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2917d;

        public AnonymousClass3(String str, Context context, List list, int i2) {
            this.f2914a = str;
            this.f2915b = context;
            this.f2916c = list;
            this.f2917d = i2;
        }

        @Override // java.util.concurrent.Callable
        public final TypefaceResult call() {
            try {
                return FontRequestWorker.b(this.f2914a, this.f2915b, this.f2916c, this.f2917d);
            } catch (Throwable unused) {
                return new TypefaceResult(-3);
            }
        }
    }

    static {
        RequestExecutor.DefaultThreadFactory defaultThreadFactory = new RequestExecutor.DefaultThreadFactory();
        defaultThreadFactory.f2928a = "fonts-androidx";
        defaultThreadFactory.f2929b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), defaultThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2906b = threadPoolExecutor;
        f2907c = new Object();
        f2908d = new SimpleArrayMap();
    }

    public static String a(int i2, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb.append(((FontRequest) list.get(i3)).f2904e);
            sb.append("-");
            sb.append(i2);
            if (i3 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static TypefaceResult b(String str, Context context, List list, int i2) {
        int i3;
        Trace.beginSection(androidx.tracing.Trace.g("getFontSync"));
        LruCache lruCache = f2905a;
        try {
            Typeface typeface = (Typeface) lruCache.c(str);
            if (typeface != null) {
                return new TypefaceResult(typeface);
            }
            FontsContractCompat.FontFamilyResult fontFamilyResultA = FontProvider.a(context, list);
            int i4 = fontFamilyResultA.f2921a;
            List list2 = fontFamilyResultA.f2922b;
            if (i4 != 0) {
                i3 = i4 != 1 ? -3 : -2;
            } else {
                FontsContractCompat.FontInfo[] fontInfoArr = (FontsContractCompat.FontInfo[]) list2.get(0);
                if (fontInfoArr == null || fontInfoArr.length == 0) {
                    i3 = 1;
                } else {
                    int length = fontInfoArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            i3 = 0;
                            break;
                        }
                        int i6 = fontInfoArr[i5].f2927e;
                        if (i6 == 0) {
                            i5++;
                        } else if (i6 >= 0) {
                            i3 = i6;
                        }
                    }
                }
            }
            if (i3 != 0) {
                return new TypefaceResult(i3);
            }
            Typeface typefaceB = (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) ? TypefaceCompat.b(context, (FontsContractCompat.FontInfo[]) list2.get(0), i2) : TypefaceCompat.c(context, list2, i2);
            if (typefaceB == null) {
                return new TypefaceResult(-3);
            }
            lruCache.d(str, typefaceB);
            return new TypefaceResult(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        } finally {
            Trace.endSection();
        }
    }

    public static final class TypefaceResult {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f2919a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2920b;

        public TypefaceResult(int i2) {
            this.f2919a = null;
            this.f2920b = i2;
        }

        public TypefaceResult(Typeface typeface) {
            this.f2919a = typeface;
            this.f2920b = 0;
        }
    }
}
