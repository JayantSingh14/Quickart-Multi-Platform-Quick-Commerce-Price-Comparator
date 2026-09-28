package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzfu extends zzfw {

    /* renamed from: b, reason: collision with root package name */
    public final long f31859b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f31860c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f31861d;

    public zzfu(int i2, long j2) {
        super(i2);
        this.f31859b = j2;
        this.f31860c = new ArrayList();
        this.f31861d = new ArrayList();
    }

    public final zzfv b(int i2) {
        ArrayList arrayList = this.f31860c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzfv zzfvVar = (zzfv) arrayList.get(i3);
            if (zzfvVar.f31964a == i2) {
                return zzfvVar;
            }
        }
        return null;
    }

    public final zzfu c(int i2) {
        ArrayList arrayList = this.f31861d;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzfu zzfuVar = (zzfu) arrayList.get(i3);
            if (zzfuVar.f31964a == i2) {
                return zzfuVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final String toString() {
        ArrayList arrayList = this.f31860c;
        String strA = zzfw.a(this.f31964a);
        String string = Arrays.toString(arrayList.toArray());
        String string2 = Arrays.toString(this.f31861d.toArray());
        int length = strA.length();
        StringBuilder sb = new StringBuilder(length + 9 + String.valueOf(string).length() + 13 + String.valueOf(string2).length());
        android.support.v4.media.b.B(sb, strA, " leaves: ", string, " containers: ");
        sb.append(string2);
        return sb.toString();
    }
}
