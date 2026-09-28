package com.zeptoconsumerapp.modules.configservice;

import android.net.Uri;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.JsonSyntaxException;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.modules.base.StorageKeys;
import com.zeptoconsumerapp.modules.base.StorageManager;
import com.zeptoconsumerapp.modules.configservice.entity.ConfigResponse;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.modules.configservice.ConfigService$fetchAndStoreConfig$1", f = "ConfigManager.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class ConfigService$fetchAndStoreConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfigService f47636a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigService$fetchAndStoreConfig$1(ConfigService configService, Continuation continuation) {
        super(2, continuation);
        this.f47636a = configService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ConfigService$fetchAndStoreConfig$1(this.f47636a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ConfigService$fetchAndStoreConfig$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws RuntimeException {
        int i2;
        Throwable th;
        IOException e2;
        JsonSyntaxException e3;
        String str;
        Response responseD;
        ResponseBody responseBody;
        ConfigService configService = this.f47636a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            String string = Uri.parse(BuildConfig.PHOENIX_BASE_URL).buildUpon().encodedPath("Prod/api/v1/config").appendQueryParameter(CLConstants.SALT_FIELD_APP_ID, BuildConfig.ANDROID_PHOENIX_ID).appendQueryParameter("bucket", String.valueOf(((Number) configService.f47633d.getValue()).intValue())).appendQueryParameter("is", String.valueOf(((Boolean) configService.f47635f.getValue()).booleanValue())).appendQueryParameter("iu", String.valueOf(((Boolean) configService.f47634e.getValue()).booleanValue())).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Request.Builder builder = new Request.Builder();
            builder.i(string);
            responseD = OkHttpClientProvider.b().a(builder.b()).d();
            i2 = responseD.f56353d;
        } catch (JsonSyntaxException e4) {
            i2 = -1;
            e3 = e4;
        } catch (IOException e5) {
            i2 = -1;
            e2 = e5;
        } catch (Throwable th2) {
            i2 = -1;
            th = th2;
        }
        try {
            if (responseD.c() && i2 == 200 && (responseBody = responseD.f56356g) != null) {
                str = "success_v2";
                ConfigResponse configResponse = (ConfigResponse) configService.a().d(ConfigResponse.class, StringsKt.b0(responseBody.r()).toString());
                Intrinsics.c(configResponse);
                ResolvedConfigData resolvedConfigDataB = configService.b(configResponse);
                MMKV mmkvA = StorageManager.a();
                StorageKeys[] storageKeysArr = StorageKeys.f47625b;
                mmkvA.putString("FeaturesConfig", configService.a().j(resolvedConfigDataB));
            } else {
                str = "initialized_v2";
            }
        } catch (JsonSyntaxException e6) {
            e3 = e6;
            e3.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e3);
            str = "JsonSyntaxException_v2";
            MMKV mmkvA2 = StorageManager.a();
            StorageKeys[] storageKeysArr2 = StorageKeys.f47625b;
            mmkvA2.encode("configTrace", configService.a().j(MapsKt.h(new Pair(APayConstants.Error.MESSAGE, str), new Pair(CLConstants.OTP_STATUS, String.valueOf(i2)), new Pair("timeTaken", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
            return Unit.f53572a;
        } catch (IOException e7) {
            e2 = e7;
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            str = "IOException_v2";
            MMKV mmkvA22 = StorageManager.a();
            StorageKeys[] storageKeysArr22 = StorageKeys.f47625b;
            mmkvA22.encode("configTrace", configService.a().j(MapsKt.h(new Pair(APayConstants.Error.MESSAGE, str), new Pair(CLConstants.OTP_STATUS, String.valueOf(i2)), new Pair("timeTaken", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
            return Unit.f53572a;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(th);
            str = "Throwable_v2";
            MMKV mmkvA222 = StorageManager.a();
            StorageKeys[] storageKeysArr222 = StorageKeys.f47625b;
            mmkvA222.encode("configTrace", configService.a().j(MapsKt.h(new Pair(APayConstants.Error.MESSAGE, str), new Pair(CLConstants.OTP_STATUS, String.valueOf(i2)), new Pair("timeTaken", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
            return Unit.f53572a;
        }
        MMKV mmkvA2222 = StorageManager.a();
        StorageKeys[] storageKeysArr2222 = StorageKeys.f47625b;
        mmkvA2222.encode("configTrace", configService.a().j(MapsKt.h(new Pair(APayConstants.Error.MESSAGE, str), new Pair(CLConstants.OTP_STATUS, String.valueOf(i2)), new Pair("timeTaken", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
        return Unit.f53572a;
    }
}
