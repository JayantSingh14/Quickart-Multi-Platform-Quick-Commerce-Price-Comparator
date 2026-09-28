package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerActivityTransactionBinding;
import com.chuckerteam.chucker.databinding.ChuckerFragmentTransactionOverviewBinding;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16981a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16982b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f16981a = i2;
        this.f16982b = obj;
    }

    @Override // androidx.lifecycle.Observer
    public final void a(Object obj) {
        Object obj2 = this.f16982b;
        switch (this.f16981a) {
            case 0:
                Pair pair = (Pair) obj;
                HttpTransaction httpTransaction = (HttpTransaction) pair.f53533a;
                boolean zBooleanValue = ((Boolean) pair.f53534b).booleanValue();
                if (httpTransaction == null) {
                    return;
                }
                TransactionPayloadFragment transactionPayloadFragment = (TransactionPayloadFragment) obj2;
                BuildersKt.c(LifecycleOwnerKt.a(transactionPayloadFragment), null, new TransactionPayloadFragment$onViewCreated$2$1(transactionPayloadFragment, httpTransaction, zBooleanValue, null), 3);
                return;
            case 1:
                String str = (String) obj;
                ChuckerActivityTransactionBinding chuckerActivityTransactionBinding = ((TransactionActivity) obj2).f16907k;
                if (chuckerActivityTransactionBinding != null) {
                    chuckerActivityTransactionBinding.f16653a.setText(str);
                    return;
                } else {
                    Intrinsics.h("transactionBinding");
                    throw null;
                }
            case 2:
                int i2 = TransactionActivity.f16905l;
                ((MenuItem) obj2).setIcon(((Boolean) obj).booleanValue() ? R.drawable.chucker_ic_encoded_url_white : R.drawable.chucker_ic_decoded_url_white);
                return;
            case 3:
                ((Menu) obj2).findItem(R.id.encode_url).setVisible(((Boolean) obj).booleanValue());
                return;
            default:
                Pair pair2 = (Pair) obj;
                HttpTransaction httpTransaction2 = (HttpTransaction) pair2.f53533a;
                boolean zBooleanValue2 = ((Boolean) pair2.f53534b).booleanValue();
                ChuckerFragmentTransactionOverviewBinding chuckerFragmentTransactionOverviewBinding = ((TransactionOverviewFragment) obj2).X;
                if (chuckerFragmentTransactionOverviewBinding == null) {
                    Intrinsics.h("overviewBinding");
                    throw null;
                }
                chuckerFragmentTransactionOverviewBinding.x.setText(httpTransaction2 != null ? httpTransaction2.getFormattedUrl(zBooleanValue2) : null);
                chuckerFragmentTransactionOverviewBinding.f16658e.setText(httpTransaction2 != null ? httpTransaction2.getMethod() : null);
                chuckerFragmentTransactionOverviewBinding.f16659f.setText(httpTransaction2 != null ? httpTransaction2.getProtocol() : null);
                chuckerFragmentTransactionOverviewBinding.s.setText(String.valueOf(httpTransaction2 != null ? httpTransaction2.getStatus() : null));
                chuckerFragmentTransactionOverviewBinding.f16664k.setText(httpTransaction2 != null ? httpTransaction2.getResponseSummaryText() : null);
                Boolean boolValueOf = httpTransaction2 != null ? Boolean.valueOf(httpTransaction2.isSsl()) : null;
                Group group = chuckerFragmentTransactionOverviewBinding.q;
                if (boolValueOf == null) {
                    group.setVisibility(8);
                } else {
                    boolean zEquals = boolValueOf.equals(Boolean.TRUE);
                    TextView textView = chuckerFragmentTransactionOverviewBinding.r;
                    if (zEquals) {
                        group.setVisibility(0);
                        textView.setText(R.string.chucker_yes);
                    } else {
                        group.setVisibility(0);
                        textView.setText(R.string.chucker_no);
                    }
                }
                if ((httpTransaction2 != null ? httpTransaction2.getResponseTlsVersion() : null) != null) {
                    chuckerFragmentTransactionOverviewBinding.v.setText(httpTransaction2.getResponseTlsVersion());
                    chuckerFragmentTransactionOverviewBinding.t.setVisibility(0);
                }
                if ((httpTransaction2 != null ? httpTransaction2.getResponseCipherSuite() : null) != null) {
                    chuckerFragmentTransactionOverviewBinding.f16656c.setText(httpTransaction2.getResponseCipherSuite());
                    chuckerFragmentTransactionOverviewBinding.f16655b.setVisibility(0);
                }
                chuckerFragmentTransactionOverviewBinding.f16662i.setText(httpTransaction2 != null ? httpTransaction2.getRequestDateString() : null);
                chuckerFragmentTransactionOverviewBinding.n.setText(httpTransaction2 != null ? httpTransaction2.getResponseDateString() : null);
                chuckerFragmentTransactionOverviewBinding.f16657d.setText(httpTransaction2 != null ? httpTransaction2.getDurationString() : null);
                chuckerFragmentTransactionOverviewBinding.f16660g.setText(httpTransaction2 != null ? httpTransaction2.getRequestSizeString() : null);
                chuckerFragmentTransactionOverviewBinding.f16665l.setText(httpTransaction2 != null ? httpTransaction2.getResponseSizeString() : null);
                chuckerFragmentTransactionOverviewBinding.w.setText(httpTransaction2 != null ? httpTransaction2.getTotalSizeString() : null);
                return;
        }
    }
}
