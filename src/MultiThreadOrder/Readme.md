### Task Description
Create 10 orders asynchronously, maintain a Queue with max size 5, offer these 10 orders synchronously. Each order offered and polled from the queue will be marked as Fulfilled.

### Implementation
**Order.java**: An object class of order, containing an Enum of states with New and Fulfilled. Every order created by default will have new state.

**Worker.java**: Maintains a FIFO Queue with fixed size = 5. Two thread instance can be created from Worker, create and fulfill. Create thread will create 1 order with New state, Fulfill thread will use ReentrantLock to lock the write operation.

**Test.java**: Main method. Create orders asynchronously using while loop and fulfill synchronously using Thread pool.