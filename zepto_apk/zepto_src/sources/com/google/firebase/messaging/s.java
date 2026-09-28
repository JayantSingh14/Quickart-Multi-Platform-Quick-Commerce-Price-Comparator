package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44889a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f44890b;

    public /* synthetic */ s(Object obj, int i2) {
        this.f44889a = i2;
        this.f44890b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f44889a) {
            case 0:
                SharedPreferencesQueue sharedPreferencesQueue = (SharedPreferencesQueue) this.f44890b;
                synchronized (sharedPreferencesQueue.f44760d) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesQueue.f44757a.edit();
                    String str = sharedPreferencesQueue.f44758b;
                    StringBuilder sb = new StringBuilder();
                    Iterator it = sharedPreferencesQueue.f44760d.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append(sharedPreferencesQueue.f44759c);
                    }
                    editorEdit.putString(str, sb.toString()).commit();
                }
                return;
            default:
                StringBuilder sb2 = new StringBuilder("Service took too long to process intent: ");
                WithinAppServiceConnection.BindRequest bindRequest = (WithinAppServiceConnection.BindRequest) this.f44890b;
                sb2.append(bindRequest.f44811a.getAction());
                sb2.append(" finishing.");
                Log.w("FirebaseMessaging", sb2.toString());
                bindRequest.f44812b.d(null);
                return;
        }
    }
}
