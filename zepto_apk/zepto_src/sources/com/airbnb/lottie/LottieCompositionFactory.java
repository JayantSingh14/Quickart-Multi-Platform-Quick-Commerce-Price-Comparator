package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
import okio.RealBufferedSource;
import okio.RealBufferedSource$inputStream$1;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class LottieCompositionFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f14148a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f14149b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f14150c = {80, 75, 3, 4};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f14151d = {31, -117, 8};

    public static LottieTask a(final String str, Callable callable, Runnable runnable) {
        LottieComposition lottieCompositionA = str == null ? null : LottieCompositionCache.f14469b.a(str);
        LottieTask lottieTask = lottieCompositionA != null ? new LottieTask(lottieCompositionA) : null;
        HashMap map = f14148a;
        if (str != null && map.containsKey(str)) {
            lottieTask = (LottieTask) map.get(str);
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask lottieTask2 = new LottieTask(callable, false);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final int i2 = 0;
            lottieTask2.b(new LottieListener() { // from class: com.airbnb.lottie.g
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    switch (i2) {
                        case 0:
                            HashMap map2 = LottieCompositionFactory.f14148a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                LottieCompositionFactory.q(true);
                                break;
                            }
                            break;
                        default:
                            HashMap map3 = LottieCompositionFactory.f14148a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                LottieCompositionFactory.q(true);
                                break;
                            }
                            break;
                    }
                }
            });
            final int i3 = 1;
            lottieTask2.a(new LottieListener() { // from class: com.airbnb.lottie.g
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    switch (i3) {
                        case 0:
                            HashMap map2 = LottieCompositionFactory.f14148a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                LottieCompositionFactory.q(true);
                                break;
                            }
                            break;
                        default:
                            HashMap map3 = LottieCompositionFactory.f14148a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                LottieCompositionFactory.q(true);
                                break;
                            }
                            break;
                    }
                }
            });
            if (!atomicBoolean.get()) {
                map.put(str, lottieTask2);
                if (map.size() == 1) {
                    q(false);
                }
            }
        }
        return lottieTask2;
    }

    public static LottieTask b(Context context, String str) {
        return c(context, str, "asset_" + str);
    }

    public static LottieTask c(Context context, String str, String str2) {
        return a(str2, new e(1, context.getApplicationContext(), str, str2), null);
    }

    public static LottieResult d(Context context, String str, String str2) {
        LottieComposition lottieCompositionA = str2 == null ? null : LottieCompositionCache.f14469b.a(str2);
        if (lottieCompositionA != null) {
            return new LottieResult(lottieCompositionA);
        }
        try {
            RealBufferedSource realBufferedSourceD = Okio.d(Okio.m(context.getAssets().open(str)));
            return p(realBufferedSourceD, f14150c).booleanValue() ? n(context, new ZipInputStream(new RealBufferedSource$inputStream$1(realBufferedSourceD)), str2) : p(realBufferedSourceD, f14151d).booleanValue() ? f(new GZIPInputStream(new RealBufferedSource$inputStream$1(realBufferedSourceD)), str2) : g(JsonReader.l(realBufferedSourceD), str2, true);
        } catch (IOException e2) {
            return new LottieResult(e2);
        }
    }

    public static LottieTask e(InputStream inputStream, String str) {
        return a(str, new b(str, 1, inputStream), new f(inputStream, 0));
    }

    public static LottieResult f(InputStream inputStream, String str) {
        return g(JsonReader.l(Okio.d(Okio.m(inputStream))), str, true);
    }

    public static LottieResult g(JsonReader jsonReader, String str, boolean z) throws IOException {
        LottieComposition lottieCompositionA;
        try {
            if (str == null) {
                lottieCompositionA = null;
            } else {
                try {
                    lottieCompositionA = LottieCompositionCache.f14469b.a(str);
                } catch (Exception e2) {
                    LottieResult lottieResult = new LottieResult(e2);
                    if (z) {
                        Utils.b(jsonReader);
                    }
                    return lottieResult;
                }
            }
            if (lottieCompositionA != null) {
                LottieResult lottieResult2 = new LottieResult(lottieCompositionA);
                if (z) {
                    Utils.b(jsonReader);
                }
                return lottieResult2;
            }
            LottieComposition lottieCompositionA2 = LottieCompositionMoshiParser.a(jsonReader);
            if (str != null) {
                LottieCompositionCache.f14469b.f14470a.d(str, lottieCompositionA2);
            }
            LottieResult lottieResult3 = new LottieResult(lottieCompositionA2);
            if (z) {
                Utils.b(jsonReader);
            }
            return lottieResult3;
        } catch (Throwable th) {
            if (z) {
                Utils.b(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask h(int i2, Context context) {
        return i(context, i2, r(i2, context));
    }

    public static LottieTask i(Context context, final int i2, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable() { // from class: com.airbnb.lottie.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                HashMap map = LottieCompositionFactory.f14148a;
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return LottieCompositionFactory.j(context2, i2, str);
            }
        }, null);
    }

    public static LottieResult j(Context context, int i2, String str) {
        LottieComposition lottieCompositionA = str == null ? null : LottieCompositionCache.f14469b.a(str);
        if (lottieCompositionA != null) {
            return new LottieResult(lottieCompositionA);
        }
        try {
            RealBufferedSource realBufferedSourceD = Okio.d(Okio.m(context.getResources().openRawResource(i2)));
            if (p(realBufferedSourceD, f14150c).booleanValue()) {
                return n(context, new ZipInputStream(new RealBufferedSource$inputStream$1(realBufferedSourceD)), str);
            }
            if (!p(realBufferedSourceD, f14151d).booleanValue()) {
                return g(JsonReader.l(realBufferedSourceD), str, true);
            }
            try {
                return f(new GZIPInputStream(new RealBufferedSource$inputStream$1(realBufferedSourceD)), str);
            } catch (IOException e2) {
                return new LottieResult(e2);
            }
        } catch (Resources.NotFoundException e3) {
            return new LottieResult(e3);
        }
    }

    public static LottieTask k(Context context, String str) {
        return l(context, str, "url_" + str);
    }

    public static LottieTask l(Context context, String str, String str2) {
        return a(str2, new e(0, context, str, str2), null);
    }

    public static LottieTask m(ZipInputStream zipInputStream, String str) {
        return a(str, new b(str, 3, zipInputStream), new f(zipInputStream, 1));
    }

    public static LottieResult n(Context context, ZipInputStream zipInputStream, String str) throws IOException {
        try {
            return o(context, zipInputStream, str);
        } finally {
            Utils.b(zipInputStream);
        }
    }

    public static LottieResult o(Context context, ZipInputStream zipInputStream, String str) throws IOException {
        LottieComposition lottieCompositionA;
        LottieImageAsset lottieImageAsset;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            lottieCompositionA = null;
        } else {
            try {
                lottieCompositionA = LottieCompositionCache.f14469b.a(str);
            } catch (IOException e2) {
                return new LottieResult(e2);
            }
        }
        if (lottieCompositionA != null) {
            return new LottieResult(lottieCompositionA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        LottieComposition lottieComposition = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                lottieComposition = g(JsonReader.l(Okio.d(Okio.m(zipInputStream))), null, false).f14191a;
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new LottieResult(new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream2 = new FileOutputStream(file);
                    } finally {
                    }
                } catch (Throwable th) {
                    Logger.c("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileOutputStream.close();
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    if (!file.delete()) {
                        Logger.b("Failed to delete temp font file " + file.getAbsolutePath() + CLConstants.DOT_SALT_DELIMETER);
                    }
                    map2.put(str3, typefaceCreateFromFile);
                } catch (Throwable th2) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (lottieComposition == null) {
            return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            Iterator it = ((HashMap) lottieComposition.c()).values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    lottieImageAsset = null;
                    break;
                }
                lottieImageAsset = (LottieImageAsset) it.next();
                if (lottieImageAsset.f14175d.equals(str4)) {
                    break;
                }
            }
            if (lottieImageAsset != null) {
                lottieImageAsset.f14177f = Utils.d((Bitmap) entry.getValue(), lottieImageAsset.f14172a, lottieImageAsset.f14173b);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z = false;
            for (Font font : lottieComposition.f14140f.values()) {
                if (font.f14457a.equals(entry2.getKey())) {
                    font.f14460d = (Typeface) entry2.getValue();
                    z = true;
                }
            }
            if (!z) {
                Logger.b("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it2 = ((HashMap) lottieComposition.c()).entrySet().iterator();
            while (it2.hasNext()) {
                LottieImageAsset lottieImageAsset2 = (LottieImageAsset) ((Map.Entry) it2.next()).getValue();
                if (lottieImageAsset2 == null) {
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                String str5 = lottieImageAsset2.f14175d;
                if (str5.startsWith("data:") && str5.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(str5.substring(str5.indexOf(44) + 1), 0);
                        lottieImageAsset2.f14177f = Utils.d(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options), lottieImageAsset2.f14172a, lottieImageAsset2.f14173b);
                    } catch (IllegalArgumentException e3) {
                        Logger.c("data URL did not have correct base64 format.", e3);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            LottieCompositionCache.f14469b.f14470a.d(str, lottieComposition);
        }
        return new LottieResult(lottieComposition);
    }

    public static Boolean p(RealBufferedSource realBufferedSource, byte[] bArr) {
        try {
            RealBufferedSource realBufferedSourcePeek = realBufferedSource.peek();
            for (byte b2 : bArr) {
                if (realBufferedSourcePeek.e() != b2) {
                    return Boolean.FALSE;
                }
            }
            realBufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            Logger.f14793a.getClass();
            NetworkFetcher networkFetcher = L.f14106a;
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused2) {
            return Boolean.FALSE;
        }
    }

    public static void q(boolean z) {
        ArrayList arrayList = new ArrayList(f14149b);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((LottieTaskIdleListener) arrayList.get(i2)).a();
        }
    }

    public static String r(int i2, Context context) {
        return androidx.fragment.app.e.r(new StringBuilder("rawRes"), i2, (context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
    }
}
