package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;

/* loaded from: classes3.dex */
final class AutoValue_ExternalPrivacyContext extends ExternalPrivacyContext {

    /* renamed from: a, reason: collision with root package name */
    public final ExternalPRequestContext f20627a;

    public static final class Builder extends ExternalPrivacyContext.Builder {

        /* renamed from: a, reason: collision with root package name */
        public ExternalPRequestContext f20628a;

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public final ExternalPrivacyContext a() {
            return new AutoValue_ExternalPrivacyContext(this.f20628a);
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public final ExternalPrivacyContext.Builder b(ExternalPRequestContext externalPRequestContext) {
            this.f20628a = externalPRequestContext;
            return this;
        }
    }

    public AutoValue_ExternalPrivacyContext(ExternalPRequestContext externalPRequestContext) {
        this.f20627a = externalPRequestContext;
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext
    public final ExternalPRequestContext b() {
        return this.f20627a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPrivacyContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = this.f20627a;
        ExternalPRequestContext externalPRequestContextB = ((ExternalPrivacyContext) obj).b();
        return externalPRequestContext == null ? externalPRequestContextB == null : externalPRequestContext.equals(externalPRequestContextB);
    }

    public final int hashCode() {
        ExternalPRequestContext externalPRequestContext = this.f20627a;
        return (externalPRequestContext == null ? 0 : externalPRequestContext.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f20627a + "}";
    }
}
