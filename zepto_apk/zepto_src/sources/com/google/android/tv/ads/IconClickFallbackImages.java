package com.google.android.tv.ads;

import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.internal.atv_ads_framework.zzbe;
import com.google.android.gms.internal.atv_ads_framework.zzbv;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class IconClickFallbackImages implements Parcelable {

    public static abstract class Builder {
        public abstract IconClickFallbackImages a();
    }

    public static Builder a(ArrayList arrayList) {
        zzb zzbVar = new zzb();
        zzbv zzbvVar = zzbe.f36045b;
        Object[] array = arrayList.toArray();
        int length = array.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (array[i2] == null) {
                throw new NullPointerException(b.f(i2, "at index "));
            }
        }
        zzbe zzbeVarN = zzbe.n(length, array);
        if (zzbeVarN == null) {
            throw new NullPointerException("Null iconClickFallbackImageList");
        }
        zzbVar.f42221a = zzbeVarN;
        return zzbVar;
    }

    public abstract List b();
}
