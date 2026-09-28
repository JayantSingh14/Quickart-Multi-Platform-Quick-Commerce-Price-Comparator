package com.brentvatne.react;

import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f15638b;

    public /* synthetic */ b(int i2, Promise promise) {
        this.f15637a = i2;
        this.f15638b = promise;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f15637a) {
            case 0:
                return VideoManagerModule.getCurrentPosition$lambda$8(this.f15638b, (ReactExoplayerView) obj);
            default:
                this.f15638b.resolve(Boolean.TRUE);
                return Unit.f53572a;
        }
    }
}
