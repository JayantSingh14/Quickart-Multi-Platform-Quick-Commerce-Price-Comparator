package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.BaseColumns;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class FontsContractCompat {

    public static final class Columns implements BaseColumns {
    }

    public static class FontInfo {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f2923a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2924b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2925c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2926d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2927e;

        public FontInfo(Uri uri, int i2, int i3, boolean z, int i4) {
            uri.getClass();
            this.f2923a = uri;
            this.f2924b = i2;
            this.f2925c = i3;
            this.f2926d = z;
            this.f2927e = i4;
        }
    }

    public static class FontRequestCallback {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface FontRequestFailReason {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TypefaceStyle {
    }

    public static FontFamilyResult a(Context context, FontRequest fontRequest) {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{fontRequest}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        return FontProvider.a(context, Collections.unmodifiableList(arrayList));
    }

    public static Typeface b(final Context context, List list, final int i2, boolean z, int i3, Handler handler, TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter) throws InterruptedException {
        final CallbackWrapper callbackWrapper = new CallbackWrapper(resourcesCallbackAdapter, new RequestExecutor.HandlerExecutor(handler));
        if (!z) {
            final String strA = FontRequestWorker.a(i2, list);
            Typeface typeface = (Typeface) FontRequestWorker.f2905a.c(strA);
            if (typeface != null) {
                callbackWrapper.a(new FontRequestWorker.TypefaceResult(typeface));
                return typeface;
            }
            Consumer<FontRequestWorker.TypefaceResult> consumer = new Consumer<FontRequestWorker.TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
                public AnonymousClass2() {
                }

                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    TypefaceResult typefaceResult = (TypefaceResult) obj;
                    if (typefaceResult == null) {
                        typefaceResult = new TypefaceResult(-3);
                    }
                    callbackWrapper.a(typefaceResult);
                }
            };
            synchronized (FontRequestWorker.f2907c) {
                try {
                    SimpleArrayMap simpleArrayMap = FontRequestWorker.f2908d;
                    ArrayList arrayList = (ArrayList) simpleArrayMap.get(strA);
                    if (arrayList != null) {
                        arrayList.add(consumer);
                        return null;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(consumer);
                    simpleArrayMap.put(strA, arrayList2);
                    FontRequestWorker.AnonymousClass3 anonymousClass3 = new FontRequestWorker.AnonymousClass3(strA, context, list, i2);
                    ThreadPoolExecutor threadPoolExecutor = FontRequestWorker.f2906b;
                    Consumer<FontRequestWorker.TypefaceResult> consumer2 = new Consumer<FontRequestWorker.TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4

                        /* renamed from: a */
                        public final /* synthetic */ String f2918a;

                        public AnonymousClass4(final String strA2) {
                            str = strA2;
                        }

                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            TypefaceResult typefaceResult = (TypefaceResult) obj;
                            synchronized (FontRequestWorker.f2907c) {
                                try {
                                    SimpleArrayMap simpleArrayMap2 = FontRequestWorker.f2908d;
                                    ArrayList arrayList3 = (ArrayList) simpleArrayMap2.get(str);
                                    if (arrayList3 == null) {
                                        return;
                                    }
                                    simpleArrayMap2.remove(str);
                                    for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                                        ((Consumer) arrayList3.get(i4)).accept(typefaceResult);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                    RequestExecutor.ReplyRunnable replyRunnable = new RequestExecutor.ReplyRunnable();
                    replyRunnable.f2932a = anonymousClass3;
                    replyRunnable.f2933b = consumer2;
                    replyRunnable.f2934c = handler2;
                    threadPoolExecutor.execute(replyRunnable);
                    return null;
                } finally {
                }
            }
        }
        if (list.size() > 1) {
            throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
        }
        final FontRequest fontRequest = (FontRequest) list.get(0);
        LruCache lruCache = FontRequestWorker.f2905a;
        ArrayList arrayList3 = new ArrayList(1);
        Object obj = new Object[]{fontRequest}[0];
        Objects.requireNonNull(obj);
        arrayList3.add(obj);
        final String strA2 = FontRequestWorker.a(i2, Collections.unmodifiableList(arrayList3));
        Typeface typeface2 = (Typeface) FontRequestWorker.f2905a.c(strA2);
        if (typeface2 != null) {
            callbackWrapper.a(new FontRequestWorker.TypefaceResult(typeface2));
            return typeface2;
        }
        if (i3 == -1) {
            ArrayList arrayList4 = new ArrayList(1);
            Object obj2 = new Object[]{fontRequest}[0];
            Objects.requireNonNull(obj2);
            arrayList4.add(obj2);
            FontRequestWorker.TypefaceResult typefaceResultB = FontRequestWorker.b(strA2, context, Collections.unmodifiableList(arrayList4), i2);
            callbackWrapper.a(typefaceResultB);
            return typefaceResultB.f2919a;
        }
        try {
            try {
                FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) FontRequestWorker.f2906b.submit(new Callable<FontRequestWorker.TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1

                    /* renamed from: a */
                    public final /* synthetic */ String f2909a;

                    /* renamed from: b */
                    public final /* synthetic */ Context f2910b;

                    /* renamed from: c */
                    public final /* synthetic */ FontRequest f2911c;

                    /* renamed from: d */
                    public final /* synthetic */ int f2912d;

                    public AnonymousClass1(final String strA22, final Context context2, final FontRequest fontRequest2, final int i22) {
                        str = strA22;
                        context = context2;
                        fontRequest = fontRequest2;
                        i = i22;
                    }

                    @Override // java.util.concurrent.Callable
                    public final TypefaceResult call() {
                        Object[] objArr = {fontRequest};
                        ArrayList arrayList5 = new ArrayList(1);
                        Object obj3 = objArr[0];
                        Objects.requireNonNull(obj3);
                        arrayList5.add(obj3);
                        return FontRequestWorker.b(str, context, Collections.unmodifiableList(arrayList5), i);
                    }
                }).get(i3, TimeUnit.MILLISECONDS);
                callbackWrapper.a(typefaceResult);
                return typefaceResult.f2919a;
            } catch (InterruptedException e2) {
                throw e2;
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            } catch (TimeoutException unused) {
                throw new InterruptedException("timeout");
            }
        } catch (InterruptedException unused2) {
            callbackWrapper.a(new FontRequestWorker.TypefaceResult(-3));
            return null;
        }
    }

    public static class FontFamilyResult {

        /* renamed from: a, reason: collision with root package name */
        public final int f2921a;

        /* renamed from: b, reason: collision with root package name */
        public final List f2922b;

        public FontFamilyResult() {
            this.f2921a = 1;
            this.f2922b = Collections.singletonList(null);
        }

        public FontFamilyResult(ArrayList arrayList) {
            this.f2921a = 0;
            this.f2922b = arrayList;
        }
    }
}
