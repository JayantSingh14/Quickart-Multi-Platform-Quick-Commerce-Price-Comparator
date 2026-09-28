package com.zeptonow.horizon;

import com.zeptonow.horizon.di.DependencyContainer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.HorizonSDK", f = "HorizonSDK.kt", l = {101}, m = "flushQueuedEvents")
/* loaded from: classes.dex */
final class HorizonSDK$flushQueuedEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f47834a;

    /* renamed from: b, reason: collision with root package name */
    public int f47835b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47834a = obj;
        this.f47835b |= Integer.MIN_VALUE;
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        return HorizonSDK.a(this);
    }
}
