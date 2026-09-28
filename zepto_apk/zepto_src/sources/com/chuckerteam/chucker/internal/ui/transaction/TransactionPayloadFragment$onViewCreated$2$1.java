package com.chuckerteam.chucker.internal.ui.transaction;

import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerFragmentTransactionPayloadBinding;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onViewCreated$2$1", f = "TransactionPayloadFragment.kt", l = {WKSRecord.Service.INGRES_NET}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransactionPayloadFragment$onViewCreated$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16944a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TransactionPayloadFragment f16945b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16946c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16947d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionPayloadFragment$onViewCreated$2$1(TransactionPayloadFragment transactionPayloadFragment, HttpTransaction httpTransaction, boolean z, Continuation continuation) {
        super(2, continuation);
        this.f16945b = transactionPayloadFragment;
        this.f16946c = httpTransaction;
        this.f16947d = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransactionPayloadFragment$onViewCreated$2$1(this.f16945b, this.f16946c, this.f16947d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionPayloadFragment$onViewCreated$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16944a;
        TransactionPayloadFragment transactionPayloadFragment = this.f16945b;
        if (i2 == 0) {
            ResultKt.b(obj);
            ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding = transactionPayloadFragment.Z;
            if (chuckerFragmentTransactionPayloadBinding == null) {
                Intrinsics.h("payloadBinding");
                throw null;
            }
            chuckerFragmentTransactionPayloadBinding.f16669c.setVisibility(0);
            PayloadType payloadTypeA = transactionPayloadFragment.A();
            this.f16944a = 1;
            obj = BuildersKt.e(Dispatchers.f54091a, new TransactionPayloadFragment$processPayload$2(payloadTypeA, this.f16946c, this.f16947d, transactionPayloadFragment, null), this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List bodyItems = (List) obj;
        if (bodyItems.isEmpty()) {
            ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding2 = transactionPayloadFragment.Z;
            if (chuckerFragmentTransactionPayloadBinding2 == null) {
                Intrinsics.h("payloadBinding");
                throw null;
            }
            chuckerFragmentTransactionPayloadBinding2.f16667a.setText(transactionPayloadFragment.A() == PayloadType.f16900b ? transactionPayloadFragment.getString(R.string.chucker_response_is_empty) : transactionPayloadFragment.getString(R.string.chucker_request_is_empty));
            chuckerFragmentTransactionPayloadBinding2.f16668b.setVisibility(0);
            chuckerFragmentTransactionPayloadBinding2.f16670d.setVisibility(8);
        } else {
            TransactionBodyAdapter transactionBodyAdapter = transactionPayloadFragment.A0;
            transactionBodyAdapter.getClass();
            Intrinsics.checkNotNullParameter(bodyItems, "bodyItems");
            ArrayList arrayList = transactionBodyAdapter.f16933e;
            int size = arrayList.size();
            arrayList.clear();
            arrayList.addAll(bodyItems);
            transactionBodyAdapter.l(0, size);
            transactionBodyAdapter.k(0, arrayList.size());
            ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding3 = transactionPayloadFragment.Z;
            if (chuckerFragmentTransactionPayloadBinding3 == null) {
                Intrinsics.h("payloadBinding");
                throw null;
            }
            chuckerFragmentTransactionPayloadBinding3.f16668b.setVisibility(8);
            chuckerFragmentTransactionPayloadBinding3.f16670d.setVisibility(0);
        }
        transactionPayloadFragment.requireActivity().invalidateOptionsMenu();
        ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding4 = transactionPayloadFragment.Z;
        if (chuckerFragmentTransactionPayloadBinding4 != null) {
            chuckerFragmentTransactionPayloadBinding4.f16669c.setVisibility(8);
            return Unit.f53572a;
        }
        Intrinsics.h("payloadBinding");
        throw null;
    }
}
