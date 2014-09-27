Need-To-Do
==========


1. 很多recursive容易的算法也要考虑iterative方法。因为掌握iterative代表你对问
题结构理解上升了一个高度。e.g. reverse linked list， tree traversal

2. i) top k (kth) elements: heap O(n+klogn), quickselect O(n) average O(n^2)
worst, median of medians O(n) worst. cons and pros.
Extension: what if all data can not fit into memory. heap size of k O(nlogk)
for single machine, many machines see 3.
ii) get median in data stream: max heap + min heap

3. kth element in many m machines: binary search, pick a pivot and see how 
many less and larger among all machines, then discard halves accordingly (
distributed quickselect)

if sorted in single machine: find smallest (k/m)th element among all 
machines and discard the less partition.

4. stack support O(1) getMin
   queue support O(1) getMin
e.g. k sliding window, most frequently clicked url in past 12 months.

5. reservoir sampling for infinite stream, generate random(1-7) with random(
1-5), card shuffle, string permute in place

6. data structure with O(1) insert, delete, getRandom, get: hashmap + array

LRU data structure: hashmap + doublelikedlist.

binary search tree with rank() (position of inserted or queried data)
(add treesize attribute for each node)

7. bit operation and bitset.
e.g. find missing number in large data, reverse binary number, 

8. java multi-threading, blocking queue, nonblocking queue, H20, philosophy 
dining, deadlock checking. 现在是个公司都问concurrency，一定要好好准备。

9. OOP: elevator design, parking lot design
distributed: large log file design, social network design, distributed cache
design ....
