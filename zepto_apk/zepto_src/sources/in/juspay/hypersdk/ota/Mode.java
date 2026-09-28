package in.juspay.hypersdk.ota;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public interface Mode {

    @Metadata
    public static final class Beta implements Mode {

        @NotNull
        public static final Beta INSTANCE = new Beta();

        private Beta() {
        }
    }

    @Metadata
    public static final class CUG implements Mode {

        @NotNull
        public static final CUG INSTANCE = new CUG();

        private CUG() {
        }
    }

    @Metadata
    public static final class DevQa implements Mode {

        @NotNull
        private final String ticket;

        public DevQa(@NotNull String ticket) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            this.ticket = ticket;
        }

        public static /* synthetic */ DevQa copy$default(DevQa devQa, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = devQa.ticket;
            }
            return devQa.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.ticket;
        }

        @NotNull
        public final DevQa copy(@NotNull String ticket) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            return new DevQa(ticket);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DevQa) && Intrinsics.b(this.ticket, ((DevQa) obj).ticket);
        }

        @NotNull
        public final String getTicket() {
            return this.ticket;
        }

        public int hashCode() {
            return this.ticket.hashCode();
        }

        @NotNull
        public String toString() {
            return e.t(new StringBuilder("DevQa(ticket="), this.ticket, ')');
        }
    }

    @Metadata
    public static final class Release implements Mode {

        @NotNull
        public static final Release INSTANCE = new Release();

        private Release() {
        }
    }
}
