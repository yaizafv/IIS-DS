# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.

## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- If you implemented the form in Swing, could you reuse your adapters as they are?
- If the `Map` screen were removed but the form were kept, would anything need to change in the form's classes or adapters?
- Does each model class have one adapter for connecting to the `Map` class and another for connecting to the `MiniForm` class, or does each model have just one adapter that connects it to both objects?
- Could you remove the map-related functionality without affecting the form (`MiniForm`, its adapters, or the model classes)?

## 🎨 Design Patterns Used

This solution primarily uses the Adapter design pattern.

## ✏️ Proposed Exercise

Change the `MiniForm` class so that instead of editing only two fields, it can edit an arbitrary number of fields. That is, it should be possible to use it to edit two fields of, for example, a `Monument`, but also three fields of a `Restaurant` or one field of a `Photo`. In short, it should be possible to choose which fields to edit for each model class (all of them being `String`).
