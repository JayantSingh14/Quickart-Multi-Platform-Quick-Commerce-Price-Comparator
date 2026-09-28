package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.facebook.react.bridge.Promise;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.sudoplz.rninappupdates.SpReactNativeInAppUpdatesModule;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements SynchronizationGuard.CriticalSection, OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20906a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20907b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20908c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f20907b = obj;
        this.f20908c = obj2;
        this.f20906a = i2;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object d() {
        ((Uploader) this.f20907b).f20878d.a((TransportContext) this.f20908c, this.f20906a + 1);
        return null;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((SpReactNativeInAppUpdatesModule) this.f20907b).lambda$startUpdate$3((Promise) this.f20908c, this.f20906a, (AppUpdateInfo) obj);
    }
}
