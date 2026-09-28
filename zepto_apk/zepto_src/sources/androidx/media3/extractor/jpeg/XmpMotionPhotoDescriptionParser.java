package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.jpeg.MotionPhotoDescription;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
final class XmpMotionPhotoDescriptionParser {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8762a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8763b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f8764c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c9, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.jpeg.MotionPhotoDescription a(java.lang.String r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()
            java.io.StringReader r1 = new java.io.StringReader
            r2 = r19
            r1.<init>(r2)
            r0.setInput(r1)
            r0.next()
            java.lang.String r1 = "x:xmpmeta"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.c(r0, r1)
            r3 = 0
            if (r2 == 0) goto Ld0
            com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.r()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r4
        L28:
            r0.next()
            java.lang.String r8 = "rdf:Description"
            boolean r8 = androidx.media3.common.util.XmlPullParserUtil.c(r0, r8)
            if (r8 == 0) goto L9c
            java.lang.String[] r2 = androidx.media3.extractor.jpeg.XmpMotionPhotoDescriptionParser.f8762a
            r6 = 0
            r7 = r6
        L37:
            r8 = 4
            if (r7 >= r8) goto Lc9
            r9 = r2[r7]
            java.lang.String r9 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r9)
            if (r9 == 0) goto L99
            int r2 = java.lang.Integer.parseInt(r9)
            r7 = 1
            if (r2 != r7) goto Lc9
            java.lang.String[] r2 = androidx.media3.extractor.jpeg.XmpMotionPhotoDescriptionParser.f8763b
            r7 = r6
        L4c:
            if (r7 >= r8) goto L60
            r9 = r2[r7]
            java.lang.String r9 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r9)
            if (r9 == 0) goto L62
            long r7 = java.lang.Long.parseLong(r9)
            r9 = -1
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L65
        L60:
            r7 = r4
            goto L65
        L62:
            int r7 = r7 + 1
            goto L4c
        L65:
            java.lang.String[] r2 = androidx.media3.extractor.jpeg.XmpMotionPhotoDescriptionParser.f8764c
        L67:
            r9 = 2
            if (r6 >= r9) goto L93
            r9 = r2[r6]
            java.lang.String r9 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r9)
            if (r9 == 0) goto L90
            long r11 = java.lang.Long.parseLong(r9)
            androidx.media3.extractor.jpeg.MotionPhotoDescription$ContainerItem r13 = new androidx.media3.extractor.jpeg.MotionPhotoDescription$ContainerItem
            r14 = 0
            r16 = 0
            java.lang.String r18 = "image/jpeg"
            r13.<init>(r14, r16, r18)
            r2 = r13
            androidx.media3.extractor.jpeg.MotionPhotoDescription$ContainerItem r10 = new androidx.media3.extractor.jpeg.MotionPhotoDescription$ContainerItem
            r13 = 0
            java.lang.String r15 = "video/mp4"
            r10.<init>(r11, r13, r15)
            com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.u(r2, r10)
            goto L97
        L90:
            int r6 = r6 + 1
            goto L67
        L93:
            com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.r()
        L97:
            r6 = r7
            goto Lbd
        L99:
            int r7 = r7 + 1
            goto L37
        L9c:
            java.lang.String r8 = "Container:Directory"
            boolean r8 = androidx.media3.common.util.XmlPullParserUtil.c(r0, r8)
            if (r8 == 0) goto Lad
            java.lang.String r2 = "Container"
            java.lang.String r8 = "Item"
            com.google.common.collect.ImmutableList r2 = b(r0, r2, r8)
            goto Lbd
        Lad:
            java.lang.String r8 = "GContainer:Directory"
            boolean r8 = androidx.media3.common.util.XmlPullParserUtil.c(r0, r8)
            if (r8 == 0) goto Lbd
            java.lang.String r2 = "GContainer"
            java.lang.String r8 = "GContainerItem"
            com.google.common.collect.ImmutableList r2 = b(r0, r2, r8)
        Lbd:
            boolean r8 = androidx.media3.common.util.XmlPullParserUtil.b(r0, r1)
            if (r8 == 0) goto L28
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto Lca
        Lc9:
            return r3
        Lca:
            androidx.media3.extractor.jpeg.MotionPhotoDescription r0 = new androidx.media3.extractor.jpeg.MotionPhotoDescription
            r0.<init>(r6, r2)
            return r0
        Ld0:
            java.lang.String r0 = "Couldn't find xmp metadata"
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r3, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.jpeg.XmpMotionPhotoDescriptionParser.a(java.lang.String):androidx.media3.extractor.jpeg.MotionPhotoDescription");
    }

    public static ImmutableList b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.c(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strA = XmlPullParserUtil.a(xmlPullParser, strConcat3);
                String strA2 = XmlPullParserUtil.a(xmlPullParser, strConcat4);
                String strA3 = XmlPullParserUtil.a(xmlPullParser, strConcat5);
                String strA4 = XmlPullParserUtil.a(xmlPullParser, strConcat6);
                if (strA == null || strA2 == null) {
                    return ImmutableList.r();
                }
                builder.h(new MotionPhotoDescription.ContainerItem(strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L, strA));
            }
        } while (!XmlPullParserUtil.b(xmlPullParser, strConcat2));
        return builder.j();
    }
}
