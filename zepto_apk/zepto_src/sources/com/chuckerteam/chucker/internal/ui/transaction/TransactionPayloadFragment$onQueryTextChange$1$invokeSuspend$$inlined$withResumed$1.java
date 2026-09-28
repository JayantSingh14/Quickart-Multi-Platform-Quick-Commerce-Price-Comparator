package com.chuckerteam.chucker.internal.ui.transaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1 extends Lambda implements Function0<Unit> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TransactionPayloadFragment f16939c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1(TransactionPayloadFragment transactionPayloadFragment) {
        super(0);
        this.f16939c = transactionPayloadFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TransactionPayloadFragment transactionPayloadFragment = this.f16939c;
        if (transactionPayloadFragment.E0.isEmpty()) {
            transactionPayloadFragment.F0 = -1;
        } else {
            transactionPayloadFragment.E(0);
        }
        return Unit.f53572a;
    }
}
