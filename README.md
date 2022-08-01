# HEAD FIRST DESIGN PATTERNS #
This is my practical code when I read the book "Head First Design Patterns" of Eric Freeman et. al.

## OO Patterns ##
### Strategy ###
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
Strategy lets the algorithm vary independently from clients that use it.

### Observer ###
The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

### Decorator ###
The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
 
### Factory ###
The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. 
Factory Method lets a class defer instantiation to subclasses.

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

|              | Factory Method                                                                                                          | Abstract Factory                                                                                          |
|--------------|-------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| Similarities | Both encapsulate object creation.                                                                                       |                                                                                                           |
|              | Promote loose coupling by reducing the dependency of your application on concrete classes.                              |                                                                                                           |
| Differences  | Relies on inheritance: object creation is delegated to subclasses which implement the factory method to create objects. | Relies on object composition: object creation is implemented in methods exposed in the factory interface. |
|              | Allow a class to defer instantiation to its subclasses.                                                                 | Create families of related objects without having to depend on their concrete classes.                    |

### Singleton ###
The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it.
 
_There are several ways to deal with multi-threading in Singleton_
1. Synchronize the getInstance() method
2. Use eager instantiation
3. Double-check locking

### Command ###
The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.

> The command object encapsulates a request means by binding together a set of actions on a specific receiver.
To achieve this, it packages the actions and the receiver up into an object that exposes just one method.
```java
public interface Command {
    void execute();
}

public class Receiver implements Command {
    @Override
    public void execute() {
        // do something here
    }
}

public class Invoker {
    Command command;
    
    public setCommand(Command command) {
        this.command = command;
    }
    
    public void buttonWasPressed() {
        command.execute();
    }    
}
```

> Parameterizing an object means the Invoker don't care what command object it have, as long as it implemented the Command interface
```java
public class Runner {
    Invoker invoker = new Invoker();
    // lightOn is a class that implemented Command interface
    invoker.setCommand(lightOn);
    // garageOpen is a class that implemented Command interface
    invoker.setCommand(garageOpen);    
}
```

> Using commands to implement _queues and logs and supports undo operations_ means we can apply the Command Pattern to create a job queues, job schedulers, or thread pools to compute tasks long after client creates the command object.
Likewise, we can use Command Pattern to log all actions and be able to recover after a crask by invoking those actions. 

### Adapter and Facade ###
The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.
There are two forms of Adapter Pattern: class adapter (multiple inheritance - not supported in Java) and object adapter (composition)

The Facade Pattern provides a unified interface to a set of interfaces in a subsytem. Facade defines a higher- level interface that makes the subsystem easier to use.

|Decorator Pattern|Adapter Pattern|Facade Pattern|
|------------------|---------------|--------------|
|                  |When you need to use an existing class and its interface is not the one you need, use an adapter.|When you need to simplify and unify a large interface or complex set of interfaces, use a facade.|
|                  |An adapter changes an interface into one a client expects.|A facade decouples a client from a complex subsystem.|
|                  |Implementing an adapter may require little work or a great deal of work depending on the size and complexity of the target interface.|Implementing a facade requires that we compose the facade with its subsystem and use delegation to perform the work of the facade.|
|A decorator wraps an object to add new behaviors and responsibilities|An adapter wraps an object to change its interface|A facade “wraps” a set of objects to simplify.|

### Template Method ###
The Template Method Pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm’s structure.

A hook is the method that declared in the abstract class, but only given an empty or default implementation. This gives subclasses the ability to “hook into” the algorithm at various points, if they wish; a subclass is also free to ignore the hook.

|Template Method|Strategy|
|---------------|--------|
|Define the steps of an algorithm and allow subclasses to provide implementation for one or more steps|Define a family of algorithms and make them interchangeable.|
|Encapsulate algorithms using inheritance|Encapsulate algorithms using composition|
| |Don't depend on methods implemented on superclass|
|Keep control over the algorithm's structure|Manage entire algorithm in concrete classes|
|Don't duplicate code||

### Iterator and Composition ###
The Iterator Pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
> The pattern gives you a way to step through the elements of an aggregate without having to know how things are represented under the covers.
 
The Composite Pattern allows you to compose objects into tree structures to represent part-whole (or whole-part) hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
> Whole-part relationship means you tell the top level component to do something, and count on that component to do something all its parts i.e. we call the components that contain other components (composite objects) and components that don't contain other components (leaf objects)

> Treating the objects uniformly means having common methods on composites and leaves i.e. they must implement the same interface.

### State ###
The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
> The patterns encapsulates states into separate classes and delegates to the object representing the current state, we know that behavior changes along with the internal state

> If an object you’re using can completely change its behavior, then it appears to you that the object is actually instantiated from another class

|Strategy Pattern|State Pattern|
|----------------|-------------|
|By encapsulating the behaviors within state objects, you can simply change the state object in context to change its behavior.|Change the behavior by composing with a different object.|
|Remove all the troublesome if statements in the context||
 
### Proxy ###
The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

A remote proxy acts as a local representive to a remote object. The client talks to that local representive - called 'stub' - and thinks they are invoking methods on a remote object - called skeleton. Behind the scene, the stub packages up information about the call (arguments, method name and etc.) and ships it over the network to the skeleton; the skeleton then unpacks the information, finds out which method to call (and on which object) and invokes the real method on the real service object. 

### RMI ###
RMI provides a mechanism by which the server and the client communicate and pass information back and forth.

This is an overview of the five steps for making the remote service.
- Step 1: Make a Remote Interface
    1. Extend java.rmi.Remote
    2. Declare that all methods throw a RemoteException
    3. Be sure arguments and return values are primitives or Serializable
- Step 2: Make a Remote Implementation
    1. Implement the Remote interface
    2. Extend UnicastRemoteObject
    3. Write a no-arg constructor that declares a RemoteException
    4. Register the service with the RMI registry using Naming.rebind(String name, Remote obj)
- Step 3: Generate the stubs and skeletons using rmic
```
$ rmic MyRemoteImpl
```
- Step 4: Start the RMI registry (rmiregistry)
```
$ rmiregistry
```
- Step 5: Start the remote service
```
$ java MyRemoteImpl
```

## OO Principles ##
1. Identify aspects of your application that vary and separate them from what stays the same. i.e. encapsulate what varies
    > Take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don't

2. Favor composition over inheritance
    > Classes contains instances of other classes that implement the desired functionality
    ``` java
    public abstract class Duck {
        protected FlyBehavior flyBehavior;
        ...
    }
    
    public interface FlyBehavior {
        public void fly();
    }
    ```

3. Program to interfaces, not implementations
    > The declared type of the variables should be a supertype, usually an abstract class or interface, 
    so that the objects assigned to those variables can be of any concrete implementation of the supertype, 
    which means the class declaring them does not have to know about the actual object types
    ``` java
    public abstract class Animal {
        protected abstract void makeSound();
    }
    
    public Dog extends Animal {
        @Override
        public void makeSound() {
            bark();
        }
    }
    
    Animal animal = new Dog();
    animal.makeSound();
    ```

4. Strive for loosely coupled designs between objects that interact
    
    _When two objects are loosely coupled, they can interact, but have very little knowledge of each other_

5. Classes should be open for extension but closed for modification
    > Allow behavior to be extended without the need to modify existing code

6. Depend upon abstractions. Do not depend upon concrete classes.
    > It suggests that our high-level components should not depend on our low-level components; rather, they should _both_ depend on abstractions.
    
7. Principle of Least Knowledge - talk only to your immediate friends.
    > When you are designing a system, for any object, be careful of the number of classes it interacts with and also how it comes to interact with those classes.
    
    > This principle prevents us from creating designs that have a large number of classes coupled together so that changes in one part of the system cascade to other parts. 
    When you build a lot of dependencies between many classes, you are building a fragile system that will be costly to maintain and complex for others to understand.

8. The Hollywood Principle - don't call us, we call you
    > 

9. A class should have only one reason to change
    > One class, one responsibility