# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.


## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Could the validations be reused in a graphical or web interface?
- Did you create a class for each validation or did you combine them all into a single class?
- In the `Validator`, did you use the parameter of type `String` or is it another type? Why?
    ```java
    boolean isValid(String text)
    ```
- Do you need to create a new class to combine validations already implemented?
- Do you still have the `Field` interface or is it now a class?
- Have you used the Template Method pattern? That is, have you implemented it [this way](#template-method)?

## 🎨 Design Patterns Used

This solution primarily utilises the _Strategy_ and _Composite_ design patterns.

## 🧠 Points for Reflection

As you review the solution, you might notice alternative ways to structure certain components. Consider whether these are simply **equivalent choices**, or whether they introduce **hidden trade-offs** and design implications worth understanding.

### Template Method

What do you think of this alternative?

```java
public abstract class AbstractField {

    ...

    public void requestInput() {

        var console = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print(label + ": ");
                value = console.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!isValid(value));
    }

    protected abstract boolean isValid(String text);

}
```

Now, each field derives from the previous class and implements the `isValid` method. For example, the `TextField` class could be implemented as follows:

```java
class TextField extends AbstractField {

    ...

    protected boolean isValid(String text) {
        for (char ch : text.toCharArray())
            if (!Character.isLetter(ch))
                return false;

        return true;
    }
}

class NumberField extends AbstractField {
    ...

    protected boolean isValid(String text) {
        for (char ch : text.toCharArray())
            if (!Character.isDigit(ch))
                return false;

        return true;
    }
}
```

### List of Validations

In the presented solution, the `Field` class receives a single validator in its constructor:

```java
public class Field {

    public Field(String label, Validator validator) {
        ...
    }
...
```

Would it have been simpler to pass a list of validators for when multiple validations are to be applied to the same field?

```java
public class Field {
    public Field(String label, List<Validator> validators) {
        ...
    }
```
