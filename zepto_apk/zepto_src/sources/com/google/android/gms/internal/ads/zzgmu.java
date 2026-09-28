package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgmu extends BroadcastReceiver implements zzglz, zzgcb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32939a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32940b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f32941c = true;

    public zzgmu(Context context, ExecutorService executorService) {
        this.f32939a = context;
        this.f32940b = executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void a(HashMap map, Context context, View view) {
        boolean z;
        synchronized (this) {
            z = this.f32941c;
        }
        map.put("up", Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void b(HashMap map) {
        boolean z;
        synchronized (this) {
            z = this.f32941c;
        }
        map.put("up", Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void c(HashMap map) {
        boolean z;
        synchronized (this) {
            z = this.f32941c;
        }
        map.put("up", Boolean.valueOf(z));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            synchronized (this) {
                this.f32941c = true;
            }
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            synchronized (this) {
                this.f32941c = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgmt
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgmu zzgmuVar = this.f32938a;
                zzgmuVar.getClass();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                zzgmuVar.f32939a.registerReceiver(zzgmuVar, intentFilter);
                return null;
            }
        }, this.f32940b);
    }
}
