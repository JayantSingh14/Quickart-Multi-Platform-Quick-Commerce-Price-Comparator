package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class zzx extends com.google.android.play.core.splitinstall.internal.zzs {

    /* renamed from: j, reason: collision with root package name */
    public static zzx f42144j;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f42145g;

    /* renamed from: h, reason: collision with root package name */
    public final zzo f42146h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f42147i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(Context context) {
        super(new com.google.android.play.core.splitinstall.internal.zzu("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        zzo zzoVar = zzo.f42127a;
        this.f42145g = new Handler(Looper.getMainLooper());
        this.f42147i = new LinkedHashSet();
        this.f42146h = zzoVar;
    }

    public static synchronized zzx c(Context context) {
        try {
            if (f42144j == null) {
                zzo zzoVar = zzo.f42127a;
                f42144j = new zzx(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f42144j;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzs
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        SplitInstallSessionState splitInstallSessionStateM = SplitInstallSessionState.m(bundleExtra);
        this.f41991a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", splitInstallSessionStateM);
        zzh zzhVarA = this.f42146h.a();
        if (splitInstallSessionStateM.h() != 3 || zzhVarA == null) {
            d(splitInstallSessionStateM);
        } else {
            zzhVarA.a(splitInstallSessionStateM.l(), new zzv(this, splitInstallSessionStateM, intent, context));
        }
    }

    public final synchronized void d(SplitInstallSessionState splitInstallSessionState) {
        try {
            Iterator it = new LinkedHashSet(this.f42147i).iterator();
            while (it.hasNext()) {
                ((SplitInstallStateUpdatedListener) it.next()).onStateUpdate(splitInstallSessionState);
            }
            synchronized (this) {
                Iterator it2 = new HashSet(this.f41994d).iterator();
                while (it2.hasNext()) {
                    ((StateUpdatedListener) it2.next()).onStateUpdate(splitInstallSessionState);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
