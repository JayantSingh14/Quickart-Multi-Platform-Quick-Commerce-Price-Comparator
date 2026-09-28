package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import com.google.android.datatransport.Transformer;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final /* synthetic */ class zze implements Transformer {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zze f36143a = new zze();

    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        zzac zzacVar = (zzac) obj;
        try {
            int iZzn = zzacVar.zzn();
            byte[] bArr = new byte[iZzn];
            Logger logger = zzcv.f36101b;
            zzcs zzcsVar = new zzcs(bArr, iZzn);
            zzey zzeyVarA = zzew.f36171c.a(zzac.class);
            zzcw zzcwVar = zzcsVar.f36103a;
            if (zzcwVar == null) {
                zzcwVar = new zzcw(zzcsVar);
            }
            zzeyVarA.b(zzacVar, zzcwVar);
            if (zzcsVar.f36099e - zzcsVar.f36100f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(b.D("Serializing ", zzacVar.getClass().getName(), " to a byte array threw an IOException (should never happen)."), e2);
        }
    }
}
