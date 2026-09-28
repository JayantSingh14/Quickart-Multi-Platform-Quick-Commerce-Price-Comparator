package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfts {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f31857b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public zzftr f31858c = null;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f31856a = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
}
