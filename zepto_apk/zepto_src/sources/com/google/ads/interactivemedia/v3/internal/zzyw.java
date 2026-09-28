package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.InetAddress;

/* loaded from: classes3.dex */
final class zzyw extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() != 9) {
            return InetAddress.getByName(zzaaqVar.zzh());
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        zzaasVar.zzl(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
