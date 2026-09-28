package com.zeptoconsumerapp.apiprefetch.base;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class HeaderField {

    /* renamed from: a, reason: collision with root package name */
    public final String f47583a;

    /* renamed from: b, reason: collision with root package name */
    public final String f47584b;

    public HeaderField(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f47583a = key;
        this.f47584b = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderField)) {
            return false;
        }
        HeaderField headerField = (HeaderField) obj;
        return Intrinsics.b(this.f47583a, headerField.f47583a) && Intrinsics.b(this.f47584b, headerField.f47584b);
    }

    public final int hashCode() {
        return this.f47584b.hashCode() + (this.f47583a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderField(key=");
        sb.append(this.f47583a);
        sb.append(", value=");
        return b.r(sb, this.f47584b, ")");
    }
}
