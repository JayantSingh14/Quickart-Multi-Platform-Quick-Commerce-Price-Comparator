package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import androidx.fragment.app.e;

/* loaded from: classes3.dex */
final class zzau extends zzcq {

    @Nullable
    private final zzcr adapterVersion;
    private final Boolean isPublisherCreated;
    private final String name;

    @Nullable
    private final zzcr sdkVersion;
    private final String signals;

    public zzau(@Nullable zzcr zzcrVar, @Nullable zzcr zzcrVar2, String str, String str2, Boolean bool) {
        this.adapterVersion = zzcrVar;
        this.sdkVersion = zzcrVar2;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null signals");
        }
        this.signals = str2;
        if (bool == null) {
            throw new NullPointerException("Null isPublisherCreated");
        }
        this.isPublisherCreated = bool;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcq
    @Nullable
    public zzcr adapterVersion() {
        return this.adapterVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcq) {
            zzcq zzcqVar = (zzcq) obj;
            zzcr zzcrVar = this.adapterVersion;
            if (zzcrVar != null ? zzcrVar.equals(zzcqVar.adapterVersion()) : zzcqVar.adapterVersion() == null) {
                zzcr zzcrVar2 = this.sdkVersion;
                if (zzcrVar2 != null ? zzcrVar2.equals(zzcqVar.sdkVersion()) : zzcqVar.sdkVersion() == null) {
                    if (this.name.equals(zzcqVar.name()) && this.signals.equals(zzcqVar.signals()) && this.isPublisherCreated.equals(zzcqVar.isPublisherCreated())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        zzcr zzcrVar = this.adapterVersion;
        int iHashCode = zzcrVar == null ? 0 : zzcrVar.hashCode();
        zzcr zzcrVar2 = this.sdkVersion;
        return ((((((((iHashCode ^ 1000003) * 1000003) ^ (zzcrVar2 != null ? zzcrVar2.hashCode() : 0)) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.signals.hashCode()) * 1000003) ^ this.isPublisherCreated.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcq
    public Boolean isPublisherCreated() {
        return this.isPublisherCreated;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcq
    public String name() {
        return this.name;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcq
    @Nullable
    public zzcr sdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcq
    public String signals() {
        return this.signals;
    }

    public String toString() {
        StringBuilder sbV = e.v("SecureSignalsData{adapterVersion=", String.valueOf(this.adapterVersion), ", sdkVersion=", String.valueOf(this.sdkVersion), ", name=");
        sbV.append(this.name);
        sbV.append(", signals=");
        sbV.append(this.signals);
        sbV.append(", isPublisherCreated=");
        sbV.append(this.isPublisherCreated);
        sbV.append("}");
        return sbV.toString();
    }
}
