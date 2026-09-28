package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbn {

    /* renamed from: b, reason: collision with root package name */
    public static final zzbn f25323b;

    /* renamed from: a, reason: collision with root package name */
    public final zzgtd f25324a;

    static {
        zzgvs zzgvsVar = zzgtd.f33183b;
        f25323b = new zzbn(zzguy.f33232e);
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
    }

    public zzbn(zzgtd zzgtdVar) {
        this.f25324a = zzgtd.r(zzgtdVar);
    }

    public final boolean a(int i2) {
        int i3 = 0;
        while (true) {
            zzgtd zzgtdVar = this.f25324a;
            if (i3 >= zzgtdVar.size()) {
                return false;
            }
            zzbm zzbmVar = (zzbm) zzgtdVar.get(i3);
            boolean[] zArr = zzbmVar.f25316e;
            int length = zArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (!zArr[i4]) {
                    i4++;
                } else if (zzbmVar.f25313b.f24985c == i2) {
                    return true;
                }
            }
            i3++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbn.class != obj.getClass()) {
            return false;
        }
        return this.f25324a.equals(((zzbn) obj).f25324a);
    }

    public final int hashCode() {
        return this.f25324a.hashCode();
    }
}
