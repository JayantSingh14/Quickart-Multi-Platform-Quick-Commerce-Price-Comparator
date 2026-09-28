package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f58087a;

    public static final class ExecutorCallbackCall<T> implements Call<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f58090a;

        /* renamed from: b, reason: collision with root package name */
        public final Call f58091b;

        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<Object> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callback f58092a;

            public AnonymousClass1(Callback callback) {
                this.f58092a = callback;
            }

            @Override // retrofit2.Callback
            public final void a(Call call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.f58090a;
                final Callback callback = this.f58092a;
                executor.execute(new Runnable() { // from class: retrofit2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.a(DefaultCallAdapterFactory.ExecutorCallbackCall.this, th);
                    }
                });
            }

            @Override // retrofit2.Callback
            public final void b(Call call, final Response response) {
                Executor executor = ExecutorCallbackCall.this.f58090a;
                final Callback callback = this.f58092a;
                executor.execute(new Runnable() { // from class: retrofit2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall executorCallbackCall = DefaultCallAdapterFactory.ExecutorCallbackCall.this;
                        boolean zS = executorCallbackCall.f58091b.s();
                        Callback callback2 = callback;
                        if (zS) {
                            callback2.a(executorCallbackCall, new IOException("Canceled"));
                        } else {
                            callback2.b(executorCallbackCall, response);
                        }
                    }
                });
            }
        }

        public ExecutorCallbackCall(Executor executor, Call call) {
            this.f58090a = executor;
            this.f58091b = call;
        }

        @Override // retrofit2.Call
        public final void N(Callback callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.f58091b.N(new AnonymousClass1(callback));
        }

        @Override // retrofit2.Call
        public final void cancel() {
            this.f58091b.cancel();
        }

        @Override // retrofit2.Call
        public final Request r() {
            return this.f58091b.r();
        }

        @Override // retrofit2.Call
        public final boolean s() {
            return this.f58091b.s();
        }

        @Override // retrofit2.Call
        public final Call clone() {
            return new ExecutorCallbackCall(this.f58090a, this.f58091b.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.f58087a = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    public final CallAdapter a(Type type, Annotation[] annotationArr) {
        if (Utils.e(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type typeD = Utils.d(0, (ParameterizedType) type);
        final Executor executor = Utils.h(annotationArr, SkipCallbackExecutor.class) ? null : this.f58087a;
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            public final Type a() {
                return typeD;
            }

            @Override // retrofit2.CallAdapter
            public final Object b(Call call) {
                Executor executor2 = executor;
                return executor2 == null ? call : new ExecutorCallbackCall(executor2, call);
            }
        };
    }
}
