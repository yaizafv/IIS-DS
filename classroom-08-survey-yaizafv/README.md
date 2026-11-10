# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.

## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Did you implement the backup as just another Observer or did you give it special treatment?
- Could you reuse the classes from the `survey` package in a graphical environment without modifying them?
- The classes in the `wrappers` package implement an additional pattern. Which one is it?

## 🎨 Design Patterns Used

This solution primarily uses the _Observer_ design pattern. It also uses the _Decorator_ design pattern.


## 🧠 Points for Reflection

As you review the solution, you might notice alternative ways to structure certain components. Consider whether these are simply **equivalent choices**, or whether they introduce **hidden trade-offs** and design implications worth understanding.

### Notifying the charts from the user interface

The `TextUserInterface` class in the provided solution has been implemented as follows:
```java
public class TextUserInterface {
    ...
        do {
            ...

            if (answer.startsWith("y")) // yes
                survey.addYesVote();

            if (answer.startsWith("n")) // no
                survey.addNoVote();

        } while (true);

    ...
```

What do you think of this alternative? Instead of notifying the charts from within the `Survey` class, we could notify
them directly from the user interface class every time a vote is added. For example:

```java
public class TextUserInterface {
    ...
        do {

            ...

            if (answer.startsWith("y")) { // yes
                survey.addYesVote();
                updateCharts();
            }

            if (answer.startsWith("n")) { // no
                survey.addNoVote();
                updateCharts();
            }

        } while (true);

    ...

    private void updateCharts() {
        updatePieChart();
        updateBarChart();
        backupData();
    }
```


### Implementing the Delay inside each Chart

In the provided solution, the delay for updating the charts is implemented creating a new class `Delayer`:
```java
/*
* Program 3. Instead of drawing it with each vote, the pie chart is only
* drawn starting from the third vote (and from then on with each vote).
*/
survey.addObserver(new Delayer(3, new PieChart()));
```

What do you think of the alternative of implementing the delay inside the chart? That is, instead of creating the new `Delayer` class, we could have changed the `PieChart` constructor to receive the number of votes to wait before updating.

```java
public class PieChart implements Observer {

    private int voteCount;
    private int delay;

    public PieChart(int delay) {
        this.delay = delay;
        this.voteCount = 0;
    }

    public void update(Survey survey) {
        voteCount++;
        if (voteCount >= delay) {
            // Drawing logic here
        }
    }
}
```

The main would now look like this:

```java
/*
* Program 3. Instead of drawing it with each vote, the pie chart is only
* drawn starting from the third vote (and from then on with each vote).
*/
survey.addObserver(new PieChart(3));
```

And the same could have been done with the `BarChart` in program 4 so that it draws every 3 votes.

```java
survey.addObserver(new BarChart(3));
```

### What Information to Pass in the Event?

In this solution, the `Observer` interface is defined as follows:
```java
public interface VoteObserver {
    void voteReceived(Survey survey);
}
```

What do you think of this alternative?

```java
public interface VoteObserver {
    void voteReceived(int yes, int no);
}
```

That is, in the previous proposal, instead of passing the `Survey` object, pass the vote counts directly (yes and no). Is it better, worse, or equivalent?

### Implementing notifications outside the Survey class (advanced)

Instead of modifying the `Survey` class to notify observers every time a vote is added, what do you think of the alternative of creating a wrapper class that handles that functionality? This way, the `Survey` class would remain unchanged and the notification logic would be separated.

```java
class SurveyVoteNotifier {
    private Survey survey;
    private List<VoteObserver> observers;

    public SurveyVoteNotifier(Survey survey) {
        this.survey = survey;
        this.observers = new ArrayList<>();
    }

    public void addObserver(VoteObserver observer) {
        observers.add(observer);
    }

    public void voteYes() {
        survey.voteYes();
        notifyObservers();
    }

    public void voteNo() {
        survey.voteNo();
        notifyObservers();
    }

    private void notifyObservers() {
        for (VoteObserver observer : observers) {
            observer.update(survey);
        }
    }
}
```

It would be used as follows:
```java
survey = new SurveyVoteNotifier(new Survey("Are you in favor of nuclear energy?"));
```

A variant of the above, which would share the same _advantages_ or _disadvantages_ as the previous one, would be to use inheritance instead of composition:

```java
class SurveyVoteNotifier extends Survey {
    private List<VoteObserver> observers;

    public SurveyVoteNotifier() {
        super();
        this.observers = new ArrayList<>();
    }

    public void addObserver(VoteObserver observer) {
        observers.add(observer);
    }

    @Override
    public void voteYes() {
        super.voteYes();
        notifyObservers();
    }

    @Override
    public void voteNo() {
        super.voteNo();
        notifyObservers();
    }

    private void notifyObservers() {
        for (VoteObserver observer : observers) {
            observer.update(this);
        }
    }
}
```

## ✏️ Proposed Exercises

Implement the solution to this exercise in a graphical environment using Swing. This way, each chart would be a window that could be opened or closed independently from other charts.
