package com.appsflyer.internal;

import com.appsflyer.internal.AFa1tSDK;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15314a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15315b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f15314a = i2;
        this.f15315b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f15314a) {
            case 0:
                return ((AFa1tSDK.AFa1vSDK) this.f15315b).getRevenue();
            default:
                return ((AFc1eSDK) this.f15315b).m_();
        }
    }
}
