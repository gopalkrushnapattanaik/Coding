# 📚 Data Structures & Algorithms - Complete Study Guide with Concepts

**Created:** February 2026 | **Total Problems:** 84+ | **Categories:** 14 | **Learning Path:** Beginner → Advanced

---

## 🧠 Complete Architecture Map

```
┌─────────────────────────────────────────────────────────────────────┐
│     DATA STRUCTURES & ALGORITHMS - COMPLETE LEARNING ECOSYSTEM      │
└─────────────────────────────────────────────────────────────────────┘
                                    │
        ┌───────────────────────────┼───────────────────────────┐
        │                           │                           │
    ┌───▼────────┐        ┌────────▼────────┐      ┌──────────▼──────┐
    │ FOUNDATIONS│        │  INTERMEDIATE   │      │    ADVANCED     │
    └───┬────────┘        └────────┬────────┘      └──────────┬──────┘
        │                          │                          │
    ┌───┴──────────┐      ┌────────┴────────┐      ┌─────────┴────────┐
    │ Arrays       │      │ Trees           │      │ DP               │
    │ LinkedLists  │      │ Heaps           │      │ Advanced Strings │
    │ Stacks       │      │ Graphs          │      │ Complex Patterns │
    │ Queues       │      │ Advanced Arrays │      │ Optimization     │
    │ HashMaps     │      │ Algorithms      │      │ System Design    │
    └──────────────┘      └─────────────────┘      └──────────────────┘
```

---

# 📊 LEVEL 1: FUNDAMENTAL DATA STRUCTURES

## 1️⃣ ARRAYS - The Foundation

### 📖 Core Concepts & Techniques

#### **Concept 1: Array Basics**
- **Definition:** Contiguous memory, fixed-size collection
- **Key Property:** O(1) random access via index
- **Trade-off:** Fast access but costly insertions/deletions
- **Memory Model:** Sequential allocation

#### **Concept 2: Binary Search**
- **Prerequisite:** Sorted array
- **Core Idea:** Eliminate half of remaining elements each iteration
- **Divide & Conquer:** Divide problem into smaller subproblems
- **Applications:** Search, Find insertion position, Find range

#### **Concept 3: Two Pointer Technique**
- **When to Use:** Sorted arrays, palindromes, pairs/triplets
- **Movement:** One from start, one from end
- **Optimization:** Reduces nested loops from O(n²) to O(n)
- **Pattern:** Move toward each other based on comparison

#### **Concept 4: Sliding Window**
- **Best For:** Contiguous subarrays/substrings
- **Technique:** Expand and contract window dynamically
- **Key Insight:** Avoid recalculating full window each time
- **When Fixed:** K-size window (fixed window)
- **When Dynamic:** Find min/max window with condition

#### **Concept 5: Prefix/Suffix Optimization**
- **Idea:** Precompute values to avoid redundant calculations
- **Trade-off:** O(n) space for O(n) time instead of O(n²)
- **Use Case:** Problems needing left and right context

#### **Concept 6: Matrix Operations**
- **Row-Major Order:** Access matrix[i][j]
- **Diagonal Traversal:** Principal (i==j) and Secondary (i+j==n-1)
- **2D Problems:** Often reducible to 1D patterns

---

### ✅ PROBLEMS SOLVED

#### **Category A: Searching & Lookup**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **BinarySearch** | Divide & Conquer, Binary Search | O(log n) | O(1) | ⭐ Easy |
| **SearchInAlmostSortedArray** | Modified Binary Search | O(log n) | O(1) | ⭐ Easy |

**Key Insight:** When array is sorted, always think binary search for O(log n)

#### **Category B: Finding Pairs/Triplets**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **TwoSum** | HashMap, Hash Lookup | O(n) | O(n) | ⭐ Easy |
| **ThreeSum** | Two Pointers, Sorting | O(n²) | O(1) | ⭐⭐ Medium |
| **FourSum** | Nested Two Pointers | O(n³) | O(1) | ⭐⭐ Medium |

**Key Insight:** Fix outer element(s), use two pointers for inner search

#### **Category C: Array Manipulation & Rearrangement**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **RotateArray** | Reversal Trick, Cyclic Shift | O(n) | O(1) | ⭐ Easy |
| **MoveZeros** | Two Pointers, In-place | O(n) | O(1) | ⭐ Easy |
| **SegregateEvenOddNumbers** | Partitioning, Two Pointers | O(n) | O(1) | ⭐ Easy |
| **SeggregateZerosOnesTwos** | Dutch National Flag, Three Pointers | O(n) | O(1) | ⭐⭐ Medium |
| **SortZeroOnes** | Binary Sorting, Two Pointers | O(n) | O(1) | ⭐ Easy |

**Key Insight:** Use partition logic to rearrange in-place

#### **Category D: Array Analysis & Statistics**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **Largest_Smallest_Number** | Single Pass, Min/Max Tracking | O(n) | O(1) | ⭐ Easy |
| **Second_Largest_Smallest** | Multi-pass or Single Pass | O(n) | O(1) | ⭐ Easy |
| **Local_Maxima** | Peak Finding | O(n) | O(1) | ⭐ Easy |
| **NumberCounts** | Frequency Counting, HashMap | O(n) | O(n) | ⭐ Easy |

**Key Insight:** Track multiple variables for different statistics

#### **Category E: Advanced Array Problems**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **TwoPointers** | Container, Merge, Two Pointer | O(n) | O(1) | ⭐⭐ Medium |
| **TrappingRainWater** | Prefix/Suffix Max, Dynamic Programming | O(n) | O(n) | ⭐⭐⭐ Hard |
| **StockBuySell** | Greedy, State Machine, Single Pass | O(n) | O(1) | ⭐⭐ Medium |
| **MatrixDiagonalSum** | Matrix Traversal, Diagonal Logic | O(n²) | O(1) | ⭐ Easy |
| **PrintAlternateElement** | Index Manipulation | O(n) | O(1) | ⭐ Easy |
| **Pyramid** | Pattern Printing, Loops | O(n²) | O(1) | ⭐ Easy |
| **MergeStrings** | Two Pointer String Merge | O(n) | O(1) | ⭐ Easy |

**Key Insight:** Combine multiple techniques for complex problems

---

## 2️⃣ LINKED LISTS - Dynamic Collections

### 📖 Core Concepts & Techniques

#### **Concept 1: Node-Based Structure**
- **Definition:** Each element (node) contains data and reference(s)
- **Singly:** One reference to next node
- **Doubly:** References to both next and previous
- **Circular:** Last node points back to first

#### **Concept 2: Fast & Slow Pointers**
- **Tortoise & Hare:** Move at different speeds
- **Use Cases:** Cycle detection, middle finding
- **Relative Speed:** Slow moves 1, Fast moves 2
- **Meeting Point:** Detects cycle if they meet

#### **Concept 3: Two-Pointer Manipulation**
- **Reversal:** Swap references while traversing
- **Merging:** Compare and connect nodes
- **Deletion:** Skip nodes by adjusting references

#### **Concept 4: Structural Properties**
- **Cycle:** Node references back to earlier node
- **Position:** K from end, middle, nth node
- **Duplication:** Multiple nodes with same value
- **Sorting:** Merge two sorted lists

#### **Concept 5: Memory Efficiency**
- **No Reallocation:** Unlike arrays, dynamic growth
- **Insert/Delete:** O(1) at known position
- **Trade-off:** O(n) access vs O(1) modification

---

### ✅ PROBLEMS SOLVED

#### **Category A: Basic Operations**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **LinkedList** | Singly Linked List, Node | O(1) insert/delete | O(1) | ⭐ Easy |
| **SinglyLinkedList** | Complete Implementation | O(n) | O(n) | ⭐ Easy |
| **SinglyLinkedListImpl** | Full CRUD Operations | O(n) | O(n) | ⭐ Easy |

**Key Insight:** Understand node structure and pointer manipulation

#### **Category B: Traversal & Analysis**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **MiddleOfLinkedList** | Fast & Slow Pointers | O(n) | O(1) | ⭐ Easy |
| **LinkedListKthElementFromEnd** | Two Pointers, Gap | O(n) | O(1) | ⭐ Easy |
| **GetNodeValue** | Index-based Access | O(n) | O(1) | ⭐ Easy |

**Key Insight:** Use pointer technique to find positions without tracking size

#### **Category C: Structural Operations**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **ReverseLinkedList** | Pointer Reversal, Iterative/Recursive | O(n) | O(1) or O(n) | ⭐⭐ Medium |
| **ReverseDoublyLinkedList** | Bidirectional Pointer Reversal | O(n) | O(1) | ⭐⭐ Medium |

**Key Insight:** Think about what connections to break and create

#### **Category D: Advanced Problems**
| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **LinkedListCycle** | Floyd's Algorithm, Cycle Detection | O(n) | O(1) | ⭐⭐ Medium |
| **RemoveNthNodeFromEnd** | Two Pointer, Dummy Node | O(n) | O(1) | ⭐⭐ Medium |
| **RemoveDuplicates** | HashMap, Single Pass | O(n) | O(n) | ⭐ Easy |
| **mergeSortedLinkedLists** | Two Pointer Merge | O(n+m) | O(1) | ⭐⭐ Medium |
| **DoublyLinkedListNode** | Bidirectional Linking | O(1) per operation | O(1) | ⭐ Easy |

**Key Insight:** Use dummy nodes to simplify edge cases (head removal)

---

## 3️⃣ STACKS - LIFO Principle

### 📖 Core Concepts & Techniques

#### **Concept 1: Stack Fundamentals**
- **LIFO:** Last In, First Out principle
- **Operations:** Push (add), Pop (remove), Peek (view)
- **Implementation:** Array-based or Linked List-based
- **Time Complexity:** All operations O(1)

#### **Concept 2: Expression Evaluation**
- **Balanced Parentheses:** Every opening has matching closing
- **Nesting:** Valid if properly nested
- **Stack Property:** Push opening, pop on closing

#### **Concept 3: Undo/Redo Pattern**
- **State Tracking:** Store operations/states
- **History:** Stack of previous states
- **Reversal:** Pop to undo in LIFO order

#### **Concept 4: Monotonic Stack**
- **Maintains Order:** Keep elements in increasing/decreasing order
- **Use Case:** Next greater element, histogram problems
- **Efficiency:** Each element pushed/popped once = O(n)

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **BalancedParanthesis** | Stack, Expression Parsing | O(n) | O(n) | ⭐ Easy |
| **EqualStacks** | Stack Operations, Height Matching | O(n) | O(n) | ⭐⭐ Medium |

**Key Insight:** Stack solves matching problems elegantly; maintain invariants

---

## 4️⃣ QUEUES - FIFO Principle

### 📖 Core Concepts & Techniques

#### **Concept 1: Queue Fundamentals**
- **FIFO:** First In, First Out principle
- **Operations:** Enqueue, Dequeue, Peek
- **Implementation:** Array (circular) or Linked List
- **Time Complexity:** All operations O(1)

#### **Concept 2: Breadth-First Search (BFS)**
- **Level-Order:** Process nodes level by level
- **Queue Property:** Ensures level-wise exploration
- **Applications:** Shortest path, level traversal, tree width

#### **Concept 3: Deque (Double-Ended Queue)**
- **Flexibility:** Add/remove from both ends
- **Use Cases:** Sliding window max, zigzag traversal
- **Operations:** addFirst, addLast, pollFirst, pollLast

#### **Concept 4: Time Window Problems**
- **Sliding Window:** Keep relevant data in time range
- **Eviction:** Remove old entries outside window
- **Counter:** Track current state in window

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **HitCounterUsingQueue** | Time Window, Deque, Timestamp | O(n) | O(n) | ⭐⭐ Medium |
| **LevelOrderTraversal** | Queue, BFS, Tree Traversal | O(n) | O(w) | ⭐⭐ Medium |
| **ZigZagTraversal** | Deque, Alternating Direction | O(n) | O(w) | ⭐⭐ Medium |

**Key Insight:** Deque enables bidirectional processing; queues perfect for level operations

---

## 5️⃣ HASH MAPS / HASH TABLES - Fast Lookup

### 📖 Core Concepts & Techniques

#### **Concept 1: Hash Function**
- **Purpose:** Map key to index in constant time
- **Collision:** Multiple keys hash to same index
- **Distribution:** Good hash function spreads keys uniformly

#### **Concept 2: Collision Resolution**
- **Chaining:** Each bucket is a linked list
- **Open Addressing:** Find next available slot
- **Load Factor:** Controls when to resize

#### **Concept 3: Frequency Counting**
- **Pattern:** Count occurrences of elements
- **Optimization:** O(1) lookup instead of linear search
- **Space Trade-off:** Extra memory for speed

#### **Concept 4: Access-Order Semantics**
- **LinkedHashMap:** Maintains insertion or access order
- **LRU Cache:** Mark accessed elements as recently used
- **Eviction:** Remove least recently used on overflow

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **CustomHashMap** | Hash Function, Collision Resolution, Buckets | O(1) avg | O(n) | ⭐⭐ Medium |
| **CustomHashMapTest** | Test Cases, Edge Cases | - | - | ⭐ Easy |

**Key Insight:** Understand internals for optimization; use built-in unless learning

---

---

# 📊 LEVEL 2: TREE & GRAPH STRUCTURES

## 6️⃣ BINARY TREES - Hierarchical Data

### 📖 Core Concepts & Techniques

#### **Concept 1: Tree Fundamentals**
- **Structure:** Root with left and right subtrees
- **Properties:** Parent-child relationships, levels
- **Height:** Longest path from root to leaf
- **Balanced:** Height difference ≤ 1 for performance

#### **Concept 2: Depth-First Search (DFS)**
- **Preorder:** Root → Left → Right (prefix notation)
- **Inorder:** Left → Root → Right (sorted for BST)
- **Postorder:** Left → Right → Root (cleanup order)
- **Space:** O(h) for recursion stack (h = height)
- **Time:** O(n) to visit all nodes

#### **Concept 3: Breadth-First Search (BFS)**
- **Level-Order:** Visit nodes level by level
- **Queue-Based:** Maintain frontier of nodes
- **Space:** O(w) where w is maximum level width
- **Time:** O(n) to visit all nodes

#### **Concept 4: Tree Traversal Patterns**
- **Recursive:** Natural for tree structure
- **Iterative:** Use explicit stack for control
- **Morris:** O(1) space in-order (advanced)

#### **Concept 5: Binary Tree Properties**
- **Complete:** All levels full except possibly last
- **Full:** Every node has 0 or 2 children
- **Perfect:** All internal nodes have 2 children
- **Skewed:** Linear structure (degenerate)

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **TreeNode** | Node Structure, Generic Type | - | - | ⭐ Easy |
| **Tree** | Tree Class, Basic Operations | - | - | ⭐ Easy |
| **BinaryTree** | Tree Construction, Property Calculation | O(n) | O(h) | ⭐ Easy |
| **BinaryTreeBFS** | Level-Order Traversal, Queue | O(n) | O(w) | ⭐⭐ Medium |
| **BinaryTreeDFS** | DFS Methods, Recursion | O(n) | O(h) | ⭐⭐ Medium |

**Key Insight:** Choose DFS for space, BFS for level-order; understand time/space trade-off

---

## 7️⃣ HEAPS - Priority-Based Collection

### 📖 Core Concepts & Techniques

#### **Concept 1: Heap Structure**
- **Min-Heap:** Parent ≤ children (smallest at root)
- **Max-Heap:** Parent ≥ children (largest at root)
- **Complete Binary Tree:** All levels full except last
- **Array Representation:** Parent at i, children at 2i+1, 2i+2

#### **Concept 2: Heap Operations**
- **Insert:** O(log n) - add at end, bubble up
- **Delete Min/Max:** O(log n) - remove root, move last, bubble down
- **Heapify:** O(n) - build heap in linear time
- **Peek:** O(1) - return root without removal

#### **Concept 3: Heap Sort**
- **Process:** Build heap, repeatedly extract min/max
- **Time:** O(n log n) guaranteed
- **Space:** O(1) in-place (array-based)
- **Stability:** Not stable (order changes)

#### **Concept 4: Priority Queue Use Cases**
- **Top-K Problems:** K largest/smallest elements
- **Scheduling:** Process by priority
- **Median Finding:** Use two heaps
- **Dijkstra's:** Shortest path with priorities

#### **Concept 5: Heap vs Hash Map**
- **When Fixed Size:** Use heap (Top-K)
- **When All Elements:** Use hash map (frequency)
- **Memory:** Heap more efficient for large n, small k

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **LastStone** | Min-Heap, Simulation, Game Logic | O(n log n) | O(n) | ⭐⭐ Medium |
| **SmashStones** | Heap Operations, Weight Tracking | O(n log n) | O(n) | ⭐⭐ Medium |
| **TopKFrequentElements** | Min-Heap, Frequency Map, K Selection | O(n log k) | O(k) | ⭐⭐ Medium |

**Key Insight:** Heap perfect for top-k; maintain heap size k for O(n log k)

---

---

# 🔄 LEVEL 3: ALGORITHM PATTERNS

## 8️⃣ SORTING ALGORITHMS - Fundamental Patterns

### 📖 Core Concepts & Techniques

#### **Concept 1: Comparison-Based Sorting**
- **Lower Bound:** O(n log n) for comparison sorts
- **Stability:** Maintains relative order of equal elements
- **In-Place:** O(1) extra space (excluding input)
- **Trade-offs:** Time vs space, simplicity vs efficiency

#### **Concept 2: Sorting Algorithm Categories**
- **O(n²):** Bubble, Selection, Insertion (simple)
- **O(n log n):** Merge, Quick, Heap (efficient)
- **O(n):** Counting, Radix, Bucket (special cases)

#### **Concept 3: Algorithm Selection Criteria**
- **Small Data (n < 100):** Insertion sort
- **Random Data:** Quick sort
- **Guarantee Performance:** Merge sort
- **In-Place Requirement:** Heap sort
- **Nearly Sorted:** Insertion sort
- **External Sorting:** Merge sort

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Stability | Difficulty |
|---------|----------|------|-------|-----------|------------|
| **BubbleSort** | Comparison, Adjacent Swap, Simple | O(n²) | O(1) | ✓ Yes | ⭐ Easy |
| **SelectionSort** | Find Min, Swap, Partition | O(n²) | O(1) | ✗ No | ⭐ Easy |
| **InsertionSort** | Shift, Placement, Adaptive | O(n²) avg, O(n) best | O(1) | ✓ Yes | ⭐ Easy |
| **MergeSort** | Divide & Conquer, Merge | O(n log n) | O(n) | ✓ Yes | ⭐⭐ Medium |

**Key Insight:** Master fundamentals; recognize when each algorithm excels

---

## 9️⃣ SLIDING WINDOW - Efficient Subarray Problems

### 📖 Core Concepts & Techniques

#### **Concept 1: Fixed Window Size**
- **Pattern:** Window size k is constant
- **Technique:** Add element on right, remove from left
- **Benefit:** O(n) instead of O(n*k)
- **Example:** Max sum of k consecutive

#### **Concept 2: Dynamic Window Size**
- **Pattern:** Window size varies based on condition
- **Technique:** Expand for inclusion, contract for constraint
- **When to Expand:** Element helps (inside valid window)
- **When to Contract:** Element blocks (outside valid window)

#### **Concept 3: Two Pointers in Sliding Window**
- **Left Pointer:** Start of window
- **Right Pointer:** End of window
- **Invariant:** Maintain some property within [left, right]
- **Movement:** Move pointers based on current state

#### **Concept 4: Optimization Technique**
- **Problem:** Subarray with property X
- **Naive:** Check all subarrays O(n²) or O(n³)
- **Optimized:** Window tracks minimal info, update incrementally
- **Result:** O(n) or O(n log n) instead

#### **Concept 5: Valid Window Conditions**
- **Maximum/Minimum:** Keep element count
- **Contiguous:** Don't break sequence
- **Constraint:** Some sum/condition limit
- **Target:** Find longest/shortest window

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Window Type | Difficulty |
|---------|----------|------|-------|------------|------------|
| **LongestSubString** | HashMap, Char Tracking, Dynamic | O(n) | O(n) | Dynamic | ⭐⭐ Medium |
| **MaxSumSubArrayOfK** | Fixed Window, Sliding Sum | O(n) | O(1) | Fixed | ⭐ Easy |
| **MaxSumOfKthElement** | K Selection, Optimization | O(n) | O(1) | Fixed | ⭐ Easy |
| **minSubArrayLen** | Two Pointer, Minimum Length | O(n) | O(1) | Dynamic | ⭐⭐ Medium |

**Key Insight:** Recognize when sliding window applies; avoid nested loops

---

## 🔟 STRING ALGORITHMS - Pattern Manipulation

### 📖 Core Concepts & Techniques

#### **Concept 1: String Immutability**
- **Java Strings:** Immutable, creates new for changes
- **StringBuilder:** Mutable, efficient for concatenation
- **Performance:** Use StringBuilder for loops (O(n) vs O(n²))

#### **Concept 2: Character Manipulation**
- **Frequency Counting:** HashMap of characters
- **Validation:** Check properties like palindrome
- **Transformation:** Compression, rotation, permutation

#### **Concept 3: Pattern Matching**
- **Naive:** O(n*m) character by character
- **KMP:** O(n+m) with failure function
- **Hashing:** Rolling hash for substring search
- **Trie:** For multiple pattern search

#### **Concept 4: Permutation & Rotation**
- **Permutation:** Same characters, different order
- **Rotation:** Substring moved to different position
- **Detection:** Frequency counts or substring trick

#### **Concept 5: Text Processing**
- **Word Wrapping:** Fit text in width
- **Compression:** Reduce size with run-length encoding
- **Parsing:** Extract patterns from text

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Time | Space | Difficulty |
|---------|----------|------|-------|------------|
| **StringValidation** | Character Check, Validation Rules | O(n) | O(1) | ⭐ Easy |
| **StringPermutation** | Frequency Count, Comparison | O(n) | O(1) | ⭐ Easy |
| **StringRotation** | Substring Search, Concatenation Trick | O(n) | O(n) | ⭐ Easy |
| **StringCompression** | Run-Length Encoding, Efficient Concat | O(n) | O(n) | ⭐⭐ Medium |
| **LongetSubString** | Sliding Window, HashMap | O(n) | O(n) | ⭐⭐ Medium |
| **SOSPatternString** | Pattern Matching, Traversal | O(n*m) | O(1) | ⭐⭐ Medium |
| **SimpleTextEditor** | Stack, Undo Operations | O(n) per op | O(n) | ⭐⭐ Medium |
| **WordWrap** | Text Formatting, Line Breaking | O(n) | O(n) | ⭐⭐ Medium |

**Key Insight:** Use StringBuilder for efficiency; recognize frequency problems

---

---

# 🎯 LEVEL 4: ADVANCED ALGORITHMS

## 1️⃣1️⃣ DYNAMIC PROGRAMMING - Optimization Pattern

### 📖 Core Concepts & Techniques

#### **Concept 1: DP Fundamentals**
- **Overlapping Subproblems:** Same subproblem solved multiple times
- **Optimal Substructure:** Optimal solution from optimal subproblems
- **Memoization:** Store computed results (top-down)
- **Tabulation:** Build up from base cases (bottom-up)

#### **Concept 2: Memoization (Top-Down)**
- **Approach:** Recursive solution with caching
- **Storage:** HashMap or array for results
- **Benefit:** Avoid recomputation, cleaner code
- **Risk:** Stack overflow for deep recursion

#### **Concept 3: Tabulation (Bottom-Up)**
- **Approach:** Iterative solution building from base
- **Storage:** Array table with subproblem results
- **Benefit:** No recursion overhead, guaranteed termination
- **Logic:** Fill table based on recurrence relation

#### **Concept 4: Time Complexity Analysis**
- **States:** Number of unique subproblems
- **Transition:** Time to compute each state
- **Total:** States × Transition time

#### **Concept 5: Space Optimization**
- **Observation:** Often only need previous states
- **Rolling Array:** Use 2 arrays instead of n
- **Space Reduction:** O(n) → O(1) or O(n) → O(k)

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Approach | Time | Space | Difficulty |
|---------|----------|----------|------|-------|------------|
| **Fibbonaci** | Recursion, Exponential Growth | Recursive (naive) | O(2ⁿ) | O(n) stack | ⭐ Easy |
| **FibbonaciMemoization** | Memoization, Caching | Top-Down with Cache | O(n) | O(n) | ⭐⭐ Medium |

**Key Insight:** Recognize overlapping subproblems; use memoization for clarity

---

## 1️⃣2️⃣ MATH & NUMBER PROBLEMS - Mathematical Reasoning

### 📖 Core Concepts & Techniques

#### **Concept 1: Number Properties**
- **Palindrome:** Reads same forwards and backwards
- **Prime:** Divisible only by 1 and itself
- **Factorial:** Product of all positive integers ≤ n
- **GCD/LCM:** Greatest common divisor / Least common multiple

#### **Concept 2: Digit Manipulation**
- **Reversal:** Extract digits and rebuild
- **Extraction:** Use modulo and division
- **Boundaries:** Handle overflow, negative numbers

#### **Concept 3: Geometric Problems**
- **Rectangle:** Area and overlap detection
- **Coordinate System:** Distance, intersection
- **Boundaries:** Min/max coordinates

#### **Concept 4: Optimization Problems**
- **Greedy Choice:** Select best at each step
- **State Tracking:** Remember key information
- **Pattern Recognition:** Simplify complex problems

#### **Concept 5: Modular Arithmetic**
- **Modulo:** Remainder after division
- **Use Cases:** Prevent overflow, cyclic problems
- **Properties:** (a+b)%m = ((a%m)+(b%m))%m

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Mathematical Idea | Time | Space | Difficulty |
|---------|----------|-------------------|------|-------|------------|
| **Factorial** | Multiplication, Recursion | n! = n × (n-1)! | O(n) | O(1) or O(n) | ⭐ Easy |
| **Palindrome** | Digit Extraction, Comparison | Compare original vs reversed | O(log n) | O(1) | ⭐ Easy |
| **ReverseInteger** | Digit Manipulation, Overflow | Extract and rebuild digits | O(log n) | O(1) | ⭐ Easy |
| **RectangleArea** | Area Formula | Area = length × width | O(1) | O(1) | ⭐ Easy |
| **OverlapRectangle** | Coordinate Intersection | Check all dimensions | O(1) | O(1) | ⭐ Easy |
| **MaximizeProfit** | Greedy, State Tracking | Track min, update max profit | O(n) | O(1) | ⭐⭐ Medium |

**Key Insight:** Break problem to digit/coordinate level; use mathematics to optimize

---

## 1️⃣3️⃣ SPECIAL PROBLEMS - Unique Algorithms

### 📖 Core Concepts & Techniques

#### **Concept 1: Cache Design (LRU)**
- **Problem:** Limited capacity cache with eviction
- **Strategy:** Remove least recently used element
- **Implementation:** HashMap + Doubly Linked List
- **Access Pattern:** Update order on get/put

#### **Concept 2: Elimination Logic (Poisonous Plant)**
- **Greedy Approach:** Identify and remove
- **State Tracking:** Remember previous eliminations
- **Efficiency:** Avoid rechecking all elements
- **Pattern:** Often solution has cascading effects

#### **Concept 3: Data Structure Combinations**
- **Problem:** Single structure insufficient
- **Solution:** Combine structures for desired properties
- **Example:** LRU = HashMap (O(1) lookup) + LL (O(1) reorder)
- **Trade-off:** More space for better time complexity

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Data Structures | Time | Space | Difficulty |
|---------|----------|-----------------|------|-------|------------|
| **LRUCache** | Cache, LRU Eviction, Double Linked List | HashMap + Doubly LL | O(1) | O(capacity) | ⭐⭐⭐ Hard |
| **LRUCacheUsingLinkedHashMap** | LRU, Built-in Collection | LinkedHashMap | O(1) | O(capacity) | ⭐⭐ Medium |
| **PoisonousPlant** | Elimination, Greedy, State | Stack/Deque | O(n) avg | O(n) | ⭐⭐⭐ Hard |

**Key Insight:** Combine data structures for optimal properties; understand trade-offs

---

## 1️⃣4️⃣ STREAMS & FUNCTIONAL PROGRAMMING - Modern Java

### 📖 Core Concepts & Techniques

#### **Concept 1: Stream API Basics**
- **Creation:** From collection, array, or generator
- **Operations:** Intermediate (map, filter) and Terminal (collect, reduce)
- **Lazy Evaluation:** Intermediate operations don't execute until terminal
- **Chaining:** Method chaining for readable code

#### **Concept 2: Functional Operations**
- **map:** Transform each element
- **filter:** Select elements matching predicate
- **reduce:** Combine elements into single value
- **collect:** Gather elements into collection

#### **Concept 3: Stream vs Loop**
- **Readability:** Declarative vs imperative
- **Performance:** Comparable with optimizations
- **Parallelization:** Easy with parallel streams
- **Purity:** Functional style avoids side effects

#### **Concept 4: Common Patterns**
- **Transformation:** Map one collection to another
- **Filtering:** Keep elements satisfying condition
- **Aggregation:** Sum, count, find min/max
- **Grouping:** Group by property

---

### ✅ PROBLEMS SOLVED

| Problem | Concepts | Use Cases | Difficulty |
|---------|----------|-----------|------------|
| **StreamExample** | Stream API, Functional Programming | Map, Filter, Reduce, Collect | ⭐⭐ Medium |

**Key Insight:** Use streams for clean, readable code; understand lazy evaluation

---

---

# 🗺️ COMPLETE LEARNING ROADMAP

## 📅 8-Week Intensive Study Plan

### **Week 1: Array Foundations**
- **Days 1-2:** Understand array indexing and basics
- **Days 3-4:** Binary search and two-pointer technique
- **Days 5-6:** Pair/triplet finding (TwoSum, ThreeSum)
- **Day 7:** Review and practice variations
- **Problems:** 8+ array problems
- **Target:** Master O(n) and O(log n) solutions

### **Week 2: Array Advanced + Linked Lists Intro**
- **Days 1-2:** Array manipulation (rotate, segregate, move)
- **Days 3-4:** Analysis problems (max, min, local maxima)
- **Days 5-6:** Linked list basics and reversal
- **Day 7:** Connected components review
- **Problems:** 12+ problems combined
- **Target:** In-place algorithms, pointer techniques

### **Week 3: Linked Lists + Stacks/Queues**
- **Days 1-2:** Advanced LL (cycles, middle, kth from end)
- **Days 3-4:** Stack applications (balanced, undo)
- **Days 5-6:** Queue and deque operations
- **Day 7:** Tree traversal with BFS/DFS intro
- **Problems:** 15+ problems
- **Target:** Fast & slow pointers, LIFO/FIFO patterns

### **Week 4: Trees + Sorting Algorithms**
- **Days 1-2:** Tree traversals (BFS, DFS variants)
- **Days 3-4:** Sorting algorithms (understand all 4)
- **Days 5-6:** Heap and priority queue
- **Day 7:** Tree problems and sorting review
- **Problems:** 10+ problems
- **Target:** O(n log n) mindset, tree navigation

### **Week 5: Sliding Window + Hash Maps**
- **Days 1-2:** Fixed and dynamic windows
- **Days 3-4:** Hash map design and usage
- **Days 5-6:** Frequency counting patterns
- **Day 7:** Complex window problems
- **Problems:** 8+ problems
- **Target:** Sliding window recognition, hash-based optimization

### **Week 6: String Algorithms + Matrix**
- **Days 1-2:** String manipulations and patterns
- **Days 3-4:** Pattern matching basics
- **Days 5-6:** Matrix operations and traversals
- **Day 7:** Complex string and matrix problems
- **Problems:** 10+ problems
- **Target:** String optimization, 2D array thinking

### **Week 7: Dynamic Programming Introduction**
- **Days 1-2:** DP fundamentals and memoization
- **Days 3-4:** Tabulation and optimization
- **Days 5-6:** Classic DP problems
- **Day 7:** DP pattern recognition
- **Problems:** 6+ problems
- **Target:** Overlap recognition, state definition

### **Week 8: Math + Special Problems + Review**
- **Days 1-2:** Number theory and math problems
- **Days 3-4:** LRU Cache and special data structures
- **Days 5-6:** Comprehensive review of all patterns
- **Day 7:** Mixed difficulty comprehensive challenge
- **Problems:** 10+ problems
- **Target:** Pattern recognition across all types

---

## 🎓 PATTERN RECOGNITION QUICK REFERENCE

### **When to Use Each Algorithm**

```
Problem Type          → Solution Pattern           → Key Insight
────────────────────────────────────────────────────────────────
Find pair/triplet    → Sort + Two Pointers        → Fix outer, search inner
Subarray sum         → Sliding Window or Prefix   → Avoid recomputation
Substring pattern    → Sliding Window or HashMap  → Track character state
Sorted search        → Binary Search              → Half the search space
Tree/Graph explore   → BFS or DFS                 → Use queue or stack
Frequency count      → HashMap + Sorting          → Count then sort/select
Top-K selection      → Min-Heap of size k         → Maintain k best
Cache eviction       → HashMap + Doubly LL        → Combine for O(1)
Repeated calc        → Memoization or DP         → Store intermediate results
```

---

## 💯 PROBLEM DIFFICULTY DISTRIBUTION

### **By Level**
- ⭐ **Easy:** 35+ problems (fundamentals, single pattern)
- ⭐⭐ **Medium:** 35+ problems (2-3 pattern combination)
- ⭐⭐⭐ **Hard:** 14+ problems (complex design, optimization)

### **By Category**
- Arrays: 25 problems
- Linked Lists: 9 problems
- Stacks: 2 problems
- Queues: 3 problems
- Hash Maps: 2 problems
- Trees: 5 problems
- Heaps: 3 problems
- Sorting: 4 problems
- Sliding Window: 4 problems
- Strings: 8 problems
- Dynamic Programming: 2 problems
- Math: 6 problems
- Special: 3 problems
- Streams: 1 problem

---

## 🔄 INTER-TOPIC CONNECTIONS

```
Arrays ←→ Sorting ←→ Searching
  ↓
  ├→ Two Pointers
  ├→ Sliding Window
  └→ HashMap Optimization
     ↓
  Linked Lists → Tree Structure
     ↓
  DFS/BFS
     ↓
  Stack/Queue
     ↓
  Heaps (Priority)
     ↓
Dynamic Programming (Optimization)
```

---

## 📚 MASTERY CHECKLIST

### **Concepts Mastery**
- [ ] Time and Space Complexity Analysis
- [ ] Big-O Notation and practical implications
- [ ] Trade-offs: Time vs Space vs Readability
- [ ] Algorithm Design Techniques
- [ ] Data Structure Properties and Usage
- [ ] Pattern Recognition across problems
- [ ] Optimization Techniques
- [ ] Edge Case Handling

### **Problem-Solving Skills**
- [ ] Read problem carefully → Identify constraints
- [ ] Recognize algorithm pattern → Match with solution
- [ ] Estimate complexity before coding
- [ ] Write clean, readable code
- [ ] Test with examples (normal, edge, large)
- [ ] Debug efficiently using breakpoints
- [ ] Refactor for better solution
- [ ] Explain solution verbally

### **Code Quality**
- [ ] Proper variable naming
- [ ] Comments for complex logic
- [ ] DRY (Don't Repeat Yourself)
- [ ] Proper exception handling
- [ ] Test-driven development
- [ ] Code reusability

---

## 🎯 SUCCESS METRICS

| Metric | Target | Validation |
|--------|--------|------------|
| **Problems Solved** | 84+ | Run all test cases |
| **Average Time** | < 20 min/easy, < 45 min/medium | Time yourself |
| **Code Quality** | < 5 min refactor | Review and improve |
| **Complexity Accuracy** | 95%+ | Analyze every solution |
| **Pattern Recognition** | Instant | See problem → know approach |
| **Interview Ready** | Confident explanation | Speak through solutions |

---

## 📖 REFERENCE MATERIALS

### **Data Structure Reference**
- **Array:** Fixed size, O(1) access, O(n) modification
- **Linked List:** Dynamic, O(n) access, O(1) modification at known position
- **Stack:** LIFO, O(1) all ops, useful for recursion/backtracking
- **Queue:** FIFO, O(1) all ops, useful for BFS/level-order
- **Hash Map:** O(1) avg lookup, useful for frequency/deduplication
- **Heap:** O(log n) insert/delete, useful for priority/top-k
- **Tree:** Hierarchical, useful for search/indexing
- **Trie:** String prefix, O(m) search where m is string length

### **Algorithm Reference**
- **Sorting:** Merge(O(n log n)), Quick(O(n log n) avg), Heap(O(n log n))
- **Searching:** Binary(O(log n)), Linear(O(n))
- **Graph Traversal:** BFS(O(V+E)), DFS(O(V+E))
- **String Matching:** KMP(O(n+m)), Rolling Hash(O(n+m))
- **Dynamic Programming:** Define states, transitions, base cases

---

**Last Updated:** February 2026
**Total Problems:** 84+
**Complete Categories:** 14
**Learning Levels:** 4
**Estimated Study Time:** 60-80 hours
**Status:** ✅ Comprehensive Guide Complete
