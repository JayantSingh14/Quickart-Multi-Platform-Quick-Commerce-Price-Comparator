package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhre extends zzhts {

    /* renamed from: a, reason: collision with root package name */
    public final zzhrc f34095a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhra f34096b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhrb f34097c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhrd f34098d;

    public /* synthetic */ zzhre(zzhrc zzhrcVar, zzhra zzhraVar, zzhrb zzhrbVar, zzhrd zzhrdVar) {
        this.f34095a = zzhrcVar;
        this.f34096b = zzhraVar;
        this.f34097c = zzhrbVar;
        this.f34098d = zzhrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f34098d != zzhrd.f34093e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhre)) {
            return false;
        }
        zzhre zzhreVar = (zzhre) obj;
        return zzhreVar.f34095a == this.f34095a && zzhreVar.f34096b == this.f34096b && zzhreVar.f34097c == this.f34097c && zzhreVar.f34098d == this.f34098d;
    }

    public final int hashCode() {
        return Objects.hash(zzhre.class, this.f34095a, this.f34096b, this.f34097c, this.f34098d);
    }

    public final String toString() {
        String string = this.f34098d.toString();
        int length = string.length();
        String string2 = this.f34097c.toString();
        int length2 = string2.length();
        String string3 = this.f34095a.toString();
        int length3 = string3.length();
        String string4 = this.f34096b.toString();
        StringBuilder sb = new StringBuilder(length + 39 + length2 + 12 + length3 + 9 + string4.length() + 1);
        android.support.v4.media.b.B(sb, "ECDSA Parameters (variant: ", string, ", hashType: ", string2);
        android.support.v4.media.b.B(sb, ", encoding: ", string3, ", curve: ", string4);
        sb.append(")");
        return sb.toString();
    }
}
