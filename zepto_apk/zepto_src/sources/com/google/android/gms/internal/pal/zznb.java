package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zznb {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f37938a = Logger.getLogger(zznb.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f37939b = new AtomicBoolean(false);

    public static boolean a() {
        return f37939b.get();
    }
}
