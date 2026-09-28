package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public class PoolFactory {

    /* renamed from: a, reason: collision with root package name */
    public final PoolConfig f18049a;

    /* renamed from: b, reason: collision with root package name */
    public MemoryChunkPool f18050b;

    /* renamed from: c, reason: collision with root package name */
    public BitmapPool f18051c;

    /* renamed from: d, reason: collision with root package name */
    public MemoryChunkPool f18052d;

    /* renamed from: e, reason: collision with root package name */
    public MemoryChunkPool f18053e;

    /* renamed from: f, reason: collision with root package name */
    public MemoryPooledByteBufferFactory f18054f;

    /* renamed from: g, reason: collision with root package name */
    public PooledByteStreams f18055g;

    /* renamed from: h, reason: collision with root package name */
    public GenericByteArrayPool f18056h;

    public PoolFactory(PoolConfig poolConfig) {
        this.f18049a = poolConfig;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.imagepipeline.memory.BitmapPool a() {
        /*
            r6 = this;
            com.facebook.imagepipeline.memory.BitmapPool r0 = r6.f18051c
            if (r0 != 0) goto L85
            com.facebook.imagepipeline.memory.PoolConfig r0 = r6.f18049a
            java.lang.String r1 = r0.f18047i
            int r2 = r1.hashCode()
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r2) {
                case -1868884870: goto L3b;
                case -1106578487: goto L31;
                case -404562712: goto L27;
                case -402149703: goto L1d;
                case 95945896: goto L13;
                default: goto L12;
            }
        L12:
            goto L45
        L13:
            java.lang.String r2 = "dummy"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L45
            r1 = 0
            goto L46
        L1d:
            java.lang.String r2 = "dummy_with_tracking"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L45
            r1 = r5
            goto L46
        L27:
            java.lang.String r2 = "experimental"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L45
            r1 = r4
            goto L46
        L31:
            java.lang.String r2 = "legacy"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L45
            r1 = 4
            goto L46
        L3b:
            java.lang.String r2 = "legacy_default_params"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L45
            r1 = r3
            goto L46
        L45:
            r1 = -1
        L46:
            if (r1 == 0) goto L7e
            if (r1 == r5) goto L76
            if (r1 == r4) goto L68
            com.facebook.imagepipeline.memory.NoOpPoolStatsTracker r2 = r0.f18040b
            com.facebook.common.memory.NoOpMemoryTrimmableRegistry r4 = r0.f18042d
            if (r1 == r3) goto L5c
            com.facebook.imagepipeline.memory.BucketsBitmapPool r1 = new com.facebook.imagepipeline.memory.BucketsBitmapPool
            com.facebook.imagepipeline.memory.PoolParams r0 = r0.f18039a
            r1.<init>(r4, r0, r2)
            r6.f18051c = r1
            goto L85
        L5c:
            com.facebook.imagepipeline.memory.BucketsBitmapPool r0 = new com.facebook.imagepipeline.memory.BucketsBitmapPool
            com.facebook.imagepipeline.memory.PoolParams r1 = com.facebook.imagepipeline.memory.DefaultBitmapPoolParams.a()
            r0.<init>(r4, r1, r2)
            r6.f18051c = r0
            goto L85
        L68:
            com.facebook.imagepipeline.memory.LruBitmapPool r1 = new com.facebook.imagepipeline.memory.LruBitmapPool
            com.facebook.imagepipeline.memory.NoOpPoolStatsTracker r2 = com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.a()
            int r0 = r0.f18048j
            r1.<init>(r0, r2)
            r6.f18051c = r1
            goto L85
        L76:
            com.facebook.imagepipeline.memory.DummyTrackingInUseBitmapPool r0 = new com.facebook.imagepipeline.memory.DummyTrackingInUseBitmapPool
            r0.<init>()
            r6.f18051c = r0
            goto L85
        L7e:
            com.facebook.imagepipeline.memory.DummyBitmapPool r0 = new com.facebook.imagepipeline.memory.DummyBitmapPool
            r0.<init>()
            r6.f18051c = r0
        L85:
            com.facebook.imagepipeline.memory.BitmapPool r0 = r6.f18051c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.PoolFactory.a():com.facebook.imagepipeline.memory.BitmapPool");
    }

    public final PooledByteBufferFactory b(int i2) {
        MemoryChunkPool memoryChunkPool;
        if (this.f18054f == null) {
            PoolConfig poolConfig = this.f18049a;
            NoOpPoolStatsTracker noOpPoolStatsTracker = poolConfig.f18044f;
            PoolParams poolParams = poolConfig.f18043e;
            NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry = poolConfig.f18042d;
            if (i2 == 0) {
                if (this.f18053e == null) {
                    try {
                        this.f18053e = (MemoryChunkPool) NativeMemoryChunkPool.class.getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(noOpMemoryTrimmableRegistry, poolParams, noOpPoolStatsTracker);
                    } catch (ClassNotFoundException e2) {
                        FLog.h("PoolFactory", "", e2);
                        this.f18053e = null;
                    } catch (IllegalAccessException e3) {
                        FLog.h("PoolFactory", "", e3);
                        this.f18053e = null;
                    } catch (InstantiationException e4) {
                        FLog.h("PoolFactory", "", e4);
                        this.f18053e = null;
                    } catch (NoSuchMethodException e5) {
                        FLog.h("PoolFactory", "", e5);
                        this.f18053e = null;
                    } catch (InvocationTargetException e6) {
                        FLog.h("PoolFactory", "", e6);
                        this.f18053e = null;
                    }
                }
                memoryChunkPool = this.f18053e;
            } else if (i2 == 1) {
                if (this.f18052d == null) {
                    try {
                        this.f18052d = (MemoryChunkPool) BufferMemoryChunkPool.class.getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(noOpMemoryTrimmableRegistry, poolParams, noOpPoolStatsTracker);
                    } catch (ClassNotFoundException unused) {
                        this.f18052d = null;
                    } catch (IllegalAccessException unused2) {
                        this.f18052d = null;
                    } catch (InstantiationException unused3) {
                        this.f18052d = null;
                    } catch (NoSuchMethodException unused4) {
                        this.f18052d = null;
                    } catch (InvocationTargetException unused5) {
                        this.f18052d = null;
                    }
                }
                memoryChunkPool = this.f18052d;
            } else {
                if (i2 != 2) {
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                if (this.f18050b == null) {
                    try {
                        this.f18050b = (MemoryChunkPool) AshmemMemoryChunkPool.class.getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(noOpMemoryTrimmableRegistry, poolParams, noOpPoolStatsTracker);
                    } catch (ClassNotFoundException unused6) {
                        this.f18050b = null;
                    } catch (IllegalAccessException unused7) {
                        this.f18050b = null;
                    } catch (InstantiationException unused8) {
                        this.f18050b = null;
                    } catch (NoSuchMethodException unused9) {
                        this.f18050b = null;
                    } catch (InvocationTargetException unused10) {
                        this.f18050b = null;
                    }
                }
                memoryChunkPool = this.f18050b;
            }
            Preconditions.d(memoryChunkPool, "failed to get pool for chunk type: " + i2);
            this.f18054f = new MemoryPooledByteBufferFactory(memoryChunkPool, c());
        }
        return this.f18054f;
    }

    public final PooledByteStreams c() {
        if (this.f18055g == null) {
            if (this.f18056h == null) {
                PoolConfig poolConfig = this.f18049a;
                this.f18056h = new GenericByteArrayPool(poolConfig.f18042d, poolConfig.f18045g, poolConfig.f18046h);
            }
            this.f18055g = new PooledByteStreams(this.f18056h);
        }
        return this.f18055g;
    }
}
