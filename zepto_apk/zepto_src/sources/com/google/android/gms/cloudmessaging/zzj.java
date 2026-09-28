package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzp f22265a;

    public /* synthetic */ zzj(zzp zzpVar) {
        this.f22265a = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws RemoteException {
        while (true) {
            final zzp zzpVar = this.f22265a;
            synchronized (zzpVar) {
                try {
                    if (zzpVar.f22271a != 2) {
                        return;
                    }
                    if (zzpVar.f22274d.isEmpty()) {
                        zzpVar.c();
                        return;
                    }
                    final zzs zzsVar = (zzs) zzpVar.f22274d.poll();
                    zzpVar.f22275e.put(zzsVar.f22279a, zzsVar);
                    zzpVar.f22276f.f22285b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzp zzpVar2 = zzpVar;
                            int i2 = zzsVar.f22279a;
                            synchronized (zzpVar2) {
                                zzs zzsVar2 = (zzs) zzpVar2.f22275e.get(i2);
                                if (zzsVar2 != null) {
                                    Log.w("MessengerIpcClient", "Timing out request: " + i2);
                                    zzpVar2.f22275e.remove(i2);
                                    zzsVar2.c(new zzt("Timed out waiting for response", null));
                                    zzpVar2.c();
                                }
                            }
                        }
                    }, 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(zzsVar)));
                    }
                    zzv zzvVar = zzpVar.f22276f;
                    Messenger messenger = zzpVar.f22272b;
                    int i2 = zzsVar.f22281c;
                    Context context = zzvVar.f22284a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i2;
                    messageObtain.arg1 = zzsVar.f22279a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzsVar.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", zzsVar.f22282d);
                    messageObtain.setData(bundle);
                    try {
                        zzq zzqVar = zzpVar.f22273c;
                        Messenger messenger2 = zzqVar.f22277a;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            zzd zzdVar = zzqVar.f22278b;
                            if (zzdVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            zzdVar.a(messageObtain);
                        }
                    } catch (RemoteException e2) {
                        zzpVar.a(e2.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}
