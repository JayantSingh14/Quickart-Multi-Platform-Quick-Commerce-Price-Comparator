package com.horcrux.svg;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
class RNSVGMarkerPosition {

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList f45820d;

    /* renamed from: e, reason: collision with root package name */
    public static int f45821e;

    /* renamed from: f, reason: collision with root package name */
    public static Point f45822f;

    /* renamed from: g, reason: collision with root package name */
    public static Point f45823g;

    /* renamed from: h, reason: collision with root package name */
    public static Point f45824h;

    /* renamed from: i, reason: collision with root package name */
    public static Point f45825i;

    /* renamed from: a, reason: collision with root package name */
    public final RNSVGMarkerType f45826a;

    /* renamed from: b, reason: collision with root package name */
    public final Point f45827b;

    /* renamed from: c, reason: collision with root package name */
    public final double f45828c;

    /* renamed from: com.horcrux.svg.RNSVGMarkerPosition$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45829a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f45830b;

        static {
            int[] iArr = new int[ElementType.values().length];
            f45830b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45830b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45830b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45830b[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45830b[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[RNSVGMarkerType.values().length];
            f45829a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45829a[1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45829a[2] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public RNSVGMarkerPosition(RNSVGMarkerType rNSVGMarkerType, Point point, double d2) {
        this.f45826a = rNSVGMarkerType;
        this.f45827b = point;
        this.f45828c = d2;
    }

    public static void a(SegmentData segmentData, Point point, Point point2, Point point3) {
        segmentData.f45856a = e(point2, point);
        segmentData.f45857b = e(point3, point2);
        if (d(segmentData.f45856a)) {
            segmentData.f45856a = segmentData.f45857b;
        } else if (d(segmentData.f45857b)) {
            segmentData.f45857b = segmentData.f45856a;
        }
    }

    public static double b(RNSVGMarkerType rNSVGMarkerType) {
        Point point = f45824h;
        double dAtan2 = Math.atan2(point.f45818b, point.f45817a) * 57.29577951308232d;
        Point point2 = f45825i;
        double dAtan22 = Math.atan2(point2.f45818b, point2.f45817a) * 57.29577951308232d;
        int iOrdinal = rNSVGMarkerType.ordinal();
        if (iOrdinal == 0) {
            return dAtan22;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                return 0.0d;
            }
            return dAtan2;
        }
        if (Math.abs(dAtan2 - dAtan22) > 180.0d) {
            dAtan2 += 360.0d;
        }
        return (dAtan2 + dAtan22) / 2.0d;
    }

    public static ArrayList c(ArrayList arrayList) {
        f45820d = new ArrayList();
        f45821e = 0;
        f45822f = new Point(0.0d, 0.0d);
        f45823g = new Point(0.0d, 0.0d);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PathElement pathElement = (PathElement) it.next();
            SegmentData segmentData = new SegmentData();
            Point[] pointArr = pathElement.f45794b;
            ElementType elementType = pathElement.f45793a;
            int iOrdinal = elementType.ordinal();
            if (iOrdinal == 0) {
                segmentData.f45858c = pointArr[2];
                segmentData.f45856a = e(pointArr[0], f45822f);
                segmentData.f45857b = e(pointArr[2], pointArr[1]);
                if (d(segmentData.f45856a)) {
                    a(segmentData, pointArr[0], pointArr[1], pointArr[2]);
                } else if (d(segmentData.f45857b)) {
                    a(segmentData, f45822f, pointArr[0], pointArr[1]);
                }
            } else if (iOrdinal == 1) {
                Point point = pointArr[1];
                segmentData.f45858c = point;
                a(segmentData, f45822f, pointArr[0], point);
            } else if (iOrdinal == 2 || iOrdinal == 3) {
                Point point2 = pointArr[0];
                segmentData.f45858c = point2;
                segmentData.f45856a = e(point2, f45822f);
                segmentData.f45857b = e(segmentData.f45858c, f45822f);
            } else if (iOrdinal == 4) {
                Point point3 = f45823g;
                segmentData.f45858c = point3;
                segmentData.f45856a = e(point3, f45822f);
                segmentData.f45857b = e(segmentData.f45858c, f45822f);
            }
            f45825i = segmentData.f45856a;
            int i2 = f45821e;
            if (i2 > 0) {
                RNSVGMarkerType rNSVGMarkerType = i2 == 1 ? RNSVGMarkerType.f45831a : RNSVGMarkerType.f45832b;
                f45820d.add(new RNSVGMarkerPosition(rNSVGMarkerType, f45822f, b(rNSVGMarkerType)));
            }
            f45824h = segmentData.f45857b;
            f45822f = segmentData.f45858c;
            if (elementType == ElementType.f45652b) {
                f45823g = pathElement.f45794b[0];
            } else if (elementType == ElementType.f45654d) {
                f45823g = new Point(0.0d, 0.0d);
            }
            f45821e++;
        }
        RNSVGMarkerType rNSVGMarkerType2 = RNSVGMarkerType.f45833c;
        f45820d.add(new RNSVGMarkerPosition(rNSVGMarkerType2, f45822f, b(rNSVGMarkerType2)));
        return f45820d;
    }

    public static boolean d(Point point) {
        return point.f45817a == 0.0d && point.f45818b == 0.0d;
    }

    public static Point e(Point point, Point point2) {
        return new Point(point2.f45817a - point.f45817a, point2.f45818b - point.f45818b);
    }
}
