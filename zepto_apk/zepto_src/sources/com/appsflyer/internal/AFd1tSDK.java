package com.appsflyer.internal;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AFd1tSDK {
    @NotNull
    public static final JSONArray getCurrencyIso4217Code(@NotNull List<AFc1cSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AFc1cSDK> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AFc1cSDK) it.next()).getRevenue());
        }
        return new JSONArray((Collection) arrayList);
    }

    public static final boolean getRevenue(@NotNull HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "");
        return httpURLConnection.getResponseCode() / 100 == 2;
    }
}
