package com.google.android.gms.ads.admanager;

import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.AdRequest;

/* loaded from: classes4.dex */
public final class AdManagerAdRequest extends AdRequest {

    public static final class Builder extends AbstractAdRequestBuilder<Builder> {
        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        public final /* bridge */ /* synthetic */ AbstractAdRequestBuilder d() {
            return this;
        }

        public final AdManagerAdRequest h() {
            return new AdManagerAdRequest(this);
        }
    }
}
