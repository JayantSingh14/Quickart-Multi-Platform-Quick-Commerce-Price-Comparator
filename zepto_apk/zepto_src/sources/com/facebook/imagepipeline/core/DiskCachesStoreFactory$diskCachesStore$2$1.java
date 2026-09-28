package com.facebook.imagepipeline.core;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DiskCachesStoreFactory$diskCachesStore$2$1 implements DiskCachesStore {

    /* renamed from: a, reason: collision with root package name */
    public final Object f17809a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17810b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f17811c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f17812d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f17813e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f17814f;

    public DiskCachesStoreFactory$diskCachesStore$2$1(final DiskCachesStoreFactory diskCachesStoreFactory) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53528a;
        final int i2 = 0;
        this.f17809a = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        DiskCachesStoreFactory this$0 = diskCachesStoreFactory;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        return this$0.f17800a.a(this$0.f17805f);
                    default:
                        DiskCachesStoreFactory this$02 = diskCachesStoreFactory;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        return this$02.f17800a.a(this$02.f17806g);
                }
            }
        });
        this.f17810b = LazyKt.a(lazyThreadSafetyMode, new b(0, this, diskCachesStoreFactory));
        final int i3 = 1;
        this.f17811c = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        DiskCachesStoreFactory this$0 = diskCachesStoreFactory;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        return this$0.f17800a.a(this$0.f17805f);
                    default:
                        DiskCachesStoreFactory this$02 = diskCachesStoreFactory;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        return this$02.f17800a.a(this$02.f17806g);
                }
            }
        });
        this.f17812d = LazyKt.a(lazyThreadSafetyMode, new b(1, this, diskCachesStoreFactory));
        this.f17813e = LazyKt.a(lazyThreadSafetyMode, new b(diskCachesStoreFactory, this));
        this.f17814f = LazyKt.a(lazyThreadSafetyMode, new b(3, this, diskCachesStoreFactory));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public final BufferedDiskCache a() {
        return (BufferedDiskCache) this.f17812d.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public final BufferedDiskCache b() {
        return (BufferedDiskCache) this.f17810b.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public final ImmutableMap c() {
        Object value = this.f17814f.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImmutableMap) value;
    }
}
