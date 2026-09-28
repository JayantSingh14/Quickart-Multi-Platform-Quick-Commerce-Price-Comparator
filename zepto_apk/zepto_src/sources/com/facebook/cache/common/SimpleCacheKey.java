package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class SimpleCacheKey implements CacheKey {

    /* renamed from: a, reason: collision with root package name */
    public final String f16993a;

    public SimpleCacheKey(String str) {
        str.getClass();
        this.f16993a = str;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return this.f16993a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean b(Uri uri) {
        return this.f16993a.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean c() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleCacheKey) {
            return this.f16993a.equals(((SimpleCacheKey) obj).f16993a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16993a.hashCode();
    }

    public final String toString() {
        return this.f16993a;
    }
}
