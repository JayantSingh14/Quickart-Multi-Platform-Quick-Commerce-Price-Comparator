package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ConstraintLayoutStates {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2433a;

    /* renamed from: b, reason: collision with root package name */
    public int f2434b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f2435c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f2436d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f2437e = new SparseArray();

    public static class State {

        /* renamed from: a, reason: collision with root package name */
        public final int f2438a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f2439b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final int f2440c;

        /* renamed from: d, reason: collision with root package name */
        public final ConstraintSet f2441d;

        public State(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f2440c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2438a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2438a);
                } else if (index == R.styleable.State_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2440c);
                    this.f2440c = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f2441d = constraintSet;
                        constraintSet.f((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Variant {

        /* renamed from: a, reason: collision with root package name */
        public final float f2442a;

        /* renamed from: b, reason: collision with root package name */
        public final float f2443b;

        /* renamed from: c, reason: collision with root package name */
        public final float f2444c;

        /* renamed from: d, reason: collision with root package name */
        public final float f2445d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2446e;

        /* renamed from: f, reason: collision with root package name */
        public final ConstraintSet f2447f;

        public Variant(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f2442a = Float.NaN;
            this.f2443b = Float.NaN;
            this.f2444c = Float.NaN;
            this.f2445d = Float.NaN;
            this.f2446e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2446e);
                    this.f2446e = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f2447f = constraintSet;
                        constraintSet.f((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2445d = typedArrayObtainStyledAttributes.getDimension(index, this.f2445d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2443b = typedArrayObtainStyledAttributes.getDimension(index, this.f2443b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2444c = typedArrayObtainStyledAttributes.getDimension(index, this.f2444c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2442a = typedArrayObtainStyledAttributes.getDimension(index, this.f2442a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final boolean a(float f2, float f3) {
            float f4 = this.f2442a;
            if (!Float.isNaN(f4) && f2 < f4) {
                return false;
            }
            float f5 = this.f2443b;
            if (!Float.isNaN(f5) && f3 < f5) {
                return false;
            }
            float f6 = this.f2444c;
            if (!Float.isNaN(f6) && f2 > f6) {
                return false;
            }
            float f7 = this.f2445d;
            return Float.isNaN(f7) || f3 <= f7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ConstraintLayoutStates(android.content.Context r11, androidx.constraintlayout.widget.ConstraintLayout r12, int r13) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r10 = this;
            r10.<init>()
            r0 = -1
            r10.f2434b = r0
            r10.f2435c = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r10.f2436d = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r10.f2437e = r1
            r1 = 0
            r10.f2433a = r12
            java.lang.String r12 = "Error parsing resource: "
            java.lang.String r2 = "ConstraintLayoutStates"
            android.content.res.Resources r3 = r11.getResources()
            android.content.res.XmlResourceParser r3 = r3.getXml(r13)
            int r4 = r3.getEventType()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L29:
            r5 = 1
            if (r4 == r5) goto Lbe
            r6 = 2
            if (r4 == r6) goto L31
            goto L9a
        L31:
            java.lang.String r4 = r3.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r7 = r4.hashCode()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r8 = 4
            r9 = 3
            switch(r7) {
                case -1349929691: goto L6b;
                case 80204913: goto L61;
                case 1382829617: goto L58;
                case 1657696882: goto L4e;
                case 1901439077: goto L3f;
                default: goto L3e;
            }     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L3e:
            goto L75
        L3f:
            java.lang.String r5 = "Variant"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r4 == 0) goto L75
            r5 = r9
            goto L76
        L49:
            r11 = move-exception
            goto L9f
        L4b:
            r11 = move-exception
            goto Laf
        L4e:
            java.lang.String r5 = "layoutDescription"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r4 == 0) goto L75
            r5 = 0
            goto L76
        L58:
            java.lang.String r7 = "StateSet"
            boolean r4 = r4.equals(r7)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r4 == 0) goto L75
            goto L76
        L61:
            java.lang.String r5 = "State"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r4 == 0) goto L75
            r5 = r6
            goto L76
        L6b:
            java.lang.String r5 = "ConstraintSet"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r4 == 0) goto L75
            r5 = r8
            goto L76
        L75:
            r5 = r0
        L76:
            if (r5 == r6) goto L8e
            if (r5 == r9) goto L81
            if (r5 == r8) goto L7d
            goto L9a
        L7d:
            r10.a(r11, r3)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L9a
        L81:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r4 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r4.<init>(r11, r3)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r1 == 0) goto L9a
            java.util.ArrayList r5 = r1.f2439b     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r5.add(r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L9a
        L8e:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r1.<init>(r11, r3)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            android.util.SparseArray r4 = r10.f2436d     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r5 = r1.f2438a     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r4.put(r5, r1)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L9a:
            int r4 = r3.next()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L29
        L9f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            r0.append(r13)
            java.lang.String r12 = r0.toString()
            android.util.Log.e(r2, r12, r11)
            goto Lbe
        Laf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            r0.append(r13)
            java.lang.String r12 = r0.toString()
            android.util.Log.e(r2, r12, r11)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.<init>(android.content.Context, androidx.constraintlayout.widget.ConstraintLayout, int):void");
    }

    public final void a(Context context, XmlResourceParser xmlResourceParser) throws XmlPullParserException, NumberFormatException, IOException {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlResourceParser.getAttributeName(i2);
            String attributeValue = xmlResourceParser.getAttributeValue(i2);
            if (attributeName != null && attributeValue != null && CLConstants.SHARED_PREFERENCE_ITEM_ID.equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), CLConstants.SHARED_PREFERENCE_ITEM_ID, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.l(context, xmlResourceParser);
                this.f2437e.put(identifier, constraintSet);
                return;
            }
        }
    }

    public final void b(int i2, float f2, float f3) {
        int i3 = this.f2434b;
        SparseArray sparseArray = this.f2436d;
        int i4 = 0;
        ConstraintLayout constraintLayout = this.f2433a;
        if (i3 == i2) {
            State state = i2 == -1 ? (State) sparseArray.valueAt(0) : (State) sparseArray.get(i3);
            int i5 = this.f2435c;
            if (i5 == -1 || !((Variant) state.f2439b.get(i5)).a(f2, f3)) {
                while (true) {
                    ArrayList arrayList = state.f2439b;
                    if (i4 >= arrayList.size()) {
                        i4 = -1;
                        break;
                    } else if (((Variant) arrayList.get(i4)).a(f2, f3)) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (this.f2435c == i4) {
                    return;
                }
                ArrayList arrayList2 = state.f2439b;
                ConstraintSet constraintSet = i4 == -1 ? null : ((Variant) arrayList2.get(i4)).f2447f;
                if (i4 != -1) {
                    int i6 = ((Variant) arrayList2.get(i4)).f2446e;
                }
                if (constraintSet == null) {
                    return;
                }
                this.f2435c = i4;
                constraintSet.c(constraintLayout);
                return;
            }
            return;
        }
        this.f2434b = i2;
        State state2 = (State) sparseArray.get(i2);
        while (true) {
            ArrayList arrayList3 = state2.f2439b;
            if (i4 >= arrayList3.size()) {
                i4 = -1;
                break;
            } else if (((Variant) arrayList3.get(i4)).a(f2, f3)) {
                break;
            } else {
                i4++;
            }
        }
        ArrayList arrayList4 = state2.f2439b;
        ConstraintSet constraintSet2 = i4 == -1 ? state2.f2441d : ((Variant) arrayList4.get(i4)).f2447f;
        if (i4 != -1) {
            int i7 = ((Variant) arrayList4.get(i4)).f2446e;
        }
        if (constraintSet2 != null) {
            this.f2435c = i4;
            constraintSet2.c(constraintLayout);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + ", " + f3);
    }
}
