package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;

@Nullsafe
/* loaded from: classes.dex */
public class DiskCacheConfig {

    /* renamed from: a, reason: collision with root package name */
    public final int f17014a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17015b;

    /* renamed from: c, reason: collision with root package name */
    public final Supplier f17016c;

    /* renamed from: d, reason: collision with root package name */
    public final long f17017d;

    /* renamed from: e, reason: collision with root package name */
    public final long f17018e;

    /* renamed from: f, reason: collision with root package name */
    public final long f17019f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultEntryEvictionComparatorSupplier f17020g;

    /* renamed from: h, reason: collision with root package name */
    public final NoOpCacheErrorLogger f17021h;

    /* renamed from: i, reason: collision with root package name */
    public final NoOpCacheEventListener f17022i;

    /* renamed from: j, reason: collision with root package name */
    public final NoOpDiskTrimmableRegistry f17023j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f17024k;

    /* renamed from: com.facebook.cache.disk.DiskCacheConfig$1, reason: invalid class name */
    class AnonymousClass1 implements Supplier<File> {
        public AnonymousClass1() {
        }

        @Override // com.facebook.common.internal.Supplier
        public final Object get() {
            DiskCacheConfig diskCacheConfig = DiskCacheConfig.this;
            diskCacheConfig.f17024k.getClass();
            return diskCacheConfig.f17024k.getApplicationContext().getCacheDir();
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Supplier f17026a;

        /* renamed from: b, reason: collision with root package name */
        public long f17027b = 41943040;

        /* renamed from: c, reason: collision with root package name */
        public long f17028c = 10485760;

        /* renamed from: d, reason: collision with root package name */
        public long f17029d = 2097152;

        /* renamed from: e, reason: collision with root package name */
        public final DefaultEntryEvictionComparatorSupplier f17030e = new DefaultEntryEvictionComparatorSupplier();

        /* renamed from: f, reason: collision with root package name */
        public final Context f17031f;

        public Builder(Context context) {
            this.f17031f = context;
        }
    }

    public DiskCacheConfig(Builder builder) {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        NoOpCacheEventListener noOpCacheEventListener;
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        Context context = builder.f17031f;
        this.f17024k = context;
        Supplier supplier = builder.f17026a;
        if (!((supplier == null && context == null) ? false : true)) {
            throw new IllegalStateException("Either a non-null context or a base directory path or supplier must be provided.");
        }
        if (supplier == null && context != null) {
            builder.f17026a = new AnonymousClass1();
        }
        this.f17014a = 1;
        this.f17015b = "image_cache";
        Supplier supplier2 = builder.f17026a;
        supplier2.getClass();
        this.f17016c = supplier2;
        this.f17017d = builder.f17027b;
        this.f17018e = builder.f17028c;
        this.f17019f = builder.f17029d;
        DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier = builder.f17030e;
        defaultEntryEvictionComparatorSupplier.getClass();
        this.f17020g = defaultEntryEvictionComparatorSupplier;
        synchronized (NoOpCacheErrorLogger.class) {
            try {
                if (NoOpCacheErrorLogger.f16991a == null) {
                    NoOpCacheErrorLogger.f16991a = new NoOpCacheErrorLogger();
                }
                noOpCacheErrorLogger = NoOpCacheErrorLogger.f16991a;
            } finally {
            }
        }
        this.f17021h = noOpCacheErrorLogger;
        synchronized (NoOpCacheEventListener.class) {
            try {
                if (NoOpCacheEventListener.f16992a == null) {
                    NoOpCacheEventListener.f16992a = new NoOpCacheEventListener();
                }
                noOpCacheEventListener = NoOpCacheEventListener.f16992a;
            } finally {
            }
        }
        this.f17022i = noOpCacheEventListener;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            try {
                if (NoOpDiskTrimmableRegistry.f17068a == null) {
                    NoOpDiskTrimmableRegistry.f17068a = new NoOpDiskTrimmableRegistry();
                }
                noOpDiskTrimmableRegistry = NoOpDiskTrimmableRegistry.f17068a;
            } finally {
            }
        }
        this.f17023j = noOpDiskTrimmableRegistry;
    }
}
