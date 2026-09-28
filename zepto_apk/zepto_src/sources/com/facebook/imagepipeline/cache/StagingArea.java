package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.HashMap;

@Nullsafe
/* loaded from: classes3.dex */
public class StagingArea {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f17772a;

    public final void a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f17772a.values());
            this.f17772a.clear();
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i2);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public final synchronized EncodedImage b(CacheKey cacheKey) {
        cacheKey.getClass();
        EncodedImage encodedImageA = (EncodedImage) this.f17772a.get(cacheKey);
        if (encodedImageA != null) {
            synchronized (encodedImageA) {
                if (!EncodedImage.V(encodedImageA)) {
                    this.f17772a.remove(cacheKey);
                    FLog.p(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImageA)), cacheKey.a(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImageA = EncodedImage.a(encodedImageA);
            }
        }
        return encodedImageA;
    }

    public final synchronized void c() {
        FLog.l(StagingArea.class, "Count = %d", Integer.valueOf(this.f17772a.size()));
    }

    public final void d(CacheKey cacheKey) {
        EncodedImage encodedImage;
        cacheKey.getClass();
        synchronized (this) {
            encodedImage = (EncodedImage) this.f17772a.remove(cacheKey);
        }
        if (encodedImage == null) {
            return;
        }
        try {
            encodedImage.T();
        } finally {
            encodedImage.close();
        }
    }

    public final synchronized void e(CacheKey cacheKey, EncodedImage encodedImage) {
        cacheKey.getClass();
        encodedImage.getClass();
        if (!EncodedImage.V(encodedImage)) {
            throw new IllegalArgumentException();
        }
        EncodedImage encodedImage2 = (EncodedImage) this.f17772a.get(cacheKey);
        if (encodedImage2 == null) {
            return;
        }
        CloseableReference closeableReferenceC = CloseableReference.c(encodedImage2.f17956a);
        CloseableReference closeableReferenceC2 = CloseableReference.c(encodedImage.f17956a);
        if (closeableReferenceC != null && closeableReferenceC2 != null) {
            try {
                if (closeableReferenceC.l() == closeableReferenceC2.l()) {
                    this.f17772a.remove(cacheKey);
                    closeableReferenceC2.close();
                    closeableReferenceC.close();
                    encodedImage2.close();
                    c();
                    return;
                }
            } catch (Throwable th) {
                closeableReferenceC2.close();
                closeableReferenceC.close();
                encodedImage2.close();
                throw th;
            }
        }
        CloseableReference.e(closeableReferenceC2);
        CloseableReference.e(closeableReferenceC);
        encodedImage2.close();
    }
}
