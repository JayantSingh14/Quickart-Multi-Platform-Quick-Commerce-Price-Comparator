package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.mpmetrics.MPDbAdapter;

/* loaded from: classes.dex */
class DecideMessages {

    /* renamed from: a, reason: collision with root package name */
    public String f45991a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45992b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f45993c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f45994d;

    public DecideMessages(Context context, String str) {
        this.f45994d = context;
        this.f45992b = str;
    }

    public final synchronized void a(boolean z) {
        try {
            if (this.f45993c == null && !z) {
                MPDbAdapter mPDbAdapterG = MPDbAdapter.g(this.f45994d);
                String str = this.f45992b;
                synchronized (mPDbAdapterG) {
                    mPDbAdapterG.d(MPDbAdapter.Table.EVENTS, str);
                    mPDbAdapterG.d(MPDbAdapter.Table.PEOPLE, str);
                    mPDbAdapterG.d(MPDbAdapter.Table.GROUPS, str);
                }
            }
            this.f45993c = Boolean.valueOf(z);
        } catch (Throwable th) {
            throw th;
        }
    }
}
