package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.MenuItem;
import android.widget.Toast;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16975b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f16974a = i2;
        this.f16975b = obj;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem it) {
        PayloadType payloadTypeA;
        Object obj = this.f16975b;
        switch (this.f16974a) {
            case 0:
                int i2 = TransactionActivity.f16905l;
                Intrinsics.checkNotNullParameter(it, "it");
                TransactionViewModel transactionViewModelM = ((TransactionActivity) obj).m();
                Intrinsics.c(transactionViewModelM.f16967c.d());
                transactionViewModelM.f16966b.k(Boolean.valueOf(!((Boolean) r1).booleanValue()));
                break;
            default:
                Intrinsics.checkNotNullParameter(it, "it");
                TransactionPayloadFragment transactionPayloadFragment = (TransactionPayloadFragment) obj;
                HttpTransaction httpTransaction = (HttpTransaction) transactionPayloadFragment.B().f16971g.d();
                if (httpTransaction != null && (((payloadTypeA = transactionPayloadFragment.A()) == PayloadType.f16899a && httpTransaction.getRequestBody() == null) || (payloadTypeA == PayloadType.f16900b && httpTransaction.getResponseBody() == null))) {
                    Toast.makeText(transactionPayloadFragment.getActivity(), R.string.chucker_file_not_saved_body_is_empty, 0).show();
                    break;
                } else {
                    transactionPayloadFragment.Y.a(android.support.v4.media.b.i(System.currentTimeMillis(), "chucker-export-"));
                    break;
                }
                break;
        }
        return true;
    }
}
