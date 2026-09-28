package com.chuckerteam.chucker.internal.ui;

import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.support.HarUtils;
import com.chuckerteam.chucker.internal.support.TransactionListDetailsSharable;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import java.io.ByteArrayInputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import okio.Okio;
import okio.Source;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$2", f = "MainActivity.kt", l = {356}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$prepareDataToSave$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Source>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16882a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity.ExportType f16883b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f16884c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16885d;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[MainActivity.ExportType.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MainActivity.ExportType exportType = MainActivity.ExportType.f16856a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$prepareDataToSave$2(MainActivity.ExportType exportType, List list, MainActivity mainActivity, Continuation continuation) {
        super(2, continuation);
        this.f16883b = exportType;
        this.f16884c = list;
        this.f16885d = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$prepareDataToSave$2(this.f16883b, this.f16884c, this.f16885d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$prepareDataToSave$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16882a;
        if (i2 == 0) {
            ResultKt.b(obj);
            int iOrdinal = this.f16883b.ordinal();
            List list = this.f16884c;
            MainActivity mainActivity = this.f16885d;
            if (iOrdinal == 0) {
                return new TransactionListDetailsSharable(list).a(mainActivity);
            }
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            HarUtils harUtils = HarUtils.f16765a;
            String string = mainActivity.getString(R.string.chucker_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = mainActivity.getString(R.string.chucker_version);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.f16882a = 1;
            obj = harUtils.a(list, string, string2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Okio.d(Okio.m(new ByteArrayInputStream(bytes)));
    }
}
