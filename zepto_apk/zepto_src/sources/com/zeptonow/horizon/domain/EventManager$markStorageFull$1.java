package com.zeptonow.horizon.domain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes4.dex */
final class EventManager$markStorageFull$1 extends Lambda implements Function0<String> {

    /* renamed from: c, reason: collision with root package name */
    public static final EventManager$markStorageFull$1 f47991c = new EventManager$markStorageFull$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        return "EventManager:: storage marked as full, switching to direct sending";
    }
}
