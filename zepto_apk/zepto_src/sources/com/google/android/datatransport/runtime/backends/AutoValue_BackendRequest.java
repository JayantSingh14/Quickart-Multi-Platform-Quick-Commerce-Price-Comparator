package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class AutoValue_BackendRequest extends BackendRequest {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20769a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f20770b;

    public static final class Builder extends BackendRequest.Builder {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f20771a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f20772b;

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public final BackendRequest a() {
            String str = this.f20771a == null ? " events" : "";
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f20771a, this.f20772b);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public final BackendRequest.Builder b(ArrayList arrayList) {
            this.f20771a = arrayList;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public final BackendRequest.Builder c(byte[] bArr) {
            this.f20772b = bArr;
            return this;
        }
    }

    public AutoValue_BackendRequest(ArrayList arrayList, byte[] bArr) {
        this.f20769a = arrayList;
        this.f20770b = bArr;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public final Iterable b() {
        return this.f20769a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public final byte[] c() {
        return this.f20770b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f20769a.equals(backendRequest.b())) {
            return Arrays.equals(this.f20770b, backendRequest instanceof AutoValue_BackendRequest ? ((AutoValue_BackendRequest) backendRequest).f20770b : backendRequest.c());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f20769a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20770b);
    }

    public final String toString() {
        return "BackendRequest{events=" + this.f20769a + ", extras=" + Arrays.toString(this.f20770b) + "}";
    }
}
