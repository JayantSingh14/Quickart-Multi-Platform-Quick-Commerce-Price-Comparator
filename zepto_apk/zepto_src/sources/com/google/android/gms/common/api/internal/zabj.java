package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zabj {
    private static final ExecutorService zaa = com.google.android.gms.internal.base.zat.f36472b.b(2, new NumberedThreadFactory("GAC_Executor"));

    public static ExecutorService zaa() {
        return zaa;
    }
}
