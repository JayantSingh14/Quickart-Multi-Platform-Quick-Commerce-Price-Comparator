package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;

/* loaded from: classes3.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16098a;

        public AnonymousClass1(Context context) {
            this.f16098a = context;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        super(new AnonymousClass1(context));
    }
}
