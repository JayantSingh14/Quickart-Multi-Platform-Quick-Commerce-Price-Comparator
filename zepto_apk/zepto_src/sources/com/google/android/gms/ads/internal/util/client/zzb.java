package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f21407a = new ThreadPoolExecutor(2, Api.BaseClientBuilder.API_PRIORITY_OTHER, 10, TimeUnit.SECONDS, new SynchronousQueue(), new zza("ClientDefault"));

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f21408b = Executors.newSingleThreadExecutor(new zza("ClientSingle"));
}
