package com.zeptoconsumerapp.performancemode.performanceClasses;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.modules.base.ExperimentKeys;
import com.zeptoconsumerapp.performancemode.PerformanceModeVariants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class InitialPerformanceModeEvaluator {
    /* JADX WARN: Multi-variable type inference failed */
    public static PerformanceModeVariants a() throws RuntimeException {
        String rootDir = MMKV.getRootDir();
        ContextProvider.Companion companion = ContextProvider.f47615b;
        if (rootDir == null) {
            MMKV.initialize(companion.a().a());
        }
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
        Intrinsics.checkNotNullExpressionValue(mmkvDefaultMMKV, "defaultMMKV(...)");
        boolean zDecodeBool = mmkvDefaultMMKV.decodeBool("performanceModeOverrideEnabled");
        String strDecodeString = mmkvDefaultMMKV.decodeString("performanceModeOverride");
        PerformanceModeVariants performanceModeVariants = null;
        if (zDecodeBool && strDecodeString != null) {
            String mode = StringsKt.H(StringsKt.H(StringsKt.b0(strDecodeString).toString(), "\""), "'");
            PerformanceModeVariants.f47741c.getClass();
            Intrinsics.checkNotNullParameter(mode, "mode");
            Iterator it = ((AbstractList) PerformanceModeVariants.f47745g).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((PerformanceModeVariants) next).f47746a.equals(mode)) {
                    performanceModeVariants = next;
                    break;
                }
            }
            performanceModeVariants = performanceModeVariants;
            if (performanceModeVariants == null) {
                performanceModeVariants = PerformanceModeVariants.f47742d;
            }
        }
        if (performanceModeVariants != null) {
            return performanceModeVariants;
        }
        Context contextA = companion.a().a();
        ExperimentKeys[] experimentKeysArr = ExperimentKeys.f47618b;
        if (Utils.a(contextA, "edge_performance_mode")) {
            Object systemService = companion.a().a().getSystemService("activity");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem < 4194304000L) {
                return PerformanceModeVariants.f47743e;
            }
        }
        return PerformanceModeVariants.f47742d;
    }
}
