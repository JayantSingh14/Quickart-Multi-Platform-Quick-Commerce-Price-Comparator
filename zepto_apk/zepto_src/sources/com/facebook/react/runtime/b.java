package com.facebook.react.runtime;

import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19284a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f19285b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19286c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19287d;

    public /* synthetic */ b(ReactHostImpl reactHostImpl, String str, Object obj, int i2) {
        this.f19284a = i2;
        this.f19285b = reactHostImpl;
        this.f19286c = str;
        this.f19287d = obj;
    }

    @Override // com.facebook.react.runtime.internal.bolts.Continuation
    public final Object a(Task task) {
        Object obj = this.f19287d;
        String str = this.f19286c;
        ReactHostImpl reactHostImpl = this.f19285b;
        switch (this.f19284a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                reactHostImpl.getClass();
                ReactInstance reactInstance = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid() ? (ReactInstance) task.g() : reactHostImpl.f19250l;
                if (reactInstance == null) {
                    reactHostImpl.s(str, "Execute: reactInstance is null. Dropping work.", null);
                    return Boolean.FALSE;
                }
                ((ReactHostImpl.ReactInstanceCalback) obj).a(reactInstance);
                return Boolean.TRUE;
            case 1:
                AtomicInteger atomicInteger2 = ReactHostImpl.A;
                ReactInstance reactInstance2 = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid() ? (ReactInstance) task.g() : reactHostImpl.f19250l;
                if (reactInstance2 == null) {
                    reactHostImpl.s(str, "Execute: reactInstance is null. Dropping work.", null);
                } else {
                    ((g) obj).a(reactInstance2);
                }
                return null;
            default:
                AtomicInteger atomicInteger3 = ReactHostImpl.A;
                return reactHostImpl.n(str, (Exception) obj);
        }
    }
}
