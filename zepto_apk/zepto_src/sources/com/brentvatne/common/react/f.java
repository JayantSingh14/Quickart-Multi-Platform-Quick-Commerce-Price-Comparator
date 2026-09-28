package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Function3 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15471a;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        String errorString = (String) obj;
        Exception exception = (Exception) obj2;
        String errorCode = (String) obj3;
        Intrinsics.checkNotNullParameter(errorString, "errorString");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.f15471a.a(EventTypes.f15432e, new l(exception, errorString, errorCode, 0));
        return Unit.f53572a;
    }
}
