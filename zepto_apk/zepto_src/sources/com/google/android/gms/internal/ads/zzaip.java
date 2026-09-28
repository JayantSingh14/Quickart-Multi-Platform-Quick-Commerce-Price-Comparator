package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzaip implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f23208a;

    public zzaip(ArrayList arrayList) {
        this.f23208a = arrayList;
        boolean z = false;
        if (!arrayList.isEmpty()) {
            long j2 = ((zzaio) arrayList.get(0)).f23206b;
            int i2 = 1;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (((zzaio) arrayList.get(i2)).f23205a < j2) {
                    z = true;
                    break;
                } else {
                    j2 = ((zzaio) arrayList.get(i2)).f23206b;
                    i2++;
                }
            }
        }
        zzgqa.a(!z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzaip.class != obj.getClass()) {
            return false;
        }
        return this.f23208a.equals(((zzaip) obj).f23208a);
    }

    public final int hashCode() {
        return this.f23208a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.f23208a.toString());
    }
}
