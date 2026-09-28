package com.bumptech.glide.load;

import android.support.v4.media.b;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Option<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final CacheKeyUpdater f15812e = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final Object f15813a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyUpdater f15814b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15815c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte[] f15816d;

    /* renamed from: com.bumptech.glide.load.Option$1, reason: invalid class name */
    public class AnonymousClass1 implements CacheKeyUpdater<Object> {
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface CacheKeyUpdater<T> {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    public Option(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f15815c = str;
        this.f15813a = obj;
        this.f15814b = cacheKeyUpdater;
    }

    public static Option a(Object obj, String str) {
        return new Option(str, obj, f15812e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f15815c.equals(((Option) obj).f15815c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15815c.hashCode();
    }

    public final String toString() {
        return b.r(new StringBuilder("Option{key='"), this.f15815c, "'}");
    }
}
