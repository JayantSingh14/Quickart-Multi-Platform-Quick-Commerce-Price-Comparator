package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzers implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30180a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f30181b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f30182c;

    public zzers(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, ArrayList arrayList) {
        this.f30180a = context;
        this.f30181b = zzrVar;
        this.f30182c = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        zzczm zzczmVar = (zzczm) obj;
        if (((Boolean) zzbin.f25192a.c()).booleanValue()) {
            Bundle bundle = new Bundle();
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            String className = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.f30180a.getSystemService("activity");
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                    className = runningTaskInfo.topActivity.getClassName();
                }
            } catch (Exception unused) {
            }
            bundle.putString("activity", className);
            Bundle bundle2 = new Bundle();
            com.google.android.gms.ads.internal.client.zzr zzrVar = this.f30181b;
            bundle2.putInt(Snapshot.WIDTH, zzrVar.f21285e);
            bundle2.putInt(Snapshot.HEIGHT, zzrVar.f21282b);
            bundle.putBundle("size", bundle2);
            ArrayList arrayList = this.f30182c;
            if (!arrayList.isEmpty()) {
                bundle.putParcelableArray("parents", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
            }
            zzczmVar.f27481a.putBundle("view_hierarchy", bundle);
        }
    }
}
