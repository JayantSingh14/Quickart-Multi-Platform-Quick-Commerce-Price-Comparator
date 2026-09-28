package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzahq implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final long f23136a;

    public zzahq(long j2) {
        this.f23136a = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzahq.class == obj.getClass() && this.f23136a == ((zzahq) obj).f23136a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f23136a) + 527;
    }

    public final String toString() {
        long j2 = this.f23136a;
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 38);
        sb.append("ThumbnailMetadata: presentationTimeUs=");
        sb.append(j2);
        return sb.toString();
    }
}
