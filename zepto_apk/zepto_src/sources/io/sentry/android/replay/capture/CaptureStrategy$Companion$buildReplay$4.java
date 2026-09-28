package io.sentry.android.replay.capture;

import io.sentry.rrweb.RRWebEvent;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class CaptureStrategy$Companion$buildReplay$4 extends Lambda implements Function1<RRWebEvent, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Date f52584c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f52585d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureStrategy$Companion$buildReplay$4(Date date, ArrayList arrayList) {
        super(1);
        this.f52584c = date;
        this.f52585d = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RRWebEvent event = (RRWebEvent) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.f53031b >= this.f52584c.getTime()) {
            this.f52585d.add(event);
        }
        return Unit.f53572a;
    }
}
