package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzayg implements zzfvv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfua f24473a;

    public zzayg(zzayi zzayiVar, zzfua zzfuaVar) {
        this.f24473a = zzfuaVar;
        Objects.requireNonNull(zzayiVar);
    }

    public final boolean a(File file) {
        try {
            return this.f24473a.a(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
