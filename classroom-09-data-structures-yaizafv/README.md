# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.

## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:

- Did you change any class in the _operations_ package?
- In `Team.java`, what type did you use for the `players` field? Did you use `MyIterator`? Would that be appropriate?
    ```java
    public class Team {
        private ... players;
        ...
    }
    ```

## 🎨 Design Patterns Used

This solution primarily uses the _Iterator_ design pattern.

It also uses the _Decorator_, _Strategy_, and _Composite_ design patterns.

## 🧠 Points for Reflection

As you review the solution, you might notice alternative ways to structure certain components. Consider whether these are simply **equivalent choices**, or whether they introduce **hidden trade-offs** and design implications worth understanding.

### Patterns Used

In this solution, several design patterns have been implemented. Can you identify them?
- Which pattern does the `Concat` class implement?
- Which patterns do the `Map` and `Filter` classes implement?

### Iterators in Trees

A tree can be traversed in several different ways: preorder, inorder, postorder, level-order, etc. How could this functionality be implemented using the _Iterator_ pattern?

### Returning Iterator versus Implementing Iterator

The `MyVector` class in the provided solution has been implemented as follows:
```java
public class MyVector {
    ...
    public MyIterator iterator() {
        return new VectorIterator(this);
    }
}
```

What would be the drawbacks of this alternative?

```java
public class MyVector implements MyIterator {
    ...
    public String next() {
        ...
    }
}
```

### Equivalence with Java Functional Interfaces

The `Filter`, `Find` and `Map` classes define their own interfaces `Condition`, `ElementMatcher` and `Transformation` respectively.

But, in fact, these interfaces **were not necessary**, as Java's standard library already defines equivalent functional interfaces. Which ones are they?

### Multiple Uses of the Same Iterator

In the presented solution, a `MyIterator` object can only be used once. For example, the following code would not work as expected:

```java
void operation(MyIterator it) {
    while (it.hasNext()) {
        System.out.println(it.next());
    }

    // Trying to iterate again -> this won't print anything
    while (it.hasNext()) {
        System.out.println(it.next());
    }
}
```

Therefore, an iterator would not be the appropriate type to pass to a method that needs to traverse a data collection multiple times.

How could this problem be solved? As a hint, it is recommended to recall how this functionality is implemented in _C#_ and what type is used in that language when passing and returning data collections.

### Application of Iterators in Java

Java has classes that implement the _Iterator_ pattern in its standard library. Specifically, the `Iterable<T>` interface defines the `iterator()` method that returns an object of type `Iterator<T>`, which in turn defines the `hasNext()` and `next()` methods. It also has older classes that implement this pattern, such as `Enumeration<T>`. And finally, Java 8 introduced _Streams_, which also implement this pattern.

Due to these multiple implementations across different Java versions, it can be difficult to know which class to use in practice. These inconsistencies make it harder for programmers to use iterators consistently. Languages like _C#_ and _Python_ have a single, unified way to define and use iterators, which makes them easier to work with.

Given the current state of Java's standard library, the recommendation to use iterators both as method parameters and return values is no longer practical. In real-world Java code, while iterators have their merits, developers typically use...
- ... as a parameter for a method that needs to traverse a data collection?
- ... as a return value for a method that returns a data collection?


## ✏️ Proposed Exercises

Implement the following common operations when traversing data collections: `anyMatch`, `allMatch`, `skip`, `limit`, `min`, `max`, and `sort`.
