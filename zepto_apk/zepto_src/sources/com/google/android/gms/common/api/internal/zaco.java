package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zaco {
    private static final ExecutorService zaa = com.google.android.gms.internal.base.zat.f36472b.a(new NumberedThreadFactory("GAC_Transform"));

    public static ExecutorService zaa() {
        return zaa;
    }
}
