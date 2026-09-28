package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzav extends zzbg {

    /* renamed from: e, reason: collision with root package name */
    public final com.google.ads.interactivemedia.pal.zzx f37525e;

    /* renamed from: f, reason: collision with root package name */
    public final Task f37526f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f37527g;

    public zzav(Handler handler, ExecutorService executorService, Context context, Task task, com.google.ads.interactivemedia.pal.zzx zzxVar) {
        super(handler, executorService, zzagc.b(2L));
        this.f37527g = context;
        this.f37526f = task;
        this.f37525e = zzxVar;
    }

    @Override // com.google.android.gms.internal.pal.zzbg
    public final zzil a() {
        try {
            String strZzg = ((zzfm) Tasks.a(this.f37526f)).f37740a.zzg(new ObjectWrapper(this.f37527g), null);
            strZzg.getClass();
            return new zziq(strZzg);
        } catch (RemoteException | InterruptedException | ExecutionException unused) {
            Log.e("NonceGenerator", "Unexpected exception while gathering request signals.");
            this.f37525e.zza(1);
            return zzif.f37811a;
        }
    }
}
