package com.google.firebase.iid.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;

@KeepForSdk
/* loaded from: classes.dex */
public interface FirebaseInstanceIdInternal {

    @KeepForSdk
    /* loaded from: classes4.dex */
    public interface NewTokenListener {
    }

    String a();

    void b();

    void c();

    Task d();
}
