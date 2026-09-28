package retrofit2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;

/* loaded from: classes.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    public final RequestFactory f58095a;

    /* renamed from: b, reason: collision with root package name */
    public final Call.Factory f58096b;

    /* renamed from: c, reason: collision with root package name */
    public final Converter f58097c;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        public final CallAdapter f58098d;

        public CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter) {
            super(requestFactory, factory, converter);
            this.f58098d = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object c(Call call, Object[] objArr) {
            return this.f58098d.b(call);
        }
    }

    /* loaded from: classes5.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final CallAdapter f58099d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f58100e;

        public SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter, boolean z) {
            super(requestFactory, factory, converter);
            this.f58099d = callAdapter;
            this.f58100e = z;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object c(Call call, Object[] objArr) {
            Call call2 = (Call) this.f58099d.b(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (!this.f58100e) {
                    return KotlinExtensions.a(call2, continuation);
                }
                Intrinsics.d(call2, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
                return KotlinExtensions.b(call2, continuation);
            } catch (LinkageError e2) {
                throw e2;
            } catch (ThreadDeath e3) {
                throw e3;
            } catch (VirtualMachineError e4) {
                throw e4;
            } catch (Throwable th) {
                KotlinExtensions.c(th, continuation);
                return CoroutineSingletons.f53689a;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final CallAdapter f58101d;

        public SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter) {
            super(requestFactory, factory, converter);
            this.f58101d = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object c(Call call, Object[] objArr) throws Throwable {
            final Call call2 = (Call) this.f58101d.b(call);
            Continuation frame = (Continuation) objArr[objArr.length - 1];
            try {
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
                cancellableContinuationImpl.s();
                cancellableContinuationImpl.u(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        call2.cancel();
                        return Unit.f53572a;
                    }
                });
                call2.N(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
                    @Override // retrofit2.Callback
                    public final void a(Call call3, Throwable t) {
                        Intrinsics.checkNotNullParameter(call3, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Result.Companion companion = Result.f53538b;
                        cancellableContinuationImpl.resumeWith(ResultKt.a(t));
                    }

                    @Override // retrofit2.Callback
                    public final void b(Call call3, Response response) {
                        Intrinsics.checkNotNullParameter(call3, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        Result.Companion companion = Result.f53538b;
                        cancellableContinuationImpl.resumeWith(response);
                    }
                });
                Object objR = cancellableContinuationImpl.r();
                if (objR == CoroutineSingletons.f53689a) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                }
                return objR;
            } catch (Exception e2) {
                KotlinExtensions.c(e2, frame);
                return CoroutineSingletons.f53689a;
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter converter) {
        this.f58095a = requestFactory;
        this.f58096b = factory;
        this.f58097c = converter;
    }

    @Override // retrofit2.ServiceMethod
    public final Object a(Object[] objArr, Object obj) {
        return c(new OkHttpCall(this.f58095a, obj, objArr, this.f58096b, this.f58097c), objArr);
    }

    public abstract Object c(Call call, Object[] objArr);
}
