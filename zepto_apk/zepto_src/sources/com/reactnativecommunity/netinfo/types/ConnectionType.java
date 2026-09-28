package com.reactnativecommunity.netinfo.types;

import com.google.ads.interactivemedia.v3.impl.data.zzck;

/* loaded from: classes.dex */
public enum ConnectionType {
    BLUETOOTH("bluetooth"),
    CELLULAR("cellular"),
    ETHERNET("ethernet"),
    NONE("none"),
    UNKNOWN(zzck.UNKNOWN_CONTENT_TYPE),
    WIFI("wifi"),
    /* JADX INFO: Fake field, exist only in values array */
    WIMAX("wimax"),
    VPN("vpn");


    /* renamed from: a, reason: collision with root package name */
    public final String f46207a;

    ConnectionType(String str) {
        this.f46207a = str;
    }
}
