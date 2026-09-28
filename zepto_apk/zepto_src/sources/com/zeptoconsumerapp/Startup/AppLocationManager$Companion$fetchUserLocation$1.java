package com.zeptoconsumerapp.Startup;

import android.content.Context;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.zeptoconsumerapp.FusedLocation.FusedLocationMain;
import com.zeptoconsumerapp.FusedLocation.FusedLocationModule;
import com.zeptoconsumerapp.FusedLocation.LocationStatusTypes;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.apiprefetch.factory.ApiPrefetchModule;
import com.zeptoconsumerapp.apiprefetch.factory.ApiPrefetchModuleFactory;
import com.zeptoconsumerapp.apiprefetch.homepage.HomePageOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.Startup.AppLocationManager$Companion$fetchUserLocation$1", f = "AppLocationManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AppLocationManager$Companion$fetchUserLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f47552a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLocationManager$Companion$fetchUserLocation$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f47552a = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppLocationManager$Companion$fetchUserLocation$1(this.f47552a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AppLocationManager$Companion$fetchUserLocation$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        try {
            Context context = this.f47552a;
            if (context != null) {
                LocationStatusTypes locationStatusTypes = FusedLocationMain.f47427a;
                LocationStatusTypes locationStatusTypes2 = LocationStatusTypes.f47480d;
                if (locationStatusTypes == locationStatusTypes2) {
                    FusedLocationModule fusedLocationModule = new FusedLocationModule(context);
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putDouble("maximumAge", 900000.0d);
                    writableMapCreateMap.putInt("timeout", 15000);
                    writableMapCreateMap.putBoolean("enableHighAccuracy", false);
                    fusedLocationModule.b(writableMapCreateMap);
                }
                if (Utils.d(context).booleanValue()) {
                    LocationStatusTypes locationStatusTypes3 = FusedLocationMain.f47427a;
                    Timber.a("PREFETCHLOGIC location status %s", locationStatusTypes3);
                    if (locationStatusTypes3 != locationStatusTypes2) {
                        ApiPrefetchModule apiPrefetchModule = ApiPrefetchModule.f47585a;
                        ApiPrefetchModuleFactory.b(new HomePageOptions(ApiPrefetchModuleFactory.a(), null, null, false)).b();
                    }
                }
            }
        } catch (Exception e2) {
            Utils.i(e2);
        }
        return Unit.f53572a;
    }
}
