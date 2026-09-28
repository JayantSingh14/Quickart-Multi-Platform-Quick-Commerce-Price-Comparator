package com.google.android.gms.internal.ads;

import java.security.cert.X509Certificate;

/* loaded from: classes4.dex */
final class zzaqo extends zzaqp {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f24171b;

    public zzaqo(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f24171b = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f24171b;
    }
}
