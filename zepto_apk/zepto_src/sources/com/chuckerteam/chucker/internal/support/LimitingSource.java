package com.chuckerteam.chucker.internal.support;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LimitingSource extends ForwardingSource {

    /* renamed from: a, reason: collision with root package name */
    public final long f16774a;

    /* renamed from: b, reason: collision with root package name */
    public long f16775b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitingSource(Source delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f16774a = 250000L;
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.f16775b >= this.f16774a) {
            return -1L;
        }
        long j3 = super.read(sink, j2);
        this.f16775b += j3;
        return j3;
    }
}
