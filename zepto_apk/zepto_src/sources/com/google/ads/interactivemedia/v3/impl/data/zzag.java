package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* loaded from: classes3.dex */
final class zzag extends zzca {

    @Nullable
    private final AdErrorEvent adErrorEvent;

    @Nullable
    private final zzbx component;

    @Nullable
    private final zzcc eventTimestampInfo;

    @Nullable
    private final Long latency;

    @Nullable
    private final zzch loggableException;

    @Nullable
    private final zzbz method;
    private final long timestamp;

    public zzag(long j2, @Nullable zzbx zzbxVar, @Nullable zzbz zzbzVar, @Nullable AdErrorEvent adErrorEvent, @Nullable zzch zzchVar, @Nullable Long l2, @Nullable zzcc zzccVar) {
        this.timestamp = j2;
        this.component = zzbxVar;
        this.method = zzbzVar;
        this.adErrorEvent = adErrorEvent;
        this.loggableException = zzchVar;
        this.latency = l2;
        this.eventTimestampInfo = zzccVar;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public AdErrorEvent adErrorEvent() {
        return this.adErrorEvent;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public zzbx component() {
        return this.component;
    }

    public boolean equals(Object obj) {
        zzbx zzbxVar;
        zzbz zzbzVar;
        AdErrorEvent adErrorEvent;
        zzch zzchVar;
        Long l2;
        zzcc zzccVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzca) {
            zzca zzcaVar = (zzca) obj;
            if (this.timestamp == zzcaVar.timestamp() && ((zzbxVar = this.component) != null ? zzbxVar.equals(zzcaVar.component()) : zzcaVar.component() == null) && ((zzbzVar = this.method) != null ? zzbzVar.equals(zzcaVar.method()) : zzcaVar.method() == null) && ((adErrorEvent = this.adErrorEvent) != null ? adErrorEvent.equals(zzcaVar.adErrorEvent()) : zzcaVar.adErrorEvent() == null) && ((zzchVar = this.loggableException) != null ? zzchVar.equals(zzcaVar.loggableException()) : zzcaVar.loggableException() == null) && ((l2 = this.latency) != null ? l2.equals(zzcaVar.latency()) : zzcaVar.latency() == null) && ((zzccVar = this.eventTimestampInfo) != null ? zzccVar.equals(zzcaVar.eventTimestampInfo()) : zzcaVar.eventTimestampInfo() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public zzcc eventTimestampInfo() {
        return this.eventTimestampInfo;
    }

    public int hashCode() {
        zzbx zzbxVar = this.component;
        int iHashCode = zzbxVar == null ? 0 : zzbxVar.hashCode();
        long j2 = this.timestamp;
        zzbz zzbzVar = this.method;
        int iHashCode2 = zzbzVar == null ? 0 : zzbzVar.hashCode();
        int i2 = iHashCode ^ ((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003);
        AdErrorEvent adErrorEvent = this.adErrorEvent;
        int iHashCode3 = ((((i2 * 1000003) ^ iHashCode2) * 1000003) ^ (adErrorEvent == null ? 0 : adErrorEvent.hashCode())) * 1000003;
        zzch zzchVar = this.loggableException;
        int iHashCode4 = (iHashCode3 ^ (zzchVar == null ? 0 : zzchVar.hashCode())) * 1000003;
        Long l2 = this.latency;
        int iHashCode5 = (iHashCode4 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        zzcc zzccVar = this.eventTimestampInfo;
        return iHashCode5 ^ (zzccVar != null ? zzccVar.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public Long latency() {
        return this.latency;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public zzch loggableException() {
        return this.loggableException;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    @Nullable
    public zzbz method() {
        return this.method;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzca
    public long timestamp() {
        return this.timestamp;
    }

    public String toString() {
        zzcc zzccVar = this.eventTimestampInfo;
        zzch zzchVar = this.loggableException;
        AdErrorEvent adErrorEvent = this.adErrorEvent;
        zzbz zzbzVar = this.method;
        String strValueOf = String.valueOf(this.component);
        String strValueOf2 = String.valueOf(zzbzVar);
        String strValueOf3 = String.valueOf(adErrorEvent);
        String strValueOf4 = String.valueOf(zzchVar);
        String strValueOf5 = String.valueOf(zzccVar);
        StringBuilder sb = new StringBuilder("InstrumentationData{timestamp=");
        sb.append(this.timestamp);
        sb.append(", component=");
        sb.append(strValueOf);
        b.B(sb, ", method=", strValueOf2, ", adErrorEvent=", strValueOf3);
        a.u(sb, ", loggableException=", strValueOf4, ", latency=");
        sb.append(this.latency);
        sb.append(", eventTimestampInfo=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
