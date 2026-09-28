package com.brentvatne.exoplayer;

import java.net.CookieManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactExoplayerView f15607b;

    public /* synthetic */ d(ReactExoplayerView reactExoplayerView, int i2) {
        this.f15606a = i2;
        this.f15607b = reactExoplayerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReactExoplayerView reactExoplayerView = this.f15607b;
        switch (this.f15606a) {
            case 0:
                if (reactExoplayerView.z) {
                    reactExoplayerView.I();
                    break;
                }
                break;
            case 1:
                reactExoplayerView.f15560a.f15451j.invoke();
                break;
            case 2:
                reactExoplayerView.f15560a.f15453l.invoke();
                break;
            default:
                CookieManager cookieManager = ReactExoplayerView.j1;
                reactExoplayerView.X();
                break;
        }
    }
}
