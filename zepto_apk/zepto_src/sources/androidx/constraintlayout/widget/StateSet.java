package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StateSet {

    /* renamed from: a, reason: collision with root package name */
    public final int f2533a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f2534b = new SparseArray();

    public static class State {

        /* renamed from: a, reason: collision with root package name */
        public final int f2535a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f2536b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final int f2537c;

        public State(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f2537c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2535a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2535a);
                } else if (index == R.styleable.State_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2537c);
                    this.f2537c = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    "layout".equals(resourceTypeName);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Variant {

        /* renamed from: a, reason: collision with root package name */
        public final float f2538a;

        /* renamed from: b, reason: collision with root package name */
        public final float f2539b;

        /* renamed from: c, reason: collision with root package name */
        public final float f2540c;

        /* renamed from: d, reason: collision with root package name */
        public final float f2541d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2542e;

        public Variant(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f2538a = Float.NaN;
            this.f2539b = Float.NaN;
            this.f2540c = Float.NaN;
            this.f2541d = Float.NaN;
            this.f2542e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2542e);
                    this.f2542e = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    "layout".equals(resourceTypeName);
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2541d = typedArrayObtainStyledAttributes.getDimension(index, this.f2541d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2539b = typedArrayObtainStyledAttributes.getDimension(index, this.f2539b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2540c = typedArrayObtainStyledAttributes.getDimension(index, this.f2540c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2538a = typedArrayObtainStyledAttributes.getDimension(index, this.f2538a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final boolean a(float f2, float f3) {
            float f4 = this.f2538a;
            if (!Float.isNaN(f4) && f2 < f4) {
                return false;
            }
            float f5 = this.f2539b;
            if (!Float.isNaN(f5) && f3 < f5) {
                return false;
            }
            float f6 = this.f2540c;
            if (!Float.isNaN(f6) && f2 > f6) {
                return false;
            }
            float f7 = this.f2541d;
            return Float.isNaN(f7) || f3 <= f7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public StateSet(android.content.Context r12, android.content.res.XmlResourceParser r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r11 = this;
            r11.<init>()
            r0 = -1
            r11.f2533a = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r11.f2534b = r1
            java.lang.String r1 = "Error parsing XML resource"
            java.lang.String r2 = "ConstraintLayoutStates"
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r13)
            int[] r4 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r3 = r12.obtainStyledAttributes(r3, r4)
            int r4 = r3.getIndexCount()
            r5 = 0
            r6 = r5
        L21:
            if (r6 >= r4) goto L36
            int r7 = r3.getIndex(r6)
            int r8 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r7 != r8) goto L33
            int r8 = r11.f2533a
            int r7 = r3.getResourceId(r7, r8)
            r11.f2533a = r7
        L33:
            int r6 = r6 + 1
            goto L21
        L36:
            r3.recycle()
            int r3 = r13.getEventType()     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            r4 = 0
        L3e:
            r6 = 1
            if (r3 == r6) goto Lb7
            java.lang.String r7 = "StateSet"
            r8 = 3
            r9 = 2
            if (r3 == r9) goto L5b
            if (r3 == r8) goto L4b
            goto Lab
        L4b:
            java.lang.String r3 = r13.getName()     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            boolean r3 = r7.equals(r3)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r3 == 0) goto Lab
            goto Lb7
        L57:
            r12 = move-exception
            goto Lb0
        L59:
            r12 = move-exception
            goto Lb4
        L5b:
            java.lang.String r3 = r13.getName()     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            int r10 = r3.hashCode()     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            switch(r10) {
                case 80204913: goto L82;
                case 1301459538: goto L78;
                case 1382829617: goto L71;
                case 1901439077: goto L67;
                default: goto L66;
            }     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
        L66:
            goto L8c
        L67:
            java.lang.String r6 = "Variant"
            boolean r3 = r3.equals(r6)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r3 == 0) goto L8c
            r6 = r8
            goto L8d
        L71:
            boolean r3 = r3.equals(r7)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r3 == 0) goto L8c
            goto L8d
        L78:
            java.lang.String r6 = "LayoutDescription"
            boolean r3 = r3.equals(r6)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r3 == 0) goto L8c
            r6 = r5
            goto L8d
        L82:
            java.lang.String r6 = "State"
            boolean r3 = r3.equals(r6)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r3 == 0) goto L8c
            r6 = r9
            goto L8d
        L8c:
            r6 = r0
        L8d:
            if (r6 == r9) goto L9f
            if (r6 == r8) goto L92
            goto Lab
        L92:
            androidx.constraintlayout.widget.StateSet$Variant r3 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            r3.<init>(r12, r13)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            if (r4 == 0) goto Lab
            java.util.ArrayList r6 = r4.f2536b     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            r6.add(r3)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            goto Lab
        L9f:
            androidx.constraintlayout.widget.StateSet$State r4 = new androidx.constraintlayout.widget.StateSet$State     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            r4.<init>(r12, r13)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            android.util.SparseArray r3 = r11.f2534b     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            int r6 = r4.f2535a     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            r3.put(r6, r4)     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
        Lab:
            int r3 = r13.next()     // Catch: java.io.IOException -> L57 org.xmlpull.v1.XmlPullParserException -> L59
            goto L3e
        Lb0:
            android.util.Log.e(r2, r1, r12)
            goto Lb7
        Lb4:
            android.util.Log.e(r2, r1, r12)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public final int a(float f2, int i2, float f3, int i3) {
        State state = (State) this.f2534b.get(i3);
        if (state == null) {
            return i3;
        }
        ArrayList arrayList = state.f2536b;
        int i4 = state.f2537c;
        if (f2 != -1.0f && f3 != -1.0f) {
            Iterator it = arrayList.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant variant2 = (Variant) it.next();
                if (variant2.a(f2, f3)) {
                    if (i2 != variant2.f2542e) {
                        variant = variant2;
                    }
                }
            }
            return variant != null ? variant.f2542e : i4;
        }
        if (i4 != i2) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (i2 == ((Variant) it2.next()).f2542e) {
                }
            }
            return i4;
        }
        return i2;
    }

    public final int b(int i2) {
        float f2 = -1;
        SparseArray sparseArray = this.f2534b;
        int i3 = 0;
        if (-1 == i2) {
            State state = i2 == -1 ? (State) sparseArray.valueAt(0) : (State) sparseArray.get(-1);
            if (state != null) {
                while (true) {
                    ArrayList arrayList = state.f2536b;
                    if (i3 >= arrayList.size()) {
                        i3 = -1;
                        break;
                    }
                    if (((Variant) arrayList.get(i3)).a(f2, f2)) {
                        break;
                    }
                    i3++;
                }
                if (-1 != i3) {
                    return i3 == -1 ? state.f2537c : ((Variant) state.f2536b.get(i3)).f2542e;
                }
            }
        } else {
            State state2 = (State) sparseArray.get(i2);
            if (state2 != null) {
                while (true) {
                    ArrayList arrayList2 = state2.f2536b;
                    if (i3 >= arrayList2.size()) {
                        i3 = -1;
                        break;
                    }
                    if (((Variant) arrayList2.get(i3)).a(f2, f2)) {
                        break;
                    }
                    i3++;
                }
                return i3 == -1 ? state2.f2537c : ((Variant) state2.f2536b.get(i3)).f2542e;
            }
        }
        return -1;
    }
}
