package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqf;
import java.util.List;

/* loaded from: classes3.dex */
final class zzan extends zzcl {
    private zzqf<zzcn> obstructions;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcl
    public zzco build() {
        zzqf<zzcn> zzqfVar = this.obstructions;
        if (zzqfVar != null) {
            return new zzap(zzqfVar);
        }
        throw new IllegalStateException("Missing required properties: obstructions");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcl
    public zzcl obstructions(List<zzcn> list) {
        this.obstructions = zzqf.zzk(list);
        return this;
    }
}
