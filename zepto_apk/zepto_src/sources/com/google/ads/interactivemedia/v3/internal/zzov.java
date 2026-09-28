package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzov {
    private final String zza;
    private final zzot zzb;
    private zzot zzc;

    public /* synthetic */ zzov(String str, zzou zzouVar) {
        zzot zzotVar = new zzot();
        this.zzb = zzotVar;
        this.zzc = zzotVar;
        str.getClass();
        this.zza = str;
    }

    private final zzot zzc() {
        zzot zzotVar = new zzot();
        this.zzc.zzc = zzotVar;
        this.zzc = zzotVar;
        return zzotVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzot zzotVar = this.zzb.zzc;
        String str = "";
        while (zzotVar != null) {
            Object obj = zzotVar.zzb;
            sb.append(str);
            String str2 = zzotVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzotVar = zzotVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzov zza(String str, @CheckForNull Object obj) {
        zzot zzotVarZzc = zzc();
        zzotVarZzc.zzb = obj;
        zzotVarZzc.zza = "consentKeyTypes";
        return this;
    }

    public final zzov zzb(@CheckForNull Object obj) {
        zzc().zzb = obj;
        return this;
    }
}
