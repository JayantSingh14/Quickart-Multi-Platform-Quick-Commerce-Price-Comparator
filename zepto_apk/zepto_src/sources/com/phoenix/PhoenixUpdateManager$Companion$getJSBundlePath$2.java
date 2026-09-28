package com.phoenix;

import android.support.v4.media.b;
import com.phoenix.FileUtil;
import com.phoenix.PhoenixAnalyticsLogger;
import com.phoenix.PhoenixSharedPreference;
import com.phoenix.PhoenixUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@DebugMetadata(c = "com.phoenix.PhoenixUpdateManager$Companion$getJSBundlePath$2", f = "PhoenixUpdateManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class PhoenixUpdateManager$Companion$getJSBundlePath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46129a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CacheManifest f46130b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46131c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f46132d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoenixUpdateManager$Companion$getJSBundlePath$2(String str, CacheManifest cacheManifest, int i2, int i3, Continuation continuation) {
        super(2, continuation);
        this.f46129a = str;
        this.f46130b = cacheManifest;
        this.f46131c = i2;
        this.f46132d = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PhoenixUpdateManager$Companion$getJSBundlePath$2(this.f46129a, this.f46130b, this.f46131c, this.f46132d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PhoenixUpdateManager$Companion$getJSBundlePath$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        String appVersion = this.f46129a;
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        CacheManifest userData = this.f46130b;
        Intrinsics.checkNotNullParameter(userData, "userData");
        BundleStates bundleStatesF = userData.f();
        if (bundleStatesF == null || bundleStatesF != BundleStates.f46106g) {
            obj2 = "js_bundle_version";
        } else {
            BundleStates bundleStates = BundleStates.f46107h;
            int iE = userData.e();
            int iC = userData.c();
            JSONObject jSONObject = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject, new Pair("hash", userData.d()), new Pair("bundleVersion", Integer.valueOf(iC)), new Pair("jsVersion", Integer.valueOf(iE)), new Pair("appVersion", appVersion), new Pair(CLConstants.OTP_STATUS, bundleStates));
            JSONObject jSONObject2 = new JSONObject();
            obj2 = "js_bundle_version";
            PhoenixUtils.Companion.a(jSONObject2, new Pair("hash", userData.d()), new Pair("bundle_version", Integer.valueOf(iC)), new Pair("js_version", Integer.valueOf(iE)), new Pair("app_version", appVersion), new Pair("old_status", bundleStatesF), new Pair(CLConstants.OTP_STATUS, bundleStates), new Pair(obj2, iE + "-" + iC));
            PhoenixSharedPreference.Companion.c("cache_manifest_data", jSONObject);
            PhoenixAnalyticsLogger.Companion.a("UPDATE_CACHE_DATA", jSONObject2);
            PhoenixAnalyticsLogger.Companion.a("UPDATE_INSTALLED", jSONObject2);
        }
        String strK = b.k(FileUtil.Companion.i(), "/phoenix");
        File[] fileArrListFiles = new File(strK).listFiles(new a());
        CacheManifest cacheManifestB = PhoenixUtils.Companion.b(PhoenixSharedPreference.Companion.a("cache_temp_manifest_data"));
        Integer numValueOf = cacheManifestB != null ? Integer.valueOf(cacheManifestB.e()) : null;
        Integer numValueOf2 = cacheManifestB != null ? Integer.valueOf(cacheManifestB.c()) : null;
        JSONObject jSONObject3 = new JSONObject();
        int i2 = this.f46131c;
        Pair pair = new Pair("js_version", Integer.valueOf(i2));
        int i3 = this.f46132d;
        PhoenixUtils.Companion.a(jSONObject3, pair, new Pair("bundle_version", Integer.valueOf(i3)), new Pair(obj2, i2 + "-" + i3));
        if (fileArrListFiles != null) {
            Iterator itA = ArrayIteratorKt.a(fileArrListFiles);
            while (itA.hasNext()) {
                File file = (File) itA.next();
                if (Intrinsics.b(file.getName(), i2 + "-" + i3)) {
                    it = itA;
                } else if (cacheManifestB != null) {
                    it = itA;
                    if (!Intrinsics.b(file.getName(), numValueOf + "-" + numValueOf2)) {
                        PhoenixUtils.Companion.a(jSONObject3, new Pair("deleting_path", file.getName()));
                        try {
                            PhoenixAnalyticsLogger.Companion.a("DELETING_OLD_BUNDLES_SUCCESS", jSONObject3);
                            FilesKt.b(file);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            Unit.f53572a.getClass();
                            PhoenixUtils.Companion.a(jSONObject3, new Pair("error", "kotlin.Unit"));
                            PhoenixAnalyticsLogger.Companion.a("DELETING_OLD_BUNDLES_FAILED", jSONObject3);
                            e2.printStackTrace();
                            Intrinsics.checkNotNullParameter("kotlin.Unit", "data");
                        }
                    }
                } else {
                    it = itA;
                    PhoenixUtils.Companion.a(jSONObject3, new Pair("deleting_path", file.getName()));
                    try {
                        PhoenixAnalyticsLogger.Companion.a("DELETING_OLD_BUNDLES_SUCCESS", jSONObject3);
                        FilesKt.b(file);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        Unit.f53572a.getClass();
                        PhoenixUtils.Companion.a(jSONObject3, new Pair("error", "kotlin.Unit"));
                        PhoenixAnalyticsLogger.Companion.a("DELETING_OLD_BUNDLES_FAILED", jSONObject3);
                        e3.printStackTrace();
                        Intrinsics.checkNotNullParameter("kotlin.Unit", "data");
                    }
                }
                itA = it;
            }
        } else {
            System.out.println((Object) b.C("No subdirectories found in ", strK));
        }
        return Unit.f53572a;
    }
}
