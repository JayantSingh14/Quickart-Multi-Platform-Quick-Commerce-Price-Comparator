package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public interface zzlg {
    default void a(zzpn zzpnVar) {
        throw new IllegalStateException("onStopped not implemented");
    }

    zzaah b(zzpn zzpnVar);

    default void c(zzpn zzpnVar) {
        throw new IllegalStateException("onReleased not implemented");
    }

    default void d(zzpn zzpnVar) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    default void e(zzlf zzlfVar, zzzw[] zzzwVarArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    default boolean f(zzlf zzlfVar) {
        throw null;
    }

    default boolean g(zzlf zzlfVar) {
        throw null;
    }

    default long zzf() {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    default void zzg() {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    default boolean zzj() {
        zzee.c("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }
}
