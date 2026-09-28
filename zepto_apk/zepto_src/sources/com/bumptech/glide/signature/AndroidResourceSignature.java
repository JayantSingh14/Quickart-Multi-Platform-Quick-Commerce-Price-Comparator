package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class AndroidResourceSignature implements Key {
    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        throw null;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        ((AndroidResourceSignature) obj).getClass();
        throw null;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Util.g(0, null);
    }
}
