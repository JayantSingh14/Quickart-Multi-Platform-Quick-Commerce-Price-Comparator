package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ComplianceData;

/* loaded from: classes3.dex */
final class AutoValue_ComplianceData extends ComplianceData {

    /* renamed from: a, reason: collision with root package name */
    public final ExternalPrivacyContext f20617a;

    /* renamed from: b, reason: collision with root package name */
    public final ComplianceData.ProductIdOrigin f20618b;

    public static final class Builder extends ComplianceData.Builder {

        /* renamed from: a, reason: collision with root package name */
        public ExternalPrivacyContext f20619a;

        /* renamed from: b, reason: collision with root package name */
        public ComplianceData.ProductIdOrigin f20620b;

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public final ComplianceData a() {
            return new AutoValue_ComplianceData(this.f20619a, this.f20620b);
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public final ComplianceData.Builder b(ExternalPrivacyContext externalPrivacyContext) {
            this.f20619a = externalPrivacyContext;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public final ComplianceData.Builder c() {
            this.f20620b = ComplianceData.ProductIdOrigin.f20668a;
            return this;
        }
    }

    public AutoValue_ComplianceData(ExternalPrivacyContext externalPrivacyContext, ComplianceData.ProductIdOrigin productIdOrigin) {
        this.f20617a = externalPrivacyContext;
        this.f20618b = productIdOrigin;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public final ExternalPrivacyContext b() {
        return this.f20617a;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public final ComplianceData.ProductIdOrigin c() {
        return this.f20618b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComplianceData)) {
            return false;
        }
        ComplianceData complianceData = (ComplianceData) obj;
        ExternalPrivacyContext externalPrivacyContext = this.f20617a;
        if (externalPrivacyContext == null) {
            if (complianceData.b() != null) {
                return false;
            }
        } else if (!externalPrivacyContext.equals(complianceData.b())) {
            return false;
        }
        ComplianceData.ProductIdOrigin productIdOrigin = this.f20618b;
        return productIdOrigin == null ? complianceData.c() == null : productIdOrigin.equals(complianceData.c());
    }

    public final int hashCode() {
        ExternalPrivacyContext externalPrivacyContext = this.f20617a;
        int iHashCode = ((externalPrivacyContext == null ? 0 : externalPrivacyContext.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.f20618b;
        return (productIdOrigin != null ? productIdOrigin.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f20617a + ", productIdOrigin=" + this.f20618b + "}";
    }
}
