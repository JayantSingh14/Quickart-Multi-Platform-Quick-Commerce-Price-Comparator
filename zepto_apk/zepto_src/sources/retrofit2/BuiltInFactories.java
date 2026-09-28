package retrofit2;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class BuiltInFactories {

    @TargetApi(24)
    public static final class Java8 extends BuiltInFactories {
        @Override // retrofit2.BuiltInFactories
        public final List a(Executor executor) {
            return Arrays.asList(new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(executor));
        }

        @Override // retrofit2.BuiltInFactories
        public final List b() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }

    public List a(Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    public List b() {
        return Collections.EMPTY_LIST;
    }
}
