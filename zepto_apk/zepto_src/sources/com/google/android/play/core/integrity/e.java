package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* loaded from: classes4.dex */
final class e extends StandardIntegrityManager.PrepareIntegrityTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    public final long f41834a;

    public /* synthetic */ e(long j2) {
        this.f41834a = j2;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest
    public final long a() {
        return this.f41834a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StandardIntegrityManager.PrepareIntegrityTokenRequest) {
            return this.f41834a == ((StandardIntegrityManager.PrepareIntegrityTokenRequest) obj).a();
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f41834a;
        return (((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003;
    }

    public final String toString() {
        return android.support.v4.media.b.p(new StringBuilder("PrepareIntegrityTokenRequest{cloudProjectNumber="), this.f41834a, ", webViewRequestMode=0}");
    }
}
