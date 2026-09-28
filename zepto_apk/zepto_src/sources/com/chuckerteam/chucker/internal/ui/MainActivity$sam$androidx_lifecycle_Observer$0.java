package com.chuckerteam.chucker.internal.ui;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MainActivity$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f16886a;

    public MainActivity$sam$androidx_lifecycle_Observer$0(a function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f16886a = function;
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void a(Object obj) {
        this.f16886a.invoke(obj);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
            return this.f16886a.equals(((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f16886a;
    }

    public final int hashCode() {
        return this.f16886a.hashCode();
    }
}
