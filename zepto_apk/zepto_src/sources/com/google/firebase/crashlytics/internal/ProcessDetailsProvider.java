package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ProcessDetailsProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final ProcessDetailsProvider f43706a = new ProcessDetailsProvider();

    public static CrashlyticsReport.Session.Event.Application.ProcessDetails a(ProcessDetailsProvider processDetailsProvider, String processName, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        processDetailsProvider.getClass();
        Intrinsics.checkNotNullParameter(processName, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder builderA = CrashlyticsReport.Session.Event.Application.ProcessDetails.a();
        builderA.e(processName);
        builderA.d(i2);
        builderA.c(i3);
        builderA.b(false);
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsA = builderA.a();
        Intrinsics.checkNotNullExpressionValue(processDetailsA, "builder()\n      .setProc…ltProcess)\n      .build()");
        return processDetailsA;
    }

    public static ArrayList b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = EmptyList.f53609a;
        }
        ArrayList arrayListX = CollectionsKt.x(runningAppProcesses);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListX.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((ActivityManager.RunningAppProcessInfo) next).uid == i2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it2.next();
            CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder builderA = CrashlyticsReport.Session.Event.Application.ProcessDetails.a();
            builderA.e(runningAppProcessInfo.processName);
            builderA.d(runningAppProcessInfo.pid);
            builderA.c(runningAppProcessInfo.importance);
            builderA.b(Intrinsics.b(runningAppProcessInfo.processName, str));
            arrayList2.add(builderA.a());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails c(Context context) {
        Object next;
        String processName;
        Intrinsics.checkNotNullParameter(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = b(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) next).c() == iMyPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) next;
        if (processDetails != null) {
            return processDetails;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 33) {
            processName = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(processName, "{\n      Process.myProcessName()\n    }");
        } else if (i2 < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        return a(this, processName, iMyPid, 0, 12);
    }
}
