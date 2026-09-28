package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.support.v4.media.b;
import androidx.work.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WakeLocks {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12996a;

    static {
        String strG = Logger.g("WakeLocks");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"WakeLocks\")");
        f12996a = strG;
    }

    public static final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (WakeLocksHolder.f12997a) {
            linkedHashMap.putAll(WakeLocksHolder.f12998b);
            Unit unit = Unit.f53572a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.e().h(f12996a, "WakeLock held for " + str);
            }
        }
    }

    public static final PowerManager.WakeLock b(Context context, String tag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String strC = b.C("WorkManager: ", tag);
        PowerManager.WakeLock wakeLock = ((PowerManager) systemService).newWakeLock(1, strC);
        synchronized (WakeLocksHolder.f12997a) {
        }
        Intrinsics.checkNotNullExpressionValue(wakeLock, "wakeLock");
        return wakeLock;
    }
}
