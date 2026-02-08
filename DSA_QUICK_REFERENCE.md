# 📋 DSA Quick Reference - Problems By Category with Solutions

**Last Updated:** February 2026 | **Format:** Organized by Data Structure + Algorithm Type

---

## 🎯 QUICK LOOKUP TABLE

Jump to any category:
- [Arrays](#arrays-problems)
- [Linked Lists](#linked-lists-problems)
- [Stacks](#stacks-problems)
- [Queues](#queues-problems)
- [Hash Maps](#hash-maps-problems)
- [Trees](#trees-problems)
- [Heaps](#heaps-problems)
- [Sorting](#sorting-problems)
- [Sliding Window](#sliding-window-problems)
- [Strings](#string-problems)
- [Dynamic Programming](#dynamic-programming-problems)
- [Math](#math-problems)
- [Special Algorithms](#special-algorithm-problems)

---

## 📦 ARRAYS PROBLEMS

### **Problem Catalog (25+ Problems)**

#### **Searching & Lookup (2 Problems)**
```
1. BinarySearch
   File: com/practice/datastructure/array/BinarySearch.java
   Type: Divide & Conquer
   Prerequisites: Sorted Array
   Concepts: Binary Search, Mid Calculation, Range Narrowing
   Time: O(log n) | Space: O(1)
   Pattern: Check middle → go left or right
   Key Trick: Avoid integer overflow in mid calculation
   Related: SearchInAlmostSortedArray
   
2. SearchInAlmostSortedArray
   Concepts: Modified Binary Search
   Time: O(log n) | Space: O(1)
   Pattern: Account for unsorted middle element
   Key Trick: Check if mid is better alternative than expected
```

#### **Pair/Triplet Finding (3 Problems)**
```
3. TwoSum
   Concepts: HashMap Lookup, Hash Table
   Time: O(n) | Space: O(n)
   Pattern: For each num, check if (target - num) exists
   Key Trick: Store numbers in map as you iterate
   Follow-up: Find indices, sorted array variant
   
4. ThreeSum
   Concepts: Sorting, Two Pointers, Deduplication
   Time: O(n²) | Space: O(1)
   Pattern: Sort → Fix one → Two pointer rest
   Key Trick: Skip duplicates to avoid repeated results
   Follow-up: FourSum, closest sum variant
   
5. FourSum
   Concepts: Nested Two Pointers
   Time: O(n³) | Space: O(1)
   Pattern: Sort → Fix two outer → Two pointer inner
   Key Trick: Early termination if sum impossible
```

#### **Array Manipulation (5 Problems)**
```
6. RotateArray
   Concepts: Array Reversal, Cyclic Shift
   Time: O(n) | Space: O(1)
   Approaches:
     a) Reverse: Reverse all → reverse first k → reverse rest
     b) Cyclic: Rotate each element k positions
   Key Trick: Reversal approach is elegant and space-efficient
   Follow-up: Rotate matrix, rotate string
   
7. MoveZeros
   Concepts: Two Pointers, In-Place Manipulation
   Time: O(n) | Space: O(1)
   Pattern: Keep pointer at next non-zero position
   Key Trick: Place element and advance position only on non-zero
   Follow-up: Move zeros to beginning, keep other order
   
8. SegregateEvenOddNumbers
   Concepts: Partitioning, Two Pointers
   Time: O(n) | Space: O(1)
   Pattern: Left pointer finds odd, right finds even, swap
   Key Trick: Think of partitioning problem
   Follow-up: Segregate positive/negative
   
9. SeggregateZerosOnesTwos (Dutch National Flag)
   Concepts: Three Pointers, Partitioning
   Time: O(n) | Space: O(1)
   Pattern: Keep 0s on left, 2s on right, 1s in middle
   Key Trick: Three pointers - low, mid, high
   Follow-up: K colors variation
   
10. SortZeroOnes
    Concepts: Binary Array Sorting
    Time: O(n) | Space: O(1)
    Pattern: Count 0s, place them, fill rest with 1s
    Key Trick: Simpler two-pointer approach
```

#### **Array Analysis (4 Problems)**
```
11. Largest_Smallest_Number
    Concepts: Min/Max Tracking, Single Pass
    Time: O(n) | Space: O(1)
    Pattern: Initialize with first element, track both in loop
    Key Trick: Initialize before loop to avoid special case
    
12. Second_Largest_Smallest
    Concepts: Two-Level Tracking
    Time: O(n) | Space: O(1)
    Approaches:
      a) Sorting then access 2nd position
      b) Track largest and second separately
    Key Trick: Handle edge cases (duplicates, < 2 elements)
    
13. Local_Maxima
    Concepts: Peak Finding, Neighbors
    Time: O(n) | Space: O(n) or O(1)
    Pattern: Element > both neighbors is local max
    Key Trick: Handle edge indices (first and last)
    Follow-up: Find global maximum peak
    
14. NumberCounts
    Concepts: Frequency Counting, HashMap
    Time: O(n) | Space: O(n)
    Pattern: HashMap stores element → count
    Key Trick: Use getOrDefault for cleaner code
    Follow-up: Top-K frequent, group by frequency
```

#### **Advanced Array Problems (11 Problems)**
```
15. TwoPointers
    Concepts: Container Width-Height, Merge Strategies
    Time: O(n) | Space: O(1)
    Approaches:
      a) Container: Maximize area with inner pointers
      b) Merge: Two sorted arrays with external array
    Key Trick: For container, always move smaller pointer
    Follow-up: Trapping water between bars
    
16. TrappingRainWater
    Concepts: Prefix/Suffix Maximum, Dynamic Programming
    Time: O(n) | Space: O(n)
    Approaches:
      a) Precompute left_max and right_max arrays
      b) Two pointers with tracking
    Key Trick: At each position, water = min(left_max, right_max) - height
    Follow-up: Rain water in 2D grid
    
17. StockBuySell
    Concepts: Greedy, State Tracking, Single Pass
    Time: O(n) | Space: O(1)
    Pattern: Track minimum price seen, calculate profit
    Key Trick: Profit = price - min_price_so_far
    Follow-up: Multiple transactions allowed, cooldown period
    
18. MatrixDiagonalSum
    Concepts: Matrix Traversal, Diagonal Logic
    Time: O(n²) | Space: O(1)
    Pattern:
      - Principal diagonal: matrix[i][i]
      - Secondary diagonal: matrix[i][n-1-i]
      - Handle overlap for odd-sized matrices
    Key Trick: Skip middle element if n is odd (counted twice)
    Follow-up: All diagonal sums, diagonal traversal
    
19. PrintAlternateElement
    Concepts: Index Manipulation
    Time: O(n) | Space: O(1)
    Pattern: Loop with step = 2
    
20. Pyramid
    Concepts: Pattern Printing, Nested Loops
    Time: O(n²) | Space: O(1)
    Pattern: Outer loop for rows, inner for columns
    Key Trick: Calculate spaces and stars based on row number
    
21. MergeStrings
    Concepts: Two Pointer String Merge
    Time: O(n) | Space: O(1)
    Pattern: Alternate characters from both strings
    Key Trick: Merge in-place or build new string
```

---

## 🔗 LINKED LISTS PROBLEMS

### **Problem Catalog (9 Problems)**

#### **Basic Implementation (3 Problems)**
```
1. LinkNode
   Type: Node Structure Definition
   Concepts: Single node with data and next reference
   
2. LinkedList
   Type: Core Linked List Class
   Operations: Insert, Delete, Display
   
3. SinglyLinkedList & SinglyLinkedListImpl
   Type: Full Implementation
   Methods: Add, Remove, Display, Size tracking
```

#### **Traversal & Analysis (3 Problems)**
```
4. MiddleOfLinkedList
   Concepts: Fast & Slow Pointers
   Time: O(n) | Space: O(1)
   Pattern: Slow moves 1, Fast moves 2
   Key Trick: Fast reaches end when slow is at middle
   
5. LinkedListKthElementFromEnd
   Concepts: Two Pointers with Gap
   Time: O(n) | Space: O(1)
   Pattern: Create k-distance gap between pointers
   Key Trick: Move both together until fast reaches end
   
6. GetNodeValue
   Concepts: Index-based Access
   Time: O(n) | Space: O(1)
   Pattern: Traverse k steps and return node
```

#### **Structural Operations (2 Problems)**
```
7. ReverseLinkedList
   Concepts: Pointer Reversal, Iterative/Recursive
   Time: O(n) | Space: O(1) iterative, O(n) recursive
   Approaches:
      a) Iterative: Three pointers (prev, current, next)
      b) Recursive: Reverse rest then point back
   Key Trick: Don't lose reference to next node before reversing
   Follow-up: Reverse groups of K, reverse alternate nodes
   
8. ReverseDoublyLinkedList
   Concepts: Bidirectional Pointer Reversal
   Time: O(n) | Space: O(1)
   Pattern: Swap next and prev for each node
```

#### **Advanced Problems (2 Problems)**
```
9. LinkedListCycle
   Concepts: Floyd's Tortoise & Hare Algorithm
   Time: O(n) | Space: O(1)
   Pattern: Slow and fast pointers meet in cycle
   Key Trick: If no cycle, fast reaches null first
   Follow-up: Find cycle start node
   
10. RemoveNthNodeFromEnd
    Concepts: Two Pointers with Dummy Node
    Time: O(n) | Space: O(1)
    Pattern: Create dummy pointing to head, use gap
    Key Trick: Dummy node handles head removal elegantly
    
11. RemoveDuplicates
    Concepts: HashMap, Deduplication
    Time: O(n) | Space: O(n)
    Pattern: Track seen nodes, skip duplicates
    
12. mergeSortedLinkedLists
    Concepts: Two Pointer Merge, Comparison
    Time: O(n+m) | Space: O(1)
    Pattern: Compare heads, attach smaller, advance pointer
    Key Trick: Dummy node simplifies logic
    
13. DoublyLinkedListNode
    Type: Node with bidirectional links
```

---

## 🔴 STACKS PROBLEMS

### **Problem Catalog (2 Problems)**

```
1. BalancedParanthesis
   Concepts: Stack, Expression Parsing, Matching
   Time: O(n) | Space: O(n)
   Pattern:
      - Push opening brackets
      - Pop and match on closing brackets
      - Check empty at end
   Key Trick: Different bracket types can be mixed
   Use Cases: Compiler syntax checking, math expression validation
   
2. EqualStacks
   Concepts: Stack Operations, Height Matching, Simultaneous Search
   Time: O(n) | Space: O(n)
   Pattern:
      - Calculate height of each stack
      - Find common base height
      - Work backwards from highest
   Key Trick: Remove from tallest until heights match
   Follow-up: Equalize stacks by moving elements
```

---

## 📤 QUEUES PROBLEMS

### **Problem Catalog (3 Problems)**

```
1. HitCounterUsingQueue
   Concepts: Time Window, Deque, Timestamp Tracking
   Time: O(n) per query | Space: O(n)
   Pattern:
      - Store timestamps in deque
      - Remove expired timestamps (outside window)
      - Count remaining
   Key Trick: Process queries in sorted timestamp order
   Follow-up: Hit counter for streaming data
   
2. LevelOrderTraversal
   Concepts: Queue, BFS, Tree Traversal, Level-by-Level
   Time: O(n) | Space: O(w) where w is max width
   Pattern:
      - Enqueue root
      - For each level, process all current nodes
      - Enqueue their children
   Key Trick: Process by levels using queue size
   Follow-up: Zigzag, spiral level order
   
3. ZigZagTraversal
   Concepts: Deque, Bidirectional Processing, Alternating Direction
   Time: O(n) | Space: O(w)
   Pattern:
      - Alternate direction for each level
      - Left-to-right: pollFirst (add children to back)
      - Right-to-left: pollLast (add children to front)
   Key Trick: Use deque instead of regular queue
   Follow-up: Spiral traversal, diagonal traversal
```

---

## 🗂️ HASH MAPS PROBLEMS

### **Problem Catalog (2 Problems)**

```
1. CustomHashMap
   Concepts: Hash Function, Collision Resolution, Bucketing
   Time: O(1) average | Space: O(n)
   Implementation Details:
      - Hash function: hashCode % capacity
      - Collision handling: Chaining with linked lists
      - Load factor: Resize when load > threshold
      - Operations: put, get, remove
   Key Trick: Good hash function distributes keys uniformly
   Follow-up: Open addressing, quadratic probing
   
2. CustomHashMapTest
   Type: Unit Tests
   Coverage: Basic operations, collisions, resizing
```

---

## 🌳 TREES PROBLEMS

### **Problem Catalog (5 Problems)**

```
1. TreeNode & Tree
   Type: Basic Structures
   Concepts: Node with data, left, right references
   
2. BinaryTree
   Concepts: Tree Construction, Properties
   Time: O(n) | Space: O(h)
   Methods: Height, Size, Is Balanced
   
3. BinaryTreeBFS
   Concepts: Breadth-First Search, Queue-Based
   Time: O(n) | Space: O(w)
   Pattern:
      - Queue for frontier nodes
      - Process level by level
      - Enqueue children of current nodes
   Key Trick: Know width at each level for space analysis
   Use Case: Level-order output, shortest path in tree
   
4. BinaryTreeDFS
   Concepts: Depth-First Search, Recursion
   Time: O(n) | Space: O(h)
   Traversal Orders:
      a) Preorder: Root → Left → Right (prefix)
      b) Inorder: Left → Root → Right (sorted for BST)
      c) Postorder: Left → Right → Root (cleanup)
   Key Trick: Choose traversal based on problem requirement
   Use Case: Expression evaluation, BST validation
   
5. BinaryTreeTest
   Type: Test Cases
```

---

## 📚 HEAPS PROBLEMS

### **Problem Catalog (3 Problems)**

```
1. TopKFrequentElements
   Concepts: Min-Heap, Frequency Counting, K-Selection
   Time: O(n log k) | Space: O(k)
   Pattern:
      - Count frequency of all elements
      - Maintain min-heap of size k
      - Top k most frequent are in heap
   Key Trick: Use heap size k (not n) for optimization
   Why Min-Heap: When size exceeds k, remove minimum (least frequent)
   Follow-up: Top-K largest elements, top-K pairs
   
2. LastStone
   Concepts: Max-Heap, Simulation, Game Logic
   Time: O(n log n) | Space: O(n)
   Pattern:
      - Max-heap stores stone weights
      - Repeatedly remove top two heaviest
      - If different weights, add difference back
      - Continue until one stone left
   Key Trick: Simulate process step by step
   
3. SmashStones
   Concepts: Heap Operations, State Tracking
   Time: O(n log n) | Space: O(n)
   Pattern: Similar to LastStone with additional tracking
```

---

## 🔀 SORTING PROBLEMS

### **Problem Catalog (4 Problems)**

```
1. BubbleSort
   Concepts: Adjacent Swap, Simple Comparison
   Time: O(n²) avg, best O(n), worst O(n²)
   Space: O(1)
   Stability: Yes
   Pattern:
      - Compare adjacent elements
      - Swap if out of order
      - Largest "bubbles" to end each pass
   Key Trick: Optimize with flag to detect if already sorted
   Best Use: Educational, nearly sorted data
   
2. SelectionSort
   Concepts: Find Minimum, Swap
   Time: O(n²) guaranteed
   Space: O(1)
   Stability: No
   Pattern:
      - Find minimum in unsorted portion
      - Swap with start of unsorted portion
      - Move boundary right
   Key Trick: Guaranteed O(n²), useful when write operations expensive
   Best Use: When writing to array is costly (external sort)
   
3. InsertionSort
   Concepts: Shift, Placement, Adaptive
   Time: O(n²) avg, O(n) best, O(n²) worst
   Space: O(1)
   Stability: Yes
   Pattern:
      - Take element from unsorted
      - Insert into correct position in sorted
      - Shift larger elements right
   Key Trick: Excellent for nearly sorted data
   Best Use: Small arrays, final pass after quicksort
   
4. MergeSort
   Concepts: Divide & Conquer, Merge
   Time: O(n log n) guaranteed
   Space: O(n)
   Stability: Yes
   Pattern:
      - Divide array in half
      - Recursively sort halves
      - Merge two sorted halves
   Key Trick: Extra space for guaranteed O(n log n)
   Best Use: When consistent O(n log n) required, external data
   Follow-up: In-place merge, merge 3 sorted arrays
```

---

## 🪟 SLIDING WINDOW PROBLEMS

### **Problem Catalog (4 Problems)**

```
1. MaxSumSubArrayOfK (Fixed Window)
   Concepts: Fixed Window Size, Sliding Calculation
   Time: O(n) | Space: O(1)
   Pattern:
      - Calculate sum of first k elements
      - Slide window: remove leftmost, add rightmost
      - Track maximum
   Key Trick: Avoid recalculating full window sum
   
2. MaxSumOfKthElement (Fixed Window)
   Concepts: K-Element Selection
   Time: O(n) | Space: O(1)
   
3. LongestSubString (Dynamic Window)
   Concepts: Dynamic Window, HashMap Tracking
   Time: O(n) | Space: O(min(n, charset))
   Pattern:
      - Expand right pointer to include characters
      - Shrink left pointer when duplicate found
      - Track character positions in map
   Key Trick: Update character position instead of removing
   Follow-up: Longest with at most K distinct characters
   
4. minSubArrayLen (Dynamic Window)
   Concepts: Minimum Length, Target Sum
   Time: O(n) | Space: O(1)
   Pattern:
      - Expand right to meet condition
      - Shrink left while condition maintained
      - Track minimum window size
   Key Trick: Two pointer approach without nested loops
   Follow-up: Minimum product subarray, target sum variations
```

---

## 📝 STRING PROBLEMS

### **Problem Catalog (8 Problems)**

```
1. StringValidation
   Concepts: Character Checking, Predicate Validation
   Time: O(n) | Space: O(1)
   Pattern: Check each character against rules
   
2. StringPermutation
   Concepts: Frequency Count, Anagram Detection
   Time: O(n) | Space: O(1)
   Pattern:
      - Count characters in both strings
      - Compare frequency maps
   Key Trick: Only 26 letters, fixed space
   Follow-up: Minimal window containing all chars of s1
   
3. StringRotation
   Concepts: Substring Search, Concatenation Trick
   Time: O(n) | Space: O(n)
   Pattern:
      - If s2 is rotation of s1, then s2 is substring of s1+s1
      - Example: "waterbottle" → "bottlewater" in "waterbottlewaterbottle"
   Key Trick: Clever one-liner using concatenation
   
4. StringCompression
   Concepts: Run-Length Encoding, Efficient Concatenation
   Time: O(n) | Space: O(n)
   Pattern:
      - Count consecutive same characters
      - Build compressed string with count
      - Check if shorter
   Key Trick: Use StringBuilder, not string concatenation
   
5. LongetSubString
   Concepts: Sliding Window, Duplicate Tracking
   Time: O(n) | Space: O(n)
   Pattern: Similar to sliding window with character tracking
   
6. SOSPatternString
   Concepts: Pattern Matching, Character Position
   Time: O(n*m) | Space: O(1)
   Pattern: Scan text for pattern occurrences
   
7. SimpleTextEditor
   Concepts: Stack for Undo, Operation Tracking
   Time: O(n) per operation | Space: O(n)
   Pattern:
      - Stack stores previous states or operations
      - Append, delete, print current string
      - Undo pops state
   Key Trick: Stack elegantly handles undo
   
8. WordWrap
   Concepts: Text Formatting, Line Breaking
   Time: O(n) | Space: O(n)
   Pattern:
      - Fit words within width
      - Start new line when word doesn't fit
      - Handle spacing and alignment
   Key Trick: Build lines carefully managing width
```

---

## 🔄 DYNAMIC PROGRAMMING PROBLEMS

### **Problem Catalog (2 Problems)**

```
1. Fibbonaci (Naive Recursive)
   Concepts: Recursion, Exponential Growth
   Time: O(2ⁿ) | Space: O(n) stack
   Pattern: fib(n) = fib(n-1) + fib(n-2)
   Issue: Massive recomputation
   
2. FibbonaciMemoization (Top-Down DP)
   Concepts: Memoization, Caching Results
   Time: O(n) | Space: O(n)
   Pattern:
      - Recursive with cache
      - Check cache before computing
      - Store result before returning
   Key Trick: Map stores computed values
   Follow-up: Tabulation (bottom-up), space optimization
```

---

## 🔢 MATH PROBLEMS

### **Problem Catalog (6 Problems)**

```
1. Factorial
   Concepts: Multiplication, Recursion/Iteration
   Time: O(n) | Space: O(1) iterative, O(n) recursive
   Pattern: n! = n × (n-1)!
   Key Trick: Base case n=1 or n=0
   
2. Palindrome
   Concepts: Digit Extraction, Comparison
   Time: O(log n) | Space: O(1)
   Pattern: Extract digits and rebuild reversed
   Key Trick: Original == reversed
   
3. ReverseInteger
   Concepts: Digit Manipulation, Overflow Handling
   Time: O(log n) | Space: O(1)
   Pattern:
      - Extract digit: digit = num % 10
      - Build result: result = result * 10 + digit
      - Check overflow: result > INT_MAX/10
   Key Trick: Handle negative numbers and overflow
   
4. RectangleArea
   Concepts: Area Formula
   Time: O(1) | Space: O(1)
   Formula: Area = length × width
   
5. OverlapRectangle
   Concepts: Coordinate Geometry, Intersection
   Time: O(1) | Space: O(1)
   Pattern:
      - Check x-axis overlap: x1_left < x2_right AND x2_left < x1_right
      - Check y-axis overlap: similarly
      - Both must overlap for rectangles to overlap
   Key Trick: Think in 1D for each axis independently
   
6. MaximizeProfit
   Concepts: Greedy Approach, State Tracking
   Time: O(n) | Space: O(1)
   Pattern: Track minimum, update maximum profit
   Similar to: StockBuySell
```

---

## 🎁 SPECIAL ALGORITHM PROBLEMS

### **Problem Catalog (3 Problems)**

```
1. LRUCache
   Concepts: Cache Design, LRU Eviction, Data Structure Combination
   Time: O(1) | Space: O(capacity)
   Implementation: HashMap + Doubly Linked List
   Pattern:
      - HashMap for O(1) lookup
      - Doubly LL for O(1) reordering (move to front on access)
      - Remove least recently used on overflow
   Key Trick: Combine structures for optimal properties
   Operations:
      - get(key): Lookup value, mark as recently used
      - put(key, value): Insert/update, evict if full
   
2. LRUCacheUsingLinkedHashMap
   Concepts: LinkedHashMap, Access-Order Semantics
   Time: O(1) | Space: O(capacity)
   Pattern: LinkedHashMap with accessOrder=true
   Key Trick: Built-in removeEldestEntry for eviction
   Advantage: Simpler code, understanding internals vs implementation
   
3. PoisonousPlant
   Concepts: Elimination Algorithm, Greedy Approach
   Time: O(n) average | Space: O(n)
   Pattern:
      - Identify plants to eliminate
      - Remove and check neighbors
      - Cascading eliminations may occur
   Key Trick: Use deque or simulation with care
   Follow-up: Count eliminations, optimal removal order
```

---

## 🌊 STREAMS & FUNCTIONAL PROGRAMMING

### **Problem Catalog (1 Problem)**

```
1. StreamExample
   Concepts: Stream API, Functional Programming, Method References
   Time: Depends on operations | Space: O(n) for collection
   Operations:
      - map(Function): Transform elements
      - filter(Predicate): Select elements
      - reduce(Function): Combine into single value
      - collect(Collector): Gather into collection
   Key Trick: Lazy evaluation - intermediate ops don't execute until terminal
   Use Case: Clean, readable functional transformations
   
   Example Patterns:
      - Transform: stream.map(x -> x * 2).collect(toList())
      - Filter & Count: stream.filter(x > 5).count()
      - Group & Aggregate: stream.collect(groupingBy(property))
      - Find & Optional: stream.filter(pred).findFirst()
```

---

## 🎯 ALGORITHM SELECTION FLOWCHART

```
Problem Given
    │
    ├─ Need to search?
    │  ├─ Sorted array → Binary Search O(log n)
    │  └─ Unsorted → HashMap/HashSet O(n)
    │
    ├─ Need to find pairs/groups?
    │  ├─ Pair → Two Pointers O(n)
    │  ├─ Triplet → Sort + Two Pointers O(n²)
    │  └─ Frequency based → HashMap + Heap O(n log k)
    │
    ├─ Need to traverse?
    │  ├─ Tree/Graph → DFS or BFS
    │  ├─ Level-wise → Queue (BFS)
    │  └─ In-depth → Stack (DFS)
    │
    ├─ Contiguous subarray/substring?
    │  ├─ Fixed window → Sliding window O(n)
    │  ├─ Dynamic window → Two pointers O(n)
    │  └─ Complex pattern → HashMap+Sliding O(n)
    │
    ├─ Need best k elements?
    │  ├─ Top-k selection → Min-heap O(n log k)
    │  └─ All frequencies → HashMap O(n)
    │
    ├─ String problem?
    │  ├─ Matching/pattern → KMP or HashMap O(n)
    │  ├─ Permutation → Frequency count O(n)
    │  └─ Rotation → Concatenation trick O(n)
    │
    ├─ Cache needed?
    │  └─ LRU pattern → HashMap + DLL O(1)
    │
    ├─ Overlapping subproblems?
    │  └─ Dynamic Programming → Memoization O(states)
    │
    └─ Sorting needed?
       ├─ Small data → Insertion O(n²)
       ├─ Guaranteed O(n log n) → Merge O(n log n)
       └─ Average fast → Quick O(n log n)
```

---

## 📊 PROBLEMS BY DIFFICULTY

### **⭐ EASY (35+ Problems)**
- All basic array operations
- Singly traversing problems
- Simple pattern matching
- Single data structure usage

### **⭐⭐ MEDIUM (35+ Problems)**
- Combination of 2 concepts
- Optimization techniques
- Complex data structures
- Algorithm design thinking

### **⭐⭐⭐ HARD (14+ Problems)**
- LRUCache (multiple data structures)
- PoisonousPlant (elimination logic)
- TrappingRainWater (optimization)
- Advanced tree/graph problems

---

## 🔗 DEPENDENCY GRAPH

```
Fundamentals
├── Arrays ─────┬──→ Searching (Binary Search)
│               ├──→ Sorting (Quicksort, Mergesort)
│               ├──→ Techniques (Two Pointers, Sliding Window)
│               └──→ Analysis (Min/Max, Statistics)
│
├── Linked Lists ───→ Advanced Traversal (Fast & Slow)
│                  ───→ Structural Changes (Reverse, Merge)
│                  ───→ Cycle Detection
│
├── Stacks ─────────→ Expression Evaluation
│               ───→ Undo/Redo Pattern
│
├── Queues ─────────→ BFS/Level Order
│               ───→ Window Management
│
└── Hash Maps ──────→ Frequency Problems
                ───→ Lookup Optimization

Intermediate
├── Trees ───────────→ DFS/BFS Traversals
│             ───────→ BST Properties
│             ───────→ Tree Optimization
│
├── Heaps ───────────→ Priority Queue
│             ───────→ Top-K Selection
│
└── Sorting ─────────→ Pre-processing
              ───────→ Algorithm Complexity

Advanced
├── Dynamic Programming ──→ State Definition
│                    ──→ Recurrence Relation
│                    ──→ Memoization
│
├── String Algorithms ─────→ Pattern Matching
│                    ─────→ Transformation
│
└── System Design ──────────→ Data Structure Choice
                 ──────────→ Optimization
```

---

## ✅ MASTERY VERIFICATION CHECKLIST

- [ ] Can solve all problems without referring to code
- [ ] Can explain time/space complexity for every problem
- [ ] Can code solution in < 20 min (easy), < 45 min (medium)
- [ ] Can recognize problem type and pattern instantly
- [ ] Can explain trade-offs for different approaches
- [ ] Can code clean, readable solution with good variable names
- [ ] Can write test cases and edge case handling
- [ ] Can explain solution to interviewer verbally
- [ ] Can optimize if given hints
- [ ] Can solve related variations

---

**Total Problems:** 84+
**Categories:** 14
**Quick Reference:** Organized for fast lookup
**Updated:** February 2026
