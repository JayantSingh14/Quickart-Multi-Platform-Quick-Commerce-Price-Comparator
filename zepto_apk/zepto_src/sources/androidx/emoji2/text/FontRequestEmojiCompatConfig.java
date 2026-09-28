package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.Trace;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.nio.MappedByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: d, reason: collision with root package name */
    public static final FontProviderHelper f4333d = new FontProviderHelper();

    /* loaded from: classes3.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
    }

    @RestrictTo
    /* loaded from: classes3.dex */
    public static class FontProviderHelper {
    }

    /* loaded from: classes3.dex */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a, reason: collision with root package name */
        public final Context f4334a;

        /* renamed from: b, reason: collision with root package name */
        public final FontRequest f4335b;

        /* renamed from: c, reason: collision with root package name */
        public final FontProviderHelper f4336c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f4337d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f4338e;

        /* renamed from: f, reason: collision with root package name */
        public ThreadPoolExecutor f4339f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f4340g;

        /* renamed from: h, reason: collision with root package name */
        public EmojiCompat.MetadataRepoLoaderCallback f4341h;

        /* renamed from: i, reason: collision with root package name */
        public ContentObserver f4342i;

        /* renamed from: androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$1, reason: invalid class name */
        class AnonymousClass1 extends ContentObserver {
            @Override // android.database.ContentObserver
            public final void onChange(boolean z, Uri uri) {
                throw null;
            }
        }

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.c(context, "Context cannot be null");
            this.f4334a = context.getApplicationContext();
            this.f4335b = fontRequest;
            this.f4336c = fontProviderHelper;
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            synchronized (this.f4337d) {
                this.f4341h = metadataRepoLoaderCallback;
            }
            synchronized (this.f4337d) {
                try {
                    if (this.f4341h == null) {
                        return;
                    }
                    if (this.f4339f == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        this.f4340g = threadPoolExecutor;
                        this.f4339f = threadPoolExecutor;
                    }
                    this.f4339f.execute(new Runnable() { // from class: androidx.emoji2.text.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = this.f4365a;
                            synchronized (fontRequestMetadataLoader.f4337d) {
                                try {
                                    if (fontRequestMetadataLoader.f4341h == null) {
                                        return;
                                    }
                                    try {
                                        FontsContractCompat.FontInfo fontInfoC = fontRequestMetadataLoader.c();
                                        int i2 = fontInfoC.f2927e;
                                        if (i2 == 2) {
                                            synchronized (fontRequestMetadataLoader.f4337d) {
                                            }
                                        }
                                        if (i2 != 0) {
                                            throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                                        }
                                        try {
                                            int i3 = TraceCompat.f2887a;
                                            Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                            FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper = fontRequestMetadataLoader.f4336c;
                                            Context context = fontRequestMetadataLoader.f4334a;
                                            fontProviderHelper.getClass();
                                            Typeface typefaceB = TypefaceCompat.b(context, new FontsContractCompat.FontInfo[]{fontInfoC}, 0);
                                            MappedByteBuffer mappedByteBufferE = TypefaceCompatUtil.e(fontRequestMetadataLoader.f4334a, fontInfoC.f2923a);
                                            if (mappedByteBufferE == null || typefaceB == null) {
                                                throw new RuntimeException("Unable to open file.");
                                            }
                                            try {
                                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                                MetadataRepo metadataRepo = new MetadataRepo(typefaceB, MetadataListReader.a(mappedByteBufferE));
                                                Trace.endSection();
                                                Trace.endSection();
                                                synchronized (fontRequestMetadataLoader.f4337d) {
                                                    try {
                                                        EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = fontRequestMetadataLoader.f4341h;
                                                        if (metadataRepoLoaderCallback2 != null) {
                                                            metadataRepoLoaderCallback2.b(metadataRepo);
                                                        }
                                                    } finally {
                                                    }
                                                }
                                                fontRequestMetadataLoader.b();
                                            } finally {
                                                int i4 = TraceCompat.f2887a;
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        synchronized (fontRequestMetadataLoader.f4337d) {
                                            try {
                                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback3 = fontRequestMetadataLoader.f4341h;
                                                if (metadataRepoLoaderCallback3 != null) {
                                                    metadataRepoLoaderCallback3.a(th2);
                                                }
                                                fontRequestMetadataLoader.b();
                                            } finally {
                                            }
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void b() {
            synchronized (this.f4337d) {
                try {
                    this.f4341h = null;
                    ContentObserver contentObserver = this.f4342i;
                    if (contentObserver != null) {
                        FontProviderHelper fontProviderHelper = this.f4336c;
                        Context context = this.f4334a;
                        fontProviderHelper.getClass();
                        context.getContentResolver().unregisterContentObserver(contentObserver);
                        this.f4342i = null;
                    }
                    Handler handler = this.f4338e;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                    }
                    this.f4338e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f4340g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f4339f = null;
                    this.f4340g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final FontsContractCompat.FontInfo c() {
            try {
                FontProviderHelper fontProviderHelper = this.f4336c;
                Context context = this.f4334a;
                FontRequest fontRequest = this.f4335b;
                fontProviderHelper.getClass();
                FontsContractCompat.FontFamilyResult fontFamilyResultA = FontsContractCompat.a(context, fontRequest);
                int i2 = fontFamilyResultA.f2921a;
                if (i2 != 0) {
                    throw new RuntimeException(android.support.v4.media.b.g(i2, "fetchFonts failed (", ")"));
                }
                FontsContractCompat.FontInfo[] fontInfoArr = (FontsContractCompat.FontInfo[]) fontFamilyResultA.f2922b.get(0);
                if (fontInfoArr == null || fontInfoArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fontInfoArr[0];
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        public final void d(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this.f4337d) {
                this.f4339f = threadPoolExecutor;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class RetryPolicy {
    }
}
