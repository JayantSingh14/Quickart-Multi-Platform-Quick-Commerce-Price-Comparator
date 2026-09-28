package com.zeptoconsumerapp.AppServiceStarter.cleanup;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class CleanupActionRegistry {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f47327a;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f47327a = linkedHashMap;
        POIACleanupAction action = new POIACleanupAction();
        Intrinsics.checkNotNullParameter(action, "action");
        linkedHashMap.put("POIA_CLEANUP", action);
    }
}
