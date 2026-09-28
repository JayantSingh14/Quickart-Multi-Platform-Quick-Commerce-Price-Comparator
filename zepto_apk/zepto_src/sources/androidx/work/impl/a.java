package androidx.work.impl;

import androidx.work.impl.model.WorkTagDao;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12690a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12691b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12692c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12693d;

    public /* synthetic */ a(UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule, String str, String str2) {
        this.f12690a = 2;
        this.f12691b = universalFirebaseAnalyticsModule;
        this.f12693d = str;
        this.f12692c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        PooledByteBuffer pooledByteBufferD;
        switch (this.f12690a) {
            case 0:
                WorkDatabase workDatabase = ((Processor) this.f12691b).f12620e;
                WorkTagDao workTagDaoW = workDatabase.w();
                String str = (String) this.f12693d;
                ((ArrayList) this.f12692c).addAll(workTagDaoW.a(str));
                return workDatabase.v().j(str);
            case 1:
                AtomicBoolean isCancelled = (AtomicBoolean) this.f12691b;
                Intrinsics.checkNotNullParameter(isCancelled, "$isCancelled");
                BufferedDiskCache this$0 = (BufferedDiskCache) this.f12692c;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                CacheKey key = (CacheKey) this.f12693d;
                Intrinsics.checkNotNullParameter(key, "$key");
                try {
                    if (isCancelled.get()) {
                        throw new CancellationException();
                    }
                    EncodedImage encodedImageB = this$0.f17736g.b(key);
                    ImageCacheStatsTracker imageCacheStatsTracker = this$0.f17735f;
                    if (encodedImageB != null) {
                        FLog.l(BufferedDiskCache.class, "Found image for %s in staging area", key.a());
                        imageCacheStatsTracker.getClass();
                    } else {
                        FLog.l(BufferedDiskCache.class, "Did not find image for %s in staging area", key.a());
                        imageCacheStatsTracker.getClass();
                        try {
                            pooledByteBufferD = this$0.d(key);
                        } catch (Exception unused) {
                        }
                        if (pooledByteBufferD == null) {
                            return null;
                        }
                        DefaultCloseableReference defaultCloseableReferenceD = CloseableReference.D(pooledByteBufferD);
                        Intrinsics.checkNotNullExpressionValue(defaultCloseableReferenceD, "of(...)");
                        try {
                            EncodedImage encodedImage = new EncodedImage(defaultCloseableReferenceD);
                            defaultCloseableReferenceD.close();
                            encodedImageB = encodedImage;
                        } catch (Throwable th) {
                            CloseableReference.e(defaultCloseableReferenceD);
                            throw th;
                        }
                    }
                    if (!Thread.interrupted()) {
                        return encodedImageB;
                    }
                    if (FLog.f17086a.a(2)) {
                        FLogDefaultLoggingDelegate.b(2, "BufferedDiskCache", "Host thread was interrupted, decreasing reference count");
                    }
                    encodedImageB.close();
                    throw new InterruptedException();
                } catch (Throwable th2) {
                    Intrinsics.checkNotNullParameter(th2, "th");
                    throw th2;
                }
            default:
                FirebaseAnalytics.getInstance(((UniversalFirebaseAnalyticsModule) this.f12691b).f49247a).f43527a.p(null, (String) this.f12693d, (String) this.f12692c, false);
                return null;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f12690a = i2;
        this.f12691b = obj;
        this.f12692c = obj2;
        this.f12693d = obj3;
    }
}
