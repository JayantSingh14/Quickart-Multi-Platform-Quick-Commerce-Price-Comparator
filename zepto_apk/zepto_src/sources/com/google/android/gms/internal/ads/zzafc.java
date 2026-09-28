package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public class zzafc implements zzaep {

    /* renamed from: a, reason: collision with root package name */
    public final zzaef f22916a;

    public zzafc(zzaef zzaefVar) {
        this.f22916a = zzaefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        return this.f22916a.b(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void r(int i2) throws EOFException, InterruptedIOException {
        this.f22916a.f(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void s(int i2, byte[] bArr, int i3) {
        this.f22916a.t(bArr, i2, i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final boolean t(byte[] bArr, int i2, int i3, boolean z) {
        return this.f22916a.t(bArr, 0, i3, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void u(byte[] bArr, int i2, int i3) throws EOFException, InterruptedIOException {
        this.f22916a.v(bArr, i2, i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final boolean v(byte[] bArr, int i2, int i3, boolean z) {
        return this.f22916a.v(bArr, 0, i3, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void zzf(int i2) throws EOFException, InterruptedIOException {
        this.f22916a.d(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void zzl() {
        this.f22916a.f22874f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public long zzm() {
        return this.f22916a.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public long zzn() {
        return this.f22916a.f22872d;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public long zzo() {
        return this.f22916a.f22871c;
    }
}
