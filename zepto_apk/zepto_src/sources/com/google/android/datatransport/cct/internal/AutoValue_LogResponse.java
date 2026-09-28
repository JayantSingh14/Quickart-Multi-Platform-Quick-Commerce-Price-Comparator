package com.google.android.datatransport.cct.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: a, reason: collision with root package name */
    public final long f20661a;

    public AutoValue_LogResponse(long j2) {
        this.f20661a = j2;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public final long b() {
        return this.f20661a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.f20661a == ((LogResponse) obj).b();
    }

    public final int hashCode() {
        long j2 = this.f20661a;
        return ((int) ((j2 >>> 32) ^ j2)) ^ 1000003;
    }

    public final String toString() {
        return b.p(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.f20661a, "}");
    }
}
