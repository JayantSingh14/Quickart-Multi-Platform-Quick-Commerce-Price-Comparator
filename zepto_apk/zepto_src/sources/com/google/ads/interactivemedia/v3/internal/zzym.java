package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;

/* loaded from: classes3.dex */
final class zzym extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        if (strZzh.length() == 1) {
            return Character.valueOf(strZzh.charAt(0));
        }
        throw new zzuk(e.p("Expecting character, got: ", strZzh, "; at ", zzaaqVar.zzf()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Character ch2 = (Character) obj;
        zzaasVar.zzl(ch2 == null ? null : ch2.toString());
    }
}
