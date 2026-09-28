package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzaau;
import com.google.ads.interactivemedia.v3.internal.zzaav;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class zzaav<MessageType extends zzaav<MessageType, BuilderType>, BuilderType extends zzaau<MessageType, BuilderType>> implements zzadz {
    protected int zza = 0;

    public int zzat(zzaet zzaetVar) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadz
    public final zzabn zzau() {
        try {
            int iZzax = zzax();
            zzabn zzabnVar = zzabn.zzb;
            byte[] bArr = new byte[iZzax];
            zzabw zzabwVarZzy = zzabw.zzy(bArr, 0, iZzax);
            zzaR(zzabwVarZzy);
            zzabwVarZzy.zzz();
            return new zzabk(bArr);
        } catch (IOException e2) {
            throw new RuntimeException(b.D("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e2);
        }
    }

    public final byte[] zzav() {
        try {
            int iZzax = zzax();
            byte[] bArr = new byte[iZzax];
            zzabw zzabwVarZzy = zzabw.zzy(bArr, 0, iZzax);
            zzaR(zzabwVarZzy);
            zzabwVarZzy.zzz();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(b.D("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e2);
        }
    }
}
