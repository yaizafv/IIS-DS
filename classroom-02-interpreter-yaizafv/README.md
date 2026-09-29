# Software Design Laboratory Class

## Instructions

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.


## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Did you make `Instruction` an abstract class rather than an interface?
- Do you pass the operands of instructions (`Jump`, `Push`, etc.) in the constructor of each of those instructions?
- Did you separate the creation of the program (`BasicProgramLoader`) from its execution (`VirtualMachine`)?
    - Could you create a test program in JUnit and pass it to the `VirtualMachine` to test it?
- Do instructions receive only the `State` or the entire `VirtualMachine`?
- Do you have any `static` attributes in any class?
- Where is `Scanner console` now?

## 🧠 Points for Reflection

As you review the solution, you might notice alternative ways to structure certain components. Consider whether these are simply **equivalent choices**, or whether they introduce **hidden trade-offs** and design implications worth understanding.

### How to pass the program to the Virtual Machine

The `VirtualMachine` class has been implemented as follows:
```java
public class VirtualMachine {

    ...

    public VirtualMachine(List<Instruction> program) {
        this.program = program;
    }

    public void run() {
        ...
    }
}
```

What do you think of this alternative?

```java
public class VirtualMachine {

    // The constructor is removed

    public void run(List<Instruction> program) {
       ...
    }

}
```

Answer:
1. It doesn't matter. It's a matter of preference.
2. The second option is worse because ...

### How to pass the State to Instructions

Instructions have been implemented passing the `State` object to each instruction's `execute` method:
```java
interface Instruction ... {
    void execute(State state);
}
```

What do you think of this alternative, which passes the `State` object to each instruction's constructor instead of to
the `execute` method? Fore example, the `Jump` instructions would be implemented as follows:

```java
public class Jump ... {
    private State state;

    public Jump(State state) {   // State is passed once in the constructor
        this.state = state;
    }

    protected void execute() {  // No need to pass the state to the execute method
        ...
    }
}
```

Answer:
1. It doesn't matter. It's a matter of preference.
2. The second option is worse because ...


### Program Class

In the `VirtualMachine` class, the program is represented as a list of instructions:
```java
public class VirtualMachine {

    private List<Instruction> program;
    ...
}
```

Would it have been better to create a `Program` class that encapsulates the list of instructions?


```java
public class VirtualMachine {

    private Program program;
    ...
}

public class Program {
    private List<Instruction> instructions;
    ...
}
```

### Static Attributes

What is the problem with this approach?

```java
public class VirtualMachine {

    private static State state = new State(); // Note the static attribute
    ...

    public void run() {
        while (state.getIP() < program.size())
            program.get(state.getIP()).execute();   // No need to pass the state
    }
}
```
