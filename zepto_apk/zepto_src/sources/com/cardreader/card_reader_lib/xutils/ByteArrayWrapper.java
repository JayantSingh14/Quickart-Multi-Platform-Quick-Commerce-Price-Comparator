package com.cardreader.card_reader_lib.xutils;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ByteArrayWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16559a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16560b;

    public ByteArrayWrapper(byte[] bArr) {
        this.f16559a = bArr;
        this.f16560b = Arrays.hashCode(bArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ByteArrayWrapper)) {
            return false;
        }
        return Arrays.equals(this.f16559a, ((ByteArrayWrapper) obj).f16559a);
    }

    public final int hashCode() {
        return this.f16560b;
    }
}
