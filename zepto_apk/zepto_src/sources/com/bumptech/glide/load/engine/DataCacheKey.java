package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class DataCacheKey implements Key {

    /* renamed from: b, reason: collision with root package name */
    public final Key f15878b;

    /* renamed from: c, reason: collision with root package name */
    public final Key f15879c;

    public DataCacheKey(Key key, Key key2) {
        this.f15878b = key;
        this.f15879c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        this.f15878b.b(messageDigest);
        this.f15879c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            if (this.f15878b.equals(dataCacheKey.f15878b) && this.f15879c.equals(dataCacheKey.f15879c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.f15879c.hashCode() + (this.f15878b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f15878b + ", signature=" + this.f15879c + '}';
    }
}
