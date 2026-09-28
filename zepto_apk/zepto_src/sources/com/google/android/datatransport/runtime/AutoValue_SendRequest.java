package com.google.android.datatransport.runtime;

import android.support.v4.media.b;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes3.dex */
final class AutoValue_SendRequest extends SendRequest {

    /* renamed from: a, reason: collision with root package name */
    public final TransportContext f20717a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20718b;

    /* renamed from: c, reason: collision with root package name */
    public final Event f20719c;

    /* renamed from: d, reason: collision with root package name */
    public final Transformer f20720d;

    /* renamed from: e, reason: collision with root package name */
    public final Encoding f20721e;

    public static final class Builder extends SendRequest.Builder {

        /* renamed from: a, reason: collision with root package name */
        public TransportContext f20722a;

        /* renamed from: b, reason: collision with root package name */
        public String f20723b;

        /* renamed from: c, reason: collision with root package name */
        public Event f20724c;

        /* renamed from: d, reason: collision with root package name */
        public Transformer f20725d;

        /* renamed from: e, reason: collision with root package name */
        public Encoding f20726e;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final AutoValue_SendRequest a() {
            String strK = this.f20722a == null ? " transportContext" : "";
            if (this.f20723b == null) {
                strK = strK.concat(" transportName");
            }
            if (this.f20724c == null) {
                strK = b.k(strK, " event");
            }
            if (this.f20725d == null) {
                strK = b.k(strK, " transformer");
            }
            if (this.f20726e == null) {
                strK = b.k(strK, " encoding");
            }
            if (strK.isEmpty()) {
                return new AutoValue_SendRequest(this.f20722a, this.f20723b, this.f20724c, this.f20725d, this.f20726e);
            }
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder b(Encoding encoding) {
            this.f20726e = encoding;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder c(Event event) {
            this.f20724c = event;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder d(Transformer transformer) {
            if (transformer == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f20725d = transformer;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder e(TransportContext transportContext) {
            if (transportContext == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f20722a = transportContext;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder f(String str) {
            this.f20723b = str;
            return this;
        }
    }

    public AutoValue_SendRequest(TransportContext transportContext, String str, Event event, Transformer transformer, Encoding encoding) {
        this.f20717a = transportContext;
        this.f20718b = str;
        this.f20719c = event;
        this.f20720d = transformer;
        this.f20721e = encoding;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final Encoding b() {
        return this.f20721e;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final Event c() {
        return this.f20719c;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final Transformer e() {
        return this.f20720d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        return this.f20717a.equals(sendRequest.f()) && this.f20718b.equals(sendRequest.g()) && this.f20719c.equals(sendRequest.c()) && this.f20720d.equals(sendRequest.e()) && this.f20721e.equals(sendRequest.b());
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final TransportContext f() {
        return this.f20717a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final String g() {
        return this.f20718b;
    }

    public final int hashCode() {
        return ((((((((this.f20717a.hashCode() ^ 1000003) * 1000003) ^ this.f20718b.hashCode()) * 1000003) ^ this.f20719c.hashCode()) * 1000003) ^ this.f20720d.hashCode()) * 1000003) ^ this.f20721e.hashCode();
    }

    public final String toString() {
        return "SendRequest{transportContext=" + this.f20717a + ", transportName=" + this.f20718b + ", event=" + this.f20719c + ", transformer=" + this.f20720d + ", encoding=" + this.f20721e + "}";
    }
}
