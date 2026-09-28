package com.google.android.play.core.splitinstall.internal;

import java.security.cert.X509Certificate;

/* loaded from: classes4.dex */
final class zzg extends zzh {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f41983b;

    public zzg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f41983b = bArr;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzh, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f41983b;
    }
}
