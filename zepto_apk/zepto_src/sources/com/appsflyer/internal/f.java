package com.appsflyer.internal;

import android.content.Context;
import android.hardware.SensorEvent;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15319b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15320c;

    public /* synthetic */ f(int i2, Object obj, Object obj2) {
        this.f15318a = i2;
        this.f15319b = obj;
        this.f15320c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15318a) {
            case 0:
                AFb1lSDK.getCurrencyIso4217Code((AFb1lSDK) this.f15319b, (AFh1qSDK) this.f15320c);
                break;
            case 1:
                ((AFj1pSDK) this.f15319b).G_((SensorEvent) this.f15320c);
                break;
            case 2:
                AFj1uSDK.getMonetizationNetwork((AFj1uSDK) this.f15319b, (Context) this.f15320c);
                break;
            case 3:
                ((AFj1vSDK) this.f15319b).getCurrencyIso4217Code((Context) this.f15320c);
                break;
            default:
                AFj1zSDK.getMonetizationNetwork((AFj1zSDK) this.f15319b, (Context) this.f15320c);
                break;
        }
    }
}
