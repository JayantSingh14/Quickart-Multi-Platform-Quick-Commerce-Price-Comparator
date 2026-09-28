package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* loaded from: classes.dex */
public interface Operation {

    /* renamed from: a, reason: collision with root package name */
    public static final State.SUCCESS f12544a = new State.SUCCESS();

    /* renamed from: b, reason: collision with root package name */
    public static final State.IN_PROGRESS f12545b = new State.IN_PROGRESS();

    public static abstract class State {

        public static final class FAILURE extends State {

            /* renamed from: a, reason: collision with root package name */
            public final Throwable f12546a;

            public FAILURE(Throwable th) {
                this.f12546a = th;
            }

            public final String toString() {
                return "FAILURE (" + this.f12546a.getMessage() + ")";
            }
        }

        public static final class IN_PROGRESS extends State {
            public final String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class SUCCESS extends State {
            public final String toString() {
                return MerchantConstants.SUCCESS;
            }
        }
    }

    SettableFuture a();
}
