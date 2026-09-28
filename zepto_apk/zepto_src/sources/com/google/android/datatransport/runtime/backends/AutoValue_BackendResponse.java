package com.google.android.datatransport.runtime.backends;

import android.support.v4.media.b;
import com.google.android.datatransport.runtime.backends.BackendResponse;

/* loaded from: classes3.dex */
final class AutoValue_BackendResponse extends BackendResponse {

    /* renamed from: a, reason: collision with root package name */
    public final BackendResponse.Status f20773a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20774b;

    public AutoValue_BackendResponse(BackendResponse.Status status, long j2) {
        this.f20773a = status;
        this.f20774b = j2;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public final long b() {
        return this.f20774b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public final BackendResponse.Status c() {
        return this.f20773a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f20773a.equals(backendResponse.c()) && this.f20774b == backendResponse.b();
    }

    public final int hashCode() {
        int iHashCode = (this.f20773a.hashCode() ^ 1000003) * 1000003;
        long j2 = this.f20774b;
        return iHashCode ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        sb.append(this.f20773a);
        sb.append(", nextRequestWaitMillis=");
        return b.p(sb, this.f20774b, "}");
    }
}
