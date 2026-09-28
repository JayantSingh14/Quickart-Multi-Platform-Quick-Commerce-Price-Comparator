package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: classes3.dex */
final class zzy extends zzbp {

    @Nullable
    private final String detailedReason;
    private final FriendlyObstructionPurpose purpose;
    private final View view;

    private zzy(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.view = view;
        this.purpose = friendlyObstructionPurpose;
        this.detailedReason = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbp
    @Nullable
    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbp) {
            zzbp zzbpVar = (zzbp) obj;
            if (this.view.equals(zzbpVar.view()) && this.purpose.equals(zzbpVar.purpose()) && ((str = this.detailedReason) != null ? str.equals(zzbpVar.detailedReason()) : zzbpVar.detailedReason() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.view.hashCode() ^ 1000003) * 1000003) ^ this.purpose.hashCode();
        String str = this.detailedReason;
        return (iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbp
    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        return b.r(e.v("FriendlyObstructionImpl{view=", String.valueOf(this.view), ", purpose=", String.valueOf(this.purpose), ", detailedReason="), this.detailedReason, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbp
    public View view() {
        return this.view;
    }
}
