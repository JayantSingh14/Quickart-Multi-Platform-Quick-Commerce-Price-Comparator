package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerListItemTransactionBinding;
import com.chuckerteam.chucker.internal.data.entity.HttpTransactionTuple;
import com.chuckerteam.chucker.internal.support.TransactionDiffCallback;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionAdapter extends ListAdapter<HttpTransactionTuple, TransactionViewHolder> {

    /* renamed from: f, reason: collision with root package name */
    public final com.chuckerteam.chucker.internal.ui.a f16925f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16926g;

    /* renamed from: h, reason: collision with root package name */
    public final int f16927h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16928i;

    /* renamed from: j, reason: collision with root package name */
    public final int f16929j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16930k;

    /* renamed from: l, reason: collision with root package name */
    public final int f16931l;

    @Metadata
    public final class TransactionViewHolder extends RecyclerView.ViewHolder {
        public final ChuckerListItemTransactionBinding u;
        public Long v;
        public final /* synthetic */ TransactionAdapter w;

        /* JADX WARN: Illegal instructions before constructor call */
        public TransactionViewHolder(TransactionAdapter transactionAdapter, ChuckerListItemTransactionBinding itemBinding) {
            Intrinsics.checkNotNullParameter(itemBinding, "itemBinding");
            this.w = transactionAdapter;
            ConstraintLayout constraintLayout = itemBinding.f16675a;
            super(constraintLayout);
            this.u = itemBinding;
            constraintLayout.setOnClickListener(new c(0, this, transactionAdapter));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionAdapter(MainActivity context, com.chuckerteam.chucker.internal.ui.a onTransactionClick) {
        super(TransactionDiffCallback.f16840a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onTransactionClick, "onTransactionClick");
        this.f16925f = onTransactionClick;
        this.f16926g = context.getColor(R.color.chucker_status_default);
        this.f16927h = context.getColor(R.color.chucker_status_requested);
        this.f16928i = context.getColor(R.color.chucker_status_error);
        this.f16929j = context.getColor(R.color.chucker_status_500);
        this.f16930k = context.getColor(R.color.chucker_status_400);
        this.f16931l = context.getColor(R.color.chucker_status_300);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(androidx.recyclerview.widget.RecyclerView.ViewHolder r10, int r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.transaction.TransactionAdapter.o(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chucker_list_item_transaction, parent, false);
        int i3 = R.id.code;
        TextView textView = (TextView) ViewBindings.a(i3, viewInflate);
        if (textView != null) {
            i3 = R.id.duration;
            TextView textView2 = (TextView) ViewBindings.a(i3, viewInflate);
            if (textView2 != null) {
                i3 = R.id.graphqlIcon;
                ImageView imageView = (ImageView) ViewBindings.a(i3, viewInflate);
                if (imageView != null) {
                    i3 = R.id.graphqlPath;
                    TextView textView3 = (TextView) ViewBindings.a(i3, viewInflate);
                    if (textView3 != null) {
                        i3 = R.id.guideline;
                        if (((Guideline) ViewBindings.a(i3, viewInflate)) != null) {
                            i3 = R.id.host;
                            TextView textView4 = (TextView) ViewBindings.a(i3, viewInflate);
                            if (textView4 != null) {
                                i3 = R.id.path;
                                TextView textView5 = (TextView) ViewBindings.a(i3, viewInflate);
                                if (textView5 != null) {
                                    i3 = R.id.size;
                                    TextView textView6 = (TextView) ViewBindings.a(i3, viewInflate);
                                    if (textView6 != null) {
                                        i3 = R.id.ssl;
                                        ImageView imageView2 = (ImageView) ViewBindings.a(i3, viewInflate);
                                        if (imageView2 != null) {
                                            i3 = R.id.timeStart;
                                            TextView textView7 = (TextView) ViewBindings.a(i3, viewInflate);
                                            if (textView7 != null) {
                                                ChuckerListItemTransactionBinding chuckerListItemTransactionBinding = new ChuckerListItemTransactionBinding((ConstraintLayout) viewInflate, textView, textView2, imageView, textView3, textView4, textView5, textView6, imageView2, textView7);
                                                Intrinsics.checkNotNullExpressionValue(chuckerListItemTransactionBinding, "inflate(...)");
                                                return new TransactionViewHolder(this, chuckerListItemTransactionBinding);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
    }
}
