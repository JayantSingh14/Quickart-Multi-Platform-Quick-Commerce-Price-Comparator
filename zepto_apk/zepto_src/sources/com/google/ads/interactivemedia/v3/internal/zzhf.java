package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzhf extends zzhe {
    public zzhf(Context context, String str, boolean z) {
        super(context, str, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzhe
    public final List zzo(zzih zzihVar, Context context, zzaf zzafVar, zzy zzyVar) {
        if (zzihVar.zzk() == null || !((zzhe) this).zzu) {
            return super.zzo(zzihVar, context, zzafVar, null);
        }
        int iZza = zzihVar.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzo(zzihVar, context, zzafVar, null));
        arrayList.add(new zziz(zzihVar, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzafVar, iZza, 24));
        return arrayList;
    }
}
