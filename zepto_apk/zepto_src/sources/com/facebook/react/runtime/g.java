package com.facebook.react.runtime;

import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.runtime.ReactHostImpl;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements ReactHostImpl.ReactInstanceCalback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19302b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19303c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19304d;

    public /* synthetic */ g(ReactHostImpl reactHostImpl, String str, ReactSurfaceImpl reactSurfaceImpl, int i2) {
        this.f19301a = i2;
        this.f19302b = reactHostImpl;
        this.f19303c = str;
        this.f19304d = reactSurfaceImpl;
    }

    @Override // com.facebook.react.runtime.ReactHostImpl.ReactInstanceCalback
    public final void a(ReactInstance reactInstance) {
        String str = this.f19303c;
        Object obj = this.f19304d;
        Object obj2 = this.f19302b;
        switch (this.f19301a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                ((ReactHostImpl) obj2).r(str, "Execute");
                reactInstance.f((ReactSurfaceImpl) obj);
                break;
            case 1:
                AtomicInteger atomicInteger2 = ReactHostImpl.A;
                ((ReactHostImpl) obj2).r(str, "Execute");
                reactInstance.g((ReactSurfaceImpl) obj);
                break;
            default:
                AtomicInteger atomicInteger3 = ReactHostImpl.A;
                reactInstance.callFunctionOnModule(str, (String) obj2, (WritableNativeArray) obj);
                break;
        }
    }

    public /* synthetic */ g(String str, String str2, WritableNativeArray writableNativeArray) {
        this.f19301a = 2;
        this.f19303c = str;
        this.f19302b = str2;
        this.f19304d = writableNativeArray;
    }
}
