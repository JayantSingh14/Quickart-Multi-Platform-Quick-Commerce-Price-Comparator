package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexKt;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17918a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f17919b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17920c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f17918a = i2;
        this.f17919b = obj;
        this.f17920c = obj2;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj = this.f17920c;
        Object obj2 = this.f17919b;
        switch (this.f17918a) {
            case 0:
                DiskCachesStoreFactory$diskCachesStore$2$1 this$0 = (DiskCachesStoreFactory$diskCachesStore$2$1) obj2;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                DiskCachesStoreFactory this$1 = (DiskCachesStoreFactory) obj;
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                FileCache fileCache = (FileCache) this$0.f17809a.getValue();
                PooledByteBufferFactory pooledByteBufferFactoryB = this$1.f17801b.b(this$1.f17804e);
                Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactoryB, "getPooledByteBufferFactory(...)");
                PooledByteStreams pooledByteStreamsC = this$1.f17801b.c();
                Intrinsics.checkNotNullExpressionValue(pooledByteStreamsC, "getPooledByteStreams(...)");
                ExecutorSupplier executorSupplier = this$1.f17802c;
                ExecutorService executorServiceE = executorSupplier.e();
                Intrinsics.checkNotNullExpressionValue(executorServiceE, "forLocalStorageRead(...)");
                ExecutorService executorServiceB = executorSupplier.b();
                Intrinsics.checkNotNullExpressionValue(executorServiceB, "forLocalStorageWrite(...)");
                return new BufferedDiskCache(fileCache, pooledByteBufferFactoryB, pooledByteStreamsC, executorServiceE, executorServiceB, this$1.f17803d);
            case 1:
                DiskCachesStoreFactory$diskCachesStore$2$1 this$02 = (DiskCachesStoreFactory$diskCachesStore$2$1) obj2;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                DiskCachesStoreFactory this$12 = (DiskCachesStoreFactory) obj;
                Intrinsics.checkNotNullParameter(this$12, "this$1");
                FileCache fileCache2 = (FileCache) this$02.f17811c.getValue();
                PooledByteBufferFactory pooledByteBufferFactoryB2 = this$12.f17801b.b(this$12.f17804e);
                Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactoryB2, "getPooledByteBufferFactory(...)");
                PooledByteStreams pooledByteStreamsC2 = this$12.f17801b.c();
                Intrinsics.checkNotNullExpressionValue(pooledByteStreamsC2, "getPooledByteStreams(...)");
                ExecutorSupplier executorSupplier2 = this$12.f17802c;
                ExecutorService executorServiceE2 = executorSupplier2.e();
                Intrinsics.checkNotNullExpressionValue(executorServiceE2, "forLocalStorageRead(...)");
                ExecutorService executorServiceB2 = executorSupplier2.b();
                Intrinsics.checkNotNullExpressionValue(executorServiceB2, "forLocalStorageWrite(...)");
                return new BufferedDiskCache(fileCache2, pooledByteBufferFactoryB2, pooledByteStreamsC2, executorServiceE2, executorServiceB2, this$12.f17803d);
            case 2:
                DiskCachesStoreFactory this$03 = (DiskCachesStoreFactory) obj;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                Intrinsics.checkNotNullParameter((DiskCachesStoreFactory$diskCachesStore$2$1) obj2, "this$1");
                Map map = this$03.f17807h;
                if (map == null) {
                    return MapsKt.c();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.f(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), this$03.f17800a.a((DiskCacheConfig) entry.getValue()));
                }
                return linkedHashMap;
            case 3:
                DiskCachesStoreFactory$diskCachesStore$2$1 this$04 = (DiskCachesStoreFactory$diskCachesStore$2$1) obj2;
                Intrinsics.checkNotNullParameter(this$04, "this$0");
                DiskCachesStoreFactory this$13 = (DiskCachesStoreFactory) obj;
                Intrinsics.checkNotNullParameter(this$13, "this$1");
                Map map2 = (Map) this$04.f17813e.getValue();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.f(map2.size()));
                for (Map.Entry entry2 : map2.entrySet()) {
                    Object key = entry2.getKey();
                    FileCache fileCache3 = (FileCache) entry2.getValue();
                    PooledByteBufferFactory pooledByteBufferFactoryB3 = this$13.f17801b.b(this$13.f17804e);
                    Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactoryB3, "getPooledByteBufferFactory(...)");
                    PooledByteStreams pooledByteStreamsC3 = this$13.f17801b.c();
                    Intrinsics.checkNotNullExpressionValue(pooledByteStreamsC3, "getPooledByteStreams(...)");
                    ExecutorSupplier executorSupplier3 = this$13.f17802c;
                    ExecutorService executorServiceE3 = executorSupplier3.e();
                    Intrinsics.checkNotNullExpressionValue(executorServiceE3, "forLocalStorageRead(...)");
                    ExecutorService executorServiceB3 = executorSupplier3.b();
                    Intrinsics.checkNotNullExpressionValue(executorServiceB3, "forLocalStorageWrite(...)");
                    linkedHashMap2.put(key, new BufferedDiskCache(fileCache3, pooledByteBufferFactoryB3, pooledByteStreamsC3, executorServiceE3, executorServiceB3, this$13.f17803d));
                }
                return new ImmutableMap(linkedHashMap2);
            default:
                Regex.Companion companion = Regex.f53991b;
                Regex regex = (Regex) obj2;
                regex.getClass();
                CharSequence input = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(input, "input");
                Matcher matcher = regex.f53992a.matcher(input);
                Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
                return RegexKt.a(matcher, 0, input);
        }
    }

    public /* synthetic */ b(DiskCachesStoreFactory diskCachesStoreFactory, DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStoreFactory$diskCachesStore$2$1) {
        this.f17918a = 2;
        this.f17920c = diskCachesStoreFactory;
        this.f17919b = diskCachesStoreFactory$diskCachesStore$2$1;
    }
}
