# CRC Cards Explanation

TaskManager collaborates with Task because its responsibilities include storing, retrieving, and filtering Task objects. In order to perform these operations, TaskManager must interact directly with Task instances.

On the other hand, Task does not collaborate with TaskManager because its responsibilities are limited to storing its own data and managing its own status. It operates independently and does not need to be aware of how tasks are stored or managed at a higher level.
