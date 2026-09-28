package com.bumptech.glide.load;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Options implements Key {

    /* renamed from: b, reason: collision with root package name */
    public final CachedHashCodeArrayMap f15817b = new CachedHashCodeArrayMap();

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        int i2 = 0;
        while (true) {
            CachedHashCodeArrayMap cachedHashCodeArrayMap = this.f15817b;
            if (i2 >= cachedHashCodeArrayMap.f1605c) {
                return;
            }
            Option option = (Option) cachedHashCodeArrayMap.f(i2);
            Object objJ = this.f15817b.j(i2);
            Option.CacheKeyUpdater cacheKeyUpdater = option.f15814b;
            if (option.f15816d == null) {
                option.f15816d = option.f15815c.getBytes(Key.f15811a);
            }
            cacheKeyUpdater.a(option.f15816d, objJ, messageDigest);
            i2++;
        }
    }

    public final Object c(Option option) {
        CachedHashCodeArrayMap cachedHashCodeArrayMap = this.f15817b;
        return cachedHashCodeArrayMap.containsKey(option) ? cachedHashCodeArrayMap.get(option) : option.f15813a;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f15817b.equals(((Options) obj).f15817b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.f15817b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f15817b + '}';
    }
}
