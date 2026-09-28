package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

@RestrictTo
/* loaded from: classes.dex */
public class OperationImpl implements Operation {

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData f12613c = new MutableLiveData();

    /* renamed from: d, reason: collision with root package name */
    public final SettableFuture f12614d = new SettableFuture();

    public OperationImpl() {
        b(Operation.f12545b);
    }

    @Override // androidx.work.Operation
    public final SettableFuture a() {
        return this.f12614d;
    }

    public final void b(Operation.State state) {
        this.f12613c.i(state);
        boolean z = state instanceof Operation.State.SUCCESS;
        SettableFuture settableFuture = this.f12614d;
        if (z) {
            settableFuture.i((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            settableFuture.j(((Operation.State.FAILURE) state).f12546a);
        }
    }
}
