package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzof {
    public static zzny a(zzvd zzvdVar) {
        if (zzvdVar.r() == 3) {
            return new zznv(16);
        }
        if (zzvdVar.r() == 4) {
            return new zznv(32);
        }
        if (zzvdVar.r() == 5) {
            return new zznw();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzoc b(zzvd zzvdVar) {
        if (zzvdVar.t() == 3) {
            return new zzoo(new zznx("HmacSha256"));
        }
        if (zzvdVar.t() == 4) {
            return zzom.b(1);
        }
        if (zzvdVar.t() == 5) {
            return zzom.b(2);
        }
        if (zzvdVar.t() == 6) {
            return zzom.b(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static zznx c(zzvd zzvdVar) {
        if (zzvdVar.s() == 3) {
            return new zznx("HmacSha256");
        }
        if (zzvdVar.s() == 4) {
            return new zznx("HmacSha384");
        }
        if (zzvdVar.s() == 5) {
            return new zznx("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
