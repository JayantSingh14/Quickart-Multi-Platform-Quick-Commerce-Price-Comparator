package com.phoenix;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixBundleList;
import com.phoenix.PhoenixLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@DebugMetadata(c = "com.phoenix.PhoenixBundleList$Companion$getBundleList$1", f = "PhoenixBundleList.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
final class PhoenixBundleList$Companion$getBundleList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46121a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f46122b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoenixBundleList$Companion$getBundleList$1(int i2, Promise promise, Continuation continuation) {
        super(2, continuation);
        this.f46121a = i2;
        this.f46122b = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PhoenixBundleList$Companion$getBundleList$1(this.f46121a, this.f46122b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PhoenixBundleList$Companion$getBundleList$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<BundleListItem> listA;
        Promise promise = this.f46122b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        try {
            String strA = PhoenixBundleList.Companion.a(this.f46121a);
            if (strA != null) {
                BundleListResponseData bundleListResponseDataA = ((BundleListResponse) Phoenix.Companion.c().d(BundleListResponse.class, strA)).a();
                if (bundleListResponseDataA == null || (listA = bundleListResponseDataA.a()) == null) {
                    listA = EmptyList.f53609a;
                }
                WritableArray writableArrayCreateArray = Arguments.createArray();
                for (BundleListItem bundleListItem : listA) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    String strA2 = bundleListItem.a();
                    if (strA2 != null) {
                        writableMapCreateMap.putString(CLConstants.SALT_FIELD_APP_ID, strA2);
                    }
                    String strB = bundleListItem.b();
                    if (strB != null) {
                        writableMapCreateMap.putString("appVersion", strB);
                    }
                    Integer numD = bundleListItem.d();
                    if (numD != null) {
                        writableMapCreateMap.putInt("bundleVersion", numD.intValue());
                    }
                    String strE = bundleListItem.e();
                    if (strE != null) {
                        writableMapCreateMap.putString("createdAt", strE);
                    }
                    Boolean boolF = bundleListItem.f();
                    if (boolF != null) {
                        writableMapCreateMap.putBoolean("defaultRelease", boolF.booleanValue());
                    }
                    String strG = bundleListItem.g();
                    if (strG != null) {
                        writableMapCreateMap.putString("description", strG);
                    }
                    String strH = bundleListItem.h();
                    if (strH != null) {
                        writableMapCreateMap.putString("hash", strH);
                    }
                    Integer numI = bundleListItem.i();
                    if (numI != null) {
                        writableMapCreateMap.putInt("jsVersion", numI.intValue());
                    }
                    Boolean boolJ = bundleListItem.j();
                    if (boolJ != null) {
                        writableMapCreateMap.putBoolean("nativeRelease", boolJ.booleanValue());
                    }
                    Integer numK = bundleListItem.k();
                    if (numK != null) {
                        writableMapCreateMap.putInt("releaseState", numK.intValue());
                    }
                    String strL = bundleListItem.l();
                    if (strL != null) {
                        writableMapCreateMap.putString("releaseVersion", strL);
                    }
                    Integer numM = bundleListItem.m();
                    if (numM != null) {
                        writableMapCreateMap.putInt("rollout", numM.intValue());
                    }
                    String strN = bundleListItem.n();
                    if (strN != null) {
                        writableMapCreateMap.putString("updatedAt", strN);
                    }
                    BundleInfo bundleInfoC = bundleListItem.c();
                    if (bundleInfoC != null) {
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        if (bundleInfoC.a() != null) {
                            writableMapCreateMap2.putDouble("size", r5.longValue());
                        }
                        String strB2 = bundleInfoC.b();
                        if (strB2 != null) {
                            writableMapCreateMap2.putString("url", strB2);
                        }
                        writableMapCreateMap.putMap("bundle", writableMapCreateMap2);
                    }
                    writableArrayCreateArray.pushMap(writableMapCreateMap);
                }
                promise.resolve(writableArrayCreateArray);
            } else {
                promise.resolve(Arguments.createArray());
            }
        } catch (Exception e2) {
            PhoenixLogger.Companion.a("Exception in getBundleList: " + e2.getMessage());
            promise.reject(e2);
        }
        return Unit.f53572a;
    }
}
