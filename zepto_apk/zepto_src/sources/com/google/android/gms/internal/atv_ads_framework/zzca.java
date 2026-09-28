package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import com.google.android.gms.internal.atv_ads_framework.zzbz;
import com.google.android.gms.internal.atv_ads_framework.zzca;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzca<MessageType extends zzca<MessageType, BuilderType>, BuilderType extends zzbz<MessageType, BuilderType>> implements zzeo {
    protected int zza = 0;

    public int a(zzey zzeyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzeo
    public final zzcn zzk() {
        try {
            zzdh zzdhVar = (zzdh) this;
            int iZzn = zzdhVar.zzn();
            zzcn zzcnVar = zzcn.f36095b;
            byte[] bArr = new byte[iZzn];
            Logger logger = zzcv.f36101b;
            zzcs zzcsVar = new zzcs(bArr, iZzn);
            zzey zzeyVarA = zzew.f36171c.a(zzdhVar.getClass());
            zzcw zzcwVar = zzcsVar.f36103a;
            if (zzcwVar == null) {
                zzcwVar = new zzcw(zzcsVar);
            }
            zzeyVarA.b(zzdhVar, zzcwVar);
            if (zzcsVar.f36099e - zzcsVar.f36100f == 0) {
                return new zzck(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(b.D("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e2);
        }
    }
}
