package com.google.firebase.sessions.settings;

import android.net.Uri;
import com.google.firebase.sessions.AndroidApplicationInfo;
import com.google.firebase.sessions.ApplicationInfo;
import in.juspay.hyper.constants.LogSubCategory;
import java.net.URL;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Singleton
@Metadata
/* loaded from: classes.dex */
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {

    /* renamed from: a, reason: collision with root package name */
    public final ApplicationInfo f45165a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f45166b;

    @Metadata
    public static final class Companion {
    }

    public RemoteSettingsFetcher(ApplicationInfo appInfo, CoroutineContext blockingDispatcher) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        this.f45165a = appInfo;
        this.f45166b = blockingDispatcher;
    }

    public static final URL b(RemoteSettingsFetcher remoteSettingsFetcher) {
        remoteSettingsFetcher.getClass();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath(LogSubCategory.LifeCycle.ANDROID).appendPath("gmp");
        ApplicationInfo applicationInfo = remoteSettingsFetcher.f45165a;
        Uri.Builder builderAppendPath2 = builderAppendPath.appendPath(applicationInfo.f44923a).appendPath("settings");
        AndroidApplicationInfo androidApplicationInfo = applicationInfo.f44924b;
        return new URL(builderAppendPath2.appendQueryParameter("build_version", androidApplicationInfo.f44920c).appendQueryParameter("display_version", androidApplicationInfo.f44919b).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public final Object a(Map map, Function2 function2, Function2 function22, Continuation continuation) throws Throwable {
        Object objE = BuildersKt.e(this.f45166b, new RemoteSettingsFetcher$doConfigFetch$2(this, map, function2, function22, null), continuation);
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }
}
