package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzqh {
    Object[] zza;
    int zzb;
    zzqg zzc;

    public zzqh() {
        this(4);
    }

    private final void zzd(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i3 = i2 + i2;
        if (i3 > length) {
            this.zza = Arrays.copyOf(objArr, zzqa.zza(length, i3));
        }
    }

    public final zzqh zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzpm.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        int i3 = i2 + i2;
        objArr[i3] = obj;
        objArr[i3 + 1] = obj2;
        this.zzb = i2 + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzqh zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(iterable.size() + this.zzb);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzqi zzc() {
        zzqg zzqgVar = this.zzc;
        if (zzqgVar != null) {
            throw zzqgVar.zza();
        }
        zzrc zzrcVarZzl = zzrc.zzl(this.zzb, this.zza, this);
        zzqg zzqgVar2 = this.zzc;
        if (zzqgVar2 == null) {
            return zzrcVarZzl;
        }
        throw zzqgVar2.zza();
    }

    public zzqh(int i2) {
        this.zza = new Object[i2 + i2];
        this.zzb = 0;
    }
}
