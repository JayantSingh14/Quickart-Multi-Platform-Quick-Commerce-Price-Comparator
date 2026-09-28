package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclableBufferedInputStream f15840a;

    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final LruArrayPool f15841a;

        public Factory(LruArrayPool lruArrayPool) {
            this.f15841a = lruArrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final DataRewinder b(Object obj) {
            return new InputStreamRewinder((InputStream) obj, this.f15841a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, LruArrayPool lruArrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, lruArrayPool);
        this.f15840a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final Object a() {
        RecyclableBufferedInputStream recyclableBufferedInputStream = this.f15840a;
        recyclableBufferedInputStream.reset();
        return recyclableBufferedInputStream;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final void b() {
        this.f15840a.release();
    }
}
