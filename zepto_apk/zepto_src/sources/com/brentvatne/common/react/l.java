package com.brentvatne.common.react;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.MediatorLiveData;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15493a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f15494b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15495c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f15496d;

    public /* synthetic */ l(Serializable serializable, Object obj, Object obj2, int i2) {
        this.f15493a = i2;
        this.f15494b = serializable;
        this.f15495c = obj;
        this.f15496d = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object obj2 = this.f15496d;
        Object obj3 = this.f15495c;
        Serializable serializable = this.f15494b;
        switch (this.f15493a) {
            case 0:
                WritableMap dispatch = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                WritableMap writableMapCreateMap = Arguments.createMap();
                StringWriter stringWriter = new StringWriter();
                Exception exc = (Exception) serializable;
                exc.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                writableMapCreateMap.putString("errorString", (String) obj3);
                writableMapCreateMap.putString("errorException", exc.toString());
                writableMapCreateMap.putString(CLConstants.FIELD_ERROR_CODE, (String) obj2);
                writableMapCreateMap.putString("errorStackTrace", string);
                Unit unit = Unit.f53572a;
                dispatch.putMap("error", writableMapCreateMap);
                break;
            default:
                ArchTaskExecutor.a().f1276a.f1278b.execute(new androidx.media3.exoplayer.source.h((Ref.ObjectRef) serializable, (com.chuckerteam.chucker.internal.data.repository.a) obj3, obj, (MediatorLiveData) obj2));
                break;
        }
        return Unit.f53572a;
    }
}
