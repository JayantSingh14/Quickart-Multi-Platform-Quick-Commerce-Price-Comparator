package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes3.dex */
final class zzyv extends zzuu {
    public static final URI zza(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        try {
            String strZzh = zzaaqVar.zzh();
            if (strZzh.equals("null")) {
                return null;
            }
            return new URI(strZzh);
        } catch (URISyntaxException e2) {
            throw new zzud(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        return zza(zzaaqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        zzaasVar.zzl(uri == null ? null : uri.toASCIIString());
    }
}
