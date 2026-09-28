package com.reactnativedocumentpicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.truecaller.android.sdk.common.TrueException;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1", f = "FileOperations.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableMap>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f46350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f46351b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileOperations f46352c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f46353d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ File f46354e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(ReadableArray readableArray, int i2, FileOperations fileOperations, ReactApplicationContext reactApplicationContext, File file, Continuation continuation) {
        super(2, continuation);
        this.f46350a = readableArray;
        this.f46351b = i2;
        this.f46352c = fileOperations;
        this.f46353d = reactApplicationContext;
        this.f46354e = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        File file = this.f46354e;
        return new FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(this.f46350a, this.f46351b, this.f46352c, this.f46353d, file, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableArray readableArray = this.f46350a;
        int i2 = this.f46351b;
        ReadableMap map = readableArray.getMap(i2);
        try {
            if (map != null) {
                writableMapCreateMap.merge(FileOperations.a(this.f46352c, map, this.f46353d, this.f46354e));
                return writableMapCreateMap;
            }
            throw new IllegalArgumentException("keepLocalCopy: The file argument is null at index " + i2);
        } catch (Exception e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null && (localizedMessage = e2.getMessage()) == null) {
                localizedMessage = TrueException.TYPE_UNKNOWN_MESSAGE;
            }
            writableMapCreateMap.putString(CLConstants.OTP_STATUS, "error");
            writableMapCreateMap.putString("copyError", localizedMessage);
            writableMapCreateMap.putString("sourceUri", map != null ? map.getString("uri") : null);
            return writableMapCreateMap;
        }
    }
}
