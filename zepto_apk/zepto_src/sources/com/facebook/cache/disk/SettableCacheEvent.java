package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class SettableCacheEvent implements CacheEvent {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f17057c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static SettableCacheEvent f17058d;

    /* renamed from: e, reason: collision with root package name */
    public static int f17059e;

    /* renamed from: a, reason: collision with root package name */
    public CacheKey f17060a;

    /* renamed from: b, reason: collision with root package name */
    public SettableCacheEvent f17061b;

    public static SettableCacheEvent a() {
        synchronized (f17057c) {
            try {
                SettableCacheEvent settableCacheEvent = f17058d;
                if (settableCacheEvent == null) {
                    return new SettableCacheEvent();
                }
                f17058d = settableCacheEvent.f17061b;
                settableCacheEvent.f17061b = null;
                f17059e--;
                return settableCacheEvent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (f17057c) {
            try {
                int i2 = f17059e;
                if (i2 < 5) {
                    f17059e = i2 + 1;
                    SettableCacheEvent settableCacheEvent = f17058d;
                    if (settableCacheEvent != null) {
                        this.f17061b = settableCacheEvent;
                    }
                    f17058d = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
