package lessons.v8.ocp.chapter3.generics;

public class GenericClass<T> {

    private T genericContent;

    public GenericClass(T genericContent) {
        this.genericContent = genericContent;
    }

    public T getGenericContent() {
        return genericContent;
    }

    public void setGenericContent(T genericContent) {
        this.genericContent = genericContent;
    }

    @Override
    public String toString() {
        return String.format("GenericClass [genericContent = %s, type = %s ]",
                genericContent, genericContent.getClass().getSimpleName());
    }

}
