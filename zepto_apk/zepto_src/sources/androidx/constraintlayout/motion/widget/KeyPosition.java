package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyPosition extends KeyPositionBase {

    /* renamed from: f, reason: collision with root package name */
    public String f2111f;

    /* renamed from: g, reason: collision with root package name */
    public int f2112g;

    /* renamed from: h, reason: collision with root package name */
    public int f2113h;

    /* renamed from: i, reason: collision with root package name */
    public float f2114i;

    /* renamed from: j, reason: collision with root package name */
    public float f2115j;

    /* renamed from: k, reason: collision with root package name */
    public float f2116k;

    /* renamed from: l, reason: collision with root package name */
    public float f2117l;

    /* renamed from: m, reason: collision with root package name */
    public float f2118m;
    public float n;
    public int o;

    public static class Loader {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f2119a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2119a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            sparseIntArray.append(R.styleable.KeyPosition_framePosition, 2);
            sparseIntArray.append(R.styleable.KeyPosition_transitionEasing, 3);
            sparseIntArray.append(R.styleable.KeyPosition_curveFit, 4);
            sparseIntArray.append(R.styleable.KeyPosition_drawPath, 5);
            sparseIntArray.append(R.styleable.KeyPosition_percentX, 6);
            sparseIntArray.append(R.styleable.KeyPosition_percentY, 7);
            sparseIntArray.append(R.styleable.KeyPosition_keyPositionType, 9);
            sparseIntArray.append(R.styleable.KeyPosition_sizePercent, 8);
            sparseIntArray.append(R.styleable.KeyPosition_percentWidth, 11);
            sparseIntArray.append(R.styleable.KeyPosition_percentHeight, 12);
            sparseIntArray.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }
    }

    public KeyPosition() {
        this.f2120e = -1;
        this.f2111f = null;
        this.f2112g = -1;
        this.f2113h = 0;
        this.f2114i = Float.NaN;
        this.f2115j = Float.NaN;
        this.f2116k = Float.NaN;
        this.f2117l = Float.NaN;
        this.f2118m = Float.NaN;
        this.n = Float.NaN;
        this.o = 0;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void a(HashMap map) {
        throw null;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: b */
    public final Key clone() {
        KeyPosition keyPosition = new KeyPosition();
        super.c(this);
        keyPosition.f2111f = this.f2111f;
        keyPosition.f2112g = this.f2112g;
        keyPosition.f2113h = this.f2113h;
        keyPosition.f2114i = this.f2114i;
        keyPosition.f2115j = Float.NaN;
        keyPosition.f2116k = this.f2116k;
        keyPosition.f2117l = this.f2117l;
        keyPosition.f2118m = this.f2118m;
        keyPosition.n = this.n;
        return keyPosition;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition);
        SparseIntArray sparseIntArray = Loader.f2119a;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = Loader.f2119a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    if (MotionLayout.o1) {
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2086b);
                        this.f2086b = resourceId;
                        if (resourceId == -1) {
                            this.f2087c = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2087c = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f2086b = typedArrayObtainStyledAttributes.getResourceId(index, this.f2086b);
                        break;
                    }
                case 2:
                    this.f2085a = typedArrayObtainStyledAttributes.getInt(index, this.f2085a);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2111f = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f2111f = Easing.f1811c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.f2120e = typedArrayObtainStyledAttributes.getInteger(index, this.f2120e);
                    break;
                case 5:
                    this.f2113h = typedArrayObtainStyledAttributes.getInt(index, this.f2113h);
                    break;
                case 6:
                    this.f2116k = typedArrayObtainStyledAttributes.getFloat(index, this.f2116k);
                    break;
                case 7:
                    this.f2117l = typedArrayObtainStyledAttributes.getFloat(index, this.f2117l);
                    break;
                case 8:
                    float f2 = typedArrayObtainStyledAttributes.getFloat(index, this.f2115j);
                    this.f2114i = f2;
                    this.f2115j = f2;
                    break;
                case 9:
                    this.o = typedArrayObtainStyledAttributes.getInt(index, this.o);
                    break;
                case 10:
                    this.f2112g = typedArrayObtainStyledAttributes.getInt(index, this.f2112g);
                    break;
                case 11:
                    this.f2114i = typedArrayObtainStyledAttributes.getFloat(index, this.f2114i);
                    break;
                case 12:
                    this.f2115j = typedArrayObtainStyledAttributes.getFloat(index, this.f2115j);
                    break;
                default:
                    Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
            }
        }
        if (this.f2085a == -1) {
            Log.e("KeyPosition", "no frame position");
        }
    }

    public final void h(Object obj, String str) {
        switch (str) {
            case "transitionEasing":
                this.f2111f = obj.toString();
                break;
            case "percentWidth":
                this.f2114i = Key.g((Number) obj);
                break;
            case "percentHeight":
                this.f2115j = Key.g((Number) obj);
                break;
            case "drawPath":
                Number number = (Number) obj;
                this.f2113h = number instanceof Integer ? ((Integer) number).intValue() : Integer.parseInt(number.toString());
                break;
            case "sizePercent":
                float fG = Key.g((Number) obj);
                this.f2114i = fG;
                this.f2115j = fG;
                break;
            case "percentX":
                this.f2116k = Key.g((Number) obj);
                break;
            case "percentY":
                this.f2117l = Key.g((Number) obj);
                break;
        }
    }
}
