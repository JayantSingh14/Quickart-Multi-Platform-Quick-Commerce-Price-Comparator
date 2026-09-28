package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionListDetailsSharable implements Sharable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16841a;

    public TransactionListDetailsSharable(List transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        List list = transactions;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TransactionDetailsSharable((HttpTransaction) it.next(), false));
        }
        this.f16841a = arrayList;
    }

    @Override // com.chuckerteam.chucker.internal.support.Sharable
    public final Buffer a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Buffer buffer = new Buffer();
        buffer.X1(CollectionsKt.E(this.f16841a, android.support.v4.media.b.D(StringUtils.LF, context.getString(R.string.chucker_export_separator), StringUtils.LF), android.support.v4.media.b.k(context.getString(R.string.chucker_export_prefix), StringUtils.LF), android.support.v4.media.b.D(StringUtils.LF, context.getString(R.string.chucker_export_postfix), StringUtils.LF), new com.brentvatne.react.c(context, 1), 24));
        return buffer;
    }
}
