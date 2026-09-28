package com.reactnativecommunity.netinfo.types;

import android.net.NetworkInfo;

/* loaded from: classes4.dex */
public enum CellularGeneration {
    CG_2G("2g"),
    CG_3G("3g"),
    CG_4G("4g"),
    CG_5G("5g");


    /* renamed from: a, reason: collision with root package name */
    public final String f46198a;

    CellularGeneration(String str) {
        this.f46198a = str;
    }

    public static CellularGeneration a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == 20) {
            return CG_5G;
        }
        switch (subtype) {
        }
        return null;
    }
}
