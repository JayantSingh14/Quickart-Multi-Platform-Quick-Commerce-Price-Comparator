package com.zeptonow.horizon.utils;

import com.zeptonow.horizon.storage.EventEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class LoggerHelper {
    public static String a(List eventList) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        StringBuilder sb = new StringBuilder("Batch size=");
        sb.append(eventList.size());
        sb.append(", Event Id list=");
        List list = eventList;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((EventEntity) it.next()).f48164a);
        }
        sb.append(arrayList);
        return sb.toString();
    }
}
