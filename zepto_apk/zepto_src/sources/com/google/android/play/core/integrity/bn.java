package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class bn {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.s f41817a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41818b;

    /* renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource f41819c;

    /* renamed from: d, reason: collision with root package name */
    public final j f41820d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ae f41821e;

    public bn(Context context, com.google.android.play.integrity.internal.s sVar, at atVar, j jVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f41819c = taskCompletionSource;
        this.f41818b = context.getPackageName();
        this.f41817a = sVar;
        this.f41820d = jVar;
        com.google.android.play.integrity.internal.ae aeVar = new com.google.android.play.integrity.internal.ae(context, sVar, "ExpressIntegrityService", bo.f41822a, new com.google.android.play.integrity.internal.z() { // from class: com.google.android.play.core.integrity.bd
            @Override // com.google.android.play.integrity.internal.z
            public final Object a(IBinder iBinder) {
                int i2 = com.google.android.play.integrity.internal.h.f42192a;
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
                return iInterfaceQueryLocalInterface instanceof com.google.android.play.integrity.internal.i ? (com.google.android.play.integrity.internal.i) iInterfaceQueryLocalInterface : new com.google.android.play.integrity.internal.g(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
            }
        });
        this.f41821e = aeVar;
        aeVar.a().post(new be(this, taskCompletionSource, context));
    }

    public static /* bridge */ /* synthetic */ Bundle a(bn bnVar, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest, long j2, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f41818b);
        bundle.putLong("cloud.prj", j2);
        bundle.putString("nonce", standardIntegrityTokenRequest.b());
        bundle.putLong("warm.up.sid", j3);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 4);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        bundle.putIntegerArrayList("request.verdict.opt.out", new ArrayList<>(standardIntegrityTokenRequest.c()));
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle b(bn bnVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f41818b);
        bundle.putLong("cloud.prj", j2);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 4);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }

    public static boolean c(bn bnVar) {
        return bnVar.f41819c.f39750a.p() && ((Integer) bnVar.f41819c.f39750a.l()).intValue() < 83420000;
    }

    public static boolean d(bn bnVar) {
        return bnVar.f41819c.f39750a.p() && ((Integer) bnVar.f41819c.f39750a.l()).intValue() == 0;
    }
}
