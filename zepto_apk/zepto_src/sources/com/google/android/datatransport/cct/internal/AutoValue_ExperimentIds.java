package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExperimentIds;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class AutoValue_ExperimentIds extends ExperimentIds {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f20621a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f20622b;

    public static final class Builder extends ExperimentIds.Builder {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f20623a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f20624b;

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public final ExperimentIds a() {
            return new AutoValue_ExperimentIds(this.f20623a, this.f20624b);
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public final ExperimentIds.Builder b(byte[] bArr) {
            this.f20623a = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public final ExperimentIds.Builder c(byte[] bArr) {
            this.f20624b = bArr;
            return this;
        }
    }

    public AutoValue_ExperimentIds(byte[] bArr, byte[] bArr2) {
        this.f20621a = bArr;
        this.f20622b = bArr2;
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public final byte[] b() {
        return this.f20621a;
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public final byte[] c() {
        return this.f20622b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExperimentIds)) {
            return false;
        }
        ExperimentIds experimentIds = (ExperimentIds) obj;
        boolean z = experimentIds instanceof AutoValue_ExperimentIds;
        if (Arrays.equals(this.f20621a, z ? ((AutoValue_ExperimentIds) experimentIds).f20621a : experimentIds.b())) {
            return Arrays.equals(this.f20622b, z ? ((AutoValue_ExperimentIds) experimentIds).f20622b : experimentIds.c());
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f20621a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20622b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f20621a) + ", encryptedBlob=" + Arrays.toString(this.f20622b) + "}";
    }
}
