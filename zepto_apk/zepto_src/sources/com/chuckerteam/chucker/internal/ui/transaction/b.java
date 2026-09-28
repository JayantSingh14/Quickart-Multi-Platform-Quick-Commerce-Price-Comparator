package com.chuckerteam.chucker.internal.ui.transaction;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16976a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16977b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f16976a = i2;
        this.f16977b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj = this.f16977b;
        switch (this.f16976a) {
            case 0:
                int i2 = TransactionActivity.f16905l;
                return new TransactionViewModelFactory(((TransactionActivity) obj).getIntent().getLongExtra("transaction_id", 0L));
            default:
                Bundle arguments = ((TransactionPayloadFragment) obj).getArguments();
                Serializable serializable = arguments != null ? arguments.getSerializable("type") : null;
                Intrinsics.d(serializable, "null cannot be cast to non-null type com.chuckerteam.chucker.internal.ui.transaction.PayloadType");
                return (PayloadType) serializable;
        }
    }
}
