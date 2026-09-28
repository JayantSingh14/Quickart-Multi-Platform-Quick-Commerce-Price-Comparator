package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhin extends zzhan {

    /* renamed from: a, reason: collision with root package name */
    public final zzhka f33863a;

    public zzhin(zzhka zzhkaVar) {
        this.f33863a = zzhkaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33863a.f33917b.E() != zzhpw.RAW;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhin)) {
            return false;
        }
        zzhka zzhkaVar = ((zzhin) obj).f33863a;
        zzhka zzhkaVar2 = this.f33863a;
        if (zzhkaVar2.f33917b.E().equals(zzhkaVar.f33917b.E())) {
            zzhpd zzhpdVar = zzhkaVar2.f33917b;
            String strC = zzhpdVar.C();
            zzhpd zzhpdVar2 = zzhkaVar.f33917b;
            if (strC.equals(zzhpdVar2.C()) && zzhpdVar.D().equals(zzhpdVar2.D())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        zzhka zzhkaVar = this.f33863a;
        return Objects.hash(zzhkaVar.f33917b, zzhkaVar.f33916a);
    }

    public final String toString() {
        zzhka zzhkaVar = this.f33863a;
        String strC = zzhkaVar.f33917b.C();
        int iOrdinal = zzhkaVar.f33917b.E().ordinal();
        return android.support.v4.media.b.m("(typeUrl=", strC, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }
}
