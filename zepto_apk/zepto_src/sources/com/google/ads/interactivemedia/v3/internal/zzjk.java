package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjk extends zzjv {
    public zzjk(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3) {
        super(zzihVar, "0njjbCFUq6vJ1UgnErUI7KEtLgZLN7V9IJ5yZ3QtzXmjMaTjzKInpeDNakYTgh0P", "C8NIMy/t/HZjKrbJt0Xe/Cv+czK1jvEhHHQsIVfXSJE=", zzafVar, i2, 73);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            boolean zBooleanValue = ((Boolean) this.zzf.invoke(null, this.zzb.zzb())).booleanValue();
            zzaf zzafVar = this.zze;
            int i2 = 1;
            if (true == zBooleanValue) {
                i2 = 2;
            }
            zzafVar.zzaf(i2);
        } catch (InvocationTargetException unused) {
            this.zze.zzaf(3);
        }
    }
}
