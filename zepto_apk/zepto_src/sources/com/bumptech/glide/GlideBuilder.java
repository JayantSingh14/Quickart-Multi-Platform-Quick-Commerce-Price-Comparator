package com.bumptech.glide;

import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.util.List;

/* loaded from: classes3.dex */
public final class GlideBuilder {

    /* renamed from: b, reason: collision with root package name */
    public Engine f15658b;

    /* renamed from: c, reason: collision with root package name */
    public BitmapPool f15659c;

    /* renamed from: d, reason: collision with root package name */
    public LruArrayPool f15660d;

    /* renamed from: e, reason: collision with root package name */
    public LruResourceCache f15661e;

    /* renamed from: f, reason: collision with root package name */
    public GlideExecutor f15662f;

    /* renamed from: g, reason: collision with root package name */
    public GlideExecutor f15663g;

    /* renamed from: h, reason: collision with root package name */
    public InternalCacheDiskCacheFactory f15664h;

    /* renamed from: i, reason: collision with root package name */
    public MemorySizeCalculator f15665i;

    /* renamed from: j, reason: collision with root package name */
    public DefaultConnectivityMonitorFactory f15666j;

    /* renamed from: m, reason: collision with root package name */
    public GlideExecutor f15669m;
    public List n;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f15657a = new ArrayMap();

    /* renamed from: k, reason: collision with root package name */
    public final int f15667k = 4;

    /* renamed from: l, reason: collision with root package name */
    public final Glide.RequestOptionsFactory f15668l = new AnonymousClass1();

    /* renamed from: com.bumptech.glide.GlideBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements Glide.RequestOptionsFactory {
    }

    /* renamed from: com.bumptech.glide.GlideBuilder$2, reason: invalid class name */
    class AnonymousClass2 implements Glide.RequestOptionsFactory {
    }
}
