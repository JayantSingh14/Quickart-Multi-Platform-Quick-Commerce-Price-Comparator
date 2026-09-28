package in.juspay.hypersdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hypersdk.core.InflateView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class InflateJSON extends InflateView {
    private final String ARGS;
    private final String BODY;
    private final String CATCH;
    private final String COMMAND;
    private final String CONDITION;
    private final String CONDITIONS;
    private final String EXPLICIT_TYPE;
    private final String FUNCTION_STACK_NAME;
    private final String GLOBAL;
    private final String IF;
    private final String INVOKE_ON;
    private final String JSON_ARRAY;
    private final String JSON_OBJECT;
    private final String LISTENER;
    private final String LOCAL;
    private final String METHOD_NAME;
    private final String NEW;
    private final String OVERRIDE_CLASS_LISTENER;
    private final String OVERRIDE_METHODS;
    private final String RETURN_TO;
    private final String RETURN_TYPE;
    private final String RUNIN_UI_JSON;
    private final String STATE;
    private final String STATIC;
    private final String TO;
    private final String TYPE;
    private final String VALUE;
    private final String VALUE_GET;
    private final String VALUE_SET;
    private final String VOID;
    private final String WHILE;

    @NonNull
    private final HashMap<InflateView.Cmd, Constructor<?>> constructorCache;
    private final AtomicInteger idCounter;
    private final HashMap<String, HashMap<String, Object>> localState;
    private OverrideClass overrideClass;

    public class Arguments {
        private final Object[] args;
        private Class<?>[] classTypes;

        public Arguments(JSONArray jSONArray, Object obj, LinkedList<String> linkedList) throws JSONException {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.classTypes = new Class[0];
            }
            this.args = new Object[jSONArray.length()];
            this.classTypes = new Class[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                this.args[i2] = InflateJSON.this.getValue(jSONObject, obj, linkedList);
                this.classTypes[i2] = (Class) InflateJSON.this.getClassTypeFromObject(this.args[i2], jSONObject.optString("et"));
            }
        }
    }

    public InflateJSON(@NonNull DynamicUI dynamicUI) {
        super(dynamicUI);
        this.constructorCache = new HashMap<>();
        this.RUNIN_UI_JSON = "rj";
        this.JSON_ARRAY = "jsa";
        this.JSON_OBJECT = "jso";
        this.idCounter = new AtomicInteger(0);
        this.VALUE = "v";
        this.VOID = "vo";
        this.COMMAND = "c";
        this.CATCH = "ct";
        this.TYPE = "t";
        this.TO = "to";
        this.GLOBAL = "g";
        this.LOCAL = "lcl";
        this.STATE = "st";
        this.INVOKE_ON = "io";
        this.RETURN_TO = "rt";
        this.METHOD_NAME = "mn";
        this.ARGS = "a";
        this.NEW = "n";
        this.EXPLICIT_TYPE = "et";
        this.CONDITION = "cnd";
        this.CONDITIONS = "cnds";
        this.RETURN_TYPE = "rty";
        this.BODY = "bd";
        this.IF = "if";
        this.WHILE = "w";
        this.VALUE_SET = "vs";
        this.VALUE_GET = "vg";
        this.FUNCTION_STACK_NAME = "fnstk";
        this.STATIC = "stc";
        this.OVERRIDE_CLASS_LISTENER = "ocl";
        this.OVERRIDE_METHODS = "orm";
        this.LISTENER = "lis";
        this.localState = new HashMap<>();
        this.overrideClass = new OverrideClass(this);
    }

    private Object createNewInstance(Class<?> cls, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor<?> constructor;
        if (objArr == null || objArr.length == 0) {
            return cls.newInstance();
        }
        InflateView.Cmd cmd = new InflateView.Cmd(cls, "new", clsArr);
        if (this.constructorCache.containsKey(cmd)) {
            Constructor<?> constructor2 = this.constructorCache.get(cmd);
            Objects.requireNonNull(constructor2);
            return constructor2.newInstance(objArr);
        }
        Object objNewInstance = null;
        try {
            constructor = cls.getConstructor(clsArr);
            try {
                objNewInstance = constructor.newInstance(objArr);
            } catch (NoSuchMethodException unused) {
                Constructor<?>[] constructors = cls.getConstructors();
                int i2 = 0;
                if (clsArr == null) {
                    clsArr = new Class[objArr.length];
                    for (int i3 = 0; i3 < objArr.length; i3++) {
                        Object obj = objArr[i3];
                        if (obj != null) {
                            clsArr[i3] = obj.getClass();
                        }
                    }
                }
                int length = constructors.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Constructor<?> constructor3 = constructors[i2];
                    if (constructor3.getParameterTypes().length == objArr.length && matchTypes(constructor3.getParameterTypes(), clsArr)) {
                        objNewInstance = constructor3.newInstance(objArr);
                        constructor = constructor3;
                        break;
                    }
                    i2++;
                }
                this.constructorCache.put(cmd, constructor);
                return objNewInstance;
            }
        } catch (NoSuchMethodException unused2) {
            constructor = null;
        }
        this.constructorCache.put(cmd, constructor);
        return objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <Any> Any getClassTypeFromObject(Object obj, @NonNull String str) {
        if (str.equals("")) {
            return (Any) obj.getClass();
        }
        Any any = (Any) createPrimitiveClass(str);
        return any == null ? (Any) Class.forName(str) : any;
    }

    private Field getField(Class<?> cls, String str) {
        return cls.getDeclaredField(str);
    }

    @Nullable
    private Object getLocalStateValue(String str, LinkedList<String> linkedList) throws Exception {
        Iterator<String> itDescendingIterator = linkedList.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            String next = itDescendingIterator.next();
            if (!this.localState.containsKey(next)) {
                throw new Exception(android.support.v4.media.b.C("local state not found for function ", next));
            }
            HashMap<String, Object> map = this.localState.get(next);
            Objects.requireNonNull(map);
            if (map.containsKey(str)) {
                HashMap<String, Object> map2 = this.localState.get(next);
                Objects.requireNonNull(map2);
                return map2.get(str);
            }
        }
        return null;
    }

    @Nullable
    private Object getStateValue(String str) {
        return this.state.get(str);
    }

    @Nullable
    private Object invokeFunction(Method method, Object obj, Object[] objArr) {
        return objArr == null ? method.invoke(obj, null) : method.invoke(obj, objArr);
    }

    private void saveOutput(Object obj, JSONObject jSONObject, LinkedList<String> linkedList) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        String string = jSONObject.getString("to");
        String string2 = jSONObject.getString("v");
        if (string.equals("g")) {
            getDUI().setGlobalState(string2, obj);
        } else if (string.equals("lcl")) {
            setLocalStateValue(string2, obj, linkedList);
        } else {
            this.state.put(string2, obj);
        }
    }

    private void setLocalStateValue(String str, Object obj, LinkedList<String> linkedList) {
        HashMap<String, Object> map = this.localState.get(linkedList.getLast());
        Objects.requireNonNull(map);
        map.put(str, obj);
    }

    public Object callFunction(String str, Object obj, Object[] objArr) {
        return callFunction(str, obj, objArr, null);
    }

    @Nullable
    public Method findMethodInClassWithArgs(Class<?> cls, String str, Class<?>[] clsArr) {
        return findMethodWithCmd(new InflateView.Cmd(cls, str, clsArr));
    }

    @Nullable
    public Class<?> getClassNameJSON(JSONObject jSONObject, Object obj) throws Exception {
        String string = jSONObject.getString("t");
        String strOptString = jSONObject.optString("et");
        if (string.equals("stc")) {
            strOptString = jSONObject.getString("v");
        }
        if (!strOptString.equals("")) {
            return getClassName(strOptString);
        }
        if (obj != null) {
            return obj.getClass();
        }
        throw new Exception("toRunOn is null");
    }

    @Nullable
    public Object getValue(JSONObject jSONObject, Object obj, LinkedList<String> linkedList) throws JSONException {
        String string = jSONObject.getString("t");
        return string.equals("jsa") ? jSONObject.getJSONArray("v") : string.equals("jso") ? jSONObject.getJSONObject("v") : getValueNew(string, jSONObject.getString("v"), obj, linkedList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public <Any> Any getValueNew(String str, String str2, Object obj, LinkedList<String> linkedList) {
        str.getClass();
        switch (str) {
            case "g":
                return (Any) getDUI().getGlobalState(str2);
            case "st":
                return (Any) getStateValue(str2);
            case "apm":
                return (Any) this.dynamicUI.getApplicationManager();
            case "ctx":
                Any any = (Any) this.dynamicUI.getActivity();
                return any == null ? (Any) this.dynamicUI.getAppContext() : any;
            case "lcl":
                return (Any) getLocalStateValue(str2, linkedList);
            case "stc":
                return null;
            case "infl":
                return this;
            case "this":
                return obj;
            default:
                return (Any) getValueNew(str, str2);
        }
    }

    @Nullable
    public Object parseAndRunPipeJSON(Object obj, JSONArray jSONArray, boolean z, LinkedList<String> linkedList) throws Exception {
        Object obj2 = null;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Object objRunCommandJSON = runCommandJSON(jSONObject, obj, z, linkedList);
            if (jSONObject.has("rt")) {
                saveOutput(objRunCommandJSON, jSONObject.getJSONObject("rt"), linkedList);
            }
            i2++;
            obj2 = objRunCommandJSON;
        }
        return obj2;
    }

    @Override // in.juspay.hypersdk.core.InflateView
    public void parseKeys(String str, JSONObject jSONObject, Object obj, boolean z) throws JSONException {
        try {
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e("WARNING", "Error in parsing new infl " + e2.getMessage());
        }
        if (str.equals("rj")) {
            runJSON(obj, jSONObject.getJSONArray("rj"), z, null);
            return;
        }
        if (str.equals("ocl")) {
            JSONArray jSONArray = jSONObject.getJSONArray("ocl");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                this.overrideClass.addListener(obj, jSONObject2.getString("lis"), jSONObject2.getJSONObject("orm"));
            }
        }
        super.parseKeys(str, jSONObject, obj, z);
    }

    @Nullable
    public Object runCommandJSON(JSONObject jSONObject, Object obj, boolean z, LinkedList<String> linkedList) throws Exception {
        int i2;
        String strOptString;
        Class<?> classNameJSON;
        Object value;
        Arguments arguments;
        String strOptString2 = jSONObject.optString("t", "c");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("io");
        strOptString = jSONObject.optString("mn", "");
        if (jSONObjectOptJSONObject != null) {
            value = getValue(jSONObjectOptJSONObject, obj, linkedList);
            classNameJSON = getClassNameJSON(jSONObjectOptJSONObject, value);
            arguments = new Arguments(jSONObject.optJSONArray("a"), obj, linkedList);
        } else {
            classNameJSON = null;
            value = null;
            arguments = null;
        }
        strOptString2.getClass();
        switch (strOptString2) {
            case "w":
                JSONArray jSONArray = jSONObject.getJSONArray("cnd");
                JSONArray jSONArray2 = jSONObject.getJSONArray("bd");
                while (true) {
                    Object objRunJSON = runJSON(obj, jSONArray, z, linkedList);
                    if ((objRunJSON instanceof Boolean) && ((Boolean) objRunJSON).equals(Boolean.TRUE)) {
                        runJSON(obj, jSONArray2, z, linkedList);
                    }
                }
                return null;
            case "if":
                JSONArray jSONArray3 = jSONObject.getJSONArray("cnds");
                for (i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i2);
                    Object objRunJSON2 = runJSON(obj, jSONObject2.getJSONArray("cnd"), z, linkedList);
                    if ((objRunJSON2 instanceof Boolean) && ((Boolean) objRunJSON2).equals(Boolean.TRUE)) {
                        return runJSON(obj, jSONObject2.getJSONArray("bd"), z, linkedList);
                    }
                }
                return null;
            case "vg":
                Objects.requireNonNull(classNameJSON);
                return getField(classNameJSON, strOptString).get(value);
            case "vs":
                Objects.requireNonNull(classNameJSON);
                Field field = getField(classNameJSON, strOptString);
                Objects.requireNonNull(arguments);
                field.set(value, arguments.args[0]);
                return null;
            default:
                if (strOptString.equals("n")) {
                    Objects.requireNonNull(classNameJSON);
                    Objects.requireNonNull(arguments);
                    return createNewInstance(classNameJSON, arguments.args, arguments.classTypes);
                }
                Objects.requireNonNull(arguments);
                Method methodFindMethodInClassWithArgs = findMethodInClassWithArgs(classNameJSON, strOptString, arguments.classTypes);
                if (methodFindMethodInClassWithArgs != null) {
                    return invokeFunction(methodFindMethodInClassWithArgs, value, arguments.args);
                }
                throw new Exception("Method not found");
        }
    }

    @Nullable
    public Object runJSON(Object obj, JSONArray jSONArray, boolean z, LinkedList<String> linkedList) {
        Object andRunPipeJSON = null;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                andRunPipeJSON = parseAndRunPipeJSON(obj, jSONArray.getJSONArray(i2), z, linkedList);
            } catch (Exception e2) {
                this.dynamicUI.getLogger().e("WARNING", "Error in parsing new infl " + e2.getMessage());
            }
        }
        return andRunPipeJSON;
    }

    @Nullable
    public Object runProps(JSONObject jSONObject, String str, Object obj) throws JSONException, ClassNotFoundException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("props");
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            parseKeys(itKeys.next(), jSONObject3, obj, false);
        }
        Object obj2 = getState().get("rt");
        String string = jSONObject2.getString("rty");
        if (string.equals("vo")) {
            return null;
        }
        Class<?> cls = Class.forName(string);
        if (cls.isInstance(obj2)) {
            return obj2;
        }
        DuiLogger logger = getDUI().getLogger();
        StringBuilder sbV = androidx.fragment.app.e.v("return type mismatch for method ", str, " expected ", string, " got ");
        sbV.append(obj2 != null ? obj2.getClass().getName() : "result isnull");
        logger.e("WARNING", sbV.toString());
        Object objRunJSON = runJSON(obj, jSONObject2.getJSONArray("ct"), false, null);
        if (cls.isInstance(objRunJSON)) {
            return objRunJSON;
        }
        DuiLogger logger2 = getDUI().getLogger();
        StringBuilder sbV2 = androidx.fragment.app.e.v("return type mismatch for method on default", str, " expected ", string, " got ");
        sbV2.append(objRunJSON == null ? "null" : objRunJSON.getClass().getName());
        logger2.e("WARNING", sbV2.toString());
        return null;
    }

    @Nullable
    public Object callFunction(String str, Object obj, Object[] objArr, LinkedList<String> linkedList) {
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sbW = android.support.v4.media.b.w(str);
        sbW.append(this.idCounter.getAndIncrement());
        String string = sbW.toString();
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        map.put("fnstk", linkedList);
        this.localState.put(string, map);
        linkedList.add(string);
        map.put("a", objArr);
        Object objRunJSON = runJSON(obj, getDUI().getFunction(str), false, linkedList);
        linkedList.removeLast();
        this.localState.remove(string);
        return objRunJSON;
    }
}
