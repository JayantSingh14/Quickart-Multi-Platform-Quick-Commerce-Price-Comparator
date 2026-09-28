package com.mixpanel.android.util;

/* loaded from: classes.dex */
public interface RemoteService {

    public static class ServiceUnavailableException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f46097a;

        public ServiceUnavailableException(String str) throws NumberFormatException {
            int i2;
            super("Service Unavailable");
            try {
                i2 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            this.f46097a = i2;
        }
    }
}
