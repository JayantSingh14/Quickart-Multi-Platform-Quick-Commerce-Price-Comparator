package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.sessions.AutoSessionEventEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SessionEvents {

    /* renamed from: a, reason: collision with root package name */
    public static final SessionEvents f45060a = new SessionEvents();

    /* renamed from: b, reason: collision with root package name */
    public static final DataEncoder f45061b;

    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        jsonDataEncoderBuilder.b(SessionEvent.class, AutoSessionEventEncoder.SessionEventEncoder.f44948a);
        jsonDataEncoderBuilder.b(SessionInfo.class, AutoSessionEventEncoder.SessionInfoEncoder.f44952a);
        jsonDataEncoderBuilder.b(DataCollectionStatus.class, AutoSessionEventEncoder.DataCollectionStatusEncoder.f44939a);
        jsonDataEncoderBuilder.b(ApplicationInfo.class, AutoSessionEventEncoder.ApplicationInfoEncoder.f44932a);
        jsonDataEncoderBuilder.b(AndroidApplicationInfo.class, AutoSessionEventEncoder.AndroidApplicationInfoEncoder.f44925a);
        jsonDataEncoderBuilder.b(ProcessDetails.class, AutoSessionEventEncoder.ProcessDetailsEncoder.f44943a);
        jsonDataEncoderBuilder.f44505d = true;
        DataEncoder dataEncoderA = jsonDataEncoderBuilder.a();
        Intrinsics.checkNotNullExpressionValue(dataEncoderA, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f45061b = dataEncoderA;
    }

    public static ApplicationInfo a(FirebaseApp firebaseApp) throws PackageManager.NameNotFoundException {
        Object next;
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        firebaseApp.a();
        Context context = firebaseApp.f43489a;
        Intrinsics.checkNotNullExpressionValue(context, "firebaseApp.applicationContext");
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        firebaseApp.a();
        String str = firebaseApp.f43491c.f43507b;
        Intrinsics.checkNotNullExpressionValue(str, "firebaseApp.options.applicationId");
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        String str2 = packageInfo.versionName;
        if (str2 == null) {
            str2 = strValueOf;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        firebaseApp.a();
        Intrinsics.checkNotNullExpressionValue(context, "firebaseApp.applicationContext");
        Intrinsics.checkNotNullParameter(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = ProcessDetailsProvider.a(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProcessDetails) next).f45024b == iMyPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) next;
        if (processDetails == null) {
            processDetails = new ProcessDetails(iMyPid, 0, ProcessDetailsProvider.b(), false);
        }
        firebaseApp.a();
        Intrinsics.checkNotNullExpressionValue(context, "firebaseApp.applicationContext");
        return new ApplicationInfo(str, new AndroidApplicationInfo(packageName, str2, strValueOf, processDetails, ProcessDetailsProvider.a(context)));
    }
}
