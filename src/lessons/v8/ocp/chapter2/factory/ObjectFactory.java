package lessons.v8.ocp.chapter2.factory;

public class ObjectFactory {

    private ObjectFactory() {
        //hide implicit public constructor
    }

    public static Object getObject(Class<?> classOfObject) {
        String name = classOfObject.getSimpleName();
        switch (classOfObject.getSimpleName()) {
        case "String":
            return new String(name);
        case "Integer":
            return 1;
        case "Long":
            return 1l;
        case "Short":
            return (short) 1;
        case "Double":
            return 2.0;
        case "Float":
            return 2.0f;
        case "Boolean":
            return true;
        case "Character":
            return 'A';
        case "Byte":
            return (byte) 1;
        default:
            return new Object();
        }

    }

}
