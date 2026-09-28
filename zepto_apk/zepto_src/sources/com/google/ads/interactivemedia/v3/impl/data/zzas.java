package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: classes3.dex */
final class zzas extends zzcn {
    private final boolean attached;
    private final zzbh bounds;

    @Nullable
    private final String detailedReason;
    private final boolean hidden;
    private final FriendlyObstructionPurpose purpose;
    private final String type;

    private zzas(boolean z, zzbh zzbhVar, @Nullable String str, boolean z2, FriendlyObstructionPurpose friendlyObstructionPurpose, String str2) {
        this.attached = z;
        this.bounds = zzbhVar;
        this.detailedReason = str;
        this.hidden = z2;
        this.purpose = friendlyObstructionPurpose;
        this.type = str2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    public boolean attached() {
        return this.attached;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    public zzbh bounds() {
        return this.bounds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    @Nullable
    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcn) {
            zzcn zzcnVar = (zzcn) obj;
            if (this.attached == zzcnVar.attached() && this.bounds.equals(zzcnVar.bounds()) && ((str = this.detailedReason) != null ? str.equals(zzcnVar.detailedReason()) : zzcnVar.detailedReason() == null) && this.hidden == zzcnVar.hidden() && this.purpose.equals(zzcnVar.purpose()) && this.type.equals(zzcnVar.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((true != this.attached ? 1237 : 1231) ^ 1000003) * 1000003) ^ this.bounds.hashCode();
        String str = this.detailedReason;
        return (((((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ (true != this.hidden ? 1237 : 1231)) * 1000003) ^ this.purpose.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    public boolean hidden() {
        return this.hidden;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.purpose;
        String strValueOf = String.valueOf(this.bounds);
        String strValueOf2 = String.valueOf(friendlyObstructionPurpose);
        StringBuilder sb = new StringBuilder("ObstructionData{attached=");
        sb.append(this.attached);
        sb.append(", bounds=");
        sb.append(strValueOf);
        sb.append(", detailedReason=");
        sb.append(this.detailedReason);
        sb.append(", hidden=");
        sb.append(this.hidden);
        sb.append(", purpose=");
        sb.append(strValueOf2);
        sb.append(", type=");
        return b.r(sb, this.type, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcn
    public String type() {
        return this.type;
    }
}
