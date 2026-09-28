package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class NativeMemoryCacheTrimStrategy implements MemoryCache.CacheTrimStrategy {

    /* renamed from: com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17770a;

        static {
            int[] iArr = new int[MemoryTrimType.values().length];
            f17770a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17770a[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17770a[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17770a[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17770a[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
