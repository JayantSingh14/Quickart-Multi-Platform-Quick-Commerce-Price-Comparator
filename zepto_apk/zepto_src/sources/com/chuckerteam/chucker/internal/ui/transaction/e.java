package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.View;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16983a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16984b;

    public /* synthetic */ e(Object obj, int i2) {
        this.f16983a = i2;
        this.f16984b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f16983a) {
            case 0:
                ((TransactionPayloadFragment) this.f16984b).D(true);
                break;
            case 1:
                ((TransactionPayloadFragment) this.f16984b).D(false);
                break;
            default:
                ((TransactionPayloadViewHolder.CopyViewHolder) this.f16984b).v.invoke();
                break;
        }
    }
}
