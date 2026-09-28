package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;

/* loaded from: classes.dex */
final class ProxyNotificationPreferences {
    public static SharedPreferences a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static void b(final Context context, GmsRpc gmsRpc, final boolean z) {
        Task taskD;
        if (PlatformVersion.isAtLeastQ()) {
            SharedPreferences sharedPreferencesA = a(context);
            if (sharedPreferencesA.contains("proxy_retention") && sharedPreferencesA.getBoolean("proxy_retention", false) == z) {
                return;
            }
            Rpc rpc = gmsRpc.f44718c;
            if (rpc.f22240c.a() >= 241100000) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("proxy_retention", z);
                taskD = zzv.a(rpc.f22239b).b(4, bundle);
            } else {
                taskD = Tasks.d(new IOException("SERVICE_NOT_AVAILABLE"));
            }
            taskD.f(new androidx.arch.core.executor.a(1), new OnSuccessListener() { // from class: com.google.firebase.messaging.p
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    SharedPreferences.Editor editorEdit = ProxyNotificationPreferences.a(context).edit();
                    editorEdit.putBoolean("proxy_retention", z);
                    editorEdit.apply();
                }
            });
        }
    }
}
