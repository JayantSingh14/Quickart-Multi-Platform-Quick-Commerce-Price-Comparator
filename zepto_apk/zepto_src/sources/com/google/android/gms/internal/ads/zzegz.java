package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzbfp;

/* loaded from: classes4.dex */
public final class zzegz extends zzeha {

    /* renamed from: h, reason: collision with root package name */
    public static final SparseArray f29318h;

    /* renamed from: c, reason: collision with root package name */
    public final Context f29319c;

    /* renamed from: d, reason: collision with root package name */
    public final zzczo f29320d;

    /* renamed from: e, reason: collision with root package name */
    public final TelephonyManager f29321e;

    /* renamed from: f, reason: collision with root package name */
    public final zzegr f29322f;

    /* renamed from: g, reason: collision with root package name */
    public zzbfp.zzq f29323g;

    static {
        SparseArray sparseArray = new SparseArray();
        f29318h = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbfp.zzaf.zzd.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbfp.zzaf.zzd zzdVar = zzbfp.zzaf.zzd.CONNECTING;
        sparseArray.put(iOrdinal, zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbfp.zzaf.zzd.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbfp.zzaf.zzd zzdVar2 = zzbfp.zzaf.zzd.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbfp.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzdVar);
    }

    public zzegz(Context context, zzczo zzczoVar, zzegr zzegrVar, zzegn zzegnVar, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        super(zzegnVar, zzjVar);
        this.f29319c = context;
        this.f29320d = zzczoVar;
        this.f29322f = zzegrVar;
        this.f29321e = (TelephonyManager) context.getSystemService("phone");
    }
}
