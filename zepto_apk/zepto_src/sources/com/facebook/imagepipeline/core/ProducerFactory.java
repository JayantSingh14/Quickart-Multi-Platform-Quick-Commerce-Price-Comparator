package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class ProducerFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f17890a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f17891b;

    /* renamed from: c, reason: collision with root package name */
    public final AssetManager f17892c;

    /* renamed from: d, reason: collision with root package name */
    public final ByteArrayPool f17893d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageDecoder f17894e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressiveJpegConfig f17895f;

    /* renamed from: g, reason: collision with root package name */
    public final DownsampleMode f17896g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f17897h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorSupplier f17898i;

    /* renamed from: j, reason: collision with root package name */
    public final PooledByteBufferFactory f17899j;

    /* renamed from: k, reason: collision with root package name */
    public final Supplier f17900k;

    /* renamed from: l, reason: collision with root package name */
    public final InstrumentedMemoryCache f17901l;

    /* renamed from: m, reason: collision with root package name */
    public final InstrumentedMemoryCache f17902m;
    public final CacheKeyFactory n;
    public final PlatformBitmapFactory o;
    public final CloseableReferenceFactory p;
    public final int q;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean z, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, InstrumentedMemoryCache instrumentedMemoryCache, InstrumentedMemoryCache instrumentedMemoryCache2, Supplier supplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, CloseableReferenceFactory closeableReferenceFactory, int i2) {
        this.f17890a = context.getApplicationContext().getContentResolver();
        this.f17891b = context.getApplicationContext().getResources();
        this.f17892c = context.getApplicationContext().getAssets();
        this.f17893d = byteArrayPool;
        this.f17894e = imageDecoder;
        this.f17895f = progressiveJpegConfig;
        this.f17896g = downsampleMode;
        this.f17897h = z;
        this.f17898i = executorSupplier;
        this.f17899j = pooledByteBufferFactory;
        this.f17902m = instrumentedMemoryCache;
        this.f17901l = instrumentedMemoryCache2;
        this.f17900k = supplier;
        this.n = cacheKeyFactory;
        this.o = platformBitmapFactory;
        new BoundedLinkedHashSet(i2);
        new BoundedLinkedHashSet(i2);
        this.q = 2048;
        this.p = closeableReferenceFactory;
    }

    public final ResizeAndRotateProducer a(Producer producer, boolean z, MultiImageTranscoderFactory multiImageTranscoderFactory) {
        return new ResizeAndRotateProducer(this.f17898i.d(), this.f17899j, producer, z, multiImageTranscoderFactory);
    }
}
