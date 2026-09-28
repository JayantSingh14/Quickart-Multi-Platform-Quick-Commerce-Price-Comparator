package com.chuckerteam.chucker.internal.ui.transaction;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.chuckerteam.chucker.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: i, reason: collision with root package name */
    public final String[] f16938i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionPagerAdapter(TransactionActivity context, FragmentManager fm) {
        super(fm);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.f16938i = new String[]{context.getString(R.string.chucker_overview), context.getString(R.string.chucker_request), context.getString(R.string.chucker_response)};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int c() {
        return this.f16938i.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence d(int i2) {
        String str = this.f16938i[i2];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public final Fragment k(int i2) {
        if (i2 == 0) {
            return new TransactionOverviewFragment();
        }
        if (i2 == 1) {
            PayloadType type = PayloadType.f16899a;
            Intrinsics.checkNotNullParameter(type, "type");
            TransactionPayloadFragment transactionPayloadFragment = new TransactionPayloadFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", type);
            transactionPayloadFragment.setArguments(bundle);
            return transactionPayloadFragment;
        }
        if (i2 != 2) {
            throw new IllegalArgumentException("no item");
        }
        PayloadType type2 = PayloadType.f16900b;
        Intrinsics.checkNotNullParameter(type2, "type");
        TransactionPayloadFragment transactionPayloadFragment2 = new TransactionPayloadFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("type", type2);
        transactionPayloadFragment2.setArguments(bundle2);
        return transactionPayloadFragment2;
    }
}
