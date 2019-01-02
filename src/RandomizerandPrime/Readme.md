### Requirements
You are to create two small applications for this programming task; one is called Randomizer, the other Prime
Randomizer‘s job is to generate a series of positive random integers and send those to Prime via a distributed queue of integers.       
Primes job is to receive the integers and calculate whether the integer is a prime or not and return the answer to Randomizer via a distributed queue (just a java Queue implementation, no need to implement JMS etc) that contains the original number and a Boolean; which Randomizer will print to system out.

#### Points
1. Use only the standard java library
2. Both Applications will run on the same server
3. The system should be as fast as possible
4. The results do not have to be returned in the same order as received
5. You don’t have to go overboard tweaking the prime check
6. You need to have detail comment in your code to demonstrate your thought process (why certainly implementation is chosen, any limitation of your approach, etc.)
