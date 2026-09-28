package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzak extends zzch {

    @Nullable
    private final String message;

    @Nullable
    private final String name;

    public zzak(@Nullable String str, @Nullable String str2) {
        this.name = str;
        this.message = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzch) {
            zzch zzchVar = (zzch) obj;
            String str = this.name;
            if (str != null ? str.equals(zzchVar.name()) : zzchVar.name() == null) {
                String str2 = this.message;
                if (str2 != null ? str2.equals(zzchVar.message()) : zzchVar.message() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.message;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzch
    @Nullable
    public String message() {
        return this.message;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzch
    @Nullable
    public String name() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LoggableException{name=");
        sb.append(this.name);
        sb.append(", message=");
        return b.r(sb, this.message, "}");
    }
}
