package com.google.android.gms.internal.ads;

import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzchb extends zzcgx {
    @Override // com.google.android.gms.internal.ads.zzcgx
    public final boolean e(String str) throws NoSuchAlgorithmException {
        String strD = com.google.android.gms.ads.internal.util.client.zzf.d(str, MessageDigestAlgorithms.MD5);
        zzcfk zzcfkVar = (zzcfk) this.f26217c.get();
        if (zzcfkVar != null && strD != null) {
            zzcfkVar.T(strD, this);
        }
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("VideoStreamNoopCache is doing nothing.");
        q(str, strD, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void p() {
    }
}
