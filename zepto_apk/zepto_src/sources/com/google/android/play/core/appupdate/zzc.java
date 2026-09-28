package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzc extends com.google.android.play.core.appupdate.internal.zzl {
    @Override // com.google.android.play.core.appupdate.internal.zzl
    public final void a(Context context, Intent intent) {
        boolean zEquals = context.getPackageName().equals(intent.getStringExtra("package.name"));
        com.google.android.play.core.appupdate.internal.zzm zzmVar = this.f41682a;
        if (!zEquals) {
            zzmVar.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        zzmVar.a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            zzmVar.a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        InstallState installStateF = InstallState.f(intent, zzmVar);
        zzmVar.a("ListenerRegistryBroadcastReceiver.onReceive: %s", installStateF);
        synchronized (this) {
            Iterator it = new HashSet(this.f41685d).iterator();
            while (it.hasNext()) {
                ((StateUpdatedListener) it.next()).onStateUpdate(installStateF);
            }
        }
    }
}
