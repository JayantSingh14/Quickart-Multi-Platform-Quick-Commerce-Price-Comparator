package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzpo {

    /* renamed from: d, reason: collision with root package name */
    public static final zzpo f35328d;

    /* renamed from: a, reason: collision with root package name */
    public final int f35329a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35330b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgtn f35331c;

    static {
        zzpo zzpoVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzgtm zzgtmVar = new zzgtm();
            for (int i2 = 1; i2 <= 10; i2++) {
                zzgtmVar.f(Integer.valueOf(zzfj.b(i2)));
            }
            zzpoVar = new zzpo(2, zzgtmVar.h());
        } else {
            zzpoVar = new zzpo(2, 10);
        }
        f35328d = zzpoVar;
    }

    public zzpo(int i2, int i3) {
        this.f35329a = i2;
        this.f35330b = i3;
        this.f35331c = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpo)) {
            return false;
        }
        zzpo zzpoVar = (zzpo) obj;
        return this.f35329a == zzpoVar.f35329a && this.f35330b == zzpoVar.f35330b && Objects.equals(this.f35331c, zzpoVar.f35331c);
    }

    public final int hashCode() {
        zzgtn zzgtnVar = this.f35331c;
        return (((this.f35329a * 31) + this.f35330b) * 31) + (zzgtnVar == null ? 0 : zzgtnVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f35331c);
        int i2 = this.f35329a;
        int length = String.valueOf(i2).length();
        int i3 = this.f35330b;
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(i3).length() + 15 + strValueOf.length() + 1);
        androidx.fragment.app.e.w(i2, i3, "AudioProfile[format=", ", maxChannelCount=", sb);
        return android.support.v4.media.b.s(sb, ", channelMasks=", strValueOf, "]");
    }

    public zzpo(int i2, Set set) {
        this.f35329a = i2;
        zzgtn zzgtnVarP = zzgtn.p(set);
        this.f35331c = zzgtnVarP;
        zzgvr it = zzgtnVarP.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.f35330b = iMax;
    }
}
