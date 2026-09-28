package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.BucketMap;
import com.facebook.infer.annotation.Nullsafe;
import java.util.HashSet;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f18024a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final BucketMap f18025b = new BucketMap();

    public final Object a() {
        Object obj;
        BucketMap bucketMap = this.f18025b;
        synchronized (bucketMap) {
            BucketMap.LinkedEntry linkedEntry = bucketMap.f18008c;
            if (linkedEntry == null) {
                obj = null;
            } else {
                Object objPollLast = linkedEntry.f18011c.pollLast();
                if (linkedEntry.f18011c.isEmpty()) {
                    bucketMap.a(linkedEntry);
                    bucketMap.f18006a.remove(linkedEntry.f18010b);
                }
                obj = objPollLast;
            }
        }
        if (obj == null) {
            return obj;
        }
        synchronized (this) {
            this.f18024a.remove(obj);
        }
        return obj;
    }
}
