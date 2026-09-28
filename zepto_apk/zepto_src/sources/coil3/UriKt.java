package coil3;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class UriKt {
    @NotNull
    public static final Uri Uri(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6) {
        if (str == null && str2 == null && str3 == null && str4 == null && str5 == null) {
            throw new IllegalArgumentException("At least one of scheme, authority, path, query, or fragment must be non-null.");
        }
        return new Uri(buildData(str, str2, str3, str4, str5), str6, str, str2, str3, str4, str5);
    }

    public static /* synthetic */ Uri Uri$default(String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        if ((i2 & 32) != 0) {
            str6 = Path.f56972b;
        }
        return Uri(str, str2, str3, str4, str5, str6);
    }

    private static final String buildData(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        if (str2 != null) {
            sb.append("//");
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Nullable
    public static final String getFilePath(@NotNull Uri uri) {
        List<String> pathSegments = getPathSegments(uri);
        if (pathSegments.isEmpty()) {
            return null;
        }
        String path = uri.getPath();
        Intrinsics.c(path);
        return CollectionsKt.E(pathSegments, uri.getSeparator(), StringsKt.O(path, uri.getSeparator(), false) ? uri.getSeparator() : "", null, null, 60);
    }

    private static final int getLength(String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    @NotNull
    public static final List<String> getPathSegments(@NotNull Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return EmptyList.f53609a;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        while (i2 < path.length()) {
            int i3 = i2 + 1;
            int iW = StringsKt.w(path, '/', i3, 4);
            if (iW == -1) {
                iW = path.length();
            }
            String strSubstring = path.substring(i3, iW);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (strSubstring.length() > 0) {
                arrayList.add(strSubstring);
            }
            i2 = iW;
        }
        return arrayList;
    }

    private static final Uri parseUri(String str, String str2, String str3) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        String strSubstring5;
        boolean z = true;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '#') {
                if (cCharAt != '/') {
                    if (cCharAt != ':') {
                        if (cCharAt == '?' && i4 == -1 && i2 == -1) {
                            i4 = i7 + 1;
                        }
                    } else if (z && i4 == -1 && i2 == -1) {
                        int i8 = i7 + 2;
                        if (i8 < str2.length() && str2.charAt(i7 + 1) == '/' && str2.charAt(i8) == '/') {
                            i5 = i7 + 3;
                            z = false;
                            i6 = i7;
                            i7 = i8;
                        } else if (str.equals(str2)) {
                            i3 = i7 + 1;
                            i6 = i7;
                            i7 = i3;
                            i5 = i7;
                        }
                    }
                } else if (i3 == -1 && i4 == -1 && i2 == -1) {
                    i3 = i5 == -1 ? 0 : i7;
                    z = false;
                }
            } else if (i2 == -1) {
                i2 = i7 + 1;
            }
            i7++;
        }
        int i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(i2 == -1 ? Integer.MAX_VALUE : i2 - 1, str.length());
        int iMin2 = Math.min(i4 == -1 ? Integer.MAX_VALUE : i4 - 1, iMin);
        if (i5 != -1) {
            strSubstring2 = str.substring(0, i6);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            if (i3 != -1) {
                i9 = i3;
            }
            strSubstring = str.substring(i5, Math.min(i9, iMin2));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = null;
            strSubstring2 = null;
        }
        if (i3 != -1) {
            strSubstring3 = str.substring(i3, iMin2);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        } else {
            strSubstring3 = null;
        }
        if (i4 != -1) {
            strSubstring4 = str.substring(i4, iMin);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        } else {
            strSubstring4 = null;
        }
        if (i2 != -1) {
            strSubstring5 = str.substring(i2, str.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
        } else {
            strSubstring5 = null;
        }
        byte[] bArr = new byte[Math.max(0, Math.max(getLength(strSubstring2), Math.max(getLength(strSubstring), Math.max(getLength(strSubstring3), Math.max(getLength(strSubstring4), getLength(strSubstring5))))) - 2)];
        return new Uri(str, str3, strSubstring2 != null ? percentDecode(strSubstring2, bArr) : null, strSubstring != null ? percentDecode(strSubstring, bArr) : null, strSubstring3 != null ? percentDecode(strSubstring3, bArr) : null, strSubstring4 != null ? percentDecode(strSubstring4, bArr) : null, strSubstring5 != null ? percentDecode(strSubstring5, bArr) : null);
    }

    private static final String percentDecode(String str, byte[] bArr) {
        int length = str.length();
        int iMax = Math.max(0, length - 2);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= iMax) {
                if (i2 == i3) {
                    return str;
                }
                if (i2 >= length) {
                    Intrinsics.checkNotNullParameter(bArr, "<this>");
                    AbstractList.Companion companion = AbstractList.f53584a;
                    int length2 = bArr.length;
                    companion.getClass();
                    AbstractList.Companion.a(0, i3, length2);
                    return new String(bArr, 0, i3, Charsets.UTF_8);
                }
            } else if (str.charAt(i2) == '%') {
                int i4 = i2 + 3;
                try {
                    String strSubstring = str.substring(i2 + 1, i4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    bArr[i3] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
                    i3++;
                    i2 = i4;
                } catch (NumberFormatException unused) {
                }
            }
            bArr[i3] = (byte) str.charAt(i2);
            i3++;
            i2++;
        }
    }

    @JvmOverloads
    @NotNull
    public static final Uri toUri(@NotNull String str) {
        return toUri$default(str, null, 1, null);
    }

    public static /* synthetic */ Uri toUri$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = Path.f56972b;
        }
        return toUri(str, str2);
    }

    @JvmOverloads
    @NotNull
    public static final Uri toUri(@NotNull String str, @NotNull String str2) {
        return parseUri(!Intrinsics.b(str2, "/") ? StringsKt.K(str, str2, "/") : str, str, str2);
    }
}
