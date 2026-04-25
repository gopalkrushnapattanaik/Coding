Java Practice Projects - Technical Documentation

## Table of Contents
1. [Algorithms Module](#algorithms-module)
2. [Design Patterns Module](#design-patterns-module)
3. [Concurrency Examples](#concurrency-examples)
4. [Java Features](#java-features)
5. [Q&A Section](#qa-section)

---

## Algorithms Module

### 1. Hit Counter Implementation

#### Files
- [HitCounter.java](Algorithms/HitCounter.java)
- [ThreadSafeHitCounter.java](Algorithms/ThreadSafeHitCounter.java)
- [HitCounterTest.java](Algorithms/HitCounterTest.java)

#### Summary
**HitCounter** implements a data structure that tracks hits in the last 300 seconds (5 minutes) using a circular buffer approach with two arrays.

**Key Features:**
- Uses two arrays: `times[]` and `counts[]` with size 300
- `hit(timestamp)`: Records a hit at the given timestamp - O(1)
- `getHits(timestamp)`: Returns total hits in the last 300 seconds - O(300)

**ThreadSafeHitCounter** is a thread-safe version using atomic operations.

**Key Features:**
- Uses `AtomicLongArray` and `AtomicIntegerArray`
- Thread-safe operations using `compareAndSet`
- Same time complexity as non-thread-safe version

---

### 2. LRU Cache Implementation

#### Files
- [LRUCache.java](Algorithms/src/com/practice/algorithm/lrucache/LRUCache.java)
- [Node.java](Algorithms/src/com/practice/algorithm/lrucache/Node.java)
- [LRUCacheUsingLinkedHashMap.java](Algorithms/src/com/practice/algorithm/lrucache/LRUCacheUsingLinkedHashMap.java)

#### Summary
Implements a Least Recently Used (LRU) Cache with O(1) operations for both `get` and `set`.

**Implementation Strategy:**
- **HashMap** for O(1) key-value lookup
- **Doubly Linked List** to track access order (most recent at head, least recent at tail)
- Dummy head and tail nodes for easier manipulation

**Operations:**
- `get(key)`: Returns value if exists, moves node to head - O(1)
- `set(key, value)`: Inserts/updates value, evicts LRU item if capacity reached - O(1)

**Alternative Implementation:**
- `LRUCacheUsingLinkedHashMap`: Uses Java's LinkedHashMap with access-order mode

---

### 3. Custom HashMap Implementation

#### File
- [CustomHashMap.java](Algorithms/src/com/practice/datastructure/hashmap/CustomHashMap.java)

#### Summary
Custom implementation of HashMap data structure using array and linked list for collision handling.

**Features:**
- Array of Entry nodes (`entryTable`)
- Linked list for handling hash collisions
- Hash function: `key.hashCode() % tableSize`

**Operations:**
- `put(key, value)`: Adds or updates entry - O(1) best case, O(N) worst case
- `get(key)`: Retrieves value by key - O(1) best case, O(N) worst case
- `remove(key)`: Removes entry if exists

---

### 4. Fibonacci Implementations

#### File
- [FibbonaciMemoization.java](Algorithms/src/com/practice/algorithm/fibbonaci/FibbonaciMemoization.java)

#### Summary
Three different approaches to calculate nth Fibonacci number:

**1. Iterative Approach**
- Time Complexity: O(n)
- Space Complexity: O(1)
- Most efficient for large numbers

**2. Recursive with Memoization**
- Uses `WeakHashMap` to cache results
- Time Complexity: O(n)
- Space Complexity: O(n)
- Demonstrates optimization technique

**3. Matrix Multiplication**
- Uses matrix power: [[1,1],[1,0]]^n
- Time Complexity: O(n)
- Space Complexity: O(1)

---

### 5. Heap-based Problems

#### File
- [MedianOfStream.java](Algorithms/src/com/practice/datastructure/heap/MedianOfStream.java)

#### Summary
Finds median of a data stream using two heaps.

**Strategy:**
- **maxHeap**: Stores smaller half of numbers (reversed order)
- **minHeap**: Stores larger half of numbers
- Maintain: maxHeap.size() = minHeap.size() or maxHeap.size() = minHeap.size() + 1

**Operations:**
- `addNum(num)`: Adds number to appropriate heap - O(log n)
- `findMedian()`: Returns median - O(1)

---

### 6. Linked List Problems

#### Files
- [ReverseLinkedList.java](Algorithms/src/com/practice/datastructure/linkedlist/ReverseLinkedList.java)
- [RemoveDuplicates.java](Algorithms/src/com/practice/datastructure/linkedlist/RemoveDuplicates.java)
- [RemoveNthNodeFromEnd.java](Algorithms/src/com/practice/datastructure/linkedlist/RemoveNthNodeFromEnd.java)

#### Summary
Common linked list operations and problems.

**Reverse Linked List:**
- Iterative approach using three pointers: previous, current, next
- Time: O(n), Space: O(1)

---

### 7. Stack Problems

#### File
- [BalancedParanthesis.java](Algorithms/src/com/practice/datastructure/stack/BalancedParanthesis.java)

#### Summary
Validates if a string of brackets is balanced.

**Algorithm:**
- Use stack to track opening brackets
- For closing brackets, check if they match the top of stack
- Returns "YES" if balanced, "NO" otherwise
- Time: O(n), Space: O(n)

---

### 8. Array Problems

#### File
- [TwoPointers.java](Algorithms/src/com/practice/datastructure/array/TwoPointers.java)

#### Summary
Comprehensive guide to two-pointer technique for array problems.

**Three Types of Two-Pointer Techniques:**

1. **Opposite Ends (Left-Right)**
   - Two Sum in sorted array
   - Container with most water
   - Time: O(n)

2. **Fast-Slow Pointers**
   - Remove duplicates from sorted array
   - Find middle of linked list
   - Detect cycles

3. **Sliding Window**
   - Longest substring without repeating characters
   - Maximum sum subarray

---

### 9. Interval Problems

#### File
- [MergeInterval.java](Algorithms/src/com/practice/algorithm/intervals/MergeInterval.java)

#### Summary
Merges overlapping intervals.

**Algorithm:**
1. Sort intervals by start time
2. Iterate and check for overlaps
3. Merge overlapping intervals
- Time: O(n log n), Space: O(n)

---

### 10. Stream API Examples

#### File
- [StreamExample.java](Algorithms/src/com/practice/stream/StreamExample.java)

#### Summary
Demonstrates Java 8 Stream API operations.

**Key Operations Covered:**
- `filter()`: Filter elements based on predicate
- `map()`: Transform elements
- `flatMap()`: Flatten nested structures
- `reduce()`: Aggregate values
- `collect()`: Collect results into collections
- `sorted()`: Sort with comparators

---

## Design Patterns Module

### 1. Singleton Pattern

#### Files
- [ThreadSafeSingleton.java](DesignPattern/src/com/practice/creational/singleton/ThreadSafeSingleton.java)
- [BillPughSingleton.java](DesignPattern/src/com/practice/creational/singleton/BillPughSingleton.java)
- [LazyInitializedSingleton.java](DesignPattern/src/com/practice/creational/singleton/LazyInitializedSingleton.java)

#### Summary
Multiple implementations of Singleton design pattern.

**ThreadSafeSingleton:**
- Two approaches:
  1. Synchronized method (simple but slower)
  2. Double-checked locking (better performance)

**BillPughSingleton:**
- Uses static inner class for lazy initialization
- Thread-safe without synchronization
- Best practice approach

---

### 2. Builder Pattern

#### File
- [NutritonalFacts.java](DesignPattern/src/com/practice/creational/builder/NutritonalFacts.java)

#### Summary
Implements Builder pattern for creating objects with many optional parameters.

**Features:**
- Immutable object with final fields
- Static inner `Builder` class
- Mandatory parameters in constructor
- Optional parameters via builder methods
- Fluent API (method chaining)

**Usage:**
```java
NutritonalFacts facts = new NutritonalFacts.Builder(servingSize, servings)
    .calories(100)
    .fat(5)
    .build();
```

---

### 3. Factory Pattern

#### File
- [ShapeFactory.java](DesignPattern/src/com/practice/creational/factory/ShapeFactory.java)

#### Summary
Simple factory pattern for creating shape objects.

**Implementation:**
- Static factory method `getShape(ShapeType type)`
- Switch-case based object creation
- Encapsulates object creation logic

---

### 4. Flyweight Pattern

#### Files
- [ShapeFactory.java](DesignPattern/src/com/practice/structural/flyweight/ShapeFactory.java)
- [Shape.java](DesignPattern/src/com/practice/structural/flyweight/Shape.java)
- [Circle.java, Rectangle.java, Square.java](DesignPattern/src/com/practice/structural/flyweight/)

#### Summary
Implements Flyweight pattern to share objects and reduce memory usage.

**Features:**
- HashMap to cache and reuse shape instances
- Thread-safe object creation using double-checked locking
- Shares intrinsic state (shape type), varies extrinsic state (dimensions)

---

### 5. Producer-Consumer Pattern

#### Files
- [ProducerConsumerPattern.java](DesignPattern/src/com/practice/behavioral/producerconsumer/arrayblockingqueue/ProducerConsumerPattern.java)
- [Producer.java](DesignPattern/src/com/practice/behavioral/producerconsumer/arrayblockingqueue/Producer.java)
- [Consumer.java](DesignPattern/src/com/practice/behavioral/producerconsumer/arrayblockingqueue/Consumer.java)

#### Summary
Classic producer-consumer problem implementation using ArrayList and wait/notify.

**Producer:**
- Produces numbers incrementally
- Waits if queue is full (size >= capacity)
- Notifies consumers after producing

**Consumer:**
- Consumes elements from queue
- Waits if queue is empty
- Notifies producers after consuming

**Synchronization:**
- Uses synchronized block on shared list
- `wait()` and `notifyAll()` for coordination

---

## Concurrency Examples

### 1. Deadlock Example

#### Files
- [DeadLockTest.java](Thread-Dump/deadlock/DeadLockTest.java)
- [A.java](Thread-Dump/deadlock/A.java)
- [B.java](Thread-Dump/deadlock/B.java)

#### Summary
Demonstrates classic deadlock scenario with two threads and two resources.

**Deadlock Condition:**
- Thread1: Locks A → tries to lock B
- Thread2: Locks B → tries to lock A
- Both threads wait indefinitely (deadlock)

**Key Learning:**
- Always acquire locks in the same order to avoid deadlock
- Use timeout mechanisms
- Consider using higher-level concurrency utilities

---

### 2. Future Example

#### Files
- [FutureExample.java](Future-Example/src/com/future/example/FutureExample.java)
- [CustomTask.java](Future-Example/src/com/future/example/CustomTask.java)

#### Summary
Demonstrates Java's `Future` interface for asynchronous computation.

**Features:**
- `ExecutorService` with fixed thread pool
- `Future.get()`: Blocking call that waits for result
- Demonstrates asynchronous task execution

---

### 3. CompletableFuture Example

#### File
- [CompletableFutureExample.java](Future-Example/src/com/completablefuture/example/CompletableFutureExample.java)

#### Summary
Advanced asynchronous programming with CompletableFuture.

**Key Operations Demonstrated:**
1. **supplyAsync**: Execute computation and return value
2. **runAsync**: Execute without returning value
3. **thenApply**: Transform result
4. **thenCompose**: Chain dependent futures
5. **allOf**: Wait for all futures to complete
6. **anyOf**: Proceed when any future completes

**Benefits:**
- Non-blocking operations
- Easy composition of async tasks
- Better exception handling than Future

---

## Java Features

### 1. Object Cloning

#### Files
- [Employee.java](JavaCloning/src/com/practice/clone/model/Employee.java)
- [Department.java](JavaCloning/src/com/practice/clone/model/Department.java)
- [TestCloning.java](JavaCloning/src/com/practice/clone/tester/TestCloning.java)

#### Summary
Demonstrates shallow copy vs deep copy in Java.

**Deep Copy (Employee):**
- Overrides `clone()` method
- Clones nested objects (Department)
- Changes to clone don't affect original

**Shallow Copy (Department):**
- Uses default `super.clone()`
- Primitive fields are copied
- Reference fields point to same objects

**Copy Constructor:**
- Alternative to Cloneable
- More flexible and safer
- Explicit control over copying logic

---

### 2. Try-With-Resources

#### Files
- [TryWithResourceTester.java](Try-With-Resources/src/com/practice/trywithresources/TryWithResourceTester.java)
- [CustomResource.java](Try-With-Resources/src/com/practice/trywithresources/CustomResource.java)

#### Summary
Demonstrates automatic resource management in Java 7+.

**Features:**
- Resource declared in try() is auto-closed
- Resource must implement `AutoCloseable`
- `close()` called automatically after try block
- Reduces boilerplate code
- Prevents resource leaks

**CustomResource:**
- Implements `AutoCloseable`
- Overrides `close()` method
- Demonstrates custom resource cleanup

---

### 3. WebSocket Server

#### File
- [Server.java](WebSocket/src/com/practice/websocket/server/Server.java)

#### Summary
Basic WebSocket server implementation.

**Features:**
- Creates ServerSocket on port 8080
- Accepts client connections
- Foundation for WebSocket communication

---

## Q&A Section

### Data Structures

**Q1: How does the LRU Cache achieve O(1) time complexity for both get and set operations?**
- **File:** [LRUCache.java](Algorithms/src/com/practice/algorithm/lrucache/LRUCache.java)
- **Answer:** The LRU Cache uses a combination of:
  1. **HashMap** for O(1) key lookup
  2. **Doubly Linked List** for O(1) insertion/deletion
  - The HashMap stores key-node pairs, allowing instant access to any node
  - The linked list maintains access order with dummy head/tail nodes
  - When accessing a node, it's removed from its current position and inserted at the head (both O(1))
  - When capacity is reached, the tail.prev node is removed (O(1))

**Q2: What's the difference between thread-safe and non-thread-safe HitCounter?**
- **Files:** [HitCounter.java](Algorithms/HitCounter.java), [ThreadSafeHitCounter.java](Algorithms/ThreadSafeHitCounter.java)
- **Answer:**
  - **Non-thread-safe:** Uses regular arrays, no synchronization, race conditions possible
  - **Thread-safe:** Uses `AtomicLongArray` and `AtomicIntegerArray` with `compareAndSet` for atomic updates
  - Thread-safe version prevents data corruption in multi-threaded environments
  - Both maintain same time complexity, but thread-safe has slight overhead

**Q3: How does custom HashMap handle collisions?**
- **File:** [CustomHashMap.java](Algorithms/src/com/practice/datastructure/hashmap/CustomHashMap.java)
- **Answer:** Uses **chaining** with linked lists:
  - When hash collision occurs, new node is appended to the linked list at that index
  - During lookup, traverses the linked list checking `equals()` on keys
  - Best case O(1) when no collisions
  - Worst case O(n) when all keys hash to same index

**Q4: Why use two heaps for finding median of a stream?**
- **File:** [MedianOfStream.java](Algorithms/src/com/practice/datastructure/heap/MedianOfStream.java)
- **Answer:**
  - **maxHeap** stores smaller half (largest element at top)
  - **minHeap** stores larger half (smallest element at top)
  - Median is always at the tops of these heaps
  - This allows O(1) median retrieval and O(log n) insertion
  - Alternative approaches like sorting would be O(n log n) per insertion

---

### Algorithms

**Q5: What are the different approaches to calculate Fibonacci numbers and their trade-offs?**
- **File:** [FibbonaciMemoization.java](Algorithms/src/com/practice/algorithm/fibbonaci/FibbonaciMemoization.java)
- **Answer:**
  1. **Iterative:** O(n) time, O(1) space - Most efficient
  2. **Recursive with Memoization:** O(n) time, O(n) space - Good for demonstrating optimization
  3. **Matrix Multiplication:** O(n) time, O(1) space - Elegant mathematical approach
  - Iterative is best for production code
  - Memoization shows optimization techniques
  - Matrix approach can be optimized to O(log n) with fast matrix exponentiation

**Q6: How does the two-pointer technique reduce time complexity?**
- **File:** [TwoPointers.java](Algorithms/src/com/practice/datastructure/array/TwoPointers.java)
- **Answer:** Reduces from O(n²) to O(n) by:
  - **Opposite ends:** Eliminates nested loop in sorted array problems
  - **Fast-slow:** Single pass instead of multiple iterations
  - **Sliding window:** Maintains valid range without recalculating
  - Example: Two Sum in sorted array - instead of checking all pairs O(n²), move pointers based on sum comparison O(n)

**Q7: How do you check if brackets are balanced?**
- **File:** [BalancedParanthesis.java](Algorithms/src/com/practice/datastructure/stack/BalancedParanthesis.java)
- **Answer:**
  - Use a **stack** to track opening brackets
  - For opening brackets: push to stack
  - For closing brackets: pop and check if it matches
  - If stack is empty when encountering closing bracket → unbalanced
  - If stack is not empty at end → unbalanced
  - Time: O(n), Space: O(n)

---

### Design Patterns

**Q8: What's the best way to implement Singleton pattern and why?**
- **Files:** [BillPughSingleton.java](DesignPattern/src/com/practice/creational/singleton/BillPughSingleton.java), [ThreadSafeSingleton.java](DesignPattern/src/com/practice/creational/singleton/ThreadSafeSingleton.java)
- **Answer:** **Bill Pugh Singleton** (static inner class) is best because:
  - **Thread-safe** without synchronization overhead
  - **Lazy initialization** - instance created only when needed
  - **No double-checked locking complexity**
  - Works because static inner class is loaded only when referenced
  - Alternative: Double-checked locking works but more complex

**Q9: When should you use Builder pattern?**
- **File:** [NutritonalFacts.java](DesignPattern/src/com/practice/creational/builder/NutritonalFacts.java)
- **Answer:** Use Builder when:
  - Class has many parameters (especially optional ones)
  - Want immutable objects
  - Need readable, self-documenting code
  - Telescoping constructor anti-pattern would occur
  - Benefits: Fluent API, parameter validation in one place, prevents inconsistent object states

**Q10: How does Flyweight pattern save memory?**
- **File:** [ShapeFactory.java](DesignPattern/src/com/practice/structural/flyweight/ShapeFactory.java)
- **Answer:**
  - Shares common objects instead of creating new instances
  - Uses HashMap to cache and reuse objects
  - Separates **intrinsic state** (shared) from **extrinsic state** (passed as parameters)
  - Example: Shape type is intrinsic (shared), dimensions are extrinsic (not shared)
  - Memory savings proportional to number of shared instances

**Q11: How does Producer-Consumer pattern prevent race conditions?**
- **Files:** [Producer.java](DesignPattern/src/com/practice/behavioral/producerconsumer/arrayblockingqueue/Producer.java), [Consumer.java](DesignPattern/src/com/practice/behavioral/producerconsumer/arrayblockingqueue/Consumer.java)
- **Answer:**
  - Uses **synchronized** block on shared list
  - **wait()** releases lock and waits when condition not met
  - **notifyAll()** wakes waiting threads after state change
  - Prevents multiple threads from modifying list simultaneously
  - Modern alternative: Use `BlockingQueue` for cleaner implementation

---

### Concurrency

**Q12: What causes deadlock and how to prevent it?**
- **File:** [DeadLockTest.java](Thread-Dump/deadlock/DeadLockTest.java)
- **Answer:**
  - **Cause:** Circular wait for resources
    - Thread1: locks A, waits for B
    - Thread2: locks B, waits for A
  - **Prevention strategies:**
    1. Always acquire locks in same order
    2. Use lock timeout (`tryLock` with timeout)
    3. Use higher-level concurrency utilities
    4. Avoid nested locks when possible
    5. Use deadlock detection tools

**Q13: What's the difference between Future and CompletableFuture?**
- **Files:** [FutureExample.java](Future-Example/src/com/future/example/FutureExample.java), [CompletableFutureExample.java](Future-Example/src/com/completablefuture/example/CompletableFutureExample.java)
- **Answer:**
  - **Future:**
    - Simple async result holder
    - `get()` is blocking
    - No composition or chaining
    - Limited exception handling
  - **CompletableFuture:**
    - Rich API for async programming
    - Non-blocking with callbacks (`thenApply`, `thenCompose`)
    - Easy composition (`allOf`, `anyOf`)
    - Better exception handling (`exceptionally`, `handle`)
    - Can be completed manually

---

### Java Features

**Q14: What's the difference between shallow copy and deep copy?**
- **Files:** [Employee.java](JavaCloning/src/com/practice/clone/model/Employee.java), [Department.java](JavaCloning/src/com/practice/clone/model/Department.java)
- **Answer:**
  - **Shallow Copy:**
    - Copies primitive values
    - Reference fields point to same objects
    - Changes to nested objects affect both original and copy
  - **Deep Copy:**
    - Copies primitive values
    - Recursively copies nested objects
    - Original and copy are completely independent
  - **Implementation:** Override `clone()` and clone nested objects explicitly

**Q15: Why use try-with-resources instead of finally block?**
- **File:** [TryWithResourceTester.java](Try-With-Resources/src/com/practice/trywithresources/TryWithResourceTester.java)
- **Answer:**
  - **Benefits:**
    1. Automatic resource cleanup
    2. Less boilerplate code
    3. Handles exceptions in close() properly
    4. Prevents resource leaks
    5. Cleaner, more readable code
  - **Requirement:** Resource must implement `AutoCloseable`
  - Finally blocks still execute after resources are closed

**Q16: How do Java 8 Streams improve code readability?**
- **File:** [StreamExample.java](Algorithms/src/com/practice/stream/StreamExample.java)
- **Answer:**
  - **Declarative style:** Describe what, not how
  - **Fluent API:** Method chaining reads like English
  - **Functional operations:** map, filter, reduce are self-documenting
  - **Example:**
    ```java
    // Before
    List<String> result = new ArrayList<>();
    for (String s : list) {
        if (s.length() > 3) {
            result.add(s.toUpperCase());
        }
    }
    
    // After
    List<String> result = list.stream()
        .filter(s -> s.length() > 3)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
    ```

---

### Performance & Optimization

**Q17: When should you use memoization and what's the trade-off?**
- **File:** [FibbonaciMemoization.java](Algorithms/src/com/practice/algorithm/fibbonaci/FibbonaciMemoization.java)
- **Answer:**
  - **Use when:**
    - Function has overlapping subproblems
    - Function is pure (same input → same output)
    - Computation is expensive
  - **Trade-offs:**
    - Pros: Dramatically reduces time complexity (exponential → linear)
    - Cons: Uses extra memory for cache
    - Uses `WeakHashMap` to allow garbage collection of cached values

**Q18: Why is double-checked locking used in thread-safe Singleton?**
- **File:** [ThreadSafeSingleton.java](DesignPattern/src/com/practice/creational/singleton/ThreadSafeSingleton.java)
- **Answer:**
  - **First check (outside synchronized):** Avoids synchronization overhead for already-initialized instance
  - **Second check (inside synchronized):** Ensures only one thread creates instance
  - Without double-checking, every call would synchronize (slower)
  - **Note:** Requires `volatile` keyword on instance variable (not shown in code, should be added)

---

### Practical Applications

**Q19: How would you implement rate limiting using HitCounter?**
- **Files:** [HitCounter.java](Algorithms/HitCounter.java), [ThreadSafeHitCounter.java](Algorithms/ThreadSafeHitCounter.java)
- **Answer:**
  - Track requests per user/IP in last N seconds
  - Call `hit(timestamp)` for each request
  - Check `getHits(currentTime)` before processing
  - If hits exceed threshold, reject request
  - Use `ThreadSafeHitCounter` in production for multi-threaded servers
  - Can extend to different time windows by changing window size

**Q20: When would you use a custom HashMap implementation instead of Java's?**
- **File:** [CustomHashMap.java](Algorithms/src/com/practice/datastructure/hashmap/CustomHashMap.java)
- **Answer:**
  - **Educational purposes:** Understanding internals
  - **Special requirements:**
    - Custom hash functions
    - Different collision resolution (e.g., open addressing)
    - Memory-constrained environments
  - **In production:** Almost always use Java's HashMap
    - Java's implementation is highly optimized
    - Handles rehashing, load factor automatically
    - Uses tree nodes for buckets with many collisions (Java 8+)

---

## Best Practices Demonstrated

### 1. Thread Safety
- Use atomic classes for thread-safe counters
- Implement proper synchronization with wait/notify
- Prefer immutable objects
- Use concurrent collections when available

### 2. Design Patterns
- Singleton: Use Bill Pugh approach
- Builder: For objects with many parameters
- Factory: Encapsulate object creation
- Flyweight: Share objects to save memory

### 3. Coding Standards
- Clear method documentation
- Time and space complexity comments
- Meaningful variable names
- Proper exception handling

### 4. Performance
- Choose right data structure (HashMap for O(1), TreeMap for sorted)
- Use appropriate algorithms (two pointers instead of nested loops)
- Consider space-time trade-offs (memoization)
- Profile before optimizing

---

## Interview Preparation Tips

### Data Structure Questions
1. **Always clarify requirements:** Time/space constraints, data characteristics
2. **Start with brute force:** Then optimize
3. **Think about edge cases:** Empty input, single element, duplicates
4. **Explain complexity:** Big-O for time and space

### Common Patterns
- Two pointers for array/list problems
- Sliding window for substring/subarray
- Stack for bracket matching, monotonic problems
- Heap for top-K, median problems
- HashMap for frequency counting, caching

### Concurrency Questions
- Understand deadlock conditions
- Know synchronization primitives (synchronized, wait/notify, Lock)
- Be familiar with concurrent collections
- Understand thread lifecycle and states

---

## Summary

This codebase demonstrates:
- **Core data structures** with custom implementations
- **Classic algorithms** with multiple approaches
- **Design patterns** following best practices
- **Concurrency patterns** and pitfalls
- **Modern Java features** (Streams, CompletableFuture, try-with-resources)

Each module focuses on practical, interview-relevant problems with detailed explanations and working code examples.

---

**Last Updated:** February 4, 2026  
**Total Java Files:** 149  
**Modules:** 8 (Algorithms, Design Patterns, Concurrency, WebSocket, Cloning, Try-With-Resources, Future Examples, Thread Dumps)
