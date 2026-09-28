package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzek;

/* loaded from: classes4.dex */
public class AdRequest {

    /* renamed from: a, reason: collision with root package name */
    public final zzek f20997a;

    public static class Builder extends AbstractAdRequestBuilder<Builder> {
        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        public final AbstractAdRequestBuilder d() {
            return this;
        }
    }

    public AdRequest(AbstractAdRequestBuilder abstractAdRequestBuilder) {
        this.f20997a = new zzek(abstractAdRequestBuilder.f20979a);
    }
}
