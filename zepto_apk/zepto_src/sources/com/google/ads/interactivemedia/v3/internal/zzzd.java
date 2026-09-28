package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.IOException;
import java.util.BitSet;

/* loaded from: classes3.dex */
final class zzzd extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException, NumberFormatException {
        BitSet bitSet = new BitSet();
        zzaaqVar.zzi();
        int iZzr = zzaaqVar.zzr();
        int i2 = 0;
        while (iZzr != 2) {
            int i3 = iZzr - 1;
            if (i3 == 5 || i3 == 6) {
                int iZzb = zzaaqVar.zzb();
                if (iZzb != 0) {
                    if (iZzb != 1) {
                        throw new zzuk(b.h(iZzb, "Invalid bitset value ", ", expected 0 or 1; at path ", zzaaqVar.zzf()));
                    }
                    bitSet.set(i2);
                } else {
                    continue;
                }
            } else {
                if (i3 != 7) {
                    throw new zzuk(e.p("Invalid bitset value type: ", zzaar.zza(iZzr), "; at path ", zzaaqVar.zze()));
                }
                if (zzaaqVar.zzq()) {
                    bitSet.set(i2);
                }
            }
            i2++;
            iZzr = zzaaqVar.zzr();
        }
        zzaaqVar.zzk();
        return bitSet;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        zzaasVar.zzb();
        int length = bitSet.length();
        for (int i2 = 0; i2 < length; i2++) {
            zzaasVar.zzi(bitSet.get(i2) ? 1L : 0L);
        }
        zzaasVar.zzd();
    }
}
