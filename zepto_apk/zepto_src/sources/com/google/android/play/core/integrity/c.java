package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* loaded from: classes4.dex */
final class c extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* renamed from: a, reason: collision with root package name */
    public long f41832a;

    /* renamed from: b, reason: collision with root package name */
    public byte f41833b;

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest a() {
        if (this.f41833b == 3) {
            return new e(this.f41832a);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f41833b & 1) == 0) {
            sb.append(" cloudProjectNumber");
        }
        if ((this.f41833b & 2) == 0) {
            sb.append(" webViewRequestMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder b(long j2) {
        this.f41832a = j2;
        this.f41833b = (byte) (this.f41833b | 1);
        return this;
    }
}
