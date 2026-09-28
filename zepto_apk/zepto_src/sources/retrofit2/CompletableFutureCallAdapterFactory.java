package retrofit2;

import android.annotation.TargetApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes.dex */
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {

    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f58082a;

        @IgnoreJRERequirement
        public class BodyCallback implements Callback<R> {

            /* renamed from: a, reason: collision with root package name */
            public final CompletableFuture f58083a;

            public BodyCallback(CompletableFuture completableFuture) {
                this.f58083a = completableFuture;
            }

            @Override // retrofit2.Callback
            public final void a(Call call, Throwable th) {
                this.f58083a.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public final void b(Call call, Response response) {
                boolean zC = response.f58224a.c();
                CompletableFuture completableFuture = this.f58083a;
                if (zC) {
                    completableFuture.complete(response.f58225b);
                } else {
                    completableFuture.completeExceptionally(new HttpException(response));
                }
            }
        }

        public BodyCallAdapter(Type type) {
            this.f58082a = type;
        }

        @Override // retrofit2.CallAdapter
        public final Type a() {
            return this.f58082a;
        }

        @Override // retrofit2.CallAdapter
        public final Object b(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            ((OkHttpCall) call).N(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Call f58084a;

        public CallCancelCompletableFuture(Call call) {
            this.f58084a = call;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            if (z) {
                this.f58084a.cancel();
            }
            return super.cancel(z);
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f58085a;

        @IgnoreJRERequirement
        public class ResponseCallback implements Callback<R> {

            /* renamed from: a, reason: collision with root package name */
            public final CompletableFuture f58086a;

            public ResponseCallback(CompletableFuture completableFuture) {
                this.f58086a = completableFuture;
            }

            @Override // retrofit2.Callback
            public final void a(Call call, Throwable th) {
                this.f58086a.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public final void b(Call call, Response response) {
                this.f58086a.complete(response);
            }
        }

        public ResponseCallAdapter(Type type) {
            this.f58085a = type;
        }

        @Override // retrofit2.CallAdapter
        public final Type a() {
            return this.f58085a;
        }

        @Override // retrofit2.CallAdapter
        public final Object b(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            ((OkHttpCall) call).N(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    public final CallAdapter a(Type type, Annotation[] annotationArr) {
        if (Utils.e(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeD = Utils.d(0, (ParameterizedType) type);
        if (Utils.e(typeD) != Response.class) {
            return new BodyCallAdapter(typeD);
        }
        if (typeD instanceof ParameterizedType) {
            return new ResponseCallAdapter(Utils.d(0, (ParameterizedType) typeD));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
