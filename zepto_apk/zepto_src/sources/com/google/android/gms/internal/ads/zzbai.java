package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbai extends zzbbh {
    public zzbai(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "0k0HoJtCvAtrnTz0UbiSqrs0BGKzSTMoo+ZxCfyJrLcMn8tbsvf/NG2/ui2bKbWP", "z6GzXqyR8kvBYJKVLhMc9mqmsbq6ZkNeWqgTkONnpqg=", zzavsVar, i2, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).K0(-1L);
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).L0(-1L);
        int[] iArr = (int[]) this.f24673e.invoke(null, this.f24669a.f24558a);
        synchronized (zzavsVar) {
            long j2 = iArr[0];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).K0(j2);
            long j3 = iArr[1];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).L0(j3);
            int i2 = iArr[2];
            if (i2 != Integer.MIN_VALUE) {
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).a0(i2);
            }
        }
    }
}
