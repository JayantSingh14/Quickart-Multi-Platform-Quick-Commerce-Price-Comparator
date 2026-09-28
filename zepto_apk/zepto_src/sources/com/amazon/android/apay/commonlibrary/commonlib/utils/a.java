package com.amazon.android.apay.commonlibrary.commonlib.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.amazon.android.apay.commonlibrary.interfaces.model.AppDetails;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14878a = new a();

    public static ArrayList a(Activity context, Intent intent) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…nager.MATCH_DEFAULT_ONLY)");
        ArrayList arrayList = new ArrayList(CollectionsKt.r(listQueryIntentActivities, 10));
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            String packageName = resolveInfo.activityInfo.packageName;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = resolveInfo.activityInfo.applicationInfo;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            arrayList.add(new AppDetails(packageName, context.getPackageManager().getApplicationLabel(applicationInfo).toString(), packageInfo.versionName.toString()));
        }
        return arrayList;
    }
}
