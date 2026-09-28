package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.a;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class zzce {
    public int errorCode;
    public String errorMessage;
    public String innerError;
    public String type;

    public Map<String, String> constructMap() {
        HashMap map = new HashMap();
        map.put("type", this.type);
        map.put(CLConstants.FIELD_ERROR_CODE, String.valueOf(this.errorCode));
        map.put("errorMessage", this.errorMessage);
        String str = this.innerError;
        if (str != null) {
            map.put("innerError", str);
        }
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    public String toString() {
        String str = this.type;
        int i2 = this.errorCode;
        String str2 = this.errorMessage;
        String str3 = this.innerError;
        StringBuilder sb = new StringBuilder("Log[type=");
        sb.append(str);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", errorMessage=");
        return a.n(sb, str2, ", innerError=", str3, "]");
    }
}
