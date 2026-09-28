package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjp extends zzjv {
    private final zzio zzi;
    private long zzj;

    public zzjp(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, zzio zzioVar) {
        super(zzihVar, "1LUIVO6lhWmBJfHw9DMAIriIU/Yodc7yYpCjENKu6ENqSuhgH3MJrJCpj/jKq6Pa", "V8P78mWO+MxnWR283vMX+BSDXEvrm8XlQCYXMpvUe5w=", zzafVar, i2, 53);
        this.zzi = zzioVar;
        if (zzioVar != null) {
            this.zzj = zzioVar.zza();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke(null, Long.valueOf(this.zzj))).longValue());
        }
    }
}
