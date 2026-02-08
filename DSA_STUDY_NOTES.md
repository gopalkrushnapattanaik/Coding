# Data Structures & Algorithms (DSA) - Complete Study Notes & Mind Map

## 📚 Overview
This document provides a comprehensive guide to all DSA problems and concepts organized in this repository. It includes 84+ Java implementations covering arrays, linked lists, trees, graphs, heaps, queues, stacks, and advanced algorithms.

---

## 🧠 Complete Mind Map

```
┌─────────────────────────────────────────────────────────────────┐
│         DATA STRUCTURES & ALGORITHMS LEARNING PATH              │
└─────────────────────────────────────────────────────────────────┘
                              │
                ┌─────────────┼─────────────┐
                │             │             │
        ┌──────▼──────┐  ┌────▼────┐  ┌───▼────────┐
        │ DATA        │  │ BASIC   │  │ ADVANCED  │
        │ STRUCTURES  │  │ SORTING │  │ ALGORITHMS│
        └──────┬──────┘  └────┬────┘  └───┬────────┘
               │               │           │
    ┌──────────┼───────────────┼───────────┼──────────┐
    │          │               │           │          │
   ▼▼▼        ▼▼▼             ▼▼▼         ▼▼▼        ▼▼▼
```

---

## 📊 LEVEL 1: FUNDAMENTAL DATA STRUCTURES

### 1️⃣ ARRAYS
**Complexity:** O(1) access, O(n) search/insert/delete
**Use Cases:** Fast random access, fixed-size collections

#### Basic Operations
- ✅ **BinarySearch** - Find element in sorted array
  - Time: O(log n) | Space: O(1)
  - Logic: Divide and conquer approach
  
- ✅ **TwoSum** - Find pair of numbers that add up to target
  - Time: O(n) | Space: O(n)
  - Logic: HashMap for O(1) lookup
  
- ✅ **ThreeSum** - Find triplets that sum to zero
  - Time: O(n²) | Space: O(1)
  - Logic: Fixed element + two pointer technique
  
- ✅ **FourSum** - Find 4 numbers with target sum
  - Time: O(n³) | Space: O(1)
  - Logic: Two nested loops + two pointers

#### Array Manipulation
- ✅ **RotateArray** - Rotate array by k positions
  - Methods: Reverse, Cyclic rotation, Space-optimized
  - Time: O(n) | Space: O(1)
  
- ✅ **MoveZeros** - Move all zeros to end, maintain order
  - Time: O(n) | Space: O(1)
  - Logic: Two-pointer technique
  
- ✅ **SegregateEvenOddNumbers** - Separate even and odd numbers
  - Time: O(n) | Space: O(1)
  
- ✅ **SeggregateZerosOnesTwos** - Sort array with 0s, 1s, 2s
  - Time: O(n) | Space: O(1)
  - Logic: Dutch National Flag algorithm
  
- ✅ **SortZeroOnes** - Binary array sorting
  - Time: O(n) | Space: O(1)

#### Array Search & Analysis
- ✅ **Largest_Smallest_Number** - Find max and min
  - Time: O(n) | Space: O(1)
  
- ✅ **Second_Largest_Smallest** - Find 2nd max and min
  - Time: O(n) | Space: O(1)
  
- ✅ **Local_Maxima** - Find local maximum elements
  - Time: O(n) | Space: O(1)
  
- ✅ **SearchInAlmostSortedArray** - Search in nearly sorted array
  - Time: O(log n) | Space: O(1)
  - Similar to binary search with modifications

#### Advanced Array Problems
- ✅ **TwoPointers** - Merge sorted arrays, container with water
  - Time: O(n) | Space: O(1)
  
- ✅ **TrappingRainWater** - Water trapped between elevation
  - Time: O(n) | Space: O(n)
  - Logic: Prefix max + suffix max approach
  
- ✅ **StockBuySell** - Maximum profit from buying/selling
  - Time: O(n) | Space: O(1)
  - Logic: Track min price, calculate max profit
  
- ✅ **MatrixDiagonalSum** - Sum of matrix diagonals
  - Time: O(n²) | Space: O(1)
  
- ✅ **NumberCounts** - Count occurrences
  - Time: O(n) | Space: O(n)
  
- ✅ **PrintAlternateElement** - Print every alternate element
  - Time: O(n) | Space: O(1)
  
- ✅ **Pyramid** - Print pyramid pattern
  - Time: O(n²) | Space: O(1)
  
- ✅ **MergeStrings** - Merge two strings alternately
  - Time: O(n+m) | Space: O(1)

---

### 2️⃣ LINKED LISTS
**Complexity:** O(n) access, O(1) insert/delete (if position known)
**Use Cases:** Dynamic size, efficient insertions

#### Basic Implementation
- ✅ **LinkNode** - Node structure definition
- ✅ **LinkedList** - Basic linked list operations
- ✅ **LinkedListTest** - Test cases
- ✅ **SinglyLinkedList** - Singly linked list
- ✅ **SinglyLinkedListImpl** - Full implementation
- ✅ **DoublyLinkedListNode** - Node for doubly linked list

#### Linked List Algorithms
- ✅ **ReverseLinkedList** - Reverse entire linked list
  - Time: O(n) | Space: O(1)
  - Logic: Iterative or recursive approach
  
- ✅ **ReverseDoublyLinkedList** - Reverse doubly linked list
  - Time: O(n) | Space: O(1)
  
- ✅ **LinkedListCycle** - Detect cycle in linked list
  - Time: O(n) | Space: O(1)
  - Logic: Floyd's tortoise and hare algorithm
  
- ✅ **MiddleOfLinkedList** - Find middle node
  - Time: O(n) | Space: O(1)
  - Logic: Slow and fast pointers
  
- ✅ **LinkedListKthElementFromEnd** - Find Kth node from end
  - Time: O(n) | Space: O(1)
  - Logic: Two-pointer technique
  
- ✅ **RemoveNthNodeFromEnd** - Remove node at position from end
  - Time: O(n) | Space: O(1)
  
- ✅ **RemoveDuplicates** - Remove duplicate nodes
  - Time: O(n) | Space: O(n)
  
- ✅ **GetNodeValue** - Extract node value
  - Time: O(n) | Space: O(1)
  
- ✅ **mergeSortedLinkedLists** - Merge two sorted lists
  - Time: O(n+m) | Space: O(1)

---

### 3️⃣ STACKS
**Complexity:** O(1) push/pop/peek
**Use Cases:** LIFO operations, undo/redo, expression parsing

- ✅ **BalancedParanthesis** - Check matching parentheses
  - Time: O(n) | Space: O(n)
  - Logic: Push opening, pop on closing bracket
  
- ✅ **EqualStacks** - Find height where 3 stacks are equal
  - Time: O(n) | Space: O(n)

---

### 4️⃣ QUEUES
**Complexity:** O(1) enqueue/dequeue
**Use Cases:** FIFO operations, BFS, level-order traversal

- ✅ **HitCounterUsingQueue** - Count hits in time window
  - Time: O(n) | Space: O(n)
  - Logic: Queue stores timestamps
  
- ✅ **LevelOrderTraversal** - Level-by-level tree traversal
  - Time: O(n) | Space: O(w) where w is max width
  - Logic: BFS with queue
  
- ✅ **ZigZagTraversal** - Alternate direction level traversal
  - Time: O(n) | Space: O(w)
  - Logic: Double-ended queue (deque)

---

### 5️⃣ HASH MAPS / HASH TABLES
**Complexity:** O(1) average case, O(n) worst case
**Use Cases:** Fast lookup, caching, duplicate detection

- ✅ **CustomHashMap** - Implement hash map from scratch
  - Time: O(1) avg | Space: O(n)
  - Logic: Hash function + collision handling
  
- ✅ **CustomHashMapTest** - Test cases

---

## 📈 LEVEL 2: TREE & GRAPH STRUCTURES

### 6️⃣ BINARY TREES
**Complexity:** O(log n) balanced, O(n) unbalanced
**Use Cases:** Sorted data, fast search, hierarchical data

#### Tree Basics
- ✅ **TreeNode** - Node structure
- ✅ **Tree** - Basic tree operations
- ✅ **BinaryTree** - Binary tree implementation
- ✅ **BinaryTreeBFS** - Breadth-first search
  - Time: O(n) | Space: O(w)
  
- ✅ **BinaryTreeDFS** - Depth-first search
  - Time: O(n) | Space: O(h)
  - Methods: Preorder, Inorder, Postorder

---

### 7️⃣ HEAPS
**Complexity:** O(log n) insert/delete, O(1) peek
**Use Cases:** Priority queue, top-k problems, median finding

- ✅ **LastStone** - Last stone weight (min heap simulation)
  - Time: O(n log n) | Space: O(n)
  
- ✅ **SmashStones** - Smash stones game
  - Time: O(n log n) | Space: O(n)
  
- ✅ **TopKFrequentElements** - Find K most frequent elements
  - Time: O(n log k) | Space: O(k)
  - Logic: Min heap of size k

---

## 🔄 LEVEL 3: ALGORITHM PATTERNS

### 8️⃣ SORTING ALGORITHMS
**Learn the fundamentals of comparison-based sorting**

- ✅ **BubbleSort** - Compare adjacent elements
  - Time: O(n²) | Space: O(1)
  - Best for: Small datasets, educational purpose
  
- ✅ **SelectionSort** - Select minimum repeatedly
  - Time: O(n²) | Space: O(1)
  - Best for: Small datasets
  
- ✅ **InsertionSort** - Insert into sorted portion
  - Time: O(n²) avg, O(n) best | Space: O(1)
  - Best for: Small data, nearly sorted arrays
  
- ✅ **MergeSort** - Divide and conquer merge
  - Time: O(n log n) | Space: O(n)
  - Stable sort, consistent performance

---

### 9️⃣ SLIDING WINDOW
**Pattern for solving subarray/substring problems**

- ✅ **LongestSubString** - Longest substring without repeating chars
  - Time: O(n) | Space: O(min(n, m))
  - Logic: Sliding window with HashMap
  
- ✅ **MaxSumSubArrayOfK** - Maximum sum of K consecutive elements
  - Time: O(n) | Space: O(1)
  - Logic: Maintain window sum
  
- ✅ **MaxSumOfKthElement** - Max sum of K elements
  - Time: O(n) | Space: O(1)
  
- ✅ **minSubArrayLen** - Minimum length subarray with sum ≥ target
  - Time: O(n) | Space: O(1)
  - Logic: Two-pointer sliding window

---

### 🔟 STRING ALGORITHMS
**String manipulation and pattern matching**

- ✅ **StringValidation** - Validate string properties
  - Time: O(n) | Space: O(1)
  
- ✅ **StringPermutation** - Check if strings are permutations
  - Time: O(n) | Space: O(1)
  - Logic: Character count comparison
  
- ✅ **StringRotation** - Check if one string is rotation of another
  - Time: O(n) | Space: O(n)
  - Logic: Concatenation trick
  
- ✅ **StringCompression** - Compress repeated characters
  - Time: O(n) | Space: O(n)
  - Example: "aaabbbcccc" → "a3b3c4"
  
- ✅ **LongetSubString** - Longest substring without repeating
  - Time: O(n) | Space: O(n)
  
- ✅ **SOSPatternString** - Pattern matching
  - Time: O(n*m) | Space: O(1)
  
- ✅ **SimpleTextEditor** - Text editor with undo
  - Time: O(n) per operation | Space: O(n)
  - Logic: Stack-based undo
  
- ✅ **WordWrap** - Format text to fit width
  - Time: O(n) | Space: O(n)

---

## 🎯 LEVEL 4: ADVANCED ALGORITHMS

### 1️⃣1️⃣ DYNAMIC PROGRAMMING
**Optimize recursive problems with memoization/tabulation**

- ✅ **Fibbonaci** - Classic DP problem (recursive)
  - Time: O(2ⁿ) without memoization
  - Time: O(n) with memoization
  
- ✅ **FibbonaciMemoization** - Optimized Fibonacci
  - Time: O(n) | Space: O(n)
  - Logic: Store computed results

---

### 1️⃣2️⃣ MATH & NUMBER PROBLEMS
**Mathematical problem-solving**

- ✅ **Factorial** - Calculate n!
  - Time: O(n) | Space: O(1)
  
- ✅ **Palindrome** - Check if number is palindrome
  - Time: O(log n) | Space: O(1)
  
- ✅ **ReverseInteger** - Reverse digits of integer
  - Time: O(log n) | Space: O(1)
  
- ✅ **RectangleArea** - Calculate area
  - Time: O(1) | Space: O(1)
  
- ✅ **OverlapRectangle** - Check if rectangles overlap
  - Time: O(1) | Space: O(1)
  
- ✅ **MaximizeProfit** - Maximize profit problem
  - Time: O(n) | Space: O(1)

---

### 1️⃣3️⃣ SPECIAL PROBLEMS

- ✅ **PoisonousPlant** - Eliminate poisonous plants
  - Time: O(n²) | Space: O(n)
  - Logic: Greedy approach with tracking

- ✅ **LRUCache** - Least Recently Used cache
  - Time: O(1) | Space: O(n)
  - Logic: HashMap + Doubly Linked List
  
- ✅ **LRUCacheUsingLinkedHashMap** - LRU using built-in
  - Time: O(1) | Space: O(n)
  - Built-in LinkedHashMap with access-order
  
- ✅ **LRUCacheTest** - LRU test cases

---

### 1️⃣4️⃣ STREAMS & FUNCTIONAL PROGRAMMING

- ✅ **StreamExample** - Java 8 Stream API usage
  - Operations: map, filter, reduce, collect
  - Use cases: Functional data transformations

---

## 🗺️ STUDY ROADMAP (Recommended Order)

### Phase 1: FOUNDATIONS (Week 1-2)
1. Arrays → BinarySearch, TwoSum, Largest/Smallest
2. Linked Lists → ReverseLinkedList, MiddleOfLinkedList
3. Stacks → BalancedParanthesis
4. Queues → Basic operations

### Phase 2: CORE PATTERNS (Week 3-4)
1. Sorting → Understand all 4 algorithms
2. Two Pointers → Apply to array problems
3. Sliding Window → Substring/subarray problems
4. Hash Maps → Duplicate detection, frequency counting

### Phase 3: TREE & HEAP (Week 5-6)
1. Tree Traversals → BFS, DFS (inorder, preorder, postorder)
2. Binary Tree Problems
3. Heaps → Priority queue, top-k
4. Level Order, ZigZag Traversals

### Phase 4: ADVANCED (Week 7-8)
1. Dynamic Programming → Fibonacci, LRU Cache
2. String Algorithms → Compression, Rotation, Permutation
3. Math Problems
4. Special Problems (Poisonous Plant, etc.)

---

## 💡 KEY CONCEPTS CHEAT SHEET

### Algorithm Techniques
| Technique | Best For | Time Complexity |
|-----------|----------|-----------------|
| **Sorting** | Pre-processing data | O(n log n) |
| **Binary Search** | Sorted data lookup | O(log n) |
| **Two Pointers** | Arrays/Linked Lists | O(n) |
| **Sliding Window** | Subarray/Substring | O(n) |
| **Hash Map** | Frequency/Lookup | O(1) avg |
| **DFS** | Tree/Graph traversal | O(n) |
| **BFS** | Level-order traversal | O(n) |
| **Heap** | Top-K problems | O(n log k) |
| **DP** | Optimization problems | O(n) to O(n³) |

### Data Structure Properties
| Structure | Access | Search | Insert | Delete | Space |
|-----------|--------|--------|--------|--------|-------|
| **Array** | O(1) | O(n) | O(n) | O(n) | O(n) |
| **Linked List** | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| **Stack** | O(n) | O(n) | O(1) | O(1) | O(n) |
| **Queue** | O(n) | O(n) | O(1) | O(1) | O(n) |
| **Hash Map** | - | O(1)* | O(1)* | O(1)* | O(n) |
| **Heap** | O(1) | O(n) | O(log n) | O(log n) | O(n) |
| **BST** | O(log n)* | O(log n)* | O(log n)* | O(log n)* | O(n) |

*with known position or balanced structure

---

## 🎓 IMPORTANT PATTERNS & TECHNIQUES

### 1. Two Pointer Technique
Used for: Pair finding, reversing, merging
Examples: TwoSum, ThreeSum, ReverseLinkedList, MiddleOfLinkedList

### 2. Sliding Window
Used for: Subarray/substring problems
Examples: LongestSubString, MaxSumSubArrayOfK, minSubArrayLen

### 3. Fast & Slow Pointers
Used for: Cycle detection, middle finding
Examples: LinkedListCycle, MiddleOfLinkedList

### 4. Stack-based Problems
Used for: Expression parsing, undo operations, matching
Examples: BalancedParanthesis, SimpleTextEditor

### 5. DFS vs BFS
- **DFS**: Uses stack, good for depth exploration, backtracking
- **BFS**: Uses queue, good for level-order, shortest path

### 6. Divide & Conquer
Used for: Sorting, searching, optimization
Examples: BinarySearch, MergeSort

### 7. Greedy Algorithm
Used for: Optimization when local choice = global optimum
Examples: PoisonousPlant, StockBuySell, MaximizeProfit

### 8. Dynamic Programming
Used for: Optimization with overlapping subproblems
Examples: Fibonacci, LRUCache

---

## 📋 PROBLEM COMPLEXITY REFERENCE

### Easy (O(n) to O(n log n))
- BinarySearch
- TwoSum
- ReverseLinkedList
- MiddleOfLinkedList
- BalancedParanthesis
- Sorting Algorithms
- Palindrome

### Medium (O(n²) or optimized approaches)
- ThreeSum, FourSum
- RotateArray
- LinkedListCycle
- StockBuySell
- TrappingRainWater
- Sliding Window problems
- String problems

### Hard (O(n²) or complex logic)
- LRUCache
- TopKFrequentElements
- PoisonousPlant
- Multiple nested operations

---

## 🔗 DEPENDENCIES & RELATIONSHIPS

```
Mathematical Foundations
    ↓
Arrays (Basic)
    ↓
├─→ Searching (BinarySearch)
├─→ Sorting
├─→ Manipulation (Rotate, Move, Segregate)
    ↓
Linked Lists
    ├─→ Reversal
    ├─→ Cycle Detection
    └─→ Merging
    ↓
Stacks & Queues
    ├─→ Expression Parsing
    └─→ Tree Traversals (BFS, DFS)
    ↓
Trees & Heaps
    ├─→ Traversal Patterns
    └─→ Optimization (Top-K)
    ↓
Advanced Algorithms
    ├─→ Dynamic Programming
    ├─→ Optimization Techniques
    └─→ Complex Data Structure Combinations
```

---

## 📝 HOW TO USE THIS GUIDE

1. **Start with Level 1**: Master fundamental data structures
2. **Practice Each Category**: Implement solutions from scratch
3. **Understand Complexity**: Time and space trade-offs
4. **Recognize Patterns**: Identify which pattern to use
5. **Code and Test**: Practice with the Java implementations
6. **Optimize**: Apply different techniques for same problem
7. **Move to Level 4**: Advanced concepts build on foundations

---

## 🎯 PRACTICE STRATEGY

### Daily Practice (1-2 hours)
- Solve 1-2 new problems
- Review 2-3 previously solved problems
- Understand different approaches to same problem

### Weekly Review
- Revisit patterns learned
- Implement alternate solutions
- Increase optimization level

### Monthly Reinforcement
- Solve mix of all difficulty levels
- Time-boxed practice (45 min per problem)
- Explain solutions verbally

---

---

## 📚 COMPANION DOCUMENTS

This document is part of a comprehensive DSA learning ecosystem:

1. **DSA_COMPLETE_GUIDE.md** - Detailed concepts for each algorithm with full categorization
2. **DSA_QUICK_REFERENCE.md** - Quick lookup table with file paths and key insights
3. **DSA_STUDY_NOTES.md** - This file (overview and learning path)

---

**Last Updated:** February 2026
**Total Problems:** 84+
**Categories:** 14
**Difficulty Levels:** Beginner → Advanced
**Learning Documents:** 3 comprehensive guides
