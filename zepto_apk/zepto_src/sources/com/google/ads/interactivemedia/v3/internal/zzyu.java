package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URL;

/* loaded from: classes3.dex */
final class zzyu extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        if (strZzh.equals("null")) {
            return null;
        }
        return new URL(strZzh);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        URL url = (URL) obj;
        zzaasVar.zzl(url == null ? null : url.toExternalForm());
    }
}
