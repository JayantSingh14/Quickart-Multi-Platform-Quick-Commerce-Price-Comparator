package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class ResourceCacheKey implements Key {

    /* renamed from: j, reason: collision with root package name */
    public static final LruCache f16027j = new LruCache(50);

    /* renamed from: b, reason: collision with root package name */
    public final LruArrayPool f16028b;

    /* renamed from: c, reason: collision with root package name */
    public final Key f16029c;

    /* renamed from: d, reason: collision with root package name */
    public final Key f16030d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16031e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16032f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f16033g;

    /* renamed from: h, reason: collision with root package name */
    public final Options f16034h;

    /* renamed from: i, reason: collision with root package name */
    public final Transformation f16035i;

    public ResourceCacheKey(LruArrayPool lruArrayPool, Key key, Key key2, int i2, int i3, Transformation transformation, Class cls, Options options) {
        this.f16028b = lruArrayPool;
        this.f16029c = key;
        this.f16030d = key2;
        this.f16031e = i2;
        this.f16032f = i3;
        this.f16035i = transformation;
        this.f16033g = cls;
        this.f16034h = options;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        LruArrayPool lruArrayPool = this.f16028b;
        byte[] bArr = (byte[]) lruArrayPool.f();
        ByteBuffer.wrap(bArr).putInt(this.f16031e).putInt(this.f16032f).array();
        this.f16030d.b(messageDigest);
        this.f16029c.b(messageDigest);
        messageDigest.update(bArr);
        Transformation transformation = this.f16035i;
        if (transformation != null) {
            transformation.b(messageDigest);
        }
        this.f16034h.b(messageDigest);
        LruCache lruCache = f16027j;
        Class cls = this.f16033g;
        byte[] bytes = (byte[]) lruCache.b(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(Key.f15811a);
            lruCache.e(cls, bytes);
        }
        messageDigest.update(bytes);
        lruArrayPool.i(bArr);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            if (this.f16032f == resourceCacheKey.f16032f && this.f16031e == resourceCacheKey.f16031e && Util.a(this.f16035i, resourceCacheKey.f16035i) && this.f16033g.equals(resourceCacheKey.f16033g) && this.f16029c.equals(resourceCacheKey.f16029c) && this.f16030d.equals(resourceCacheKey.f16030d) && this.f16034h.equals(resourceCacheKey.f16034h)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        int iHashCode = ((((this.f16030d.hashCode() + (this.f16029c.hashCode() * 31)) * 31) + this.f16031e) * 31) + this.f16032f;
        Transformation transformation = this.f16035i;
        if (transformation != null) {
            iHashCode = (iHashCode * 31) + transformation.hashCode();
        }
        return this.f16034h.f15817b.hashCode() + ((this.f16033g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f16029c + ", signature=" + this.f16030d + ", width=" + this.f16031e + ", height=" + this.f16032f + ", decodedResourceClass=" + this.f16033g + ", transformation='" + this.f16035i + "', options=" + this.f16034h + '}';
    }
}
