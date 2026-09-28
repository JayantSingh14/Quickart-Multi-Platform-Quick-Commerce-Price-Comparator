package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
final class zzalg {

    /* renamed from: a, reason: collision with root package name */
    public final zzalh f23474a = new zzalh();

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23475b = new zzer(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f23476c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f23477d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23478e;

    public final boolean a(zzaef zzaefVar) throws InterruptedIOException {
        int i2;
        boolean z = this.f23478e;
        zzer zzerVar = this.f23475b;
        if (z) {
            this.f23478e = false;
            zzerVar.y(0);
        }
        while (true) {
            if (this.f23478e) {
                return true;
            }
            int i3 = this.f23476c;
            zzalh zzalhVar = this.f23474a;
            if (i3 < 0) {
                if (!zzalhVar.a(zzaefVar, -1L) || !zzalhVar.b(zzaefVar, true)) {
                    break;
                }
                int iB = zzalhVar.f23482d;
                if ((zzalhVar.f23479a & 1) == 1 && zzerVar.f30146c == 0) {
                    iB += b(0);
                    i2 = this.f23477d;
                } else {
                    i2 = 0;
                }
                try {
                    zzaefVar.d(iB, false);
                    this.f23476c = i2;
                    i3 = i2;
                } catch (EOFException unused) {
                }
            }
            int iB2 = b(i3);
            int i4 = this.f23476c + this.f23477d;
            if (iB2 > 0) {
                zzerVar.A(zzerVar.f30146c + iB2);
                zzaefVar.v(zzerVar.f30144a, zzerVar.f30146c, iB2, false);
                zzerVar.C(zzerVar.f30146c + iB2);
                this.f23478e = zzalhVar.f23484f[i4 + (-1)] != 255;
            }
            if (i4 == zzalhVar.f23481c) {
                i4 = -1;
            }
            this.f23476c = i4;
        }
        return false;
    }

    public final int b(int i2) {
        int i3;
        int i4 = 0;
        this.f23477d = 0;
        do {
            int i5 = this.f23477d;
            int i6 = i2 + i5;
            zzalh zzalhVar = this.f23474a;
            if (i6 >= zzalhVar.f23481c) {
                break;
            }
            this.f23477d = i5 + 1;
            i3 = zzalhVar.f23484f[i6];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }
}
