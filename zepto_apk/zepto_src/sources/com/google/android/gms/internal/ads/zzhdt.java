package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhdt extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzhds f33621a;

    /* renamed from: b, reason: collision with root package name */
    public final String f33622b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhdr f33623c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhbf f33624d;

    public /* synthetic */ zzhdt(zzhds zzhdsVar, String str, zzhdr zzhdrVar, zzhbf zzhbfVar) {
        this.f33621a = zzhdsVar;
        this.f33622b = str;
        this.f33623c = zzhdrVar;
        this.f33624d = zzhbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33621a != zzhds.f33619c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhdt)) {
            return false;
        }
        zzhdt zzhdtVar = (zzhdt) obj;
        return zzhdtVar.f33623c.equals(this.f33623c) && zzhdtVar.f33624d.equals(this.f33624d) && zzhdtVar.f33622b.equals(this.f33622b) && zzhdtVar.f33621a.equals(this.f33621a);
    }

    public final int hashCode() {
        return Objects.hash(zzhdt.class, this.f33622b, this.f33623c, this.f33624d, this.f33621a);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33623c);
        String strValueOf2 = String.valueOf(this.f33624d);
        String strValueOf3 = String.valueOf(this.f33621a);
        String str = this.f33622b;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 64 + length2 + 27 + strValueOf2.length() + 11 + strValueOf3.length() + 1);
        android.support.v4.media.b.B(sb, "LegacyKmsEnvelopeAead Parameters (kekUri: ", str, ", dekParsingStrategy: ", strValueOf);
        android.support.v4.media.b.B(sb, ", dekParametersForNewKeys: ", strValueOf2, ", variant: ", strValueOf3);
        sb.append(")");
        return sb.toString();
    }
}
