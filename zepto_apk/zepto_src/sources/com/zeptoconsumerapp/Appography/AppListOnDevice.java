package com.zeptoconsumerapp.Appography;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.Settings;
import bridges.CommsModule;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import com.zeptoconsumerapp.modules.event.model.entity.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AppListOnDevice {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47335a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f47336b;

    /* renamed from: c, reason: collision with root package name */
    public final List f47337c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f47338d;

    @Metadata
    public static final class Companion {
    }

    public AppListOnDevice(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47335a = context;
        final int i2 = 0;
        this.f47336b = LazyKt.b(new Function0(this) { // from class: com.zeptoconsumerapp.Appography.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppListOnDevice f47340b;

            {
                this.f47340b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        MMKV.initialize(this.f47340b.f47335a.getApplicationContext());
                        return MMKV.mmkvWithID("app_package_list");
                    default:
                        try {
                            return this.f47340b.f47335a.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
                        } catch (Exception unused) {
                            return null;
                        }
                }
            }
        });
        this.f47337c = CollectionsKt.H("org.chromium.webapk");
        final int i3 = 1;
        this.f47338d = LazyKt.b(new Function0(this) { // from class: com.zeptoconsumerapp.Appography.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppListOnDevice f47340b;

            {
                this.f47340b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        MMKV.initialize(this.f47340b.f47335a.getApplicationContext());
                        return MMKV.mmkvWithID("app_package_list");
                    default:
                        try {
                            return this.f47340b.f47335a.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
                        } catch (Exception unused) {
                            return null;
                        }
                }
            }
        });
    }

    public final List a(Context context) {
        List listZ;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 128);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo) it.next()).activityInfo;
            String str = (activityInfo == null || (applicationInfo = activityInfo.applicationInfo) == null) ? null : applicationInfo.packageName;
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            String str2 = (String) next;
            List list = this.f47337c;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    if (StringsKt.O(str2, (String) it3.next(), false)) {
                        break;
                    }
                }
            }
            arrayList2.add(next);
        }
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        List listE0 = CollectionsKt.e0(CollectionsKt.g0(arrayList2));
        return (listE0 == null || (listZ = CollectionsKt.Z(listE0, 600)) == null) ? EmptyList.f53609a : listZ;
    }

    public final void b(List list) {
        String string;
        SharedPreferences sharedPreferences = (SharedPreferences) this.f47338d.getValue();
        String str = "";
        if (sharedPreferences == null || (string = sharedPreferences.getString("userId", null)) == null) {
            string = "";
        }
        try {
            String string2 = Settings.Secure.getString(this.f47335a.getContentResolver(), "android_id");
            if (string2 != null) {
                str = string2;
            }
        } catch (Exception unused) {
        }
        Event event = new Event("apps_on_device", MapsKt.h(new Pair("installed_packages", list), new Pair("app_version", "26.1.3"), new Pair("user_id", string), new Pair("device_id", str)));
        Object obj = LogEventUseCase.f47644a;
        LogEventUseCase.Companion.a(event.b(), event.a());
    }
}
