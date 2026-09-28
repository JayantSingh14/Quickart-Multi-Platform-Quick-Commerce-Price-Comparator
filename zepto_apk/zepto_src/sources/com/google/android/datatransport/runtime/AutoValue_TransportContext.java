package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_TransportContext extends TransportContext {

    /* renamed from: a, reason: collision with root package name */
    public final String f20727a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f20728b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f20729c;

    public static final class Builder extends TransportContext.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f20730a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f20731b;

        /* renamed from: c, reason: collision with root package name */
        public Priority f20732c;

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public final TransportContext a() {
            String strConcat = this.f20730a == null ? " backendName" : "";
            if (this.f20732c == null) {
                strConcat = strConcat.concat(" priority");
            }
            if (strConcat.isEmpty()) {
                return new AutoValue_TransportContext(this.f20730a, this.f20731b, this.f20732c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public final TransportContext.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f20730a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public final TransportContext.Builder c(byte[] bArr) {
            this.f20731b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public final TransportContext.Builder d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f20732c = priority;
            return this;
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.f20727a = str;
        this.f20728b = bArr;
        this.f20729c = priority;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final String b() {
        return this.f20727a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final byte[] c() {
        return this.f20728b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public final Priority d() {
        return this.f20729c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f20727a.equals(transportContext.b())) {
            return Arrays.equals(this.f20728b, transportContext instanceof AutoValue_TransportContext ? ((AutoValue_TransportContext) transportContext).f20728b : transportContext.c()) && this.f20729c.equals(transportContext.d());
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f20727a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20728b)) * 1000003) ^ this.f20729c.hashCode();
    }
}
