package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a, reason: collision with root package name */
    public final Encoder f15880a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15881b;

    /* renamed from: c, reason: collision with root package name */
    public final Options f15882c;

    public DataCacheWriter(Encoder encoder, Object obj, Options options) {
        this.f15880a = encoder;
        this.f15881b = obj;
        this.f15882c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public final boolean a(File file) {
        return this.f15880a.a(this.f15881b, file, this.f15882c);
    }
}
