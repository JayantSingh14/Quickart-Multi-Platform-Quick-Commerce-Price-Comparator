package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.View;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionAdapter;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16978a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16979b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16980c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f16978a = i2;
        this.f16979b = obj;
        this.f16980c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.f16980c;
        Object obj2 = this.f16979b;
        switch (this.f16978a) {
            case 0:
                Long l2 = ((TransactionAdapter.TransactionViewHolder) obj2).v;
                if (l2 != null) {
                    ((TransactionAdapter) obj).f16925f.invoke(Long.valueOf(l2.longValue()));
                    break;
                }
                break;
            default:
                int[] iArr = Snackbar.B;
                ((com.chuckerteam.chucker.internal.ui.d) obj).onClick(view);
                ((Snackbar) obj2).b(1);
                break;
        }
    }
}
