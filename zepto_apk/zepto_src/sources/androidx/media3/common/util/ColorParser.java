package androidx.media3.common.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class ColorParser {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f5665a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5666b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f5667c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f5668d;

    static {
        HashMap map = new HashMap();
        f5668d = map;
        android.support.v4.media.b.z(-984833, map, "aliceblue", -332841, "antiquewhite");
        androidx.fragment.app.e.x(-8388652, -16711681, "aqua", "aquamarine", map);
        android.support.v4.media.b.z(-983041, map, "azure", -657956, "beige");
        android.support.v4.media.b.z(-6972, map, "bisque", -16777216, "black");
        android.support.v4.media.b.z(-5171, map, "blanchedalmond", -16776961, "blue");
        android.support.v4.media.b.z(-7722014, map, "blueviolet", -5952982, "brown");
        android.support.v4.media.b.z(-2180985, map, "burlywood", -10510688, "cadetblue");
        android.support.v4.media.b.z(-8388864, map, "chartreuse", -2987746, "chocolate");
        android.support.v4.media.b.z(-32944, map, "coral", -10185235, "cornflowerblue");
        android.support.v4.media.b.z(-1828, map, "cornsilk", -2354116, "crimson");
        androidx.fragment.app.e.x(-16777077, -16711681, "cyan", "darkblue", map);
        android.support.v4.media.b.z(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
        androidx.fragment.app.e.x(-16751616, -5658199, "darkgray", "darkgreen", map);
        androidx.fragment.app.e.x(-4343957, -5658199, "darkgrey", "darkkhaki", map);
        android.support.v4.media.b.z(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
        android.support.v4.media.b.z(-29696, map, "darkorange", -6737204, "darkorchid");
        android.support.v4.media.b.z(-7667712, map, "darkred", -1468806, "darksalmon");
        android.support.v4.media.b.z(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
        map.put("darkslategray", -13676721);
        map.put("darkslategrey", -13676721);
        androidx.fragment.app.e.x(-7077677, -16724271, "darkturquoise", "darkviolet", map);
        android.support.v4.media.b.z(-60269, map, "deeppink", -16728065, "deepskyblue");
        map.put("dimgray", -9868951);
        map.put("dimgrey", -9868951);
        androidx.fragment.app.e.x(-5103070, -14774017, "dodgerblue", "firebrick", map);
        android.support.v4.media.b.z(-1296, map, "floralwhite", -14513374, "forestgreen");
        androidx.fragment.app.e.x(-2302756, -65281, "fuchsia", "gainsboro", map);
        android.support.v4.media.b.z(-460545, map, "ghostwhite", -10496, "gold");
        map.put("goldenrod", -2448096);
        map.put("gray", -8355712);
        android.support.v4.media.b.z(-16744448, map, "green", -5374161, "greenyellow");
        androidx.fragment.app.e.x(-983056, -8355712, "grey", "honeydew", map);
        android.support.v4.media.b.z(-38476, map, "hotpink", -3318692, "indianred");
        android.support.v4.media.b.z(-11861886, map, "indigo", -16, "ivory");
        android.support.v4.media.b.z(-989556, map, "khaki", -1644806, "lavender");
        android.support.v4.media.b.z(-3851, map, "lavenderblush", -8586240, "lawngreen");
        android.support.v4.media.b.z(-1331, map, "lemonchiffon", -5383962, "lightblue");
        android.support.v4.media.b.z(-1015680, map, "lightcoral", -2031617, "lightcyan");
        map.put("lightgoldenrodyellow", -329006);
        map.put("lightgray", -2894893);
        map.put("lightgreen", -7278960);
        map.put("lightgrey", -2894893);
        android.support.v4.media.b.z(-18751, map, "lightpink", -24454, "lightsalmon");
        android.support.v4.media.b.z(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
        map.put("lightslategray", -8943463);
        map.put("lightslategrey", -8943463);
        androidx.fragment.app.e.x(-32, -5192482, "lightsteelblue", "lightyellow", map);
        android.support.v4.media.b.z(-16711936, map, "lime", -13447886, "limegreen");
        map.put("linen", -331546);
        map.put("magenta", -65281);
        android.support.v4.media.b.z(-8388608, map, "maroon", -10039894, "mediumaquamarine");
        android.support.v4.media.b.z(-16777011, map, "mediumblue", -4565549, "mediumorchid");
        android.support.v4.media.b.z(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
        android.support.v4.media.b.z(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
        android.support.v4.media.b.z(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
        android.support.v4.media.b.z(-15132304, map, "midnightblue", -655366, "mintcream");
        android.support.v4.media.b.z(-6943, map, "mistyrose", -6987, "moccasin");
        android.support.v4.media.b.z(-8531, map, "navajowhite", -16777088, "navy");
        android.support.v4.media.b.z(-133658, map, "oldlace", -8355840, "olive");
        android.support.v4.media.b.z(-9728477, map, "olivedrab", -23296, "orange");
        android.support.v4.media.b.z(-47872, map, "orangered", -2461482, "orchid");
        android.support.v4.media.b.z(-1120086, map, "palegoldenrod", -6751336, "palegreen");
        android.support.v4.media.b.z(-5247250, map, "paleturquoise", -2396013, "palevioletred");
        android.support.v4.media.b.z(-4139, map, "papayawhip", -9543, "peachpuff");
        android.support.v4.media.b.z(-3308225, map, "peru", -16181, "pink");
        android.support.v4.media.b.z(-2252579, map, "plum", -5185306, "powderblue");
        android.support.v4.media.b.z(-8388480, map, "purple", -10079335, "rebeccapurple");
        android.support.v4.media.b.z(-65536, map, "red", -4419697, "rosybrown");
        android.support.v4.media.b.z(-12490271, map, "royalblue", -7650029, "saddlebrown");
        android.support.v4.media.b.z(-360334, map, "salmon", -744352, "sandybrown");
        android.support.v4.media.b.z(-13726889, map, "seagreen", -2578, "seashell");
        android.support.v4.media.b.z(-6270419, map, "sienna", -4144960, "silver");
        android.support.v4.media.b.z(-7876885, map, "skyblue", -9807155, "slateblue");
        map.put("slategray", -9404272);
        map.put("slategrey", -9404272);
        androidx.fragment.app.e.x(-16711809, -1286, "snow", "springgreen", map);
        android.support.v4.media.b.z(-12156236, map, "steelblue", -2968436, "tan");
        android.support.v4.media.b.z(-16744320, map, "teal", -2572328, "thistle");
        android.support.v4.media.b.z(-40121, map, "tomato", 0, "transparent");
        android.support.v4.media.b.z(-12525360, map, "turquoise", -1146130, "violet");
        android.support.v4.media.b.z(-663885, map, "wheat", -1, "white");
        android.support.v4.media.b.z(-657931, map, "whitesmoke", -256, "yellow");
        map.put("yellowgreen", -6632142);
    }

    public static int a(String str, boolean z) throws NumberFormatException {
        int i2;
        Assertions.a(!TextUtils.isEmpty(str));
        String strReplace = str.replace(StringUtils.SPACE, "");
        if (strReplace.charAt(0) == '#') {
            int i3 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i3;
            }
            if (strReplace.length() == 9) {
                return ((i3 & 255) << 24) | (i3 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith("rgba")) {
            Matcher matcher = (z ? f5667c : f5666b).matcher(strReplace);
            if (matcher.matches()) {
                if (z) {
                    String strGroup = matcher.group(4);
                    strGroup.getClass();
                    i2 = (int) (Float.parseFloat(strGroup) * 255.0f);
                } else {
                    String strGroup2 = matcher.group(4);
                    strGroup2.getClass();
                    i2 = Integer.parseInt(strGroup2, 10);
                }
                String strGroup3 = matcher.group(1);
                strGroup3.getClass();
                int i4 = Integer.parseInt(strGroup3, 10);
                String strGroup4 = matcher.group(2);
                strGroup4.getClass();
                int i5 = Integer.parseInt(strGroup4, 10);
                String strGroup5 = matcher.group(3);
                strGroup5.getClass();
                return Color.argb(i2, i4, i5, Integer.parseInt(strGroup5, 10));
            }
        } else if (strReplace.startsWith("rgb")) {
            Matcher matcher2 = f5665a.matcher(strReplace);
            if (matcher2.matches()) {
                String strGroup6 = matcher2.group(1);
                strGroup6.getClass();
                int i6 = Integer.parseInt(strGroup6, 10);
                String strGroup7 = matcher2.group(2);
                strGroup7.getClass();
                int i7 = Integer.parseInt(strGroup7, 10);
                String strGroup8 = matcher2.group(3);
                strGroup8.getClass();
                return Color.rgb(i6, i7, Integer.parseInt(strGroup8, 10));
            }
        } else {
            Integer num = (Integer) f5668d.get(Ascii.b(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
