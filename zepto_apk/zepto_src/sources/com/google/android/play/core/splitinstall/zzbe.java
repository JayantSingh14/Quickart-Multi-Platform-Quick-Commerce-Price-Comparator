package com.google.android.play.core.splitinstall;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbe {

    /* renamed from: a, reason: collision with root package name */
    public final Context f42108a;

    public zzbe(Context context) {
        this.f42108a = context;
    }

    public final Set a() {
        Set<String> hashSet;
        synchronized (zzbe.class) {
            try {
                hashSet = this.f42108a.getSharedPreferences("playcore_split_install_internal", 0).getStringSet("modules_to_uninstall_if_emulated", new HashSet());
            } catch (Exception unused) {
                hashSet = new HashSet<>();
            }
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
        }
        return hashSet;
    }
}
