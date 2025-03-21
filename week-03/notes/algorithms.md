# Algorithms 

## What is an Algorithm?

An algorithm is a process, or set of rules to be followed in calculations or some other problem-solving operations. Typically, the size of the input will often affect the overall runtime of the algorithm.

There are many different types but we'll be covering 3 today:

- Brute Force Search
- Binary Search
- Recursive

## Complexity of Algorithms

### Time Complexity

Time complexity is typically talked about much more than Space complexity simply because we live in a day and age when we want everything to be fast, but more often than not, care a bit less about how much space a solution takes up. When calculating and comparing time complexities, as mentioned, we really only care about the worst possible case for a given solution, that is, what is the absolute most time, or iterations, that this given operation will take or perform.

### Space Complexity

When calculating the space complexity for a given solution, we often ask the question "How much space does this solution need for its computation", or rather, how much memory needs to be reserved or allocated during its execution.

### Big O Notation

Complexity is typically denoted with what we call "Big O Notation", which looks something like O(n) or O(1) where the variable within the parentheses denotes the upper bound worst case for a given implementation.

#### Big O Cheat Sheet

| O(1)          | O(log n)                 | O(n)                              | O(n log n)             | O(n^2)                          | O(2^n)                             | O(n!)          |
| ------------- | ------------------------ | --------------------------------- | ---------------------- | ------------------------------- | ---------------------------------- | -------------- |
| Constant Time | Logarithmic Time         | Linear Time                       | Asymptotic Time        | Quadratic Time                  | Fibonacci Time                     | Factorial Time |
| Best Case     | Slightly Worse than O(1) | Dependent on number of iterations | Worse than Linear Time | Much Worse than Asymptotic Time | Growth Doubles with Each New Input | Worst Case     |

<img src="https://miro.medium.com/max/1400/1*5ZLci3SuR0zM_QlZOADv8Q.jpeg" width = "600">

## Searching Algorithms

- **Basic Linear Search (Brute Force)** - O(n) Linear
- **Binary Search** - O(log n) Logarithmic
  > *Logarithmic running time (O(log n)) essentially means that the running time grows in proportion to the logarithm of the input size - as an example, if 10 items takes at most some amount of time x, and 100 items takes at most, say, 2x, and 10,000 items takes at most 4x, then it's looking like an O(log n) time complexity.*
<br>

- **Recursive Linear Search**
- **Recursive Binary Search**

## Binary Search
Imagine that you have a shelf of books and you are looking for a book authored by *Shakespear*.  With Linear search, you would start from the beginning and check each book.  The faster approach (O(log n)) would be by using **Binary Search**.

> The collection must be **sorted** to apply Binary Search
- Imagine that the books are **sorted by last name**.
- With Binary Search you would **first located the center of the book shelf**.
- Imagine the book in the center of the shelf is authored by someone with a last name starting with "U".

<br>

> [ P Q R S T **U** V W X Y Z]
<br>

- Since "S" is *less than* "U", we can eliminate the entire right half of the book shelf, only searching between "P" - "T".

<br>

> [ P Q R S T ~~**U** V W X Y Z~~]
<br>

- We repeat this process, continuously finding the midpoint and checking whether our target value is greater than or less than, until we find "S".

<br>

> [ P Q **R** S T] <br>
> [ ~~P Q **R**~~ S T] <br> 
> [ **S** ~~T~~]
<br>

Binary Search on a *sorted* array looks like this:

<br>

```java
public static int binarySearch(int[] arr, int x) {
    int min = 0;
    int max = arr.length - 1;
    while (min <= max) {
        
        int mid = (min + max) / 2;
        
        if (x < arr[mid]) { // if the target value is less than
            max = mid - 1; // the midpoint, we discard the RHS
        } else if (x > arr[mid]) {
            min = mid + 1; // otherwise we discard the LHS
        } else {
            return mid;
        }
    }
    return -1;
}
```

<br>

### Logarithmic Complexity O(log n)
Logarithm is the inverse of exponentiation.  The way this works is by division - the size of the input is repeatedly being divided by 2. Note the radicall difference in number of operations performed based on input between Linear O(n) vs Binary Search O(log n).

| Binary Search |            |
|---------------|------------|
| Input Size(n) | # of Steps |
| 10            | 4          |
| 100           | 7          |
| 1,000         | 10         |
| 10,000        | 14         |
| 100,000       | 17         |
| 1,000,000     | 20         |
| 10,000,000    | 24         |
| 100,000,000   | 27         |
| 1,000,000,000 | 30         |

The formula to get the logarithm of a number is `log`<sub>`2`</sub>`n`.  For example, let's say we had an input size of **10,000**.  To find how many opearations this would take with Binary Search to find a target value, in a calculator you would run:

> `n` = 10,000 <br>
> `log`<sub>`2`</sub>`n` = **14** <br>
Finding the `log`<sub>`2`</sub> of a number, is equivelent to asking "how many times can I divide this by 2 until I reach 1?".  That's why the `log`<sub>`2`</sub> of 10,000 is 14.

## Recursion
Recursion occurs when a method invokes itself, like so:

<br

```java
public static void foo() {
    foo();
}
```

<br>

The above method will continue to call itself and adding one frame ontop of another in the stack until we reach a `StackOverflowError`.  We must add a condition for the method to be invoked called a **Base Case**.

Take a look at the following example:

<br>

```java
	public static void reduceByOne(int n) {
		
		if (n >= 0) { // we must add a condition to avoid a StackOverFlow error
					  // this is also called a Base Case.
			reduceByOne(n-1);
		}
		System.out.println("Completed Call: " + n);
	}
```

<br>

Within the `main()` method, if we run `	reduceByOne(10);`, it will return the following

```sh
Completed Call: -1
Completed Call: 0
Completed Call: 1
Completed Call: 2
Completed Call: 3
Completed Call: 4
Completed Call: 5
Completed Call: 6
Completed Call: 7
Completed Call: 8
Completed Call: 9
Completed Call: 10
```

<br>

***Why does the console print 10 last and -1 first?*** <br>
- The last method on top of the stack is the condition that breaks the recursive loop: `n = -1` which is `< 0`. 
- When that method completes, it allows the previous method (in which `n = 0`) to be complete and be released from the stack.
- This process continues all the way until the first call is popped off the stack. (`n = 10`).

### Using Recursion To Solve a Problem
#### Finding the nth term in the Fibonacci Sequence
We can break a recursive function down into a few main parts. First, let's understand/review what the fibonacci sequence is. It is a sequence of numbers where each entry is the sum of the previous 2 (starting with 0 and 1). 
The first few numbers of the fibonacci sequence are:
```
0, 1, 1, 2, 3, 5, 8, 13, 21
```

#### Base Case
With recursive functions, we are usually going to keep calling our own function (recursing) until we reach some condition called the base case. In the case of fibonacci sequence, the base cases are 0 and 1. So we can write a function that retrieves the nth number in the fibanoacci sequence, starting with these base cases:

```java
function find_nth_fibonacci(n) {
	if (n == 1) return 0;
	if (n == 2) return 1;
}
```

In this case, we directly return 0 and 1 for the 1st and 2nd terms of the sequence, respectively, because these are the base cases (the function should and would always return the same values when n=1 or n=2 are passed in as arguments). Once we have the base case, we can work on the recursive part.

#### Recursion
```java
	return fibonacci(n-1) + finbonacci(n-2)
```

This is all we have to write because we just want the sum of the previous 2 numbers. 

Putting it all together:
```java
function find_nth_fibonacci(n) {
	if (n == 1) return 0;
	if (n == 2) return 1;
	return fibonacci(n-1) + finbonacci(n-2);
}
```

To demonstrate this function in action, let's use fibonacci(3):
fibonacci(3) will return fibonacci(2) + fibonacci(1)
fibonacci(2) will return fibonacci(1) + fibonacci(0)
fibonacci(1) will return 1
fibonacci(0) will return 0

Without these base cases, the recursive calls would be infinite.

In the end, the solution will be 1 + 0 + 1 = 2.