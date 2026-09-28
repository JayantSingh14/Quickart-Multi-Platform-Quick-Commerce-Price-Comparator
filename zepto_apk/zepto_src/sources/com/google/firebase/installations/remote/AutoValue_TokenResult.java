package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes.dex */
final class AutoValue_TokenResult extends TokenResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f44632a;

    /* renamed from: b, reason: collision with root package name */
    public final long f44633b;

    /* renamed from: c, reason: collision with root package name */
    public final TokenResult.ResponseCode f44634c;

    public static final class Builder extends TokenResult.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44635a;

        /* renamed from: b, reason: collision with root package name */
        public Long f44636b;

        /* renamed from: c, reason: collision with root package name */
        public TokenResult.ResponseCode f44637c;

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult a() {
            String str = this.f44636b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.f44635a, this.f44636b.longValue(), this.f44637c);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_TokenResult(String str, long j2, TokenResult.ResponseCode responseCode) {
        this.f44632a = str;
        this.f44633b = j2;
        this.f44634c = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.ResponseCode b() {
        return this.f44634c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final String c() {
        return this.f44632a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final long d() {
        return this.f44633b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f44632a;
        if (str == null) {
            if (tokenResult.c() != null) {
                return false;
            }
        } else if (!str.equals(tokenResult.c())) {
            return false;
        }
        if (this.f44633b != tokenResult.d()) {
            return false;
        }
        TokenResult.ResponseCode responseCode = this.f44634c;
        return responseCode == null ? tokenResult.b() == null : responseCode.equals(tokenResult.b());
    }

    public final int hashCode() {
        String str = this.f44632a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f44633b;
        int i2 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f44634c;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ i2;
    }

    public final String toString() {
        return "TokenResult{token=" + this.f44632a + ", tokenExpirationTimestamp=" + this.f44633b + ", responseCode=" + this.f44634c + "}";
    }
}
