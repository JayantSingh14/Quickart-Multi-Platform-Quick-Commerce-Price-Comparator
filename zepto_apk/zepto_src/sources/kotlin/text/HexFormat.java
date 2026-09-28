package kotlin.text;

import com.google.android.gms.common.api.Api;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
public final class HexFormat {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53969d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final HexFormat f53970e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f53971a;

    /* renamed from: b, reason: collision with root package name */
    public final BytesHexFormat f53972b;

    /* renamed from: c, reason: collision with root package name */
    public final NumberHexFormat f53973c;

    @Metadata
    public static final class Builder {
        @PublishedApi
        public Builder() {
            HexFormat.f53969d.getClass();
            HexFormat.f53970e.getClass();
        }
    }

    @Metadata
    public static final class BytesHexFormat {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Companion f53974a = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final BytesHexFormat f53975b;

        @Metadata
        public static final class Builder {
            public Builder() {
                Companion companion = BytesHexFormat.f53974a;
                companion.getClass();
                BytesHexFormat bytesHexFormat = BytesHexFormat.f53975b;
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
            }
        }

        @Metadata
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            Intrinsics.checkNotNullParameter("  ", "groupSeparator");
            Intrinsics.checkNotNullParameter("", "byteSeparator");
            Intrinsics.checkNotNullParameter("", "bytePrefix");
            Intrinsics.checkNotNullParameter("", "byteSuffix");
            BytesHexFormat bytesHexFormat = new BytesHexFormat();
            if (!HexFormatKt.a("  ") && !HexFormatKt.a("") && !HexFormatKt.a("")) {
                HexFormatKt.a("");
            }
            f53975b = bytesHexFormat;
        }

        public final void a(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append("  ");
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            android.support.v4.media.b.B(sb, indent, "byteSuffix = \"", "", "\"");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(\n");
            a(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    public static final class NumberHexFormat {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Companion f53976a = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final NumberHexFormat f53977b;

        @Metadata
        @SourceDebugExtension
        public static final class Builder {
            public Builder() {
                Companion companion = NumberHexFormat.f53976a;
                companion.getClass();
                NumberHexFormat numberHexFormat = NumberHexFormat.f53977b;
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
            }
        }

        @Metadata
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "suffix");
            NumberHexFormat numberHexFormat = new NumberHexFormat();
            if (!HexFormatKt.a("")) {
                HexFormatKt.a("");
            }
            f53977b = numberHexFormat;
        }

        public final void a(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            android.support.v4.media.b.B(sb, indent, "suffix = \"", "", "\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(false);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(1);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(\n");
            a(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.f53974a;
        companion.getClass();
        BytesHexFormat bytesHexFormat = BytesHexFormat.f53975b;
        NumberHexFormat.Companion companion2 = NumberHexFormat.f53976a;
        companion2.getClass();
        NumberHexFormat numberHexFormat = NumberHexFormat.f53977b;
        f53970e = new HexFormat(false, bytesHexFormat, numberHexFormat);
        companion.getClass();
        companion2.getClass();
        new HexFormat(true, bytesHexFormat, numberHexFormat);
    }

    public HexFormat(boolean z, BytesHexFormat bytes, NumberHexFormat number) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(number, "number");
        this.f53971a = z;
        this.f53972b = bytes;
        this.f53973c = number;
    }

    public final String toString() {
        StringBuilder sbW = android.support.v4.media.b.w("HexFormat(\n    upperCase = ");
        sbW.append(this.f53971a);
        sbW.append(",\n    bytes = BytesHexFormat(\n");
        this.f53972b.a(sbW, "        ");
        sbW.append('\n');
        sbW.append("    ),");
        sbW.append('\n');
        sbW.append("    number = NumberHexFormat(");
        sbW.append('\n');
        this.f53973c.a(sbW, "        ");
        sbW.append('\n');
        sbW.append("    )");
        sbW.append('\n');
        sbW.append(")");
        return sbW.toString();
    }
}
