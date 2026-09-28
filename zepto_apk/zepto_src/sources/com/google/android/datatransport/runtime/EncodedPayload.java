package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EncodedPayload {

    /* renamed from: a, reason: collision with root package name */
    public final Encoding f20745a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f20746b;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f20745a = encoding;
        this.f20746b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.f20745a.equals(encodedPayload.f20745a)) {
            return Arrays.equals(this.f20746b, encodedPayload.f20746b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f20745a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20746b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f20745a + ", bytes=[...]}";
    }
}
