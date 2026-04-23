## Part 1:
Shared Resource #1: "nextId" – a shared counter used by all threads to generate request IDs.
Shared Resource #2: "requests" – the shared ArrayList where all request strings are stored.

Concurrency Problem: Race condition – multiple threads can access and modify the resources "nextId" and "requests" at the same time, and that will lead to possible duplicate values and inconsistent data.

Why addRequest() is unsafe: it's unsafe because it performs non-atomic operations on shared resources even though race conditions may occur. Without the process being synchronized, the getNextId() method can return duplicate IDs when accessed concurrently. The function requests.add() is also not thread-safe, which can lead to data corruption or lost entries when multiple threads modify the list simultaneously.

---

## Part 2:
Fix A: Not correct because requests.add() is still unsafe. The nextId variable is protected but not the requests.add() function therefore it's not a complete fix.

Fix B: Correct. The entire addRequest() function is protected. Only one thread can access the function, hence we can avoid race conditions from existing, which solves the problem.

Fix C: Not correct. This only synchronizes access when returning the list. It does not protect nextId or requests.add() inside addRequest(). It's not helpful at all.

---

## Part 3:
No. According to Arthur Riel's heuristics, a class should hide its internal data and implementation details. The nextId counter is an internal mechanism that should only be used within the class. Making it public will break the rule of encapsulation, and makes the system vulnerable to various attacks.

---

## Part 4:
Description: using locks instead of synchronization. Because our problem is race conditions, locking the resource and then freeing the resources after we are done executing what we have to do, guarantees that we won't have duplicate values. Locks are used as a solution to race conditions because they guarantee only one thread has access to the resources. 

Code Snippet:

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

private final Lock lock = new ReentrantLock();

public void addRequest(String studentName) {

    lock.lock();
    
    try {
    
        int id = getNextId();
        
        requests.add("Request-" + id + " from " + studentName);
        
    } finally {
    
        lock.unlock();
        
    }
    
}
