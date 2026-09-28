package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class ObjectKey implements Key {

    /* renamed from: b, reason: collision with root package name */
    public final Object f16503b;

    public ObjectKey(Object obj) {
        Preconditions.c(obj, "Argument must not be null");
        this.f16503b = obj;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f16503b.toString().getBytes(Key.f15811a));
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f16503b.equals(((ObjectKey) obj).f16503b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.f16503b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f16503b + '}';
    }
}
