package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ConstraintAttribute {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2371a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f2372b;

    /* renamed from: c, reason: collision with root package name */
    public AttributeType f2373c;

    /* renamed from: d, reason: collision with root package name */
    public int f2374d;

    /* renamed from: e, reason: collision with root package name */
    public float f2375e;

    /* renamed from: f, reason: collision with root package name */
    public String f2376f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2377g;

    /* renamed from: h, reason: collision with root package name */
    public int f2378h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AttributeType {

        /* renamed from: a, reason: collision with root package name */
        public static final AttributeType f2379a;

        /* renamed from: b, reason: collision with root package name */
        public static final AttributeType f2380b;

        /* renamed from: c, reason: collision with root package name */
        public static final AttributeType f2381c;

        /* renamed from: d, reason: collision with root package name */
        public static final AttributeType f2382d;

        /* renamed from: e, reason: collision with root package name */
        public static final AttributeType f2383e;

        /* renamed from: f, reason: collision with root package name */
        public static final AttributeType f2384f;

        /* renamed from: g, reason: collision with root package name */
        public static final AttributeType f2385g;

        /* renamed from: h, reason: collision with root package name */
        public static final AttributeType f2386h;

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AttributeType[] f2387i;

        static {
            AttributeType attributeType = new AttributeType("INT_TYPE", 0);
            f2379a = attributeType;
            AttributeType attributeType2 = new AttributeType("FLOAT_TYPE", 1);
            f2380b = attributeType2;
            AttributeType attributeType3 = new AttributeType("COLOR_TYPE", 2);
            f2381c = attributeType3;
            AttributeType attributeType4 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            f2382d = attributeType4;
            AttributeType attributeType5 = new AttributeType("STRING_TYPE", 4);
            f2383e = attributeType5;
            AttributeType attributeType6 = new AttributeType("BOOLEAN_TYPE", 5);
            f2384f = attributeType6;
            AttributeType attributeType7 = new AttributeType("DIMENSION_TYPE", 6);
            f2385g = attributeType7;
            AttributeType attributeType8 = new AttributeType("REFERENCE_TYPE", 7);
            f2386h = attributeType8;
            f2387i = new AttributeType[]{attributeType, attributeType2, attributeType3, attributeType4, attributeType5, attributeType6, attributeType7, attributeType8};
        }

        public static AttributeType valueOf(String str) {
            return (AttributeType) Enum.valueOf(AttributeType.class, str);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f2387i.clone();
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f2372b = constraintAttribute.f2372b;
        this.f2373c = constraintAttribute.f2373c;
        f(obj);
    }

    public static void d(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        AttributeType attributeType;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        AttributeType attributeType2 = null;
        boolean z = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.f2384f;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.f2381c;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.f2382d;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    int i3 = R.styleable.CustomAttribute_customPixelDimension;
                    AttributeType attributeType3 = AttributeType.f2385g;
                    if (index == i3) {
                        objValueOf2 = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == R.styleable.CustomAttribute_customDimension) {
                        objValueOf2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                        attributeType = AttributeType.f2380b;
                        objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                        attributeType = AttributeType.f2379a;
                        objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    } else if (index == R.styleable.CustomAttribute_customStringValue) {
                        attributeType = AttributeType.f2383e;
                        objValueOf = typedArrayObtainStyledAttributes.getString(index);
                    } else if (index == R.styleable.CustomAttribute_customReference) {
                        attributeType = AttributeType.f2386h;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        if (resourceId == -1) {
                            resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        objValueOf = Integer.valueOf(resourceId);
                    }
                    attributeType2 = attributeType3;
                }
                Object obj = objValueOf;
                attributeType2 = attributeType;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            ConstraintAttribute constraintAttribute = new ConstraintAttribute();
            constraintAttribute.f2372b = string;
            constraintAttribute.f2373c = attributeType2;
            constraintAttribute.f2371a = z;
            constraintAttribute.f(objValueOf2);
            map.put(string, constraintAttribute);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void e(View view, HashMap map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) map.get(str);
            String strC = !constraintAttribute.f2371a ? b.C("set", str) : str;
            try {
                int iOrdinal = constraintAttribute.f2373c.ordinal();
                Class cls2 = Float.TYPE;
                Class cls3 = Integer.TYPE;
                switch (iOrdinal) {
                    case 0:
                        cls.getMethod(strC, cls3).invoke(view, Integer.valueOf(constraintAttribute.f2374d));
                        break;
                    case 1:
                        cls.getMethod(strC, cls2).invoke(view, Float.valueOf(constraintAttribute.f2375e));
                        break;
                    case 2:
                        cls.getMethod(strC, cls3).invoke(view, Integer.valueOf(constraintAttribute.f2378h));
                        break;
                    case 3:
                        Method method = cls.getMethod(strC, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f2378h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(strC, CharSequence.class).invoke(view, constraintAttribute.f2376f);
                        break;
                    case 5:
                        cls.getMethod(strC, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f2377g));
                        break;
                    case 6:
                        cls.getMethod(strC, cls2).invoke(view, Float.valueOf(constraintAttribute.f2375e));
                        break;
                    case 7:
                        cls.getMethod(strC, cls3).invoke(view, Integer.valueOf(constraintAttribute.f2374d));
                        break;
                }
            } catch (IllegalAccessException e2) {
                StringBuilder sbY = b.y(" Custom Attribute \"", str, "\" not found on ");
                sbY.append(cls.getName());
                Log.e("TransitionLayout", sbY.toString(), e2);
            } catch (NoSuchMethodException e3) {
                Log.e("TransitionLayout", cls.getName() + " must have a method " + strC, e3);
            } catch (InvocationTargetException e4) {
                StringBuilder sbY2 = b.y(" Custom Attribute \"", str, "\" not found on ");
                sbY2.append(cls.getName());
                Log.e("TransitionLayout", sbY2.toString(), e4);
            }
        }
    }

    public final float a() {
        switch (this.f2373c.ordinal()) {
            case 0:
                return this.f2374d;
            case 1:
            case 6:
                return this.f2375e;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.f2377g ? 1.0f : 0.0f;
            default:
                return Float.NaN;
        }
    }

    public final void b(float[] fArr) {
        switch (this.f2373c.ordinal()) {
            case 0:
                fArr[0] = this.f2374d;
                return;
            case 1:
                fArr[0] = this.f2375e;
                return;
            case 2:
            case 3:
                int i2 = (this.f2378h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i2 / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.f2377g ? 1.0f : 0.0f;
                return;
            case 6:
                fArr[0] = this.f2375e;
                return;
            default:
                return;
        }
    }

    public final int c() {
        int iOrdinal = this.f2373c.ordinal();
        return (iOrdinal == 2 || iOrdinal == 3) ? 4 : 1;
    }

    public final void f(Object obj) {
        switch (this.f2373c.ordinal()) {
            case 0:
            case 7:
                this.f2374d = ((Integer) obj).intValue();
                break;
            case 1:
                this.f2375e = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f2378h = ((Integer) obj).intValue();
                break;
            case 4:
                this.f2376f = (String) obj;
                break;
            case 5:
                this.f2377g = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f2375e = ((Float) obj).floatValue();
                break;
        }
    }
}
