package com.zeptoconsumerapp.AppServiceStarter.model;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class POIARequestBody {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof POIARequestBody)) {
            return false;
        }
        ((POIARequestBody) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (Boolean.hashCode(false) * 31);
    }

    public final String toString() {
        return "POIARequestBody(enable=false, intent=false)";
    }
}
