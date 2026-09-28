package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* loaded from: classes.dex */
final class AutoValue_InstallationResponse extends InstallationResponse {

    /* renamed from: a, reason: collision with root package name */
    public final String f44623a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44624b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44625c;

    /* renamed from: d, reason: collision with root package name */
    public final TokenResult f44626d;

    /* renamed from: e, reason: collision with root package name */
    public final InstallationResponse.ResponseCode f44627e;

    public static final class Builder extends InstallationResponse.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44628a;

        /* renamed from: b, reason: collision with root package name */
        public String f44629b;

        /* renamed from: c, reason: collision with root package name */
        public String f44630c;

        /* renamed from: d, reason: collision with root package name */
        public TokenResult f44631d;
    }

    public AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f44623a = str;
        this.f44624b = str2;
        this.f44625c = str3;
        this.f44626d = tokenResult;
        this.f44627e = responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final TokenResult a() {
        return this.f44626d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String b() {
        return this.f44624b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String c() {
        return this.f44625c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.ResponseCode d() {
        return this.f44627e;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String e() {
        return this.f44623a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f44623a;
        if (str == null) {
            if (installationResponse.e() != null) {
                return false;
            }
        } else if (!str.equals(installationResponse.e())) {
            return false;
        }
        String str2 = this.f44624b;
        if (str2 == null) {
            if (installationResponse.b() != null) {
                return false;
            }
        } else if (!str2.equals(installationResponse.b())) {
            return false;
        }
        String str3 = this.f44625c;
        if (str3 == null) {
            if (installationResponse.c() != null) {
                return false;
            }
        } else if (!str3.equals(installationResponse.c())) {
            return false;
        }
        TokenResult tokenResult = this.f44626d;
        if (tokenResult == null) {
            if (installationResponse.a() != null) {
                return false;
            }
        } else if (!tokenResult.equals(installationResponse.a())) {
            return false;
        }
        InstallationResponse.ResponseCode responseCode = this.f44627e;
        return responseCode == null ? installationResponse.d() == null : responseCode.equals(installationResponse.d());
    }

    public final int hashCode() {
        String str = this.f44623a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f44624b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f44625c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f44626d;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f44627e;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ iHashCode4;
    }

    public final String toString() {
        return "InstallationResponse{uri=" + this.f44623a + ", fid=" + this.f44624b + ", refreshToken=" + this.f44625c + ", authToken=" + this.f44626d + ", responseCode=" + this.f44627e + "}";
    }
}
