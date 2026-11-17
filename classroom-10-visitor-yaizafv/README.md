# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.

## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Did you have to change any existing class or interface to implement the translator to _Python_?
- If you wanted to remove `ExecutorVisitor` and/or `PythonVisitor`, would you have to change any node?

## 🎨 Design Patterns Used

This solution uses the _Visitor_ design pattern.


## ✏️ Proposed Exercise

Currently, visitor methods are allowed to pass values as return values. However, there might also be a need for some visitor method to require passing additional information as parameters to other methods of the same visitor. What extension can you think of to allow visitors that require this functionality?
