package com.chuckerteam.chucker.internal.ui.transaction;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionPayloadFragment$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f16955a;

    public TransactionPayloadFragment$sam$androidx_lifecycle_Observer$0(f function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f16955a = function;
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void a(Object obj) {
        this.f16955a.invoke(obj);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
            return this.f16955a.equals(((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f16955a;
    }

    public final int hashCode() {
        return this.f16955a.hashCode();
    }
}
