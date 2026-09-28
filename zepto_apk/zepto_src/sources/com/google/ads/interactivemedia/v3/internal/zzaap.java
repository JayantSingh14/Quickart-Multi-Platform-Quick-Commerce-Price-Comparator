package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzaap extends zzwa {
    @Override // com.google.ads.interactivemedia.v3.internal.zzwa
    public final void zza(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar instanceof zzxk) {
            ((zzxk) zzaaqVar).zzn();
            return;
        }
        int iZzs = zzaaqVar.zza;
        if (iZzs == 0) {
            iZzs = zzaaqVar.zzs();
        }
        if (iZzs == 13) {
            zzaaqVar.zza = 9;
        } else if (iZzs == 12) {
            zzaaqVar.zza = 8;
        } else {
            if (iZzs != 14) {
                throw zzaaqVar.zzz("a name");
            }
            zzaaqVar.zza = 10;
        }
    }
}
