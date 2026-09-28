package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class EmptySignature implements Key {

    /* renamed from: b, reason: collision with root package name */
    public static final EmptySignature f16502b = new EmptySignature();

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
    }

    public final String toString() {
        return "EmptySignature";
    }
}
