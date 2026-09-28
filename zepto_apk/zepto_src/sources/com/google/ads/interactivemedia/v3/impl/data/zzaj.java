package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.internal.zzea;
import com.google.ads.interactivemedia.v3.internal.zzqf;

/* loaded from: classes3.dex */
final class zzaj extends zzcc {
    private final zzqf<zzea> globalEvents;
    private final zzbn metadata;
    private final zzqf<zzea> requestEvents;

    private zzaj(zzbn zzbnVar, zzqf<zzea> zzqfVar, zzqf<zzea> zzqfVar2) {
        this.metadata = zzbnVar;
        this.requestEvents = zzqfVar;
        this.globalEvents = zzqfVar2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcc) {
            zzcc zzccVar = (zzcc) obj;
            if (this.metadata.equals(zzccVar.metadata()) && this.requestEvents.equals(zzccVar.requestEvents()) && this.globalEvents.equals(zzccVar.globalEvents())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcc
    public zzqf<zzea> globalEvents() {
        return this.globalEvents;
    }

    public int hashCode() {
        return ((((this.metadata.hashCode() ^ 1000003) * 1000003) ^ this.requestEvents.hashCode()) * 1000003) ^ this.globalEvents.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcc
    public zzbn metadata() {
        return this.metadata;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcc
    public zzqf<zzea> requestEvents() {
        return this.requestEvents;
    }

    public String toString() {
        zzqf<zzea> zzqfVar = this.globalEvents;
        zzqf<zzea> zzqfVar2 = this.requestEvents;
        String strValueOf = String.valueOf(this.metadata);
        String strValueOf2 = String.valueOf(zzqfVar2);
        return b.r(e.v("InstrumentationEventTimestampInfo{metadata=", strValueOf, ", requestEvents=", strValueOf2, ", globalEvents="), String.valueOf(zzqfVar), "}");
    }
}
