package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionDetailsHarSharable implements Sharable {

    /* renamed from: a, reason: collision with root package name */
    public final String f16837a;

    public TransactionDetailsHarSharable(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.f16837a = content;
    }

    @Override // com.chuckerteam.chucker.internal.support.Sharable
    public final Buffer a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Buffer buffer = new Buffer();
        buffer.X1(this.f16837a + StringUtils.LF);
        return buffer;
    }
}
