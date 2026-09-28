package com.google.ads.interactivemedia.pal;

import android.net.Uri;
import com.google.android.gms.internal.pal.zzjb;
import com.google.android.gms.internal.pal.zzjc;
import com.google.android.gms.internal.pal.zzjd;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzs {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzs(zzq zzqVar) {
        this.zza = zzqVar.zzb();
        this.zzb = zzqVar.zzc();
        this.zzc = zzqVar.zza();
    }

    public final void zza(String str, String str2, Map map) {
        zzjb zzjbVar = new zzjb();
        zzjbVar.b(map);
        zzjbVar.a(zzr.SDKV.zza(), this.zzb);
        zzjbVar.a(zzr.PALV.zza(), this.zza);
        zzjbVar.a(zzr.CORRELATOR.zza(), this.zzc);
        zzjbVar.a(zzr.EVENT_ID.zza(), str2);
        zzjbVar.a(zzr.LOGGER_ID.zza(), str);
        zzjc zzjcVarC = zzjbVar.c();
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        zzjd<String> zzjdVarG = zzjcVarC.f37829b;
        if (zzjdVarG == null) {
            zzjdVarG = zzjcVarC.g();
            zzjcVarC.f37829b = zzjdVarG;
        }
        for (String str3 : zzjdVarG) {
            builderBuildUpon.appendQueryParameter(str3, (String) zzjcVarC.get(str3));
        }
        new zzo(this, builderBuildUpon.build().toString()).start();
    }
}
