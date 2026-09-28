package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class zzaeo {
    private final ArrayDeque zza = new ArrayDeque();

    private zzaeo() {
    }

    public static /* bridge */ /* synthetic */ zzabn zza(zzaeo zzaeoVar, zzabn zzabnVar, zzabn zzabnVar2) {
        zzaeoVar.zzb(zzabnVar);
        zzaeoVar.zzb(zzabnVar2);
        zzabn zzaesVar = (zzabn) zzaeoVar.zza.pop();
        while (!zzaeoVar.zza.isEmpty()) {
            zzaesVar = new zzaes((zzabn) zzaeoVar.zza.pop(), zzaesVar);
        }
        return zzaesVar;
    }

    private final void zzb(zzabn zzabnVar) {
        zzaer zzaerVar;
        if (!zzabnVar.zzh()) {
            if (!(zzabnVar instanceof zzaes)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzabnVar.getClass())));
            }
            zzaes zzaesVar = (zzaes) zzabnVar;
            zzb(zzaesVar.zzd);
            zzb(zzaesVar.zze);
            return;
        }
        int iZzc = zzc(zzabnVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzaes.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzabn) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzabnVar);
            return;
        }
        int iZzc3 = zzaes.zzc(iZzc);
        zzabn zzaesVar2 = (zzabn) this.zza.pop();
        while (true) {
            zzaerVar = null;
            if (this.zza.isEmpty() || ((zzabn) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzaesVar2 = new zzaes((zzabn) this.zza.pop(), zzaesVar2);
            }
        }
        zzaes zzaesVar3 = new zzaes(zzaesVar2, zzabnVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzaesVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzabn) arrayDeque2.peek()).zzd() >= zzaes.zzc(iZzc4)) {
                break;
            } else {
                zzaesVar3 = new zzaes((zzabn) this.zza.pop(), zzaesVar3);
            }
        }
        this.zza.push(zzaesVar3);
    }

    private static final int zzc(int i2) {
        int iBinarySearch = Arrays.binarySearch(zzaes.zza, i2);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public /* synthetic */ zzaeo(zzaen zzaenVar) {
    }
}
