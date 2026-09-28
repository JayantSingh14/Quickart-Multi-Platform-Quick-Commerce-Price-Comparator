package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.memory.BucketMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {

    @Metadata
    public static final class Companion {
    }

    public static boolean c(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            FLog.v("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        FLog.v("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }

    public final Object b(int i2) {
        Object objPollFirst;
        BucketMap bucketMap = this.f18025b;
        synchronized (bucketMap) {
            BucketMap.LinkedEntry linkedEntry = (BucketMap.LinkedEntry) bucketMap.f18006a.get(i2);
            if (linkedEntry == null) {
                objPollFirst = null;
            } else {
                objPollFirst = linkedEntry.f18011c.pollFirst();
                if (bucketMap.f18007b != linkedEntry) {
                    bucketMap.a(linkedEntry);
                    BucketMap.LinkedEntry linkedEntry2 = bucketMap.f18007b;
                    if (linkedEntry2 == null) {
                        bucketMap.f18007b = linkedEntry;
                        bucketMap.f18008c = linkedEntry;
                    } else {
                        linkedEntry.f18012d = linkedEntry2;
                        linkedEntry2.f18009a = linkedEntry;
                        bucketMap.f18007b = linkedEntry;
                    }
                }
            }
        }
        if (objPollFirst != null) {
            synchronized (this) {
                this.f18024a.remove(objPollFirst);
            }
        }
        Bitmap bitmap = (Bitmap) objPollFirst;
        if (bitmap == null || !c(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }
}
