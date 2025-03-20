# Stream API
The Java 8 [Stream API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html) is a functional-style way of defining operations on a stream of elements. Streams are an abstraction which allow defining operations which do not modify the source data and are lazily executed. Streams **do not store data**, they simply define operations like filtering, mapping, or reducing, and can be combined with other operations and then executed. Some built-in `Stream`s are located in the `java.util.stream` package.

Streams are divided into *intermediate* and *terminal* operations. Intermediate streams return a new stream and are always lazy - they don't actually execute until a terminal operation is called. Terminal operations trigger the execution of the stream pipeline, which allows efficiency by perfoming all operations in a single pass over the data.

Finally, reduction operations take a sequence of elements and combine them into a single result. Stream classes have the `reduce()` and `collect()` methods for this purpose, with many built-in operations defined in the `Collectors` class.

```java
List<Student> students = new ArrayList<>();
// add students...
List<Double> grades = students.stream()
                          .filter(s -> s.isAttending())
						  .mapToDouble(s -> s.getGrade)
						  .collect(Collectors.toList());
```

## Optional Class
[The `Optional` class](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) was introduced in Java 8 to reduce the need for excessive `null` value checking. An `Optional` is a kind of wrapper object which may or may not contain a value, with a few helper methods to handle existing or non-existent values (see Javadocs above).

Optionals are useful as replacements for `null` values when returning an "empty" response from a method. For example:

```java
public class OptionalExample {
  public Optional<String> getAmbiguousString(boolean b) {
    if (true) {
	  return Optional.of("awesome string!");
	} else {
	  return Optional.empty();
	}
  }
  
  public static void main(String[] args) {
    Optional<String> optString = getAmbiguousString(false);
	String theString = optString.orElse(""); // specify a fallback value
	System.out.println(theString);
	// we can use the String without fear of NullPointerException now
  }
}
```