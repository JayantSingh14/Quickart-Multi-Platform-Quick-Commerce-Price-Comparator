package com.chuckerteam.chucker.internal.ui.transaction;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemBodyLineBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemCopyBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemHeadersBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemImageBinding;
import com.chuckerteam.chucker.internal.support.SearchHighlightUtilKt;
import com.chuckerteam.chucker.internal.support.SpanTextUtil;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadItem;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionBodyAdapter extends RecyclerView.Adapter<TransactionPayloadViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    public final Function0 f16932d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f16933e;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class SearchItemBodyLine {

        /* renamed from: a, reason: collision with root package name */
        public final int f16934a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16935b;

        public SearchItemBodyLine(int i2, int i3) {
            this.f16934a = i2;
            this.f16935b = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SearchItemBodyLine)) {
                return false;
            }
            SearchItemBodyLine searchItemBodyLine = (SearchItemBodyLine) obj;
            return this.f16934a == searchItemBodyLine.f16934a && this.f16935b == searchItemBodyLine.f16935b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f16935b) + (Integer.hashCode(this.f16934a) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("SearchItemBodyLine(indexBodyLine=");
            sb.append(this.f16934a);
            sb.append(", indexStartOfQuerySubString=");
            return android.support.v4.media.b.o(sb, this.f16935b, ")");
        }
    }

    public TransactionBodyAdapter(Function0 onCopyBodyListener) {
        Intrinsics.checkNotNullParameter(onCopyBodyListener, "onCopyBodyListener");
        this.f16932d = onCopyBodyListener;
        this.f16933e = new ArrayList();
    }

    public static int y(SpannableStringBuilder spannableStringBuilder) {
        int i2 = 0;
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class)) {
            if (!(obj instanceof SpanTextUtil.ChuckerForegroundColorSpan)) {
                spannableStringBuilder.removeSpan(obj);
                i2++;
            }
        }
        return i2;
    }

    public final void A() {
        ArrayList arrayList = this.f16933e;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof TransactionPayloadItem.BodyLineItem) {
                arrayList2.add(next);
            }
        }
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        Iterator it2 = new IndexingIterable(new coil3.decode.a(arrayList2, 10)).iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it2;
            if (!indexingIterator.f53615a.hasNext()) {
                return;
            }
            IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
            int i2 = indexedValue.f53612a;
            if (y(((TransactionPayloadItem.BodyLineItem) indexedValue.f53613b).f16962a) > 0) {
                h(i2 + 1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return this.f16933e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int f(int i2) {
        TransactionPayloadItem transactionPayloadItem = (TransactionPayloadItem) this.f16933e.get(i2);
        if (transactionPayloadItem instanceof TransactionPayloadItem.HeaderItem) {
            return 1;
        }
        if (transactionPayloadItem instanceof TransactionPayloadItem.BodyLineItem) {
            return 2;
        }
        if (transactionPayloadItem instanceof TransactionPayloadItem.ImageItem) {
            return 3;
        }
        if (transactionPayloadItem instanceof TransactionPayloadItem.CopyItem) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        TransactionPayloadViewHolder holder = (TransactionPayloadViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.f16933e.get(i2);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        holder.q((TransactionPayloadItem) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (i2 == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.chucker_transaction_item_headers, parent, false);
            if (viewInflate == null) {
                throw new NullPointerException("rootView");
            }
            TextView textView = (TextView) viewInflate;
            ChuckerTransactionItemHeadersBinding chuckerTransactionItemHeadersBinding = new ChuckerTransactionItemHeadersBinding(textView, textView);
            Intrinsics.checkNotNullExpressionValue(chuckerTransactionItemHeadersBinding, "inflate(...)");
            return new TransactionPayloadViewHolder.HeaderViewHolder(chuckerTransactionItemHeadersBinding);
        }
        if (i2 == 2) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.chucker_transaction_item_body_line, parent, false);
            if (viewInflate2 == null) {
                throw new NullPointerException("rootView");
            }
            TextView textView2 = (TextView) viewInflate2;
            ChuckerTransactionItemBodyLineBinding chuckerTransactionItemBodyLineBinding = new ChuckerTransactionItemBodyLineBinding(textView2, textView2);
            Intrinsics.checkNotNullExpressionValue(chuckerTransactionItemBodyLineBinding, "inflate(...)");
            return new TransactionPayloadViewHolder.BodyLineViewHolder(chuckerTransactionItemBodyLineBinding);
        }
        if (i2 != 4) {
            View viewInflate3 = layoutInflaterFrom.inflate(R.layout.chucker_transaction_item_image, parent, false);
            int i3 = R.id.binaryData;
            ImageView imageView = (ImageView) ViewBindings.a(i3, viewInflate3);
            if (imageView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i3)));
            }
            ChuckerTransactionItemImageBinding chuckerTransactionItemImageBinding = new ChuckerTransactionItemImageBinding((FrameLayout) viewInflate3, imageView);
            Intrinsics.checkNotNullExpressionValue(chuckerTransactionItemImageBinding, "inflate(...)");
            return new TransactionPayloadViewHolder.ImageViewHolder(chuckerTransactionItemImageBinding);
        }
        View viewInflate4 = layoutInflaterFrom.inflate(R.layout.chucker_transaction_item_copy, parent, false);
        int i4 = R.id.responseCopy;
        ImageButton imageButton = (ImageButton) ViewBindings.a(i4, viewInflate4);
        if (imageButton == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate4.getResources().getResourceName(i4)));
        }
        ChuckerTransactionItemCopyBinding chuckerTransactionItemCopyBinding = new ChuckerTransactionItemCopyBinding((LinearLayout) viewInflate4, imageButton);
        Intrinsics.checkNotNullExpressionValue(chuckerTransactionItemCopyBinding, "inflate(...)");
        return new TransactionPayloadViewHolder.CopyViewHolder(chuckerTransactionItemCopyBinding, this.f16932d);
    }

    public final void z(int i2, int i3, int i4, int i5, String search) {
        Intrinsics.checkNotNullParameter(search, "queryText");
        Object objC = CollectionsKt.C(i2, this.f16933e);
        TransactionPayloadItem.BodyLineItem bodyLineItem = objC instanceof TransactionPayloadItem.BodyLineItem ? (TransactionPayloadItem.BodyLineItem) objC : null;
        if (bodyLineItem != null) {
            SpannableStringBuilder spannableStringBuilder = bodyLineItem.f16962a;
            Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
            Intrinsics.checkNotNullParameter(search, "search");
            SearchHighlightUtilKt.a(spannableStringBuilder, i3, search.length(), i4, i5);
            Intrinsics.checkNotNullParameter(spannableStringBuilder, "<set-?>");
            bodyLineItem.f16962a = spannableStringBuilder;
            h(i2);
        }
    }
}
