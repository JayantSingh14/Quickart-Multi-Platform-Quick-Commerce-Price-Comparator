package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46689a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f46690b;

    public /* synthetic */ d(int i2, Promise promise) {
        this.f46689a = i2;
        this.f46690b = promise;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f46689a) {
            case 0:
                return MapModule.lambda$getMapBoundaries$5(this.f46690b, (MapView) obj);
            default:
                return MapModule.lambda$getCamera$1(this.f46690b, (MapView) obj);
        }
    }
}
