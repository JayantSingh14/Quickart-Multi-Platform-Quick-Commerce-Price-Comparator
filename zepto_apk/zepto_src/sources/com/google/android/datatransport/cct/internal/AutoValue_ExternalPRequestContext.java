package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExternalPRequestContext;

/* loaded from: classes3.dex */
final class AutoValue_ExternalPRequestContext extends ExternalPRequestContext {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f20625a;

    public static final class Builder extends ExternalPRequestContext.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Integer f20626a;

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public final ExternalPRequestContext a() {
            return new AutoValue_ExternalPRequestContext(this.f20626a);
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public final ExternalPRequestContext.Builder b(Integer num) {
            this.f20626a = num;
            return this;
        }
    }

    public AutoValue_ExternalPRequestContext(Integer num) {
        this.f20625a = num;
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext
    public final Integer b() {
        return this.f20625a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPRequestContext)) {
            return false;
        }
        Integer num = this.f20625a;
        Integer numB = ((ExternalPRequestContext) obj).b();
        return num == null ? numB == null : num.equals(numB);
    }

    public final int hashCode() {
        Integer num = this.f20625a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f20625a + "}";
    }
}
