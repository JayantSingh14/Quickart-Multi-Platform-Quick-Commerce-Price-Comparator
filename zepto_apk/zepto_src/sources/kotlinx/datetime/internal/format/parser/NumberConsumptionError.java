package kotlinx.datetime.internal.format.parser;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public interface NumberConsumptionError {

    @Metadata
    public static final class Conflicting implements NumberConsumptionError {

        /* renamed from: a, reason: collision with root package name */
        public final Object f55588a;

        public Conflicting(Object conflicting) {
            Intrinsics.checkNotNullParameter(conflicting, "conflicting");
            this.f55588a = conflicting;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public final String a() {
            return "attempted to overwrite the existing value '" + this.f55588a + '\'';
        }
    }

    @Metadata
    public static final class ExpectedInt implements NumberConsumptionError {

        /* renamed from: a, reason: collision with root package name */
        public static final ExpectedInt f55589a = new ExpectedInt();

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public final String a() {
            return "expected an Int value";
        }
    }

    @Metadata
    public static final class TooFewDigits implements NumberConsumptionError {

        /* renamed from: a, reason: collision with root package name */
        public final int f55590a;

        public TooFewDigits(int i2) {
            this.f55590a = i2;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public final String a() {
            return b.o(new StringBuilder("expected at least "), this.f55590a, " digits");
        }
    }

    @Metadata
    public static final class TooManyDigits implements NumberConsumptionError {

        /* renamed from: a, reason: collision with root package name */
        public final int f55591a;

        public TooManyDigits(int i2) {
            this.f55591a = i2;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public final String a() {
            return b.o(new StringBuilder("expected at most "), this.f55591a, " digits");
        }
    }

    @Metadata
    public static final class WrongConstant implements NumberConsumptionError {

        /* renamed from: a, reason: collision with root package name */
        public final String f55592a;

        public WrongConstant(String expected) {
            Intrinsics.checkNotNullParameter(expected, "expected");
            this.f55592a = expected;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public final String a() {
            return e.t(new StringBuilder("expected '"), this.f55592a, '\'');
        }
    }

    String a();
}
