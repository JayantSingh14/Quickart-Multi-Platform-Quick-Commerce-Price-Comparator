package com.google.common.net;

import androidx.media3.exoplayer.analytics.p;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MediaType {

    /* renamed from: f, reason: collision with root package name */
    public static final ImmutableListMultimap f43271f;

    /* renamed from: g, reason: collision with root package name */
    public static final CharMatcher f43272g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f43273h;

    /* renamed from: i, reason: collision with root package name */
    public static final Joiner.MapJoiner f43274i;

    /* renamed from: a, reason: collision with root package name */
    public final String f43275a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43276b;

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableListMultimap f43277c;

    /* renamed from: d, reason: collision with root package name */
    public String f43278d;

    /* renamed from: e, reason: collision with root package name */
    public int f43279e;

    public static final class Tokenizer {
    }

    static {
        String strB = Ascii.b(Charsets.f42260c.name());
        ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
        builder.b("charset", strB);
        f43271f = builder.a();
        f43272g = CharMatcher.e().b(CharMatcher.l().p()).b(CharMatcher.k()).b(CharMatcher.c("()<>@,;:\\\"/[]?=").p());
        CharMatcher.e().b(CharMatcher.c("\"\\\r").p());
        CharMatcher.c(" \t\r\n");
        f43273h = new HashMap();
        a("*", "*");
        a("text", "*");
        a("image", "*");
        a("audio", "*");
        a("video", "*");
        a("application", "*");
        a("font", "*");
        b("text", "cache-manifest");
        b("text", "css");
        b("text", "csv");
        b("text", "html");
        b("text", "calendar");
        b("text", "plain");
        b("text", "javascript");
        b("text", "tab-separated-values");
        b("text", "vcard");
        b("text", "vnd.wap.wml");
        b("text", "xml");
        b("text", "vtt");
        a("image", "bmp");
        a("image", "x-canon-crw");
        a("image", "gif");
        a("image", "vnd.microsoft.icon");
        a("image", "jpeg");
        a("image", "png");
        a("image", "vnd.adobe.photoshop");
        b("image", "svg+xml");
        a("image", "tiff");
        a("image", "webp");
        a("image", "heif");
        a("image", "jp2");
        a("audio", "mp4");
        a("audio", "mpeg");
        a("audio", "ogg");
        a("audio", "webm");
        a("audio", "l16");
        a("audio", "l24");
        a("audio", "basic");
        a("audio", "aac");
        a("audio", "vorbis");
        a("audio", "x-ms-wma");
        a("audio", "x-ms-wax");
        a("audio", "vnd.rn-realaudio");
        a("audio", "vnd.wave");
        a("video", "mp4");
        a("video", "mpeg");
        a("video", "ogg");
        a("video", "quicktime");
        a("video", "webm");
        a("video", "x-ms-wmv");
        a("video", "x-flv");
        a("video", "3gpp");
        a("video", "3gpp2");
        b("application", "xml");
        b("application", "atom+xml");
        a("application", "x-bzip2");
        b("application", "dart");
        a("application", "vnd.apple.pkpass");
        a("application", "vnd.ms-fontobject");
        a("application", "epub+zip");
        a("application", "x-www-form-urlencoded");
        a("application", "pkcs12");
        a("application", "binary");
        a("application", "geo+json");
        a("application", "x-gzip");
        a("application", "hal+json");
        b("application", "javascript");
        a("application", "jose");
        a("application", "jose+json");
        b("application", "json");
        a("application", "jwt");
        b("application", "manifest+json");
        a("application", "vnd.google-earth.kml+xml");
        a("application", "vnd.google-earth.kmz");
        a("application", "mbox");
        a("application", "x-apple-aspen-config");
        a("application", "vnd.ms-excel");
        a("application", "vnd.ms-outlook");
        a("application", "vnd.ms-powerpoint");
        a("application", "msword");
        a("application", "dash+xml");
        a("application", "wasm");
        a("application", "x-nacl");
        a("application", "x-pnacl");
        a("application", "octet-stream");
        a("application", "ogg");
        a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
        a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
        a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        a("application", "vnd.oasis.opendocument.graphics");
        a("application", "vnd.oasis.opendocument.presentation");
        a("application", "vnd.oasis.opendocument.spreadsheet");
        a("application", "vnd.oasis.opendocument.text");
        b("application", "opensearchdescription+xml");
        a("application", "pdf");
        a("application", "postscript");
        a("application", "protobuf");
        b("application", "rdf+xml");
        b("application", "rtf");
        a("application", "font-sfnt");
        a("application", "x-shockwave-flash");
        a("application", "vnd.sketchup.skp");
        b("application", "soap+xml");
        a("application", "x-tar");
        a("application", "font-woff");
        a("application", "font-woff2");
        b("application", "xhtml+xml");
        b("application", "xrd+xml");
        a("application", "zip");
        a("font", "collection");
        a("font", "otf");
        a("font", "sfnt");
        a("font", "ttf");
        a("font", "woff");
        a("font", "woff2");
        f43274i = new Joiner.MapJoiner(new Joiner("; "));
    }

    public MediaType(String str, String str2, ImmutableListMultimap immutableListMultimap) {
        this.f43275a = str;
        this.f43276b = str2;
        this.f43277c = immutableListMultimap;
    }

    public static void a(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, ImmutableListMultimap.o());
        f43273h.put(mediaType, mediaType);
    }

    public static void b(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, f43271f);
        f43273h.put(mediaType, mediaType);
        Optional.d(Charsets.f42260c);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        if (this.f43275a.equals(mediaType.f43275a) && this.f43276b.equals(mediaType.f43276b)) {
            return ((AbstractMap) Maps.j(this.f43277c.asMap(), new a(0))).equals(Maps.j(mediaType.f43277c.asMap(), new a(0)));
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f43279e;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(new Object[]{this.f43275a, this.f43276b, Maps.j(this.f43277c.asMap(), new a(0))});
        this.f43279e = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String str = this.f43278d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43275a);
        sb.append('/');
        sb.append(this.f43276b);
        ImmutableListMultimap immutableListMultimap = this.f43277c;
        if (!immutableListMultimap.isEmpty()) {
            sb.append("; ");
            Collection collectionD = Multimaps.a(immutableListMultimap, new p(29)).d();
            Joiner.MapJoiner mapJoiner = f43274i;
            mapJoiner.getClass();
            try {
                mapJoiner.a(collectionD.iterator(), sb);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
        String string = sb.toString();
        this.f43278d = string;
        return string;
    }
}
