# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.


## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Did you try to use any special character to represent an _empty character_ ('\0' or '\u0000')?
- Do the terminal Outputs (`BluetoothOutput`, `InternetOutput`, `FileOutput`) always write whatever they receive, regardless of what it is, or did you have to add logic to avoid writing in certain situations?
- Where do you write the number of characters written or read? In `main` or somewhere else?


## 🎨 Design Patterns Used

This solution primarily uses the _decorator_ design pattern.

The _composite_ pattern is also employed for the `Duplicator` class, which allows sending data to multiple outputs simultaneously.


## 🧠 Points for Reflection

### Decorator vs List<Transformer>

The `FileSystem.copy` method has been implemented by passing a single `Output`, so that all transformations are chained one after another.

```java
public void copy(String name, Output output) {
```

Could a different solution be considered where, instead of each transformation being linked to the next, all the transformations are passed in a `List` to the `copy` method?

```java
public void copy(String name, List<Transformer> outputs) {
```

### Character by Character Processing

Not everything can be processed character by character. Examples:
- If we wanted to implement a transformation that replaced every occurrence of the string "foo" with "bar", we could not do it character by character; we would have to read the whole file (or at least blocks of characters).
- Compression algorithms (like ZIP) or encryption algorithms (like AES) typically operate on blocks of data, not character by character.

To allow operations that require more than a single character, would we have to discard the current design or can this be accommodated by the given solution? How would you implement it?


## ✏️ Proposed Exercises

The following exercises are independent of each other. You can do them in any order.

### Exercise 1

Add the option to replace a tab character with 8 spaces (or vice versa). You should not need to change anything else beyond adding a new class.

### Exercise 2

Do modification 1 (copy `private.txt` as a normalized file to `a.txt` and also encrypted to `b.txt`) by reading `private.txt` only once (i.e., making a single call to `copy`).

### Exercise 3

Do everything requested in the Base Design on the same input file `private.txt` with a single call to `copy`. That is, send that file to the three destinations, each of which receives the file with the indicated operations applied in each case.

### Exercise 4

Make it possible to calculate the MD5 signature of a file (in our case, it is simulated by simply summing its bytes). Encrypt `private.txt` and then calculate its signature before sending it over the Internet. Afterwards, print its signature on the screen.
