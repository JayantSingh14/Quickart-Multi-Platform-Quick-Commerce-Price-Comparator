package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;
import java.util.Set;

/* loaded from: classes4.dex */
final class h extends StandardIntegrityManager.StandardIntegrityTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    public final String f41837a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f41838b;

    public /* synthetic */ h(String str, Set set) {
        this.f41837a = str;
        this.f41838b = set;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest
    public final String b() {
        return this.f41837a;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest
    public final Set c() {
        return this.f41838b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardIntegrityManager.StandardIntegrityTokenRequest)) {
            return false;
        }
        StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest = (StandardIntegrityManager.StandardIntegrityTokenRequest) obj;
        String str = this.f41837a;
        if (str == null) {
            if (standardIntegrityTokenRequest.b() != null) {
                return false;
            }
        } else if (!str.equals(standardIntegrityTokenRequest.b())) {
            return false;
        }
        return this.f41838b.equals(standardIntegrityTokenRequest.c());
    }

    public final int hashCode() {
        String str = this.f41837a;
        return (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f41838b.hashCode();
    }

    public final String toString() {
        return android.support.v4.media.a.n(new StringBuilder("StandardIntegrityTokenRequest{requestHash="), this.f41837a, ", verdictOptOut=", this.f41838b.toString(), "}");
    }
}
