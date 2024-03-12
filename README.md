# Study Group: Java 18-21 

## Java 21
---

### String Templates (Preview)

In short, to simplify the writing of Java program and enhance readability.
STR is a public static final field and is automatically imported into every Java compilation unit


### Sequenced Collections

Introduce new interfaces to represent collections with a defined encounter order.

![Sequenced Collection](./img/SequencedCollectionDiagram.png)

### Generational ZGC

Generational ZGC should be a better solution for most use cases than non-generational ZGC

``` shell
java -XX:+UseZGC -XX:+ZGenerational ...
```

For detailed  
https://openjdk.org/jeps/439 

### Record Patterns

a more declarative, data-focused style of programming

### Pattern Matching for switch


### Foreign Function & Memory API (Third Preview)

Introduce an API by which Java programs can interoperate with code and data outside of the Java runtime.

Goal: Ease of use, Performance, Generality, Safety


### Unnamed Patterns and Variables (Preview)



### Virtual Threads

At a high level, a thread is managed and scheduled by the operating system, while a virtual thread is managed and scheduled by a virtual machine. Now, to create a new kernel thread, we must do a system call, and that’s a costly operation.

virtual threads are managed by the JVM. Therefore, their allocation doesn’t require a system call, and they’re free of the operating system’s context switch.

virtual threads can significantly improve application throughput when
- The number of concurrent tasks is high (more than a few thousand), and
- The workload is not CPU-bound, since having many more threads than processor cores cannot improve throughput in that case.

Note:
Do not pool virtual threads

![Virtual Thread](./img/virtual-threads-mapped-to-carrier-threads.png)


### Unnamed Classes and Instance Main Methods (Preview)

Unnamed classes are a significant feature designed to simplify the learning curve for beginners. It allows methods, fields, and classes to exist without explicit class declarations.


#### Rules to Create and Use an Unnamed Class
1. The ‘package’ Statement is Not Allowed

2. No Constructor is Allowed
Since we cannot refer to the unnamed class by its name, we cannot create a constructor as well.

It also means that we cannot create an instance of an unnamed class. That is why these classes are suited only for simple POC and learning purposes.

3. A main() Method must Exist
Since we cannot create a direct instance of an unnamed class, to make it usable, it must have a main() method to execute its code. Java compiler will throw an error if there is no main method.

4. Unnamed class cannot extend or implement
An unnamed class is always final and it cannot extend another class (except Object) or implement an interface.

5. Access to Static Members

### Scoped Values (Preview)
### Vector API (Sixth Incubator)

A vector computation is a sequence of operations that work on multiple data elements at the same time, such as complex math and array operations.
The Vector API has two main parts: the vector classes and the vector operations. the Vector API has a hardware dependency as it relies on SIMD instructions

```java
int[] a = {1, 2, 3, 4};
int[] b = {5, 6, 7, 8};
int[] c = new int[4];

// Vector computation
for (int i = 0; i < c.length; i++) {
  c[i] = a[i] + b[i];
} 

// vs
c[0] = a[0] + b[0];
```


### Deprecate the Windows 32-bit x86 Port for Removal

Deprecate the Windows 32-bit x86 port, with the intent to remove it in a future release.
Windows 10, the last Windows operating system to support 32-bit operation, will reach End of Life in October 2025.


### Prepare to Disallow the Dynamic Loading of Agents

Issue warnings when agents are loaded dynamically into a running JVM.   


An agent is a component that can alter the code of an application while the application is running.


### Key Encapsulation Mechanism API

Introduce an API for key encapsulation mechanisms (KEMs), an encryption technique for securing symmetric keys using public key cryptography.

### Structured Concurrency (Preview)

Structured concurrency treats groups of related tasks running in different threads as a single unit of work, thereby streamlining error handling and cancellation, improving reliability, and enhancing observability.

The principal class of the structured concurrency API is StructuredTaskScope in the java.util.concurrent package.

The general workflow of code using StructuredTaskScope is:

1. Create a scope. The thread that creates the scope is its owner.

2. Use the fork(Callable) method to fork subtasks in the scope.

3. At any time, any of the subtasks, or the scope's owner, may call the scope's shutdown() method to cancel unfinished subtasks and prevent the forking of new subtasks.
4. The scope's owner joins the scope, i.e., all of its subtasks, as a unit. The owner can call the scope's join() method, to wait until all subtasks have either completed (successfully or not) or been cancelled via shutdown(). Alternatively, it can call the scope's joinUntil(java.time.Instant) method, to wait up to a deadline.

5. After joining, handle any errors in the subtasks and process their results.

6. Close the scope, usually implicitly via try-with-resources. This shuts down the scope, if it is not already shut down, and waits for any subtasks that have been cancelled but not yet completed to complete.

## Java 20
---

### Scoped Values
### Record Patterns
###  Pattern Matching for Switch
### Foreign Function and Memory API
### Virtual Threads
### Structured Concurrency
### Vectored API
- No change compared to JAVA 19, a few bug fixes and performance enhancements

## Java 19
---

- Changes to Preallocated HashMap Creation

### Preview and Incubator Features

#### 1. Pattern Matching for Switch
#### 2. Record Patterns
#### 2.1 Nested Record Patterns
#### Foreign Function & Memory API
#### Virtual Threads
#### Structured Concurrency
#### Vector api 
### Deprecated

- Locale Class Constructors Deprecated
- ThreadGroup Degraded
- Remove Finalizer Implementation in SSLSocketImpl





## Java 18
---
### Feature: 

- UTF-8 by Default
- Simple Web Server
- Code Snippets in Java API Documentation
- Vector API
- Internet-Address Resolution SPI
- Foreign Function and Memory API
- Pattern Matching Improvements
- Deprecated Finalization for Removal


---




## References
- https://openjdk.org/projects/jdk/21/
- https://www.baeldung.com/java-21-string-templates
- https://www.developer.com/java/java-18-features/
- https://www.jrebel.com/blog/java-19-features
- https://www.baeldung.com/java-20-new-features
- https://www.baeldung.com/java-21-string-templates
- https://www.happycoders.eu/java/virtual-threads/
- https://howtodoinjava.com/java/java-unnamed-class-instance-method/