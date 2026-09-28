package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.annotation.RequiresApi;
import com.appsflyer.AFLogger;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import in.juspay.hyperupi.UPIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AFi1qSDK extends AFi1pSDK {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFi1qSDK(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
    }

    private static boolean w_(NetworkCapabilities networkCapabilities) {
        return (networkCapabilities == null || !networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(15)) ? false : true;
    }

    @Override // com.appsflyer.internal.AFi1pSDK
    public final boolean getMonetizationNetwork() {
        Network[] allNetworks;
        try {
            ConnectivityManager connectivityManager = this.getMonetizationNetwork;
            if (connectivityManager == null || (allNetworks = connectivityManager.getAllNetworks()) == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (Network network : allNetworks) {
                ConnectivityManager connectivityManager2 = this.getMonetizationNetwork;
                Intrinsics.c(connectivityManager2);
                NetworkCapabilities networkCapabilities = connectivityManager2.getNetworkCapabilities(network);
                if (networkCapabilities != null) {
                    arrayList.add(networkCapabilities);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (w_((NetworkCapabilities) it.next())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            AFLogger.afErrorLog("Failed collecting ivc data", e2);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFi1pSDK
    @NotNull
    public final String getRevenue() {
        final Network[] allNetworks;
        Object next;
        ConnectivityManager connectivityManager = this.getMonetizationNetwork;
        if (connectivityManager == null || (allNetworks = connectivityManager.getAllNetworks()) == null) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
        Intrinsics.checkNotNullParameter(allNetworks, "<this>");
        Sequence<Object> sequenceF = allNetworks.length == 0 ? SequencesKt.f() : new Sequence<Object>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator iterator() {
                return ArrayIteratorKt.a(allNetworks);
            }
        };
        if (sequenceF == null) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1();
        while (true) {
            if (!anonymousClass1.hasNext()) {
                next = null;
                break;
            }
            next = anonymousClass1.next();
            if (AFi1pSDK.v_((NetworkInfo) next)) {
                break;
            }
        }
        NetworkInfo networkInfo = (NetworkInfo) next;
        if (networkInfo == null) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
        int type = networkInfo.getType();
        return type != 0 ? type != 1 ? zzck.UNKNOWN_CONTENT_TYPE : UPIConstants.WIFI : "MOBILE";
    }
}
