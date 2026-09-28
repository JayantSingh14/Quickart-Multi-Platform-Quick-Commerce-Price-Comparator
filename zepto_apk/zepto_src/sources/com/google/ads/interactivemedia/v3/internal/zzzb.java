package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzzb extends zzuu {
    private static final zzuc zzb(zzaaq zzaaqVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 5) {
            return new zzuh(zzaaqVar.zzh());
        }
        if (i3 == 6) {
            return new zzuh(new zzwb(zzaaqVar.zzh()));
        }
        if (i3 == 7) {
            return new zzuh(Boolean.valueOf(zzaaqVar.zzq()));
        }
        if (i3 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzaar.zza(i2)));
        }
        zzaaqVar.zzm();
        return zzue.zza;
    }

    private static final zzuc zzc(zzaaq zzaaqVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 0) {
            zzaaqVar.zzi();
            return new zzua();
        }
        if (i3 != 2) {
            return null;
        }
        zzaaqVar.zzj();
        return new zzuf();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar instanceof zzxk) {
            return ((zzxk) zzaaqVar).zzd();
        }
        int iZzr = zzaaqVar.zzr();
        zzuc zzucVarZzc = zzc(zzaaqVar, iZzr);
        if (zzucVarZzc == null) {
            return zzb(zzaaqVar, iZzr);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzaaqVar.zzp()) {
                String strZzg = zzucVarZzc instanceof zzuf ? zzaaqVar.zzg() : null;
                int iZzr2 = zzaaqVar.zzr();
                zzuc zzucVarZzc2 = zzc(zzaaqVar, iZzr2);
                zzuc zzucVarZzb = zzucVarZzc2 == null ? zzb(zzaaqVar, iZzr2) : zzucVarZzc2;
                if (zzucVarZzc instanceof zzua) {
                    ((zzua) zzucVarZzc).zza(zzucVarZzb);
                } else {
                    ((zzuf) zzucVarZzc).zzb(strZzg, zzucVarZzb);
                }
                if (zzucVarZzc2 != null) {
                    arrayDeque.addLast(zzucVarZzc);
                    zzucVarZzc = zzucVarZzb;
                }
            } else {
                if (zzucVarZzc instanceof zzua) {
                    zzaaqVar.zzk();
                } else {
                    zzaaqVar.zzl();
                }
                if (arrayDeque.isEmpty()) {
                    return zzucVarZzc;
                }
                zzucVarZzc = (zzuc) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void write(zzaas zzaasVar, zzuc zzucVar) throws IOException {
        if (zzucVar == null || (zzucVar instanceof zzue)) {
            zzaasVar.zzg();
            return;
        }
        if (zzucVar instanceof zzuh) {
            zzuh zzuhVar = (zzuh) zzucVar;
            if (zzuhVar.zzj()) {
                zzaasVar.zzk(zzuhVar.zzd());
                return;
            } else if (zzuhVar.zzi()) {
                zzaasVar.zzm(zzuhVar.zzh());
                return;
            } else {
                zzaasVar.zzl(zzuhVar.zze());
                return;
            }
        }
        if (zzucVar instanceof zzua) {
            zzaasVar.zzb();
            Iterator it = ((zzua) zzucVar).iterator();
            while (it.hasNext()) {
                write(zzaasVar, (zzuc) it.next());
            }
            zzaasVar.zzd();
            return;
        }
        if (!(zzucVar instanceof zzuf)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(zzucVar.getClass())));
        }
        zzaasVar.zzc();
        for (Map.Entry entry : ((zzuf) zzucVar).zza()) {
            zzaasVar.zzf((String) entry.getKey());
            write(zzaasVar, (zzuc) entry.getValue());
        }
        zzaasVar.zze();
    }
}
