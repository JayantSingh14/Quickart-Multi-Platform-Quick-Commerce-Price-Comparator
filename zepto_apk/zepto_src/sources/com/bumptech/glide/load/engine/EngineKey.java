package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
class EngineKey implements Key {

    /* renamed from: b, reason: collision with root package name */
    public final Object f15984b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15985c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15986d;

    /* renamed from: e, reason: collision with root package name */
    public final Class f15987e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f15988f;

    /* renamed from: g, reason: collision with root package name */
    public final Key f15989g;

    /* renamed from: h, reason: collision with root package name */
    public final CachedHashCodeArrayMap f15990h;

    /* renamed from: i, reason: collision with root package name */
    public final Options f15991i;

    /* renamed from: j, reason: collision with root package name */
    public int f15992j;

    public EngineKey(Object obj, Key key, int i2, int i3, CachedHashCodeArrayMap cachedHashCodeArrayMap, Class cls, Class cls2, Options options) {
        Preconditions.c(obj, "Argument must not be null");
        this.f15984b = obj;
        Preconditions.c(key, "Signature must not be null");
        this.f15989g = key;
        this.f15985c = i2;
        this.f15986d = i3;
        Preconditions.c(cachedHashCodeArrayMap, "Argument must not be null");
        this.f15990h = cachedHashCodeArrayMap;
        Preconditions.c(cls, "Resource class must not be null");
        this.f15987e = cls;
        Preconditions.c(cls2, "Transcode class must not be null");
        this.f15988f = cls2;
        Preconditions.c(options, "Argument must not be null");
        this.f15991i = options;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        return this.f15984b.equals(engineKey.f15984b) && this.f15989g.equals(engineKey.f15989g) && this.f15986d == engineKey.f15986d && this.f15985c == engineKey.f15985c && this.f15990h.equals(engineKey.f15990h) && this.f15987e.equals(engineKey.f15987e) && this.f15988f.equals(engineKey.f15988f) && this.f15991i.equals(engineKey.f15991i);
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        if (this.f15992j == 0) {
            int iHashCode = this.f15984b.hashCode();
            this.f15992j = iHashCode;
            int iHashCode2 = ((((this.f15989g.hashCode() + (iHashCode * 31)) * 31) + this.f15985c) * 31) + this.f15986d;
            this.f15992j = iHashCode2;
            int iHashCode3 = this.f15990h.hashCode() + (iHashCode2 * 31);
            this.f15992j = iHashCode3;
            int iHashCode4 = this.f15987e.hashCode() + (iHashCode3 * 31);
            this.f15992j = iHashCode4;
            int iHashCode5 = this.f15988f.hashCode() + (iHashCode4 * 31);
            this.f15992j = iHashCode5;
            this.f15992j = this.f15991i.f15817b.hashCode() + (iHashCode5 * 31);
        }
        return this.f15992j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f15984b + ", width=" + this.f15985c + ", height=" + this.f15986d + ", resourceClass=" + this.f15987e + ", transcodeClass=" + this.f15988f + ", signature=" + this.f15989g + ", hashCode=" + this.f15992j + ", transformations=" + this.f15990h + ", options=" + this.f15991i + '}';
    }
}
