package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WorkDatabasePathHelper {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.Map] */
    public static final void a(Context context) {
        LinkedHashMap linkedHashMapG;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        if (databasePath.exists()) {
            Logger.e().a(WorkDatabasePathHelperKt.f12642a, "Migrating WorkDatabase to the no-backup directory");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            Intrinsics.checkNotNullExpressionValue(databasePath2, "context.getDatabasePath(WORK_DATABASE_NAME)");
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(Api21Impl.f12600a.a(context), "androidx.work.workdb");
            String[] strArr = WorkDatabasePathHelperKt.f12643b;
            int iF = MapsKt.f(strArr.length);
            if (iF < 16) {
                iF = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
            for (String str : strArr) {
                linkedHashMap.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
            }
            Pair pair = new Pair(databasePath2, file);
            Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
            Intrinsics.checkNotNullParameter(pair, "pair");
            if (linkedHashMap.isEmpty()) {
                linkedHashMapG = MapsKt.g(pair);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath2, file);
                linkedHashMapG = linkedHashMap2;
            }
            for (Map.Entry entry : linkedHashMapG.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        Logger.e().h(WorkDatabasePathHelperKt.f12642a, "Over-writing contents of " + file3);
                    }
                    Logger.e().a(WorkDatabasePathHelperKt.f12642a, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }
}
