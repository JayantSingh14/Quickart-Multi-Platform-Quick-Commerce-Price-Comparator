package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* loaded from: classes3.dex */
final class AutoValue_ClientInfo extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f20613a;

    /* renamed from: b, reason: collision with root package name */
    public final AndroidClientInfo f20614b;

    public static final class Builder extends ClientInfo.Builder {

        /* renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f20615a;

        /* renamed from: b, reason: collision with root package name */
        public AndroidClientInfo f20616b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public final ClientInfo a() {
            return new AutoValue_ClientInfo(this.f20615a, this.f20616b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public final ClientInfo.Builder b(AndroidClientInfo androidClientInfo) {
            this.f20616b = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public final ClientInfo.Builder c() {
            this.f20615a = ClientInfo.ClientType.f20666a;
            return this;
        }
    }

    public AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.f20613a = clientType;
        this.f20614b = androidClientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public final AndroidClientInfo b() {
        return this.f20614b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public final ClientInfo.ClientType c() {
        return this.f20613a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f20613a;
        if (clientType == null) {
            if (clientInfo.c() != null) {
                return false;
            }
        } else if (!clientType.equals(clientInfo.c())) {
            return false;
        }
        AndroidClientInfo androidClientInfo = this.f20614b;
        return androidClientInfo == null ? clientInfo.b() == null : androidClientInfo.equals(clientInfo.b());
    }

    public final int hashCode() {
        ClientInfo.ClientType clientType = this.f20613a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f20614b;
        return (androidClientInfo != null ? androidClientInfo.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f20613a + ", androidClientInfo=" + this.f20614b + "}";
    }
}
