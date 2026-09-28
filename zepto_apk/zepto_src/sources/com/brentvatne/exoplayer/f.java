package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.source.ads.AdsLoader;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements AdsLoader.Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15613a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactExoplayerView f15614b;

    public /* synthetic */ f(ReactExoplayerView reactExoplayerView, int i2) {
        this.f15613a = i2;
        this.f15614b = reactExoplayerView;
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader.Provider
    public final ImaAdsLoader a() {
        switch (this.f15613a) {
        }
        return this.f15614b.f15568i;
    }
}
