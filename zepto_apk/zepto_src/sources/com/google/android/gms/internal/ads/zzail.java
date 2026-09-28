package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzail extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23196b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgtd f23197c;

    /* JADX WARN: Multi-variable type inference failed */
    public zzail(String str, String str2, List list) {
        super(str);
        zzgqa.a(!((AbstractCollection) list).isEmpty());
        this.f23196b = str2;
        zzgtd zzgtdVarR = zzgtd.r(list);
        this.f23197c = zzgtdVarR;
    }

    public static ArrayList b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    @Override // com.google.android.gms.internal.ads.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.internal.ads.zzam r9) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.a(com.google.android.gms.internal.ads.zzam):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzail.class == obj.getClass()) {
            zzail zzailVar = (zzail) obj;
            if (Objects.equals(this.f23184a, zzailVar.f23184a) && Objects.equals(this.f23196b, zzailVar.f23196b) && this.f23197c.equals(zzailVar.f23197c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f23184a.hashCode() + 527;
        String str = this.f23196b;
        return this.f23197c.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String strValueOf = String.valueOf(this.f23197c);
        String str = this.f23184a;
        int length = String.valueOf(str).length();
        String str2 = this.f23196b;
        StringBuilder sb = new StringBuilder(length + 14 + String.valueOf(str2).length() + 9 + strValueOf.length());
        android.support.v4.media.b.B(sb, str, ": description=", str2, ": values=");
        sb.append(strValueOf);
        return sb.toString();
    }
}
