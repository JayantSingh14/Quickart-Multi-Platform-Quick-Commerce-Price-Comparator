package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* renamed from: a, reason: collision with root package name */
    public final c f44545a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f44546b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider f44547c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f44548d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f44549e;

    public DefaultHeartBeatController(Context context, String str, Set set, Provider provider, Executor executor) {
        this.f44545a = new c(context, str);
        this.f44548d = set;
        this.f44549e = executor;
        this.f44547c = provider;
        this.f44546b = context;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public final Task a() {
        return !UserManagerCompat.a(this.f44546b) ? Tasks.e("") : Tasks.c(new a(this, 1), this.f44549e);
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public final synchronized HeartBeatInfo.HeartBeat b() {
        boolean zG;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) this.f44545a.get();
        synchronized (heartBeatInfoStorage) {
            zG = heartBeatInfoStorage.g(jCurrentTimeMillis);
        }
        if (!zG) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        synchronized (heartBeatInfoStorage) {
            String strD = heartBeatInfoStorage.d(System.currentTimeMillis());
            heartBeatInfoStorage.f44554a.edit().putString("last-used-date", strD).commit();
            heartBeatInfoStorage.f(strD);
        }
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    public final void c() {
        if (this.f44548d.size() <= 0) {
            Tasks.e(null);
        } else if (UserManagerCompat.a(this.f44546b)) {
            Tasks.c(new a(this, 0), this.f44549e);
        } else {
            Tasks.e(null);
        }
    }
}
