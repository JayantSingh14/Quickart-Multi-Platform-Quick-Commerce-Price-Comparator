package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzea;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import java.util.List;

/* loaded from: classes3.dex */
final class zzah implements zzcb {
    private zzqf<zzea> globalEvents;
    private zzbn metadata;
    private zzqf<zzea> requestEvents;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcb
    public zzcc build() {
        zzqf<zzea> zzqfVar;
        zzqf<zzea> zzqfVar2;
        zzbn zzbnVar = this.metadata;
        if (zzbnVar != null && (zzqfVar = this.requestEvents) != null && (zzqfVar2 = this.globalEvents) != null) {
            return new zzaj(zzbnVar, zzqfVar, zzqfVar2);
        }
        StringBuilder sb = new StringBuilder();
        if (this.metadata == null) {
            sb.append(" metadata");
        }
        if (this.requestEvents == null) {
            sb.append(" requestEvents");
        }
        if (this.globalEvents == null) {
            sb.append(" globalEvents");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcb
    public zzcb globalEvents(List<zzea> list) {
        this.globalEvents = zzqf.zzk(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcb
    public zzcb metadata(zzbn zzbnVar) {
        if (zzbnVar == null) {
            throw new NullPointerException("Null metadata");
        }
        this.metadata = zzbnVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcb
    public zzcb requestEvents(List<zzea> list) {
        this.requestEvents = zzqf.zzk(list);
        return this;
    }
}
