package com.facebook.react.modules.core;

import com.facebook.react.modules.core.JavaTimerManager;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(Long.signum(((JavaTimerManager.Timer) obj).f19058b - ((JavaTimerManager.Timer) obj2).f19058b));
    }
}
