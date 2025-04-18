# Java Threads

## Intro to Concurrency
**Concurrency** refers to breaking up a task or piece of computation into different parts that can be executed independently, out of order, or in partial order without affecting the final outcome. One way - but not the only way - of achieving concurrency is by using multiple threads in the same program.

### Multi-core Processing
Most computers these days have multiple cores or CPUs, which means that calculations at the hardware level can be done in parallel. Without multiple cores, operating systems can still achieve concurrency with a process called **time splicing** - this means running one process for a short time, then switching to another, and back very rapidly. This ensures that no process or application is completely blocked.

On multi-core systems, different processes can be run on different CPUs entirely. This enables true parallelization and is a key benefit of writing multithreaded programs.

## Introduction to Threads
A thread is a subset of a process that is also an independent sequence of execution, but threads of the main process run in the same memory space, managed independently by a scheduler. So, we can think of a thread as a "path of execution", but they can access the same objects in memory.

Every thread that is created in a program is given its own call stack, where it stores local variables references. However, all threads share the same heap, where the objects live in memory. Thus, two threads could have separate variable references on two different stacks that still point to the same object in the heap.

### Multithreading
Multithreading extends the idea of multitasking into applications where you can subdivide operations in a single application into individual, parallel threads. Each thread can have its own task that it performs. The OS divides processing time not just with applications, but between threads. Multi-core processors can actually run multiple different processes and threads concurrently, enabling true parallelization.

In Java, multithreading is achieved via the [`Thread`](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) class and/or the [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) interface.

#### A Note on Best Practices
In general, it is best to avoid implementing multithreading yourself if possible. The benefit of multithreaded applications is better performance due to non-blocking execution. However, you should always measure or attempt to estimate the performance benefit you will get by using threads versus the tradeoff in complexity and subtle bugs that might be generated. Usually there are frameworks, tools, or libraries that have implemented the problem you are trying to solve, and you can leverage those instead of trying to build your own solution. For example, web servers like Apache Tomcat have multithreading built-in and provide APIs for dealing with network requests without having to worry about threads.

### Thread methods
A few important methods in the `Thread` class include:
* getters and setters for id, name, and priority
* `interrupt()` to explicitly interrupt the thread
* `isAlive()`, `isInterrupted()` and `isDaemon()` to test the state of the thread
* `join()` to wait for the thread to finish execution
* `start()` to actually begin thread execution after instantiation

A few important `static` methods are also defined:
* `Thread.currentThread()` which returns the thread that is currently executing
* `Thread.sleep(long millis)` which causes the currently executing thread to temporarily stop for a specified number of milliseconds

## Lifecycle of a Thread
At any given time, a thread can be in one of these states:
1. **New**: newly created thread that has not started executing
2. **Runnable**: either running or ready for execution but waiting for its resource allocation
3. **Blocked**: waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
4. **Waiting**: waiting for some other thread to perform an action without any time limit
5. **Timed_Waiting**: waiting for some other thread to perform a specific action for a specified time period
6. **Terminated**: has completed its execution

<img src = "https://miro.medium.com/max/1197/1*AVdsesDdmzZz4XoKi-AHWQ.png" width = "600">

## Thread Priorities
Priorities signify which order threads are to be run. The Thread class contains a few `static` variables for priority:
* MIN_PRIORITY = 1
* NORM_PRIORITY = 5, default
* MAX_PRIORITY = 10


### Creating Threads
There are two options to create and execute a `Thread` in Java:
1. Create a class that implements the `Runnable` functional interface
* implement the `run()` method
* pass an instance of your class to a `Thread` constructor
* call the `start()` method on the thread
	
```java
	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Inside the MyRunnable class");
		}
	}
```

2. Create a class that extends `Thread`
* implement the `run()` method
* instantiate your class
* call the `start()` method
	
```java
	public class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Inside the MyThread class");
		}
	}
```

```java
	public class ThreadDemo {
		public static void main(String[] args) {
			Thread myRunnable = new Thread(new MyRunnable());
			Thread myThread = new MyThread();
			myRunnable.start();
			myThread.start();
		}
	}
```

### Runnable and Lambda Expressions
Because `Runnable` is a *functional* interface, we can use a lambda expression to define thread behavior inline instead of implementing the interface in a separate class. We pass a lambda expression as the `Runnable` type required in the `Thread` constructor. For example:

```java
public class ThreadLambda {
  public static main(String[] args) {
    Thread willRun = new Thread(() -> {
	  System.out.println("Running!");
	});
	willRun.start();
  }
}
```

## Deadlock
The term "deadlock" describes a situation where 2 or more threads are blocked trying to access the same resource, waiting for the other. Neither thread can continue execution, so the program halts indefinitely.

### `synchronized` keyword
In a multithreaded environment, a race condition occurs when 2 or more threads attempt to access the same resource. Using the `synchronized` keyword on a piece of logic enforces that only one thread can access the resource at any given time. `synchronized` blocks or methods can be created using the keyword. Also, one way a class can be "thread-safe" is if all of its methods are `synchronized`.

## Producer-Consumer Problem

The Producer-Consumer problem is a classic example of a multi-process synchronization problem. Here, we have  a *fixed-size buffer* and two classes of threads - *producers* and *consumers*. Producers produces the data to the queue and Consumers consume the data from the queue. Both producer and consumer shares the same fixed-size buffer as a queue.

**Problem** - The producer should produce data only when the queue is not full. If the queue is full, then the producer shouldn't be allowed to put any data into the queue. The consumer should consume data only when the queue is not empty. If the queue is empty, then the consumer shouldn't be allowed to take any data from the queue.

We can solve the Producer-Consumer problem by using `wait()` & `notify()`methods to communicate between producer and consumer threads. The `wait()` method to pause the producer or consumer thread depending on the queue size. The `notify()` method sends a notification to the waiting thread.

Producer thread will keep on producing data for Consumer to consume. It will use `wait()` method when Queue is full and use `notify()` method to send notification to Consumer thread once data is added to the queue.

Consumer thread will consume the data form the queue. It will also use `wait()` method to wait if queue is empty. It will also use `notify()` method to send notification to producer thread after consuming data from the queue.

## Thread Pooling
Server Programs such as database and web servers repeatedly execute requests from multiple clients and these are oriented around processing a large number of short tasks. An approach for building a server application would be to create a new thread each time a request arrives and service this new request in the newly created thread. While this approach seems simple to implement, it has significant disadvantages. A server that creates a new thread for every request would spend more time and consume more system resources in creating and destroying threads than processing actual requests.

A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.

- Java provides the Executor framework which is centered around the Executor interface, its sub-interface –ExecutorService and the class-ThreadPoolExecutor, which implements both of these interfaces. By using the executor, one only has to implement the Runnable objects and send them to the executor to execute.

- Executor Thread Pool Methods

```java
newFixedThreadPool(int) // Creates a fixed size thread pool
newCachedThreadPool() // Creates a thread pool that creats new threads as needed,
                      // but will resuse previously constructed threads that are available
newSingleThreadExecutor() // Creates a single thread
```

<img src = "https://media.geeksforgeeks.org/wp-content/uploads/Thread_Pool.jpg" width = "600">

<img src = "https://media.geeksforgeeks.org/wp-content/uploads/tprun1.jpg" width = "600">

<img src = "https://media.geeksforgeeks.org/wp-content/uploads/tprun2.jpg" width = "600">
