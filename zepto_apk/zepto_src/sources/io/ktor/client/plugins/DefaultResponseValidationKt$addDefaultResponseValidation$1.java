package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.xbill.DNS.Type;

@Metadata
/* loaded from: classes.dex */
final class DefaultResponseValidationKt$addDefaultResponseValidation$1 extends Lambda implements Function1<HttpCallValidator.Config, Unit> {

    @Metadata
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {42, Type.DNSKEY}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public HttpResponse f49466a;

        /* renamed from: b, reason: collision with root package name */
        public int f49467b;

        /* renamed from: c, reason: collision with root package name */
        public int f49468c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f49469d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(2, continuation);
            anonymousClass1.f49469d = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((HttpResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(1:(1:(8:6|56|7|30|34|(2:39|(1:(1:48)(1:47))(1:43))(1:38)|49|50)(2:9|10))(1:11))(2:12|(2:14|15)(2:16|(2:51|52)(3:21|(1:24)|28)))|25|54|26|(6:29|30|34|(2:39|(1:(2:45|48)(0))(0))(0)|49|50)|28|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        
            r0 = r1;
            r3 = r4;
            r1 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c6 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        HttpCallValidator.Config HttpResponseValidator = (HttpCallValidator.Config) obj;
        Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
        HttpResponseValidator.f49518c = false;
        AnonymousClass1 block = new AnonymousClass1(2, null);
        Intrinsics.checkNotNullParameter(block, "block");
        HttpResponseValidator.f49516a.add(block);
        return Unit.f53572a;
    }
}
