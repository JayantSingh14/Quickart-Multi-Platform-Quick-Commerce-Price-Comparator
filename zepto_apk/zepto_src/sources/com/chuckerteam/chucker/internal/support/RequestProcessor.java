package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import com.chuckerteam.chucker.api.ChuckerCollector;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RequestProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16795a;

    /* renamed from: b, reason: collision with root package name */
    public final ChuckerCollector f16796b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f16797c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f16798d;

    public RequestProcessor(Context context, ChuckerCollector collector, LinkedHashSet headersToRedact, ArrayList bodyDecoders) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(collector, "collector");
        Intrinsics.checkNotNullParameter(headersToRedact, "headersToRedact");
        Intrinsics.checkNotNullParameter(bodyDecoders, "bodyDecoders");
        this.f16795a = context;
        this.f16796b = collector;
        this.f16797c = headersToRedact;
        this.f16798d = bodyDecoders;
    }
}
